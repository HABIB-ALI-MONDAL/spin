package c.d.a.b.h;

import java.util.concurrent.Callable;

final class i0 implements Runnable {
    final /* synthetic */ h0 j;
    final /* synthetic */ Callable k;

    i0(h0 h0Var, Callable callable) {
        this.j = h0Var;
        this.k = callable;
    }

    public final void run() {
        try {
            this.j.q(this.k.call());
        } catch (Exception e2) {
            this.j.p(e2);
        } catch (Throwable th) {
            this.j.p(new RuntimeException(th));
        }
    }
}
