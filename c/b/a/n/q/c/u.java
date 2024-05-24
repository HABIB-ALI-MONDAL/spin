package c.b.a.n.q.c;

import android.graphics.Bitmap;
import c.b.a.n.j;
import c.b.a.n.k;
import c.b.a.t.i;

public final class u implements k<Bitmap, Bitmap> {

    private static final class a implements c.b.a.n.o.u<Bitmap> {
        private final Bitmap j;

        a(Bitmap bitmap) {
            this.j = bitmap;
        }

        /* renamed from: a */
        public Bitmap get() {
            return this.j;
        }

        public void b() {
        }

        public int c() {
            return i.g(this.j);
        }

        public Class<Bitmap> d() {
            return Bitmap.class;
        }
    }

    /* renamed from: c */
    public c.b.a.n.o.u<Bitmap> a(Bitmap bitmap, int i, int i2, j jVar) {
        return new a(bitmap);
    }

    /* renamed from: d */
    public boolean b(Bitmap bitmap, j jVar) {
        return true;
    }
}
