package c.b.a.t;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b extends FilterInputStream {
    private final long j;
    private int k;

    private b(InputStream inputStream, long j2) {
        super(inputStream);
        this.j = j2;
    }

    private int c(int i) {
        if (i >= 0) {
            this.k += i;
        } else if (this.j - ((long) this.k) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.j + ", but read: " + this.k);
        }
        return i;
    }

    public static InputStream f(InputStream inputStream, long j2) {
        return new b(inputStream, j2);
    }

    public synchronized int available() {
        return (int) Math.max(this.j - ((long) this.k), (long) this.in.available());
    }

    public synchronized int read() {
        int read;
        read = super.read();
        c(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        int read;
        read = super.read(bArr, i, i2);
        c(read);
        return read;
    }
}
