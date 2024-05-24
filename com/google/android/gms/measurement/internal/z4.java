package com.google.android.gms.measurement.internal;

final class z4 implements Runnable {
    final /* synthetic */ d j;
    final /* synthetic */ qa k;
    final /* synthetic */ q5 l;

    z4(q5 q5Var, d dVar, qa qaVar) {
        this.l = q5Var;
        this.j = dVar;
        this.k = qaVar;
    }

    public final void run() {
        this.l.f2514a.b();
        if (this.j.l.g() == null) {
            this.l.f2514a.t(this.j, this.k);
        } else {
            this.l.f2514a.z(this.j, this.k);
        }
    }
}
