package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;

final class w7 implements Runnable {
    final /* synthetic */ qa j;
    final /* synthetic */ boolean k;
    final /* synthetic */ fa l;
    final /* synthetic */ u8 m;

    w7(u8 u8Var, qa qaVar, boolean z, fa faVar) {
        this.m = u8Var;
        this.j = qaVar;
        this.k = z;
        this.l = faVar;
    }

    public final void run() {
        u8 u8Var = this.m;
        b3 H = u8Var.f2568d;
        if (H == null) {
            u8Var.f2527a.f().r().a("Discarding data. Failed to set user property");
            return;
        }
        n.i(this.j);
        this.m.r(H, this.k ? null : this.l, this.j);
        this.m.E();
    }
}
