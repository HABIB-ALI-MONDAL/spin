package c.d.a.b.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;
import java.util.List;

public final class h extends a implements k {
    public static final Parcelable.Creator<h> CREATOR = new i();
    private final List j;
    private final String k;

    public h(List list, String str) {
        this.j = list;
        this.k = str;
    }

    public final Status d() {
        return this.k != null ? Status.o : Status.q;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.o(parcel, 1, this.j, false);
        c.n(parcel, 2, this.k, false);
        c.b(parcel, a2);
    }
}
