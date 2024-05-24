package c.b.a.n.q.h;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c.b.a.n.j;
import c.b.a.n.o.u;
import c.b.a.n.o.z.e;
import c.b.a.n.q.c.d;

public final class c implements e<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final e f1209a;

    /* renamed from: b  reason: collision with root package name */
    private final e<Bitmap, byte[]> f1210b;

    /* renamed from: c  reason: collision with root package name */
    private final e<c.b.a.n.q.g.c, byte[]> f1211c;

    public c(e eVar, e<Bitmap, byte[]> eVar2, e<c.b.a.n.q.g.c, byte[]> eVar3) {
        this.f1209a = eVar;
        this.f1210b = eVar2;
        this.f1211c = eVar3;
    }

    private static u<c.b.a.n.q.g.c> b(u<Drawable> uVar) {
        return uVar;
    }

    public u<byte[]> a(u<Drawable> uVar, j jVar) {
        Drawable drawable = uVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f1210b.a(d.f(((BitmapDrawable) drawable).getBitmap(), this.f1209a), jVar);
        }
        if (!(drawable instanceof c.b.a.n.q.g.c)) {
            return null;
        }
        e<c.b.a.n.q.g.c, byte[]> eVar = this.f1211c;
        b(uVar);
        return eVar.a(uVar, jVar);
    }
}
