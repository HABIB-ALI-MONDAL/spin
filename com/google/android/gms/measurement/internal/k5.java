package com.google.android.gms.measurement.internal;

final class k5 implements Runnable {
    final /* synthetic */ x j;
    final /* synthetic */ String k;
    final /* synthetic */ q5 l;

    k5(q5 q5Var, x xVar, String str) {
        this.l = q5Var;
        this.j = xVar;
        this.k = str;
    }

    public final void run() {
        this.l.f2514a.b();
        this.l.f2514a.k(this.j, this.k);
    }
}
