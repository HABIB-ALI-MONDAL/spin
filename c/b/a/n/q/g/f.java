package c.b.a.n.q.g;

import android.content.Context;
import android.graphics.Bitmap;
import c.b.a.c;
import c.b.a.n.m;
import c.b.a.n.o.u;
import c.b.a.n.q.c.d;
import c.b.a.t.h;
import java.security.MessageDigest;

public class f implements m<c> {

    /* renamed from: b  reason: collision with root package name */
    private final m<Bitmap> f1189b;

    public f(m<Bitmap> mVar) {
        h.d(mVar);
        this.f1189b = mVar;
    }

    public void a(MessageDigest messageDigest) {
        this.f1189b.a(messageDigest);
    }

    public u<c> b(Context context, u<c> uVar, int i, int i2) {
        c cVar = uVar.get();
        d dVar = new d(cVar.e(), c.c(context).f());
        u<Bitmap> b2 = this.f1189b.b(context, dVar, i, i2);
        if (!dVar.equals(b2)) {
            dVar.b();
        }
        cVar.l(this.f1189b, b2.get());
        return uVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f1189b.equals(((f) obj).f1189b);
        }
        return false;
    }

    public int hashCode() {
        return this.f1189b.hashCode();
    }
}
