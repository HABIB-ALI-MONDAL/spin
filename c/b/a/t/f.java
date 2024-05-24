package c.b.a.t;

import java.io.FilterInputStream;
import java.io.InputStream;

public class f extends FilterInputStream {
    private int j = Integer.MIN_VALUE;

    public f(InputStream inputStream) {
        super(inputStream);
    }

    private long c(long j2) {
        int i = this.j;
        if (i == 0) {
            return -1;
        }
        return (i == Integer.MIN_VALUE || j2 <= ((long) i)) ? j2 : (long) i;
    }

    private void f(long j2) {
        int i = this.j;
        if (i != Integer.MIN_VALUE && j2 != -1) {
            this.j = (int) (((long) i) - j2);
        }
    }

    public int available() {
        int i = this.j;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    public synchronized void mark(int i) {
        super.mark(i);
        this.j = i;
    }

    public int read() {
        if (c(1) == -1) {
            return -1;
        }
        int read = super.read();
        f(1);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int c2 = (int) c((long) i2);
        if (c2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i, c2);
        f((long) read);
        return read;
    }

    public synchronized void reset() {
        super.reset();
        this.j = Integer.MIN_VALUE;
    }

    public long skip(long j2) {
        long c2 = c(j2);
        if (c2 == -1) {
            return 0;
        }
        long skip = super.skip(c2);
        f(skip);
        return skip;
    }
}
