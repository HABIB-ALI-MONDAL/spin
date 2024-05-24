package com.google.android.gms.common.api.internal;

final class k1 implements Runnable {
    final /* synthetic */ LifecycleCallback j;
    final /* synthetic */ String k;
    final /* synthetic */ l1 l;

    k1(l1 l1Var, LifecycleCallback lifecycleCallback, String str) {
        this.l = l1Var;
        this.j = lifecycleCallback;
        this.k = str;
    }

    public final void run() {
        l1 l1Var = this.l;
        if (l1Var.i0 > 0) {
            this.j.f(l1Var.j0 != null ? l1Var.j0.getBundle(this.k) : null);
        }
        if (this.l.i0 >= 2) {
            this.j.j();
        }
        if (this.l.i0 >= 3) {
            this.j.h();
        }
        if (this.l.i0 >= 4) {
            this.j.k();
        }
        if (this.l.i0 >= 5) {
            this.j.g();
        }
    }
}
