package c.d.a.b.f.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public final class b extends a implements k {
    public static final Parcelable.Creator<b> CREATOR = new c();
    final int j;
    private int k;
    private Intent l;

    public b() {
        this(2, 0, (Intent) null);
    }

    b(int i, int i2, Intent intent) {
        this.j = i;
        this.k = i2;
        this.l = intent;
    }

    public final Status d() {
        return this.k == 0 ? Status.o : Status.q;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, this.j);
        c.i(parcel, 2, this.k);
        c.m(parcel, 3, this.l, i, false);
        c.b(parcel, a2);
    }
}
