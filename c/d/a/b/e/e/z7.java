package c.d.a.b.e.e;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class z7 extends j7 {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f1790b = Logger.getLogger(z7.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f1791c = kb.C();

    /* renamed from: a  reason: collision with root package name */
    a8 f1792a;

    private z7() {
    }

    /* synthetic */ z7(y7 y7Var) {
    }

    public static int A(c9 c9Var) {
        int a2 = c9Var.a();
        return a(a2) + a2;
    }

    static int B(x9 x9Var, ia iaVar) {
        int i = ((d7) x9Var).i(iaVar);
        return a(i) + i;
    }

    public static int C(String str) {
        int i;
        try {
            i = qb.c(str);
        } catch (pb unused) {
            i = str.getBytes(y8.f1783a).length;
        }
        return a(i) + i;
    }

    public static int D(int i) {
        return a(i << 3);
    }

    public static int a(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int b(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static z7 c(byte[] bArr) {
        return new w7(bArr, 0, bArr.length);
    }

    public static int x(r7 r7Var) {
        int i = r7Var.i();
        return a(i) + i;
    }

    @Deprecated
    static int y(int i, x9 x9Var, ia iaVar) {
        int a2 = a(i << 3);
        return a2 + a2 + ((d7) x9Var).i(iaVar);
    }

    public static int z(int i) {
        if (i >= 0) {
            return a(i);
        }
        return 10;
    }

    public final void d() {
        if (g() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(String str, pb pbVar) {
        f1790b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", pbVar);
        byte[] bytes = str.getBytes(y8.f1783a);
        try {
            int length = bytes.length;
            u(length);
            q(bytes, 0, length);
        } catch (IndexOutOfBoundsException e2) {
            throw new x7(e2);
        }
    }

    public abstract int g();

    public abstract void h(byte b2);

    public abstract void i(int i, boolean z);

    public abstract void j(int i, r7 r7Var);

    public abstract void k(int i, int i2);

    public abstract void l(int i);

    public abstract void m(int i, long j);

    public abstract void n(long j);

    public abstract void o(int i, int i2);

    public abstract void p(int i);

    public abstract void q(byte[] bArr, int i, int i2);

    public abstract void r(int i, String str);

    public abstract void s(int i, int i2);

    public abstract void t(int i, int i2);

    public abstract void u(int i);

    public abstract void v(int i, long j);

    public abstract void w(long j);
}
