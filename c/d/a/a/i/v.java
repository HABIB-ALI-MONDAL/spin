package c.d.a.a.i;

import c.d.a.a.i.a0.e;
import c.d.a.a.i.w.a.b;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.u;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.w;
import d.a.a;

public final class v implements b<t> {

    /* renamed from: a  reason: collision with root package name */
    private final a<c.d.a.a.i.c0.a> f1472a;

    /* renamed from: b  reason: collision with root package name */
    private final a<c.d.a.a.i.c0.a> f1473b;

    /* renamed from: c  reason: collision with root package name */
    private final a<e> f1474c;

    /* renamed from: d  reason: collision with root package name */
    private final a<u> f1475d;

    /* renamed from: e  reason: collision with root package name */
    private final a<w> f1476e;

    public v(a<c.d.a.a.i.c0.a> aVar, a<c.d.a.a.i.c0.a> aVar2, a<e> aVar3, a<u> aVar4, a<w> aVar5) {
        this.f1472a = aVar;
        this.f1473b = aVar2;
        this.f1474c = aVar3;
        this.f1475d = aVar4;
        this.f1476e = aVar5;
    }

    public static v a(a<c.d.a.a.i.c0.a> aVar, a<c.d.a.a.i.c0.a> aVar2, a<e> aVar3, a<u> aVar4, a<w> aVar5) {
        return new v(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static t c(c.d.a.a.i.c0.a aVar, c.d.a.a.i.c0.a aVar2, e eVar, u uVar, w wVar) {
        return new t(aVar, aVar2, eVar, uVar, wVar);
    }

    /* renamed from: b */
    public t get() {
        return c(this.f1472a.get(), this.f1473b.get(), this.f1474c.get(), this.f1475d.get(), this.f1476e.get());
    }
}
