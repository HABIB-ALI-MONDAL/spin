package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import c.d.a.b.e.d.a;
import c.d.a.b.e.d.c;
import com.google.android.gms.common.c0;
import com.google.android.gms.common.e0;
import com.google.android.gms.common.g0;

public final class q0 extends a implements s0 {
    q0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final boolean E(g0 g0Var, c.d.a.b.d.a aVar) {
        Parcel i = i();
        c.d(i, g0Var);
        c.e(i, aVar);
        Parcel h = h(5, i);
        boolean f2 = c.f(h);
        h.recycle();
        return f2;
    }

    public final e0 K(c0 c0Var) {
        Parcel i = i();
        c.d(i, c0Var);
        Parcel h = h(6, i);
        e0 e0Var = (e0) c.a(h, e0.CREATOR);
        h.recycle();
        return e0Var;
    }

    public final boolean g() {
        Parcel h = h(7, i());
        boolean f2 = c.f(h);
        h.recycle();
        return f2;
    }

    public final e0 o(c0 c0Var) {
        Parcel i = i();
        c.d(i, c0Var);
        Parcel h = h(8, i);
        e0 e0Var = (e0) c.a(h, e0.CREATOR);
        h.recycle();
        return e0Var;
    }
}
