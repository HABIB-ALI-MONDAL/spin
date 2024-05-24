package c.d.a.b.h;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class y implements d0 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1846a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f1847b = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public e f1848c;

    public y(Executor executor, e eVar) {
        this.f1846a = executor;
        this.f1848c = eVar;
    }

    public final void c(i iVar) {
        if (!iVar.m() && !iVar.k()) {
            synchronized (this.f1847b) {
                if (this.f1848c != null) {
                    this.f1846a.execute(new x(this, iVar));
                }
            }
        }
    }
}
