package com.google.android.gms.measurement.internal;

final class o8 implements Runnable {
    final /* synthetic */ b3 j;
    final /* synthetic */ t8 k;

    o8(t8 t8Var, b3 b3Var) {
        this.k = t8Var;
        this.j = b3Var;
    }

    public final void run() {
        synchronized (this.k) {
            this.k.f2549a = false;
            if (!this.k.f2551c.z()) {
                this.k.f2551c.f2527a.f().v().a("Connected to service");
                this.k.f2551c.x(this.j);
            }
        }
    }
}
