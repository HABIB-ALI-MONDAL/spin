package com.google.firebase.installations;

import c.d.a.b.h.j;
import com.google.firebase.installations.r.d;

class l implements o {

    /* renamed from: a  reason: collision with root package name */
    final j<String> f2777a;

    public l(j<String> jVar) {
        this.f2777a = jVar;
    }

    public boolean a(Exception exc) {
        return false;
    }

    public boolean b(d dVar) {
        if (!dVar.l() && !dVar.k() && !dVar.i()) {
            return false;
        }
        this.f2777a.e(dVar.d());
        return true;
    }
}
