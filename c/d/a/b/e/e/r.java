package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class r implements q {
    private final String j;
    private final ArrayList k;

    public r(String str, List list) {
        this.j = str;
        ArrayList arrayList = new ArrayList();
        this.k = arrayList;
        arrayList.addAll(list);
    }

    public final String a() {
        return this.j;
    }

    public final ArrayList b() {
        return this.k;
    }

    public final q d() {
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        String str = this.j;
        if (str == null ? rVar.j == null : str.equals(rVar.j)) {
            return this.k.equals(rVar.k);
        }
        return false;
    }

    public final Double f() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    public final String g() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    public final int hashCode() {
        String str = this.j;
        return ((str != null ? str.hashCode() : 0) * 31) + this.k.hashCode();
    }

    public final Iterator i() {
        return null;
    }

    public final Boolean k() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    public final q l(String str, n4 n4Var, List list) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }
}
