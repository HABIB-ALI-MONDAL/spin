package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.m;

final class b0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f2069a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d f2070b;

    /* synthetic */ b0(b bVar, d dVar, a0 a0Var) {
        this.f2069a = bVar;
        this.f2070b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof b0)) {
            b0 b0Var = (b0) obj;
            return m.a(this.f2069a, b0Var.f2069a) && m.a(this.f2070b, b0Var.f2070b);
        }
    }

    public final int hashCode() {
        return m.b(this.f2069a, this.f2070b);
    }

    public final String toString() {
        m.a c2 = m.c(this);
        c2.a("key", this.f2069a);
        c2.a("feature", this.f2070b);
        return c2.toString();
    }
}
