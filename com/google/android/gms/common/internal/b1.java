package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.b;

public final class b1 extends n0 {
    final /* synthetic */ c g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b1(c cVar, int i, Bundle bundle) {
        super(cVar, i, (Bundle) null);
        this.g = cVar;
    }

    /* access modifiers changed from: protected */
    public final void f(b bVar) {
        if (!this.g.t() || !c.h0(this.g)) {
            this.g.j.a(bVar);
            this.g.L(bVar);
            return;
        }
        c.d0(this.g, 16);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        this.g.j.a(b.n);
        return true;
    }
}
