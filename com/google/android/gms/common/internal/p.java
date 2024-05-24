package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public class p extends a {
    public static final Parcelable.Creator<p> CREATOR = new v0();
    private final int j;
    private final boolean k;
    private final boolean l;
    private final int m;
    private final int n;

    public p(int i, boolean z, boolean z2, int i2, int i3) {
        this.j = i;
        this.k = z;
        this.l = z2;
        this.m = i2;
        this.n = i3;
    }

    public int g() {
        return this.m;
    }

    public int i() {
        return this.n;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return this.l;
    }

    public int l() {
        return this.j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, l());
        c.c(parcel, 2, j());
        c.c(parcel, 3, k());
        c.i(parcel, 4, g());
        c.i(parcel, 5, i());
        c.b(parcel, a2);
    }
}
