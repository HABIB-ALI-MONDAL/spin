package com.google.android.gms.measurement.internal;

import android.net.Uri;

final class b7 implements Runnable {
    final /* synthetic */ boolean j;
    final /* synthetic */ Uri k;
    final /* synthetic */ String l;
    final /* synthetic */ String m;
    final /* synthetic */ d7 n;

    b7(d7 d7Var, boolean z, Uri uri, String str, String str2) {
        this.n = d7Var;
        this.j = z;
        this.k = uri;
        this.l = str;
        this.m = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a A[SYNTHETIC, Splitter:B:27:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d1 A[Catch:{ RuntimeException -> 0x0164 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d3 A[Catch:{ RuntimeException -> 0x0164 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            com.google.android.gms.measurement.internal.d7 r2 = r1.n
            boolean r0 = r1.j
            android.net.Uri r3 = r1.k
            java.lang.String r4 = r1.l
            java.lang.String r5 = r1.m
            com.google.android.gms.measurement.internal.e7 r6 = r2.j
            r6.h()
            com.google.android.gms.measurement.internal.e7 r6 = r2.j     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.x4 r6 = r6.f2527a     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.la r6 = r6.N()     // Catch:{ RuntimeException -> 0x0164 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0164 }
            java.lang.String r8 = "Activity created with data 'referrer' without required params"
            java.lang.String r9 = "utm_medium"
            java.lang.String r10 = "_cis"
            java.lang.String r11 = "utm_source"
            java.lang.String r12 = "utm_campaign"
            r13 = 0
            java.lang.String r14 = "gclid"
            if (r7 == 0) goto L_0x002e
        L_0x002c:
            r6 = r13
            goto L_0x0085
        L_0x002e:
            boolean r7 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0164 }
            if (r7 != 0) goto L_0x006c
            boolean r7 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0164 }
            if (r7 != 0) goto L_0x006c
            boolean r7 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x0164 }
            if (r7 != 0) goto L_0x006c
            boolean r7 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x0164 }
            if (r7 != 0) goto L_0x006c
            java.lang.String r7 = "utm_id"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0164 }
            if (r7 != 0) goto L_0x006c
            java.lang.String r7 = "dclid"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0164 }
            if (r7 != 0) goto L_0x006c
            java.lang.String r7 = "srsltid"
            boolean r7 = r5.contains(r7)     // Catch:{ RuntimeException -> 0x0164 }
            if (r7 != 0) goto L_0x006c
            com.google.android.gms.measurement.internal.x4 r6 = r6.f2527a     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.k3 r6 = r6.q()     // Catch:{ RuntimeException -> 0x0164 }
            r6.a(r8)     // Catch:{ RuntimeException -> 0x0164 }
            goto L_0x002c
        L_0x006c:
            java.lang.String r7 = "https://google.com/search?"
            java.lang.String r15 = java.lang.String.valueOf(r5)     // Catch:{ RuntimeException -> 0x0164 }
            java.lang.String r7 = r7.concat(r15)     // Catch:{ RuntimeException -> 0x0164 }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ RuntimeException -> 0x0164 }
            android.os.Bundle r6 = r6.t0(r7)     // Catch:{ RuntimeException -> 0x0164 }
            if (r6 == 0) goto L_0x0085
            java.lang.String r7 = "referrer"
            r6.putString(r10, r7)     // Catch:{ RuntimeException -> 0x0164 }
        L_0x0085:
            java.lang.String r7 = "_cmp"
            r15 = 1
            if (r0 == 0) goto L_0x00cb
            com.google.android.gms.measurement.internal.e7 r0 = r2.j     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.la r0 = r0.N()     // Catch:{ RuntimeException -> 0x0164 }
            android.os.Bundle r0 = r0.t0(r3)     // Catch:{ RuntimeException -> 0x0164 }
            if (r0 == 0) goto L_0x00cb
            java.lang.String r3 = "intent"
            r0.putString(r10, r3)     // Catch:{ RuntimeException -> 0x0164 }
            boolean r3 = r0.containsKey(r14)     // Catch:{ RuntimeException -> 0x0164 }
            if (r3 != 0) goto L_0x00bf
            if (r6 == 0) goto L_0x00bf
            boolean r3 = r6.containsKey(r14)     // Catch:{ RuntimeException -> 0x0164 }
            if (r3 == 0) goto L_0x00bf
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ RuntimeException -> 0x0164 }
            r10 = 0
            java.lang.String r16 = r6.getString(r14)     // Catch:{ RuntimeException -> 0x0164 }
            r3[r10] = r16     // Catch:{ RuntimeException -> 0x0164 }
            java.lang.String r10 = "_cer"
            java.lang.String r15 = "gclid=%s"
            java.lang.String r3 = java.lang.String.format(r15, r3)     // Catch:{ RuntimeException -> 0x0164 }
            r0.putString(r10, r3)     // Catch:{ RuntimeException -> 0x0164 }
        L_0x00bf:
            com.google.android.gms.measurement.internal.e7 r3 = r2.j     // Catch:{ RuntimeException -> 0x0164 }
            r3.u(r4, r7, r0)     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.e7 r3 = r2.j     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.sa r3 = r3.n     // Catch:{ RuntimeException -> 0x0164 }
            r3.a(r4, r0)     // Catch:{ RuntimeException -> 0x0164 }
        L_0x00cb:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0164 }
            if (r0 == 0) goto L_0x00d3
            goto L_0x0153
        L_0x00d3:
            com.google.android.gms.measurement.internal.e7 r0 = r2.j     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.q()     // Catch:{ RuntimeException -> 0x0164 }
            java.lang.String r3 = "Activity created with referrer"
            r0.b(r3, r5)     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.e7 r0 = r2.j     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.h r0 = r0.z()     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.x2 r3 = com.google.android.gms.measurement.internal.y2.Z     // Catch:{ RuntimeException -> 0x0164 }
            boolean r0 = r0.B(r13, r3)     // Catch:{ RuntimeException -> 0x0164 }
            java.lang.String r3 = "_ldl"
            java.lang.String r10 = "auto"
            if (r0 == 0) goto L_0x011f
            if (r6 == 0) goto L_0x0107
            com.google.android.gms.measurement.internal.e7 r0 = r2.j     // Catch:{ RuntimeException -> 0x0164 }
            r0.u(r4, r7, r6)     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.e7 r0 = r2.j     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.sa r0 = r0.n     // Catch:{ RuntimeException -> 0x0164 }
            r0.a(r4, r6)     // Catch:{ RuntimeException -> 0x0164 }
            goto L_0x0118
        L_0x0107:
            com.google.android.gms.measurement.internal.e7 r0 = r2.j     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.q()     // Catch:{ RuntimeException -> 0x0164 }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.b(r4, r5)     // Catch:{ RuntimeException -> 0x0164 }
        L_0x0118:
            com.google.android.gms.measurement.internal.e7 r0 = r2.j     // Catch:{ RuntimeException -> 0x0164 }
            r4 = 1
            r0.K(r10, r3, r13, r4)     // Catch:{ RuntimeException -> 0x0164 }
            return
        L_0x011f:
            boolean r0 = r5.contains(r14)     // Catch:{ RuntimeException -> 0x0164 }
            if (r0 == 0) goto L_0x0154
            boolean r0 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x0164 }
            if (r0 != 0) goto L_0x0147
            boolean r0 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x0164 }
            if (r0 != 0) goto L_0x0147
            boolean r0 = r5.contains(r9)     // Catch:{ RuntimeException -> 0x0164 }
            if (r0 != 0) goto L_0x0147
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0164 }
            if (r0 != 0) goto L_0x0147
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x0164 }
            if (r0 == 0) goto L_0x0154
        L_0x0147:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x0164 }
            if (r0 != 0) goto L_0x0153
            com.google.android.gms.measurement.internal.e7 r0 = r2.j     // Catch:{ RuntimeException -> 0x0164 }
            r4 = 1
            r0.K(r10, r3, r5, r4)     // Catch:{ RuntimeException -> 0x0164 }
        L_0x0153:
            return
        L_0x0154:
            com.google.android.gms.measurement.internal.e7 r0 = r2.j     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.m3 r0 = r0.f()     // Catch:{ RuntimeException -> 0x0164 }
            com.google.android.gms.measurement.internal.k3 r0 = r0.q()     // Catch:{ RuntimeException -> 0x0164 }
            r0.a(r8)     // Catch:{ RuntimeException -> 0x0164 }
            return
        L_0x0164:
            r0 = move-exception
            com.google.android.gms.measurement.internal.e7 r2 = r2.j
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.r()
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.b(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.b7.run():void");
    }
}
