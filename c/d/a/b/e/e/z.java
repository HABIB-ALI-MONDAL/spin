package c.d.a.b.e.e;

import java.util.List;

public final class z extends x {
    public z() {
        this.f1778a.add(n0.EQUALS);
        this.f1778a.add(n0.GREATER_THAN);
        this.f1778a.add(n0.GREATER_THAN_EQUALS);
        this.f1778a.add(n0.IDENTITY_EQUALS);
        this.f1778a.add(n0.IDENTITY_NOT_EQUALS);
        this.f1778a.add(n0.LESS_THAN);
        this.f1778a.add(n0.LESS_THAN_EQUALS);
        this.f1778a.add(n0.NOT_EQUALS);
    }

    private static boolean c(q qVar, q qVar2) {
        if (qVar.getClass().equals(qVar2.getClass())) {
            if ((qVar instanceof v) || (qVar instanceof o)) {
                return true;
            }
            return qVar instanceof i ? !Double.isNaN(qVar.f().doubleValue()) && !Double.isNaN(qVar2.f().doubleValue()) && qVar.f().doubleValue() == qVar2.f().doubleValue() : qVar instanceof u ? qVar.g().equals(qVar2.g()) : qVar instanceof g ? qVar.k().equals(qVar2.k()) : qVar == qVar2;
        } else if (((qVar instanceof v) || (qVar instanceof o)) && ((qVar2 instanceof v) || (qVar2 instanceof o))) {
            return true;
        } else {
            boolean z = qVar instanceof i;
            if (z && (qVar2 instanceof u)) {
                return c(qVar, new i(qVar2.f()));
            }
            boolean z2 = qVar instanceof u;
            if (z2 && (qVar2 instanceof i)) {
                return c(new i(qVar.f()), qVar2);
            }
            if (qVar instanceof g) {
                return c(new i(qVar.f()), qVar2);
            }
            if (qVar2 instanceof g) {
                return c(qVar, new i(qVar2.f()));
            }
            if ((z2 || z) && (qVar2 instanceof m)) {
                return c(qVar, new u(qVar2.g()));
            }
            if (!(qVar instanceof m) || (!(qVar2 instanceof u) && !(qVar2 instanceof i))) {
                return false;
            }
            return c(new u(qVar.g()), qVar2);
        }
    }

    private static boolean d(q qVar, q qVar2) {
        if (qVar instanceof m) {
            qVar = new u(qVar.g());
        }
        if (qVar2 instanceof m) {
            qVar2 = new u(qVar2.g());
        }
        if ((qVar instanceof u) && (qVar2 instanceof u)) {
            return qVar.g().compareTo(qVar2.g()) < 0;
        }
        double doubleValue = qVar.f().doubleValue();
        double doubleValue2 = qVar2.f().doubleValue();
        return !Double.isNaN(doubleValue) && !Double.isNaN(doubleValue2) && !(doubleValue == 0.0d && doubleValue2 == 0.0d) && (!(doubleValue == 0.0d && doubleValue2 == 0.0d) && Double.compare(doubleValue, doubleValue2) < 0);
    }

    private static boolean e(q qVar, q qVar2) {
        if (qVar instanceof m) {
            qVar = new u(qVar.g());
        }
        if (qVar2 instanceof m) {
            qVar2 = new u(qVar2.g());
        }
        return (((qVar instanceof u) && (qVar2 instanceof u)) || (!Double.isNaN(qVar.f().doubleValue()) && !Double.isNaN(qVar2.f().doubleValue()))) && !d(qVar2, qVar);
    }

    public final q a(String str, n4 n4Var, List list) {
        boolean z;
        boolean c2;
        n5.h(n5.e(str).name(), 2, list);
        q b2 = n4Var.b((q) list.get(0));
        q b3 = n4Var.b((q) list.get(1));
        int ordinal = n5.e(str).ordinal();
        if (ordinal != 23) {
            if (ordinal == 48) {
                c2 = c(b2, b3);
            } else if (ordinal == 42) {
                z = d(b2, b3);
            } else if (ordinal != 43) {
                switch (ordinal) {
                    case 37:
                        z = d(b3, b2);
                        break;
                    case 38:
                        z = e(b3, b2);
                        break;
                    case 39:
                        z = n5.l(b2, b3);
                        break;
                    case 40:
                        c2 = n5.l(b2, b3);
                        break;
                    default:
                        super.b(str);
                        throw null;
                }
            } else {
                z = e(b2, b3);
            }
            z = !c2;
        } else {
            z = c(b2, b3);
        }
        return z ? q.g : q.h;
    }
}
