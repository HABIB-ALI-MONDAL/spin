package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class i0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int u = b.u(parcel);
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            switch (b.i(n)) {
                case 1:
                    i = b.p(parcel2, n);
                    break;
                case 2:
                    i2 = b.p(parcel2, n);
                    break;
                case 3:
                    i3 = b.p(parcel2, n);
                    break;
                case 4:
                    j = b.q(parcel2, n);
                    break;
                case 5:
                    j2 = b.q(parcel2, n);
                    break;
                case 6:
                    str = b.d(parcel2, n);
                    break;
                case 7:
                    str2 = b.d(parcel2, n);
                    break;
                case 8:
                    i4 = b.p(parcel2, n);
                    break;
                case 9:
                    i5 = b.p(parcel2, n);
                    break;
                default:
                    b.t(parcel2, n);
                    break;
            }
        }
        b.h(parcel2, u);
        return new l(i, i2, i3, j, j2, str, str2, i4, i5);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new l[i];
    }
}
