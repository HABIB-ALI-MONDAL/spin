package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import c.d.a.b.e.e.o0;
import c.d.a.b.e.e.q0;
import java.util.ArrayList;
import java.util.List;

public final class z2 extends o0 implements b3 {
    z2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final List A(String str, String str2, String str3, boolean z) {
        Parcel h = h();
        h.writeString((String) null);
        h.writeString(str2);
        h.writeString(str3);
        q0.d(h, z);
        Parcel i = i(15, h);
        ArrayList<fa> createTypedArrayList = i.createTypedArrayList(fa.CREATOR);
        i.recycle();
        return createTypedArrayList;
    }

    public final byte[] H(x xVar, String str) {
        Parcel h = h();
        q0.e(h, xVar);
        h.writeString(str);
        Parcel i = i(9, h);
        byte[] createByteArray = i.createByteArray();
        i.recycle();
        return createByteArray;
    }

    public final void J(qa qaVar) {
        Parcel h = h();
        q0.e(h, qaVar);
        k(20, h);
    }

    public final List M(String str, String str2, boolean z, qa qaVar) {
        Parcel h = h();
        h.writeString(str);
        h.writeString(str2);
        q0.d(h, z);
        q0.e(h, qaVar);
        Parcel i = i(14, h);
        ArrayList<fa> createTypedArrayList = i.createTypedArrayList(fa.CREATOR);
        i.recycle();
        return createTypedArrayList;
    }

    public final String N(qa qaVar) {
        Parcel h = h();
        q0.e(h, qaVar);
        Parcel i = i(11, h);
        String readString = i.readString();
        i.recycle();
        return readString;
    }

    public final void O(x xVar, qa qaVar) {
        Parcel h = h();
        q0.e(h, xVar);
        q0.e(h, qaVar);
        k(1, h);
    }

    public final void V(qa qaVar) {
        Parcel h = h();
        q0.e(h, qaVar);
        k(4, h);
    }

    public final List W(String str, String str2, qa qaVar) {
        Parcel h = h();
        h.writeString(str);
        h.writeString(str2);
        q0.e(h, qaVar);
        Parcel i = i(16, h);
        ArrayList<d> createTypedArrayList = i.createTypedArrayList(d.CREATOR);
        i.recycle();
        return createTypedArrayList;
    }

    public final List a0(String str, String str2, String str3) {
        Parcel h = h();
        h.writeString((String) null);
        h.writeString(str2);
        h.writeString(str3);
        Parcel i = i(17, h);
        ArrayList<d> createTypedArrayList = i.createTypedArrayList(d.CREATOR);
        i.recycle();
        return createTypedArrayList;
    }

    public final void m(qa qaVar) {
        Parcel h = h();
        q0.e(h, qaVar);
        k(18, h);
    }

    public final void n(long j, String str, String str2, String str3) {
        Parcel h = h();
        h.writeLong(j);
        h.writeString(str);
        h.writeString(str2);
        h.writeString(str3);
        k(10, h);
    }

    public final void u(qa qaVar) {
        Parcel h = h();
        q0.e(h, qaVar);
        k(6, h);
    }

    public final void v(fa faVar, qa qaVar) {
        Parcel h = h();
        q0.e(h, faVar);
        q0.e(h, qaVar);
        k(2, h);
    }

    public final void y(d dVar, qa qaVar) {
        Parcel h = h();
        q0.e(h, dVar);
        q0.e(h, qaVar);
        k(12, h);
    }

    public final void z(Bundle bundle, qa qaVar) {
        Parcel h = h();
        q0.e(h, bundle);
        q0.e(h, qaVar);
        k(19, h);
    }
}
