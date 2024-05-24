package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;
import com.google.android.gms.common.internal.v.c;

public final class y implements Parcelable.Creator {
    static void a(x xVar, Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.n(parcel, 2, xVar.j, false);
        c.m(parcel, 3, xVar.k, i, false);
        c.n(parcel, 4, xVar.l, false);
        c.k(parcel, 5, xVar.m);
        c.b(parcel, a2);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        String str = null;
        v vVar = null;
        String str2 = null;
        long j = 0;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i = b.i(n);
            if (i == 2) {
                str = b.d(parcel, n);
            } else if (i == 3) {
                vVar = (v) b.c(parcel, n, v.CREATOR);
            } else if (i == 4) {
                str2 = b.d(parcel, n);
            } else if (i != 5) {
                b.t(parcel, n);
            } else {
                j = b.q(parcel, n);
            }
        }
        b.h(parcel, u);
        return new x(str, vVar, str2, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new x[i];
    }
}
