package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;
import com.google.android.gms.common.internal.v.c;

public final class ga implements Parcelable.Creator {
    static void a(fa faVar, Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, faVar.j);
        c.n(parcel, 2, faVar.k, false);
        c.k(parcel, 3, faVar.l);
        c.l(parcel, 4, faVar.m, false);
        c.g(parcel, 5, (Float) null, false);
        c.n(parcel, 6, faVar.n, false);
        c.n(parcel, 7, faVar.o, false);
        c.f(parcel, 8, faVar.p, false);
        c.b(parcel, a2);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int u = b.u(parcel);
        String str = null;
        Long l = null;
        Float f2 = null;
        String str2 = null;
        String str3 = null;
        Double d2 = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            switch (b.i(n)) {
                case 1:
                    i = b.p(parcel2, n);
                    break;
                case 2:
                    str = b.d(parcel2, n);
                    break;
                case 3:
                    j = b.q(parcel2, n);
                    break;
                case 4:
                    l = b.r(parcel2, n);
                    break;
                case 5:
                    f2 = b.m(parcel2, n);
                    break;
                case 6:
                    str2 = b.d(parcel2, n);
                    break;
                case 7:
                    str3 = b.d(parcel2, n);
                    break;
                case 8:
                    d2 = b.l(parcel2, n);
                    break;
                default:
                    b.t(parcel2, n);
                    break;
            }
        }
        b.h(parcel2, u);
        return new fa(i, str, j, l, f2, str2, str3, d2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new fa[i];
    }
}
