package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;
import java.util.ArrayList;

public final class x implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        int i = 0;
        ArrayList<l> arrayList = null;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i2 = b.i(n);
            if (i2 == 1) {
                i = b.p(parcel, n);
            } else if (i2 != 2) {
                b.t(parcel, n);
            } else {
                arrayList = b.g(parcel, n, l.CREATOR);
            }
        }
        b.h(parcel, u);
        return new r(i, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new r[i];
    }
}
