package com.google.android.gms.common.n;

import android.content.Context;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f2253a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f2254b;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.content.Context r4) {
        /*
            java.lang.Class<com.google.android.gms.common.n.a> r0 = com.google.android.gms.common.n.a.class
            monitor-enter(r0)
            android.content.Context r1 = r4.getApplicationContext()     // Catch:{ all -> 0x004b }
            android.content.Context r2 = f2253a     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0018
            java.lang.Boolean r3 = f2254b     // Catch:{ all -> 0x004b }
            if (r3 == 0) goto L_0x0018
            if (r2 == r1) goto L_0x0012
            goto L_0x0018
        L_0x0012:
            boolean r4 = r3.booleanValue()     // Catch:{ all -> 0x004b }
            monitor-exit(r0)
            return r4
        L_0x0018:
            r2 = 0
            f2254b = r2     // Catch:{ all -> 0x004b }
            boolean r2 = com.google.android.gms.common.util.k.h()     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0030
            android.content.pm.PackageManager r4 = r1.getPackageManager()     // Catch:{ all -> 0x004b }
            boolean r4 = r4.isInstantApp()     // Catch:{ all -> 0x004b }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x004b }
        L_0x002d:
            f2254b = r4     // Catch:{ all -> 0x004b }
            goto L_0x0041
        L_0x0030:
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x003e }
            java.lang.String r2 = "com.google.android.instantapps.supervisor.InstantAppsRuntime"
            r4.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x003e }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ ClassNotFoundException -> 0x003e }
            f2254b = r4     // Catch:{ ClassNotFoundException -> 0x003e }
            goto L_0x0041
        L_0x003e:
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x004b }
            goto L_0x002d
        L_0x0041:
            f2253a = r1     // Catch:{ all -> 0x004b }
            java.lang.Boolean r4 = f2254b     // Catch:{ all -> 0x004b }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x004b }
            monitor-exit(r0)
            return r4
        L_0x004b:
            r4 = move-exception
            monitor-exit(r0)
            goto L_0x004f
        L_0x004e:
            throw r4
        L_0x004f:
            goto L_0x004e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.n.a.a(android.content.Context):boolean");
    }
}
