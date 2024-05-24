package com.google.android.gms.measurement.internal;

final class p5 implements Runnable {
    final /* synthetic */ String j;
    final /* synthetic */ String k;
    final /* synthetic */ String l;
    final /* synthetic */ long m;
    final /* synthetic */ q5 n;

    p5(q5 q5Var, String str, String str2, String str3, long j2) {
        this.n = q5Var;
        this.j = str;
        this.k = str2;
        this.l = str3;
        this.m = j2;
    }

    public final void run() {
        String str = this.j;
        if (str == null) {
            this.n.f2514a.w(this.k, (m7) null);
            return;
        }
        this.n.f2514a.w(this.k, new m7(this.l, str, this.m));
    }
}
