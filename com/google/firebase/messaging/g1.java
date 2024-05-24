package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import c.d.a.b.g.a;
import java.util.concurrent.TimeUnit;

final class g1 {

    /* renamed from: a  reason: collision with root package name */
    static final long f2940a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f2941b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static a f2942c;

    private static void a(Context context) {
        if (f2942c == null) {
            a aVar = new a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f2942c = aVar;
            aVar.d(true);
        }
    }

    /* access modifiers changed from: package-private */
    public static void b(Intent intent) {
        synchronized (f2941b) {
            if (f2942c != null && c(intent)) {
                f(intent, false);
                f2942c.c();
            }
        }
    }

    static boolean c(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    static void e(Context context, i1 i1Var, Intent intent) {
        synchronized (f2941b) {
            a(context);
            boolean c2 = c(intent);
            f(intent, true);
            if (!c2) {
                f2942c.a(f2940a);
            }
            i1Var.c(intent).b(new z(intent));
        }
    }

    private static void f(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.content.ComponentName g(android.content.Context r3, android.content.Intent r4) {
        /*
            java.lang.Object r0 = f2941b
            monitor-enter(r0)
            a(r3)     // Catch:{ all -> 0x0022 }
            boolean r1 = c(r4)     // Catch:{ all -> 0x0022 }
            r2 = 1
            f(r4, r2)     // Catch:{ all -> 0x0022 }
            android.content.ComponentName r3 = r3.startService(r4)     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x0017
            r3 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return r3
        L_0x0017:
            if (r1 != 0) goto L_0x0020
            c.d.a.b.g.a r4 = f2942c     // Catch:{ all -> 0x0022 }
            long r1 = f2940a     // Catch:{ all -> 0x0022 }
            r4.a(r1)     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return r3
        L_0x0022:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.g1.g(android.content.Context, android.content.Intent):android.content.ComponentName");
    }
}
