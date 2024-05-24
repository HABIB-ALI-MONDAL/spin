package c.d.a.b.e.e;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

public abstract class r7 implements Iterable, Serializable {
    public static final r7 k = new q7(y8.f1784b);
    private int j = 0;

    static {
        int i = f7.f1631a;
    }

    r7() {
    }

    static int s(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }

    public static r7 u(byte[] bArr, int i, int i2) {
        s(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new q7(bArr2);
    }

    public static r7 v(String str) {
        return new q7(str.getBytes(y8.f1783a));
    }

    public abstract byte d(int i);

    public abstract boolean equals(Object obj);

    /* access modifiers changed from: package-private */
    public abstract byte g(int i);

    public final int hashCode() {
        int i = this.j;
        if (i == 0) {
            int i2 = i();
            i = j(i2, 0, i2);
            if (i == 0) {
                i = 1;
            }
            this.j = i;
        }
        return i;
    }

    public abstract int i();

    public final /* synthetic */ Iterator iterator() {
        return new k7(this);
    }

    /* access modifiers changed from: protected */
    public abstract int j(int i, int i2, int i3);

    public abstract r7 k(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String l(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void p(j7 j7Var);

    public abstract boolean r();

    /* access modifiers changed from: protected */
    public final int t() {
        return this.j;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(i());
        objArr[2] = i() <= 50 ? ya.a(this) : ya.a(k(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public final String w(Charset charset) {
        return i() == 0 ? "" : l(charset);
    }
}
