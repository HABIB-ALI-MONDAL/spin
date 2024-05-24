package c.d.a.b.e.e;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.CheckForNull;

final class y6 implements Serializable, x6 {
    final x6 j;
    volatile transient boolean k;
    @CheckForNull
    transient Object l;

    y6(x6 x6Var) {
        Objects.requireNonNull(x6Var);
        this.j = x6Var;
    }

    public final Object a() {
        if (!this.k) {
            synchronized (this) {
                if (!this.k) {
                    Object a2 = this.j.a();
                    this.l = a2;
                    this.k = true;
                    return a2;
                }
            }
        }
        return this.l;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (this.k) {
            obj = "<supplier that returned " + this.l + ">";
        } else {
            obj = this.j;
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
