package com.google.android.gms.measurement.internal;

abstract class s5 extends r5 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f2537b;

    s5(x4 x4Var) {
        super(x4Var);
        this.f2527a.i();
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean j();

    /* access modifiers changed from: protected */
    public final void k() {
        if (!n()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void l() {
        if (this.f2537b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!j()) {
            this.f2527a.g();
            this.f2537b = true;
        }
    }

    public final void m() {
        if (!this.f2537b) {
            i();
            this.f2527a.g();
            this.f2537b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean n() {
        return this.f2537b;
    }
}
