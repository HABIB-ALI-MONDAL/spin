package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class p6 implements Runnable {
    final /* synthetic */ AtomicReference j;
    final /* synthetic */ e7 k;

    p6(e7 e7Var, AtomicReference atomicReference) {
        this.k = e7Var;
        this.j = atomicReference;
    }

    public final void run() {
        synchronized (this.j) {
            try {
                this.j.set(Boolean.valueOf(this.k.f2527a.z().B(this.k.f2527a.B().s(), y2.K)));
                this.j.notify();
            } catch (Throwable th) {
                this.j.notify();
                throw th;
            }
        }
    }
}
