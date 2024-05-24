package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.n;

public final class x3 {

    /* renamed from: a  reason: collision with root package name */
    private final String f2621a;

    /* renamed from: b  reason: collision with root package name */
    private final long f2622b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2623c;

    /* renamed from: d  reason: collision with root package name */
    private long f2624d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ b4 f2625e;

    public x3(b4 b4Var, String str, long j) {
        this.f2625e = b4Var;
        n.e(str);
        this.f2621a = str;
        this.f2622b = j;
    }

    public final long a() {
        if (!this.f2623c) {
            this.f2623c = true;
            this.f2624d = this.f2625e.o().getLong(this.f2621a, this.f2622b);
        }
        return this.f2624d;
    }

    public final void b(long j) {
        SharedPreferences.Editor edit = this.f2625e.o().edit();
        edit.putLong(this.f2621a, j);
        edit.apply();
        this.f2624d = j;
    }
}
