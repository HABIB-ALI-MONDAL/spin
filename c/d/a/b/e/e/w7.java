package c.d.a.b.e.e;

import java.util.Objects;

final class w7 extends z7 {

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f1774d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1775e;

    /* renamed from: f  reason: collision with root package name */
    private int f1776f;

    w7(byte[] bArr, int i, int i2) {
        super((y7) null);
        Objects.requireNonNull(bArr, "buffer");
        int length = bArr.length;
        if (((length - i2) | i2) >= 0) {
            this.f1774d = bArr;
            this.f1776f = 0;
            this.f1775e = i2;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i2)}));
    }

    public final void E(byte[] bArr, int i, int i2) {
        try {
            System.arraycopy(bArr, 0, this.f1774d, this.f1776f, i2);
            this.f1776f += i2;
        } catch (IndexOutOfBoundsException e2) {
            throw new x7(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f1776f), Integer.valueOf(this.f1775e), Integer.valueOf(i2)}), e2);
        }
    }

    public final void F(String str) {
        int i = this.f1776f;
        try {
            int a2 = z7.a(str.length() * 3);
            int a3 = z7.a(str.length());
            if (a3 == a2) {
                int i2 = i + a3;
                this.f1776f = i2;
                int b2 = qb.b(str, this.f1774d, i2, this.f1775e - i2);
                this.f1776f = i;
                u((b2 - i) - a3);
                this.f1776f = b2;
                return;
            }
            u(qb.c(str));
            byte[] bArr = this.f1774d;
            int i3 = this.f1776f;
            this.f1776f = qb.b(str, bArr, i3, this.f1775e - i3);
        } catch (pb e2) {
            this.f1776f = i;
            e(str, e2);
        } catch (IndexOutOfBoundsException e3) {
            throw new x7(e3);
        }
    }

    public final int g() {
        return this.f1775e - this.f1776f;
    }

    public final void h(byte b2) {
        try {
            byte[] bArr = this.f1774d;
            int i = this.f1776f;
            this.f1776f = i + 1;
            bArr[i] = b2;
        } catch (IndexOutOfBoundsException e2) {
            throw new x7(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f1776f), Integer.valueOf(this.f1775e), 1}), e2);
        }
    }

    public final void i(int i, boolean z) {
        u(i << 3);
        h(z ? (byte) 1 : 0);
    }

    public final void j(int i, r7 r7Var) {
        u((i << 3) | 2);
        u(r7Var.i());
        r7Var.p(this);
    }

    public final void k(int i, int i2) {
        u((i << 3) | 5);
        l(i2);
    }

    public final void l(int i) {
        try {
            byte[] bArr = this.f1774d;
            int i2 = this.f1776f;
            int i3 = i2 + 1;
            this.f1776f = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i3 + 1;
            this.f1776f = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i4 + 1;
            this.f1776f = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.f1776f = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new x7(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f1776f), Integer.valueOf(this.f1775e), 1}), e2);
        }
    }

    public final void m(int i, long j) {
        u((i << 3) | 1);
        n(j);
    }

    public final void n(long j) {
        try {
            byte[] bArr = this.f1774d;
            int i = this.f1776f;
            int i2 = i + 1;
            this.f1776f = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i2 + 1;
            this.f1776f = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i3 + 1;
            this.f1776f = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i4 + 1;
            this.f1776f = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i5 + 1;
            this.f1776f = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 + 1;
            this.f1776f = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i7 + 1;
            this.f1776f = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.f1776f = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new x7(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f1776f), Integer.valueOf(this.f1775e), 1}), e2);
        }
    }

    public final void o(int i, int i2) {
        u(i << 3);
        p(i2);
    }

    public final void p(int i) {
        if (i >= 0) {
            u(i);
        } else {
            w((long) i);
        }
    }

    public final void q(byte[] bArr, int i, int i2) {
        E(bArr, 0, i2);
    }

    public final void r(int i, String str) {
        u((i << 3) | 2);
        F(str);
    }

    public final void s(int i, int i2) {
        u((i << 3) | i2);
    }

    public final void t(int i, int i2) {
        u(i << 3);
        u(i2);
    }

    public final void u(int i) {
        while ((i & -128) != 0) {
            byte[] bArr = this.f1774d;
            int i2 = this.f1776f;
            this.f1776f = i2 + 1;
            bArr[i2] = (byte) ((i & 127) | 128);
            i >>>= 7;
        }
        try {
            byte[] bArr2 = this.f1774d;
            int i3 = this.f1776f;
            this.f1776f = i3 + 1;
            bArr2[i3] = (byte) i;
        } catch (IndexOutOfBoundsException e2) {
            throw new x7(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f1776f), Integer.valueOf(this.f1775e), 1}), e2);
        }
    }

    public final void v(int i, long j) {
        u(i << 3);
        w(j);
    }

    public final void w(long j) {
        if (!z7.f1791c || this.f1775e - this.f1776f < 10) {
            while ((j & -128) != 0) {
                byte[] bArr = this.f1774d;
                int i = this.f1776f;
                this.f1776f = i + 1;
                bArr[i] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            }
            try {
                byte[] bArr2 = this.f1774d;
                int i2 = this.f1776f;
                this.f1776f = i2 + 1;
                bArr2[i2] = (byte) ((int) j);
            } catch (IndexOutOfBoundsException e2) {
                throw new x7(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f1776f), Integer.valueOf(this.f1775e), 1}), e2);
            }
        } else {
            while ((j & -128) != 0) {
                byte[] bArr3 = this.f1774d;
                int i3 = this.f1776f;
                this.f1776f = i3 + 1;
                kb.s(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr4 = this.f1774d;
            int i4 = this.f1776f;
            this.f1776f = i4 + 1;
            kb.s(bArr4, (long) i4, (byte) ((int) j));
        }
    }
}
