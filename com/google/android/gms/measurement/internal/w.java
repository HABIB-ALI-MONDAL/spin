package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class w implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            if (b.i(n) != 2) {
                b.t(parcel, n);
            } else {
                bundle = b.a(parcel, n);
            }
        }
        b.h(parcel, u);
        return new v(bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new v[i];
    }
}
