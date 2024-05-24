package c.d.a.b.h;

import java.util.concurrent.Executor;

final class r implements Runnable {
    final /* synthetic */ i j;
    final /* synthetic */ s k;

    r(s sVar, i iVar) {
        this.k = sVar;
        this.j = iVar;
    }

    public final void run() {
        try {
            i iVar = (i) this.k.f1838b.a(this.j);
            if (iVar == null) {
                this.k.b(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = k.f1832b;
            iVar.e(executor, this.k);
            iVar.d(executor, this.k);
            iVar.a(executor, this.k);
        } catch (g e2) {
            if (e2.getCause() instanceof Exception) {
                this.k.f1839c.p((Exception) e2.getCause());
            } else {
                this.k.f1839c.p(e2);
            }
        } catch (Exception e3) {
            this.k.f1839c.p(e3);
        }
    }
}
