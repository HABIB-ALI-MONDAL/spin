package com.google.android.gms.common.api.internal;

import c.d.a.b.h.j;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.d;

public abstract class n<A extends a.b, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final d[] f2111a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2112b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2113c;

    public static class a<A extends a.b, ResultT> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public l f2114a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2115b = true;

        /* renamed from: c  reason: collision with root package name */
        private d[] f2116c;

        /* renamed from: d  reason: collision with root package name */
        private int f2117d = 0;

        /* synthetic */ a(t0 t0Var) {
        }

        public n<A, ResultT> a() {
            com.google.android.gms.common.internal.n.b(this.f2114a != null, "execute parameter required");
            return new s0(this, this.f2116c, this.f2115b, this.f2117d);
        }

        public a<A, ResultT> b(l<A, j<ResultT>> lVar) {
            this.f2114a = lVar;
            return this;
        }

        public a<A, ResultT> c(boolean z) {
            this.f2115b = z;
            return this;
        }

        public a<A, ResultT> d(d... dVarArr) {
            this.f2116c = dVarArr;
            return this;
        }
    }

    protected n(d[] dVarArr, boolean z, int i) {
        this.f2111a = dVarArr;
        boolean z2 = false;
        if (dVarArr != null && z) {
            z2 = true;
        }
        this.f2112b = z2;
        this.f2113c = i;
    }

    public static <A extends a.b, ResultT> a<A, ResultT> a() {
        return new a<>((t0) null);
    }

    /* access modifiers changed from: protected */
    public abstract void b(A a2, j<ResultT> jVar);

    public boolean c() {
        return this.f2112b;
    }

    public final int d() {
        return this.f2113c;
    }

    public final d[] e() {
        return this.f2111a;
    }
}
