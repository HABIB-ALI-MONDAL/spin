package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public final class l0 extends a {
    public static final Parcelable.Creator<l0> CREATOR = new m0();
    final int j;
    final IBinder k;
    private final b l;
    private final boolean m;
    private final boolean n;

    l0(int i, IBinder iBinder, b bVar, boolean z, boolean z2) {
        this.j = i;
        this.k = iBinder;
        this.l = bVar;
        this.m = z;
        this.n = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return this.l.equals(l0Var.l) && m.a(i(), l0Var.i());
    }

    public final b g() {
        return this.l;
    }

    public final i i() {
        IBinder iBinder = this.k;
        if (iBinder == null) {
            return null;
        }
        return i.a.i(iBinder);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, this.j);
        c.h(parcel, 2, this.k, false);
        c.m(parcel, 3, this.l, i, false);
        c.c(parcel, 4, this.m);
        c.c(parcel, 5, this.n);
        c.b(parcel, a2);
    }
}
