package c.d.a.b.e.e;

import java.util.Objects;
import javax.annotation.CheckForNull;

final class z6 implements x6 {
    @CheckForNull
    volatile x6 j;
    volatile boolean k;
    @CheckForNull
    Object l;

    z6(x6 x6Var) {
        Objects.requireNonNull(x6Var);
        this.j = x6Var;
    }

    public final Object a() {
        if (!this.k) {
            synchronized (this) {
                if (!this.k) {
                    x6 x6Var = this.j;
                    x6Var.getClass();
                    Object a2 = x6Var.a();
                    this.l = a2;
                    this.k = true;
                    this.j = null;
                    return a2;
                }
            }
        }
        return this.l;
    }

    public final String toString() {
        Object obj = this.j;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.l + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
