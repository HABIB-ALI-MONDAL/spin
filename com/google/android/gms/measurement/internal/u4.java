package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public final class u4 extends s5 {
    /* access modifiers changed from: private */
    public static final AtomicLong l = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public t4 f2559c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public t4 f2560d;

    /* renamed from: e  reason: collision with root package name */
    private final PriorityBlockingQueue f2561e = new PriorityBlockingQueue();

    /* renamed from: f  reason: collision with root package name */
    private final BlockingQueue f2562f = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler g = new r4(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler h = new r4(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object i = new Object();
    /* access modifiers changed from: private */
    public final Semaphore j = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean k;

    u4(x4 x4Var) {
        super(x4Var);
    }

    private final void D(s4 s4Var) {
        synchronized (this.i) {
            this.f2561e.add(s4Var);
            t4 t4Var = this.f2559c;
            if (t4Var == null) {
                t4 t4Var2 = new t4(this, "Measurement Worker", this.f2561e);
                this.f2559c = t4Var2;
                t4Var2.setUncaughtExceptionHandler(this.g);
                this.f2559c.start();
            } else {
                t4Var.a();
            }
        }
    }

    public final void A(Runnable runnable) {
        k();
        n.i(runnable);
        D(new s4(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean C() {
        return Thread.currentThread() == this.f2559c;
    }

    public final void g() {
        if (Thread.currentThread() != this.f2560d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void h() {
        if (Thread.currentThread() != this.f2559c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* access modifiers changed from: protected */
    public final boolean j() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:11|12|13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3 = r1.f2527a.f().w();
        r3.a("Interrupted waiting for " + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r2 = r2.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r2 != null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r1.f2527a.f().w().a("Timed out waiting for ".concat(r5));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object r(java.util.concurrent.atomic.AtomicReference r2, long r3, java.lang.String r5, java.lang.Runnable r6) {
        /*
            r1 = this;
            monitor-enter(r2)
            com.google.android.gms.measurement.internal.x4 r0 = r1.f2527a     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.u4 r0 = r0.c()     // Catch:{ all -> 0x0049 }
            r0.z(r6)     // Catch:{ all -> 0x0049 }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x0028 }
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0027
            com.google.android.gms.measurement.internal.x4 r3 = r1.f2527a
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()
            com.google.android.gms.measurement.internal.k3 r3 = r3.w()
            java.lang.String r4 = "Timed out waiting for "
            java.lang.String r4 = r4.concat(r5)
            r3.a(r4)
        L_0x0027:
            return r2
        L_0x0028:
            com.google.android.gms.measurement.internal.x4 r3 = r1.f2527a     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.m3 r3 = r3.f()     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.k3 r3 = r3.w()     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r4.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r6 = "Interrupted waiting for "
            r4.append(r6)     // Catch:{ all -> 0x0049 }
            r4.append(r5)     // Catch:{ all -> 0x0049 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0049 }
            r3.a(r4)     // Catch:{ all -> 0x0049 }
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            r2 = 0
            return r2
        L_0x0049:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.u4.r(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    public final Future s(Callable callable) {
        k();
        n.i(callable);
        s4 s4Var = new s4(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f2559c) {
            if (!this.f2561e.isEmpty()) {
                this.f2527a.f().w().a("Callable skipped the worker queue.");
            }
            s4Var.run();
        } else {
            D(s4Var);
        }
        return s4Var;
    }

    public final Future t(Callable callable) {
        k();
        n.i(callable);
        s4 s4Var = new s4(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f2559c) {
            s4Var.run();
        } else {
            D(s4Var);
        }
        return s4Var;
    }

    public final void y(Runnable runnable) {
        k();
        n.i(runnable);
        s4 s4Var = new s4(this, runnable, false, "Task exception on network thread");
        synchronized (this.i) {
            this.f2562f.add(s4Var);
            t4 t4Var = this.f2560d;
            if (t4Var == null) {
                t4 t4Var2 = new t4(this, "Measurement Network", this.f2562f);
                this.f2560d = t4Var2;
                t4Var2.setUncaughtExceptionHandler(this.h);
                this.f2560d.start();
            } else {
                t4Var.a();
            }
        }
    }

    public final void z(Runnable runnable) {
        k();
        n.i(runnable);
        D(new s4(this, runnable, false, "Task exception on worker thread"));
    }
}
