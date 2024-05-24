package com.google.android.gms.common.api.internal;

import c.d.a.b.h.j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final Map f2123a = Collections.synchronizedMap(new WeakHashMap());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map f2124b = Collections.synchronizedMap(new WeakHashMap());

    private final void f(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f2123a) {
            hashMap = new HashMap(this.f2123a);
        }
        synchronized (this.f2124b) {
            hashMap2 = new HashMap(this.f2124b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).b(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((j) entry2.getKey()).d(new b(status));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(j jVar, boolean z) {
        this.f2124b.put(jVar, Boolean.valueOf(z));
        jVar.a().b(new p(this, jVar));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(int r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The connection to Google Play services was lost"
            r0.<init>(r1)
            r1 = 1
            if (r4 != r1) goto L_0x0010
            java.lang.String r4 = " due to service disconnection."
        L_0x000c:
            r0.append(r4)
            goto L_0x0016
        L_0x0010:
            r2 = 3
            if (r4 != r2) goto L_0x0016
            java.lang.String r4 = " due to dead object exception."
            goto L_0x000c
        L_0x0016:
            if (r5 == 0) goto L_0x0020
            java.lang.String r4 = " Last reason for disconnect: "
            r0.append(r4)
            r0.append(r5)
        L_0x0020:
            com.google.android.gms.common.api.Status r4 = new com.google.android.gms.common.api.Status
            r5 = 20
            java.lang.String r0 = r0.toString()
            r4.<init>((int) r5, (java.lang.String) r0)
            r3.f(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.q.c(int, java.lang.String):void");
    }

    public final void d() {
        f(false, e.r);
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        return !this.f2123a.isEmpty() || !this.f2124b.isEmpty();
    }
}
