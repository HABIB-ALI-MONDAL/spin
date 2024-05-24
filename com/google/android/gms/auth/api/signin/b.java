package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

public final class b implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int u = com.google.android.gms.common.internal.v.b.u(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList<Scope> arrayList = null;
        String str7 = null;
        String str8 = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < u) {
            int n = com.google.android.gms.common.internal.v.b.n(parcel);
            switch (com.google.android.gms.common.internal.v.b.i(n)) {
                case 1:
                    i = com.google.android.gms.common.internal.v.b.p(parcel2, n);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.v.b.d(parcel2, n);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.v.b.d(parcel2, n);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.v.b.d(parcel2, n);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.v.b.d(parcel2, n);
                    break;
                case 6:
                    uri = (Uri) com.google.android.gms.common.internal.v.b.c(parcel2, n, Uri.CREATOR);
                    break;
                case 7:
                    str5 = com.google.android.gms.common.internal.v.b.d(parcel2, n);
                    break;
                case 8:
                    j = com.google.android.gms.common.internal.v.b.q(parcel2, n);
                    break;
                case 9:
                    str6 = com.google.android.gms.common.internal.v.b.d(parcel2, n);
                    break;
                case 10:
                    arrayList = com.google.android.gms.common.internal.v.b.g(parcel2, n, Scope.CREATOR);
                    break;
                case 11:
                    str7 = com.google.android.gms.common.internal.v.b.d(parcel2, n);
                    break;
                case 12:
                    str8 = com.google.android.gms.common.internal.v.b.d(parcel2, n);
                    break;
                default:
                    com.google.android.gms.common.internal.v.b.t(parcel2, n);
                    break;
            }
        }
        com.google.android.gms.common.internal.v.b.h(parcel2, u);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
