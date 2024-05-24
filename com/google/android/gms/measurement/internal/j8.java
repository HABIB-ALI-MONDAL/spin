package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;

final class j8 implements Runnable {
    final /* synthetic */ qa j;
    final /* synthetic */ boolean k;
    final /* synthetic */ x l;
    final /* synthetic */ u8 m;

    j8(u8 u8Var, boolean z, qa qaVar, boolean z2, x xVar, String str) {
        this.m = u8Var;
        this.j = qaVar;
        this.k = z2;
        this.l = xVar;
    }

    public final void run() {
        u8 u8Var = this.m;
        b3 H = u8Var.f2568d;
        if (H == null) {
            u8Var.f2527a.f().r().a("Discarding data. Failed to send event to service");
            return;
        }
        n.i(this.j);
        this.m.r(H, this.k ? null : this.l, this.j);
        this.m.E();
    }
}
