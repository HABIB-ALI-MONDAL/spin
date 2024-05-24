package com.google.firebase.installations;

import c.d.a.b.h.j;
import com.google.firebase.installations.m;
import com.google.firebase.installations.r.d;

class k implements o {

    /* renamed from: a  reason: collision with root package name */
    private final p f2775a;

    /* renamed from: b  reason: collision with root package name */
    private final j<m> f2776b;

    public k(p pVar, j<m> jVar) {
        this.f2775a = pVar;
        this.f2776b = jVar;
    }

    public boolean a(Exception exc) {
        this.f2776b.d(exc);
        return true;
    }

    public boolean b(d dVar) {
        if (!dVar.k() || this.f2775a.f(dVar)) {
            return false;
        }
        j<m> jVar = this.f2776b;
        m.a a2 = m.a();
        a2.b(dVar.b());
        a2.d(dVar.c());
        a2.c(dVar.h());
        jVar.c(a2.a());
        return true;
    }
}
