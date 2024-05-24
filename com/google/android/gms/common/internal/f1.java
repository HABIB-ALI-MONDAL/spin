package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.v.b;
import com.google.android.gms.common.internal.v.c;

public final class f1 implements Parcelable.Creator {
    static void a(f fVar, Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, fVar.j);
        c.i(parcel, 2, fVar.k);
        c.i(parcel, 3, fVar.l);
        c.n(parcel, 4, fVar.m, false);
        c.h(parcel, 5, fVar.n, false);
        c.p(parcel, 6, fVar.o, i, false);
        c.e(parcel, 7, fVar.p, false);
        c.m(parcel, 8, fVar.q, i, false);
        c.p(parcel, 10, fVar.r, i, false);
        c.p(parcel, 11, fVar.s, i, false);
        c.c(parcel, 12, fVar.t);
        c.i(parcel, 13, fVar.u);
        c.c(parcel, 14, fVar.v);
        c.n(parcel, 15, fVar.g(), false);
        c.b(parcel, a2);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int u = b.u(parcel);
        Scope[] scopeArr = f.x;
        Bundle bundle = new Bundle();
        d[] dVarArr = f.y;
        d[] dVarArr2 = dVarArr;
        String str = null;
        IBinder iBinder = null;
        Account account = null;
        String str2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            switch (b.i(n)) {
                case 1:
                    i = b.p(parcel2, n);
                    break;
                case 2:
                    i2 = b.p(parcel2, n);
                    break;
                case 3:
                    i3 = b.p(parcel2, n);
                    break;
                case 4:
                    str = b.d(parcel2, n);
                    break;
                case 5:
                    iBinder = b.o(parcel2, n);
                    break;
                case 6:
                    scopeArr = (Scope[]) b.f(parcel2, n, Scope.CREATOR);
                    break;
                case 7:
                    bundle = b.a(parcel2, n);
                    break;
                case 8:
                    account = (Account) b.c(parcel2, n, Account.CREATOR);
                    break;
                case 10:
                    dVarArr = (d[]) b.f(parcel2, n, d.CREATOR);
                    break;
                case 11:
                    dVarArr2 = (d[]) b.f(parcel2, n, d.CREATOR);
                    break;
                case 12:
                    z = b.j(parcel2, n);
                    break;
                case 13:
                    i4 = b.p(parcel2, n);
                    break;
                case 14:
                    z2 = b.j(parcel2, n);
                    break;
                case 15:
                    str2 = b.d(parcel2, n);
                    break;
                default:
                    b.t(parcel2, n);
                    break;
            }
        }
        b.h(parcel2, u);
        return new f(i, i2, i3, str, iBinder, scopeArr, bundle, account, dVarArr, dVarArr2, z, i4, z2, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new f[i];
    }
}
