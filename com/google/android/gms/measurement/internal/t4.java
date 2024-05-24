package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.n;
import java.util.concurrent.BlockingQueue;

final class t4 extends Thread {
    private final Object j;
    private final BlockingQueue k;
    private boolean l = false;
    final /* synthetic */ u4 m;

    public t4(u4 u4Var, String str, BlockingQueue blockingQueue) {
        this.m = u4Var;
        n.i(str);
        n.i(blockingQueue);
        this.j = new Object();
        this.k = blockingQueue;
        setName(str);
    }

    private final void b() {
        synchronized (this.m.i) {
            if (!this.l) {
                this.m.j.release();
                this.m.i.notifyAll();
                u4 u4Var = this.m;
                if (this == u4Var.f2559c) {
                    u4Var.f2559c = null;
                } else if (this == u4Var.f2560d) {
                    u4Var.f2560d = null;
                } else {
                    u4Var.f2527a.f().r().a("Current scheduler thread is neither worker nor network");
                }
                this.l = true;
            }
        }
    }

    private final void c(InterruptedException interruptedException) {
        this.m.f2527a.f().w().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void a() {
        synchronized (this.j) {
            this.j.notifyAll();
        }
    }

    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.m.j.acquire();
                z = true;
            } catch (InterruptedException e2) {
                c(e2);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                s4 s4Var = (s4) this.k.poll();
                if (s4Var != null) {
                    Process.setThreadPriority(true != s4Var.k ? 10 : threadPriority);
                    s4Var.run();
                } else {
                    synchronized (this.j) {
                        if (this.k.peek() == null) {
                            boolean unused = this.m.k;
                            try {
                                this.j.wait(30000);
                            } catch (InterruptedException e3) {
                                c(e3);
                            }
                        }
                    }
                    synchronized (this.m.i) {
                        if (this.k.peek() == null) {
                            b();
                            b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
