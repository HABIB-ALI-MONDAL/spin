package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import c.d.a.b.e.e.i1;

final class e8 implements Runnable {
    final /* synthetic */ x j;
    final /* synthetic */ String k;
    final /* synthetic */ i1 l;
    final /* synthetic */ u8 m;

    e8(u8 u8Var, x xVar, String str, i1 i1Var) {
        this.m = u8Var;
        this.j = xVar;
        this.k = str;
        this.l = i1Var;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            u8 u8Var = this.m;
            b3 H = u8Var.f2568d;
            if (H == null) {
                u8Var.f2527a.f().r().a("Discarding data. Failed to send event to service to bundle");
            } else {
                bArr = H.H(this.j, this.k);
                this.m.E();
            }
        } catch (RemoteException e2) {
            this.m.f2527a.f().r().b("Failed to send event to the service to bundle", e2);
        } catch (Throwable th) {
            this.m.f2527a.N().G(this.l, bArr);
            throw th;
        }
        this.m.f2527a.N().G(this.l, bArr);
    }
}
