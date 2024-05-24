package c.d.a.b.e.e;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public final class n1 extends a {
    public static final Parcelable.Creator<n1> CREATOR = new o1();
    public final long j;
    public final long k;
    public final boolean l;
    public final String m;
    public final String n;
    public final String o;
    public final Bundle p;
    public final String q;

    public n1(long j2, long j3, boolean z, String str, String str2, String str3, Bundle bundle, String str4) {
        this.j = j2;
        this.k = j3;
        this.l = z;
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.p = bundle;
        this.q = str4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.k(parcel, 1, this.j);
        c.k(parcel, 2, this.k);
        c.c(parcel, 3, this.l);
        c.n(parcel, 4, this.m, false);
        c.n(parcel, 5, this.n, false);
        c.n(parcel, 6, this.o, false);
        c.e(parcel, 7, this.p, false);
        c.n(parcel, 8, this.q, false);
        c.b(parcel, a2);
    }
}
