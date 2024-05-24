package c.d.a.a.i.a0.j;

import c.d.a.a.i.w.a.b;
import c.d.a.a.i.w.a.d;

public final class m0 implements b<String> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final m0 f1360a = new m0();
    }

    public static m0 a() {
        return a.f1360a;
    }

    public static String b() {
        String a2 = l0.a();
        d.c(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    /* renamed from: c */
    public String get() {
        return b();
    }
}
