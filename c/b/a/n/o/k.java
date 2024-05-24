package c.b.a.n.o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import b.d.j.d;
import c.b.a.n.h;
import c.b.a.n.o.g;
import c.b.a.r.f;
import c.b.a.t.i;
import c.b.a.t.j.a;
import java.util.ArrayList;
import java.util.List;

class k<R> implements g.b<R>, a.f {
    private static final a G = new a();
    private static final Handler H = new Handler(Looper.getMainLooper(), new b());
    private p A;
    private boolean B;
    private List<f> C;
    private o<?> D;
    private g<R> E;
    private volatile boolean F;
    private final List<f> j;
    private final c.b.a.t.j.b k;
    private final d<k<?>> l;
    private final a m;
    private final l n;
    private final c.b.a.n.o.b0.a o;
    private final c.b.a.n.o.b0.a p;
    private final c.b.a.n.o.b0.a q;
    private final c.b.a.n.o.b0.a r;
    private h s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private u<?> x;
    private c.b.a.n.a y;
    private boolean z;

    static class a {
        a() {
        }

        public <R> o<R> a(u<R> uVar, boolean z) {
            return new o<>(uVar, z, true);
        }
    }

    private static class b implements Handler.Callback {
        b() {
        }

        public boolean handleMessage(Message message) {
            k kVar = (k) message.obj;
            int i = message.what;
            if (i == 1) {
                kVar.j();
            } else if (i == 2) {
                kVar.i();
            } else if (i == 3) {
                kVar.h();
            } else {
                throw new IllegalStateException("Unrecognized message: " + message.what);
            }
            return true;
        }
    }

    k(c.b.a.n.o.b0.a aVar, c.b.a.n.o.b0.a aVar2, c.b.a.n.o.b0.a aVar3, c.b.a.n.o.b0.a aVar4, l lVar, d<k<?>> dVar) {
        this(aVar, aVar2, aVar3, aVar4, lVar, dVar, G);
    }

    k(c.b.a.n.o.b0.a aVar, c.b.a.n.o.b0.a aVar2, c.b.a.n.o.b0.a aVar3, c.b.a.n.o.b0.a aVar4, l lVar, d<k<?>> dVar, a aVar5) {
        this.j = new ArrayList(2);
        this.k = c.b.a.t.j.b.a();
        this.o = aVar;
        this.p = aVar2;
        this.q = aVar3;
        this.r = aVar4;
        this.n = lVar;
        this.l = dVar;
        this.m = aVar5;
    }

    private void e(f fVar) {
        if (this.C == null) {
            this.C = new ArrayList(2);
        }
        if (!this.C.contains(fVar)) {
            this.C.add(fVar);
        }
    }

    private c.b.a.n.o.b0.a g() {
        return this.u ? this.q : this.v ? this.r : this.p;
    }

    private boolean m(f fVar) {
        List<f> list = this.C;
        return list != null && list.contains(fVar);
    }

    private void o(boolean z2) {
        i.a();
        this.j.clear();
        this.s = null;
        this.D = null;
        this.x = null;
        List<f> list = this.C;
        if (list != null) {
            list.clear();
        }
        this.B = false;
        this.F = false;
        this.z = false;
        this.E.z(z2);
        this.E = null;
        this.A = null;
        this.y = null;
        this.l.a(this);
    }

    public void a(p pVar) {
        this.A = pVar;
        H.obtainMessage(2, this).sendToTarget();
    }

    /* access modifiers changed from: package-private */
    public void b(f fVar) {
        i.a();
        this.k.c();
        if (this.z) {
            fVar.c(this.D, this.y);
        } else if (this.B) {
            fVar.a(this.A);
        } else {
            this.j.add(fVar);
        }
    }

    public void c(u<R> uVar, c.b.a.n.a aVar) {
        this.x = uVar;
        this.y = aVar;
        H.obtainMessage(1, this).sendToTarget();
    }

    public void d(g<?> gVar) {
        g().execute(gVar);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (!this.B && !this.z && !this.F) {
            this.F = true;
            this.E.g();
            this.n.d(this, this.s);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.k.c();
        if (this.F) {
            this.n.d(this, this.s);
            o(false);
            return;
        }
        throw new IllegalStateException("Not cancelled");
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.k.c();
        if (this.F) {
            o(false);
        } else if (this.j.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        } else if (!this.B) {
            this.B = true;
            this.n.c(this, this.s, (o<?>) null);
            for (f next : this.j) {
                if (!m(next)) {
                    next.a(this.A);
                }
            }
            o(false);
        } else {
            throw new IllegalStateException("Already failed once");
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.k.c();
        if (this.F) {
            this.x.b();
        } else if (this.j.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else if (!this.z) {
            o<?> a2 = this.m.a(this.x, this.t);
            this.D = a2;
            this.z = true;
            a2.a();
            this.n.c(this, this.s, this.D);
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.j.get(i);
                if (!m(fVar)) {
                    this.D.a();
                    fVar.c(this.D, this.y);
                }
            }
            this.D.g();
        } else {
            throw new IllegalStateException("Already have resource");
        }
        o(false);
    }

    public c.b.a.t.j.b k() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public k<R> l(h hVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.s = hVar;
        this.t = z2;
        this.u = z3;
        this.v = z4;
        this.w = z5;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return this.w;
    }

    /* access modifiers changed from: package-private */
    public void p(f fVar) {
        i.a();
        this.k.c();
        if (this.z || this.B) {
            e(fVar);
            return;
        }
        this.j.remove(fVar);
        if (this.j.isEmpty()) {
            f();
        }
    }

    public void q(g<R> gVar) {
        this.E = gVar;
        (gVar.F() ? this.o : g()).execute(gVar);
    }
}
