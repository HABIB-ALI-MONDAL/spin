package c.d.a.b.e.e;

import java.util.List;

public final class w extends x {
    public w() {
        this.f1778a.add(n0.BITWISE_AND);
        this.f1778a.add(n0.BITWISE_LEFT_SHIFT);
        this.f1778a.add(n0.BITWISE_NOT);
        this.f1778a.add(n0.BITWISE_OR);
        this.f1778a.add(n0.BITWISE_RIGHT_SHIFT);
        this.f1778a.add(n0.BITWISE_UNSIGNED_RIGHT_SHIFT);
        this.f1778a.add(n0.BITWISE_XOR);
    }

    public final q a(String str, n4 n4Var, List list) {
        n0 n0Var = n0.ADD;
        switch (n5.e(str).ordinal()) {
            case 4:
                n5.h(n0.BITWISE_AND.name(), 2, list);
                return new i(Double.valueOf((double) (n5.b(n4Var.b((q) list.get(0)).f().doubleValue()) & n5.b(n4Var.b((q) list.get(1)).f().doubleValue()))));
            case 5:
                n5.h(n0.BITWISE_LEFT_SHIFT.name(), 2, list);
                return new i(Double.valueOf((double) (n5.b(n4Var.b((q) list.get(0)).f().doubleValue()) << ((int) (n5.d(n4Var.b((q) list.get(1)).f().doubleValue()) & 31)))));
            case 6:
                n5.h(n0.BITWISE_NOT.name(), 1, list);
                return new i(Double.valueOf((double) (n5.b(n4Var.b((q) list.get(0)).f().doubleValue()) ^ -1)));
            case 7:
                n5.h(n0.BITWISE_OR.name(), 2, list);
                return new i(Double.valueOf((double) (n5.b(n4Var.b((q) list.get(0)).f().doubleValue()) | n5.b(n4Var.b((q) list.get(1)).f().doubleValue()))));
            case 8:
                n5.h(n0.BITWISE_RIGHT_SHIFT.name(), 2, list);
                return new i(Double.valueOf((double) (n5.b(n4Var.b((q) list.get(0)).f().doubleValue()) >> ((int) (n5.d(n4Var.b((q) list.get(1)).f().doubleValue()) & 31)))));
            case 9:
                n5.h(n0.BITWISE_UNSIGNED_RIGHT_SHIFT.name(), 2, list);
                return new i(Double.valueOf((double) (n5.d(n4Var.b((q) list.get(0)).f().doubleValue()) >>> ((int) (n5.d(n4Var.b((q) list.get(1)).f().doubleValue()) & 31)))));
            case 10:
                n5.h(n0.BITWISE_XOR.name(), 2, list);
                return new i(Double.valueOf((double) (n5.b(n4Var.b((q) list.get(0)).f().doubleValue()) ^ n5.b(n4Var.b((q) list.get(1)).f().doubleValue()))));
            default:
                super.b(str);
                throw null;
        }
    }
}
