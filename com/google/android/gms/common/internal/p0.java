package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

final class p0 implements k {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f2224a;

    p0(IBinder iBinder) {
        this.f2224a = iBinder;
    }

    public final void P(j jVar, f fVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            if (fVar != null) {
                obtain.writeInt(1);
                f1.a(fVar, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f2224a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f2224a;
    }
}
