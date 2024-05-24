package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.i1;

final class h8 implements Runnable {
    final /* synthetic */ i1 j;
    final /* synthetic */ x k;
    final /* synthetic */ String l;
    final /* synthetic */ AppMeasurementDynamiteService m;

    h8(AppMeasurementDynamiteService appMeasurementDynamiteService, i1 i1Var, x xVar, String str) {
        this.m = appMeasurementDynamiteService;
        this.j = i1Var;
        this.k = xVar;
        this.l = str;
    }

    public final void run() {
        this.m.f2300a.L().p(this.j, this.k, this.l);
    }
}
