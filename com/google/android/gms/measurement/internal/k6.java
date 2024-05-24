package com.google.android.gms.measurement.internal;

final class k6 implements Runnable {
    final /* synthetic */ String j;
    final /* synthetic */ String k;
    final /* synthetic */ Object l;
    final /* synthetic */ long m;
    final /* synthetic */ e7 n;

    k6(e7 e7Var, String str, String str2, Object obj, long j2) {
        this.n = e7Var;
        this.j = str;
        this.k = str2;
        this.l = obj;
        this.m = j2;
    }

    public final void run() {
        this.n.M(this.j, this.k, this.l, this.m);
    }
}
