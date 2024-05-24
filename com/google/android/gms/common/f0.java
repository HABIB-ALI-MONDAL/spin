package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class f0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        boolean z = false;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i3 = b.i(n);
            if (i3 == 1) {
                z = b.j(parcel, n);
            } else if (i3 == 2) {
                str = b.d(parcel, n);
            } else if (i3 == 3) {
                i = b.p(parcel, n);
            } else if (i3 != 4) {
                b.t(parcel, n);
            } else {
                i2 = b.p(parcel, n);
            }
        }
        b.h(parcel, u);
        return new e0(z, str, i, i2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new e0[i];
    }
}
