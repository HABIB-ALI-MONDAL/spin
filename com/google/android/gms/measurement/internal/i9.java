package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.i1;

final class i9 implements Runnable {
    final /* synthetic */ i1 j;
    final /* synthetic */ String k;
    final /* synthetic */ String l;
    final /* synthetic */ boolean m;
    final /* synthetic */ AppMeasurementDynamiteService n;

    i9(AppMeasurementDynamiteService appMeasurementDynamiteService, i1 i1Var, String str, String str2, boolean z) {
        this.n = appMeasurementDynamiteService;
        this.j = i1Var;
        this.k = str;
        this.l = str2;
        this.m = z;
    }

    public final void run() {
        this.n.f2300a.L().V(this.j, this.k, this.l, this.m);
    }
}
