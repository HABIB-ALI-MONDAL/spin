package com.google.firebase.messaging;

import c.d.a.b.h.i;
import java.util.Map;
import java.util.concurrent.Executor;

class w0 {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3007a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, i<String>> f3008b = new b.c.a();

    interface a {
        i<String> start();
    }

    w0(Executor executor) {
        this.f3007a = executor;
    }

    private /* synthetic */ i b(String str, i iVar) {
        synchronized (this) {
            this.f3008b.remove(str);
        }
        return iVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized c.d.a.b.h.i<java.lang.String> a(java.lang.String r4, com.google.firebase.messaging.w0.a r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Map<java.lang.String, c.d.a.b.h.i<java.lang.String>> r0 = r3.f3008b     // Catch:{ all -> 0x0060 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0060 }
            c.d.a.b.h.i r0 = (c.d.a.b.h.i) r0     // Catch:{ all -> 0x0060 }
            r1 = 3
            if (r0 == 0) goto L_0x002c
            java.lang.String r5 = "FirebaseMessaging"
            boolean r5 = android.util.Log.isLoggable(r5, r1)     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x002a
            java.lang.String r5 = "FirebaseMessaging"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = "Joining ongoing request for: "
            r1.append(r2)     // Catch:{ all -> 0x0060 }
            r1.append(r4)     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0060 }
            android.util.Log.d(r5, r4)     // Catch:{ all -> 0x0060 }
        L_0x002a:
            monitor-exit(r3)
            return r0
        L_0x002c:
            java.lang.String r0 = "FirebaseMessaging"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x004a
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = "Making new request for: "
            r1.append(r2)     // Catch:{ all -> 0x0060 }
            r1.append(r4)     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0060 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0060 }
        L_0x004a:
            c.d.a.b.h.i r5 = r5.start()     // Catch:{ all -> 0x0060 }
            java.util.concurrent.Executor r0 = r3.f3007a     // Catch:{ all -> 0x0060 }
            com.google.firebase.messaging.w r1 = new com.google.firebase.messaging.w     // Catch:{ all -> 0x0060 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0060 }
            c.d.a.b.h.i r5 = r5.g(r0, r1)     // Catch:{ all -> 0x0060 }
            java.util.Map<java.lang.String, c.d.a.b.h.i<java.lang.String>> r0 = r3.f3008b     // Catch:{ all -> 0x0060 }
            r0.put(r4, r5)     // Catch:{ all -> 0x0060 }
            monitor-exit(r3)
            return r5
        L_0x0060:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.w0.a(java.lang.String, com.google.firebase.messaging.w0$a):c.d.a.b.h.i");
    }

    public /* synthetic */ i c(String str, i iVar) {
        b(str, iVar);
        return iVar;
    }
}
