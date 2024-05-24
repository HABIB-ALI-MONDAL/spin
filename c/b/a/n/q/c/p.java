package c.b.a.n.q.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import c.b.a.n.o.q;
import c.b.a.n.o.u;
import c.b.a.t.h;

public final class p implements u<BitmapDrawable>, q {
    private final Resources j;
    private final u<Bitmap> k;

    private p(Resources resources, u<Bitmap> uVar) {
        h.d(resources);
        this.j = resources;
        h.d(uVar);
        this.k = uVar;
    }

    public static u<BitmapDrawable> f(Resources resources, u<Bitmap> uVar) {
        if (uVar == null) {
            return null;
        }
        return new p(resources, uVar);
    }

    public void a() {
        u<Bitmap> uVar = this.k;
        if (uVar instanceof q) {
            ((q) uVar).a();
        }
    }

    public void b() {
        this.k.b();
    }

    public int c() {
        return this.k.c();
    }

    public Class<BitmapDrawable> d() {
        return BitmapDrawable.class;
    }

    /* renamed from: e */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.j, this.k.get());
    }
}
