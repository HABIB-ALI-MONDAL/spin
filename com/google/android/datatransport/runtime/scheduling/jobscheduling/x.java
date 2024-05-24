package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import c.d.a.a.i.a0.j.j0;
import c.d.a.a.i.w.a.b;
import d.a.a;
import java.util.concurrent.Executor;

public final class x implements b<w> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Executor> f2030a;

    /* renamed from: b  reason: collision with root package name */
    private final a<j0> f2031b;

    /* renamed from: c  reason: collision with root package name */
    private final a<y> f2032c;

    /* renamed from: d  reason: collision with root package name */
    private final a<c.d.a.a.i.b0.b> f2033d;

    public x(a<Executor> aVar, a<j0> aVar2, a<y> aVar3, a<c.d.a.a.i.b0.b> aVar4) {
        this.f2030a = aVar;
        this.f2031b = aVar2;
        this.f2032c = aVar3;
        this.f2033d = aVar4;
    }

    public static x a(a<Executor> aVar, a<j0> aVar2, a<y> aVar3, a<c.d.a.a.i.b0.b> aVar4) {
        return new x(aVar, aVar2, aVar3, aVar4);
    }

    public static w c(Executor executor, j0 j0Var, y yVar, c.d.a.a.i.b0.b bVar) {
        return new w(executor, j0Var, yVar, bVar);
    }

    /* renamed from: b */
    public w get() {
        return c(this.f2030a.get(), this.f2031b.get(), this.f2032c.get(), this.f2033d.get());
    }
}
