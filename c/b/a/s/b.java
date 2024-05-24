package c.b.a.s;

import c.b.a.n.h;
import java.security.MessageDigest;

public final class b implements h {

    /* renamed from: b  reason: collision with root package name */
    private final Object f1272b;

    public b(Object obj) {
        c.b.a.t.h.d(obj);
        this.f1272b = obj;
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.f1272b.toString().getBytes(h.f873a));
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f1272b.equals(((b) obj).f1272b);
        }
        return false;
    }

    public int hashCode() {
        return this.f1272b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f1272b + '}';
    }
}
