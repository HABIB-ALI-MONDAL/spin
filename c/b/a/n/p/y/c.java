package c.b.a.n.p.y;

import android.content.Context;
import android.net.Uri;
import c.b.a.n.j;
import c.b.a.n.n.o.b;
import c.b.a.n.p.n;
import c.b.a.n.p.o;
import c.b.a.n.p.r;
import java.io.InputStream;

public class c implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1119a;

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1120a;

        public a(Context context) {
            this.f1120a = context;
        }

        public n<Uri, InputStream> b(r rVar) {
            return new c(this.f1120a);
        }
    }

    public c(Context context) {
        this.f1119a = context.getApplicationContext();
    }

    /* renamed from: c */
    public n.a<InputStream> a(Uri uri, int i, int i2, j jVar) {
        if (b.d(i, i2)) {
            return new n.a<>(new c.b.a.s.b(uri), c.b.a.n.n.o.c.f(this.f1119a, uri));
        }
        return null;
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return b.a(uri);
    }
}
