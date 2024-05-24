package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public final class Scope extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new o();
    final int j;
    private final String k;

    Scope(int i, String str) {
        n.f(str, "scopeUri must not be null or empty");
        this.j = i;
        this.k = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.k.equals(((Scope) obj).k);
    }

    public String g() {
        return this.k;
    }

    public int hashCode() {
        return this.k.hashCode();
    }

    public String toString() {
        return this.k;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, this.j);
        c.n(parcel, 2, g(), false);
        c.b(parcel, a2);
    }
}
