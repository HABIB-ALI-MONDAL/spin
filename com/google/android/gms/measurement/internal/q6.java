package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class q6 implements Runnable {
    final /* synthetic */ AtomicReference j;
    final /* synthetic */ String k;
    final /* synthetic */ String l;
    final /* synthetic */ boolean m;
    final /* synthetic */ e7 n;

    q6(e7 e7Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.n = e7Var;
        this.j = atomicReference;
        this.k = str2;
        this.l = str3;
        this.m = z;
    }

    public final void run() {
        this.n.f2527a.L().W(this.j, (String) null, this.k, this.l, this.m);
    }
}
