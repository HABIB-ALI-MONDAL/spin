package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.n;

public final class a4 {

    /* renamed from: a  reason: collision with root package name */
    private final String f2305a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2306b;

    /* renamed from: c  reason: collision with root package name */
    private String f2307c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ b4 f2308d;

    public a4(b4 b4Var, String str, String str2) {
        this.f2308d = b4Var;
        n.e(str);
        this.f2305a = str;
    }

    public final String a() {
        if (!this.f2306b) {
            this.f2306b = true;
            this.f2307c = this.f2308d.o().getString(this.f2305a, (String) null);
        }
        return this.f2307c;
    }

    public final void b(String str) {
        SharedPreferences.Editor edit = this.f2308d.o().edit();
        edit.putString(this.f2305a, str);
        edit.apply();
        this.f2307c = str;
    }
}
