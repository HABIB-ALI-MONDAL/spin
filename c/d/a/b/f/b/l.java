package c.d.a.b.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.l0;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public final class l extends a {
    public static final Parcelable.Creator<l> CREATOR = new m();
    final int j;
    private final b k;
    private final l0 l;

    l(int i, b bVar, l0 l0Var) {
        this.j = i;
        this.k = bVar;
        this.l = l0Var;
    }

    public final b g() {
        return this.k;
    }

    public final l0 i() {
        return this.l;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, this.j);
        c.m(parcel, 2, this.k, i, false);
        c.m(parcel, 3, this.l, i, false);
        c.b(parcel, a2);
    }
}
