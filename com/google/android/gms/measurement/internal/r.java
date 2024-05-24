package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Handler;
import androidx.core.content.a;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class r extends s5 {

    /* renamed from: c  reason: collision with root package name */
    private long f2518c;

    /* renamed from: d  reason: collision with root package name */
    private String f2519d;

    /* renamed from: e  reason: collision with root package name */
    private AccountManager f2520e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f2521f;
    private long g;

    r(x4 x4Var) {
        super(x4Var);
    }

    /* access modifiers changed from: protected */
    public final boolean j() {
        Calendar instance = Calendar.getInstance();
        this.f2518c = TimeUnit.MINUTES.convert((long) (instance.get(15) + instance.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.f2519d = lowerCase + "-" + lowerCase2;
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long o() {
        h();
        return this.g;
    }

    public final long p() {
        k();
        return this.f2518c;
    }

    public final String q() {
        k();
        return this.f2519d;
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        h();
        this.f2521f = null;
        this.g = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean s() {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        h();
        long a2 = this.f2527a.a().a();
        if (a2 - this.g > 86400000) {
            this.f2521f = null;
        }
        Boolean bool3 = this.f2521f;
        if (bool3 != null) {
            return bool3.booleanValue();
        }
        if (a.a(this.f2527a.d(), "android.permission.GET_ACCOUNTS") != 0) {
            this.f2527a.f().y().a("Permission error checking for dasher/unicorn accounts");
        } else {
            if (this.f2520e == null) {
                this.f2520e = AccountManager.get(this.f2527a.d());
            }
            try {
                Account[] result = this.f2520e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, (AccountManagerCallback) null, (Handler) null).getResult();
                if (result == null || result.length <= 0) {
                    Account[] result2 = this.f2520e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, (AccountManagerCallback) null, (Handler) null).getResult();
                    if (result2 != null && result2.length > 0) {
                        this.f2521f = bool;
                        this.g = a2;
                        return true;
                    }
                } else {
                    this.f2521f = bool;
                    this.g = a2;
                    return true;
                }
            } catch (AuthenticatorException | OperationCanceledException | IOException e2) {
                this.f2527a.f().t().b("Exception checking account types", e2);
            }
        }
        this.g = a2;
        this.f2521f = bool2;
        return false;
    }
}
