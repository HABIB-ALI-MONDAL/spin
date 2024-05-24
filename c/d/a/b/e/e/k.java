package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final /* synthetic */ class k {
    public static q a(m mVar, q qVar, n4 n4Var, List list) {
        if (mVar.j(qVar.g())) {
            q p = mVar.p(qVar.g());
            if (p instanceof j) {
                return ((j) p).a(n4Var, list);
            }
            throw new IllegalArgumentException(String.format("%s is not a function", new Object[]{qVar.g()}));
        } else if ("hasOwnProperty".equals(qVar.g())) {
            n5.h("hasOwnProperty", 1, list);
            return mVar.j(n4Var.b((q) list.get(0)).g()) ? q.g : q.h;
        } else {
            throw new IllegalArgumentException(String.format("Object has no function %s", new Object[]{qVar.g()}));
        }
    }

    public static Iterator b(Map map) {
        return new l(map.keySet().iterator());
    }
}
