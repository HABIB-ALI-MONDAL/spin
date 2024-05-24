package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class t6 implements Runnable {
    final /* synthetic */ AtomicReference j;
    final /* synthetic */ e7 k;

    t6(e7 e7Var, AtomicReference atomicReference) {
        this.k = e7Var;
        this.j = atomicReference;
    }

    public final void run() {
        synchronized (this.j) {
            try {
                this.j.set(this.k.f2527a.z().x(this.k.f2527a.B().s(), y2.L));
                this.j.notify();
            } catch (Throwable th) {
                this.j.notify();
                throw th;
            }
        }
    }
}
