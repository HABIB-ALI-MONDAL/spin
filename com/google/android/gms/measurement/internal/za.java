package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.g3;

final class za extends ya {
    private final g3 g;
    final /* synthetic */ b h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    za(b bVar, String str, int i, g3 g3Var) {
        super(str, i);
        this.h = bVar;
        this.g = g3Var;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.g.E();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return true;
    }

    /* JADX WARNING: type inference failed for: r2v16, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(java.lang.Long r11, java.lang.Long r12, c.d.a.b.e.e.a5 r13, boolean r14) {
        /*
            r10 = this;
            c.d.a.b.e.e.mc.c()
            com.google.android.gms.measurement.internal.b r0 = r10.h
            com.google.android.gms.measurement.internal.x4 r0 = r0.f2527a
            com.google.android.gms.measurement.internal.h r0 = r0.z()
            java.lang.String r1 = r10.f2643a
            com.google.android.gms.measurement.internal.x2 r2 = com.google.android.gms.measurement.internal.y2.V
            boolean r0 = r0.B(r1, r2)
            c.d.a.b.e.e.g3 r1 = r10.g
            boolean r1 = r1.K()
            c.d.a.b.e.e.g3 r2 = r10.g
            boolean r2 = r2.L()
            c.d.a.b.e.e.g3 r3 = r10.g
            boolean r3 = r3.M()
            r4 = 0
            r5 = 1
            if (r1 != 0) goto L_0x0030
            if (r2 != 0) goto L_0x0030
            if (r3 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r1 = 0
            goto L_0x0031
        L_0x0030:
            r1 = 1
        L_0x0031:
            r2 = 0
            if (r14 == 0) goto L_0x0060
            if (r1 != 0) goto L_0x0060
            com.google.android.gms.measurement.internal.b r11 = r10.h
            com.google.android.gms.measurement.internal.x4 r11 = r11.f2527a
            com.google.android.gms.measurement.internal.m3 r11 = r11.f()
            com.google.android.gms.measurement.internal.k3 r11 = r11.v()
            int r12 = r10.f2644b
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            c.d.a.b.e.e.g3 r13 = r10.g
            boolean r13 = r13.N()
            if (r13 == 0) goto L_0x005a
            c.d.a.b.e.e.g3 r13 = r10.g
            int r13 = r13.E()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
        L_0x005a:
            java.lang.String r13 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r11.c(r13, r12, r2)
            return r5
        L_0x0060:
            c.d.a.b.e.e.g3 r6 = r10.g
            c.d.a.b.e.e.a3 r6 = r6.F()
            boolean r7 = r6.K()
            boolean r8 = r13.U()
            if (r8 == 0) goto L_0x00ab
            boolean r8 = r6.M()
            if (r8 != 0) goto L_0x0099
            com.google.android.gms.measurement.internal.b r6 = r10.h
            com.google.android.gms.measurement.internal.x4 r6 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()
            com.google.android.gms.measurement.internal.k3 r6 = r6.w()
            com.google.android.gms.measurement.internal.b r7 = r10.h
            com.google.android.gms.measurement.internal.x4 r7 = r7.f2527a
            com.google.android.gms.measurement.internal.h3 r7 = r7.D()
            java.lang.String r8 = r13.J()
            java.lang.String r7 = r7.f(r8)
            java.lang.String r8 = "No number filter for long property. property"
        L_0x0094:
            r6.b(r8, r7)
            goto L_0x0188
        L_0x0099:
            long r8 = r13.F()
            c.d.a.b.e.e.e3 r2 = r6.G()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.ya.h(r8, r2)
        L_0x00a5:
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.ya.j(r2, r7)
            goto L_0x0188
        L_0x00ab:
            boolean r8 = r13.T()
            if (r8 == 0) goto L_0x00e3
            boolean r8 = r6.M()
            if (r8 != 0) goto L_0x00d6
            com.google.android.gms.measurement.internal.b r6 = r10.h
            com.google.android.gms.measurement.internal.x4 r6 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()
            com.google.android.gms.measurement.internal.k3 r6 = r6.w()
            com.google.android.gms.measurement.internal.b r7 = r10.h
            com.google.android.gms.measurement.internal.x4 r7 = r7.f2527a
            com.google.android.gms.measurement.internal.h3 r7 = r7.D()
            java.lang.String r8 = r13.J()
            java.lang.String r7 = r7.f(r8)
            java.lang.String r8 = "No number filter for double property. property"
            goto L_0x0094
        L_0x00d6:
            double r8 = r13.E()
            c.d.a.b.e.e.e3 r2 = r6.G()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.ya.g(r8, r2)
            goto L_0x00a5
        L_0x00e3:
            boolean r8 = r13.W()
            if (r8 == 0) goto L_0x0168
            boolean r8 = r6.O()
            if (r8 != 0) goto L_0x0152
            boolean r8 = r6.M()
            if (r8 != 0) goto L_0x0114
            com.google.android.gms.measurement.internal.b r6 = r10.h
            com.google.android.gms.measurement.internal.x4 r6 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()
            com.google.android.gms.measurement.internal.k3 r6 = r6.w()
            com.google.android.gms.measurement.internal.b r7 = r10.h
            com.google.android.gms.measurement.internal.x4 r7 = r7.f2527a
            com.google.android.gms.measurement.internal.h3 r7 = r7.D()
            java.lang.String r8 = r13.J()
            java.lang.String r7 = r7.f(r8)
            java.lang.String r8 = "No string or number filter defined. property"
            goto L_0x0094
        L_0x0114:
            java.lang.String r8 = r13.K()
            boolean r8 = com.google.android.gms.measurement.internal.ea.N(r8)
            if (r8 == 0) goto L_0x012c
            java.lang.String r2 = r13.K()
            c.d.a.b.e.e.e3 r6 = r6.G()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.ya.i(r2, r6)
            goto L_0x00a5
        L_0x012c:
            com.google.android.gms.measurement.internal.b r6 = r10.h
            com.google.android.gms.measurement.internal.x4 r6 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()
            com.google.android.gms.measurement.internal.k3 r6 = r6.w()
            com.google.android.gms.measurement.internal.b r7 = r10.h
            com.google.android.gms.measurement.internal.x4 r7 = r7.f2527a
            com.google.android.gms.measurement.internal.h3 r7 = r7.D()
            java.lang.String r8 = r13.J()
            java.lang.String r7 = r7.f(r8)
            java.lang.String r8 = r13.K()
            java.lang.String r9 = "Invalid user property value for Numeric number filter. property, value"
            r6.c(r9, r7, r8)
            goto L_0x0188
        L_0x0152:
            java.lang.String r2 = r13.K()
            c.d.a.b.e.e.k3 r6 = r6.H()
            com.google.android.gms.measurement.internal.b r8 = r10.h
            com.google.android.gms.measurement.internal.x4 r8 = r8.f2527a
            com.google.android.gms.measurement.internal.m3 r8 = r8.f()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.ya.f(r2, r6, r8)
            goto L_0x00a5
        L_0x0168:
            com.google.android.gms.measurement.internal.b r6 = r10.h
            com.google.android.gms.measurement.internal.x4 r6 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()
            com.google.android.gms.measurement.internal.k3 r6 = r6.w()
            com.google.android.gms.measurement.internal.b r7 = r10.h
            com.google.android.gms.measurement.internal.x4 r7 = r7.f2527a
            com.google.android.gms.measurement.internal.h3 r7 = r7.D()
            java.lang.String r8 = r13.J()
            java.lang.String r7 = r7.f(r8)
            java.lang.String r8 = "User property has no value, property"
            goto L_0x0094
        L_0x0188:
            com.google.android.gms.measurement.internal.b r6 = r10.h
            com.google.android.gms.measurement.internal.x4 r6 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()
            com.google.android.gms.measurement.internal.k3 r6 = r6.v()
            if (r2 != 0) goto L_0x0199
            java.lang.String r7 = "null"
            goto L_0x019a
        L_0x0199:
            r7 = r2
        L_0x019a:
            java.lang.String r8 = "Property filter result"
            r6.b(r8, r7)
            if (r2 != 0) goto L_0x01a2
            return r4
        L_0x01a2:
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r10.f2645c = r4
            if (r3 == 0) goto L_0x01b0
            boolean r3 = r2.booleanValue()
            if (r3 == 0) goto L_0x01af
            goto L_0x01b0
        L_0x01af:
            return r5
        L_0x01b0:
            if (r14 == 0) goto L_0x01ba
            c.d.a.b.e.e.g3 r14 = r10.g
            boolean r14 = r14.K()
            if (r14 == 0) goto L_0x01bc
        L_0x01ba:
            r10.f2646d = r2
        L_0x01bc:
            boolean r14 = r2.booleanValue()
            if (r14 == 0) goto L_0x0201
            if (r1 == 0) goto L_0x0201
            boolean r14 = r13.V()
            if (r14 == 0) goto L_0x0201
            long r13 = r13.G()
            if (r11 == 0) goto L_0x01d4
            long r13 = r11.longValue()
        L_0x01d4:
            if (r0 == 0) goto L_0x01ec
            c.d.a.b.e.e.g3 r11 = r10.g
            boolean r11 = r11.K()
            if (r11 == 0) goto L_0x01ec
            c.d.a.b.e.e.g3 r11 = r10.g
            boolean r11 = r11.L()
            if (r11 != 0) goto L_0x01ec
            if (r12 == 0) goto L_0x01ec
            long r13 = r12.longValue()
        L_0x01ec:
            c.d.a.b.e.e.g3 r11 = r10.g
            boolean r11 = r11.L()
            if (r11 == 0) goto L_0x01fb
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.f2648f = r11
            goto L_0x0201
        L_0x01fb:
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.f2647e = r11
        L_0x0201:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.za.k(java.lang.Long, java.lang.Long, c.d.a.b.e.e.a5, boolean):boolean");
    }
}
