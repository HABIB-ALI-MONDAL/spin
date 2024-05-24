package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.v.b;

public final class d1 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        Bundle bundle = null;
        d[] dVarArr = null;
        e eVar = null;
        int i = 0;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i2 = b.i(n);
            if (i2 == 1) {
                bundle = b.a(parcel, n);
            } else if (i2 == 2) {
                dVarArr = (d[]) b.f(parcel, n, d.CREATOR);
            } else if (i2 == 3) {
                i = b.p(parcel, n);
            } else if (i2 != 4) {
                b.t(parcel, n);
            } else {
                eVar = (e) b.c(parcel, n, e.CREATOR);
            }
        }
        b.h(parcel, u);
        return new c1(bundle, dVarArr, i, eVar);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new c1[i];
    }
}
