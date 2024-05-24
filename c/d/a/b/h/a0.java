package c.d.a.b.h;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class a0 implements d0 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1814a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f1815b = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public f f1816c;

    public a0(Executor executor, f fVar) {
        this.f1814a = executor;
        this.f1816c = fVar;
    }

    public final void c(i iVar) {
        if (iVar.m()) {
            synchronized (this.f1815b) {
                if (this.f1816c != null) {
                    this.f1814a.execute(new z(this, iVar));
                }
            }
        }
    }
}
