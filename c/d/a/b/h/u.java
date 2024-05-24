package c.d.a.b.h;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class u implements d0 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1840a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f1841b = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public c f1842c;

    public u(Executor executor, c cVar) {
        this.f1840a = executor;
        this.f1842c = cVar;
    }

    public final void c(i iVar) {
        if (iVar.k()) {
            synchronized (this.f1841b) {
                if (this.f1842c != null) {
                    this.f1840a.execute(new t(this));
                }
            }
        }
    }
}
