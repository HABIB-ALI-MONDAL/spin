package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import c.d.a.b.e.d.b;
import c.d.a.b.e.d.c;

public abstract class o0 extends b implements j {
    public o0() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean h(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            c.b(parcel);
            Y(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.a(parcel, Bundle.CREATOR));
        } else if (i == 2) {
            c.b(parcel);
            q(parcel.readInt(), (Bundle) c.a(parcel, Bundle.CREATOR));
        } else if (i != 3) {
            return false;
        } else {
            c.b(parcel);
            s(parcel.readInt(), parcel.readStrongBinder(), (c1) c.a(parcel, c1.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
