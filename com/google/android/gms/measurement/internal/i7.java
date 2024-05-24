package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.n;
import java.net.URL;
import java.util.Map;

final class i7 implements Runnable {
    private final URL j;
    private final String k;
    final /* synthetic */ j7 l;
    private final v4 m;

    public i7(j7 j7Var, String str, URL url, byte[] bArr, Map map, v4 v4Var, byte[] bArr2) {
        this.l = j7Var;
        n.e(str);
        n.i(url);
        n.i(v4Var);
        this.j = url;
        this.m = v4Var;
        this.k = str;
    }

    private final void b(int i, Exception exc, byte[] bArr, Map map) {
        this.l.f2527a.c().z(new g7(this, i, exc, bArr, map));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, Exception exc, byte[] bArr, Map map) {
        v4 v4Var = this.m;
        v4Var.f2586a.h(this.k, i, exc, bArr, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c A[SYNTHETIC, Splitter:B:29:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.j7 r0 = r9.l
            r0.g()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.j7 r2 = r9.l     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            java.net.URL r3 = r9.j     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            boolean r4 = r3 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            if (r4 == 0) goto L_0x0080
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            r3.setDefaultUseCaches(r0)     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            com.google.android.gms.measurement.internal.x4 r4 = r2.f2527a     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            r4.z()     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            r4 = 60000(0xea60, float:8.4078E-41)
            r3.setConnectTimeout(r4)     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            r2.z()     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            r2 = 61000(0xee48, float:8.5479E-41)
            r3.setReadTimeout(r2)     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            r3.setInstanceFollowRedirects(r0)     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            r2 = 1
            r3.setDoInput(r2)     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            int r2 = r3.getResponseCode()     // Catch:{ IOException -> 0x007d, all -> 0x007a }
            java.util.Map r4 = r3.getHeaderFields()     // Catch:{ IOException -> 0x0077, all -> 0x0074 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0068 }
            r5.<init>()     // Catch:{ all -> 0x0068 }
            java.io.InputStream r6 = r3.getInputStream()     // Catch:{ all -> 0x0068 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0066 }
        L_0x004a:
            int r8 = r6.read(r7)     // Catch:{ all -> 0x0066 }
            if (r8 <= 0) goto L_0x0054
            r5.write(r7, r0, r8)     // Catch:{ all -> 0x0066 }
            goto L_0x004a
        L_0x0054:
            byte[] r0 = r5.toByteArray()     // Catch:{ all -> 0x0066 }
            if (r6 == 0) goto L_0x005d
            r6.close()     // Catch:{ IOException -> 0x0072, all -> 0x0070 }
        L_0x005d:
            if (r3 == 0) goto L_0x0062
            r3.disconnect()
        L_0x0062:
            r9.b(r2, r1, r0, r4)
            return
        L_0x0066:
            r0 = move-exception
            goto L_0x006a
        L_0x0068:
            r0 = move-exception
            r6 = r1
        L_0x006a:
            if (r6 == 0) goto L_0x006f
            r6.close()     // Catch:{ IOException -> 0x0072, all -> 0x0070 }
        L_0x006f:
            throw r0     // Catch:{ IOException -> 0x0072, all -> 0x0070 }
        L_0x0070:
            r0 = move-exception
            goto L_0x008d
        L_0x0072:
            r0 = move-exception
            goto L_0x009b
        L_0x0074:
            r0 = move-exception
            r4 = r1
            goto L_0x008d
        L_0x0077:
            r0 = move-exception
            r4 = r1
            goto L_0x009b
        L_0x007a:
            r2 = move-exception
            r4 = r1
            goto L_0x008b
        L_0x007d:
            r2 = move-exception
            r4 = r1
            goto L_0x0099
        L_0x0080:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            java.lang.String r3 = "Failed to obtain HTTP connection"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
            throw r2     // Catch:{ IOException -> 0x0096, all -> 0x0088 }
        L_0x0088:
            r2 = move-exception
            r3 = r1
            r4 = r3
        L_0x008b:
            r0 = r2
            r2 = 0
        L_0x008d:
            if (r3 == 0) goto L_0x0092
            r3.disconnect()
        L_0x0092:
            r9.b(r2, r1, r1, r4)
            throw r0
        L_0x0096:
            r2 = move-exception
            r3 = r1
            r4 = r3
        L_0x0099:
            r0 = r2
            r2 = 0
        L_0x009b:
            if (r3 == 0) goto L_0x00a0
            r3.disconnect()
        L_0x00a0:
            r9.b(r2, r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.i7.run():void");
    }
}
