package c.d.a.b.e.e;

import javax.annotation.CheckForNull;

final class w6 extends v6 {
    private final Object j;

    w6(Object obj) {
        this.j = obj;
    }

    public final Object a() {
        return this.j;
    }

    public final boolean b() {
        return true;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof w6) {
            return this.j.equals(((w6) obj).j);
        }
        return false;
    }

    public final int hashCode() {
        return this.j.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.j + ")";
    }
}
