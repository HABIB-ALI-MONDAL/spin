package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public final class d extends a {
    public static final Parcelable.Creator<d> CREATOR = new e();
    public String j;
    public String k;
    public fa l;
    public long m;
    public boolean n;
    public String o;
    public final x p;
    public long q;
    public x r;
    public final long s;
    public final x t;

    d(d dVar) {
        n.i(dVar);
        this.j = dVar.j;
        this.k = dVar.k;
        this.l = dVar.l;
        this.m = dVar.m;
        this.n = dVar.n;
        this.o = dVar.o;
        this.p = dVar.p;
        this.q = dVar.q;
        this.r = dVar.r;
        this.s = dVar.s;
        this.t = dVar.t;
    }

    d(String str, String str2, fa faVar, long j2, boolean z, String str3, x xVar, long j3, x xVar2, long j4, x xVar3) {
        this.j = str;
        this.k = str2;
        this.l = faVar;
        this.m = j2;
        this.n = z;
        this.o = str3;
        this.p = xVar;
        this.q = j3;
        this.r = xVar2;
        this.s = j4;
        this.t = xVar3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.n(parcel, 2, this.j, false);
        c.n(parcel, 3, this.k, false);
        c.m(parcel, 4, this.l, i, false);
        c.k(parcel, 5, this.m);
        c.c(parcel, 6, this.n);
        c.n(parcel, 7, this.o, false);
        c.m(parcel, 8, this.p, i, false);
        c.k(parcel, 9, this.q);
        c.m(parcel, 10, this.r, i, false);
        c.k(parcel, 11, this.s);
        c.m(parcel, 12, this.t, i, false);
        c.b(parcel, a2);
    }
}
