package c.b.a.n.q.c;

import android.graphics.Bitmap;
import c.b.a.n.o.q;
import c.b.a.n.o.u;
import c.b.a.n.o.z.e;
import c.b.a.t.h;
import c.b.a.t.i;

public class d implements u<Bitmap>, q {
    private final Bitmap j;
    private final e k;

    public d(Bitmap bitmap, e eVar) {
        h.e(bitmap, "Bitmap must not be null");
        this.j = bitmap;
        h.e(eVar, "BitmapPool must not be null");
        this.k = eVar;
    }

    public static d f(Bitmap bitmap, e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, eVar);
    }

    public void a() {
        this.j.prepareToDraw();
    }

    public void b() {
        this.k.d(this.j);
    }

    public int c() {
        return i.g(this.j);
    }

    public Class<Bitmap> d() {
        return Bitmap.class;
    }

    /* renamed from: e */
    public Bitmap get() {
        return this.j;
    }
}
