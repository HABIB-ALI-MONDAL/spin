package c.d.a.b.e.e;

import java.util.List;

public final class l0 extends x {
    public final q a(String str, n4 n4Var, List list) {
        if (str == null || str.isEmpty() || !n4Var.h(str)) {
            throw new IllegalArgumentException(String.format("Command not found: %s", new Object[]{str}));
        }
        q d2 = n4Var.d(str);
        if (d2 instanceof j) {
            return ((j) d2).a(n4Var, list);
        }
        throw new IllegalArgumentException(String.format("Function %s is not defined", new Object[]{str}));
    }
}
