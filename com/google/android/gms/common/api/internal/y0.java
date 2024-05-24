package com.google.android.gms.common.api.internal;

import c.d.a.b.h.j;
import com.google.android.gms.common.d;

public final class y0 extends u0 {

    /* renamed from: c  reason: collision with root package name */
    public final h f2143c;

    public y0(h hVar, j jVar) {
        super(4, jVar);
        this.f2143c = hVar;
    }

    public final /* bridge */ /* synthetic */ void d(q qVar, boolean z) {
    }

    public final boolean f(z zVar) {
        n0 n0Var = (n0) zVar.x().get(this.f2143c);
        if (n0Var == null) {
            return false;
        }
        n0Var.f2118a.d();
        throw null;
    }

    public final d[] g(z zVar) {
        n0 n0Var = (n0) zVar.x().get(this.f2143c);
        if (n0Var == null) {
            return null;
        }
        return n0Var.f2118a.b();
    }

    public final void h(z zVar) {
        n0 n0Var = (n0) zVar.x().remove(this.f2143c);
        if (n0Var != null) {
            n0Var.f2119b.a(zVar.v(), this.f2136b);
            n0Var.f2118a.a();
            return;
        }
        this.f2136b.e(Boolean.FALSE);
    }
}
