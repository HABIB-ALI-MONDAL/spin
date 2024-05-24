package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public class l extends a {
    public static final Parcelable.Creator<l> CREATOR = new i0();
    private final int j;
    private final int k;
    private final int l;
    private final long m;
    private final long n;
    private final String o;
    private final String p;
    private final int q;
    private final int r;

    public l(int i, int i2, int i3, long j2, long j3, String str, String str2, int i4, int i5) {
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = j2;
        this.n = j3;
        this.o = str;
        this.p = str2;
        this.q = i4;
        this.r = i5;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, this.j);
        c.i(parcel, 2, this.k);
        c.i(parcel, 3, this.l);
        c.k(parcel, 4, this.m);
        c.k(parcel, 5, this.n);
        c.n(parcel, 6, this.o, false);
        c.n(parcel, 7, this.p, false);
        c.i(parcel, 8, this.q);
        c.i(parcel, 9, this.r);
        c.b(parcel, a2);
    }
}
