package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class b8 implements Runnable {
    final /* synthetic */ m7 j;
    final /* synthetic */ u8 k;

    b8(u8 u8Var, m7 m7Var) {
        this.k = u8Var;
        this.j = m7Var;
    }

    public final void run() {
        u8 u8Var = this.k;
        b3 H = u8Var.f2568d;
        if (H == null) {
            u8Var.f2527a.f().r().a("Failed to send current screen to service");
            return;
        }
        try {
            m7 m7Var = this.j;
            if (m7Var == null) {
                H.n(0, (String) null, (String) null, u8Var.f2527a.d().getPackageName());
            } else {
                H.n(m7Var.f2468c, m7Var.f2466a, m7Var.f2467b, u8Var.f2527a.d().getPackageName());
            }
            this.k.E();
        } catch (RemoteException e2) {
            this.k.f2527a.f().r().b("Failed to send current screen to the service", e2);
        }
    }
}
