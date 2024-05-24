package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.d.a.b.d.a;
import c.d.a.b.e.d.a;
import c.d.a.b.e.d.c;

public final class l extends a implements IInterface {
    l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int b0(c.d.a.b.d.a aVar, String str, boolean z) {
        Parcel i = i();
        c.e(i, aVar);
        i.writeString(str);
        c.c(i, z);
        Parcel h = h(3, i);
        int readInt = h.readInt();
        h.recycle();
        return readInt;
    }

    public final int c0(c.d.a.b.d.a aVar, String str, boolean z) {
        Parcel i = i();
        c.e(i, aVar);
        i.writeString(str);
        c.c(i, z);
        Parcel h = h(5, i);
        int readInt = h.readInt();
        h.recycle();
        return readInt;
    }

    public final c.d.a.b.d.a d0(c.d.a.b.d.a aVar, String str, int i) {
        Parcel i2 = i();
        c.e(i2, aVar);
        i2.writeString(str);
        i2.writeInt(i);
        Parcel h = h(2, i2);
        c.d.a.b.d.a i3 = a.C0064a.i(h.readStrongBinder());
        h.recycle();
        return i3;
    }

    public final c.d.a.b.d.a e0(c.d.a.b.d.a aVar, String str, int i, c.d.a.b.d.a aVar2) {
        Parcel i2 = i();
        c.e(i2, aVar);
        i2.writeString(str);
        i2.writeInt(i);
        c.e(i2, aVar2);
        Parcel h = h(8, i2);
        c.d.a.b.d.a i3 = a.C0064a.i(h.readStrongBinder());
        h.recycle();
        return i3;
    }

    public final c.d.a.b.d.a f0(c.d.a.b.d.a aVar, String str, int i) {
        Parcel i2 = i();
        c.e(i2, aVar);
        i2.writeString(str);
        i2.writeInt(i);
        Parcel h = h(4, i2);
        c.d.a.b.d.a i3 = a.C0064a.i(h.readStrongBinder());
        h.recycle();
        return i3;
    }

    public final c.d.a.b.d.a g0(c.d.a.b.d.a aVar, String str, boolean z, long j) {
        Parcel i = i();
        c.e(i, aVar);
        i.writeString(str);
        c.c(i, z);
        i.writeLong(j);
        Parcel h = h(7, i);
        c.d.a.b.d.a i2 = a.C0064a.i(h.readStrongBinder());
        h.recycle();
        return i2;
    }

    public final int k() {
        Parcel h = h(6, i());
        int readInt = h.readInt();
        h.recycle();
        return readInt;
    }
}
