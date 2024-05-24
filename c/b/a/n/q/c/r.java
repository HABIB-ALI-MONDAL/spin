package c.b.a.n.q.c;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import c.b.a.n.j;
import c.b.a.n.k;
import c.b.a.n.o.u;
import c.b.a.n.o.z.e;
import c.b.a.n.q.e.d;

public class r implements k<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f1158a;

    /* renamed from: b  reason: collision with root package name */
    private final e f1159b;

    public r(d dVar, e eVar) {
        this.f1158a = dVar;
        this.f1159b = eVar;
    }

    /* renamed from: c */
    public u<Bitmap> a(Uri uri, int i, int i2, j jVar) {
        u<Drawable> c2 = this.f1158a.a(uri, i, i2, jVar);
        if (c2 == null) {
            return null;
        }
        return l.a(this.f1159b, c2.get(), i, i2);
    }

    /* renamed from: d */
    public boolean b(Uri uri, j jVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
