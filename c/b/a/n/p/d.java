package c.b.a.n.p;

import android.util.Log;
import c.b.a.g;
import c.b.a.n.j;
import c.b.a.n.n.d;
import c.b.a.n.p.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class d implements n<File, ByteBuffer> {

    private static final class a implements c.b.a.n.n.d<ByteBuffer> {
        private final File j;

        a(File file) {
            this.j = file;
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        public void b() {
        }

        public c.b.a.n.a c() {
            return c.b.a.n.a.LOCAL;
        }

        public void cancel() {
        }

        public void d(g gVar, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.h(c.b.a.t.a.a(this.j));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.g(e2);
            }
        }
    }

    public static class b implements o<File, ByteBuffer> {
        public n<File, ByteBuffer> b(r rVar) {
            return new d();
        }
    }

    /* renamed from: c */
    public n.a<ByteBuffer> a(File file, int i, int i2, j jVar) {
        return new n.a<>(new c.b.a.s.b(file), new a(file));
    }

    /* renamed from: d */
    public boolean b(File file) {
        return true;
    }
}
