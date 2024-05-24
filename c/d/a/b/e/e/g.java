package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.List;

public final class g implements q {
    private final boolean j;

    public g(Boolean bool) {
        this.j = bool == null ? false : bool.booleanValue();
    }

    public final q d() {
        return new g(Boolean.valueOf(this.j));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.j == ((g) obj).j;
    }

    public final Double f() {
        return Double.valueOf(true != this.j ? 0.0d : 1.0d);
    }

    public final String g() {
        return Boolean.toString(this.j);
    }

    public final int hashCode() {
        return Boolean.valueOf(this.j).hashCode();
    }

    public final Iterator i() {
        return null;
    }

    public final Boolean k() {
        return Boolean.valueOf(this.j);
    }

    public final q l(String str, n4 n4Var, List list) {
        if ("toString".equals(str)) {
            return new u(Boolean.toString(this.j));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{Boolean.toString(this.j), str}));
    }

    public final String toString() {
        return String.valueOf(this.j);
    }
}
