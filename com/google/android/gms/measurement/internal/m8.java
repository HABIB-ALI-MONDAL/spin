package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import c.d.a.b.e.e.i1;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;

final class m8 implements Runnable {
    final /* synthetic */ String j;
    final /* synthetic */ String k;
    final /* synthetic */ qa l;
    final /* synthetic */ i1 m;
    final /* synthetic */ u8 n;

    m8(u8 u8Var, String str, String str2, qa qaVar, i1 i1Var) {
        this.n = u8Var;
        this.j = str;
        this.k = str2;
        this.l = qaVar;
        this.m = i1Var;
    }

    public final void run() {
        ArrayList arrayList = new ArrayList();
        try {
            u8 u8Var = this.n;
            b3 H = u8Var.f2568d;
            if (H == null) {
                u8Var.f2527a.f().r().c("Failed to get conditional properties; not connected to service", this.j, this.k);
            } else {
                n.i(this.l);
                arrayList = la.v(H.W(this.j, this.k, this.l));
                this.n.E();
            }
        } catch (RemoteException e2) {
            this.n.f2527a.f().r().d("Failed to get conditional properties; remote exception", this.j, this.k, e2);
        } catch (Throwable th) {
            this.n.f2527a.N().E(this.m, arrayList);
            throw th;
        }
        this.n.f2527a.N().E(this.m, arrayList);
    }
}
