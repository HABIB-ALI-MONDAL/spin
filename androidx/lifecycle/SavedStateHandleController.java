package androidx.lifecycle;

import androidx.lifecycle.d;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.c;

final class SavedStateHandleController implements e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f402a;

    /* renamed from: b  reason: collision with root package name */
    private final p f403b;

    /* renamed from: androidx.lifecycle.SavedStateHandleController$1  reason: invalid class name */
    class AnonymousClass1 implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f404a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SavedStateRegistry f405b;

        public void d(g gVar, d.b bVar) {
            if (bVar == d.b.ON_START) {
                this.f404a.c(this);
                this.f405b.e(a.class);
            }
        }
    }

    static final class a implements SavedStateRegistry.a {
        a() {
        }

        public void a(c cVar) {
            if (cVar instanceof t) {
                s g = ((t) cVar).g();
                SavedStateRegistry c2 = cVar.c();
                for (String b2 : g.c()) {
                    SavedStateHandleController.h(g.b(b2), c2, cVar.a());
                }
                if (!g.c().isEmpty()) {
                    c2.e(a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    static void h(q qVar, SavedStateRegistry savedStateRegistry, d dVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) qVar.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.j()) {
            savedStateHandleController.i(savedStateRegistry, dVar);
            throw null;
        }
    }

    public void d(g gVar, d.b bVar) {
        if (bVar == d.b.ON_DESTROY) {
            this.f402a = false;
            gVar.a().c(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(SavedStateRegistry savedStateRegistry, d dVar) {
        if (this.f402a) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f402a = true;
        dVar.a(this);
        this.f403b.a();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.f402a;
    }
}
