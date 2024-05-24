package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import c.d.a.b.d.b;
import com.google.android.gms.common.internal.q1;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;
import javax.annotation.Nullable;

public final class g0 extends a {
    public static final Parcelable.Creator<g0> CREATOR = new h0();
    private final String j;
    @Nullable
    private final x k;
    private final boolean l;
    private final boolean m;

    g0(String str, @Nullable IBinder iBinder, boolean z, boolean z2) {
        this.j = str;
        y yVar = null;
        if (iBinder != null) {
            try {
                c.d.a.b.d.a d2 = q1.i(iBinder).d();
                byte[] bArr = d2 == null ? null : (byte[]) b.k(d2);
                if (bArr != null) {
                    yVar = new y(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e2) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e2);
            }
        }
        this.k = yVar;
        this.l = z;
        this.m = z2;
    }

    g0(String str, @Nullable x xVar, boolean z, boolean z2) {
        this.j = str;
        this.k = xVar;
        this.l = z;
        this.m = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.n(parcel, 1, this.j, false);
        x xVar = this.k;
        if (xVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            xVar = null;
        }
        c.h(parcel, 2, xVar, false);
        c.c(parcel, 3, this.l);
        c.c(parcel, 4, this.m);
        c.b(parcel, a2);
    }
}
