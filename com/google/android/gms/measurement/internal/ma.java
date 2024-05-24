package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.i1;

final class ma implements Runnable {
    final /* synthetic */ i1 j;
    final /* synthetic */ String k;
    final /* synthetic */ String l;
    final /* synthetic */ AppMeasurementDynamiteService m;

    ma(AppMeasurementDynamiteService appMeasurementDynamiteService, i1 i1Var, String str, String str2) {
        this.m = appMeasurementDynamiteService;
        this.j = i1Var;
        this.k = str;
        this.l = str2;
    }

    public final void run() {
        this.m.f2300a.L().T(this.j, this.k, this.l);
    }
}
