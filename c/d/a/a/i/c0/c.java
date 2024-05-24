package c.d.a.a.i.c0;

import c.d.a.a.i.w.a.b;
import c.d.a.a.i.w.a.d;

public final class c implements b<a> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f1433a = new c();
    }

    public static c a() {
        return a.f1433a;
    }

    public static a b() {
        a a2 = b.a();
        d.c(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    /* renamed from: c */
    public a get() {
        return b();
    }
}
