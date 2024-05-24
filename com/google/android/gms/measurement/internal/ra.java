package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.a.j;
import com.google.android.gms.common.internal.v.b;
import java.util.ArrayList;
import java.util.List;

public final class ra implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int u = b.u(parcel);
        String str = "";
        String str2 = str;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str10 = null;
        String str11 = null;
        long j6 = -2147483648L;
        boolean z = true;
        boolean z2 = false;
        int i = 0;
        boolean z3 = true;
        boolean z4 = false;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            switch (b.i(n)) {
                case 2:
                    str3 = b.d(parcel2, n);
                    break;
                case 3:
                    str4 = b.d(parcel2, n);
                    break;
                case 4:
                    str5 = b.d(parcel2, n);
                    break;
                case 5:
                    str6 = b.d(parcel2, n);
                    break;
                case 6:
                    j = b.q(parcel2, n);
                    break;
                case 7:
                    j2 = b.q(parcel2, n);
                    break;
                case 8:
                    str7 = b.d(parcel2, n);
                    break;
                case 9:
                    z = b.j(parcel2, n);
                    break;
                case 10:
                    z2 = b.j(parcel2, n);
                    break;
                case 11:
                    j6 = b.q(parcel2, n);
                    break;
                case 12:
                    str8 = b.d(parcel2, n);
                    break;
                case 13:
                    j3 = b.q(parcel2, n);
                    break;
                case 14:
                    j4 = b.q(parcel2, n);
                    break;
                case 15:
                    i = b.p(parcel2, n);
                    break;
                case 16:
                    z3 = b.j(parcel2, n);
                    break;
                case 18:
                    z4 = b.j(parcel2, n);
                    break;
                case 19:
                    str9 = b.d(parcel2, n);
                    break;
                case 21:
                    bool = b.k(parcel2, n);
                    break;
                case 22:
                    j5 = b.q(parcel2, n);
                    break;
                case j.h3:
                    arrayList = b.e(parcel2, n);
                    break;
                case j.i3:
                    str10 = b.d(parcel2, n);
                    break;
                case 25:
                    str = b.d(parcel2, n);
                    break;
                case 26:
                    str2 = b.d(parcel2, n);
                    break;
                case 27:
                    str11 = b.d(parcel2, n);
                    break;
                default:
                    b.t(parcel2, n);
                    break;
            }
        }
        b.h(parcel2, u);
        return new qa(str3, str4, str5, str6, j, j2, str7, z, z2, j6, str8, j3, j4, i, z3, z4, str9, bool, j5, (List) arrayList, str10, str, str2, str11);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new qa[i];
    }
}
