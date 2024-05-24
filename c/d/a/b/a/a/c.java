package c.d.a.b.a.a;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class c extends Thread {
    private final WeakReference<a> j;
    private final long k;
    final CountDownLatch l = new CountDownLatch(1);
    boolean m = false;

    public c(a aVar, long j2) {
        this.j = new WeakReference<>(aVar);
        this.k = j2;
        start();
    }

    private final void a() {
        a aVar = (a) this.j.get();
        if (aVar != null) {
            aVar.c();
            this.m = true;
        }
    }

    public final void run() {
        try {
            if (!this.l.await(this.k, TimeUnit.MILLISECONDS)) {
                a();
            }
        } catch (InterruptedException unused) {
            a();
        }
    }
}
