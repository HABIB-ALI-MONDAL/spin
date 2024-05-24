package com.google.android.gms.measurement.internal;

import java.util.Iterator;

final class u implements Iterator {
    final Iterator j;
    final /* synthetic */ v k;

    u(v vVar) {
        this.k = vVar;
        this.j = vVar.j.keySet().iterator();
    }

    /* renamed from: b */
    public final String next() {
        return (String) this.j.next();
    }

    public final boolean hasNext() {
        return this.j.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
