package c.d.a.b.h;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class w implements d0 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1843a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f1844b = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public d f1845c;

    public w(Executor executor, d dVar) {
        this.f1843a = executor;
        this.f1845c = dVar;
    }

    public final void c(i iVar) {
        synchronized (this.f1844b) {
            if (this.f1845c != null) {
                this.f1843a.execute(new v(this, iVar));
            }
        }
    }
}
