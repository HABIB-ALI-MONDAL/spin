package com.google.android.gms.common.internal.w;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import c.d.a.b.e.b.f;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.u;

public final class e extends g {
    private final u A;

    public e(Context context, Looper looper, d dVar, u uVar, com.google.android.gms.common.api.internal.d dVar2, j jVar) {
        super(context, looper, 270, dVar, dVar2, jVar);
        this.A = uVar;
    }

    /* access modifiers changed from: protected */
    public final Bundle A() {
        return this.A.d();
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    /* access modifiers changed from: protected */
    public final boolean I() {
        return true;
    }

    public final int p() {
        return 203400000;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return queryLocalInterface instanceof a ? (a) queryLocalInterface : new a(iBinder);
    }

    public final com.google.android.gms.common.d[] v() {
        return f.f1560b;
    }
}
