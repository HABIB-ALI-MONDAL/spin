package com.google.android.gms.measurement.internal;

final class g9 {

    /* renamed from: a  reason: collision with root package name */
    private f9 f2384a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l9 f2385b;

    g9(l9 l9Var) {
        this.f2385b = l9Var;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j) {
        this.f2384a = new f9(this, this.f2385b.f2527a.a().a(), j);
        this.f2385b.f2451c.postDelayed(this.f2384a, 2000);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f2385b.h();
        f9 f9Var = this.f2384a;
        if (f9Var != null) {
            this.f2385b.f2451c.removeCallbacks(f9Var);
        }
        this.f2385b.f2527a.F().r.a(false);
    }
}
