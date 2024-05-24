package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import c.d.a.b.e.e.a1;

public final class l9 extends f4 {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Handler f2451c;

    /* renamed from: d  reason: collision with root package name */
    protected final k9 f2452d = new k9(this);

    /* renamed from: e  reason: collision with root package name */
    protected final j9 f2453e = new j9(this);

    /* renamed from: f  reason: collision with root package name */
    protected final g9 f2454f = new g9(this);

    l9(x4 x4Var) {
        super(x4Var);
    }

    static /* bridge */ /* synthetic */ void q(l9 l9Var, long j) {
        l9Var.h();
        l9Var.s();
        l9Var.f2527a.f().v().b("Activity paused, time", Long.valueOf(j));
        l9Var.f2454f.a(j);
        if (l9Var.f2527a.z().D()) {
            l9Var.f2453e.b(j);
        }
    }

    static /* bridge */ /* synthetic */ void r(l9 l9Var, long j) {
        l9Var.h();
        l9Var.s();
        l9Var.f2527a.f().v().b("Activity resumed, time", Long.valueOf(j));
        if (l9Var.f2527a.z().D() || l9Var.f2527a.F().r.b()) {
            l9Var.f2453e.c(j);
        }
        l9Var.f2454f.b();
        k9 k9Var = l9Var.f2452d;
        k9Var.f2437a.h();
        if (k9Var.f2437a.f2527a.o()) {
            k9Var.b(k9Var.f2437a.f2527a.a().a(), false);
        }
    }

    /* access modifiers changed from: private */
    public final void s() {
        h();
        if (this.f2451c == null) {
            this.f2451c = new a1(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean n() {
        return false;
    }
}
