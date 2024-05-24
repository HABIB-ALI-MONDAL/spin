package c.d.a.b.e.e;

import java.nio.charset.Charset;
import java.util.Objects;

class q7 extends p7 {
    protected final byte[] l;

    q7(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.l = bArr;
    }

    public byte d(int i) {
        return this.l[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r7) || i() != ((r7) obj).i()) {
            return false;
        }
        if (i() == 0) {
            return true;
        }
        if (!(obj instanceof q7)) {
            return obj.equals(this);
        }
        q7 q7Var = (q7) obj;
        int t = t();
        int t2 = q7Var.t();
        if (t != 0 && t2 != 0 && t != t2) {
            return false;
        }
        int i = i();
        if (i > q7Var.i()) {
            int i2 = i();
            throw new IllegalArgumentException("Length too large: " + i + i2);
        } else if (i > q7Var.i()) {
            int i3 = q7Var.i();
            throw new IllegalArgumentException("Ran off end of other: 0, " + i + ", " + i3);
        } else if (!(q7Var instanceof q7)) {
            return q7Var.k(0, i).equals(k(0, i));
        } else {
            byte[] bArr = this.l;
            byte[] bArr2 = q7Var.l;
            q7Var.x();
            int i4 = 0;
            int i5 = 0;
            while (i4 < i) {
                if (bArr[i4] != bArr2[i5]) {
                    return false;
                }
                i4++;
                i5++;
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public byte g(int i) {
        return this.l[i];
    }

    public int i() {
        return this.l.length;
    }

    /* access modifiers changed from: protected */
    public final int j(int i, int i2, int i3) {
        return y8.d(i, this.l, 0, i3);
    }

    public final r7 k(int i, int i2) {
        int s = r7.s(0, i2, i());
        return s == 0 ? r7.k : new m7(this.l, 0, s);
    }

    /* access modifiers changed from: protected */
    public final String l(Charset charset) {
        return new String(this.l, 0, i(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void p(j7 j7Var) {
        ((w7) j7Var).E(this.l, 0, i());
    }

    public final boolean r() {
        return qb.f(this.l, 0, i());
    }

    /* access modifiers changed from: protected */
    public int x() {
        return 0;
    }
}
