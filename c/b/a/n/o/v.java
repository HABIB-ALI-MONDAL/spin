package c.b.a.n.o;

import c.b.a.n.a;
import c.b.a.n.h;
import c.b.a.n.n.d;
import c.b.a.n.o.e;
import c.b.a.n.p.n;
import java.io.File;
import java.util.List;

class v implements e, d.a<Object> {
    private final e.a j;
    private final f<?> k;
    private int l;
    private int m = -1;
    private h n;
    private List<n<File, ?>> o;
    private int p;
    private volatile n.a<?> q;
    private File r;
    private w s;

    v(f<?> fVar, e.a aVar) {
        this.k = fVar;
        this.j = aVar;
    }

    private boolean b() {
        return this.p < this.o.size();
    }

    public boolean a() {
        List<h> c2 = this.k.c();
        boolean z = false;
        if (c2.isEmpty()) {
            return false;
        }
        List<Class<?>> m2 = this.k.m();
        if (!m2.isEmpty()) {
            while (true) {
                if (this.o == null || !b()) {
                    int i = this.m + 1;
                    this.m = i;
                    if (i >= m2.size()) {
                        int i2 = this.l + 1;
                        this.l = i2;
                        if (i2 >= c2.size()) {
                            return false;
                        }
                        this.m = 0;
                    }
                    h hVar = c2.get(this.l);
                    Class cls = m2.get(this.m);
                    h hVar2 = hVar;
                    this.s = new w(this.k.b(), hVar2, this.k.o(), this.k.s(), this.k.f(), this.k.r(cls), cls, this.k.k());
                    File b2 = this.k.d().b(this.s);
                    this.r = b2;
                    if (b2 != null) {
                        this.n = hVar;
                        this.o = this.k.j(b2);
                        this.p = 0;
                    }
                } else {
                    this.q = null;
                    while (!z && b()) {
                        List<n<File, ?>> list = this.o;
                        int i3 = this.p;
                        this.p = i3 + 1;
                        this.q = list.get(i3).a(this.r, this.k.s(), this.k.f(), this.k.k());
                        if (this.q != null && this.k.t(this.q.f1081c.a())) {
                            this.q.f1081c.d(this.k.l(), this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
        } else if (File.class.equals(this.k.q())) {
            return false;
        } else {
            throw new IllegalStateException("Failed to find any load path from " + this.k.i() + " to " + this.k.q());
        }
    }

    public void cancel() {
        n.a<?> aVar = this.q;
        if (aVar != null) {
            aVar.f1081c.cancel();
        }
    }

    public void g(Exception exc) {
        this.j.f(this.s, exc, this.q.f1081c, a.RESOURCE_DISK_CACHE);
    }

    public void h(Object obj) {
        this.j.e(this.n, obj, this.q.f1081c, a.RESOURCE_DISK_CACHE, this.s);
    }
}
