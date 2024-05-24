package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import c.d.a.b.e.d.a;
import c.d.a.b.e.d.c;

public final class o1 extends a implements i {
    o1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    public final Account b() {
        Parcel h = h(2, i());
        Account account = (Account) c.a(h, Account.CREATOR);
        h.recycle();
        return account;
    }
}
