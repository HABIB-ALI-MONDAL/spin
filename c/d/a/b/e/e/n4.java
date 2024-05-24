package c.d.a.b.e.e;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class n4 {

    /* renamed from: a  reason: collision with root package name */
    public final n4 f1694a;

    /* renamed from: b  reason: collision with root package name */
    final y f1695b;

    /* renamed from: c  reason: collision with root package name */
    final Map f1696c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    final Map f1697d = new HashMap();

    public n4(n4 n4Var, y yVar) {
        this.f1694a = n4Var;
        this.f1695b = yVar;
    }

    public final n4 a() {
        return new n4(this, this.f1695b);
    }

    public final q b(q qVar) {
        return this.f1695b.a(this, qVar);
    }

    public final q c(f fVar) {
        q qVar = q.f1722b;
        Iterator w = fVar.w();
        while (w.hasNext()) {
            qVar = this.f1695b.a(this, fVar.u(((Integer) w.next()).intValue()));
            if (qVar instanceof h) {
                break;
            }
        }
        return qVar;
    }

    public final q d(String str) {
        if (this.f1696c.containsKey(str)) {
            return (q) this.f1696c.get(str);
        }
        n4 n4Var = this.f1694a;
        if (n4Var != null) {
            return n4Var.d(str);
        }
        throw new IllegalArgumentException(String.format("%s is not defined", new Object[]{str}));
    }

    public final void e(String str, q qVar) {
        if (!this.f1697d.containsKey(str)) {
            if (qVar == null) {
                this.f1696c.remove(str);
            } else {
                this.f1696c.put(str, qVar);
            }
        }
    }

    public final void f(String str, q qVar) {
        e(str, qVar);
        this.f1697d.put(str, Boolean.TRUE);
    }

    public final void g(String str, q qVar) {
        n4 n4Var;
        if (!this.f1696c.containsKey(str) && (n4Var = this.f1694a) != null && n4Var.h(str)) {
            this.f1694a.g(str, qVar);
        } else if (!this.f1697d.containsKey(str)) {
            if (qVar == null) {
                this.f1696c.remove(str);
            } else {
                this.f1696c.put(str, qVar);
            }
        }
    }

    public final boolean h(String str) {
        if (this.f1696c.containsKey(str)) {
            return true;
        }
        n4 n4Var = this.f1694a;
        if (n4Var != null) {
            return n4Var.h(str);
        }
        return false;
    }
}
