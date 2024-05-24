package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.n;
import java.util.concurrent.atomic.AtomicReference;

final class y7 implements Runnable {
    final /* synthetic */ AtomicReference j;
    final /* synthetic */ qa k;
    final /* synthetic */ u8 l;

    y7(u8 u8Var, AtomicReference atomicReference, qa qaVar) {
        this.l = u8Var;
        this.j = atomicReference;
        this.k = qaVar;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.j) {
            try {
                if (!this.l.f2527a.F().q().i(i.ANALYTICS_STORAGE)) {
                    this.l.f2527a.f().x().a("Analytics storage consent denied; will not get app instance id");
                    this.l.f2527a.I().C((String) null);
                    this.l.f2527a.F().g.b((String) null);
                    this.j.set((Object) null);
                    this.j.notify();
                    return;
                }
                u8 u8Var = this.l;
                b3 H = u8Var.f2568d;
                if (H == null) {
                    u8Var.f2527a.f().r().a("Failed to get app instance id");
                    this.j.notify();
                    return;
                }
                n.i(this.k);
                this.j.set(H.N(this.k));
                String str = (String) this.j.get();
                if (str != null) {
                    this.l.f2527a.I().C(str);
                    this.l.f2527a.F().g.b(str);
                }
                this.l.E();
                atomicReference = this.j;
                atomicReference.notify();
            } catch (RemoteException e2) {
                try {
                    this.l.f2527a.f().r().b("Failed to get app instance id", e2);
                    atomicReference = this.j;
                } catch (Throwable th) {
                    this.j.notify();
                    throw th;
                }
            }
        }
    }
}
