package c.b.a.n.o;

import c.b.a.n.h;
import java.security.MessageDigest;

final class c implements h {

    /* renamed from: b  reason: collision with root package name */
    private final h f943b;

    /* renamed from: c  reason: collision with root package name */
    private final h f944c;

    c(h hVar, h hVar2) {
        this.f943b = hVar;
        this.f944c = hVar2;
    }

    public void a(MessageDigest messageDigest) {
        this.f943b.a(messageDigest);
        this.f944c.a(messageDigest);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f943b.equals(cVar.f943b) && this.f944c.equals(cVar.f944c);
    }

    public int hashCode() {
        return (this.f943b.hashCode() * 31) + this.f944c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f943b + ", signature=" + this.f944c + '}';
    }
}
