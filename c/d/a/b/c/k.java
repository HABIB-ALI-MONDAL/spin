package c.d.a.b.c;

import android.os.Handler;

public final /* synthetic */ class k implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f1530a;

    public /* synthetic */ k(r rVar) {
        this.f1530a = rVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005e, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0060, code lost:
        r2.c(new c.d.a.b.c.v(4, "Not supported by GmsCore", (java.lang.Throwable) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006d, code lost:
        r2.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            c.d.a.b.c.r r0 = r4.f1530a
            int r1 = r5.arg1
            java.lang.String r2 = "MessengerIpcClient"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)
            if (r2 == 0) goto L_0x0025
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 41
            r2.<init>(r3)
            java.lang.String r3 = "Received response to request: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r3 = "MessengerIpcClient"
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r3, r2)
        L_0x0025:
            monitor-enter(r0)
            android.util.SparseArray<c.d.a.b.c.u<?>> r2 = r0.f1535e     // Catch:{ all -> 0x0072 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0072 }
            c.d.a.b.c.u r2 = (c.d.a.b.c.u) r2     // Catch:{ all -> 0x0072 }
            if (r2 != 0) goto L_0x004a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r2 = 50
            r5.<init>(r2)     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = "Received response for unknown request: "
            r5.append(r2)     // Catch:{ all -> 0x0072 }
            r5.append(r1)     // Catch:{ all -> 0x0072 }
            java.lang.String r1 = "MessengerIpcClient"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0072 }
            android.util.Log.w(r1, r5)     // Catch:{ all -> 0x0072 }
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            goto L_0x0070
        L_0x004a:
            android.util.SparseArray<c.d.a.b.c.u<?>> r3 = r0.f1535e     // Catch:{ all -> 0x0072 }
            r3.remove(r1)     // Catch:{ all -> 0x0072 }
            r0.f()     // Catch:{ all -> 0x0072 }
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            android.os.Bundle r5 = r5.getData()
            java.lang.String r0 = "unsupported"
            r1 = 0
            boolean r0 = r5.getBoolean(r0, r1)
            if (r0 == 0) goto L_0x006d
            c.d.a.b.c.v r5 = new c.d.a.b.c.v
            r0 = 4
            java.lang.String r1 = "Not supported by GmsCore"
            r3 = 0
            r5.<init>(r0, r1, r3)
            r2.c(r5)
            goto L_0x0070
        L_0x006d:
            r2.a(r5)
        L_0x0070:
            r5 = 1
            return r5
        L_0x0072:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.c.k.handleMessage(android.os.Message):boolean");
    }
}
