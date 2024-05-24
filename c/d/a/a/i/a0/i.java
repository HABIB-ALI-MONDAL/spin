package c.d.a.a.i.a0;

import android.content.Context;
import c.d.a.a.i.a0.j.j0;
import c.d.a.a.i.w.a.b;
import c.d.a.a.i.w.a.d;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.y;
import d.a.a;

public final class i implements b<y> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f1318a;

    /* renamed from: b  reason: collision with root package name */
    private final a<j0> f1319b;

    /* renamed from: c  reason: collision with root package name */
    private final a<t> f1320c;

    /* renamed from: d  reason: collision with root package name */
    private final a<c.d.a.a.i.c0.a> f1321d;

    public i(a<Context> aVar, a<j0> aVar2, a<t> aVar3, a<c.d.a.a.i.c0.a> aVar4) {
        this.f1318a = aVar;
        this.f1319b = aVar2;
        this.f1320c = aVar3;
        this.f1321d = aVar4;
    }

    public static i a(a<Context> aVar, a<j0> aVar2, a<t> aVar3, a<c.d.a.a.i.c0.a> aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static y c(Context context, j0 j0Var, t tVar, c.d.a.a.i.c0.a aVar) {
        y a2 = h.a(context, j0Var, tVar, aVar);
        d.c(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    /* renamed from: b */
    public y get() {
        return c(this.f1318a.get(), this.f1319b.get(), this.f1320c.get(), this.f1321d.get());
    }
}
