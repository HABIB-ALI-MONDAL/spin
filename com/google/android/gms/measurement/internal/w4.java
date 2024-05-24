package com.google.android.gms.measurement.internal;

final class w4 implements Runnable {
    final /* synthetic */ b6 j;
    final /* synthetic */ x4 k;

    w4(x4 x4Var, b6 b6Var) {
        this.k = x4Var;
        this.j = b6Var;
    }

    public final void run() {
        x4.b(this.k, this.j);
        this.k.m(this.j.g);
    }
}
