package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.v.a;
import com.google.android.gms.common.internal.v.c;

public final class j0 extends a {
    public static final Parcelable.Creator<j0> CREATOR = new k0();
    final int j;
    private final Account k;
    private final int l;
    private final GoogleSignInAccount m;

    j0(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.j = i;
        this.k = account;
        this.l = i2;
        this.m = googleSignInAccount;
    }

    public j0(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = c.a(parcel);
        c.i(parcel, 1, this.j);
        c.m(parcel, 2, this.k, i, false);
        c.i(parcel, 3, this.l);
        c.m(parcel, 4, this.m, i, false);
        c.b(parcel, a2);
    }
}
