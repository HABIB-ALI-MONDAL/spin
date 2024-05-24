package c.b.a.n.o;

import c.b.a.n.a;
import c.b.a.n.h;
import c.b.a.n.n.d;
import c.b.a.n.o.e;
import c.b.a.n.p.n;
import java.io.File;
import java.util.List;

class b implements e, d.a<Object> {
    private final List<h> j;
    private final f<?> k;
    private final e.a l;
    private int m;
    private h n;
    private List<n<File, ?>> o;
    private int p;
    private volatile n.a<?> q;
    private File r;

    b(f<?> fVar, e.a aVar) {
        this(fVar.c(), fVar, aVar);
    }

    b(List<h> list, f<?> fVar, e.a aVar) {
        this.m = -1;
        this.j = list;
        this.k = fVar;
        this.l = aVar;
    }

    private boolean b() {
        return this.p < this.o.size();
    }

    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.o == null || !b()) {
                int i = this.m + 1;
                this.m = i;
                if (i >= this.j.size()) {
                    return false;
                }
                h hVar = this.j.get(this.m);
                File b2 = this.k.d().b(new c(hVar, this.k.o()));
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
                    int i2 = this.p;
                    this.p = i2 + 1;
                    this.q = list.get(i2).a(this.r, this.k.s(), this.k.f(), this.k.k());
                    if (this.q != null && this.k.t(this.q.f1081c.a())) {
                        this.q.f1081c.d(this.k.l(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    public void cancel() {
        n.a<?> aVar = this.q;
        if (aVar != null) {
            aVar.f1081c.cancel();
        }
    }

    public void g(Exception exc) {
        this.l.f(this.n, exc, this.q.f1081c, a.DATA_DISK_CACHE);
    }

    public void h(Object obj) {
        this.l.e(this.n, obj, this.q.f1081c, a.DATA_DISK_CACHE, this.n);
    }
}
