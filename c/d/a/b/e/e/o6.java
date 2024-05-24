package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class o6 {
    public static q a(l5 l5Var) {
        if (l5Var == null) {
            return q.f1722b;
        }
        int N = l5Var.N() - 1;
        if (N == 1) {
            return l5Var.M() ? new u(l5Var.H()) : q.i;
        }
        if (N == 2) {
            return l5Var.L() ? new i(Double.valueOf(l5Var.E())) : new i((Double) null);
        }
        if (N == 3) {
            return l5Var.K() ? new g(Boolean.valueOf(l5Var.J())) : new g((Boolean) null);
        }
        if (N == 4) {
            List<l5> I = l5Var.I();
            ArrayList arrayList = new ArrayList();
            for (l5 a2 : I) {
                arrayList.add(a(a2));
            }
            return new r(l5Var.G(), arrayList);
        }
        throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
    }

    public static q b(Object obj) {
        if (obj == null) {
            return q.f1723c;
        }
        if (obj instanceof String) {
            return new u((String) obj);
        }
        if (obj instanceof Double) {
            return new i((Double) obj);
        }
        if (obj instanceof Long) {
            return new i(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new i(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new g((Boolean) obj);
        }
        if (obj instanceof Map) {
            n nVar = new n();
            Map map = (Map) obj;
            for (Object next : map.keySet()) {
                q b2 = b(map.get(next));
                if (next != null) {
                    if (!(next instanceof String)) {
                        next = next.toString();
                    }
                    nVar.r((String) next, b2);
                }
            }
            return nVar;
        } else if (obj instanceof List) {
            f fVar = new f();
            for (Object b3 : (List) obj) {
                fVar.B(fVar.t(), b(b3));
            }
            return fVar;
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }
}
