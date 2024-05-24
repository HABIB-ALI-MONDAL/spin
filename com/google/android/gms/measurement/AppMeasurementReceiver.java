package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import b.i.a.a;
import com.google.android.gms.measurement.internal.g4;
import com.google.android.gms.measurement.internal.h4;

public final class AppMeasurementReceiver extends a implements g4 {

    /* renamed from: c  reason: collision with root package name */
    private h4 f2295c;

    public void a(Context context, Intent intent) {
        a.c(context, intent);
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f2295c == null) {
            this.f2295c = new h4(this);
        }
        this.f2295c.a(context, intent);
    }
}
