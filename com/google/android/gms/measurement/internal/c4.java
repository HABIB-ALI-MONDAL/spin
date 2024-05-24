package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.os.Bundle;
import c.d.a.b.e.e.t0;

final class c4 implements Runnable {
    final /* synthetic */ t0 j;
    final /* synthetic */ ServiceConnection k;
    final /* synthetic */ d4 l;

    c4(d4 d4Var, t0 t0Var, ServiceConnection serviceConnection) {
        this.l = d4Var;
        this.j = t0Var;
        this.k = serviceConnection;
    }

    public final void run() {
        d4 d4Var = this.l;
        e4 e4Var = d4Var.f2354b;
        String a2 = d4Var.f2353a;
        t0 t0Var = this.j;
        e4Var.f2364a.c().h();
        Bundle bundle = new Bundle();
        bundle.putString("package_name", a2);
        try {
            if (t0Var.D(bundle) == null) {
                e4Var.f2364a.f().r().a("Install Referrer Service returned a null response");
            }
        } catch (Exception e2) {
            e4Var.f2364a.f().r().b("Exception occurred while retrieving the Install Referrer", e2.getMessage());
        }
        e4Var.f2364a.c().h();
        x4.t();
        throw null;
    }
}
