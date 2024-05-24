package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.v.a;

public class f extends a {
    public static final Parcelable.Creator<f> CREATOR = new f1();
    static final Scope[] x = new Scope[0];
    static final d[] y = new d[0];
    final int j;
    final int k;
    int l;
    String m;
    IBinder n;
    Scope[] o;
    Bundle p;
    Account q;
    d[] r;
    d[] s;
    boolean t;
    int u;
    boolean v;
    private String w;

    f(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, d[] dVarArr, d[] dVarArr2, boolean z, int i4, boolean z2, String str2) {
        scopeArr = scopeArr == null ? x : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        dVarArr = dVarArr == null ? y : dVarArr;
        dVarArr2 = dVarArr2 == null ? y : dVarArr2;
        this.j = i;
        this.k = i2;
        this.l = i3;
        if ("com.google.android.gms".equals(str)) {
            this.m = "com.google.android.gms";
        } else {
            this.m = str;
        }
        if (i < 2) {
            this.q = iBinder != null ? a.k(i.a.i(iBinder)) : null;
        } else {
            this.n = iBinder;
            this.q = account;
        }
        this.o = scopeArr;
        this.p = bundle;
        this.r = dVarArr;
        this.s = dVarArr2;
        this.t = z;
        this.u = i4;
        this.v = z2;
        this.w = str2;
    }

    public final String g() {
        return this.w;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        f1.a(this, parcel, i);
    }
}
