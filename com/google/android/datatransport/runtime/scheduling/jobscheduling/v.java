package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import c.d.a.a.i.a0.j.i0;
import c.d.a.a.i.a0.j.j0;
import c.d.a.a.i.w.a.b;
import com.google.android.datatransport.runtime.backends.e;
import d.a.a;
import java.util.concurrent.Executor;

public final class v implements b<u> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f2020a;

    /* renamed from: b  reason: collision with root package name */
    private final a<e> f2021b;

    /* renamed from: c  reason: collision with root package name */
    private final a<j0> f2022c;

    /* renamed from: d  reason: collision with root package name */
    private final a<y> f2023d;

    /* renamed from: e  reason: collision with root package name */
    private final a<Executor> f2024e;

    /* renamed from: f  reason: collision with root package name */
    private final a<c.d.a.a.i.b0.b> f2025f;
    private final a<c.d.a.a.i.c0.a> g;
    private final a<c.d.a.a.i.c0.a> h;
    private final a<i0> i;

    public v(a<Context> aVar, a<e> aVar2, a<j0> aVar3, a<y> aVar4, a<Executor> aVar5, a<c.d.a.a.i.b0.b> aVar6, a<c.d.a.a.i.c0.a> aVar7, a<c.d.a.a.i.c0.a> aVar8, a<i0> aVar9) {
        this.f2020a = aVar;
        this.f2021b = aVar2;
        this.f2022c = aVar3;
        this.f2023d = aVar4;
        this.f2024e = aVar5;
        this.f2025f = aVar6;
        this.g = aVar7;
        this.h = aVar8;
        this.i = aVar9;
    }

    public static v a(a<Context> aVar, a<e> aVar2, a<j0> aVar3, a<y> aVar4, a<Executor> aVar5, a<c.d.a.a.i.b0.b> aVar6, a<c.d.a.a.i.c0.a> aVar7, a<c.d.a.a.i.c0.a> aVar8, a<i0> aVar9) {
        return new v(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static u c(Context context, e eVar, j0 j0Var, y yVar, Executor executor, c.d.a.a.i.b0.b bVar, c.d.a.a.i.c0.a aVar, c.d.a.a.i.c0.a aVar2, i0 i0Var) {
        return new u(context, eVar, j0Var, yVar, executor, bVar, aVar, aVar2, i0Var);
    }

    /* renamed from: b */
    public u get() {
        return c(this.f2020a.get(), this.f2021b.get(), this.f2022c.get(), this.f2023d.get(), this.f2024e.get(), this.f2025f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
