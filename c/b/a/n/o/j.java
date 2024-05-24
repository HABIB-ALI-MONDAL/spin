package c.b.a.n.o;

import android.util.Log;
import c.b.a.e;
import c.b.a.n.m;
import c.b.a.n.o.a0.a;
import c.b.a.n.o.a0.h;
import c.b.a.n.o.g;
import c.b.a.n.o.o;
import c.b.a.r.f;
import c.b.a.t.i;
import c.b.a.t.j.a;
import java.util.Map;

public class j implements l, h.a, o.a {

    /* renamed from: a  reason: collision with root package name */
    private final r f974a;

    /* renamed from: b  reason: collision with root package name */
    private final n f975b;

    /* renamed from: c  reason: collision with root package name */
    private final h f976c;

    /* renamed from: d  reason: collision with root package name */
    private final b f977d;

    /* renamed from: e  reason: collision with root package name */
    private final x f978e;

    /* renamed from: f  reason: collision with root package name */
    private final c f979f;
    private final a g;
    private final a h;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final g.e f980a;

        /* renamed from: b  reason: collision with root package name */
        final b.d.j.d<g<?>> f981b = c.b.a.t.j.a.d(150, new C0046a());

        /* renamed from: c  reason: collision with root package name */
        private int f982c;

        /* renamed from: c.b.a.n.o.j$a$a  reason: collision with other inner class name */
        class C0046a implements a.d<g<?>> {
            C0046a() {
            }

            /* renamed from: b */
            public g<?> a() {
                a aVar = a.this;
                return new g<>(aVar.f980a, aVar.f981b);
            }
        }

        a(g.e eVar) {
            this.f980a = eVar;
        }

        /* access modifiers changed from: package-private */
        public <R> g<R> a(e eVar, Object obj, m mVar, c.b.a.n.h hVar, int i, int i2, Class<?> cls, Class<R> cls2, c.b.a.g gVar, i iVar, Map<Class<?>, m<?>> map, boolean z, boolean z2, boolean z3, c.b.a.n.j jVar, g.b<R> bVar) {
            g<R> b2 = this.f981b.b();
            c.b.a.t.h.d(b2);
            g<R> gVar2 = b2;
            int i3 = this.f982c;
            int i4 = i3;
            this.f982c = i3 + 1;
            gVar2.q(eVar, obj, mVar, hVar, i, i2, cls, cls2, gVar, iVar, map, z, z2, z3, jVar, bVar, i4);
            return gVar2;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final c.b.a.n.o.b0.a f984a;

        /* renamed from: b  reason: collision with root package name */
        final c.b.a.n.o.b0.a f985b;

        /* renamed from: c  reason: collision with root package name */
        final c.b.a.n.o.b0.a f986c;

        /* renamed from: d  reason: collision with root package name */
        final c.b.a.n.o.b0.a f987d;

        /* renamed from: e  reason: collision with root package name */
        final l f988e;

        /* renamed from: f  reason: collision with root package name */
        final b.d.j.d<k<?>> f989f = c.b.a.t.j.a.d(150, new a());

        class a implements a.d<k<?>> {
            a() {
            }

            /* renamed from: b */
            public k<?> a() {
                b bVar = b.this;
                return new k(bVar.f984a, bVar.f985b, bVar.f986c, bVar.f987d, bVar.f988e, bVar.f989f);
            }
        }

        b(c.b.a.n.o.b0.a aVar, c.b.a.n.o.b0.a aVar2, c.b.a.n.o.b0.a aVar3, c.b.a.n.o.b0.a aVar4, l lVar) {
            this.f984a = aVar;
            this.f985b = aVar2;
            this.f986c = aVar3;
            this.f987d = aVar4;
            this.f988e = lVar;
        }

        /* access modifiers changed from: package-private */
        public <R> k<R> a(c.b.a.n.h hVar, boolean z, boolean z2, boolean z3, boolean z4) {
            k<R> b2 = this.f989f.b();
            c.b.a.t.h.d(b2);
            k<R> kVar = b2;
            kVar.l(hVar, z, z2, z3, z4);
            return kVar;
        }
    }

    private static class c implements g.e {

        /* renamed from: a  reason: collision with root package name */
        private final a.C0041a f991a;

        /* renamed from: b  reason: collision with root package name */
        private volatile c.b.a.n.o.a0.a f992b;

        c(a.C0041a aVar) {
            this.f991a = aVar;
        }

        public c.b.a.n.o.a0.a a() {
            if (this.f992b == null) {
                synchronized (this) {
                    if (this.f992b == null) {
                        this.f992b = this.f991a.a();
                    }
                    if (this.f992b == null) {
                        this.f992b = new c.b.a.n.o.a0.b();
                    }
                }
            }
            return this.f992b;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final k<?> f993a;

        /* renamed from: b  reason: collision with root package name */
        private final f f994b;

        d(f fVar, k<?> kVar) {
            this.f994b = fVar;
            this.f993a = kVar;
        }

        public void a() {
            this.f993a.p(this.f994b);
        }
    }

    j(h hVar, a.C0041a aVar, c.b.a.n.o.b0.a aVar2, c.b.a.n.o.b0.a aVar3, c.b.a.n.o.b0.a aVar4, c.b.a.n.o.b0.a aVar5, r rVar, n nVar, a aVar6, b bVar, a aVar7, x xVar, boolean z) {
        this.f976c = hVar;
        a.C0041a aVar8 = aVar;
        c cVar = new c(aVar);
        this.f979f = cVar;
        a aVar9 = aVar6 == null ? new a(z) : aVar6;
        this.h = aVar9;
        aVar9.g(this);
        this.f975b = nVar == null ? new n() : nVar;
        this.f974a = rVar == null ? new r() : rVar;
        this.f977d = bVar == null ? new b(aVar2, aVar3, aVar4, aVar5, this) : bVar;
        this.g = aVar7 == null ? new a(cVar) : aVar7;
        this.f978e = xVar == null ? new x() : xVar;
        hVar.e(this);
    }

    public j(h hVar, a.C0041a aVar, c.b.a.n.o.b0.a aVar2, c.b.a.n.o.b0.a aVar3, c.b.a.n.o.b0.a aVar4, c.b.a.n.o.b0.a aVar5, boolean z) {
        this(hVar, aVar, aVar2, aVar3, aVar4, aVar5, (r) null, (n) null, (a) null, (b) null, (a) null, (x) null, z);
    }

    private o<?> e(c.b.a.n.h hVar) {
        u<?> d2 = this.f976c.d(hVar);
        if (d2 == null) {
            return null;
        }
        return d2 instanceof o ? (o) d2 : new o<>(d2, true, true);
    }

    private o<?> g(c.b.a.n.h hVar, boolean z) {
        if (!z) {
            return null;
        }
        o<?> e2 = this.h.e(hVar);
        if (e2 != null) {
            e2.a();
        }
        return e2;
    }

    private o<?> h(c.b.a.n.h hVar, boolean z) {
        if (!z) {
            return null;
        }
        o<?> e2 = e(hVar);
        if (e2 != null) {
            e2.a();
            this.h.a(hVar, e2);
        }
        return e2;
    }

    private static void i(String str, long j, c.b.a.n.h hVar) {
        Log.v("Engine", str + " in " + c.b.a.t.d.a(j) + "ms, key: " + hVar);
    }

    public void a(c.b.a.n.h hVar, o<?> oVar) {
        i.a();
        this.h.d(hVar);
        if (oVar.f()) {
            this.f976c.c(hVar, oVar);
        } else {
            this.f978e.a(oVar);
        }
    }

    public void b(u<?> uVar) {
        i.a();
        this.f978e.a(uVar);
    }

    public void c(k<?> kVar, c.b.a.n.h hVar, o<?> oVar) {
        i.a();
        if (oVar != null) {
            oVar.h(hVar, this);
            if (oVar.f()) {
                this.h.a(hVar, oVar);
            }
        }
        this.f974a.d(hVar, kVar);
    }

    public void d(k<?> kVar, c.b.a.n.h hVar) {
        i.a();
        this.f974a.d(hVar, kVar);
    }

    public <R> d f(e eVar, Object obj, c.b.a.n.h hVar, int i, int i2, Class<?> cls, Class<R> cls2, c.b.a.g gVar, i iVar, Map<Class<?>, m<?>> map, boolean z, boolean z2, c.b.a.n.j jVar, boolean z3, boolean z4, boolean z5, boolean z6, f fVar) {
        boolean z7 = z3;
        f fVar2 = fVar;
        i.a();
        long b2 = c.b.a.t.d.b();
        m a2 = this.f975b.a(obj, hVar, i, i2, map, cls, cls2, jVar);
        o<?> g2 = g(a2, z7);
        if (g2 != null) {
            fVar2.c(g2, c.b.a.n.a.MEMORY_CACHE);
            if (Log.isLoggable("Engine", 2)) {
                i("Loaded resource from active resources", b2, a2);
            }
            return null;
        }
        o<?> h2 = h(a2, z7);
        if (h2 != null) {
            fVar2.c(h2, c.b.a.n.a.MEMORY_CACHE);
            if (Log.isLoggable("Engine", 2)) {
                i("Loaded resource from cache", b2, a2);
            }
            return null;
        }
        k<?> a3 = this.f974a.a(a2, z6);
        if (a3 != null) {
            a3.b(fVar2);
            if (Log.isLoggable("Engine", 2)) {
                i("Added to existing load", b2, a2);
            }
            return new d(fVar2, a3);
        }
        k a4 = this.f977d.a(a2, z3, z4, z5, z6);
        g<R> a5 = this.g.a(eVar, obj, a2, hVar, i, i2, cls, cls2, gVar, iVar, map, z, z2, z6, jVar, a4);
        this.f974a.c(a2, a4);
        a4.b(fVar2);
        a4.q(a5);
        if (Log.isLoggable("Engine", 2)) {
            i("Started new load", b2, a2);
        }
        return new d(fVar2, a4);
    }

    public void j(u<?> uVar) {
        i.a();
        if (uVar instanceof o) {
            ((o) uVar).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }
}
