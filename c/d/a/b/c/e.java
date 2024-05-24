package c.d.a.b.c;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class e implements Parcelable.Creator<a> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            if (b.i(n) != 1) {
                b.t(parcel, n);
            } else {
                intent = (Intent) b.c(parcel, n, Intent.CREATOR);
            }
        }
        b.h(parcel, u);
        return new a(intent);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new a[i];
    }
}
