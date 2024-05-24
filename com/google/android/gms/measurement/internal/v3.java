package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.n;

public final class v3 {

    /* renamed from: a  reason: collision with root package name */
    private final String f2581a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2582b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2583c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2584d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ b4 f2585e;

    public v3(b4 b4Var, String str, boolean z) {
        this.f2585e = b4Var;
        n.e(str);
        this.f2581a = str;
        this.f2582b = z;
    }

    public final void a(boolean z) {
        SharedPreferences.Editor edit = this.f2585e.o().edit();
        edit.putBoolean(this.f2581a, z);
        edit.apply();
        this.f2584d = z;
    }

    public final boolean b() {
        if (!this.f2583c) {
            this.f2583c = true;
            this.f2584d = this.f2585e.o().getBoolean(this.f2581a, this.f2582b);
        }
        return this.f2584d;
    }
}
