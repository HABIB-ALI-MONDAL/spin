package com.google.android.gms.measurement.internal;

final class a5 implements Runnable {
    final /* synthetic */ d j;
    final /* synthetic */ q5 k;

    a5(q5 q5Var, d dVar) {
        this.k = q5Var;
        this.j = dVar;
    }

    public final void run() {
        this.k.f2514a.b();
        if (this.j.l.g() == null) {
            this.k.f2514a.s(this.j);
        } else {
            this.k.f2514a.y(this.j);
        }
    }
}
