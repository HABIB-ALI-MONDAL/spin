package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public class d extends a {
    public static final Parcelable.Creator<d> CREATOR = new q();
    private final String j;
    @Deprecated
    private final int k;
    private final long l;

    public d(String str, int i, long j2) {
        this.j = str;
        this.k = i;
        this.l = j2;
    }

    public d(String str, long j2) {
        this.j = str;
        this.l = j2;
        this.k = -1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return ((g() != null && g().equals(dVar.g())) || (g() == null && dVar.g() == null)) && i() == dVar.i();
        }
    }

    public String g() {
        return this.j;
    }

    public final int hashCode() {
        return m.b(g(), Long.valueOf(i()));
    }

    public long i() {
        long j2 = this.l;
        return j2 == -1 ? (long) this.k : j2;
    }

    public final String toString() {
        m.a c2 = m.c(this);
        c2.a("name", g());
        c2.a("version", Long.valueOf(i()));
        return c2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.n(parcel, 1, g(), false);
        c.i(parcel, 2, this.k);
        c.k(parcel, 3, i());
        c.b(parcel, a2);
    }
}
