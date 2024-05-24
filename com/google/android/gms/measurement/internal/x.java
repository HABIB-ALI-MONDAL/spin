package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.v.a;

public final class x extends a {
    public static final Parcelable.Creator<x> CREATOR = new y();
    public final String j;
    public final v k;
    public final String l;
    public final long m;

    x(x xVar, long j2) {
        n.i(xVar);
        this.j = xVar.j;
        this.k = xVar.k;
        this.l = xVar.l;
        this.m = j2;
    }

    public x(String str, v vVar, String str2, long j2) {
        this.j = str;
        this.k = vVar;
        this.l = str2;
        this.m = j2;
    }

    public final String toString() {
        String str = this.l;
        String str2 = this.j;
        String valueOf = String.valueOf(this.k);
        return "origin=" + str + ",name=" + str2 + ",params=" + valueOf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        y.a(this, parcel, i);
    }
}
