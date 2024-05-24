package com.google.android.gms.common.api.internal;

final class i1 implements Runnable {
    final /* synthetic */ LifecycleCallback j;
    final /* synthetic */ String k;
    final /* synthetic */ j1 l;

    i1(j1 j1Var, LifecycleCallback lifecycleCallback, String str) {
        this.l = j1Var;
        this.j = lifecycleCallback;
        this.k = str;
    }

    public final void run() {
        j1 j1Var = this.l;
        if (j1Var.k > 0) {
            this.j.f(j1Var.l != null ? j1Var.l.getBundle(this.k) : null);
        }
        if (this.l.k >= 2) {
            this.j.j();
        }
        if (this.l.k >= 3) {
            this.j.h();
        }
        if (this.l.k >= 4) {
            this.j.k();
        }
        if (this.l.k >= 5) {
            this.j.g();
        }
    }
}
