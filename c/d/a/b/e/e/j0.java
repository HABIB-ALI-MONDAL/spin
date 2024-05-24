package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.List;

public final class j0 extends x {
    protected j0() {
        this.f1778a.add(n0.FOR_IN);
        this.f1778a.add(n0.FOR_IN_CONST);
        this.f1778a.add(n0.FOR_IN_LET);
        this.f1778a.add(n0.FOR_LET);
        this.f1778a.add(n0.FOR_OF);
        this.f1778a.add(n0.FOR_OF_CONST);
        this.f1778a.add(n0.FOR_OF_LET);
        this.f1778a.add(n0.WHILE);
    }

    private static q c(h0 h0Var, Iterator it, q qVar) {
        if (it != null) {
            while (it.hasNext()) {
                q c2 = h0Var.a((q) it.next()).c((f) qVar);
                if (c2 instanceof h) {
                    h hVar = (h) c2;
                    if ("break".equals(hVar.b())) {
                        return q.f1722b;
                    }
                    if ("return".equals(hVar.b())) {
                        return hVar;
                    }
                }
            }
        }
        return q.f1722b;
    }

    private static q d(h0 h0Var, q qVar, q qVar2) {
        return c(h0Var, qVar.i(), qVar2);
    }

    private static q e(h0 h0Var, q qVar, q qVar2) {
        if (qVar instanceof Iterable) {
            return c(h0Var, ((Iterable) qVar).iterator(), qVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    public final q a(String str, n4 n4Var, List list) {
        n0 n0Var = n0.ADD;
        int ordinal = n5.e(str).ordinal();
        if (ordinal != 65) {
            switch (ordinal) {
                case 26:
                    n5.h(n0.FOR_IN.name(), 3, list);
                    if (list.get(0) instanceof u) {
                        String g = ((q) list.get(0)).g();
                        return d(new i0(n4Var, g), n4Var.b((q) list.get(1)), n4Var.b((q) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                case 27:
                    n5.h(n0.FOR_IN_CONST.name(), 3, list);
                    if (list.get(0) instanceof u) {
                        String g2 = ((q) list.get(0)).g();
                        return d(new f0(n4Var, g2), n4Var.b((q) list.get(1)), n4Var.b((q) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                case 28:
                    n5.h(n0.FOR_IN_LET.name(), 3, list);
                    if (list.get(0) instanceof u) {
                        String g3 = ((q) list.get(0)).g();
                        return d(new g0(n4Var, g3), n4Var.b((q) list.get(1)), n4Var.b((q) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                case 29:
                    n5.h(n0.FOR_LET.name(), 4, list);
                    q b2 = n4Var.b((q) list.get(0));
                    if (b2 instanceof f) {
                        f fVar = (f) b2;
                        q qVar = (q) list.get(1);
                        q qVar2 = (q) list.get(2);
                        q b3 = n4Var.b((q) list.get(3));
                        n4 a2 = n4Var.a();
                        for (int i = 0; i < fVar.t(); i++) {
                            String g4 = fVar.u(i).g();
                            a2.g(g4, n4Var.d(g4));
                        }
                        while (n4Var.b(qVar).k().booleanValue()) {
                            q c2 = n4Var.c((f) b3);
                            if (c2 instanceof h) {
                                h hVar = (h) c2;
                                if ("break".equals(hVar.b())) {
                                    return q.f1722b;
                                }
                                if ("return".equals(hVar.b())) {
                                    return hVar;
                                }
                            }
                            n4 a3 = n4Var.a();
                            for (int i2 = 0; i2 < fVar.t(); i2++) {
                                String g5 = fVar.u(i2).g();
                                a3.g(g5, a2.d(g5));
                            }
                            a3.b(qVar2);
                            a2 = a3;
                        }
                        return q.f1722b;
                    }
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                case 30:
                    n5.h(n0.FOR_OF.name(), 3, list);
                    if (list.get(0) instanceof u) {
                        String g6 = ((q) list.get(0)).g();
                        return e(new i0(n4Var, g6), n4Var.b((q) list.get(1)), n4Var.b((q) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                case 31:
                    n5.h(n0.FOR_OF_CONST.name(), 3, list);
                    if (list.get(0) instanceof u) {
                        String g7 = ((q) list.get(0)).g();
                        return e(new f0(n4Var, g7), n4Var.b((q) list.get(1)), n4Var.b((q) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                case 32:
                    n5.h(n0.FOR_OF_LET.name(), 3, list);
                    if (list.get(0) instanceof u) {
                        String g8 = ((q) list.get(0)).g();
                        return e(new g0(n4Var, g8), n4Var.b((q) list.get(1)), n4Var.b((q) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                default:
                    super.b(str);
                    throw null;
            }
        } else {
            n5.h(n0.WHILE.name(), 4, list);
            q qVar3 = (q) list.get(0);
            q qVar4 = (q) list.get(1);
            q b4 = n4Var.b((q) list.get(3));
            if (n4Var.b((q) list.get(2)).k().booleanValue()) {
                q c3 = n4Var.c((f) b4);
                if (c3 instanceof h) {
                    h hVar2 = (h) c3;
                    if (!"break".equals(hVar2.b())) {
                        if ("return".equals(hVar2.b())) {
                            return hVar2;
                        }
                    }
                    return q.f1722b;
                }
            }
            while (n4Var.b(qVar3).k().booleanValue()) {
                q c4 = n4Var.c((f) b4);
                if (c4 instanceof h) {
                    h hVar3 = (h) c4;
                    if ("break".equals(hVar3.b())) {
                        break;
                    } else if ("return".equals(hVar3.b())) {
                        return hVar3;
                    }
                }
                n4Var.b(qVar4);
            }
            return q.f1722b;
        }
    }
}
