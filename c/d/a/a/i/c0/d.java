package c.d.a.a.i.c0;

import c.d.a.a.i.w.a.b;

public final class d implements b<a> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final d f1434a = new d();
    }

    public static d a() {
        return a.f1434a;
    }

    public static a c() {
        a b2 = b.b();
        c.d.a.a.i.w.a.d.c(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }

    /* renamed from: b */
    public a get() {
        return c();
    }
}
