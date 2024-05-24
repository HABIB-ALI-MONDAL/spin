package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import c.d.a.b.d.a;
import c.d.a.b.e.d.a;

public final class p1 extends a implements r1 {
    p1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final int c() {
        Parcel h = h(2, i());
        int readInt = h.readInt();
        h.recycle();
        return readInt;
    }

    public final c.d.a.b.d.a d() {
        Parcel h = h(1, i());
        c.d.a.b.d.a i = a.C0064a.i(h.readStrongBinder());
        h.recycle();
        return i;
    }
}
