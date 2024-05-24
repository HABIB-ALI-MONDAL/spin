package c.d.a.a.i.a0;

import c.d.a.a.i.a0.j.j0;
import c.d.a.a.i.w.a.b;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.y;
import d.a.a;
import java.util.concurrent.Executor;

public final class d implements b<c> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Executor> f1312a;

    /* renamed from: b  reason: collision with root package name */
    private final a<e> f1313b;

    /* renamed from: c  reason: collision with root package name */
    private final a<y> f1314c;

    /* renamed from: d  reason: collision with root package name */
    private final a<j0> f1315d;

    /* renamed from: e  reason: collision with root package name */
    private final a<c.d.a.a.i.b0.b> f1316e;

    public d(a<Executor> aVar, a<e> aVar2, a<y> aVar3, a<j0> aVar4, a<c.d.a.a.i.b0.b> aVar5) {
        this.f1312a = aVar;
        this.f1313b = aVar2;
        this.f1314c = aVar3;
        this.f1315d = aVar4;
        this.f1316e = aVar5;
    }

    public static d a(a<Executor> aVar, a<e> aVar2, a<y> aVar3, a<j0> aVar4, a<c.d.a.a.i.b0.b> aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, e eVar, y yVar, j0 j0Var, c.d.a.a.i.b0.b bVar) {
        return new c(executor, eVar, yVar, j0Var, bVar);
    }

    /* renamed from: b */
    public c get() {
        return c(this.f1312a.get(), this.f1313b.get(), this.f1314c.get(), this.f1315d.get(), this.f1316e.get());
    }
}
