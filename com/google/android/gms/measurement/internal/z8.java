package com.google.android.gms.measurement.internal;

final class z8 implements Runnable {
    final /* synthetic */ ca j;
    final /* synthetic */ Runnable k;

    z8(b9 b9Var, ca caVar, Runnable runnable) {
        this.j = caVar;
        this.k = runnable;
    }

    public final void run() {
        this.j.b();
        this.j.k0(this.k);
        this.j.C();
    }
}
