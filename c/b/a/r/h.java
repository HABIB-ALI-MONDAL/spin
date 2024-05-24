package c.b.a.r;

public class h implements c, b {
    private final c j;
    private b k;
    private b l;
    private boolean m;

    h() {
        this((c) null);
    }

    public h(c cVar) {
        this.j = cVar;
    }

    private boolean n() {
        c cVar = this.j;
        return cVar == null || cVar.m(this);
    }

    private boolean o() {
        c cVar = this.j;
        return cVar == null || cVar.l(this);
    }

    private boolean p() {
        c cVar = this.j;
        return cVar == null || cVar.a(this);
    }

    private boolean q() {
        c cVar = this.j;
        return cVar != null && cVar.k();
    }

    public boolean a(b bVar) {
        return p() && (bVar.equals(this.k) || !this.k.i());
    }

    public void b() {
        this.k.b();
        this.l.b();
    }

    public void c(b bVar) {
        c cVar;
        if (bVar.equals(this.k) && (cVar = this.j) != null) {
            cVar.c(this);
        }
    }

    public void clear() {
        this.m = false;
        this.l.clear();
        this.k.clear();
    }

    public void d() {
        this.m = false;
        this.k.d();
        this.l.d();
    }

    public void e() {
        this.m = true;
        if (!this.k.j() && !this.l.isRunning()) {
            this.l.e();
        }
        if (this.m && !this.k.isRunning()) {
            this.k.e();
        }
    }

    public void f(b bVar) {
        if (!bVar.equals(this.l)) {
            c cVar = this.j;
            if (cVar != null) {
                cVar.f(this);
            }
            if (!this.l.j()) {
                this.l.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(c.b.a.r.b r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof c.b.a.r.h
            r1 = 0
            if (r0 == 0) goto L_0x0028
            c.b.a.r.h r4 = (c.b.a.r.h) r4
            c.b.a.r.b r0 = r3.k
            if (r0 != 0) goto L_0x0010
            c.b.a.r.b r0 = r4.k
            if (r0 != 0) goto L_0x0028
            goto L_0x0018
        L_0x0010:
            c.b.a.r.b r2 = r4.k
            boolean r0 = r0.g(r2)
            if (r0 == 0) goto L_0x0028
        L_0x0018:
            c.b.a.r.b r0 = r3.l
            c.b.a.r.b r4 = r4.l
            if (r0 != 0) goto L_0x0021
            if (r4 != 0) goto L_0x0028
            goto L_0x0027
        L_0x0021:
            boolean r4 = r0.g(r4)
            if (r4 == 0) goto L_0x0028
        L_0x0027:
            r1 = 1
        L_0x0028:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.r.h.g(c.b.a.r.b):boolean");
    }

    public boolean h() {
        return this.k.h();
    }

    public boolean i() {
        return this.k.i() || this.l.i();
    }

    public boolean isCancelled() {
        return this.k.isCancelled();
    }

    public boolean isRunning() {
        return this.k.isRunning();
    }

    public boolean j() {
        return this.k.j() || this.l.j();
    }

    public boolean k() {
        return q() || i();
    }

    public boolean l(b bVar) {
        return o() && bVar.equals(this.k) && !k();
    }

    public boolean m(b bVar) {
        return n() && bVar.equals(this.k);
    }

    public void r(b bVar, b bVar2) {
        this.k = bVar;
        this.l = bVar2;
    }
}
