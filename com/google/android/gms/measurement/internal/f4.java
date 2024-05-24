package com.google.android.gms.measurement.internal;

abstract class f4 extends e3 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f2379b;

    f4(x4 x4Var) {
        super(x4Var);
        this.f2527a.i();
    }

    /* access modifiers changed from: protected */
    public final void i() {
        if (!m()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void j() {
        if (this.f2379b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!n()) {
            this.f2527a.g();
            this.f2379b = true;
        }
    }

    public final void k() {
        if (!this.f2379b) {
            l();
            this.f2527a.g();
            this.f2379b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public void l() {
    }

    /* access modifiers changed from: package-private */
    public final boolean m() {
        return this.f2379b;
    }

    /* access modifiers changed from: protected */
    public abstract boolean n();
}
