package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.d.a.b.d.a;
import c.d.a.b.e.d.a;
import c.d.a.b.e.d.c;

public final class m extends a implements IInterface {
    m(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final c.d.a.b.d.a b0(c.d.a.b.d.a aVar, String str, int i, c.d.a.b.d.a aVar2) {
        Parcel i2 = i();
        c.e(i2, aVar);
        i2.writeString(str);
        i2.writeInt(i);
        c.e(i2, aVar2);
        Parcel h = h(3, i2);
        c.d.a.b.d.a i3 = a.C0064a.i(h.readStrongBinder());
        h.recycle();
        return i3;
    }

    public final c.d.a.b.d.a k(c.d.a.b.d.a aVar, String str, int i, c.d.a.b.d.a aVar2) {
        Parcel i2 = i();
        c.e(i2, aVar);
        i2.writeString(str);
        i2.writeInt(i);
        c.e(i2, aVar2);
        Parcel h = h(2, i2);
        c.d.a.b.d.a i3 = a.C0064a.i(h.readStrongBinder());
        h.recycle();
        return i3;
    }
}
