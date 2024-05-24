package com.google.android.gms.measurement.internal;

import c.d.a.b.e.e.y2;

final class xa extends ya {
    private final y2 g;
    final /* synthetic */ b h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    xa(b bVar, String str, int i, y2 y2Var) {
        super(str, i);
        this.h = bVar;
        this.g = y2Var;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.g.F();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return this.g.R();
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0115, code lost:
        if (r4.booleanValue() == false) goto L_0x03c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0156, code lost:
        r2.b(r5, r4);
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03d4  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03dc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x03dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(java.lang.Long r18, java.lang.Long r19, c.d.a.b.e.e.g4 r20, long r21, com.google.android.gms.measurement.internal.t r23, boolean r24) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            c.d.a.b.e.e.mc.c()
            com.google.android.gms.measurement.internal.b r3 = r0.h
            com.google.android.gms.measurement.internal.x4 r3 = r3.f2527a
            com.google.android.gms.measurement.internal.h r3 = r3.z()
            java.lang.String r4 = r0.f2643a
            com.google.android.gms.measurement.internal.x2 r5 = com.google.android.gms.measurement.internal.y2.X
            boolean r3 = r3.B(r4, r5)
            c.d.a.b.e.e.y2 r4 = r0.g
            boolean r4 = r4.Q()
            if (r4 == 0) goto L_0x0026
            r4 = r23
            long r4 = r4.f2544e
            goto L_0x0028
        L_0x0026:
            r4 = r21
        L_0x0028:
            com.google.android.gms.measurement.internal.b r6 = r0.h
            com.google.android.gms.measurement.internal.x4 r6 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()
            java.lang.String r6 = r6.C()
            r7 = 2
            boolean r6 = android.util.Log.isLoggable(r6, r7)
            r7 = 0
            if (r6 == 0) goto L_0x0098
            com.google.android.gms.measurement.internal.b r6 = r0.h
            com.google.android.gms.measurement.internal.x4 r6 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()
            com.google.android.gms.measurement.internal.k3 r6 = r6.v()
            int r8 = r0.f2644b
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            c.d.a.b.e.e.y2 r9 = r0.g
            boolean r9 = r9.S()
            if (r9 == 0) goto L_0x0061
            c.d.a.b.e.e.y2 r9 = r0.g
            int r9 = r9.F()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x0062
        L_0x0061:
            r9 = r7
        L_0x0062:
            com.google.android.gms.measurement.internal.b r10 = r0.h
            com.google.android.gms.measurement.internal.x4 r10 = r10.f2527a
            com.google.android.gms.measurement.internal.h3 r10 = r10.D()
            c.d.a.b.e.e.y2 r11 = r0.g
            java.lang.String r11 = r11.K()
            java.lang.String r10 = r10.d(r11)
            java.lang.String r11 = "Evaluating filter. audience, filter, event"
            r6.d(r11, r8, r9, r10)
            com.google.android.gms.measurement.internal.b r6 = r0.h
            com.google.android.gms.measurement.internal.x4 r6 = r6.f2527a
            com.google.android.gms.measurement.internal.m3 r6 = r6.f()
            com.google.android.gms.measurement.internal.k3 r6 = r6.v()
            com.google.android.gms.measurement.internal.b r8 = r0.h
            com.google.android.gms.measurement.internal.ca r8 = r8.f2504b
            com.google.android.gms.measurement.internal.ea r8 = r8.f0()
            c.d.a.b.e.e.y2 r9 = r0.g
            java.lang.String r8 = r8.E(r9)
            java.lang.String r9 = "Filter definition"
            r6.b(r9, r8)
        L_0x0098:
            c.d.a.b.e.e.y2 r6 = r0.g
            boolean r6 = r6.S()
            r8 = 0
            if (r6 == 0) goto L_0x041f
            c.d.a.b.e.e.y2 r6 = r0.g
            int r6 = r6.F()
            r9 = 256(0x100, float:3.59E-43)
            if (r6 <= r9) goto L_0x00ad
            goto L_0x041f
        L_0x00ad:
            c.d.a.b.e.e.y2 r6 = r0.g
            boolean r6 = r6.O()
            c.d.a.b.e.e.y2 r9 = r0.g
            boolean r9 = r9.P()
            c.d.a.b.e.e.y2 r10 = r0.g
            boolean r10 = r10.Q()
            r11 = 1
            if (r6 != 0) goto L_0x00c9
            if (r9 != 0) goto L_0x00c9
            if (r10 == 0) goto L_0x00c7
            goto L_0x00c9
        L_0x00c7:
            r6 = 0
            goto L_0x00ca
        L_0x00c9:
            r6 = 1
        L_0x00ca:
            if (r24 == 0) goto L_0x00f8
            if (r6 != 0) goto L_0x00f8
            com.google.android.gms.measurement.internal.b r1 = r0.h
            com.google.android.gms.measurement.internal.x4 r1 = r1.f2527a
            com.google.android.gms.measurement.internal.m3 r1 = r1.f()
            com.google.android.gms.measurement.internal.k3 r1 = r1.v()
            int r2 = r0.f2644b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            c.d.a.b.e.e.y2 r3 = r0.g
            boolean r3 = r3.S()
            if (r3 == 0) goto L_0x00f2
            c.d.a.b.e.e.y2 r3 = r0.g
            int r3 = r3.F()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
        L_0x00f2:
            java.lang.String r3 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.c(r3, r2, r7)
            return r11
        L_0x00f8:
            c.d.a.b.e.e.y2 r9 = r0.g
            java.lang.String r10 = r20.L()
            boolean r12 = r9.R()
            if (r12 == 0) goto L_0x0119
            c.d.a.b.e.e.e3 r12 = r9.J()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.ya.h(r4, r12)
            if (r4 != 0) goto L_0x0111
        L_0x010e:
            r2 = r7
            goto L_0x03c3
        L_0x0111:
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x0119
            goto L_0x03c3
        L_0x0119:
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.List r5 = r9.L()
            java.util.Iterator r5 = r5.iterator()
        L_0x0126:
            boolean r12 = r5.hasNext()
            if (r12 == 0) goto L_0x0162
            java.lang.Object r12 = r5.next()
            c.d.a.b.e.e.a3 r12 = (c.d.a.b.e.e.a3) r12
            java.lang.String r13 = r12.I()
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x015a
            com.google.android.gms.measurement.internal.b r2 = r0.h
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.w()
            com.google.android.gms.measurement.internal.b r4 = r0.h
            com.google.android.gms.measurement.internal.x4 r4 = r4.f2527a
            com.google.android.gms.measurement.internal.h3 r4 = r4.D()
            java.lang.String r4 = r4.d(r10)
            java.lang.String r5 = "null or empty param name in filter. event"
        L_0x0156:
            r2.b(r5, r4)
            goto L_0x010e
        L_0x015a:
            java.lang.String r12 = r12.I()
            r4.add(r12)
            goto L_0x0126
        L_0x0162:
            b.c.a r5 = new b.c.a
            r5.<init>()
            java.util.List r12 = r20.M()
            java.util.Iterator r12 = r12.iterator()
        L_0x016f:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01fa
            java.lang.Object r13 = r12.next()
            c.d.a.b.e.e.k4 r13 = (c.d.a.b.e.e.k4) r13
            java.lang.String r14 = r13.K()
            boolean r14 = r4.contains(r14)
            if (r14 == 0) goto L_0x016f
            boolean r14 = r13.Z()
            if (r14 == 0) goto L_0x01a0
            java.lang.String r14 = r13.K()
            boolean r15 = r13.Z()
            if (r15 == 0) goto L_0x019e
            long r15 = r13.H()
            java.lang.Long r13 = java.lang.Long.valueOf(r15)
            goto L_0x01c7
        L_0x019e:
            r13 = r7
            goto L_0x01c7
        L_0x01a0:
            boolean r14 = r13.X()
            if (r14 == 0) goto L_0x01b9
            java.lang.String r14 = r13.K()
            boolean r15 = r13.X()
            if (r15 == 0) goto L_0x019e
            double r15 = r13.E()
            java.lang.Double r13 = java.lang.Double.valueOf(r15)
            goto L_0x01c7
        L_0x01b9:
            boolean r14 = r13.b0()
            if (r14 == 0) goto L_0x01cb
            java.lang.String r14 = r13.K()
            java.lang.String r13 = r13.L()
        L_0x01c7:
            r5.put(r14, r13)
            goto L_0x016f
        L_0x01cb:
            com.google.android.gms.measurement.internal.b r2 = r0.h
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.w()
            com.google.android.gms.measurement.internal.b r4 = r0.h
            com.google.android.gms.measurement.internal.x4 r4 = r4.f2527a
            com.google.android.gms.measurement.internal.h3 r4 = r4.D()
            java.lang.String r4 = r4.d(r10)
            com.google.android.gms.measurement.internal.b r5 = r0.h
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a
            com.google.android.gms.measurement.internal.h3 r5 = r5.D()
            java.lang.String r9 = r13.K()
            java.lang.String r5 = r5.e(r9)
            java.lang.String r9 = "Unknown value for param. event, param"
        L_0x01f5:
            r2.c(r9, r4, r5)
            goto L_0x010e
        L_0x01fa:
            java.util.List r4 = r9.L()
            java.util.Iterator r4 = r4.iterator()
        L_0x0202:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x03c2
            java.lang.Object r9 = r4.next()
            c.d.a.b.e.e.a3 r9 = (c.d.a.b.e.e.a3) r9
            boolean r12 = r9.L()
            if (r12 == 0) goto L_0x021c
            boolean r12 = r9.K()
            if (r12 == 0) goto L_0x021c
            r12 = 1
            goto L_0x021d
        L_0x021c:
            r12 = 0
        L_0x021d:
            java.lang.String r13 = r9.I()
            boolean r14 = r13.isEmpty()
            if (r14 == 0) goto L_0x0243
            com.google.android.gms.measurement.internal.b r2 = r0.h
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.w()
            com.google.android.gms.measurement.internal.b r4 = r0.h
            com.google.android.gms.measurement.internal.x4 r4 = r4.f2527a
            com.google.android.gms.measurement.internal.h3 r4 = r4.D()
            java.lang.String r4 = r4.d(r10)
            java.lang.String r5 = "Event has empty param name. event"
            goto L_0x0156
        L_0x0243:
            java.lang.Object r14 = r5.get(r13)
            boolean r15 = r14 instanceof java.lang.Long
            if (r15 == 0) goto L_0x0293
            boolean r15 = r9.M()
            if (r15 != 0) goto L_0x0279
            com.google.android.gms.measurement.internal.b r2 = r0.h
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.w()
            com.google.android.gms.measurement.internal.b r4 = r0.h
            com.google.android.gms.measurement.internal.x4 r4 = r4.f2527a
            com.google.android.gms.measurement.internal.h3 r4 = r4.D()
            java.lang.String r4 = r4.d(r10)
            com.google.android.gms.measurement.internal.b r5 = r0.h
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a
            com.google.android.gms.measurement.internal.h3 r5 = r5.D()
            java.lang.String r5 = r5.e(r13)
            java.lang.String r9 = "No number filter for long param. event, param"
            goto L_0x01f5
        L_0x0279:
            java.lang.Long r14 = (java.lang.Long) r14
            long r13 = r14.longValue()
            c.d.a.b.e.e.e3 r9 = r9.G()
            java.lang.Boolean r9 = com.google.android.gms.measurement.internal.ya.h(r13, r9)
            if (r9 != 0) goto L_0x028b
            goto L_0x010e
        L_0x028b:
            boolean r9 = r9.booleanValue()
            if (r9 != r12) goto L_0x0202
            goto L_0x03c3
        L_0x0293:
            boolean r15 = r14 instanceof java.lang.Double
            if (r15 == 0) goto L_0x02df
            boolean r15 = r9.M()
            if (r15 != 0) goto L_0x02c5
            com.google.android.gms.measurement.internal.b r2 = r0.h
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.w()
            com.google.android.gms.measurement.internal.b r4 = r0.h
            com.google.android.gms.measurement.internal.x4 r4 = r4.f2527a
            com.google.android.gms.measurement.internal.h3 r4 = r4.D()
            java.lang.String r4 = r4.d(r10)
            com.google.android.gms.measurement.internal.b r5 = r0.h
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a
            com.google.android.gms.measurement.internal.h3 r5 = r5.D()
            java.lang.String r5 = r5.e(r13)
            java.lang.String r9 = "No number filter for double param. event, param"
            goto L_0x01f5
        L_0x02c5:
            java.lang.Double r14 = (java.lang.Double) r14
            double r13 = r14.doubleValue()
            c.d.a.b.e.e.e3 r9 = r9.G()
            java.lang.Boolean r9 = com.google.android.gms.measurement.internal.ya.g(r13, r9)
            if (r9 != 0) goto L_0x02d7
            goto L_0x010e
        L_0x02d7:
            boolean r9 = r9.booleanValue()
            if (r9 != r12) goto L_0x0202
            goto L_0x03c3
        L_0x02df:
            boolean r15 = r14 instanceof java.lang.String
            if (r15 == 0) goto L_0x036e
            boolean r15 = r9.O()
            if (r15 == 0) goto L_0x02fc
            java.lang.String r14 = (java.lang.String) r14
            c.d.a.b.e.e.k3 r9 = r9.H()
            com.google.android.gms.measurement.internal.b r13 = r0.h
            com.google.android.gms.measurement.internal.x4 r13 = r13.f2527a
            com.google.android.gms.measurement.internal.m3 r13 = r13.f()
            java.lang.Boolean r9 = com.google.android.gms.measurement.internal.ya.f(r14, r9, r13)
            goto L_0x0312
        L_0x02fc:
            boolean r15 = r9.M()
            if (r15 == 0) goto L_0x0346
            java.lang.String r14 = (java.lang.String) r14
            boolean r15 = com.google.android.gms.measurement.internal.ea.N(r14)
            if (r15 == 0) goto L_0x031e
            c.d.a.b.e.e.e3 r9 = r9.G()
            java.lang.Boolean r9 = com.google.android.gms.measurement.internal.ya.i(r14, r9)
        L_0x0312:
            if (r9 != 0) goto L_0x0316
            goto L_0x010e
        L_0x0316:
            boolean r9 = r9.booleanValue()
            if (r9 != r12) goto L_0x0202
            goto L_0x03c3
        L_0x031e:
            com.google.android.gms.measurement.internal.b r2 = r0.h
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.w()
            com.google.android.gms.measurement.internal.b r4 = r0.h
            com.google.android.gms.measurement.internal.x4 r4 = r4.f2527a
            com.google.android.gms.measurement.internal.h3 r4 = r4.D()
            java.lang.String r4 = r4.d(r10)
            com.google.android.gms.measurement.internal.b r5 = r0.h
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a
            com.google.android.gms.measurement.internal.h3 r5 = r5.D()
            java.lang.String r5 = r5.e(r13)
            java.lang.String r9 = "Invalid param value for number filter. event, param"
            goto L_0x01f5
        L_0x0346:
            com.google.android.gms.measurement.internal.b r2 = r0.h
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.w()
            com.google.android.gms.measurement.internal.b r4 = r0.h
            com.google.android.gms.measurement.internal.x4 r4 = r4.f2527a
            com.google.android.gms.measurement.internal.h3 r4 = r4.D()
            java.lang.String r4 = r4.d(r10)
            com.google.android.gms.measurement.internal.b r5 = r0.h
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a
            com.google.android.gms.measurement.internal.h3 r5 = r5.D()
            java.lang.String r5 = r5.e(r13)
            java.lang.String r9 = "No filter for String param. event, param"
            goto L_0x01f5
        L_0x036e:
            if (r14 != 0) goto L_0x039a
            com.google.android.gms.measurement.internal.b r4 = r0.h
            com.google.android.gms.measurement.internal.x4 r4 = r4.f2527a
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()
            com.google.android.gms.measurement.internal.k3 r4 = r4.v()
            com.google.android.gms.measurement.internal.b r5 = r0.h
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a
            com.google.android.gms.measurement.internal.h3 r5 = r5.D()
            java.lang.String r5 = r5.d(r10)
            com.google.android.gms.measurement.internal.b r7 = r0.h
            com.google.android.gms.measurement.internal.x4 r7 = r7.f2527a
            com.google.android.gms.measurement.internal.h3 r7 = r7.D()
            java.lang.String r7 = r7.e(r13)
            java.lang.String r9 = "Missing param for filter. event, param"
            r4.c(r9, r5, r7)
            goto L_0x03c3
        L_0x039a:
            com.google.android.gms.measurement.internal.b r2 = r0.h
            com.google.android.gms.measurement.internal.x4 r2 = r2.f2527a
            com.google.android.gms.measurement.internal.m3 r2 = r2.f()
            com.google.android.gms.measurement.internal.k3 r2 = r2.w()
            com.google.android.gms.measurement.internal.b r4 = r0.h
            com.google.android.gms.measurement.internal.x4 r4 = r4.f2527a
            com.google.android.gms.measurement.internal.h3 r4 = r4.D()
            java.lang.String r4 = r4.d(r10)
            com.google.android.gms.measurement.internal.b r5 = r0.h
            com.google.android.gms.measurement.internal.x4 r5 = r5.f2527a
            com.google.android.gms.measurement.internal.h3 r5 = r5.D()
            java.lang.String r5 = r5.e(r13)
            java.lang.String r9 = "Unknown param type. event, param"
            goto L_0x01f5
        L_0x03c2:
            r2 = r1
        L_0x03c3:
            com.google.android.gms.measurement.internal.b r4 = r0.h
            com.google.android.gms.measurement.internal.x4 r4 = r4.f2527a
            com.google.android.gms.measurement.internal.m3 r4 = r4.f()
            com.google.android.gms.measurement.internal.k3 r4 = r4.v()
            if (r2 != 0) goto L_0x03d4
            java.lang.String r5 = "null"
            goto L_0x03d5
        L_0x03d4:
            r5 = r2
        L_0x03d5:
            java.lang.String r7 = "Event filter result"
            r4.b(r7, r5)
            if (r2 != 0) goto L_0x03dd
            return r8
        L_0x03dd:
            r0.f2645c = r1
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x03e6
            return r11
        L_0x03e6:
            r0.f2646d = r1
            if (r6 == 0) goto L_0x041e
            boolean r1 = r20.X()
            if (r1 == 0) goto L_0x041e
            long r1 = r20.H()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            c.d.a.b.e.e.y2 r2 = r0.g
            boolean r2 = r2.P()
            if (r2 == 0) goto L_0x0410
            if (r3 == 0) goto L_0x040d
            c.d.a.b.e.e.y2 r2 = r0.g
            boolean r2 = r2.R()
            if (r2 != 0) goto L_0x040b
            goto L_0x040d
        L_0x040b:
            r1 = r18
        L_0x040d:
            r0.f2648f = r1
            goto L_0x041e
        L_0x0410:
            if (r3 == 0) goto L_0x041c
            c.d.a.b.e.e.y2 r2 = r0.g
            boolean r2 = r2.R()
            if (r2 == 0) goto L_0x041c
            r1 = r19
        L_0x041c:
            r0.f2647e = r1
        L_0x041e:
            return r11
        L_0x041f:
            com.google.android.gms.measurement.internal.b r1 = r0.h
            com.google.android.gms.measurement.internal.x4 r1 = r1.f2527a
            com.google.android.gms.measurement.internal.m3 r1 = r1.f()
            com.google.android.gms.measurement.internal.k3 r1 = r1.w()
            java.lang.String r2 = r0.f2643a
            java.lang.Object r2 = com.google.android.gms.measurement.internal.m3.z(r2)
            c.d.a.b.e.e.y2 r3 = r0.g
            boolean r3 = r3.S()
            if (r3 == 0) goto L_0x0443
            c.d.a.b.e.e.y2 r3 = r0.g
            int r3 = r3.F()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
        L_0x0443:
            java.lang.String r3 = java.lang.String.valueOf(r7)
            java.lang.String r4 = "Invalid event filter ID. appId, id"
            r1.c(r4, r2, r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.xa.k(java.lang.Long, java.lang.Long, c.d.a.b.e.e.g4, long, com.google.android.gms.measurement.internal.t, boolean):boolean");
    }
}
