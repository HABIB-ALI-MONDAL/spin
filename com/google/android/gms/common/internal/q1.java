package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.d.a.b.d.a;
import c.d.a.b.e.d.b;
import c.d.a.b.e.d.c;

public abstract class q1 extends b implements r1 {
    public q1() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static r1 i(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof r1 ? (r1) queryLocalInterface : new p1(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean h(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            a d2 = d();
            parcel2.writeNoException();
            c.e(parcel2, d2);
        } else if (i != 2) {
            return false;
        } else {
            int c2 = c();
            parcel2.writeNoException();
            parcel2.writeInt(c2);
        }
        return true;
    }
}
