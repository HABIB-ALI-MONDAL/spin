package com.google.android.gms.measurement.internal;

final class j5 implements Runnable {
    final /* synthetic */ x j;
    final /* synthetic */ qa k;
    final /* synthetic */ q5 l;

    j5(q5 q5Var, x xVar, qa qaVar) {
        this.l = q5Var;
        this.j = xVar;
        this.k = qaVar;
    }

    public final void run() {
        this.l.c0(this.l.k(this.j, this.k), this.k);
    }
}
