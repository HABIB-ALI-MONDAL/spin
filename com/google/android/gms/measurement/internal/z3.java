package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.n;

public final class z3 {

    /* renamed from: a  reason: collision with root package name */
    final String f2651a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2652b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2653c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2654d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ b4 f2655e;

    /* synthetic */ z3(b4 b4Var, String str, long j, y3 y3Var) {
        this.f2655e = b4Var;
        n.e("health_monitor");
        n.a(j > 0);
        this.f2651a = "health_monitor:start";
        this.f2652b = "health_monitor:count";
        this.f2653c = "health_monitor:value";
        this.f2654d = j;
    }

    private final long c() {
        return this.f2655e.o().getLong(this.f2651a, 0);
    }

    private final void d() {
        this.f2655e.h();
        long a2 = this.f2655e.f2527a.a().a();
        SharedPreferences.Editor edit = this.f2655e.o().edit();
        edit.remove(this.f2652b);
        edit.remove(this.f2653c);
        edit.putLong(this.f2651a, a2);
        edit.apply();
    }

    public final Pair a() {
        long j;
        this.f2655e.h();
        this.f2655e.h();
        long c2 = c();
        if (c2 == 0) {
            d();
            j = 0;
        } else {
            j = Math.abs(c2 - this.f2655e.f2527a.a().a());
        }
        long j2 = this.f2654d;
        if (j < j2) {
            return null;
        }
        if (j > j2 + j2) {
            d();
            return null;
        }
        String string = this.f2655e.o().getString(this.f2653c, (String) null);
        long j3 = this.f2655e.o().getLong(this.f2652b, 0);
        d();
        return (string == null || j3 <= 0) ? b4.y : new Pair(string, Long.valueOf(j3));
    }

    public final void b(String str, long j) {
        this.f2655e.h();
        if (c() == 0) {
            d();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.f2655e.o().getLong(this.f2652b, 0);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.f2655e.o().edit();
            edit.putString(this.f2653c, str);
            edit.putLong(this.f2652b, 1);
            edit.apply();
            return;
        }
        long nextLong = this.f2655e.f2527a.N().u().nextLong();
        long j3 = j2 + 1;
        SharedPreferences.Editor edit2 = this.f2655e.o().edit();
        if ((nextLong & Long.MAX_VALUE) < Long.MAX_VALUE / j3) {
            edit2.putString(this.f2653c, str);
        }
        edit2.putLong(this.f2652b, j3);
        edit2.apply();
    }
}
