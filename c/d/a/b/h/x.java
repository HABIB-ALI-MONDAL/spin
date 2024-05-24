package c.d.a.b.h;

import com.google.android.gms.common.internal.n;

final class x implements Runnable {
    final /* synthetic */ i j;
    final /* synthetic */ y k;

    x(y yVar, i iVar) {
        this.k = yVar;
        this.j = iVar;
    }

    public final void run() {
        synchronized (this.k.f1847b) {
            y yVar = this.k;
            if (yVar.f1848c != null) {
                e a2 = yVar.f1848c;
                Exception h = this.j.h();
                n.i(h);
                a2.b(h);
            }
        }
    }
}
