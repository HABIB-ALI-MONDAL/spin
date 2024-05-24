package c.b.a.r;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import b.d.j.d;
import c.b.a.e;
import c.b.a.n.o.j;
import c.b.a.n.o.p;
import c.b.a.n.o.u;
import c.b.a.r.i.h;
import c.b.a.r.j.c;
import c.b.a.t.i;
import c.b.a.t.j.a;

public final class g<R> implements b, c.b.a.r.i.g, f, a.f {
    private static final d<g<?>> J = c.b.a.t.j.a.d(150, new a());
    private static final boolean K = Log.isLoggable("Request", 2);
    private u<R> A;
    private j.d B;
    private long C;
    private b D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private int H;
    private int I;
    private boolean j;
    private final String k;
    private final c.b.a.t.j.b l;
    private d<R> m;
    private c n;
    private Context o;
    private e p;
    private Object q;
    private Class<R> r;
    private e s;
    private int t;
    private int u;
    private c.b.a.g v;
    private h<R> w;
    private d<R> x;
    private j y;
    private c<? super R> z;

    class a implements a.d<g<?>> {
        a() {
        }

        /* renamed from: b */
        public g<?> a() {
            return new g<>();
        }
    }

    private enum b {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    g() {
        this.k = K ? String.valueOf(super.hashCode()) : null;
        this.l = c.b.a.t.j.b.a();
    }

    public static <R> g<R> A(Context context, e eVar, Object obj, Class<R> cls, e eVar2, int i, int i2, c.b.a.g gVar, h<R> hVar, d<R> dVar, d<R> dVar2, c cVar, j jVar, c<? super R> cVar2) {
        g<R> b2 = J.b();
        if (b2 == null) {
            b2 = new g<>();
        }
        b2.t(context, eVar, obj, cls, eVar2, i, i2, gVar, hVar, dVar, dVar2, cVar, jVar, cVar2);
        return b2;
    }

    /* JADX INFO: finally extract failed */
    private void B(p pVar, int i) {
        d<R> dVar;
        this.l.c();
        int f2 = this.p.f();
        if (f2 <= i) {
            Log.w("Glide", "Load failed for " + this.q + " with size [" + this.H + "x" + this.I + "]", pVar);
            if (f2 <= 4) {
                pVar.g("Glide");
            }
        }
        this.B = null;
        this.D = b.FAILED;
        this.j = true;
        try {
            d<R> dVar2 = this.x;
            if ((dVar2 == null || !dVar2.b(pVar, this.q, this.w, u())) && ((dVar = this.m) == null || !dVar.b(pVar, this.q, this.w, u()))) {
                E();
            }
            this.j = false;
            y();
        } catch (Throwable th) {
            this.j = false;
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x008e, code lost:
        if (r0.a(r9, r7.q, r7.w, r10, r6) == false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x007d, code lost:
        if (r0.a(r9, r7.q, r7.w, r10, r6) == false) goto L_0x007f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void C(c.b.a.n.o.u<R> r8, R r9, c.b.a.n.a r10) {
        /*
            r7 = this;
            boolean r6 = r7.u()
            c.b.a.r.g$b r0 = c.b.a.r.g.b.COMPLETE
            r7.D = r0
            r7.A = r8
            c.b.a.e r8 = r7.p
            int r8 = r8.f()
            r0 = 3
            if (r8 > r0) goto L_0x006a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Finished loading "
            r8.append(r0)
            java.lang.Class r0 = r9.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r8.append(r0)
            java.lang.String r0 = " from "
            r8.append(r0)
            r8.append(r10)
            java.lang.String r0 = " for "
            r8.append(r0)
            java.lang.Object r0 = r7.q
            r8.append(r0)
            java.lang.String r0 = " with size ["
            r8.append(r0)
            int r0 = r7.H
            r8.append(r0)
            java.lang.String r0 = "x"
            r8.append(r0)
            int r0 = r7.I
            r8.append(r0)
            java.lang.String r0 = "] in "
            r8.append(r0)
            long r0 = r7.C
            double r0 = c.b.a.t.d.a(r0)
            r8.append(r0)
            java.lang.String r0 = " ms"
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            java.lang.String r0 = "Glide"
            android.util.Log.d(r0, r8)
        L_0x006a:
            r8 = 1
            r7.j = r8
            r8 = 0
            c.b.a.r.d<R> r0 = r7.x     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x007f
            java.lang.Object r2 = r7.q     // Catch:{ all -> 0x00a1 }
            c.b.a.r.i.h<R> r3 = r7.w     // Catch:{ all -> 0x00a1 }
            r1 = r9
            r4 = r10
            r5 = r6
            boolean r0 = r0.a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a1 }
            if (r0 != 0) goto L_0x009b
        L_0x007f:
            c.b.a.r.d<R> r0 = r7.m     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x0090
            java.lang.Object r2 = r7.q     // Catch:{ all -> 0x00a1 }
            c.b.a.r.i.h<R> r3 = r7.w     // Catch:{ all -> 0x00a1 }
            r1 = r9
            r4 = r10
            r5 = r6
            boolean r0 = r0.a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a1 }
            if (r0 != 0) goto L_0x009b
        L_0x0090:
            c.b.a.r.j.c<? super R> r0 = r7.z     // Catch:{ all -> 0x00a1 }
            c.b.a.r.j.b r10 = r0.a(r10, r6)     // Catch:{ all -> 0x00a1 }
            c.b.a.r.i.h<R> r0 = r7.w     // Catch:{ all -> 0x00a1 }
            r0.c(r9, r10)     // Catch:{ all -> 0x00a1 }
        L_0x009b:
            r7.j = r8
            r7.z()
            return
        L_0x00a1:
            r9 = move-exception
            r7.j = r8
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.r.g.C(c.b.a.n.o.u, java.lang.Object, c.b.a.n.a):void");
    }

    private void D(u<?> uVar) {
        this.y.j(uVar);
        this.A = null;
    }

    private void E() {
        if (n()) {
            Drawable drawable = null;
            if (this.q == null) {
                drawable = r();
            }
            if (drawable == null) {
                drawable = q();
            }
            if (drawable == null) {
                drawable = s();
            }
            this.w.d(drawable);
        }
    }

    private void l() {
        if (this.j) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean m() {
        c cVar = this.n;
        return cVar == null || cVar.m(this);
    }

    private boolean n() {
        c cVar = this.n;
        return cVar == null || cVar.l(this);
    }

    private boolean o() {
        c cVar = this.n;
        return cVar == null || cVar.a(this);
    }

    private Drawable q() {
        if (this.E == null) {
            Drawable o2 = this.s.o();
            this.E = o2;
            if (o2 == null && this.s.n() > 0) {
                this.E = v(this.s.n());
            }
        }
        return this.E;
    }

    private Drawable r() {
        if (this.G == null) {
            Drawable p2 = this.s.p();
            this.G = p2;
            if (p2 == null && this.s.q() > 0) {
                this.G = v(this.s.q());
            }
        }
        return this.G;
    }

    private Drawable s() {
        if (this.F == null) {
            Drawable v2 = this.s.v();
            this.F = v2;
            if (v2 == null && this.s.w() > 0) {
                this.F = v(this.s.w());
            }
        }
        return this.F;
    }

    private void t(Context context, e eVar, Object obj, Class<R> cls, e eVar2, int i, int i2, c.b.a.g gVar, h<R> hVar, d<R> dVar, d<R> dVar2, c cVar, j jVar, c<? super R> cVar2) {
        this.o = context;
        this.p = eVar;
        this.q = obj;
        this.r = cls;
        this.s = eVar2;
        this.t = i;
        this.u = i2;
        this.v = gVar;
        this.w = hVar;
        this.m = dVar;
        this.x = dVar2;
        this.n = cVar;
        this.y = jVar;
        this.z = cVar2;
        this.D = b.PENDING;
    }

    private boolean u() {
        c cVar = this.n;
        return cVar == null || !cVar.k();
    }

    private Drawable v(int i) {
        return c.b.a.n.q.e.a.b(this.p, i, this.s.B() != null ? this.s.B() : this.o.getTheme());
    }

    private void w(String str) {
        Log.v("Request", str + " this: " + this.k);
    }

    private static int x(int i, float f2) {
        return i == Integer.MIN_VALUE ? i : Math.round(f2 * ((float) i));
    }

    private void y() {
        c cVar = this.n;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    private void z() {
        c cVar = this.n;
        if (cVar != null) {
            cVar.f(this);
        }
    }

    public void a(p pVar) {
        B(pVar, 5);
    }

    public void b() {
        l();
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = -1;
        this.u = -1;
        this.w = null;
        this.x = null;
        this.m = null;
        this.n = null;
        this.z = null;
        this.B = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = -1;
        this.I = -1;
        J.a(this);
    }

    public void c(u<?> uVar, c.b.a.n.a aVar) {
        this.l.c();
        this.B = null;
        if (uVar == null) {
            a(new p("Expected to receive a Resource<R> with an object of " + this.r + " inside, but instead got null."));
            return;
        }
        Object obj = uVar.get();
        if (obj == null || !this.r.isAssignableFrom(obj.getClass())) {
            D(uVar);
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive an object of ");
            sb.append(this.r);
            sb.append(" but instead got ");
            String str = "";
            sb.append(obj != null ? obj.getClass() : str);
            sb.append("{");
            sb.append(obj);
            sb.append("} inside Resource{");
            sb.append(uVar);
            sb.append("}.");
            if (obj == null) {
                str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            sb.append(str);
            a(new p(sb.toString()));
        } else if (!o()) {
            D(uVar);
            this.D = b.COMPLETE;
        } else {
            C(uVar, obj, aVar);
        }
    }

    public void clear() {
        i.a();
        l();
        this.l.c();
        b bVar = this.D;
        b bVar2 = b.CLEARED;
        if (bVar != bVar2) {
            p();
            u<R> uVar = this.A;
            if (uVar != null) {
                D(uVar);
            }
            if (m()) {
                this.w.f(s());
            }
            this.D = bVar2;
        }
    }

    public void d() {
        clear();
        this.D = b.PAUSED;
    }

    public void e() {
        l();
        this.l.c();
        this.C = c.b.a.t.d.b();
        if (this.q == null) {
            if (i.r(this.t, this.u)) {
                this.H = this.t;
                this.I = this.u;
            }
            B(new p("Received null model"), r() == null ? 5 : 3);
            return;
        }
        b bVar = this.D;
        b bVar2 = b.RUNNING;
        if (bVar == bVar2) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (bVar == b.COMPLETE) {
            c(this.A, c.b.a.n.a.MEMORY_CACHE);
        } else {
            b bVar3 = b.WAITING_FOR_SIZE;
            this.D = bVar3;
            if (i.r(this.t, this.u)) {
                f(this.t, this.u);
            } else {
                this.w.g(this);
            }
            b bVar4 = this.D;
            if ((bVar4 == bVar2 || bVar4 == bVar3) && n()) {
                this.w.b(s());
            }
            if (K) {
                w("finished run method in " + c.b.a.t.d.a(this.C));
            }
        }
    }

    public void f(int i, int i2) {
        this.l.c();
        boolean z2 = K;
        if (z2) {
            w("Got onSizeReady in " + c.b.a.t.d.a(this.C));
        }
        if (this.D == b.WAITING_FOR_SIZE) {
            b bVar = b.RUNNING;
            this.D = bVar;
            float A2 = this.s.A();
            this.H = x(i, A2);
            this.I = x(i2, A2);
            if (z2) {
                w("finished setup for calling load in " + c.b.a.t.d.a(this.C));
            }
            j jVar = this.y;
            b bVar2 = bVar;
            e eVar = this.p;
            j.d f2 = jVar.f(eVar, this.q, this.s.z(), this.H, this.I, this.s.y(), this.r, this.v, this.s.m(), this.s.C(), this.s.L(), this.s.H(), this.s.s(), this.s.F(), this.s.E(), this.s.D(), this.s.r(), this);
            this.B = f2;
            if (this.D != bVar2) {
                this.B = null;
            }
            if (z2) {
                w("finished onSizeReady in " + c.b.a.t.d.a(this.C));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(c.b.a.r.b r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof c.b.a.r.g
            r1 = 0
            if (r0 == 0) goto L_0x0043
            c.b.a.r.g r4 = (c.b.a.r.g) r4
            int r0 = r3.t
            int r2 = r4.t
            if (r0 != r2) goto L_0x0043
            int r0 = r3.u
            int r2 = r4.u
            if (r0 != r2) goto L_0x0043
            java.lang.Object r0 = r3.q
            java.lang.Object r2 = r4.q
            boolean r0 = c.b.a.t.i.b(r0, r2)
            if (r0 == 0) goto L_0x0043
            java.lang.Class<R> r0 = r3.r
            java.lang.Class<R> r2 = r4.r
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0043
            c.b.a.r.e r0 = r3.s
            c.b.a.r.e r2 = r4.s
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0043
            c.b.a.g r0 = r3.v
            c.b.a.g r2 = r4.v
            if (r0 != r2) goto L_0x0043
            c.b.a.r.d<R> r0 = r3.x
            c.b.a.r.d<R> r4 = r4.x
            if (r0 == 0) goto L_0x0040
            if (r4 == 0) goto L_0x0043
            goto L_0x0042
        L_0x0040:
            if (r4 != 0) goto L_0x0043
        L_0x0042:
            r1 = 1
        L_0x0043:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.r.g.g(c.b.a.r.b):boolean");
    }

    public boolean h() {
        return this.D == b.FAILED;
    }

    public boolean i() {
        return j();
    }

    public boolean isCancelled() {
        b bVar = this.D;
        return bVar == b.CANCELLED || bVar == b.CLEARED;
    }

    public boolean isRunning() {
        b bVar = this.D;
        return bVar == b.RUNNING || bVar == b.WAITING_FOR_SIZE;
    }

    public boolean j() {
        return this.D == b.COMPLETE;
    }

    public c.b.a.t.j.b k() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        l();
        this.l.c();
        this.w.a(this);
        this.D = b.CANCELLED;
        j.d dVar = this.B;
        if (dVar != null) {
            dVar.a();
            this.B = null;
        }
    }
}
