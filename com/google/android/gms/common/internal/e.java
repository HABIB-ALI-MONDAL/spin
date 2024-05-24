package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public class e extends a {
    public static final Parcelable.Creator<e> CREATOR = new e1();
    private final p j;
    private final boolean k;
    private final boolean l;
    private final int[] m;
    private final int n;
    private final int[] o;

    public e(p pVar, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.j = pVar;
        this.k = z;
        this.l = z2;
        this.m = iArr;
        this.n = i;
        this.o = iArr2;
    }

    public int g() {
        return this.n;
    }

    public int[] i() {
        return this.m;
    }

    public int[] j() {
        return this.o;
    }

    public boolean k() {
        return this.k;
    }

    public boolean l() {
        return this.l;
    }

    public final p p() {
        return this.j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.m(parcel, 1, this.j, i, false);
        c.c(parcel, 2, k());
        c.c(parcel, 3, l());
        c.j(parcel, 4, i(), false);
        c.i(parcel, 5, g());
        c.j(parcel, 6, j(), false);
        c.b(parcel, a2);
    }
}
