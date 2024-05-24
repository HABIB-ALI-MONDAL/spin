package com.google.android.gms.common.api;

public class b extends Exception {
    @Deprecated
    protected final Status j;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(com.google.android.gms.common.api.Status r4) {
        /*
            r3 = this;
            int r0 = r4.i()
            java.lang.String r1 = r4.j()
            if (r1 == 0) goto L_0x000f
            java.lang.String r1 = r4.j()
            goto L_0x0011
        L_0x000f:
            java.lang.String r1 = ""
        L_0x0011:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = ": "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r3.<init>(r0)
            r3.j = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.b.<init>(com.google.android.gms.common.api.Status):void");
    }

    public Status a() {
        return this.j;
    }
}
