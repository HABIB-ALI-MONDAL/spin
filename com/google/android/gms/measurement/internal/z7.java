package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import c.d.a.b.e.e.i1;
import com.google.android.gms.common.internal.n;

final class z7 implements Runnable {
    final /* synthetic */ qa j;
    final /* synthetic */ i1 k;
    final /* synthetic */ u8 l;

    z7(u8 u8Var, qa qaVar, i1 i1Var) {
        this.l = u8Var;
        this.j = qaVar;
        this.k = i1Var;
    }

    public final void run() {
        String str = null;
        try {
            if (!this.l.f2527a.F().q().i(i.ANALYTICS_STORAGE)) {
                this.l.f2527a.f().x().a("Analytics storage consent denied; will not get app instance id");
                this.l.f2527a.I().C((String) null);
                this.l.f2527a.F().g.b((String) null);
            } else {
                u8 u8Var = this.l;
                b3 H = u8Var.f2568d;
                if (H == null) {
                    u8Var.f2527a.f().r().a("Failed to get app instance id");
                } else {
                    n.i(this.j);
                    str = H.N(this.j);
                    if (str != null) {
                        this.l.f2527a.I().C(str);
                        this.l.f2527a.F().g.b(str);
                    }
                    this.l.E();
                }
            }
        } catch (RemoteException e2) {
            this.l.f2527a.f().r().b("Failed to get app instance id", e2);
        } catch (Throwable th) {
            this.l.f2527a.N().J(this.k, (String) null);
            throw th;
        }
        this.l.f2527a.N().J(this.k, str);
    }
}
