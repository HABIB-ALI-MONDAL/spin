package c.b.a.n.n;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class g extends FilterInputStream {
    private static final byte[] l;
    private static final int m;
    private static final int n;
    private final byte j;
    private int k;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        l = bArr;
        int length = bArr.length;
        m = length;
        n = length + 2;
    }

    public g(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
        }
        this.j = (byte) i;
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        int i;
        int i2 = this.k;
        int read = (i2 < 2 || i2 > (i = n)) ? super.read() : i2 == i ? this.j : l[i2 - 2] & 255;
        if (read != -1) {
            this.k++;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.k;
        int i5 = n;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.j;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(l, this.k - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.k += i3;
        }
        return i3;
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }

    public long skip(long j2) {
        long skip = super.skip(j2);
        if (skip > 0) {
            this.k = (int) (((long) this.k) + skip);
        }
        return skip;
    }
}
