package b.g.a;

import android.os.Parcel;
import android.os.Parcelable;

final class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();
    m[] j;
    int[] k;
    b[] l;
    int m = -1;
    int n;

    static class a implements Parcelable.Creator<l> {
        a() {
        }

        /* renamed from: a */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        /* renamed from: b */
        public l[] newArray(int i) {
            return new l[i];
        }
    }

    public l() {
    }

    public l(Parcel parcel) {
        this.j = (m[]) parcel.createTypedArray(m.CREATOR);
        this.k = parcel.createIntArray();
        this.l = (b[]) parcel.createTypedArray(b.CREATOR);
        this.m = parcel.readInt();
        this.n = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.j, i);
        parcel.writeIntArray(this.k);
        parcel.writeTypedArray(this.l, i);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
    }
}
