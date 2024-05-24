package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.i1;

final class r6 implements Runnable {
    final /* synthetic */ i1 j;
    final /* synthetic */ e7 k;

    r6(e7 e7Var, i1 i1Var) {
        this.k = e7Var;
        this.j = i1Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0097 A[SYNTHETIC, Splitter:B:16:0x0097] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.e7 r0 = r7.k
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a
            com.google.android.gms.measurement.internal.l9 r0 = r0.M()
            c.d.a.b.e.e.pd.c()
            com.google.android.gms.measurement.internal.x4 r1 = r0.f2527a
            com.google.android.gms.measurement.internal.h r1 = r1.z()
            com.google.android.gms.measurement.internal.x2 r2 = com.google.android.gms.measurement.internal.y2.r0
            r3 = 0
            boolean r1 = r1.B(r3, r2)
            if (r1 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.x4 r1 = r0.f2527a
            com.google.android.gms.measurement.internal.b4 r1 = r1.F()
            com.google.android.gms.measurement.internal.j r1 = r1.q()
            com.google.android.gms.measurement.internal.i r2 = com.google.android.gms.measurement.internal.i.ANALYTICS_STORAGE
            boolean r1 = r1.i(r2)
            if (r1 != 0) goto L_0x0039
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.x()
            java.lang.String r1 = "Analytics storage consent denied; will not get session id"
            goto L_0x007f
        L_0x0039:
            com.google.android.gms.measurement.internal.x4 r1 = r0.f2527a
            com.google.android.gms.measurement.internal.b4 r1 = r1.F()
            com.google.android.gms.measurement.internal.x4 r2 = r0.f2527a
            com.google.android.gms.common.util.d r2 = r2.a()
            long r4 = r2.a()
            boolean r1 = r1.v(r4)
            if (r1 != 0) goto L_0x0082
            com.google.android.gms.measurement.internal.x4 r1 = r0.f2527a
            com.google.android.gms.measurement.internal.b4 r1 = r1.F()
            com.google.android.gms.measurement.internal.x3 r1 = r1.p
            long r1 = r1.a()
            r4 = 0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0062
            goto L_0x0082
        L_0x0062:
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a
            com.google.android.gms.measurement.internal.b4 r0 = r0.F()
            com.google.android.gms.measurement.internal.x3 r0 = r0.p
            long r0 = r0.a()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            goto L_0x0083
        L_0x0073:
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()
            com.google.android.gms.measurement.internal.k3 r0 = r0.x()
            java.lang.String r1 = "getSessionId has been disabled."
        L_0x007f:
            r0.a(r1)
        L_0x0082:
            r0 = r3
        L_0x0083:
            if (r0 == 0) goto L_0x0097
            com.google.android.gms.measurement.internal.e7 r1 = r7.k
            com.google.android.gms.measurement.internal.x4 r1 = r1.f2527a
            com.google.android.gms.measurement.internal.la r1 = r1.N()
            c.d.a.b.e.e.i1 r2 = r7.j
            long r3 = r0.longValue()
            r1.I(r2, r3)
            return
        L_0x0097:
            c.d.a.b.e.e.i1 r0 = r7.j     // Catch:{ RemoteException -> 0x009d }
            r0.x(r3)     // Catch:{ RemoteException -> 0x009d }
            return
        L_0x009d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.e7 r1 = r7.k
            com.google.android.gms.measurement.internal.x4 r1 = r1.f2527a
            com.google.android.gms.measurement.internal.m3 r1 = r1.f()
            com.google.android.gms.measurement.internal.k3 r1 = r1.r()
            java.lang.String r2 = "getSessionId failed with exception"
            r1.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.r6.run():void");
    }
}
