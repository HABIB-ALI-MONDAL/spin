package c.d.a.b.e.e;

import java.util.HashMap;
import java.util.List;

public final class n8 extends j {
    private final c l;

    public n8(c cVar) {
        super("internal.eventLogger");
        this.l = cVar;
    }

    public final q a(n4 n4Var, List list) {
        n5.h(this.j, 3, list);
        String g = n4Var.b((q) list.get(0)).g();
        long a2 = (long) n5.a(n4Var.b((q) list.get(1)).f().doubleValue());
        q b2 = n4Var.b((q) list.get(2));
        this.l.e(g, a2, b2 instanceof n ? n5.g((n) b2) : new HashMap());
        return q.f1722b;
    }
}
