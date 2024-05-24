package c.c.a.h;

import android.os.Parcel;
import android.os.Parcelable;

public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public long j;
    public String k;
    public String l;
    public boolean m;

    static class a implements Parcelable.Creator<b> {
        a() {
        }

        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, (a) null);
        }

        /* renamed from: b */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(long j2, String str, String str2, boolean z) {
        this.j = j2;
        this.k = str;
        this.l = str2;
        this.m = z;
    }

    private b(Parcel parcel) {
        this.j = parcel.readLong();
        this.k = parcel.readString();
        this.l = parcel.readString();
    }

    /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
    }
}
