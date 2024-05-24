package c.b.a.n.q.d;

import c.b.a.n.n.e;
import java.nio.ByteBuffer;

public class a implements e<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f1176a;

    /* renamed from: c.b.a.n.q.d.a$a  reason: collision with other inner class name */
    public static class C0052a implements e.a<ByteBuffer> {
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        /* renamed from: c */
        public e<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f1176a = byteBuffer;
    }

    public void b() {
    }

    /* renamed from: c */
    public ByteBuffer a() {
        this.f1176a.position(0);
        return this.f1176a;
    }
}
