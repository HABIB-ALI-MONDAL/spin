package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import c.d.a.b.e.e.k1;

final class oa implements y5 {

    /* renamed from: a  reason: collision with root package name */
    public final k1 f2496a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f2497b;

    oa(AppMeasurementDynamiteService appMeasurementDynamiteService, k1 k1Var) {
        this.f2497b = appMeasurementDynamiteService;
        this.f2496a = k1Var;
    }

    public final void a(String str, String str2, Bundle bundle, long j) {
        try {
            this.f2496a.p(str, str2, bundle, j);
        } catch (RemoteException e2) {
            x4 x4Var = this.f2497b.f2300a;
            if (x4Var != null) {
                x4Var.f().w().b("Event interceptor threw exception", e2);
            }
        }
    }
}
