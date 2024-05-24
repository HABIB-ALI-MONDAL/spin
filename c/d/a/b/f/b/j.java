package c.d.a.b.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.j0;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public final class j extends a {
    public static final Parcelable.Creator<j> CREATOR = new k();
    final int j;
    final j0 k;

    j(int i, j0 j0Var) {
        this.j = i;
        this.k = j0Var;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, this.j);
        c.m(parcel, 2, this.k, i, false);
        c.b(parcel, a2);
    }
}
