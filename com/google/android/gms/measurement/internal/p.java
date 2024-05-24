package com.google.android.gms.measurement.internal;

final class p implements Runnable {
    final /* synthetic */ t5 j;
    final /* synthetic */ q k;

    p(q qVar, t5 t5Var) {
        this.k = qVar;
        this.j = t5Var;
    }

    public final void run() {
        this.j.e();
        if (c.a()) {
            this.j.c().z(this);
            return;
        }
        boolean e2 = this.k.e();
        this.k.f2510c = 0;
        if (e2) {
            this.k.c();
        }
    }
}
