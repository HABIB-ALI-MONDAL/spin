package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import c.d.a.b.e.e.tc;

final class j9 {

    /* renamed from: a  reason: collision with root package name */
    protected long f2421a;

    /* renamed from: b  reason: collision with root package name */
    protected long f2422b;

    /* renamed from: c  reason: collision with root package name */
    private final q f2423c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ l9 f2424d;

    public j9(l9 l9Var) {
        this.f2424d = l9Var;
        this.f2423c = new h9(this, l9Var.f2527a);
        long b2 = l9Var.f2527a.a().b();
        this.f2421a = b2;
        this.f2422b = b2;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f2423c.b();
        this.f2421a = 0;
        this.f2422b = 0;
    }

    /* access modifiers changed from: package-private */
    public final void b(long j) {
        this.f2423c.b();
    }

    /* access modifiers changed from: package-private */
    public final void c(long j) {
        this.f2424d.h();
        this.f2423c.b();
        this.f2421a = j;
        this.f2422b = j;
    }

    public final boolean d(boolean z, boolean z2, long j) {
        this.f2424d.h();
        this.f2424d.i();
        tc.c();
        if (!this.f2424d.f2527a.z().B((String) null, y2.e0) || this.f2424d.f2527a.o()) {
            this.f2424d.f2527a.F().o.b(this.f2424d.f2527a.a().a());
        }
        long j2 = j - this.f2421a;
        if (z || j2 >= 1000) {
            if (!z2) {
                j2 = j - this.f2422b;
                this.f2422b = j;
            }
            this.f2424d.f2527a.f().v().b("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            la.y(this.f2424d.f2527a.K().s(!this.f2424d.f2527a.z().D()), bundle, true);
            if (!z2) {
                this.f2424d.f2527a.I().u("auto", "_e", bundle);
            }
            this.f2421a = j;
            this.f2423c.b();
            this.f2423c.d(3600000);
            return true;
        }
        this.f2424d.f2527a.f().v().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }
}
