package c.d.a.b.e.e;

import java.util.List;

public final class e0 extends x {
    protected e0() {
        this.f1778a.add(n0.AND);
        this.f1778a.add(n0.NOT);
        this.f1778a.add(n0.OR);
    }

    public final q a(String str, n4 n4Var, List list) {
        n0 n0Var = n0.ADD;
        int ordinal = n5.e(str).ordinal();
        if (ordinal == 1) {
            n5.h(n0.AND.name(), 2, list);
            q b2 = n4Var.b((q) list.get(0));
            if (!b2.k().booleanValue()) {
                return b2;
            }
        } else if (ordinal == 47) {
            n5.h(n0.NOT.name(), 1, list);
            return new g(Boolean.valueOf(!n4Var.b((q) list.get(0)).k().booleanValue()));
        } else if (ordinal == 50) {
            n5.h(n0.OR.name(), 2, list);
            q b3 = n4Var.b((q) list.get(0));
            if (b3.k().booleanValue()) {
                return b3;
            }
        } else {
            super.b(str);
            throw null;
        }
        return n4Var.b((q) list.get(1));
    }
}
