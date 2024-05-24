package c.b.a.n.p.y;

import android.content.Context;
import android.net.Uri;
import c.b.a.n.j;
import c.b.a.n.n.o.b;
import c.b.a.n.n.o.c;
import c.b.a.n.p.n;
import c.b.a.n.p.o;
import c.b.a.n.p.r;
import c.b.a.n.q.c.v;
import java.io.InputStream;

public class d implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1121a;

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1122a;

        public a(Context context) {
            this.f1122a = context;
        }

        public n<Uri, InputStream> b(r rVar) {
            return new d(this.f1122a);
        }
    }

    public d(Context context) {
        this.f1121a = context.getApplicationContext();
    }

    private boolean e(j jVar) {
        Long l = (Long) jVar.c(v.f1168d);
        return l != null && l.longValue() == -1;
    }

    /* renamed from: c */
    public n.a<InputStream> a(Uri uri, int i, int i2, j jVar) {
        if (!b.d(i, i2) || !e(jVar)) {
            return null;
        }
        return new n.a<>(new c.b.a.s.b(uri), c.g(this.f1121a, uri));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return b.c(uri);
    }
}
