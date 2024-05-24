package c.d.a.b.e.e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

public abstract class q6 {
    private static final Object g = new Object();
    @Nullable
    private static volatile n6 h;
    private static final AtomicInteger i = new AtomicInteger();
    public static final /* synthetic */ int j = 0;

    /* renamed from: a  reason: collision with root package name */
    final m6 f1730a;

    /* renamed from: b  reason: collision with root package name */
    final String f1731b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f1732c;

    /* renamed from: d  reason: collision with root package name */
    private volatile int f1733d = -1;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f1734e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1735f;

    static {
        new AtomicReference();
        new s6(h6.f1644a, (byte[]) null);
    }

    /* synthetic */ q6(m6 m6Var, String str, Object obj, boolean z, p6 p6Var) {
        if (m6Var.f1686b != null) {
            this.f1730a = m6Var;
            this.f1731b = str;
            this.f1732c = obj;
            this.f1735f = true;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public static void d() {
        i.incrementAndGet();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static void e(android.content.Context r3) {
        /*
            c.d.a.b.e.e.n6 r0 = h
            if (r0 != 0) goto L_0x0045
            java.lang.Object r0 = g
            monitor-enter(r0)
            c.d.a.b.e.e.n6 r1 = h     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x0040
            monitor-enter(r0)     // Catch:{ all -> 0x0042 }
            c.d.a.b.e.e.n6 r1 = h     // Catch:{ all -> 0x003d }
            android.content.Context r2 = r3.getApplicationContext()     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0015
            r3 = r2
        L_0x0015:
            if (r1 == 0) goto L_0x001d
            android.content.Context r1 = r1.a()     // Catch:{ all -> 0x003d }
            if (r1 == r3) goto L_0x003b
        L_0x001d:
            c.d.a.b.e.e.t5.e()     // Catch:{ all -> 0x003d }
            c.d.a.b.e.e.r6.c()     // Catch:{ all -> 0x003d }
            c.d.a.b.e.e.b6.e()     // Catch:{ all -> 0x003d }
            c.d.a.b.e.e.g6 r1 = new c.d.a.b.e.e.g6     // Catch:{ all -> 0x003d }
            r1.<init>(r3)     // Catch:{ all -> 0x003d }
            c.d.a.b.e.e.x6 r1 = c.d.a.b.e.e.b7.a(r1)     // Catch:{ all -> 0x003d }
            c.d.a.b.e.e.q5 r2 = new c.d.a.b.e.e.q5     // Catch:{ all -> 0x003d }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x003d }
            h = r2     // Catch:{ all -> 0x003d }
            java.util.concurrent.atomic.AtomicInteger r3 = i     // Catch:{ all -> 0x003d }
            r3.incrementAndGet()     // Catch:{ all -> 0x003d }
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            goto L_0x0040
        L_0x003d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            throw r3     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            return
        L_0x0042:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            throw r3
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.q6.e(android.content.Context):void");
    }

    /* access modifiers changed from: package-private */
    public abstract Object a(Object obj);

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        r2 = r2.a(c());
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b() {
        /*
            r6 = this;
            boolean r0 = r6.f1735f
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = r6.f1731b
            java.lang.String r1 = "flagName must not be null"
            java.util.Objects.requireNonNull(r0, r1)
        L_0x000b:
            java.util.concurrent.atomic.AtomicInteger r0 = i
            int r0 = r0.get()
            int r1 = r6.f1733d
            if (r1 >= r0) goto L_0x00dc
            monitor-enter(r6)
            int r1 = r6.f1733d     // Catch:{ all -> 0x00d9 }
            if (r1 >= r0) goto L_0x00d7
            c.d.a.b.e.e.n6 r1 = h     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = "Must call PhenotypeFlag.init() first"
            if (r1 == 0) goto L_0x00d1
            c.d.a.b.e.e.m6 r2 = r6.f1730a     // Catch:{ all -> 0x00d9 }
            boolean r3 = r2.f1690f     // Catch:{ all -> 0x00d9 }
            android.net.Uri r2 = r2.f1686b     // Catch:{ all -> 0x00d9 }
            r3 = 0
            if (r2 == 0) goto L_0x0050
            android.content.Context r2 = r1.a()     // Catch:{ all -> 0x00d9 }
            c.d.a.b.e.e.m6 r4 = r6.f1730a     // Catch:{ all -> 0x00d9 }
            android.net.Uri r4 = r4.f1686b     // Catch:{ all -> 0x00d9 }
            boolean r2 = c.d.a.b.e.e.d6.a(r2, r4)     // Catch:{ all -> 0x00d9 }
            if (r2 == 0) goto L_0x004e
            c.d.a.b.e.e.m6 r2 = r6.f1730a     // Catch:{ all -> 0x00d9 }
            boolean r2 = r2.h     // Catch:{ all -> 0x00d9 }
            android.content.Context r2 = r1.a()     // Catch:{ all -> 0x00d9 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x00d9 }
            c.d.a.b.e.e.m6 r4 = r6.f1730a     // Catch:{ all -> 0x00d9 }
            android.net.Uri r4 = r4.f1686b     // Catch:{ all -> 0x00d9 }
            c.d.a.b.e.e.f6 r5 = c.d.a.b.e.e.f6.j     // Catch:{ all -> 0x00d9 }
            c.d.a.b.e.e.t5 r2 = c.d.a.b.e.e.t5.b(r2, r4, r5)     // Catch:{ all -> 0x00d9 }
            goto L_0x005e
        L_0x004e:
            r2 = r3
            goto L_0x005e
        L_0x0050:
            android.content.Context r2 = r1.a()     // Catch:{ all -> 0x00d9 }
            c.d.a.b.e.e.m6 r4 = r6.f1730a     // Catch:{ all -> 0x00d9 }
            java.lang.String r4 = r4.f1685a     // Catch:{ all -> 0x00d9 }
            c.d.a.b.e.e.f6 r4 = c.d.a.b.e.e.f6.j     // Catch:{ all -> 0x00d9 }
            c.d.a.b.e.e.r6 r2 = c.d.a.b.e.e.r6.b(r2, r3, r4)     // Catch:{ all -> 0x00d9 }
        L_0x005e:
            if (r2 == 0) goto L_0x006f
            java.lang.String r4 = r6.c()     // Catch:{ all -> 0x00d9 }
            java.lang.Object r2 = r2.a(r4)     // Catch:{ all -> 0x00d9 }
            if (r2 == 0) goto L_0x006f
            java.lang.Object r2 = r6.a(r2)     // Catch:{ all -> 0x00d9 }
            goto L_0x0070
        L_0x006f:
            r2 = r3
        L_0x0070:
            if (r2 == 0) goto L_0x0073
            goto L_0x009f
        L_0x0073:
            c.d.a.b.e.e.m6 r2 = r6.f1730a     // Catch:{ all -> 0x00d9 }
            boolean r4 = r2.f1689e     // Catch:{ all -> 0x00d9 }
            if (r4 != 0) goto L_0x009a
            c.d.a.b.e.e.u6 r2 = r2.i     // Catch:{ all -> 0x00d9 }
            android.content.Context r2 = r1.a()     // Catch:{ all -> 0x00d9 }
            c.d.a.b.e.e.b6 r2 = c.d.a.b.e.e.b6.b(r2)     // Catch:{ all -> 0x00d9 }
            c.d.a.b.e.e.m6 r4 = r6.f1730a     // Catch:{ all -> 0x00d9 }
            boolean r5 = r4.f1689e     // Catch:{ all -> 0x00d9 }
            if (r5 == 0) goto L_0x008b
            r4 = r3
            goto L_0x008f
        L_0x008b:
            java.lang.String r4 = r4.f1687c     // Catch:{ all -> 0x00d9 }
            java.lang.String r4 = r6.f1731b     // Catch:{ all -> 0x00d9 }
        L_0x008f:
            java.lang.String r2 = r2.a(r4)     // Catch:{ all -> 0x00d9 }
            if (r2 == 0) goto L_0x009a
            java.lang.Object r2 = r6.a(r2)     // Catch:{ all -> 0x00d9 }
            goto L_0x009b
        L_0x009a:
            r2 = r3
        L_0x009b:
            if (r2 != 0) goto L_0x009f
            java.lang.Object r2 = r6.f1732c     // Catch:{ all -> 0x00d9 }
        L_0x009f:
            c.d.a.b.e.e.x6 r1 = r1.b()     // Catch:{ all -> 0x00d9 }
            java.lang.Object r1 = r1.a()     // Catch:{ all -> 0x00d9 }
            c.d.a.b.e.e.v6 r1 = (c.d.a.b.e.e.v6) r1     // Catch:{ all -> 0x00d9 }
            boolean r4 = r1.b()     // Catch:{ all -> 0x00d9 }
            if (r4 == 0) goto L_0x00cc
            java.lang.Object r1 = r1.a()     // Catch:{ all -> 0x00d9 }
            c.d.a.b.e.e.v5 r1 = (c.d.a.b.e.e.v5) r1     // Catch:{ all -> 0x00d9 }
            c.d.a.b.e.e.m6 r2 = r6.f1730a     // Catch:{ all -> 0x00d9 }
            android.net.Uri r4 = r2.f1686b     // Catch:{ all -> 0x00d9 }
            java.lang.String r5 = r2.f1685a     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = r2.f1688d     // Catch:{ all -> 0x00d9 }
            java.lang.String r5 = r6.f1731b     // Catch:{ all -> 0x00d9 }
            java.lang.String r1 = r1.a(r4, r3, r2, r5)     // Catch:{ all -> 0x00d9 }
            if (r1 != 0) goto L_0x00c8
            java.lang.Object r2 = r6.f1732c     // Catch:{ all -> 0x00d9 }
            goto L_0x00cc
        L_0x00c8:
            java.lang.Object r2 = r6.a(r1)     // Catch:{ all -> 0x00d9 }
        L_0x00cc:
            r6.f1734e = r2     // Catch:{ all -> 0x00d9 }
            r6.f1733d = r0     // Catch:{ all -> 0x00d9 }
            goto L_0x00d7
        L_0x00d1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00d9 }
            r0.<init>(r2)     // Catch:{ all -> 0x00d9 }
            throw r0     // Catch:{ all -> 0x00d9 }
        L_0x00d7:
            monitor-exit(r6)     // Catch:{ all -> 0x00d9 }
            goto L_0x00dc
        L_0x00d9:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00d9 }
            throw r0
        L_0x00dc:
            java.lang.Object r0 = r6.f1734e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.q6.b():java.lang.Object");
    }

    public final String c() {
        String str = this.f1730a.f1688d;
        return this.f1731b;
    }
}
