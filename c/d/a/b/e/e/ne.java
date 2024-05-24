package c.d.a.b.e.e;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public final class ne extends j {
    private final o7 l;
    final Map m = new HashMap();

    public ne(o7 o7Var) {
        super("require");
        this.l = o7Var;
    }

    public final q a(n4 n4Var, List list) {
        q qVar;
        n5.h("require", 1, list);
        String g = n4Var.b((q) list.get(0)).g();
        if (this.m.containsKey(g)) {
            return (q) this.m.get(g);
        }
        o7 o7Var = this.l;
        if (o7Var.f1710a.containsKey(g)) {
            try {
                qVar = (q) ((Callable) o7Var.f1710a.get(g)).call();
            } catch (Exception unused) {
                throw new IllegalStateException("Failed to create API implementation: ".concat(String.valueOf(g)));
            }
        } else {
            qVar = q.f1722b;
        }
        if (qVar instanceof j) {
            this.m.put(g, (j) qVar);
        }
        return qVar;
    }
}
