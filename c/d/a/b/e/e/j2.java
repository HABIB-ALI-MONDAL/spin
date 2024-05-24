package c.d.a.b.e.e;

abstract class j2 implements Runnable {
    final long j;
    final long k;
    final boolean l;
    final /* synthetic */ t2 m;

    j2(t2 t2Var, boolean z) {
        this.m = t2Var;
        this.j = t2Var.f1747b.a();
        this.k = t2Var.f1747b.b();
        this.l = z;
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: protected */
    public void b() {
    }

    public final void run() {
        if (this.m.f1751f) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e2) {
            this.m.i(e2, false, this.l);
            b();
        }
    }
}
