package c.d.a.b.e.e;

import java.util.List;

public final class k0 extends x {
    protected k0() {
        this.f1778a.add(n0.ADD);
        this.f1778a.add(n0.DIVIDE);
        this.f1778a.add(n0.MODULUS);
        this.f1778a.add(n0.MULTIPLY);
        this.f1778a.add(n0.NEGATE);
        this.f1778a.add(n0.POST_DECREMENT);
        this.f1778a.add(n0.POST_INCREMENT);
        this.f1778a.add(n0.PRE_DECREMENT);
        this.f1778a.add(n0.PRE_INCREMENT);
        this.f1778a.add(n0.SUBTRACT);
    }

    public final q a(String str, n4 n4Var, List list) {
        n0 n0Var = n0.ADD;
        int ordinal = n5.e(str).ordinal();
        if (ordinal == 0) {
            n5.h(n0Var.name(), 2, list);
            q b2 = n4Var.b((q) list.get(0));
            q b3 = n4Var.b((q) list.get(1));
            return ((b2 instanceof m) || (b2 instanceof u) || (b3 instanceof m) || (b3 instanceof u)) ? new u(String.valueOf(b2.g()).concat(String.valueOf(b3.g()))) : new i(Double.valueOf(b2.f().doubleValue() + b3.f().doubleValue()));
        } else if (ordinal == 21) {
            n5.h(n0.DIVIDE.name(), 2, list);
            return new i(Double.valueOf(n4Var.b((q) list.get(0)).f().doubleValue() / n4Var.b((q) list.get(1)).f().doubleValue()));
        } else if (ordinal == 59) {
            n5.h(n0.SUBTRACT.name(), 2, list);
            return new i(Double.valueOf(n4Var.b((q) list.get(0)).f().doubleValue() + new i(Double.valueOf(-n4Var.b((q) list.get(1)).f().doubleValue())).f().doubleValue()));
        } else if (ordinal == 52 || ordinal == 53) {
            n5.h(str, 2, list);
            q b4 = n4Var.b((q) list.get(0));
            n4Var.b((q) list.get(1));
            return b4;
        } else if (ordinal == 55 || ordinal == 56) {
            n5.h(str, 1, list);
            return n4Var.b((q) list.get(0));
        } else {
            switch (ordinal) {
                case 44:
                    n5.h(n0.MODULUS.name(), 2, list);
                    return new i(Double.valueOf(n4Var.b((q) list.get(0)).f().doubleValue() % n4Var.b((q) list.get(1)).f().doubleValue()));
                case 45:
                    n5.h(n0.MULTIPLY.name(), 2, list);
                    return new i(Double.valueOf(n4Var.b((q) list.get(0)).f().doubleValue() * n4Var.b((q) list.get(1)).f().doubleValue()));
                case 46:
                    n5.h(n0.NEGATE.name(), 1, list);
                    return new i(Double.valueOf(-n4Var.b((q) list.get(0)).f().doubleValue()));
                default:
                    super.b(str);
                    throw null;
            }
        }
    }
}
