package c.d.a.b.h;

final class p implements Runnable {
    final /* synthetic */ i j;
    final /* synthetic */ q k;

    p(q qVar, i iVar) {
        this.k = qVar;
        this.j = iVar;
    }

    public final void run() {
        if (this.j.k()) {
            this.k.f1836c.r();
            return;
        }
        try {
            this.k.f1836c.q(this.k.f1835b.a(this.j));
        } catch (g e2) {
            if (e2.getCause() instanceof Exception) {
                this.k.f1836c.p((Exception) e2.getCause());
            } else {
                this.k.f1836c.p(e2);
            }
        } catch (Exception e3) {
            this.k.f1836c.p(e3);
        }
    }
}
