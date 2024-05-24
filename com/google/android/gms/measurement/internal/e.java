package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class e implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int u = b.u(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        fa faVar = null;
        String str3 = null;
        x xVar = null;
        x xVar2 = null;
        x xVar3 = null;
        boolean z = false;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            switch (b.i(n)) {
                case 2:
                    str = b.d(parcel2, n);
                    break;
                case 3:
                    str2 = b.d(parcel2, n);
                    break;
                case 4:
                    faVar = (fa) b.c(parcel2, n, fa.CREATOR);
                    break;
                case 5:
                    j = b.q(parcel2, n);
                    break;
                case 6:
                    z = b.j(parcel2, n);
                    break;
                case 7:
                    str3 = b.d(parcel2, n);
                    break;
                case 8:
                    xVar = (x) b.c(parcel2, n, x.CREATOR);
                    break;
                case 9:
                    j2 = b.q(parcel2, n);
                    break;
                case 10:
                    xVar2 = (x) b.c(parcel2, n, x.CREATOR);
                    break;
                case 11:
                    j3 = b.q(parcel2, n);
                    break;
                case 12:
                    xVar3 = (x) b.c(parcel2, n, x.CREATOR);
                    break;
                default:
                    b.t(parcel2, n);
                    break;
            }
        }
        b.h(parcel2, u);
        return new d(str, str2, faVar, j, z, str3, xVar, j2, xVar2, j3, xVar3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new d[i];
    }
}
