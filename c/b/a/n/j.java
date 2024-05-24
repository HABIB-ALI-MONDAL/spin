package c.b.a.n;

import b.c.a;
import java.security.MessageDigest;

public final class j implements h {

    /* renamed from: b  reason: collision with root package name */
    private final a<i<?>, Object> f879b = new a<>();

    private static <T> void f(i<T> iVar, Object obj, MessageDigest messageDigest) {
        iVar.g(obj, messageDigest);
    }

    public void a(MessageDigest messageDigest) {
        for (int i = 0; i < this.f879b.size(); i++) {
            f(this.f879b.i(i), this.f879b.m(i), messageDigest);
        }
    }

    public <T> T c(i<T> iVar) {
        return this.f879b.containsKey(iVar) ? this.f879b.get(iVar) : iVar.c();
    }

    public void d(j jVar) {
        this.f879b.j(jVar.f879b);
    }

    public <T> j e(i<T> iVar, T t) {
        this.f879b.put(iVar, t);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f879b.equals(((j) obj).f879b);
        }
        return false;
    }

    public int hashCode() {
        return this.f879b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f879b + '}';
    }
}
