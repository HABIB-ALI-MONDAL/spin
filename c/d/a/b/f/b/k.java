package c.d.a.b.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.j0;
import com.google.android.gms.common.internal.v.b;

public final class k implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        int i = 0;
        j0 j0Var = null;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i2 = b.i(n);
            if (i2 == 1) {
                i = b.p(parcel, n);
            } else if (i2 != 2) {
                b.t(parcel, n);
            } else {
                j0Var = (j0) b.c(parcel, n, j0.CREATOR);
            }
        }
        b.h(parcel, u);
        return new j(i, j0Var);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new j[i];
    }
}
