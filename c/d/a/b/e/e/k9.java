package c.d.a.b.e.e;

public final class k9 extends n {
    private final c k;

    public k9(c cVar) {
        this.k = cVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final c.d.a.b.e.e.q l(java.lang.String r17, c.d.a.b.e.e.n4 r18, java.util.List r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            int r4 = r17.hashCode()
            r6 = 4
            r7 = 3
            java.lang.String r8 = "setEventName"
            java.lang.String r9 = "setParamValue"
            java.lang.String r10 = "getParams"
            java.lang.String r11 = "getParamValue"
            java.lang.String r12 = "getTimestamp"
            java.lang.String r13 = "getEventName"
            r14 = 2
            r15 = 1
            r5 = 0
            switch(r4) {
                case 21624207: goto L_0x0049;
                case 45521504: goto L_0x0041;
                case 146575578: goto L_0x0039;
                case 700587132: goto L_0x0031;
                case 920706790: goto L_0x0029;
                case 1570616835: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x0051
        L_0x0021:
            boolean r4 = r1.equals(r8)
            if (r4 == 0) goto L_0x0051
            r4 = 4
            goto L_0x0052
        L_0x0029:
            boolean r4 = r1.equals(r9)
            if (r4 == 0) goto L_0x0051
            r4 = 5
            goto L_0x0052
        L_0x0031:
            boolean r4 = r1.equals(r10)
            if (r4 == 0) goto L_0x0051
            r4 = 2
            goto L_0x0052
        L_0x0039:
            boolean r4 = r1.equals(r11)
            if (r4 == 0) goto L_0x0051
            r4 = 1
            goto L_0x0052
        L_0x0041:
            boolean r4 = r1.equals(r12)
            if (r4 == 0) goto L_0x0051
            r4 = 3
            goto L_0x0052
        L_0x0049:
            boolean r4 = r1.equals(r13)
            if (r4 == 0) goto L_0x0051
            r4 = 0
            goto L_0x0052
        L_0x0051:
            r4 = -1
        L_0x0052:
            if (r4 == 0) goto L_0x0134
            if (r4 == r15) goto L_0x0114
            if (r4 == r14) goto L_0x00e1
            if (r4 == r7) goto L_0x00c9
            if (r4 == r6) goto L_0x008d
            r6 = 5
            if (r4 == r6) goto L_0x0064
            c.d.a.b.e.e.q r1 = super.l(r17, r18, r19)
            return r1
        L_0x0064:
            c.d.a.b.e.e.n5.h(r9, r14, r3)
            java.lang.Object r1 = r3.get(r5)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r1 = r2.b(r1)
            java.lang.String r1 = r1.g()
            java.lang.Object r3 = r3.get(r15)
            c.d.a.b.e.e.q r3 = (c.d.a.b.e.e.q) r3
            c.d.a.b.e.e.q r2 = r2.b(r3)
            c.d.a.b.e.e.c r3 = r0.k
            c.d.a.b.e.e.b r3 = r3.b()
            java.lang.Object r4 = c.d.a.b.e.e.n5.f(r2)
            r3.g(r1, r4)
            return r2
        L_0x008d:
            c.d.a.b.e.e.n5.h(r8, r15, r3)
            java.lang.Object r1 = r3.get(r5)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r1 = r2.b(r1)
            c.d.a.b.e.e.q r2 = c.d.a.b.e.e.q.f1722b
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00c1
            c.d.a.b.e.e.q r2 = c.d.a.b.e.e.q.f1723c
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x00c1
            c.d.a.b.e.e.c r2 = r0.k
            c.d.a.b.e.e.b r2 = r2.b()
            java.lang.String r3 = r1.g()
            r2.f(r3)
            c.d.a.b.e.e.u r2 = new c.d.a.b.e.e.u
            java.lang.String r1 = r1.g()
            r2.<init>(r1)
            return r2
        L_0x00c1:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Illegal event name"
            r1.<init>(r2)
            throw r1
        L_0x00c9:
            c.d.a.b.e.e.n5.h(r12, r5, r3)
            c.d.a.b.e.e.c r1 = r0.k
            c.d.a.b.e.e.b r1 = r1.b()
            c.d.a.b.e.e.i r2 = new c.d.a.b.e.e.i
            long r3 = r1.a()
            double r3 = (double) r3
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r2.<init>(r1)
            return r2
        L_0x00e1:
            c.d.a.b.e.e.n5.h(r10, r5, r3)
            c.d.a.b.e.e.c r1 = r0.k
            c.d.a.b.e.e.b r1 = r1.b()
            java.util.Map r1 = r1.e()
            c.d.a.b.e.e.n r2 = new c.d.a.b.e.e.n
            r2.<init>()
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x00fb:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0113
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r1.get(r4)
            c.d.a.b.e.e.q r5 = c.d.a.b.e.e.o6.b(r5)
            r2.r(r4, r5)
            goto L_0x00fb
        L_0x0113:
            return r2
        L_0x0114:
            c.d.a.b.e.e.n5.h(r11, r15, r3)
            java.lang.Object r1 = r3.get(r5)
            c.d.a.b.e.e.q r1 = (c.d.a.b.e.e.q) r1
            c.d.a.b.e.e.q r1 = r2.b(r1)
            java.lang.String r1 = r1.g()
            c.d.a.b.e.e.c r2 = r0.k
            c.d.a.b.e.e.b r2 = r2.b()
            java.lang.Object r1 = r2.c(r1)
            c.d.a.b.e.e.q r1 = c.d.a.b.e.e.o6.b(r1)
            return r1
        L_0x0134:
            c.d.a.b.e.e.n5.h(r13, r5, r3)
            c.d.a.b.e.e.c r1 = r0.k
            c.d.a.b.e.e.b r1 = r1.b()
            c.d.a.b.e.e.u r2 = new c.d.a.b.e.e.u
            java.lang.String r1 = r1.d()
            r2.<init>(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.k9.l(java.lang.String, c.d.a.b.e.e.n4, java.util.List):c.d.a.b.e.e.q");
    }
}
