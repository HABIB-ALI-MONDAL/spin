package c.b.a.n.q.e;

import android.graphics.drawable.Drawable;
import c.b.a.n.o.u;

final class c extends b<Drawable> {
    private c(Drawable drawable) {
        super(drawable);
    }

    static u<Drawable> f(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    public void b() {
    }

    public int c() {
        return Math.max(1, this.j.getIntrinsicWidth() * this.j.getIntrinsicHeight() * 4);
    }

    public Class<Drawable> d() {
        return this.j.getClass();
    }
}
