package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.n;

final class g8 implements Runnable {
    final /* synthetic */ qa j;
    final /* synthetic */ u8 k;

    g8(u8 u8Var, qa qaVar) {
        this.k = u8Var;
        this.j = qaVar;
    }

    public final void run() {
        u8 u8Var = this.k;
        b3 H = u8Var.f2568d;
        if (H == null) {
            u8Var.f2527a.f().r().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            n.i(this.j);
            H.u(this.j);
            this.k.E();
        } catch (RemoteException e2) {
            this.k.f2527a.f().r().b("Failed to send measurementEnabled to the service", e2);
        }
    }
}
