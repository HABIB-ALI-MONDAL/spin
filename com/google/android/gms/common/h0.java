package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class h0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        boolean z = false;
        String str = null;
        IBinder iBinder = null;
        boolean z2 = false;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i = b.i(n);
            if (i == 1) {
                str = b.d(parcel, n);
            } else if (i == 2) {
                iBinder = b.o(parcel, n);
            } else if (i == 3) {
                z = b.j(parcel, n);
            } else if (i != 4) {
                b.t(parcel, n);
            } else {
                z2 = b.j(parcel, n);
            }
        }
        b.h(parcel, u);
        return new g0(str, iBinder, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new g0[i];
    }
}
