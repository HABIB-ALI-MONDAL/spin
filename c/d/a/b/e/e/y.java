package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    final Map f1780a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final l0 f1781b = new l0();

    public y() {
        b(new w());
        b(new z());
        b(new a0());
        b(new e0());
        b(new j0());
        b(new k0());
        b(new m0());
    }

    public final q a(n4 n4Var, q qVar) {
        n5.c(n4Var);
        if (!(qVar instanceof r)) {
            return qVar;
        }
        r rVar = (r) qVar;
        ArrayList b2 = rVar.b();
        String a2 = rVar.a();
        return (this.f1780a.containsKey(a2) ? (x) this.f1780a.get(a2) : this.f1781b).a(a2, n4Var, b2);
    }

    /* access modifiers changed from: package-private */
    public final void b(x xVar) {
        for (n0 e2 : xVar.f1778a) {
            this.f1780a.put(e2.e().toString(), xVar);
        }
    }
}
