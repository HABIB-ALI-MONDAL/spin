package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class o6 implements Runnable {
    final /* synthetic */ AtomicReference j;
    final /* synthetic */ String k;
    final /* synthetic */ String l;
    final /* synthetic */ e7 m;

    o6(e7 e7Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.m = e7Var;
        this.j = atomicReference;
        this.k = str2;
        this.l = str3;
    }

    public final void run() {
        this.m.f2527a.L().U(this.j, (String) null, this.k, this.l);
    }
}
