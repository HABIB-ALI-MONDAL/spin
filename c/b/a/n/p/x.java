package c.b.a.n.p;

import android.net.Uri;
import c.b.a.n.j;
import c.b.a.n.p.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class x<Data> implements n<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f1112b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: a  reason: collision with root package name */
    private final n<g, Data> f1113a;

    public static class a implements o<Uri, InputStream> {
        public n<Uri, InputStream> b(r rVar) {
            return new x(rVar.d(g.class, InputStream.class));
        }
    }

    public x(n<g, Data> nVar) {
        this.f1113a = nVar;
    }

    /* renamed from: c */
    public n.a<Data> a(Uri uri, int i, int i2, j jVar) {
        return this.f1113a.a(new g(uri.toString()), i, i2, jVar);
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return f1112b.contains(uri.getScheme());
    }
}
