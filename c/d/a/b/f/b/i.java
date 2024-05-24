package c.d.a.b.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;
import java.util.ArrayList;

public final class i implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i = b.i(n);
            if (i == 1) {
                arrayList = b.e(parcel, n);
            } else if (i != 2) {
                b.t(parcel, n);
            } else {
                str = b.d(parcel, n);
            }
        }
        b.h(parcel, u);
        return new h(arrayList, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new h[i];
    }
}
