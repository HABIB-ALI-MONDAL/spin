package c.b.a.n.q.c;

import android.graphics.Bitmap;
import c.b.a.n.j;
import c.b.a.n.k;
import c.b.a.n.o.u;
import c.b.a.n.o.z.b;
import c.b.a.n.o.z.e;
import c.b.a.n.q.c.k;
import c.b.a.t.c;
import c.b.a.t.f;
import java.io.IOException;
import java.io.InputStream;

public class s implements k<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final k f1160a;

    /* renamed from: b  reason: collision with root package name */
    private final b f1161b;

    static class a implements k.b {

        /* renamed from: a  reason: collision with root package name */
        private final q f1162a;

        /* renamed from: b  reason: collision with root package name */
        private final c f1163b;

        a(q qVar, c cVar) {
            this.f1162a = qVar;
            this.f1163b = cVar;
        }

        public void a(e eVar, Bitmap bitmap) {
            IOException c2 = this.f1163b.c();
            if (c2 != null) {
                if (bitmap != null) {
                    eVar.d(bitmap);
                }
                throw c2;
            }
        }

        public void b() {
            this.f1162a.f();
        }
    }

    public s(k kVar, b bVar) {
        this.f1160a = kVar;
        this.f1161b = bVar;
    }

    /* renamed from: c */
    public u<Bitmap> a(InputStream inputStream, int i, int i2, j jVar) {
        q qVar;
        boolean z;
        if (inputStream instanceof q) {
            qVar = (q) inputStream;
            z = false;
        } else {
            qVar = new q(inputStream, this.f1161b);
            z = true;
        }
        c f2 = c.f(qVar);
        try {
            return this.f1160a.e(new f(f2), i, i2, jVar, new a(qVar, f2));
        } finally {
            f2.h();
            if (z) {
                qVar.h();
            }
        }
    }

    /* renamed from: d */
    public boolean b(InputStream inputStream, j jVar) {
        return this.f1160a.m(inputStream);
    }
}
