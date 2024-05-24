package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;
import java.util.Iterator;

public final class v extends a implements Iterable<String> {
    public static final Parcelable.Creator<v> CREATOR = new w();
    /* access modifiers changed from: private */
    public final Bundle j;

    v(Bundle bundle) {
        this.j = bundle;
    }

    public final int g() {
        return this.j.size();
    }

    public final Iterator iterator() {
        return new u(this);
    }

    public final Bundle j() {
        return new Bundle(this.j);
    }

    /* access modifiers changed from: package-private */
    public final Double k(String str) {
        return Double.valueOf(this.j.getDouble("value"));
    }

    /* access modifiers changed from: package-private */
    public final Long l(String str) {
        return Long.valueOf(this.j.getLong("value"));
    }

    /* access modifiers changed from: package-private */
    public final Object p(String str) {
        return this.j.get(str);
    }

    /* access modifiers changed from: package-private */
    public final String r(String str) {
        return this.j.getString(str);
    }

    public final String toString() {
        return this.j.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.e(parcel, 2, j(), false);
        c.b(parcel, a2);
    }
}
