package c.d.a.b.e.e;

import java.util.List;

public final class me extends j {
    private final qe l;

    public me(qe qeVar) {
        super("internal.registerCallback");
        this.l = qeVar;
    }

    public final q a(n4 n4Var, List list) {
        n5.h(this.j, 3, list);
        String g = n4Var.b((q) list.get(0)).g();
        q b2 = n4Var.b((q) list.get(1));
        if (b2 instanceof p) {
            q b3 = n4Var.b((q) list.get(2));
            if (b3 instanceof n) {
                n nVar = (n) b3;
                if (nVar.j("type")) {
                    this.l.a(g, nVar.j("priority") ? n5.b(nVar.p("priority").f().doubleValue()) : 1000, (p) b2, nVar.p("type").g());
                    return q.f1722b;
                }
                throw new IllegalArgumentException("Undefined rule type");
            }
            throw new IllegalArgumentException("Invalid callback params");
        }
        throw new IllegalArgumentException("Invalid callback type");
    }
}
