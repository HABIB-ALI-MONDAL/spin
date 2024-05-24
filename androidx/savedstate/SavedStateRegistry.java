package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.savedstate.Recreator;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
public final class SavedStateRegistry {

    /* renamed from: a  reason: collision with root package name */
    private b.b.a.b.b<String, b> f442a = new b.b.a.b.b<>();

    /* renamed from: b  reason: collision with root package name */
    private Bundle f443b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f444c;

    /* renamed from: d  reason: collision with root package name */
    private Recreator.a f445d;

    /* renamed from: e  reason: collision with root package name */
    boolean f446e = true;

    public interface a {
        void a(c cVar);
    }

    public interface b {
        Bundle a();
    }

    SavedStateRegistry() {
    }

    public Bundle a(String str) {
        if (this.f444c) {
            Bundle bundle = this.f443b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f443b.remove(str);
            if (this.f443b.isEmpty()) {
                this.f443b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* access modifiers changed from: package-private */
    public void b(d dVar, Bundle bundle) {
        if (!this.f444c) {
            if (bundle != null) {
                this.f443b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            dVar.a(new e() {
                public void d(g gVar, d.b bVar) {
                    SavedStateRegistry savedStateRegistry;
                    boolean z;
                    if (bVar == d.b.ON_START) {
                        savedStateRegistry = SavedStateRegistry.this;
                        z = true;
                    } else if (bVar == d.b.ON_STOP) {
                        savedStateRegistry = SavedStateRegistry.this;
                        z = false;
                    } else {
                        return;
                    }
                    savedStateRegistry.f446e = z;
                }
            });
            this.f444c = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* access modifiers changed from: package-private */
    public void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f443b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        b.b.a.b.b<K, V>.d j = this.f442a.j();
        while (j.hasNext()) {
            Map.Entry entry = (Map.Entry) j.next();
            bundle2.putBundle((String) entry.getKey(), ((b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void d(String str, b bVar) {
        if (this.f442a.p(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e(Class<? extends a> cls) {
        if (this.f446e) {
            if (this.f445d == null) {
                this.f445d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                this.f445d.b(cls.getName());
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }
}
