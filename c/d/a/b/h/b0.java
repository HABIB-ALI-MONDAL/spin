package c.d.a.b.h;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class b0 implements Runnable {
    final /* synthetic */ i j;
    final /* synthetic */ c0 k;

    b0(c0 c0Var, i iVar) {
        this.k = c0Var;
        this.j = iVar;
    }

    public final void run() {
        try {
            i a2 = this.k.f1818b.a(this.j.i());
            if (a2 == null) {
                this.k.b(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = k.f1832b;
            a2.e(executor, this.k);
            a2.d(executor, this.k);
            a2.a(executor, this.k);
        } catch (g e2) {
            if (e2.getCause() instanceof Exception) {
                this.k.b((Exception) e2.getCause());
            } else {
                this.k.b(e2);
            }
        } catch (CancellationException unused) {
            this.k.a();
        } catch (Exception e3) {
            this.k.b(e3);
        }
    }
}
