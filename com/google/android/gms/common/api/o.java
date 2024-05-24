package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class o implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i2 = b.i(n);
            if (i2 == 1) {
                i = b.p(parcel, n);
            } else if (i2 != 2) {
                b.t(parcel, n);
            } else {
                str = b.d(parcel, n);
            }
        }
        b.h(parcel, u);
        return new Scope(i, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Scope[i];
    }
}
