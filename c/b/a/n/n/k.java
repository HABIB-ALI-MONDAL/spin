package c.b.a.n.n;

import c.b.a.n.n.e;
import c.b.a.n.o.z.b;
import c.b.a.n.q.c.q;
import java.io.InputStream;

public final class k implements e<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final q f883a;

    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final b f884a;

        public a(b bVar) {
            this.f884a = bVar;
        }

        public Class<InputStream> a() {
            return InputStream.class;
        }

        /* renamed from: c */
        public e<InputStream> b(InputStream inputStream) {
            return new k(inputStream, this.f884a);
        }
    }

    k(InputStream inputStream, b bVar) {
        q qVar = new q(inputStream, bVar);
        this.f883a = qVar;
        qVar.mark(5242880);
    }

    public void b() {
        this.f883a.h();
    }

    /* renamed from: c */
    public InputStream a() {
        this.f883a.reset();
        return this.f883a;
    }
}
