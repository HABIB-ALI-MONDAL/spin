package com.google.android.gms.common.internal.w;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.d.a.b.e.b.c;
import com.google.android.gms.common.internal.r;

public final class a extends c.d.a.b.e.b.a implements IInterface {
    a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void b0(r rVar) {
        Parcel h = h();
        c.c(h, rVar);
        k(1, h);
    }
}
