package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public final class c1 extends a {
    public static final Parcelable.Creator<c1> CREATOR = new d1();
    Bundle j;
    d[] k;
    int l;
    e m;

    public c1() {
    }

    c1(Bundle bundle, d[] dVarArr, int i, e eVar) {
        this.j = bundle;
        this.k = dVarArr;
        this.l = i;
        this.m = eVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.e(parcel, 1, this.j, false);
        c.p(parcel, 2, this.k, i, false);
        c.i(parcel, 3, this.l);
        c.m(parcel, 4, this.m, i, false);
        c.b(parcel, a2);
    }
}
