package com.google.android.gms.common.api.internal;

import android.app.Activity;
import b.c.b;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.n;

public final class r extends e1 {
    private final b o = new b();
    private final e p;

    r(g gVar, e eVar, e eVar2) {
        super(gVar, eVar2);
        this.p = eVar;
        this.j.b("ConnectionlessLifecycleHelper", this);
    }

    public static void u(Activity activity, e eVar, b bVar) {
        g c2 = LifecycleCallback.c(activity);
        r rVar = (r) c2.d("ConnectionlessLifecycleHelper", r.class);
        if (rVar == null) {
            rVar = new r(c2, eVar, e.n());
        }
        n.j(bVar, "ApiKey cannot be null");
        rVar.o.add(bVar);
        eVar.c(rVar);
    }

    private final void v() {
        if (!this.o.isEmpty()) {
            this.p.c(this);
        }
    }

    public final void h() {
        super.h();
        v();
    }

    public final void j() {
        super.j();
        v();
    }

    public final void k() {
        super.k();
        this.p.d(this);
    }

    /* access modifiers changed from: protected */
    public final void m(com.google.android.gms.common.b bVar, int i) {
        this.p.F(bVar, i);
    }

    /* access modifiers changed from: protected */
    public final void n() {
        this.p.a();
    }

    /* access modifiers changed from: package-private */
    public final b t() {
        return this.o;
    }
}
