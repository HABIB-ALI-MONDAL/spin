package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class o7 implements Runnable {
    final /* synthetic */ Bundle j;
    final /* synthetic */ m7 k;
    final /* synthetic */ m7 l;
    final /* synthetic */ long m;
    final /* synthetic */ u7 n;

    o7(u7 u7Var, Bundle bundle, m7 m7Var, m7 m7Var2, long j2) {
        this.n = u7Var;
        this.j = bundle;
        this.k = m7Var;
        this.l = m7Var2;
        this.m = j2;
    }

    public final void run() {
        u7.w(this.n, this.j, this.k, this.l, this.m);
    }
}
