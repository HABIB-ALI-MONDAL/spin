package c.d.a.a.i;

import c.d.a.a.i.w.a.b;
import c.d.a.a.i.w.a.d;
import java.util.concurrent.Executor;

public final class l implements b<Executor> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final l f1456a = new l();
    }

    public static l a() {
        return a.f1456a;
    }

    public static Executor b() {
        Executor a2 = k.a();
        d.c(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    /* renamed from: c */
    public Executor get() {
        return b();
    }
}
