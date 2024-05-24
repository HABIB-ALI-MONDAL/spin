package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import c.d.a.b.e.d.b;

public abstract class r0 extends b implements s0 {
    public static s0 i(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return queryLocalInterface instanceof s0 ? (s0) queryLocalInterface : new q0(iBinder);
    }
}
