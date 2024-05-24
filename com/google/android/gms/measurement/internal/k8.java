package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;

final class k8 implements Runnable {
    final /* synthetic */ qa j;
    final /* synthetic */ boolean k;
    final /* synthetic */ d l;
    final /* synthetic */ u8 m;

    k8(u8 u8Var, boolean z, qa qaVar, boolean z2, d dVar, d dVar2) {
        this.m = u8Var;
        this.j = qaVar;
        this.k = z2;
        this.l = dVar;
    }

    public final void run() {
        u8 u8Var = this.m;
        b3 H = u8Var.f2568d;
        if (H == null) {
            u8Var.f2527a.f().r().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        n.i(this.j);
        this.m.r(H, this.k ? null : this.l, this.j);
        this.m.E();
    }
}
