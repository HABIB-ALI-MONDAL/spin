package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class v0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i4 = b.i(n);
            if (i4 == 1) {
                i = b.p(parcel, n);
            } else if (i4 == 2) {
                z = b.j(parcel, n);
            } else if (i4 == 3) {
                z2 = b.j(parcel, n);
            } else if (i4 == 4) {
                i2 = b.p(parcel, n);
            } else if (i4 != 5) {
                b.t(parcel, n);
            } else {
                i3 = b.p(parcel, n);
            }
        }
        b.h(parcel, u);
        return new p(i, z, z2, i2, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new p[i];
    }
}
