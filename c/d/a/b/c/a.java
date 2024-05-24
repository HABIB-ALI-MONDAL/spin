package c.d.a.b.c;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.c;

public final class a extends com.google.android.gms.common.internal.v.a {
    public static final Parcelable.Creator<a> CREATOR = new e();
    Intent j;

    public a(Intent intent) {
        this.j = intent;
    }

    public Intent g() {
        return this.j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.m(parcel, 1, this.j, i, false);
        c.b(parcel, a2);
    }
}
