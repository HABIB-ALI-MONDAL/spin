package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.Map;

final class s9 {
    s9() {
    }

    public static final int a(int i, Object obj, Object obj2) {
        r9 r9Var = (r9) obj;
        q9 q9Var = (q9) obj2;
        if (r9Var.isEmpty()) {
            return 0;
        }
        Iterator it = r9Var.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object b(Object obj, Object obj2) {
        r9 r9Var = (r9) obj;
        r9 r9Var2 = (r9) obj2;
        if (!r9Var2.isEmpty()) {
            if (!r9Var.g()) {
                r9Var = r9Var.b();
            }
            r9Var.e(r9Var2);
        }
        return r9Var;
    }
}
