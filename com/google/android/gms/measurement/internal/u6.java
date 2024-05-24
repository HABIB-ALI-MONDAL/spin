package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class u6 implements Runnable {
    final /* synthetic */ AtomicReference j;
    final /* synthetic */ e7 k;

    u6(e7 e7Var, AtomicReference atomicReference) {
        this.k = e7Var;
        this.j = atomicReference;
    }

    public final void run() {
        synchronized (this.j) {
            try {
                this.j.set(Long.valueOf(this.k.f2527a.z().r(this.k.f2527a.B().s(), y2.M)));
                this.j.notify();
            } catch (Throwable th) {
                this.j.notify();
                throw th;
            }
        }
    }
}
