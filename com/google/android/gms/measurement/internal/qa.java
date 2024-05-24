package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;
import java.util.List;

public final class qa extends a {
    public static final Parcelable.Creator<qa> CREATOR = new ra();
    public final Boolean A;
    public final long B;
    public final List C;
    public final String D;
    public final String E;
    public final String F;
    public final String G;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final long n;
    public final long o;
    public final String p;
    public final boolean q;
    public final boolean r;
    public final long s;
    public final String t;
    @Deprecated
    public final long u;
    public final long v;
    public final int w;
    public final boolean x;
    public final boolean y;
    public final String z;

    qa(String str, String str2, String str3, long j2, String str4, long j3, long j4, String str5, boolean z2, boolean z3, String str6, long j5, long j6, int i, boolean z4, boolean z5, String str7, Boolean bool, long j7, List list, String str8, String str9, String str10, String str11) {
        n.e(str);
        this.j = str;
        this.k = true != TextUtils.isEmpty(str2) ? str2 : null;
        this.l = str3;
        this.s = j2;
        this.m = str4;
        this.n = j3;
        this.o = j4;
        this.p = str5;
        this.q = z2;
        this.r = z3;
        this.t = str6;
        this.u = 0;
        this.v = j6;
        this.w = i;
        this.x = z4;
        this.y = z5;
        this.z = str7;
        this.A = bool;
        this.B = j7;
        this.C = list;
        this.D = null;
        this.E = str9;
        this.F = str10;
        this.G = str11;
    }

    qa(String str, String str2, String str3, String str4, long j2, long j3, String str5, boolean z2, boolean z3, long j4, String str6, long j5, long j6, int i, boolean z4, boolean z5, String str7, Boolean bool, long j7, List list, String str8, String str9, String str10, String str11) {
        this.j = str;
        this.k = str2;
        this.l = str3;
        this.s = j4;
        this.m = str4;
        this.n = j2;
        this.o = j3;
        this.p = str5;
        this.q = z2;
        this.r = z3;
        this.t = str6;
        this.u = j5;
        this.v = j6;
        this.w = i;
        this.x = z4;
        this.y = z5;
        this.z = str7;
        this.A = bool;
        this.B = j7;
        this.C = list;
        this.D = str8;
        this.E = str9;
        this.F = str10;
        this.G = str11;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.n(parcel, 2, this.j, false);
        c.n(parcel, 3, this.k, false);
        c.n(parcel, 4, this.l, false);
        c.n(parcel, 5, this.m, false);
        c.k(parcel, 6, this.n);
        c.k(parcel, 7, this.o);
        c.n(parcel, 8, this.p, false);
        c.c(parcel, 9, this.q);
        c.c(parcel, 10, this.r);
        c.k(parcel, 11, this.s);
        c.n(parcel, 12, this.t, false);
        c.k(parcel, 13, this.u);
        c.k(parcel, 14, this.v);
        c.i(parcel, 15, this.w);
        c.c(parcel, 16, this.x);
        c.c(parcel, 18, this.y);
        c.n(parcel, 19, this.z, false);
        c.d(parcel, 21, this.A, false);
        c.k(parcel, 22, this.B);
        c.o(parcel, 23, this.C, false);
        c.n(parcel, 24, this.D, false);
        c.n(parcel, 25, this.E, false);
        c.n(parcel, 26, this.F, false);
        c.n(parcel, 27, this.G, false);
        c.b(parcel, a2);
    }
}
