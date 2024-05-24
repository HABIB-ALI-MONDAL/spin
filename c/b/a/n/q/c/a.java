package c.b.a.n.q.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import c.b.a.n.j;
import c.b.a.n.k;
import c.b.a.n.o.u;
import c.b.a.t.h;

public class a<DataType> implements k<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final k<DataType, Bitmap> f1125a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f1126b;

    public a(Resources resources, k<DataType, Bitmap> kVar) {
        h.d(resources);
        this.f1126b = resources;
        h.d(kVar);
        this.f1125a = kVar;
    }

    public u<BitmapDrawable> a(DataType datatype, int i, int i2, j jVar) {
        return p.f(this.f1126b, this.f1125a.a(datatype, i, i2, jVar));
    }

    public boolean b(DataType datatype, j jVar) {
        return this.f1125a.b(datatype, jVar);
    }
}
