package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private Random f44a = new Random();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, String> f45b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Integer> f46c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, b> f47d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<String> f48e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    final transient Map<String, a<?>> f49f = new HashMap();
    final Map<String, Object> g = new HashMap();
    final Bundle h = new Bundle();

    private static class a<O> {

        /* renamed from: a  reason: collision with root package name */
        final b<O> f50a;

        /* renamed from: b  reason: collision with root package name */
        final androidx.activity.result.d.a<?, O> f51b;

        a(b<O> bVar, androidx.activity.result.d.a<?, O> aVar) {
            this.f50a = bVar;
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final d f52a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<e> f53b;

        /* access modifiers changed from: package-private */
        public void a() {
            Iterator<e> it = this.f53b.iterator();
            while (it.hasNext()) {
                this.f52a.c(it.next());
            }
            this.f53b.clear();
        }
    }

    private void a(int i, String str) {
        this.f45b.put(Integer.valueOf(i), str);
        this.f46c.put(str, Integer.valueOf(i));
    }

    private <O> void c(String str, int i, Intent intent, a<O> aVar) {
        b<O> bVar;
        if (aVar == null || (bVar = aVar.f50a) == null) {
            this.g.remove(str);
            this.h.putParcelable(str, new a(i, intent));
            return;
        }
        bVar.a(aVar.f51b.a(i, intent));
    }

    public final boolean b(int i, int i2, Intent intent) {
        String str = this.f45b.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.f48e.remove(str);
        c(str, i2, intent, this.f49f.get(str));
        return true;
    }

    public final void d(Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                int size = stringArrayList.size();
                for (int i = 0; i < size; i++) {
                    a(integerArrayList.get(i).intValue(), stringArrayList.get(i));
                }
                this.f48e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.f44a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                this.h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
            }
        }
    }

    public final void e(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.f45b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.f45b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.f48e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f44a);
    }

    /* access modifiers changed from: package-private */
    public final void f(String str) {
        Integer remove;
        if (!this.f48e.contains(str) && (remove = this.f46c.remove(str)) != null) {
            this.f45b.remove(remove);
        }
        this.f49f.remove(str);
        if (this.g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.g.get(str));
            this.g.remove(str);
        }
        if (this.h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.h.getParcelable(str));
            this.h.remove(str);
        }
        b bVar = this.f47d.get(str);
        if (bVar != null) {
            bVar.a();
            this.f47d.remove(str);
        }
    }
}
