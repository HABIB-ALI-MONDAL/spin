package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class j6 implements Runnable {
    final /* synthetic */ String j;
    final /* synthetic */ String k;
    final /* synthetic */ long l;
    final /* synthetic */ Bundle m;
    final /* synthetic */ boolean n;
    final /* synthetic */ boolean o;
    final /* synthetic */ boolean p;
    final /* synthetic */ String q;
    final /* synthetic */ e7 r;

    j6(e7 e7Var, String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.r = e7Var;
        this.j = str;
        this.k = str2;
        this.l = j2;
        this.m = bundle;
        this.n = z;
        this.o = z2;
        this.p = z3;
        this.q = str3;
    }

    public final void run() {
        this.r.w(this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q);
    }
}
