package c.b.a.n.q.c;

import android.content.Context;
import android.graphics.Bitmap;
import c.b.a.c;
import c.b.a.n.m;
import c.b.a.n.o.u;
import c.b.a.t.i;

public abstract class e implements m<Bitmap> {
    public final u<Bitmap> b(Context context, u<Bitmap> uVar, int i, int i2) {
        if (i.r(i, i2)) {
            c.b.a.n.o.z.e f2 = c.c(context).f();
            Bitmap bitmap = uVar.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap c2 = c(f2, bitmap, i, i2);
            return bitmap.equals(c2) ? uVar : d.f(c2, f2);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap c(c.b.a.n.o.z.e eVar, Bitmap bitmap, int i, int i2);
}
