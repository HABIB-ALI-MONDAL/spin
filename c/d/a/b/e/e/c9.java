package c.d.a.b.e.e;

public class c9 {

    /* renamed from: a  reason: collision with root package name */
    protected volatile x9 f1608a;

    /* renamed from: b  reason: collision with root package name */
    private volatile r7 f1609b;

    static {
        e8 e8Var = e8.f1626c;
    }

    public final int a() {
        if (this.f1609b != null) {
            return ((q7) this.f1609b).l.length;
        }
        if (this.f1608a != null) {
            return this.f1608a.e();
        }
        return 0;
    }

    public final r7 b() {
        if (this.f1609b != null) {
            return this.f1609b;
        }
        synchronized (this) {
            if (this.f1609b != null) {
                r7 r7Var = this.f1609b;
                return r7Var;
            }
            this.f1609b = this.f1608a == null ? r7.k : this.f1608a.b();
            r7 r7Var2 = this.f1609b;
            return r7Var2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(c.d.a.b.e.e.x9 r2) {
        /*
            r1 = this;
            c.d.a.b.e.e.x9 r0 = r1.f1608a
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            c.d.a.b.e.e.x9 r0 = r1.f1608a     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.f1608a = r2     // Catch:{ a9 -> 0x0011 }
            c.d.a.b.e.e.r7 r0 = c.d.a.b.e.e.r7.k     // Catch:{ a9 -> 0x0011 }
            r1.f1609b = r0     // Catch:{ a9 -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.f1608a = r2     // Catch:{ all -> 0x001b }
            c.d.a.b.e.e.r7 r2 = c.d.a.b.e.e.r7.k     // Catch:{ all -> 0x001b }
            r1.f1609b = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.c9.c(c.d.a.b.e.e.x9):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c9)) {
            return false;
        }
        c9 c9Var = (c9) obj;
        x9 x9Var = this.f1608a;
        x9 x9Var2 = c9Var.f1608a;
        if (x9Var == null && x9Var2 == null) {
            return b().equals(c9Var.b());
        }
        if (x9Var != null && x9Var2 != null) {
            return x9Var.equals(x9Var2);
        }
        if (x9Var != null) {
            c9Var.c(x9Var.d());
            return x9Var.equals(c9Var.f1608a);
        }
        c(x9Var2.d());
        return this.f1608a.equals(x9Var2);
    }

    public int hashCode() {
        return 1;
    }
}
