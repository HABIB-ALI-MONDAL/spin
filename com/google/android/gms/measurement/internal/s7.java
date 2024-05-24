package com.google.android.gms.measurement.internal;

final class s7 implements Runnable {
    final /* synthetic */ m7 j;
    final /* synthetic */ long k;
    final /* synthetic */ u7 l;

    s7(u7 u7Var, m7 m7Var, long j2) {
        this.l = u7Var;
        this.j = m7Var;
        this.k = j2;
    }

    public final void run() {
        this.l.p(this.j, false, this.k);
        u7 u7Var = this.l;
        u7Var.f2565e = null;
        u7Var.f2527a.L().u((m7) null);
    }
}
