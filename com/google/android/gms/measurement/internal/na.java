package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.i1;

final class na implements Runnable {
    final /* synthetic */ i1 j;
    final /* synthetic */ AppMeasurementDynamiteService k;

    na(AppMeasurementDynamiteService appMeasurementDynamiteService, i1 i1Var) {
        this.k = appMeasurementDynamiteService;
        this.j = i1Var;
    }

    public final void run() {
        this.k.f2300a.N().D(this.j, this.k.f2300a.n());
    }
}
