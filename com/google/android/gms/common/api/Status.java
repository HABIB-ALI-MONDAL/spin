package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public final class Status extends a implements k, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new p();
    public static final Status o = new Status(0);
    public static final Status p = new Status(15);
    public static final Status q = new Status(16);
    final int j;
    private final int k;
    private final String l;
    private final PendingIntent m;
    private final b n;

    public Status(int i) {
        this(i, (String) null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent, b bVar) {
        this.j = i;
        this.k = i2;
        this.l = str;
        this.m = pendingIntent;
        this.n = bVar;
    }

    public Status(int i, String str) {
        this(1, i, str, (PendingIntent) null, (b) null);
    }

    public Status(b bVar, String str) {
        this(bVar, str, 17);
    }

    @Deprecated
    public Status(b bVar, String str, int i) {
        this(1, i, str, bVar.j(), bVar);
    }

    public Status d() {
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.j == status.j && this.k == status.k && m.a(this.l, status.l) && m.a(this.m, status.m) && m.a(this.n, status.n);
    }

    public b g() {
        return this.n;
    }

    public int hashCode() {
        return m.b(Integer.valueOf(this.j), Integer.valueOf(this.k), this.l, this.m, this.n);
    }

    public int i() {
        return this.k;
    }

    public String j() {
        return this.l;
    }

    public boolean k() {
        return this.m != null;
    }

    public final String l() {
        String str = this.l;
        return str != null ? str : d.a(this.k);
    }

    public String toString() {
        m.a c2 = m.c(this);
        c2.a("statusCode", l());
        c2.a("resolution", this.m);
        return c2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, i());
        c.n(parcel, 2, j(), false);
        c.m(parcel, 3, this.m, i, false);
        c.m(parcel, 4, g(), i, false);
        c.i(parcel, 1000, this.j);
        c.b(parcel, a2);
    }
}
