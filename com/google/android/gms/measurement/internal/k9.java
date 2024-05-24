package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import c.d.a.b.e.e.jc;
import c.d.a.b.e.e.sd;

final class k9 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l9 f2437a;

    k9(l9 l9Var) {
        this.f2437a = l9Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f2437a.h();
        if (this.f2437a.f2527a.F().v(this.f2437a.f2527a.a().a())) {
            this.f2437a.f2527a.F().l.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f2437a.f2527a.f().v().a("Detected application was in foreground");
                c(this.f2437a.f2527a.a().a(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(long j, boolean z) {
        this.f2437a.h();
        this.f2437a.s();
        if (this.f2437a.f2527a.F().v(j)) {
            this.f2437a.f2527a.F().l.a(true);
            sd.c();
            if (this.f2437a.f2527a.z().B((String) null, y2.j0)) {
                this.f2437a.f2527a.B().v();
            }
        }
        this.f2437a.f2527a.F().o.b(j);
        if (this.f2437a.f2527a.F().l.b()) {
            c(j, z);
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(long j, boolean z) {
        this.f2437a.h();
        if (this.f2437a.f2527a.o()) {
            this.f2437a.f2527a.F().o.b(j);
            this.f2437a.f2527a.f().v().b("Session started, time", Long.valueOf(this.f2437a.f2527a.a().b()));
            Long valueOf = Long.valueOf(j / 1000);
            this.f2437a.f2527a.I().M("auto", "_sid", valueOf, j);
            this.f2437a.f2527a.F().p.b(valueOf.longValue());
            this.f2437a.f2527a.F().l.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.f2437a.f2527a.z().B((String) null, y2.a0) && z) {
                bundle.putLong("_aib", 1);
            }
            this.f2437a.f2527a.I().v("auto", "_s", j, bundle);
            jc.c();
            if (this.f2437a.f2527a.z().B((String) null, y2.d0)) {
                String a2 = this.f2437a.f2527a.F().u.a();
                if (!TextUtils.isEmpty(a2)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_ffr", a2);
                    this.f2437a.f2527a.I().v("auto", "_ssr", j, bundle2);
                }
            }
        }
    }
}
