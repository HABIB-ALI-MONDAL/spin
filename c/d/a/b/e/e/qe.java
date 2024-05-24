package c.d.a.b.e.e;

import java.util.Collections;
import java.util.TreeMap;

public final class qe {

    /* renamed from: a  reason: collision with root package name */
    final TreeMap f1737a = new TreeMap();

    /* renamed from: b  reason: collision with root package name */
    final TreeMap f1738b = new TreeMap();

    private static final int c(n4 n4Var, p pVar, q qVar) {
        q a2 = pVar.a(n4Var, Collections.singletonList(qVar));
        if (a2 instanceof i) {
            return n5.b(a2.f().doubleValue());
        }
        return -1;
    }

    public final void a(String str, int i, p pVar, String str2) {
        TreeMap treeMap;
        if ("create".equals(str2)) {
            treeMap = this.f1738b;
        } else if ("edit".equals(str2)) {
            treeMap = this.f1737a;
        } else {
            throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(str2)));
        }
        if (treeMap.containsKey(Integer.valueOf(i))) {
            i = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i), pVar);
    }

    public final void b(n4 n4Var, c cVar) {
        k9 k9Var = new k9(cVar);
        for (Integer num : this.f1737a.keySet()) {
            b b2 = cVar.b().clone();
            int c2 = c(n4Var, (p) this.f1737a.get(num), k9Var);
            if (c2 == 2 || c2 == -1) {
                cVar.f(b2);
            }
        }
        for (Integer num2 : this.f1738b.keySet()) {
            c(n4Var, (p) this.f1738b.get(num2), k9Var);
        }
    }
}
