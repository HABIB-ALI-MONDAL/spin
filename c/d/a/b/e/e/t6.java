package c.d.a.b.e.e;

import javax.annotation.CheckForNull;

final class t6 extends v6 {
    static final t6 j = new t6();

    private t6() {
    }

    public final Object a() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final boolean b() {
        return false;
    }

    public final boolean equals(@CheckForNull Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
