package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final /* synthetic */ class e9 implements Runnable {
    public final /* synthetic */ f9 j;

    public /* synthetic */ e9(f9 f9Var) {
        this.j = f9Var;
    }

    public final void run() {
        f9 f9Var = this.j;
        g9 g9Var = f9Var.l;
        long j2 = f9Var.j;
        long j3 = f9Var.k;
        g9Var.f2385b.h();
        g9Var.f2385b.f2527a.f().q().a("Application going to the background");
        g9Var.f2385b.f2527a.F().r.a(true);
        Bundle bundle = new Bundle();
        if (!g9Var.f2385b.f2527a.z().D()) {
            g9Var.f2385b.f2453e.b(j3);
            g9Var.f2385b.f2453e.d(false, false, j3);
        }
        g9Var.f2385b.f2527a.I().v("auto", "_ab", j2, bundle);
    }
}
