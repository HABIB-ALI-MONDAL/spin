package com.google.android.gms.measurement.internal;

public final /* synthetic */ class f6 implements Runnable {
    public final /* synthetic */ e7 j;

    public /* synthetic */ f6(e7 e7Var) {
        this.j = e7Var;
    }

    public final void run() {
        e7 e7Var = this.j;
        e7Var.h();
        if (!e7Var.f2527a.F().s.b()) {
            long a2 = e7Var.f2527a.F().t.a();
            e7Var.f2527a.F().t.b(1 + a2);
            e7Var.f2527a.z();
            if (a2 >= 5) {
                e7Var.f2527a.f().w().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                e7Var.f2527a.F().s.a(true);
                return;
            }
            e7Var.f2527a.j();
            return;
        }
        e7Var.f2527a.f().q().a("Deferred Deep Link already retrieved. Not fetching again.");
    }
}
