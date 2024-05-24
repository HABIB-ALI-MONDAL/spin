package c.d.a.b.h;

import java.util.concurrent.Executor;

final class q implements d0 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1834a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a f1835b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final h0 f1836c;

    public q(Executor executor, a aVar, h0 h0Var) {
        this.f1834a = executor;
        this.f1835b = aVar;
        this.f1836c = h0Var;
    }

    public final void c(i iVar) {
        this.f1834a.execute(new p(this, iVar));
    }
}
