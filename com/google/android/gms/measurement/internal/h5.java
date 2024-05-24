package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;

final class h5 implements Runnable {
    final /* synthetic */ qa j;
    final /* synthetic */ q5 k;

    h5(q5 q5Var, qa qaVar) {
        this.k = q5Var;
        this.j = qaVar;
    }

    public final void run() {
        this.k.f2514a.b();
        ca b0 = this.k.f2514a;
        qa qaVar = this.j;
        b0.c().h();
        b0.g();
        n.e(qaVar.j);
        b0.S(qaVar);
    }
}
