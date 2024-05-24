package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class p implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        com.google.android.gms.common.b bVar = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i3 = b.i(n);
            if (i3 == 1) {
                i2 = b.p(parcel, n);
            } else if (i3 == 2) {
                str = b.d(parcel, n);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) b.c(parcel, n, PendingIntent.CREATOR);
            } else if (i3 == 4) {
                bVar = (com.google.android.gms.common.b) b.c(parcel, n, com.google.android.gms.common.b.CREATOR);
            } else if (i3 != 1000) {
                b.t(parcel, n);
            } else {
                i = b.p(parcel, n);
            }
        }
        b.h(parcel, u);
        return new Status(i, i2, str, pendingIntent, bVar);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Status[i];
    }
}
