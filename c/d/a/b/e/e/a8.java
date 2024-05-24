package c.d.a.b.e.e;

import java.util.List;

final class a8 implements tb {

    /* renamed from: a  reason: collision with root package name */
    private final z7 f1569a;

    private a8(z7 z7Var) {
        y8.f(z7Var, "output");
        this.f1569a = z7Var;
        z7Var.f1792a = this;
    }

    public static a8 K(z7 z7Var) {
        a8 a8Var = z7Var.f1792a;
        return a8Var != null ? a8Var : new a8(z7Var);
    }

    public final void A(int i, int i2) {
        this.f1569a.k(i, i2);
    }

    public final void B(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += z7.z(((Integer) list.get(i4)).intValue());
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                this.f1569a.p(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.o(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void C(int i, boolean z) {
        this.f1569a.i(i, z);
    }

    public final void D(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += z7.b(((Long) list.get(i4)).longValue());
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                this.f1569a.w(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.v(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void E(int i, int i2) {
        this.f1569a.t(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void F(int i, String str) {
        this.f1569a.r(i, str);
    }

    public final void G(int i, long j) {
        this.f1569a.v(i, (j >> 63) ^ (j + j));
    }

    @Deprecated
    public final void H(int i) {
        this.f1569a.s(i, 4);
    }

    public final void I(int i, long j) {
        this.f1569a.v(i, j);
    }

    public final void J(int i, int i2) {
        this.f1569a.o(i, i2);
    }

    public final void a(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                this.f1569a.h(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : 0);
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.i(i, ((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    public final void b(int i, List list) {
        int i2 = 0;
        if (list instanceof e9) {
            e9 e9Var = (e9) list;
            while (i2 < list.size()) {
                Object q = e9Var.q(i2);
                if (q instanceof String) {
                    this.f1569a.r(i, (String) q);
                } else {
                    this.f1569a.j(i, (r7) q);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.r(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void c(int i, long j) {
        this.f1569a.m(i, j);
    }

    public final void d(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                this.f1569a.l(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.k(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void e(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                this.f1569a.n(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.m(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public final void f(int i, double d2) {
        this.f1569a.m(i, Double.doubleToRawLongBits(d2));
    }

    public final void g(int i, int i2) {
        this.f1569a.t(i, i2);
    }

    public final void h(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                this.f1569a.n(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.m(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void i(int i, long j) {
        this.f1569a.v(i, j);
    }

    public final void j(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f1569a.j(i, (r7) list.get(i2));
        }
    }

    public final void k(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += z7.a(((Integer) list.get(i4)).intValue());
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                this.f1569a.u(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.t(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void l(int i, Object obj, ia iaVar) {
        z7 z7Var = this.f1569a;
        z7Var.s(i, 3);
        iaVar.f((x9) obj, z7Var.f1792a);
        z7Var.s(i, 4);
    }

    public final void m(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                this.f1569a.l(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.k(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void n(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                this.f1569a.n(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.m(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void o(int i, int i2) {
        this.f1569a.k(i, i2);
    }

    @Deprecated
    public final void p(int i) {
        this.f1569a.s(i, 3);
    }

    public final void q(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                this.f1569a.l(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.k(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public final void r(int i, float f2) {
        this.f1569a.k(i, Float.floatToRawIntBits(f2));
    }

    public final void s(int i, r7 r7Var) {
        this.f1569a.j(i, r7Var);
    }

    public final void t(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                int intValue = ((Integer) list.get(i4)).intValue();
                i3 += z7.a((intValue >> 31) ^ (intValue + intValue));
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                z7 z7Var = this.f1569a;
                int intValue2 = ((Integer) list.get(i2)).intValue();
                z7Var.u((intValue2 >> 31) ^ (intValue2 + intValue2));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            z7 z7Var2 = this.f1569a;
            int intValue3 = ((Integer) list.get(i2)).intValue();
            z7Var2.t(i, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i2++;
        }
    }

    public final void u(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += z7.z(((Integer) list.get(i4)).intValue());
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                this.f1569a.p(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.o(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void v(int i, long j) {
        this.f1569a.m(i, j);
    }

    public final void w(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                long longValue = ((Long) list.get(i4)).longValue();
                i3 += z7.b((longValue >> 63) ^ (longValue + longValue));
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                z7 z7Var = this.f1569a;
                long longValue2 = ((Long) list.get(i2)).longValue();
                z7Var.w((longValue2 >> 63) ^ (longValue2 + longValue2));
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            z7 z7Var2 = this.f1569a;
            long longValue3 = ((Long) list.get(i2)).longValue();
            z7Var2.v(i, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i2++;
        }
    }

    public final void x(int i, Object obj, ia iaVar) {
        x9 x9Var = (x9) obj;
        w7 w7Var = (w7) this.f1569a;
        w7Var.u((i << 3) | 2);
        w7Var.u(((d7) x9Var).i(iaVar));
        iaVar.f(x9Var, w7Var.f1792a);
    }

    public final void y(int i, List list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f1569a.s(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += z7.b(((Long) list.get(i4)).longValue());
            }
            this.f1569a.u(i3);
            while (i2 < list.size()) {
                this.f1569a.w(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f1569a.v(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void z(int i, int i2) {
        this.f1569a.o(i, i2);
    }
}
