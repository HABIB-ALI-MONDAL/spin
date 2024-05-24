package c.b.a.n.p.y;

import c.b.a.n.j;
import c.b.a.n.p.g;
import c.b.a.n.p.n;
import c.b.a.n.p.o;
import c.b.a.n.p.r;
import java.io.InputStream;
import java.net.URL;

public class e implements n<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f1123a;

    public static class a implements o<URL, InputStream> {
        public n<URL, InputStream> b(r rVar) {
            return new e(rVar.d(g.class, InputStream.class));
        }
    }

    public e(n<g, InputStream> nVar) {
        this.f1123a = nVar;
    }

    /* renamed from: c */
    public n.a<InputStream> a(URL url, int i, int i2, j jVar) {
        return this.f1123a.a(new g(url), i, i2, jVar);
    }

    /* renamed from: d */
    public boolean b(URL url) {
        return true;
    }
}
