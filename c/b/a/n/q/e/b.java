package c.b.a.n.q.e;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c.b.a.n.o.q;
import c.b.a.n.o.u;
import c.b.a.n.q.g.c;
import c.b.a.t.h;

public abstract class b<T extends Drawable> implements u<T>, q {
    protected final T j;

    public b(T t) {
        h.d(t);
        this.j = (Drawable) t;
    }

    public void a() {
        Bitmap e2;
        T t = this.j;
        if (t instanceof BitmapDrawable) {
            e2 = ((BitmapDrawable) t).getBitmap();
        } else if (t instanceof c) {
            e2 = ((c) t).e();
        } else {
            return;
        }
        e2.prepareToDraw();
    }

    /* renamed from: e */
    public final T get() {
        Drawable.ConstantState constantState = this.j.getConstantState();
        return constantState == null ? this.j : constantState.newDrawable();
    }
}
