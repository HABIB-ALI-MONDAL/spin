package c.b.a.n.o;

import b.d.j.d;
import c.b.a.t.h;
import c.b.a.t.j.a;
import c.b.a.t.j.b;

final class t<Z> implements u<Z>, a.f {
    private static final d<t<?>> n = c.b.a.t.j.a.e(20, new a());
    private final b j = b.a();
    private u<Z> k;
    private boolean l;
    private boolean m;

    class a implements a.d<t<?>> {
        a() {
        }

        /* renamed from: b */
        public t<?> a() {
            return new t<>();
        }
    }

    t() {
    }

    private void a(u<Z> uVar) {
        this.m = false;
        this.l = true;
        this.k = uVar;
    }

    static <Z> t<Z> e(u<Z> uVar) {
        t<Z> b2 = n.b();
        h.d(b2);
        t<Z> tVar = b2;
        tVar.a(uVar);
        return tVar;
    }

    private void f() {
        this.k = null;
        n.a(this);
    }

    public synchronized void b() {
        this.j.c();
        this.m = true;
        if (!this.l) {
            this.k.b();
            f();
        }
    }

    public int c() {
        return this.k.c();
    }

    public Class<Z> d() {
        return this.k.d();
    }

    /* access modifiers changed from: package-private */
    public synchronized void g() {
        this.j.c();
        if (this.l) {
            this.l = false;
            if (this.m) {
                b();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public Z get() {
        return this.k.get();
    }

    public b k() {
        return this.j;
    }
}
