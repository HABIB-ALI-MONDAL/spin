package com.google.android.gms.measurement.internal;

final class d9 implements Runnable {
    final /* synthetic */ long j;
    final /* synthetic */ l9 k;

    d9(l9 l9Var, long j2) {
        this.k = l9Var;
        this.j = j2;
    }

    public final void run() {
        l9.q(this.k, this.j);
    }
}
