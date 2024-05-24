package com.google.android.gms.measurement.internal;

final class i6 implements Runnable {
    final /* synthetic */ long j;
    final /* synthetic */ e7 k;

    i6(e7 e7Var, long j2) {
        this.k = e7Var;
        this.j = j2;
    }

    public final void run() {
        this.k.f2527a.F().k.b(this.j);
        this.k.f2527a.f().q().b("Session timeout duration set", Long.valueOf(this.j));
    }
}
