package c.b.a.n.p;

import c.b.a.g;
import c.b.a.n.j;
import c.b.a.n.n.d;
import c.b.a.n.p.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class b<Data> implements n<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final C0049b<Data> f1055a;

    public static class a implements o<byte[], ByteBuffer> {

        /* renamed from: c.b.a.n.p.b$a$a  reason: collision with other inner class name */
        class C0048a implements C0049b<ByteBuffer> {
            C0048a(a aVar) {
            }

            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            /* renamed from: c */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        public n<byte[], ByteBuffer> b(r rVar) {
            return new b(new C0048a(this));
        }
    }

    /* renamed from: c.b.a.n.p.b$b  reason: collision with other inner class name */
    public interface C0049b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    private static class c<Data> implements c.b.a.n.n.d<Data> {
        private final byte[] j;
        private final C0049b<Data> k;

        c(byte[] bArr, C0049b<Data> bVar) {
            this.j = bArr;
            this.k = bVar;
        }

        public Class<Data> a() {
            return this.k.a();
        }

        public void b() {
        }

        public c.b.a.n.a c() {
            return c.b.a.n.a.LOCAL;
        }

        public void cancel() {
        }

        public void d(g gVar, d.a<? super Data> aVar) {
            aVar.h(this.k.b(this.j));
        }
    }

    public static class d implements o<byte[], InputStream> {

        class a implements C0049b<InputStream> {
            a(d dVar) {
            }

            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: c */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        public n<byte[], InputStream> b(r rVar) {
            return new b(new a(this));
        }
    }

    public b(C0049b<Data> bVar) {
        this.f1055a = bVar;
    }

    /* renamed from: c */
    public n.a<Data> a(byte[] bArr, int i, int i2, j jVar) {
        return new n.a<>(new c.b.a.s.b(bArr), new c(bArr, this.f1055a));
    }

    /* renamed from: d */
    public boolean b(byte[] bArr) {
        return true;
    }
}
