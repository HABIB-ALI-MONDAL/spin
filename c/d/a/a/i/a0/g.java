package c.d.a.a.i.a0;

import c.d.a.a.i.w.a.b;
import c.d.a.a.i.w.a.d;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import d.a.a;

public final class g implements b<t> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c.d.a.a.i.c0.a> f1317a;

    public g(a<c.d.a.a.i.c0.a> aVar) {
        this.f1317a = aVar;
    }

    public static t a(c.d.a.a.i.c0.a aVar) {
        t a2 = f.a(aVar);
        d.c(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    public static g b(a<c.d.a.a.i.c0.a> aVar) {
        return new g(aVar);
    }

    /* renamed from: c */
    public t get() {
        return a(this.f1317a.get());
    }
}
