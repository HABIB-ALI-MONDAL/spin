package c.d.a.b.h;

import android.os.Handler;
import android.os.Looper;
import c.d.a.b.e.g.a;
import java.util.concurrent.Executor;

final class g0 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f1823a = new a(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.f1823a.post(runnable);
    }
}
