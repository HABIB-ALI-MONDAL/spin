package c.d.a.b.e.e;

final class d8 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1618a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1619b;

    d8(Object obj, int i) {
        this.f1618a = obj;
        this.f1619b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d8)) {
            return false;
        }
        d8 d8Var = (d8) obj;
        return this.f1618a == d8Var.f1618a && this.f1619b == d8Var.f1619b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f1618a) * 65535) + this.f1619b;
    }
}
