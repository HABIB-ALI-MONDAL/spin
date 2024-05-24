package c.d.a.a.i.a0.j;

import android.content.Context;
import c.d.a.a.i.w.a.b;
import c.d.a.a.i.w.a.d;
import d.a.a;

public final class n0 implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f1365a;

    public n0(a<Context> aVar) {
        this.f1365a = aVar;
    }

    public static n0 a(a<Context> aVar) {
        return new n0(aVar);
    }

    public static String c(Context context) {
        String b2 = l0.b(context);
        d.c(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }

    /* renamed from: b */
    public String get() {
        return c(this.f1365a.get());
    }
}
