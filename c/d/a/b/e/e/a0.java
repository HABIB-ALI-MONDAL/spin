package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.List;

public final class a0 extends x {
    protected a0() {
        this.f1778a.add(n0.APPLY);
        this.f1778a.add(n0.BLOCK);
        this.f1778a.add(n0.BREAK);
        this.f1778a.add(n0.CASE);
        this.f1778a.add(n0.DEFAULT);
        this.f1778a.add(n0.CONTINUE);
        this.f1778a.add(n0.DEFINE_FUNCTION);
        this.f1778a.add(n0.FN);
        this.f1778a.add(n0.IF);
        this.f1778a.add(n0.QUOTE);
        this.f1778a.add(n0.RETURN);
        this.f1778a.add(n0.SWITCH);
        this.f1778a.add(n0.TERNARY);
    }

    private static q c(n4 n4Var, List list) {
        n5.i(n0.FN.name(), 2, list);
        q b2 = n4Var.b((q) list.get(0));
        q b3 = n4Var.b((q) list.get(1));
        if (b3 instanceof f) {
            List x = ((f) b3).x();
            List arrayList = new ArrayList();
            if (list.size() > 2) {
                arrayList = list.subList(2, list.size());
            }
            return new p(b2.g(), x, arrayList, n4Var);
        }
        throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", new Object[]{b3.getClass().getCanonicalName()}));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0123, code lost:
        if (r9.equals("continue") == false) goto L_0x0127;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final c.d.a.b.e.e.q a(java.lang.String r9, c.d.a.b.e.e.n4 r10, java.util.List r11) {
        /*
            r8 = this;
            c.d.a.b.e.e.n0 r0 = c.d.a.b.e.e.n0.ADD
            c.d.a.b.e.e.n0 r0 = c.d.a.b.e.e.n5.e(r9)
            int r0 = r0.ordinal()
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == r2) goto L_0x0203
            r5 = 15
            if (r0 == r5) goto L_0x01f7
            r5 = 25
            if (r0 == r5) goto L_0x01f2
            r5 = 41
            r6 = 0
            if (r0 == r5) goto L_0x01a2
            r5 = 54
            if (r0 == r5) goto L_0x019c
            r5 = 57
            java.lang.String r7 = "return"
            if (r0 == r5) goto L_0x0179
            r5 = 19
            if (r0 == r5) goto L_0x015b
            r5 = 20
            if (r0 == r5) goto L_0x013a
            r5 = 60
            if (r0 == r5) goto L_0x0085
            r5 = 61
            if (r0 == r5) goto L_0x0058
            switch(r0) {
                case 11: goto L_0x004a;
                case 12: goto L_0x003e;
                case 13: goto L_0x015b;
                default: goto L_0x003a;
            }
        L_0x003a:
            super.b(r9)
            throw r6
        L_0x003e:
            c.d.a.b.e.e.n0 r9 = c.d.a.b.e.e.n0.BREAK
            java.lang.String r9 = r9.name()
            c.d.a.b.e.e.n5.h(r9, r4, r11)
            c.d.a.b.e.e.q r9 = c.d.a.b.e.e.q.f1725e
            return r9
        L_0x004a:
            c.d.a.b.e.e.n4 r9 = r10.a()
            c.d.a.b.e.e.f r10 = new c.d.a.b.e.e.f
            r10.<init>(r11)
            c.d.a.b.e.e.q r9 = r9.c(r10)
            return r9
        L_0x0058:
            c.d.a.b.e.e.n0 r9 = c.d.a.b.e.e.n0.TERNARY
            java.lang.String r9 = r9.name()
            c.d.a.b.e.e.n5.h(r9, r1, r11)
            java.lang.Object r9 = r11.get(r4)
            c.d.a.b.e.e.q r9 = (c.d.a.b.e.e.q) r9
            c.d.a.b.e.e.q r9 = r10.b(r9)
            java.lang.Boolean r9 = r9.k()
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x007a
            java.lang.Object r9 = r11.get(r3)
            goto L_0x007e
        L_0x007a:
            java.lang.Object r9 = r11.get(r2)
        L_0x007e:
            c.d.a.b.e.e.q r9 = (c.d.a.b.e.e.q) r9
            c.d.a.b.e.e.q r9 = r10.b(r9)
            return r9
        L_0x0085:
            c.d.a.b.e.e.n0 r9 = c.d.a.b.e.e.n0.SWITCH
            java.lang.String r9 = r9.name()
            c.d.a.b.e.e.n5.h(r9, r1, r11)
            java.lang.Object r9 = r11.get(r4)
            c.d.a.b.e.e.q r9 = (c.d.a.b.e.e.q) r9
            c.d.a.b.e.e.q r9 = r10.b(r9)
            java.lang.Object r0 = r11.get(r3)
            c.d.a.b.e.e.q r0 = (c.d.a.b.e.e.q) r0
            c.d.a.b.e.e.q r0 = r10.b(r0)
            java.lang.Object r11 = r11.get(r2)
            c.d.a.b.e.e.q r11 = (c.d.a.b.e.e.q) r11
            c.d.a.b.e.e.q r11 = r10.b(r11)
            boolean r1 = r0 instanceof c.d.a.b.e.e.f
            if (r1 == 0) goto L_0x0132
            boolean r1 = r11 instanceof c.d.a.b.e.e.f
            if (r1 == 0) goto L_0x012a
            c.d.a.b.e.e.f r0 = (c.d.a.b.e.e.f) r0
            c.d.a.b.e.e.f r11 = (c.d.a.b.e.e.f) r11
            r1 = 0
            r2 = 0
        L_0x00ba:
            int r5 = r0.t()
            if (r1 >= r5) goto L_0x00f5
            if (r2 != 0) goto L_0x00d3
            c.d.a.b.e.e.q r2 = r0.u(r1)
            c.d.a.b.e.e.q r2 = r10.b(r2)
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x00d1
            goto L_0x00d3
        L_0x00d1:
            r2 = 0
            goto L_0x00f2
        L_0x00d3:
            c.d.a.b.e.e.q r2 = r11.u(r1)
            c.d.a.b.e.e.q r2 = r10.b(r2)
            boolean r5 = r2 instanceof c.d.a.b.e.e.h
            if (r5 == 0) goto L_0x00f1
            r9 = r2
            c.d.a.b.e.e.h r9 = (c.d.a.b.e.e.h) r9
            java.lang.String r9 = r9.b()
            java.lang.String r10 = "break"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0126
            c.d.a.b.e.e.q r9 = c.d.a.b.e.e.q.f1722b
            return r9
        L_0x00f1:
            r2 = 1
        L_0x00f2:
            int r1 = r1 + 1
            goto L_0x00ba
        L_0x00f5:
            int r9 = r0.t()
            int r9 = r9 + r3
            int r1 = r11.t()
            if (r9 != r1) goto L_0x0127
            int r9 = r0.t()
            c.d.a.b.e.e.q r9 = r11.u(r9)
            c.d.a.b.e.e.q r2 = r10.b(r9)
            boolean r9 = r2 instanceof c.d.a.b.e.e.h
            if (r9 == 0) goto L_0x0127
            r9 = r2
            c.d.a.b.e.e.h r9 = (c.d.a.b.e.e.h) r9
            java.lang.String r9 = r9.b()
            boolean r10 = r9.equals(r7)
            if (r10 != 0) goto L_0x0126
            java.lang.String r10 = "continue"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0126
            goto L_0x0127
        L_0x0126:
            return r2
        L_0x0127:
            c.d.a.b.e.e.q r9 = c.d.a.b.e.e.q.f1722b
            return r9
        L_0x012a:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Malformed SWITCH statement, case statements are not a list"
            r9.<init>(r10)
            throw r9
        L_0x0132:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Malformed SWITCH statement, cases are not a list"
            r9.<init>(r10)
            throw r9
        L_0x013a:
            c.d.a.b.e.e.n0 r9 = c.d.a.b.e.e.n0.DEFINE_FUNCTION
            java.lang.String r9 = r9.name()
            c.d.a.b.e.e.n5.i(r9, r2, r11)
            c.d.a.b.e.e.q r9 = c(r10, r11)
            r11 = r9
            c.d.a.b.e.e.j r11 = (c.d.a.b.e.e.j) r11
            java.lang.String r0 = r11.b()
            if (r0 != 0) goto L_0x0153
            java.lang.String r11 = ""
            goto L_0x0157
        L_0x0153:
            java.lang.String r11 = r11.b()
        L_0x0157:
            r10.g(r11, r9)
            return r9
        L_0x015b:
            boolean r9 = r11.isEmpty()
            if (r9 == 0) goto L_0x0164
        L_0x0161:
            c.d.a.b.e.e.q r9 = c.d.a.b.e.e.q.f1722b
            goto L_0x0178
        L_0x0164:
            java.lang.Object r9 = r11.get(r4)
            c.d.a.b.e.e.q r9 = (c.d.a.b.e.e.q) r9
            c.d.a.b.e.e.q r9 = r10.b(r9)
            boolean r11 = r9 instanceof c.d.a.b.e.e.f
            if (r11 == 0) goto L_0x0161
            c.d.a.b.e.e.f r9 = (c.d.a.b.e.e.f) r9
            c.d.a.b.e.e.q r9 = r10.c(r9)
        L_0x0178:
            return r9
        L_0x0179:
            boolean r9 = r11.isEmpty()
            if (r9 == 0) goto L_0x0182
            c.d.a.b.e.e.q r9 = c.d.a.b.e.e.q.f1726f
            goto L_0x019b
        L_0x0182:
            c.d.a.b.e.e.n0 r9 = c.d.a.b.e.e.n0.RETURN
            java.lang.String r9 = r9.name()
            c.d.a.b.e.e.n5.h(r9, r3, r11)
            java.lang.Object r9 = r11.get(r4)
            c.d.a.b.e.e.q r9 = (c.d.a.b.e.e.q) r9
            c.d.a.b.e.e.q r9 = r10.b(r9)
            c.d.a.b.e.e.h r10 = new c.d.a.b.e.e.h
            r10.<init>(r7, r9)
            r9 = r10
        L_0x019b:
            return r9
        L_0x019c:
            c.d.a.b.e.e.f r9 = new c.d.a.b.e.e.f
            r9.<init>(r11)
            return r9
        L_0x01a2:
            c.d.a.b.e.e.n0 r9 = c.d.a.b.e.e.n0.IF
            java.lang.String r9 = r9.name()
            c.d.a.b.e.e.n5.i(r9, r2, r11)
            java.lang.Object r9 = r11.get(r4)
            c.d.a.b.e.e.q r9 = (c.d.a.b.e.e.q) r9
            c.d.a.b.e.e.q r9 = r10.b(r9)
            java.lang.Object r0 = r11.get(r3)
            c.d.a.b.e.e.q r0 = (c.d.a.b.e.e.q) r0
            c.d.a.b.e.e.q r0 = r10.b(r0)
            int r1 = r11.size()
            if (r1 <= r2) goto L_0x01cf
            java.lang.Object r11 = r11.get(r2)
            c.d.a.b.e.e.q r11 = (c.d.a.b.e.e.q) r11
            c.d.a.b.e.e.q r6 = r10.b(r11)
        L_0x01cf:
            c.d.a.b.e.e.q r11 = c.d.a.b.e.e.q.f1722b
            java.lang.Boolean r9 = r9.k()
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x01e2
            c.d.a.b.e.e.f r0 = (c.d.a.b.e.e.f) r0
            c.d.a.b.e.e.q r9 = r10.c(r0)
            goto L_0x01ec
        L_0x01e2:
            if (r6 == 0) goto L_0x01eb
            c.d.a.b.e.e.f r6 = (c.d.a.b.e.e.f) r6
            c.d.a.b.e.e.q r9 = r10.c(r6)
            goto L_0x01ec
        L_0x01eb:
            r9 = r11
        L_0x01ec:
            boolean r10 = r9 instanceof c.d.a.b.e.e.h
            if (r10 == 0) goto L_0x01f1
            return r9
        L_0x01f1:
            return r11
        L_0x01f2:
            c.d.a.b.e.e.q r9 = c(r10, r11)
            return r9
        L_0x01f7:
            c.d.a.b.e.e.n0 r9 = c.d.a.b.e.e.n0.BREAK
            java.lang.String r9 = r9.name()
            c.d.a.b.e.e.n5.h(r9, r4, r11)
            c.d.a.b.e.e.q r9 = c.d.a.b.e.e.q.f1724d
            return r9
        L_0x0203:
            c.d.a.b.e.e.n0 r9 = c.d.a.b.e.e.n0.APPLY
            java.lang.String r9 = r9.name()
            c.d.a.b.e.e.n5.h(r9, r1, r11)
            java.lang.Object r9 = r11.get(r4)
            c.d.a.b.e.e.q r9 = (c.d.a.b.e.e.q) r9
            c.d.a.b.e.e.q r9 = r10.b(r9)
            java.lang.Object r0 = r11.get(r3)
            c.d.a.b.e.e.q r0 = (c.d.a.b.e.e.q) r0
            c.d.a.b.e.e.q r0 = r10.b(r0)
            java.lang.String r0 = r0.g()
            java.lang.Object r11 = r11.get(r2)
            c.d.a.b.e.e.q r11 = (c.d.a.b.e.e.q) r11
            c.d.a.b.e.e.q r11 = r10.b(r11)
            boolean r1 = r11 instanceof c.d.a.b.e.e.f
            if (r1 == 0) goto L_0x024b
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0243
            c.d.a.b.e.e.f r11 = (c.d.a.b.e.e.f) r11
            java.util.List r11 = r11.x()
            c.d.a.b.e.e.q r9 = r9.l(r0, r10, r11)
            return r9
        L_0x0243:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Function name for apply is undefined"
            r9.<init>(r10)
            throw r9
        L_0x024b:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.Object[] r10 = new java.lang.Object[r3]
            java.lang.Class r11 = r11.getClass()
            java.lang.String r11 = r11.getCanonicalName()
            r10[r4] = r11
            java.lang.String r11 = "Function arguments for Apply are not a list found %s"
            java.lang.String r10 = java.lang.String.format(r11, r10)
            r9.<init>(r10)
            goto L_0x0264
        L_0x0263:
            throw r9
        L_0x0264:
            goto L_0x0263
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.a0.a(java.lang.String, c.d.a.b.e.e.n4, java.util.List):c.d.a.b.e.e.q");
    }
}
