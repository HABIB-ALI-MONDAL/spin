package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class p implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        PendingIntent pendingIntent = null;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i3 = b.i(n);
            if (i3 == 1) {
                i = b.p(parcel, n);
            } else if (i3 == 2) {
                i2 = b.p(parcel, n);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) b.c(parcel, n, PendingIntent.CREATOR);
            } else if (i3 != 4) {
                b.t(parcel, n);
            } else {
                str = b.d(parcel, n);
            }
        }
        b.h(parcel, u);
        return new b(i, i2, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
