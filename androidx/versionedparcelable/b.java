package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import b.c.a;
import java.lang.reflect.Method;

class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f454d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f455e;

    /* renamed from: f  reason: collision with root package name */
    private final int f456f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private int k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    private b(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f454d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.f455e = parcel;
        this.f456f = i2;
        this.g = i3;
        this.j = i2;
        this.h = str;
    }

    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f455e.writeInt(bArr.length);
            this.f455e.writeByteArray(bArr);
            return;
        }
        this.f455e.writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f455e, 0);
    }

    public void E(int i2) {
        this.f455e.writeInt(i2);
    }

    public void G(Parcelable parcelable) {
        this.f455e.writeParcelable(parcelable, 0);
    }

    public void I(String str) {
        this.f455e.writeString(str);
    }

    public void a() {
        int i2 = this.i;
        if (i2 >= 0) {
            int i3 = this.f454d.get(i2);
            int dataPosition = this.f455e.dataPosition();
            this.f455e.setDataPosition(i3);
            this.f455e.writeInt(dataPosition - i3);
            this.f455e.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public a b() {
        Parcel parcel = this.f455e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.j;
        if (i2 == this.f456f) {
            i2 = this.g;
        }
        int i3 = i2;
        return new b(parcel, dataPosition, i3, this.h + "  ", this.f451a, this.f452b, this.f453c);
    }

    public boolean g() {
        return this.f455e.readInt() != 0;
    }

    public byte[] i() {
        int readInt = this.f455e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f455e.readByteArray(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f455e);
    }

    public boolean m(int i2) {
        while (this.j < this.g) {
            int i3 = this.k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f455e.setDataPosition(this.j);
            int readInt = this.f455e.readInt();
            this.k = this.f455e.readInt();
            this.j += readInt;
        }
        return this.k == i2;
    }

    public int o() {
        return this.f455e.readInt();
    }

    public <T extends Parcelable> T q() {
        return this.f455e.readParcelable(b.class.getClassLoader());
    }

    public String s() {
        return this.f455e.readString();
    }

    public void w(int i2) {
        a();
        this.i = i2;
        this.f454d.put(i2, this.f455e.dataPosition());
        E(0);
        E(i2);
    }

    public void y(boolean z) {
        this.f455e.writeInt(z ? 1 : 0);
    }
}
