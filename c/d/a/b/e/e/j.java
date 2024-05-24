package c.d.a.b.e.e;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class j implements q, m {
    protected final String j;
    protected final Map k = new HashMap();

    public j(String str) {
        this.j = str;
    }

    public abstract q a(n4 n4Var, List list);

    public final String b() {
        return this.j;
    }

    public q d() {
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        String str = this.j;
        if (str != null) {
            return str.equals(jVar.j);
        }
        return false;
    }

    public final Double f() {
        return Double.valueOf(Double.NaN);
    }

    public final String g() {
        return this.j;
    }

    public final int hashCode() {
        String str = this.j;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final Iterator i() {
        return k.b(this.k);
    }

    public final boolean j(String str) {
        return this.k.containsKey(str);
    }

    public final Boolean k() {
        return Boolean.TRUE;
    }

    public final q l(String str, n4 n4Var, List list) {
        return "toString".equals(str) ? new u(this.j) : k.a(this, new u(str), n4Var, list);
    }

    public final q p(String str) {
        return this.k.containsKey(str) ? (q) this.k.get(str) : q.f1722b;
    }

    public final void r(String str, q qVar) {
        if (qVar == null) {
            this.k.remove(str);
        } else {
            this.k.put(str, qVar);
        }
    }
}
