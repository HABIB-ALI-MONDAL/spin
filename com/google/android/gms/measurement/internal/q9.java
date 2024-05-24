package com.google.android.gms.measurement.internal;

abstract class q9 extends p9 {

    /* renamed from: c  reason: collision with root package name */
    private boolean f2517c;

    q9(ca caVar) {
        super(caVar);
        this.f2504b.r();
    }

    /* access modifiers changed from: protected */
    public final void i() {
        if (!k()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void j() {
        if (!this.f2517c) {
            l();
            this.f2504b.m();
            this.f2517c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean k() {
        return this.f2517c;
    }

    /* access modifiers changed from: protected */
    public abstract boolean l();
}
