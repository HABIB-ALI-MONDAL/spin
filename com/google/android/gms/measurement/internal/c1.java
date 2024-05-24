package com.google.android.gms.measurement.internal;

final class c1 implements Runnable {
    final /* synthetic */ long j;
    final /* synthetic */ d2 k;

    c1(d2 d2Var, long j2) {
        this.k = d2Var;
        this.j = j2;
    }

    public final void run() {
        this.k.q(this.j);
    }
}
