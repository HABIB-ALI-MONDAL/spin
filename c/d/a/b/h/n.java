package c.d.a.b.h;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class n<T> implements o<T> {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f1833a = new CountDownLatch(1);

    /* synthetic */ n(m mVar) {
    }

    public final void a() {
        this.f1833a.countDown();
    }

    public final void b(Exception exc) {
        this.f1833a.countDown();
    }

    public final void c() {
        this.f1833a.await();
    }

    public final void d(T t) {
        this.f1833a.countDown();
    }

    public final boolean e(long j, TimeUnit timeUnit) {
        return this.f1833a.await(j, timeUnit);
    }
}
