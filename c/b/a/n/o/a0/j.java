package c.b.a.n.o.a0;

import b.d.j.d;
import c.b.a.n.h;
import c.b.a.t.e;
import c.b.a.t.i;
import c.b.a.t.j.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final e<h, String> f931a = new e<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final d<b> f932b = c.b.a.t.j.a.e(10, new a(this));

    class a implements a.d<b> {
        a(j jVar) {
        }

        /* renamed from: b */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private static final class b implements a.f {
        final MessageDigest j;
        private final c.b.a.t.j.b k = c.b.a.t.j.b.a();

        b(MessageDigest messageDigest) {
            this.j = messageDigest;
        }

        public c.b.a.t.j.b k() {
            return this.k;
        }
    }

    private String a(h hVar) {
        b b2 = this.f932b.b();
        c.b.a.t.h.d(b2);
        b bVar = b2;
        try {
            hVar.a(bVar.j);
            return i.s(bVar.j.digest());
        } finally {
            this.f932b.a(bVar);
        }
    }

    public String b(h hVar) {
        String g;
        synchronized (this.f931a) {
            g = this.f931a.g(hVar);
        }
        if (g == null) {
            g = a(hVar);
        }
        synchronized (this.f931a) {
            this.f931a.k(hVar, g);
        }
        return g;
    }
}
