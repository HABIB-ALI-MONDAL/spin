package com.google.android.gms.measurement.internal;

final class m5 implements Runnable {
    final /* synthetic */ fa j;
    final /* synthetic */ qa k;
    final /* synthetic */ q5 l;

    m5(q5 q5Var, fa faVar, qa qaVar) {
        this.l = q5Var;
        this.j = faVar;
        this.k = qaVar;
    }

    public final void run() {
        this.l.f2514a.b();
        if (this.j.g() == null) {
            this.l.f2514a.u(this.j, this.k);
        } else {
            this.l.f2514a.B(this.j, this.k);
        }
    }
}
