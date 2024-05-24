package c.b.a.n.q.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c.b.a.c;
import c.b.a.n.o.u;
import c.b.a.n.o.z.e;
import java.security.MessageDigest;

public class m implements c.b.a.n.m<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private final c.b.a.n.m<Bitmap> f1151b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1152c;

    public m(c.b.a.n.m<Bitmap> mVar, boolean z) {
        this.f1151b = mVar;
        this.f1152c = z;
    }

    private u<Drawable> d(Context context, u<Bitmap> uVar) {
        return p.f(context.getResources(), uVar);
    }

    public void a(MessageDigest messageDigest) {
        this.f1151b.a(messageDigest);
    }

    public u<Drawable> b(Context context, u<Drawable> uVar, int i, int i2) {
        e f2 = c.c(context).f();
        Drawable drawable = uVar.get();
        u<Bitmap> a2 = l.a(f2, drawable, i, i2);
        if (a2 != null) {
            u<Bitmap> b2 = this.f1151b.b(context, a2, i, i2);
            if (!b2.equals(a2)) {
                return d(context, b2);
            }
            b2.b();
            return uVar;
        } else if (!this.f1152c) {
            return uVar;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    public c.b.a.n.m<BitmapDrawable> c() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f1151b.equals(((m) obj).f1151b);
        }
        return false;
    }

    public int hashCode() {
        return this.f1151b.hashCode();
    }
}
