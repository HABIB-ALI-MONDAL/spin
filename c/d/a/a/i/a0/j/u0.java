package c.d.a.a.i.a0.j;

import android.content.Context;
import c.d.a.a.i.w.a.b;
import d.a.a;

public final class u0 implements b<t0> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f1390a;

    /* renamed from: b  reason: collision with root package name */
    private final a<String> f1391b;

    /* renamed from: c  reason: collision with root package name */
    private final a<Integer> f1392c;

    public u0(a<Context> aVar, a<String> aVar2, a<Integer> aVar3) {
        this.f1390a = aVar;
        this.f1391b = aVar2;
        this.f1392c = aVar3;
    }

    public static u0 a(a<Context> aVar, a<String> aVar2, a<Integer> aVar3) {
        return new u0(aVar, aVar2, aVar3);
    }

    public static t0 c(Context context, String str, int i) {
        return new t0(context, str, i);
    }

    /* renamed from: b */
    public t0 get() {
        return c(this.f1390a.get(), this.f1391b.get(), this.f1392c.get().intValue());
    }
}
