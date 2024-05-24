package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class m0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        IBinder iBinder = null;
        com.google.android.gms.common.b bVar = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i2 = b.i(n);
            if (i2 == 1) {
                i = b.p(parcel, n);
            } else if (i2 == 2) {
                iBinder = b.o(parcel, n);
            } else if (i2 == 3) {
                bVar = (com.google.android.gms.common.b) b.c(parcel, n, com.google.android.gms.common.b.CREATOR);
            } else if (i2 == 4) {
                z = b.j(parcel, n);
            } else if (i2 != 5) {
                b.t(parcel, n);
            } else {
                z2 = b.j(parcel, n);
            }
        }
        b.h(parcel, u);
        return new l0(i, iBinder, bVar, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new l0[i];
    }
}
