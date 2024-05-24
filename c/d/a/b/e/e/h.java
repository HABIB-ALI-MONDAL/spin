package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.List;

public final class h implements q {
    private final q j;
    private final String k;

    public h() {
        throw null;
    }

    public h(String str) {
        this.j = q.f1722b;
        this.k = str;
    }

    public h(String str, q qVar) {
        this.j = qVar;
        this.k = str;
    }

    public final q a() {
        return this.j;
    }

    public final String b() {
        return this.k;
    }

    public final q d() {
        return new h(this.k, this.j.d());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.k.equals(hVar.k) && this.j.equals(hVar.j);
    }

    public final Double f() {
        throw new IllegalStateException("Control is not a double");
    }

    public final String g() {
        throw new IllegalStateException("Control is not a String");
    }

    public final int hashCode() {
        return (this.k.hashCode() * 31) + this.j.hashCode();
    }

    public final Iterator i() {
        return null;
    }

    public final Boolean k() {
        throw new IllegalStateException("Control is not a boolean");
    }

    public final q l(String str, n4 n4Var, List list) {
        throw new IllegalStateException("Control does not have functions");
    }
}
