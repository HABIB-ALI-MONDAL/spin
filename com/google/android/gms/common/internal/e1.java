package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class e1 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        p pVar = null;
        int[] iArr = null;
        int[] iArr2 = null;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            switch (b.i(n)) {
                case 1:
                    pVar = (p) b.c(parcel, n, p.CREATOR);
                    break;
                case 2:
                    z = b.j(parcel, n);
                    break;
                case 3:
                    z2 = b.j(parcel, n);
                    break;
                case 4:
                    iArr = b.b(parcel, n);
                    break;
                case 5:
                    i = b.p(parcel, n);
                    break;
                case 6:
                    iArr2 = b.b(parcel, n);
                    break;
                default:
                    b.t(parcel, n);
                    break;
            }
        }
        b.h(parcel, u);
        return new e(pVar, z, z2, iArr, i, iArr2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new e[i];
    }
}
