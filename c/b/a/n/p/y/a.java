package c.b.a.n.p.y;

import c.b.a.n.i;
import c.b.a.n.j;
import c.b.a.n.p.g;
import c.b.a.n.p.m;
import c.b.a.n.p.n;
import c.b.a.n.p.o;
import c.b.a.n.p.r;
import java.io.InputStream;

public class a implements n<g, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    public static final i<Integer> f1114b = i.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a  reason: collision with root package name */
    private final m<g, g> f1115a;

    /* renamed from: c.b.a.n.p.y.a$a  reason: collision with other inner class name */
    public static class C0051a implements o<g, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final m<g, g> f1116a = new m<>(500);

        public n<g, InputStream> b(r rVar) {
            return new a(this.f1116a);
        }
    }

    public a(m<g, g> mVar) {
        this.f1115a = mVar;
    }

    /* renamed from: c */
    public n.a<InputStream> a(g gVar, int i, int i2, j jVar) {
        m<g, g> mVar = this.f1115a;
        if (mVar != null) {
            g a2 = mVar.a(gVar, 0, 0);
            if (a2 == null) {
                this.f1115a.b(gVar, 0, 0, gVar);
            } else {
                gVar = a2;
            }
        }
        return new n.a<>(gVar, new c.b.a.n.n.j(gVar, ((Integer) jVar.c(f1114b)).intValue()));
    }

    /* renamed from: d */
    public boolean b(g gVar) {
        return true;
    }
}
