package c.d.a.b.h;

final class v implements Runnable {
    final /* synthetic */ i j;
    final /* synthetic */ w k;

    v(w wVar, i iVar) {
        this.k = wVar;
        this.j = iVar;
    }

    public final void run() {
        synchronized (this.k.f1844b) {
            w wVar = this.k;
            if (wVar.f1845c != null) {
                wVar.f1845c.a(this.j);
            }
        }
    }
}
