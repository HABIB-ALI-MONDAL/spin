package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

final class r8 implements Runnable {
    final /* synthetic */ t8 j;

    r8(t8 t8Var) {
        this.j = t8Var;
    }

    public final void run() {
        u8 u8Var = this.j.f2551c;
        Context d2 = u8Var.f2527a.d();
        this.j.f2551c.f2527a.e();
        u8.M(u8Var, new ComponentName(d2, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
