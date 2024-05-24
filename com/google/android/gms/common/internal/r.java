package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class r extends a {
    public static final Parcelable.Creator<r> CREATOR = new x();
    private final int j;
    @Nullable
    private List k;

    public r(int i, @Nullable List list) {
        this.j = i;
        this.k = list;
    }

    public final int g() {
        return this.j;
    }

    public final List i() {
        return this.k;
    }

    public final void j(l lVar) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(lVar);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, this.j);
        c.q(parcel, 2, this.k, false);
        c.b(parcel, a2);
    }
}
