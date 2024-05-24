package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import c.d.a.b.e.e.n1;
import com.google.android.gms.common.internal.n;

public final class h4 {

    /* renamed from: a  reason: collision with root package name */
    private final g4 f2396a;

    public h4(g4 g4Var) {
        n.i(g4Var);
        this.f2396a = g4Var;
    }

    public final void a(Context context, Intent intent) {
        x4 H = x4.H(context, (n1) null, (Long) null);
        m3 f2 = H.f();
        if (intent == null) {
            f2.w().a("Receiver called with null intent");
            return;
        }
        H.e();
        String action = intent.getAction();
        f2.v().b("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            f2.v().a("Starting wakeful intent.");
            this.f2396a.a(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            f2.w().a("Install Referrer Broadcasts are deprecated");
        }
    }
}
