package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class q implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i2 = b.i(n);
            if (i2 == 1) {
                str = b.d(parcel, n);
            } else if (i2 == 2) {
                i = b.p(parcel, n);
            } else if (i2 != 3) {
                b.t(parcel, n);
            } else {
                j = b.q(parcel, n);
            }
        }
        b.h(parcel, u);
        return new d(str, i, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new d[i];
    }
}
