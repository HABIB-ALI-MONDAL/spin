package c.d.a.b.h;

final class t implements Runnable {
    final /* synthetic */ u j;

    t(u uVar) {
        this.j = uVar;
    }

    public final void run() {
        synchronized (this.j.f1841b) {
            u uVar = this.j;
            if (uVar.f1842c != null) {
                uVar.f1842c.a();
            }
        }
    }
}
