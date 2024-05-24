package c.b.a.n.q.c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import c.b.a.n.c;
import c.b.a.n.j;
import c.b.a.n.l;
import c.b.a.n.o.u;
import c.b.a.n.o.z.e;
import java.io.File;

public class b implements l<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final e f1127a;

    /* renamed from: b  reason: collision with root package name */
    private final l<Bitmap> f1128b;

    public b(e eVar, l<Bitmap> lVar) {
        this.f1127a = eVar;
        this.f1128b = lVar;
    }

    public c b(j jVar) {
        return this.f1128b.b(jVar);
    }

    /* renamed from: c */
    public boolean a(u<BitmapDrawable> uVar, File file, j jVar) {
        return this.f1128b.a(new d(uVar.get().getBitmap(), this.f1127a), file, jVar);
    }
}
