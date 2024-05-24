package com.google.android.gms.measurement.internal;

final class a implements Runnable {
    final /* synthetic */ String j;
    final /* synthetic */ long k;
    final /* synthetic */ d2 l;

    a(d2 d2Var, String str, long j2) {
        this.l = d2Var;
        this.j = str;
        this.k = j2;
    }

    public final void run() {
        d2.i(this.l, this.j, this.k);
    }
}
