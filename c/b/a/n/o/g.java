package c.b.a.n.o;

import android.os.Build;
import android.util.Log;
import c.b.a.n.i;
import c.b.a.n.j;
import c.b.a.n.l;
import c.b.a.n.m;
import c.b.a.n.o.e;
import c.b.a.n.o.h;
import c.b.a.n.q.c.k;
import c.b.a.t.j.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class g<R> implements e.a, Runnable, Comparable<g<?>>, a.f {
    private h A;
    private C0045g B;
    private long C;
    private boolean D;
    private Thread E;
    private c.b.a.n.h F;
    private c.b.a.n.h G;
    private Object H;
    private c.b.a.n.a I;
    private c.b.a.n.n.d<?> J;
    private volatile e K;
    private volatile boolean L;
    private volatile boolean M;
    private final f<R> j = new f<>();
    private final List<Throwable> k = new ArrayList();
    private final c.b.a.t.j.b l = c.b.a.t.j.b.a();
    private final e m;
    private final b.d.j.d<g<?>> n;
    private final d<?> o = new d<>();
    private final f p = new f();
    private c.b.a.e q;
    private c.b.a.n.h r;
    private c.b.a.g s;
    private m t;
    private int u;
    private int v;
    private i w;
    private j x;
    private b<R> y;
    private int z;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f955a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f956b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f957c;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
        static {
            /*
                c.b.a.n.c[] r0 = c.b.a.n.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f957c = r0
                r1 = 1
                c.b.a.n.c r2 = c.b.a.n.c.SOURCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f957c     // Catch:{ NoSuchFieldError -> 0x001d }
                c.b.a.n.c r3 = c.b.a.n.c.TRANSFORMED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                c.b.a.n.o.g$h[] r2 = c.b.a.n.o.g.h.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f956b = r2
                c.b.a.n.o.g$h r3 = c.b.a.n.o.g.h.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f956b     // Catch:{ NoSuchFieldError -> 0x0038 }
                c.b.a.n.o.g$h r3 = c.b.a.n.o.g.h.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = f956b     // Catch:{ NoSuchFieldError -> 0x0043 }
                c.b.a.n.o.g$h r4 = c.b.a.n.o.g.h.SOURCE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f956b     // Catch:{ NoSuchFieldError -> 0x004e }
                c.b.a.n.o.g$h r4 = c.b.a.n.o.g.h.FINISHED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r3 = f956b     // Catch:{ NoSuchFieldError -> 0x0059 }
                c.b.a.n.o.g$h r4 = c.b.a.n.o.g.h.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                c.b.a.n.o.g$g[] r3 = c.b.a.n.o.g.C0045g.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f955a = r3
                c.b.a.n.o.g$g r4 = c.b.a.n.o.g.C0045g.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x006a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                int[] r1 = f955a     // Catch:{ NoSuchFieldError -> 0x0074 }
                c.b.a.n.o.g$g r3 = c.b.a.n.o.g.C0045g.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r0 = f955a     // Catch:{ NoSuchFieldError -> 0x007e }
                c.b.a.n.o.g$g r1 = c.b.a.n.o.g.C0045g.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.b.a.n.o.g.a.<clinit>():void");
        }
    }

    interface b<R> {
        void a(p pVar);

        void c(u<R> uVar, c.b.a.n.a aVar);

        void d(g<?> gVar);
    }

    private final class c<Z> implements h.a<Z> {

        /* renamed from: a  reason: collision with root package name */
        private final c.b.a.n.a f958a;

        c(c.b.a.n.a aVar) {
            this.f958a = aVar;
        }

        public u<Z> a(u<Z> uVar) {
            return g.this.y(this.f958a, uVar);
        }
    }

    private static class d<Z> {

        /* renamed from: a  reason: collision with root package name */
        private c.b.a.n.h f960a;

        /* renamed from: b  reason: collision with root package name */
        private l<Z> f961b;

        /* renamed from: c  reason: collision with root package name */
        private t<Z> f962c;

        d() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f960a = null;
            this.f961b = null;
            this.f962c = null;
        }

        /* access modifiers changed from: package-private */
        public void b(e eVar, j jVar) {
            b.d.g.f.a("DecodeJob.encode");
            try {
                eVar.a().a(this.f960a, new d(this.f961b, this.f962c, jVar));
            } finally {
                this.f962c.g();
                b.d.g.f.b();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f962c != null;
        }

        /* access modifiers changed from: package-private */
        public <X> void d(c.b.a.n.h hVar, l<X> lVar, t<X> tVar) {
            this.f960a = hVar;
            this.f961b = lVar;
            this.f962c = tVar;
        }
    }

    interface e {
        c.b.a.n.o.a0.a a();
    }

    private static class f {

        /* renamed from: a  reason: collision with root package name */
        private boolean f963a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f964b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f965c;

        f() {
        }

        private boolean a(boolean z) {
            return (this.f965c || z || this.f964b) && this.f963a;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean b() {
            this.f964b = true;
            return a(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean c() {
            this.f965c = true;
            return a(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean d(boolean z) {
            this.f963a = true;
            return a(z);
        }

        /* access modifiers changed from: package-private */
        public synchronized void e() {
            this.f964b = false;
            this.f963a = false;
            this.f965c = false;
        }
    }

    /* renamed from: c.b.a.n.o.g$g  reason: collision with other inner class name */
    private enum C0045g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    g(e eVar, b.d.j.d<g<?>> dVar) {
        this.m = eVar;
        this.n = dVar;
    }

    private void A() {
        this.p.e();
        this.o.a();
        this.j.a();
        this.L = false;
        this.q = null;
        this.r = null;
        this.x = null;
        this.s = null;
        this.t = null;
        this.y = null;
        this.A = null;
        this.K = null;
        this.E = null;
        this.F = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.C = 0;
        this.M = false;
        this.k.clear();
        this.n.a(this);
    }

    private void B() {
        this.E = Thread.currentThread();
        this.C = c.b.a.t.d.b();
        boolean z2 = false;
        while (!this.M && this.K != null && !(z2 = this.K.a())) {
            this.A = n(this.A);
            this.K = m();
            if (this.A == h.SOURCE) {
                d();
                return;
            }
        }
        if ((this.A == h.FINISHED || this.M) && !z2) {
            v();
        }
    }

    private <Data, ResourceType> u<R> C(Data data, c.b.a.n.a aVar, s<Data, ResourceType, R> sVar) {
        j o2 = o(aVar);
        c.b.a.n.n.e l2 = this.q.g().l(data);
        try {
            return sVar.a(l2, o2, this.u, this.v, new c(aVar));
        } finally {
            l2.b();
        }
    }

    private void D() {
        int i = a.f955a[this.B.ordinal()];
        if (i == 1) {
            this.A = n(h.INITIALIZE);
            this.K = m();
        } else if (i != 2) {
            if (i == 3) {
                l();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.B);
        }
        B();
    }

    private void E() {
        this.l.c();
        if (!this.L) {
            this.L = true;
            return;
        }
        throw new IllegalStateException("Already notified");
    }

    private <Data> u<R> i(c.b.a.n.n.d<?> dVar, Data data, c.b.a.n.a aVar) {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long b2 = c.b.a.t.d.b();
            u<R> j2 = j(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                r("Decoded result " + j2, b2);
            }
            return j2;
        } finally {
            dVar.b();
        }
    }

    private <Data> u<R> j(Data data, c.b.a.n.a aVar) {
        return C(data, aVar, this.j.h(data.getClass()));
    }

    private void l() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.C;
            s("Retrieved data", j2, "data: " + this.H + ", cache key: " + this.F + ", fetcher: " + this.J);
        }
        u<R> uVar = null;
        try {
            uVar = i(this.J, this.H, this.I);
        } catch (p e2) {
            e2.i(this.G, this.I);
            this.k.add(e2);
        }
        if (uVar != null) {
            u(uVar, this.I);
        } else {
            B();
        }
    }

    private e m() {
        int i = a.f956b[this.A.ordinal()];
        if (i == 1) {
            return new v(this.j, this);
        }
        if (i == 2) {
            return new b(this.j, this);
        }
        if (i == 3) {
            return new y(this.j, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.A);
    }

    private h n(h hVar) {
        int i = a.f956b[hVar.ordinal()];
        if (i == 1) {
            return this.w.a() ? h.DATA_CACHE : n(h.DATA_CACHE);
        }
        if (i == 2) {
            return this.D ? h.FINISHED : h.SOURCE;
        }
        if (i == 3 || i == 4) {
            return h.FINISHED;
        }
        if (i == 5) {
            return this.w.b() ? h.RESOURCE_CACHE : n(h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + hVar);
    }

    private j o(c.b.a.n.a aVar) {
        j jVar = this.x;
        if (Build.VERSION.SDK_INT < 26) {
            return jVar;
        }
        i iVar = k.i;
        if (jVar.c(iVar) != null) {
            return jVar;
        }
        if (aVar != c.b.a.n.a.RESOURCE_DISK_CACHE && !this.j.w()) {
            return jVar;
        }
        j jVar2 = new j();
        jVar2.d(this.x);
        jVar2.e(iVar, Boolean.TRUE);
        return jVar2;
    }

    private int p() {
        return this.s.ordinal();
    }

    private void r(String str, long j2) {
        s(str, j2, (String) null);
    }

    private void s(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(c.b.a.t.d.a(j2));
        sb.append(", load key: ");
        sb.append(this.t);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void t(u<R> uVar, c.b.a.n.a aVar) {
        E();
        this.y.c(uVar, aVar);
    }

    private void u(u<R> uVar, c.b.a.n.a aVar) {
        if (uVar instanceof q) {
            ((q) uVar).a();
        }
        t<R> tVar = null;
        t<R> tVar2 = uVar;
        if (this.o.c()) {
            t<R> e2 = t.e(uVar);
            tVar = e2;
            tVar2 = e2;
        }
        t(tVar2, aVar);
        this.A = h.ENCODE;
        try {
            if (this.o.c()) {
                this.o.b(this.m, this.x);
            }
            w();
        } finally {
            if (tVar != null) {
                tVar.g();
            }
        }
    }

    private void v() {
        E();
        this.y.a(new p("Failed to load resource", (List<Throwable>) new ArrayList(this.k)));
        x();
    }

    private void w() {
        if (this.p.b()) {
            A();
        }
    }

    private void x() {
        if (this.p.c()) {
            A();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        h n2 = n(h.INITIALIZE);
        return n2 == h.RESOURCE_CACHE || n2 == h.DATA_CACHE;
    }

    public void d() {
        this.B = C0045g.SWITCH_TO_SOURCE_SERVICE;
        this.y.d(this);
    }

    public void e(c.b.a.n.h hVar, Object obj, c.b.a.n.n.d<?> dVar, c.b.a.n.a aVar, c.b.a.n.h hVar2) {
        this.F = hVar;
        this.H = obj;
        this.J = dVar;
        this.I = aVar;
        this.G = hVar2;
        if (Thread.currentThread() != this.E) {
            this.B = C0045g.DECODE_DATA;
            this.y.d(this);
            return;
        }
        b.d.g.f.a("DecodeJob.decodeFromRetrievedData");
        try {
            l();
        } finally {
            b.d.g.f.b();
        }
    }

    public void f(c.b.a.n.h hVar, Exception exc, c.b.a.n.n.d<?> dVar, c.b.a.n.a aVar) {
        dVar.b();
        p pVar = new p("Fetching data failed", (Throwable) exc);
        pVar.j(hVar, aVar, dVar.a());
        this.k.add(pVar);
        if (Thread.currentThread() != this.E) {
            this.B = C0045g.SWITCH_TO_SOURCE_SERVICE;
            this.y.d(this);
            return;
        }
        B();
    }

    public void g() {
        this.M = true;
        e eVar = this.K;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    /* renamed from: h */
    public int compareTo(g<?> gVar) {
        int p2 = p() - gVar.p();
        return p2 == 0 ? this.z - gVar.z : p2;
    }

    public c.b.a.t.j.b k() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public g<R> q(c.b.a.e eVar, Object obj, m mVar, c.b.a.n.h hVar, int i, int i2, Class<?> cls, Class<R> cls2, c.b.a.g gVar, i iVar, Map<Class<?>, m<?>> map, boolean z2, boolean z3, boolean z4, j jVar, b<R> bVar, int i3) {
        this.j.u(eVar, obj, hVar, i, i2, iVar, cls, cls2, gVar, jVar, map, z2, z3, this.m);
        this.q = eVar;
        this.r = hVar;
        this.s = gVar;
        this.t = mVar;
        this.u = i;
        this.v = i2;
        this.w = iVar;
        this.D = z4;
        this.x = jVar;
        this.y = bVar;
        this.z = i3;
        this.B = C0045g.INITIALIZE;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r1 != null) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            java.lang.String r0 = "DecodeJob"
            java.lang.String r1 = "DecodeJob#run"
            b.d.g.f.a(r1)
            c.b.a.n.n.d<?> r1 = r5.J
            boolean r2 = r5.M     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x0019
            r5.v()     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0015
            r1.b()
        L_0x0015:
            b.d.g.f.b()
            return
        L_0x0019:
            r5.D()     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0021
        L_0x001e:
            r1.b()
        L_0x0021:
            b.d.g.f.b()
            goto L_0x0062
        L_0x0025:
            r2 = move-exception
            r3 = 3
            boolean r3 = android.util.Log.isLoggable(r0, r3)     // Catch:{ all -> 0x0064 }
            if (r3 == 0) goto L_0x004d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r3.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = "DecodeJob threw unexpectedly, isCancelled: "
            r3.append(r4)     // Catch:{ all -> 0x0064 }
            boolean r4 = r5.M     // Catch:{ all -> 0x0064 }
            r3.append(r4)     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = ", stage: "
            r3.append(r4)     // Catch:{ all -> 0x0064 }
            c.b.a.n.o.g$h r4 = r5.A     // Catch:{ all -> 0x0064 }
            r3.append(r4)     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0064 }
            android.util.Log.d(r0, r3, r2)     // Catch:{ all -> 0x0064 }
        L_0x004d:
            c.b.a.n.o.g$h r0 = r5.A     // Catch:{ all -> 0x0064 }
            c.b.a.n.o.g$h r3 = c.b.a.n.o.g.h.ENCODE     // Catch:{ all -> 0x0064 }
            if (r0 == r3) goto L_0x005b
            java.util.List<java.lang.Throwable> r0 = r5.k     // Catch:{ all -> 0x0064 }
            r0.add(r2)     // Catch:{ all -> 0x0064 }
            r5.v()     // Catch:{ all -> 0x0064 }
        L_0x005b:
            boolean r0 = r5.M     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x0063
            if (r1 == 0) goto L_0x0021
            goto L_0x001e
        L_0x0062:
            return
        L_0x0063:
            throw r2     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r0 = move-exception
            if (r1 == 0) goto L_0x006a
            r1.b()
        L_0x006a:
            b.d.g.f.b()
            goto L_0x006f
        L_0x006e:
            throw r0
        L_0x006f:
            goto L_0x006e
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.n.o.g.run():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: c.b.a.n.o.w} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: c.b.a.n.o.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: c.b.a.n.o.w} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: c.b.a.n.o.w} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Z> c.b.a.n.o.u<Z> y(c.b.a.n.a r12, c.b.a.n.o.u<Z> r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r13.get()
            java.lang.Class r8 = r0.getClass()
            c.b.a.n.a r0 = c.b.a.n.a.RESOURCE_DISK_CACHE
            r1 = 0
            if (r12 == r0) goto L_0x0020
            c.b.a.n.o.f<R> r0 = r11.j
            c.b.a.n.m r0 = r0.r(r8)
            c.b.a.e r2 = r11.q
            int r3 = r11.u
            int r4 = r11.v
            c.b.a.n.o.u r2 = r0.b(r2, r13, r3, r4)
            r7 = r0
            r0 = r2
            goto L_0x0022
        L_0x0020:
            r0 = r13
            r7 = r1
        L_0x0022:
            boolean r2 = r13.equals(r0)
            if (r2 != 0) goto L_0x002b
            r13.b()
        L_0x002b:
            c.b.a.n.o.f<R> r13 = r11.j
            boolean r13 = r13.v(r0)
            if (r13 == 0) goto L_0x0040
            c.b.a.n.o.f<R> r13 = r11.j
            c.b.a.n.l r1 = r13.n(r0)
            c.b.a.n.j r13 = r11.x
            c.b.a.n.c r13 = r1.b(r13)
            goto L_0x0042
        L_0x0040:
            c.b.a.n.c r13 = c.b.a.n.c.NONE
        L_0x0042:
            r10 = r1
            c.b.a.n.o.f<R> r1 = r11.j
            c.b.a.n.h r2 = r11.F
            boolean r1 = r1.x(r2)
            r2 = 1
            r1 = r1 ^ r2
            c.b.a.n.o.i r3 = r11.w
            boolean r12 = r3.d(r1, r12, r13)
            if (r12 == 0) goto L_0x00b3
            if (r10 == 0) goto L_0x00a5
            int[] r12 = c.b.a.n.o.g.a.f957c
            int r1 = r13.ordinal()
            r12 = r12[r1]
            if (r12 == r2) goto L_0x0092
            r1 = 2
            if (r12 != r1) goto L_0x007b
            c.b.a.n.o.w r12 = new c.b.a.n.o.w
            c.b.a.n.o.f<R> r13 = r11.j
            c.b.a.n.o.z.b r2 = r13.b()
            c.b.a.n.h r3 = r11.F
            c.b.a.n.h r4 = r11.r
            int r5 = r11.u
            int r6 = r11.v
            c.b.a.n.j r9 = r11.x
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x009b
        L_0x007b:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown strategy: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r12.<init>(r13)
            throw r12
        L_0x0092:
            c.b.a.n.o.c r12 = new c.b.a.n.o.c
            c.b.a.n.h r13 = r11.F
            c.b.a.n.h r1 = r11.r
            r12.<init>(r13, r1)
        L_0x009b:
            c.b.a.n.o.t r0 = c.b.a.n.o.t.e(r0)
            c.b.a.n.o.g$d<?> r13 = r11.o
            r13.d(r12, r10, r0)
            goto L_0x00b3
        L_0x00a5:
            c.b.a.h$d r12 = new c.b.a.h$d
            java.lang.Object r13 = r0.get()
            java.lang.Class r13 = r13.getClass()
            r12.<init>(r13)
            throw r12
        L_0x00b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.n.o.g.y(c.b.a.n.a, c.b.a.n.o.u):c.b.a.n.o.u");
    }

    /* access modifiers changed from: package-private */
    public void z(boolean z2) {
        if (this.p.d(z2)) {
            A();
        }
    }
}
