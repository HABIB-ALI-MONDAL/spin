package c.e.a.a;

final class d<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final A f1851a;

    /* renamed from: b  reason: collision with root package name */
    private final B f1852b;

    private d(A a2, B b2) {
        this.f1851a = a2;
        this.f1852b = b2;
    }

    public static <A, B> d<A, B> b(A a2, B b2) {
        return new d<>(a2, b2);
    }

    public A a() {
        return this.f1851a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        A a2 = this.f1851a;
        if (a2 == null) {
            if (dVar.f1851a != null) {
                return false;
            }
        } else if (!a2.equals(dVar.f1851a)) {
            return false;
        }
        B b2 = this.f1852b;
        B b3 = dVar.f1852b;
        if (b2 == null) {
            if (b3 != null) {
                return false;
            }
        } else if (!b2.equals(b3)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a2 = this.f1851a;
        int i = 0;
        int hashCode = ((a2 == null ? 0 : a2.hashCode()) + 31) * 31;
        B b2 = this.f1852b;
        if (b2 != null) {
            i = b2.hashCode();
        }
        return hashCode + i;
    }
}
