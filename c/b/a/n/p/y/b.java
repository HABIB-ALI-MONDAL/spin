package c.b.a.n.p.y;

import android.net.Uri;
import c.b.a.n.j;
import c.b.a.n.p.g;
import c.b.a.n.p.n;
import c.b.a.n.p.o;
import c.b.a.n.p.r;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class b implements n<Uri, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f1117b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f1118a;

    public static class a implements o<Uri, InputStream> {
        public n<Uri, InputStream> b(r rVar) {
            return new b(rVar.d(g.class, InputStream.class));
        }
    }

    public b(n<g, InputStream> nVar) {
        this.f1118a = nVar;
    }

    /* renamed from: c */
    public n.a<InputStream> a(Uri uri, int i, int i2, j jVar) {
        return this.f1118a.a(new g(uri.toString()), i, i2, jVar);
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return f1117b.contains(uri.getScheme());
    }
}
