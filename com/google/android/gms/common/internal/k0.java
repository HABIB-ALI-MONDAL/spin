package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.v.b;

public final class k0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u = b.u(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < u) {
            int n = b.n(parcel);
            int i3 = b.i(n);
            if (i3 == 1) {
                i = b.p(parcel, n);
            } else if (i3 == 2) {
                account = (Account) b.c(parcel, n, Account.CREATOR);
            } else if (i3 == 3) {
                i2 = b.p(parcel, n);
            } else if (i3 != 4) {
                b.t(parcel, n);
            } else {
                googleSignInAccount = (GoogleSignInAccount) b.c(parcel, n, GoogleSignInAccount.CREATOR);
            }
        }
        b.h(parcel, u);
        return new j0(i, account, i2, googleSignInAccount);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new j0[i];
    }
}
