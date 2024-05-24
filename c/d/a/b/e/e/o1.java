package c.d.a.b.e.e;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;

public final class o1 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int u = b.u(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        boolean z = false;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            switch (b.i(n)) {
                case 1:
                    j = b.q(parcel2, n);
                    break;
                case 2:
                    j2 = b.q(parcel2, n);
                    break;
                case 3:
                    z = b.j(parcel2, n);
                    break;
                case 4:
                    str = b.d(parcel2, n);
                    break;
                case 5:
                    str2 = b.d(parcel2, n);
                    break;
                case 6:
                    str3 = b.d(parcel2, n);
                    break;
                case 7:
                    bundle = b.a(parcel2, n);
                    break;
                case 8:
                    str4 = b.d(parcel2, n);
                    break;
                default:
                    b.t(parcel2, n);
                    break;
            }
        }
        b.h(parcel2, u);
        return new n1(j, j2, z, str, str2, str3, bundle, str4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new n1[i];
    }
}
