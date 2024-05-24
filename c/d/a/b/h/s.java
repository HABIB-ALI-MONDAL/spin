package c.d.a.b.h;

import java.util.concurrent.Executor;

final class s<TResult, TContinuationResult> implements f<TContinuationResult>, e, c, d0 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1837a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a f1838b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final h0 f1839c;

    public s(Executor executor, a aVar, h0 h0Var) {
        this.f1837a = executor;
        this.f1838b = aVar;
        this.f1839c = h0Var;
    }

    public final void a() {
        this.f1839c.r();
    }

    public final void b(Exception exc) {
        this.f1839c.p(exc);
    }

    public final void c(i iVar) {
        this.f1837a.execute(new r(this, iVar));
    }

    public final void d(TContinuationResult tcontinuationresult) {
        this.f1839c.q(tcontinuationresult);
    }
}
