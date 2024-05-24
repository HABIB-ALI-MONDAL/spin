package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class l6 implements Runnable {
    final /* synthetic */ long j;
    final /* synthetic */ e7 k;

    l6(e7 e7Var, long j2) {
        this.k = e7Var;
        this.j = j2;
    }

    public final void run() {
        this.k.z(this.j, true);
        this.k.f2527a.L().S(new AtomicReference());
    }
}
