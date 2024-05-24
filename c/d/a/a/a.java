package c.d.a.a;

import java.util.Objects;

final class a<T> extends c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f1298a;

    /* renamed from: b  reason: collision with root package name */
    private final T f1299b;

    /* renamed from: c  reason: collision with root package name */
    private final d f1300c;

    a(Integer num, T t, d dVar) {
        this.f1298a = num;
        Objects.requireNonNull(t, "Null payload");
        this.f1299b = t;
        Objects.requireNonNull(dVar, "Null priority");
        this.f1300c = dVar;
    }

    public Integer a() {
        return this.f1298a;
    }

    public T b() {
        return this.f1299b;
    }

    public d c() {
        return this.f1300c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        Integer num = this.f1298a;
        if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
            return this.f1299b.equals(cVar.b()) && this.f1300c.equals(cVar.c());
        }
    }

    public int hashCode() {
        Integer num = this.f1298a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f1299b.hashCode()) * 1000003) ^ this.f1300c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f1298a + ", payload=" + this.f1299b + ", priority=" + this.f1300c + "}";
    }
}
