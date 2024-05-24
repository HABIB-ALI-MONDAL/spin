package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;
import javax.annotation.Nullable;

public final class e0 extends a {
    public static final Parcelable.Creator<e0> CREATOR = new f0();
    private final boolean j;
    @Nullable
    private final String k;
    private final int l;
    private final int m;

    e0(boolean z, String str, int i, int i2) {
        this.j = z;
        this.k = str;
        this.l = m0.a(i) - 1;
        this.m = r.a(i2) - 1;
    }

    @Nullable
    public final String g() {
        return this.k;
    }

    public final boolean i() {
        return this.j;
    }

    public final int j() {
        return r.a(this.m);
    }

    public final int k() {
        return m0.a(this.l);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.c(parcel, 1, this.j);
        c.n(parcel, 2, this.k, false);
        c.i(parcel, 3, this.l);
        c.i(parcel, 4, this.m);
        c.b(parcel, a2);
    }
}
