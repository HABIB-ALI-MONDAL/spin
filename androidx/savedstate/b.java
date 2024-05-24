package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.d;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final c f449a;

    /* renamed from: b  reason: collision with root package name */
    private final SavedStateRegistry f450b = new SavedStateRegistry();

    private b(c cVar) {
        this.f449a = cVar;
    }

    public static b a(c cVar) {
        return new b(cVar);
    }

    public SavedStateRegistry b() {
        return this.f450b;
    }

    public void c(Bundle bundle) {
        d a2 = this.f449a.a();
        if (a2.b() == d.c.INITIALIZED) {
            a2.a(new Recreator(this.f449a));
            this.f450b.b(a2, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void d(Bundle bundle) {
        this.f450b.c(bundle);
    }
}
