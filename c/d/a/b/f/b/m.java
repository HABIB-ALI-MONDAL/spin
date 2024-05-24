package c.d.a.b.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l0;
import com.google.android.gms.common.internal.v.b;

public final class m implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        com.google.android.gms.common.b bVar = null;
        l0 l0Var = null;
        int i = 0;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i2 = b.i(n);
            if (i2 == 1) {
                i = b.p(parcel, n);
            } else if (i2 == 2) {
                bVar = (com.google.android.gms.common.b) b.c(parcel, n, com.google.android.gms.common.b.CREATOR);
            } else if (i2 != 3) {
                b.t(parcel, n);
            } else {
                l0Var = (l0) b.c(parcel, n, l0.CREATOR);
            }
        }
        b.h(parcel, u);
        return new l(i, bVar, l0Var);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new l[i];
    }
}
