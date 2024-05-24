package c.d.a.b.h;

final class z implements Runnable {
    final /* synthetic */ i j;
    final /* synthetic */ a0 k;

    z(a0 a0Var, i iVar) {
        this.k = a0Var;
        this.j = iVar;
    }

    public final void run() {
        synchronized (this.k.f1815b) {
            a0 a0Var = this.k;
            if (a0Var.f1816c != null) {
                a0Var.f1816c.d(this.j.i());
            }
        }
    }
}
