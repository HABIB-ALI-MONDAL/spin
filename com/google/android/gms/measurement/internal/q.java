package com.google.android.gms.measurement.internal;

import android.os.Handler;
import c.d.a.b.e.e.a1;
import com.google.android.gms.common.internal.n;

abstract class q {

    /* renamed from: d  reason: collision with root package name */
    private static volatile Handler f2507d;

    /* renamed from: a  reason: collision with root package name */
    private final t5 f2508a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f2509b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile long f2510c;

    q(t5 t5Var) {
        n.i(t5Var);
        this.f2508a = t5Var;
        this.f2509b = new p(this, t5Var);
    }

    private final Handler f() {
        Handler handler;
        if (f2507d != null) {
            return f2507d;
        }
        synchronized (q.class) {
            if (f2507d == null) {
                f2507d = new a1(this.f2508a.d().getMainLooper());
            }
            handler = f2507d;
        }
        return handler;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f2510c = 0;
        f().removeCallbacks(this.f2509b);
    }

    public abstract void c();

    public final void d(long j) {
        b();
        if (j >= 0) {
            this.f2510c = this.f2508a.a().a();
            if (!f().postDelayed(this.f2509b, j)) {
                this.f2508a.f().r().b("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean e() {
        return this.f2510c != 0;
    }
}
