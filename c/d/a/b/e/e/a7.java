package c.d.a.b.e.e;

import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

final class a7 implements Serializable, x6 {
    final Object j;

    a7(Object obj) {
        this.j = obj;
    }

    public final Object a() {
        return this.j;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof a7)) {
            return false;
        }
        Object obj2 = this.j;
        Object obj3 = ((a7) obj).j;
        return obj2 == obj3 || obj2.equals(obj3);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.j});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.j + ")";
    }
}
