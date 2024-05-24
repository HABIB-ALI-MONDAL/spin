package b.f.a;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new b();
    public static final a k = new C0031a();
    private final Parcelable j;

    /* renamed from: b.f.a.a$a  reason: collision with other inner class name */
    static class C0031a extends a {
        C0031a() {
            super((C0031a) null);
        }
    }

    static class b implements Parcelable.ClassLoaderCreator<a> {
        b() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, (ClassLoader) null);
        }

        /* renamed from: b */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.k;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: c */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    private a() {
        this.j = null;
    }

    protected a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.j = readParcelable == null ? k : readParcelable;
    }

    protected a(Parcelable parcelable) {
        if (parcelable != null) {
            this.j = parcelable == k ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    /* synthetic */ a(C0031a aVar) {
        this();
    }

    public final Parcelable a() {
        return this.j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.j, i);
    }
}
