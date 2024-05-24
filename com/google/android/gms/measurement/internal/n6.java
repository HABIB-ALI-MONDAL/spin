package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.n;

final class n6 implements Runnable {
    final /* synthetic */ Bundle j;
    final /* synthetic */ e7 k;

    n6(e7 e7Var, Bundle bundle) {
        this.k = e7Var;
        this.j = bundle;
    }

    public final void run() {
        e7 e7Var = this.k;
        Bundle bundle = this.j;
        e7Var.h();
        e7Var.i();
        n.i(bundle);
        String string = bundle.getString("name");
        n.e(string);
        if (!e7Var.f2527a.o()) {
            e7Var.f2527a.f().v().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        fa faVar = new fa(string, 0, (Object) null, "");
        try {
            d dVar = r4;
            d dVar2 = new d(bundle.getString("app_id"), "", faVar, bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), (x) null, bundle.getLong("trigger_timeout"), (x) null, bundle.getLong("time_to_live"), e7Var.f2527a.N().w0(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true));
            e7Var.f2527a.L().s(dVar);
        } catch (IllegalArgumentException unused) {
        }
    }
}
