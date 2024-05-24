package c.b.a.n.o;

import android.util.Log;
import c.b.a.n.a;
import c.b.a.n.h;
import c.b.a.n.n.d;
import c.b.a.n.o.e;
import c.b.a.n.p.n;
import java.util.Collections;
import java.util.List;

class y implements e, d.a<Object>, e.a {
    private final f<?> j;
    private final e.a k;
    private int l;
    private b m;
    private Object n;
    private volatile n.a<?> o;
    private c p;

    y(f<?> fVar, e.a aVar) {
        this.j = fVar;
        this.k = aVar;
    }

    /* JADX INFO: finally extract failed */
    private void b(Object obj) {
        long b2 = c.b.a.t.d.b();
        try {
            c.b.a.n.d<X> p2 = this.j.p(obj);
            d dVar = new d(p2, obj, this.j.k());
            this.p = new c(this.o.f1079a, this.j.o());
            this.j.d().a(this.p, dVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.p + ", data: " + obj + ", encoder: " + p2 + ", duration: " + c.b.a.t.d.a(b2));
            }
            this.o.f1081c.b();
            this.m = new b(Collections.singletonList(this.o.f1079a), this.j, this);
        } catch (Throwable th) {
            this.o.f1081c.b();
            throw th;
        }
    }

    private boolean c() {
        return this.l < this.j.g().size();
    }

    public boolean a() {
        Object obj = this.n;
        if (obj != null) {
            this.n = null;
            b(obj);
        }
        b bVar = this.m;
        if (bVar != null && bVar.a()) {
            return true;
        }
        this.m = null;
        this.o = null;
        boolean z = false;
        while (!z && c()) {
            List<n.a<?>> g = this.j.g();
            int i = this.l;
            this.l = i + 1;
            this.o = g.get(i);
            if (this.o != null && (this.j.e().c(this.o.f1081c.c()) || this.j.t(this.o.f1081c.a()))) {
                this.o.f1081c.d(this.j.l(), this);
                z = true;
            }
        }
        return z;
    }

    public void cancel() {
        n.a<?> aVar = this.o;
        if (aVar != null) {
            aVar.f1081c.cancel();
        }
    }

    public void d() {
        throw new UnsupportedOperationException();
    }

    public void e(h hVar, Object obj, d<?> dVar, a aVar, h hVar2) {
        this.k.e(hVar, obj, dVar, this.o.f1081c.c(), hVar);
    }

    public void f(h hVar, Exception exc, d<?> dVar, a aVar) {
        this.k.f(hVar, exc, dVar, this.o.f1081c.c());
    }

    public void g(Exception exc) {
        this.k.f(this.p, exc, this.o.f1081c, this.o.f1081c.c());
    }

    public void h(Object obj) {
        i e2 = this.j.e();
        if (obj == null || !e2.c(this.o.f1081c.c())) {
            this.k.e(this.o.f1079a, obj, this.o.f1081c, this.o.f1081c.c(), this.p);
            return;
        }
        this.n = obj;
        this.k.d();
    }
}
