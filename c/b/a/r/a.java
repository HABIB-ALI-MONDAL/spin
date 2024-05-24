package c.b.a.r;

public final class a implements c, b {
    private final c j;
    private b k;
    private b l;

    public a(c cVar) {
        this.j = cVar;
    }

    private boolean n(b bVar) {
        return bVar.equals(this.k) || (this.k.h() && bVar.equals(this.l));
    }

    private boolean o() {
        c cVar = this.j;
        return cVar == null || cVar.m(this);
    }

    private boolean p() {
        c cVar = this.j;
        return cVar == null || cVar.l(this);
    }

    private boolean q() {
        c cVar = this.j;
        return cVar == null || cVar.a(this);
    }

    private boolean r() {
        c cVar = this.j;
        return cVar != null && cVar.k();
    }

    public boolean a(b bVar) {
        return q() && n(bVar);
    }

    public void b() {
        this.k.b();
        this.l.b();
    }

    public void c(b bVar) {
        if (bVar.equals(this.l)) {
            c cVar = this.j;
            if (cVar != null) {
                cVar.c(this);
            }
        } else if (!this.l.isRunning()) {
            this.l.e();
        }
    }

    public void clear() {
        this.k.clear();
        if (this.l.isRunning()) {
            this.l.clear();
        }
    }

    public void d() {
        if (!this.k.h()) {
            this.k.d();
        }
        if (this.l.isRunning()) {
            this.l.d();
        }
    }

    public void e() {
        if (!this.k.isRunning()) {
            this.k.e();
        }
    }

    public void f(b bVar) {
        c cVar = this.j;
        if (cVar != null) {
            cVar.f(this);
        }
    }

    public boolean g(b bVar) {
        if (!(bVar instanceof a)) {
            return false;
        }
        a aVar = (a) bVar;
        return this.k.g(aVar.k) && this.l.g(aVar.l);
    }

    public boolean h() {
        return this.k.h() && this.l.h();
    }

    public boolean i() {
        return (this.k.h() ? this.l : this.k).i();
    }

    public boolean isCancelled() {
        return (this.k.h() ? this.l : this.k).isCancelled();
    }

    public boolean isRunning() {
        return (this.k.h() ? this.l : this.k).isRunning();
    }

    public boolean j() {
        return (this.k.h() ? this.l : this.k).j();
    }

    public boolean k() {
        return r() || i();
    }

    public boolean l(b bVar) {
        return p() && n(bVar);
    }

    public boolean m(b bVar) {
        return o() && n(bVar);
    }

    public void s(b bVar, b bVar2) {
        this.k = bVar;
        this.l = bVar2;
    }
}
