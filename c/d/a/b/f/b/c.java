package c.d.a.b.f.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class c implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i3 = b.i(n);
            if (i3 == 1) {
                i = b.p(parcel, n);
            } else if (i3 == 2) {
                i2 = b.p(parcel, n);
            } else if (i3 != 3) {
                b.t(parcel, n);
            } else {
                intent = (Intent) b.c(parcel, n, Intent.CREATOR);
            }
        }
        b.h(parcel, u);
        return new b(i, i2, intent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
