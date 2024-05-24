package c.d.a.b.e.e;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class e2 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadFactory f1623a = Executors.defaultThreadFactory();

    e2(t2 t2Var) {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f1623a.newThread(runnable);
        newThread.setName("ScionFrontendApi");
        return newThread;
    }
}
