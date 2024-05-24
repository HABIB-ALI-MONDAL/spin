package c.d.a.b.c;

import android.os.Parcel;
import android.os.Parcelable;

final class g implements Parcelable.Creator<i> {
    g() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new i(parcel.readStrongBinder());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new i[i];
    }
}
