package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import b.c.a;
import c.d.a.b.h.i;
import c.d.a.b.h.j;
import c.d.a.b.h.l;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class e1 {
    private static final long i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: a  reason: collision with root package name */
    private final Context f2925a;

    /* renamed from: b  reason: collision with root package name */
    private final p0 f2926b;

    /* renamed from: c  reason: collision with root package name */
    private final m0 f2927c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseMessaging f2928d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, ArrayDeque<j<Void>>> f2929e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final ScheduledExecutorService f2930f;
    private boolean g = false;
    private final d1 h;

    private e1(FirebaseMessaging firebaseMessaging, p0 p0Var, d1 d1Var, m0 m0Var, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f2928d = firebaseMessaging;
        this.f2926b = p0Var;
        this.h = d1Var;
        this.f2927c = m0Var;
        this.f2925a = context;
        this.f2930f = scheduledExecutorService;
    }

    private void a(c1 c1Var, j<Void> jVar) {
        ArrayDeque arrayDeque;
        synchronized (this.f2929e) {
            String e2 = c1Var.e();
            if (this.f2929e.containsKey(e2)) {
                arrayDeque = this.f2929e.get(e2);
            } else {
                ArrayDeque arrayDeque2 = new ArrayDeque();
                this.f2929e.put(e2, arrayDeque2);
                arrayDeque = arrayDeque2;
            }
            arrayDeque.add(jVar);
        }
    }

    private static <T> void b(i<T> iVar) {
        try {
            l.b(iVar, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e2);
            }
        } catch (InterruptedException | TimeoutException e3) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e3);
        }
    }

    private void c(String str) {
        b(this.f2927c.k(this.f2928d.c(), str));
    }

    private void d(String str) {
        b(this.f2927c.l(this.f2928d.c(), str));
    }

    static i<e1> e(FirebaseMessaging firebaseMessaging, p0 p0Var, m0 m0Var, Context context, ScheduledExecutorService scheduledExecutorService) {
        return l.c(scheduledExecutorService, new y(context, scheduledExecutorService, firebaseMessaging, p0Var, m0Var));
    }

    static boolean g() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    static /* synthetic */ e1 i(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, p0 p0Var, m0 m0Var) {
        return new e1(firebaseMessaging, p0Var, d1.b(context, scheduledExecutorService), m0Var, context, scheduledExecutorService);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j(com.google.firebase.messaging.c1 r5) {
        /*
            r4 = this;
            java.util.Map<java.lang.String, java.util.ArrayDeque<c.d.a.b.h.j<java.lang.Void>>> r0 = r4.f2929e
            monitor-enter(r0)
            java.lang.String r5 = r5.e()     // Catch:{ all -> 0x0032 }
            java.util.Map<java.lang.String, java.util.ArrayDeque<c.d.a.b.h.j<java.lang.Void>>> r1 = r4.f2929e     // Catch:{ all -> 0x0032 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0011:
            java.util.Map<java.lang.String, java.util.ArrayDeque<c.d.a.b.h.j<java.lang.Void>>> r1 = r4.f2929e     // Catch:{ all -> 0x0032 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0032 }
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch:{ all -> 0x0032 }
            java.lang.Object r2 = r1.poll()     // Catch:{ all -> 0x0032 }
            c.d.a.b.h.j r2 = (c.d.a.b.h.j) r2     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0025
            r3 = 0
            r2.c(r3)     // Catch:{ all -> 0x0032 }
        L_0x0025:
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0030
            java.util.Map<java.lang.String, java.util.ArrayDeque<c.d.a.b.h.j<java.lang.Void>>> r1 = r4.f2929e     // Catch:{ all -> 0x0032 }
            r1.remove(r5)     // Catch:{ all -> 0x0032 }
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0032:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.e1.j(com.google.firebase.messaging.c1):void");
    }

    private void o() {
        if (!h()) {
            s(0);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.h.c() != null;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean h() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public boolean k(c1 c1Var) {
        String str;
        String str2;
        try {
            String b2 = c1Var.b();
            char c2 = 65535;
            int hashCode = b2.hashCode();
            if (hashCode != 83) {
                if (hashCode == 85) {
                    if (b2.equals("U")) {
                        c2 = 1;
                    }
                }
            } else if (b2.equals("S")) {
                c2 = 0;
            }
            if (c2 == 0) {
                c(c1Var.c());
                if (g()) {
                    str2 = "Subscribe to topic: " + c1Var.c() + " succeeded.";
                }
                return true;
            } else if (c2 != 1) {
                if (g()) {
                    str2 = "Unknown topic operation" + c1Var + ".";
                }
                return true;
            } else {
                d(c1Var.c());
                if (g()) {
                    str2 = "Unsubscribe from topic: " + c1Var.c() + " succeeded.";
                }
                return true;
            }
            Log.d("FirebaseMessaging", str2);
            return true;
        } catch (IOException e2) {
            if ("SERVICE_NOT_AVAILABLE".equals(e2.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e2.getMessage())) {
                str = "Topic operation failed: " + e2.getMessage() + ". Will retry Topic operation.";
            } else if (e2.getMessage() == null) {
                str = "Topic operation failed without exception message. Will retry Topic operation.";
            } else {
                throw e2;
            }
            Log.e("FirebaseMessaging", str);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void l(Runnable runnable, long j) {
        this.f2930f.schedule(runnable, j, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public i<Void> m(c1 c1Var) {
        this.h.a(c1Var);
        j jVar = new j();
        a(c1Var, jVar);
        return jVar.a();
    }

    /* access modifiers changed from: package-private */
    public synchronized void n(boolean z) {
        this.g = z;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        if (f()) {
            o();
        }
    }

    /* access modifiers changed from: package-private */
    public i<Void> q(String str) {
        i<Void> m = m(c1.f(str));
        p();
        return m;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (k(r0) != false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean r() {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            com.google.firebase.messaging.d1 r0 = r2.h     // Catch:{ all -> 0x002b }
            com.google.firebase.messaging.c1 r0 = r0.c()     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0019
            boolean r0 = g()     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x002b }
        L_0x0016:
            r0 = 1
            monitor-exit(r2)     // Catch:{ all -> 0x002b }
            return r0
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x002b }
            boolean r1 = r2.k(r0)
            if (r1 != 0) goto L_0x0022
            r0 = 0
            return r0
        L_0x0022:
            com.google.firebase.messaging.d1 r1 = r2.h
            r1.e(r0)
            r2.j(r0)
            goto L_0x0000
        L_0x002b:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002b }
            goto L_0x002f
        L_0x002e:
            throw r0
        L_0x002f:
            goto L_0x002e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.e1.r():boolean");
    }

    /* access modifiers changed from: package-private */
    public void s(long j) {
        l(new f1(this, this.f2925a, this.f2926b, Math.min(Math.max(30, 2 * j), i)), j);
        n(true);
    }

    /* access modifiers changed from: package-private */
    public i<Void> t(String str) {
        i<Void> m = m(c1.g(str));
        p();
        return m;
    }
}
