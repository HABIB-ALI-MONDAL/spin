package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0006a();
    private final int j;
    private final Intent k;

    /* renamed from: androidx.activity.result.a$a  reason: collision with other inner class name */
    class C0006a implements Parcelable.Creator<a> {
        C0006a() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: b */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public a(int i, Intent intent) {
        this.j = i;
        this.k = intent;
    }

    a(Parcel parcel) {
        this.j = parcel.readInt();
        this.k = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    public static String c(int i) {
        return i != -1 ? i != 0 ? String.valueOf(i) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.k;
    }

    public int b() {
        return this.j;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.j) + ", data=" + this.k + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j);
        parcel.writeInt(this.k == null ? 0 : 1);
        Intent intent = this.k;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }
}
