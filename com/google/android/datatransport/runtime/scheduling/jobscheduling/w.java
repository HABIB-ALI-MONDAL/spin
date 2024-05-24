package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import c.d.a.a.i.a0.j.j0;
import c.d.a.a.i.b0.b;
import c.d.a.a.i.p;
import java.util.concurrent.Executor;

public class w {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f2026a;

    /* renamed from: b  reason: collision with root package name */
    private final j0 f2027b;

    /* renamed from: c  reason: collision with root package name */
    private final y f2028c;

    /* renamed from: d  reason: collision with root package name */
    private final b f2029d;

    w(Executor executor, j0 j0Var, y yVar, b bVar) {
        this.f2026a = executor;
        this.f2027b = j0Var;
        this.f2028c = yVar;
        this.f2029d = bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ Object c() {
        for (p a2 : this.f2027b.m()) {
            this.f2028c.a(a2, 1);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e() {
        this.f2029d.f(new m(this));
    }

    public void a() {
        this.f2026a.execute(new n(this));
    }
}
