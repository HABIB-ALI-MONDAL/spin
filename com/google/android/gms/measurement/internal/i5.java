package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;

final class i5 implements Runnable {
    final /* synthetic */ qa j;
    final /* synthetic */ q5 k;

    i5(q5 q5Var, qa qaVar) {
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
        j b2 = j.b(qaVar.E);
        j U = b0.U(qaVar.j);
        b0.f().v().c("Setting consent, package, consent", qaVar.j, b2);
        b0.A(qaVar.j, b2);
        if (b2.k(U)) {
            b0.v(qaVar);
        }
    }
}
