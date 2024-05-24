package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.b;
import com.google.android.gms.common.internal.v.c;

public class v0 implements Parcelable.Creator<u0> {
    static void c(u0 u0Var, Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.e(parcel, 2, u0Var.j, false);
        c.b(parcel, a2);
    }

    /* renamed from: a */
    public u0 createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            if (b.i(n) != 2) {
                b.t(parcel, n);
            } else {
                bundle = b.a(parcel, n);
            }
        }
        b.h(parcel, u);
        return new u0(bundle);
    }

    /* renamed from: b */
    public u0[] newArray(int i) {
        return new u0[i];
    }
}
