package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import c.d.a.b.a.a.a;
import com.google.android.gms.common.internal.n;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class b4 extends s5 {
    static final Pair y = new Pair("", 0L);

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f2315c;

    /* renamed from: d  reason: collision with root package name */
    public z3 f2316d;

    /* renamed from: e  reason: collision with root package name */
    public final x3 f2317e = new x3(this, "first_open_time", 0);

    /* renamed from: f  reason: collision with root package name */
    public final x3 f2318f = new x3(this, "app_install_time", 0);
    public final a4 g = new a4(this, "app_instance_id", (String) null);
    private String h;
    private boolean i;
    private long j;
    public final x3 k = new x3(this, "session_timeout", 1800000);
    public final v3 l = new v3(this, "start_new_session", true);
    public final a4 m = new a4(this, "non_personalized_ads", (String) null);
    public final v3 n = new v3(this, "allow_remote_dynamite", false);
    public final x3 o = new x3(this, "last_pause_time", 0);
    public final x3 p = new x3(this, "session_id", 0);
    public boolean q;
    public final v3 r = new v3(this, "app_backgrounded", false);
    public final v3 s = new v3(this, "deep_link_retrieval_complete", false);
    public final x3 t = new x3(this, "deep_link_retrieval_attempts", 0);
    public final a4 u = new a4(this, "firebase_feature_rollouts", (String) null);
    public final a4 v = new a4(this, "deferred_attribution_cache", (String) null);
    public final x3 w = new x3(this, "deferred_attribution_cache_timestamp", 0);
    public final w3 x = new w3(this, "default_event_parameters", (Bundle) null);

    b4(x4 x4Var) {
        super(x4Var);
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    public final void i() {
        SharedPreferences sharedPreferences = this.f2527a.d().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f2315c = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.q = z;
        if (!z) {
            SharedPreferences.Editor edit = this.f2315c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f2527a.z();
        this.f2316d = new z3(this, "health_monitor", Math.max(0, ((Long) y2.f2639c.a((Object) null)).longValue()), (y3) null);
    }

    /* access modifiers changed from: protected */
    public final boolean j() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences o() {
        h();
        k();
        n.i(this.f2315c);
        return this.f2315c;
    }

    /* access modifiers changed from: package-private */
    public final Pair p(String str) {
        h();
        long b2 = this.f2527a.a().b();
        String str2 = this.h;
        if (str2 != null && b2 < this.j) {
            return new Pair(str2, Boolean.valueOf(this.i));
        }
        this.j = b2 + this.f2527a.z().r(str, y2.f2638b);
        a.b(true);
        try {
            a.C0063a a2 = a.a(this.f2527a.d());
            this.h = "";
            String a3 = a2.a();
            if (a3 != null) {
                this.h = a3;
            }
            this.i = a2.b();
        } catch (Exception e2) {
            this.f2527a.f().q().b("Unable to get advertising id", e2);
            this.h = "";
        }
        a.b(false);
        return new Pair(this.h, Boolean.valueOf(this.i));
    }

    /* access modifiers changed from: package-private */
    public final j q() {
        h();
        return j.b(o().getString("consent_settings", "G1"));
    }

    /* access modifiers changed from: package-private */
    public final Boolean r() {
        h();
        if (o().contains("measurement_enabled")) {
            return Boolean.valueOf(o().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void s(Boolean bool) {
        h();
        SharedPreferences.Editor edit = o().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void t(boolean z) {
        h();
        this.f2527a.f().v().b("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = o().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean u() {
        SharedPreferences sharedPreferences = this.f2315c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    public final boolean v(long j2) {
        return j2 - this.k.a() > this.o.a();
    }

    /* access modifiers changed from: package-private */
    public final boolean w(int i2) {
        return j.j(i2, o().getInt("consent_source", 100));
    }
}
