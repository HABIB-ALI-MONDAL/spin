package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.n;

final class c8 implements Runnable {
    final /* synthetic */ qa j;
    final /* synthetic */ Bundle k;
    final /* synthetic */ u8 l;

    c8(u8 u8Var, qa qaVar, Bundle bundle) {
        this.l = u8Var;
        this.j = qaVar;
        this.k = bundle;
    }

    public final void run() {
        u8 u8Var = this.l;
        b3 H = u8Var.f2568d;
        if (H == null) {
            u8Var.f2527a.f().r().a("Failed to send default event parameters to service");
            return;
        }
        try {
            n.i(this.j);
            H.z(this.k, this.j);
        } catch (RemoteException e2) {
            this.l.f2527a.f().r().b("Failed to send default event parameters to service", e2);
        }
    }
}
