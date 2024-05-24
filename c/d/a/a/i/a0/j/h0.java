package c.d.a.a.i.a0.j;

import c.d.a.a.i.j;
import c.d.a.a.i.p;
import java.util.Objects;

final class h0 extends q0 {

    /* renamed from: a  reason: collision with root package name */
    private final long f1348a;

    /* renamed from: b  reason: collision with root package name */
    private final p f1349b;

    /* renamed from: c  reason: collision with root package name */
    private final j f1350c;

    h0(long j, p pVar, j jVar) {
        this.f1348a = j;
        Objects.requireNonNull(pVar, "Null transportContext");
        this.f1349b = pVar;
        Objects.requireNonNull(jVar, "Null event");
        this.f1350c = jVar;
    }

    public j b() {
        return this.f1350c;
    }

    public long c() {
        return this.f1348a;
    }

    public p d() {
        return this.f1349b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return this.f1348a == q0Var.c() && this.f1349b.equals(q0Var.d()) && this.f1350c.equals(q0Var.b());
    }

    public int hashCode() {
        long j = this.f1348a;
        return this.f1350c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f1349b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f1348a + ", transportContext=" + this.f1349b + ", event=" + this.f1350c + "}";
    }
}
