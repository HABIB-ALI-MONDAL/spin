package c.b.a.n.o;

import android.os.Looper;
import c.b.a.n.h;

class o<Z> implements u<Z> {
    private final boolean j;
    private final boolean k;
    private a l;
    private h m;
    private int n;
    private boolean o;
    private final u<Z> p;

    interface a {
        void a(h hVar, o<?> oVar);
    }

    o(u<Z> uVar, boolean z, boolean z2) {
        c.b.a.t.h.d(uVar);
        this.p = uVar;
        this.j = z;
        this.k = z2;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.o) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.n++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    public void b() {
        if (this.n > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.o) {
            this.o = true;
            if (this.k) {
                this.p.b();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public int c() {
        return this.p.c();
    }

    public Class<Z> d() {
        return this.p.d();
    }

    /* access modifiers changed from: package-private */
    public u<Z> e() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.n <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.n - 1;
            this.n = i;
            if (i == 0) {
                this.l.a(this.m, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }

    public Z get() {
        return this.p.get();
    }

    /* access modifiers changed from: package-private */
    public void h(h hVar, a aVar) {
        this.m = hVar;
        this.l = aVar;
    }

    public String toString() {
        return "EngineResource{isCacheable=" + this.j + ", listener=" + this.l + ", key=" + this.m + ", acquired=" + this.n + ", isRecycled=" + this.o + ", resource=" + this.p + '}';
    }
}
