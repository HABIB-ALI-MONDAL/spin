package com.google.android.gms.measurement.internal;

final class ja implements Runnable {
    final /* synthetic */ oa j;
    final /* synthetic */ AppMeasurementDynamiteService k;

    ja(AppMeasurementDynamiteService appMeasurementDynamiteService, oa oaVar) {
        this.k = appMeasurementDynamiteService;
        this.j = oaVar;
    }

    public final void run() {
        this.k.f2300a.I().H(this.j);
    }
}
