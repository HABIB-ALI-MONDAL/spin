package c.d.a.b.h;

import java.util.concurrent.Executor;

final class c0<TResult, TContinuationResult> implements f<TContinuationResult>, e, c, d0 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1817a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final h f1818b;

    /* renamed from: c  reason: collision with root package name */
    private final h0 f1819c;

    public c0(Executor executor, h hVar, h0 h0Var) {
        this.f1817a = executor;
        this.f1818b = hVar;
        this.f1819c = h0Var;
    }

    public final void a() {
        this.f1819c.r();
    }

    public final void b(Exception exc) {
        this.f1819c.p(exc);
    }

    public final void c(i iVar) {
        this.f1817a.execute(new b0(this, iVar));
    }

    public final void d(TContinuationResult tcontinuationresult) {
        this.f1819c.q(tcontinuationresult);
    }
}
