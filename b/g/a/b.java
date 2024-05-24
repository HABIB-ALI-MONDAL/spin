package b.g.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import b.g.a.a;
import java.util.ArrayList;

final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    final int[] j;
    final int k;
    final int l;
    final String m;
    final int n;
    final int o;
    final CharSequence p;
    final int q;
    final CharSequence r;
    final ArrayList<String> s;
    final ArrayList<String> t;
    final boolean u;

    static class a implements Parcelable.Creator<b> {
        a() {
        }

        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: b */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(Parcel parcel) {
        this.j = parcel.createIntArray();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.q = parcel.readInt();
        this.r = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.s = parcel.createStringArrayList();
        this.t = parcel.createStringArrayList();
        this.u = parcel.readInt() != 0;
    }

    public b(a aVar) {
        int size = aVar.f675b.size();
        this.j = new int[(size * 6)];
        if (aVar.i) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                a.C0032a aVar2 = aVar.f675b.get(i2);
                int[] iArr = this.j;
                int i3 = i + 1;
                iArr[i] = aVar2.f680a;
                int i4 = i3 + 1;
                d dVar = aVar2.f681b;
                iArr[i3] = dVar != null ? dVar.n : -1;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.f682c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.f683d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.f684e;
                i = i7 + 1;
                iArr[i7] = aVar2.f685f;
            }
            this.k = aVar.g;
            this.l = aVar.h;
            this.m = aVar.j;
            this.n = aVar.l;
            this.o = aVar.m;
            this.p = aVar.n;
            this.q = aVar.o;
            this.r = aVar.p;
            this.s = aVar.q;
            this.t = aVar.r;
            this.u = aVar.s;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public a a(j jVar) {
        a aVar = new a(jVar);
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.j;
            if (i < iArr.length) {
                a.C0032a aVar2 = new a.C0032a();
                int i3 = i + 1;
                aVar2.f680a = iArr[i];
                if (j.N) {
                    Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.j[i3]);
                }
                int i4 = i3 + 1;
                int i5 = this.j[i3];
                aVar2.f681b = i5 >= 0 ? jVar.n.get(i5) : null;
                int[] iArr2 = this.j;
                int i6 = i4 + 1;
                int i7 = iArr2[i4];
                aVar2.f682c = i7;
                int i8 = i6 + 1;
                int i9 = iArr2[i6];
                aVar2.f683d = i9;
                int i10 = i8 + 1;
                int i11 = iArr2[i8];
                aVar2.f684e = i11;
                int i12 = iArr2[i10];
                aVar2.f685f = i12;
                aVar.f676c = i7;
                aVar.f677d = i9;
                aVar.f678e = i11;
                aVar.f679f = i12;
                aVar.f(aVar2);
                i2++;
                i = i10 + 1;
            } else {
                aVar.g = this.k;
                aVar.h = this.l;
                aVar.j = this.m;
                aVar.l = this.n;
                aVar.i = true;
                aVar.m = this.o;
                aVar.n = this.p;
                aVar.o = this.q;
                aVar.p = this.r;
                aVar.q = this.s;
                aVar.r = this.t;
                aVar.s = this.u;
                aVar.g(1);
                return aVar;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        TextUtils.writeToParcel(this.p, parcel, 0);
        parcel.writeInt(this.q);
        TextUtils.writeToParcel(this.r, parcel, 0);
        parcel.writeStringList(this.s);
        parcel.writeStringList(this.t);
        parcel.writeInt(this.u ? 1 : 0);
    }
}
