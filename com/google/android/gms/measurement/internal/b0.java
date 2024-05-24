package com.google.android.gms.measurement.internal;

final class b0 implements Runnable {
    final /* synthetic */ String j;
    final /* synthetic */ long k;
    final /* synthetic */ d2 l;

    b0(d2 d2Var, String str, long j2) {
        this.l = d2Var;
        this.j = str;
        this.k = j2;
    }

    public final void run() {
        d2.j(this.l, this.j, this.k);
    }
}
