package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.v.a;

public final class fa extends a {
    public static final Parcelable.Creator<fa> CREATOR = new ga();
    public final int j;
    public final String k;
    public final long l;
    public final Long m;
    public final String n;
    public final String o;
    public final Double p;

    fa(int i, String str, long j2, Long l2, Float f2, String str2, String str3, Double d2) {
        this.j = i;
        this.k = str;
        this.l = j2;
        this.m = l2;
        if (i == 1) {
            this.p = f2 != null ? Double.valueOf(f2.doubleValue()) : null;
        } else {
            this.p = d2;
        }
        this.n = str2;
        this.o = str3;
    }

    fa(ha haVar) {
        this(haVar.f2406c, haVar.f2407d, haVar.f2408e, haVar.f2405b);
    }

    fa(String str, long j2, Object obj, String str2) {
        n.e(str);
        this.j = 2;
        this.k = str;
        this.l = j2;
        this.o = str2;
        if (obj == null) {
            this.m = null;
            this.p = null;
            this.n = null;
        } else if (obj instanceof Long) {
            this.m = (Long) obj;
            this.p = null;
            this.n = null;
        } else if (obj instanceof String) {
            this.m = null;
            this.p = null;
            this.n = (String) obj;
        } else if (obj instanceof Double) {
            this.m = null;
            this.p = (Double) obj;
            this.n = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object g() {
        Long l2 = this.m;
        if (l2 != null) {
            return l2;
        }
        Double d2 = this.p;
        if (d2 != null) {
            return d2;
        }
        String str = this.n;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ga.a(this, parcel, i);
    }
}
