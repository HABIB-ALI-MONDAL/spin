package c.d.a.a;

import java.util.Objects;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f1301a;

    private b(String str) {
        Objects.requireNonNull(str, "name is null");
        this.f1301a = str;
    }

    public static b b(String str) {
        return new b(str);
    }

    public String a() {
        return this.f1301a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f1301a.equals(((b) obj).f1301a);
    }

    public int hashCode() {
        return this.f1301a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f1301a + "\"}";
    }
}
