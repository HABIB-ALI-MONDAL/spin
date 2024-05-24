package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class n implements q, m {
    final Map j = new HashMap();

    public final List a() {
        return new ArrayList(this.j.keySet());
    }

    public final q d() {
        String str;
        Map map;
        q qVar;
        n nVar = new n();
        for (Map.Entry entry : this.j.entrySet()) {
            if (entry.getValue() instanceof m) {
                map = nVar.j;
                str = (String) entry.getKey();
                qVar = (q) entry.getValue();
            } else {
                map = nVar.j;
                str = (String) entry.getKey();
                qVar = ((q) entry.getValue()).d();
            }
            map.put(str, qVar);
        }
        return nVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        return this.j.equals(((n) obj).j);
    }

    public final Double f() {
        return Double.valueOf(Double.NaN);
    }

    public final String g() {
        return "[object Object]";
    }

    public final int hashCode() {
        return this.j.hashCode();
    }

    public final Iterator i() {
        return k.b(this.j);
    }

    public final boolean j(String str) {
        return this.j.containsKey(str);
    }

    public final Boolean k() {
        return Boolean.TRUE;
    }

    public q l(String str, n4 n4Var, List list) {
        return "toString".equals(str) ? new u(toString()) : k.a(this, new u(str), n4Var, list);
    }

    public final q p(String str) {
        return this.j.containsKey(str) ? (q) this.j.get(str) : q.f1722b;
    }

    public final void r(String str, q qVar) {
        if (qVar == null) {
            this.j.remove(str);
        } else {
            this.j.put(str, qVar);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (!this.j.isEmpty()) {
            for (String str : this.j.keySet()) {
                sb.append(String.format("%s: %s,", new Object[]{str, this.j.get(str)}));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }
}
