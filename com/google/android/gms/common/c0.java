package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c.d.a.b.d.a;
import c.d.a.b.d.b;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public final class c0 extends a {
    public static final Parcelable.Creator<c0> CREATOR = new d0();
    private final String j;
    private final boolean k;
    private final boolean l;
    private final Context m;
    private final boolean n;

    c0(String str, boolean z, boolean z2, IBinder iBinder, boolean z3) {
        this.j = str;
        this.k = z;
        this.l = z2;
        this.m = (Context) b.k(a.C0064a.i(iBinder));
        this.n = z3;
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [c.d.a.b.d.a, android.os.IBinder] */
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.n(parcel, 1, this.j, false);
        c.c(parcel, 2, this.k);
        c.c(parcel, 3, this.l);
        c.h(parcel, 4, b.b0(this.m), false);
        c.c(parcel, 5, this.n);
        c.b(parcel, a2);
    }
}
