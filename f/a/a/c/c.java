package f.a.a.c;

import android.content.Context;
import android.text.TextUtils;
import f.a.a.c.b;
import f.a.a.c.d;
import f.a.a.d.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private d f3088a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<h> f3089b;

    /* renamed from: c  reason: collision with root package name */
    private b.a f3090c;

    class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f3091a;

        a(h hVar) {
            this.f3091a = hVar;
        }

        public void a(String str, String str2) {
            c.this.d(this.f3091a, false, str2);
        }

        public void b(String str) {
            this.f3091a.f(str);
            c.this.d(this.f3091a, true, new String[0]);
        }
    }

    private c(Context context, a aVar, ArrayList<h> arrayList, b.a aVar2) {
        this.f3088a = new d(context, aVar);
        this.f3089b = arrayList;
        this.f3090c = aVar2;
    }

    private void c(h hVar) {
        if (TextUtils.isEmpty(hVar.b())) {
            d(hVar, false, new String[0]);
            return;
        }
        File file = new File(hVar.b());
        if (!file.exists() || !file.isFile()) {
            d(hVar, false, new String[0]);
        } else {
            this.f3088a.d(hVar.b(), new a(hVar));
        }
    }

    /* access modifiers changed from: private */
    public void d(h hVar, boolean z, String... strArr) {
        hVar.g(z);
        int indexOf = this.f3089b.indexOf(hVar);
        if (indexOf == this.f3089b.size() - 1) {
            e(strArr);
        } else {
            c(this.f3089b.get(indexOf + 1));
        }
    }

    private void e(String... strArr) {
        if (strArr.length > 0) {
            this.f3090c.b(this.f3089b, strArr[0]);
            return;
        }
        Iterator<h> it = this.f3089b.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (!next.c()) {
                b.a aVar = this.f3090c;
                ArrayList<h> arrayList = this.f3089b;
                aVar.b(arrayList, next.a() + " is compress failures");
                return;
            }
        }
        this.f3090c.a(this.f3089b);
    }

    public static b f(Context context, a aVar, ArrayList<h> arrayList, b.a aVar2) {
        return aVar.b() != null ? new e(context, aVar, arrayList, aVar2) : new c(context, aVar, arrayList, aVar2);
    }

    public void a() {
        ArrayList<h> arrayList = this.f3089b;
        if (arrayList == null || arrayList.isEmpty()) {
            this.f3090c.b(this.f3089b, " images is null");
        }
        Iterator<h> it = this.f3089b.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                this.f3090c.b(this.f3089b, " There are pictures of compress  is null.");
                return;
            }
        }
        c(this.f3089b.get(0));
    }
}
