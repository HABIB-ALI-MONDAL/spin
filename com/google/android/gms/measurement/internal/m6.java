package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.n;

final class m6 implements Runnable {
    final /* synthetic */ Bundle j;
    final /* synthetic */ e7 k;

    m6(e7 e7Var, Bundle bundle) {
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
        String string2 = bundle.getString("origin");
        n.e(string);
        n.e(string2);
        n.i(bundle.get("value"));
        if (!e7Var.f2527a.o()) {
            e7Var.f2527a.f().v().a("Conditional property not set since app measurement is disabled");
            return;
        }
        fa faVar = new fa(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            x w0 = e7Var.f2527a.N().w0(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0, true, true);
            x w02 = e7Var.f2527a.N().w0(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0, true, true);
            x w03 = e7Var.f2527a.N().w0(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0, true, true);
            e7Var.f2527a.L().s(new d(bundle.getString("app_id"), string2, faVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), w02, bundle.getLong("trigger_timeout"), w0, bundle.getLong("time_to_live"), w03));
        } catch (IllegalArgumentException unused) {
        }
    }
}
