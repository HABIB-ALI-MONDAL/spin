package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import c.d.a.b.h.i;
import c.d.a.b.h.j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.b;
import com.google.android.gms.common.e;
import java.util.concurrent.CancellationException;

public final class h0 extends e1 {
    private j o = new j();

    private h0(g gVar) {
        super(gVar, e.n());
        this.j.b("GmsAvailabilityHelper", this);
    }

    public static h0 t(Activity activity) {
        g c2 = LifecycleCallback.c(activity);
        h0 h0Var = (h0) c2.d("GmsAvailabilityHelper", h0.class);
        if (h0Var == null) {
            return new h0(c2);
        }
        if (h0Var.o.a().l()) {
            h0Var.o = new j();
        }
        return h0Var;
    }

    public final void g() {
        super.g();
        this.o.d(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    /* access modifiers changed from: protected */
    public final void m(b bVar, int i) {
        String i2 = bVar.i();
        if (i2 == null) {
            i2 = "Error connecting to Google Play services";
        }
        this.o.b(new com.google.android.gms.common.api.b(new Status(bVar, i2, bVar.g())));
    }

    /* access modifiers changed from: protected */
    public final void n() {
        Activity e2 = this.j.e();
        if (e2 == null) {
            this.o.d(new com.google.android.gms.common.api.b(new Status(8)));
            return;
        }
        int g = this.n.g(e2);
        if (g == 0) {
            this.o.e(null);
        } else if (!this.o.a().l()) {
            s(new b(g, (PendingIntent) null), 0);
        }
    }

    public final i u() {
        return this.o.a();
    }
}
