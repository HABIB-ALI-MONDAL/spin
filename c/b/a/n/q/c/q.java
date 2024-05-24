package c.b.a.n.q.c;

import c.b.a.n.o.z.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class q extends FilterInputStream {
    private volatile byte[] j;
    private int k;
    private int l;
    private int m;
    private int n;
    private final b o;

    static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    public q(InputStream inputStream, b bVar) {
        this(inputStream, bVar, 65536);
    }

    q(InputStream inputStream, b bVar, int i) {
        super(inputStream);
        this.m = -1;
        this.o = bVar;
        this.j = (byte[]) bVar.e(i, byte[].class);
    }

    private int c(InputStream inputStream, byte[] bArr) {
        int i;
        int i2 = this.m;
        if (i2 == -1 || this.n - i2 >= (i = this.l)) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.m = -1;
                this.n = 0;
                this.k = read;
            }
            return read;
        }
        if (i2 == 0 && i > bArr.length && this.k == bArr.length) {
            int length = bArr.length * 2;
            if (length <= i) {
                i = length;
            }
            byte[] bArr2 = (byte[]) this.o.e(i, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.j = bArr2;
            this.o.d(bArr);
            bArr = bArr2;
        } else if (i2 > 0) {
            System.arraycopy(bArr, i2, bArr, 0, bArr.length - i2);
        }
        int i3 = this.n - this.m;
        this.n = i3;
        this.m = 0;
        this.k = 0;
        int read2 = inputStream.read(bArr, i3, bArr.length - i3);
        int i4 = this.n;
        if (read2 > 0) {
            i4 += read2;
        }
        this.k = i4;
        return read2;
    }

    private static IOException i() {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized int available() {
        InputStream inputStream;
        inputStream = this.in;
        if (this.j == null || inputStream == null) {
            i();
            throw null;
        }
        return (this.k - this.n) + inputStream.available();
    }

    public void close() {
        if (this.j != null) {
            this.o.d(this.j);
            this.j = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void f() {
        this.l = this.j.length;
    }

    public synchronized void h() {
        if (this.j != null) {
            this.o.d(this.j);
            this.j = null;
        }
    }

    public synchronized void mark(int i) {
        this.l = Math.max(this.l, i);
        this.m = this.n;
    }

    public boolean markSupported() {
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0026=Splitter:B:19:0x0026, B:11:0x0019=Splitter:B:11:0x0019, B:28:0x0039=Splitter:B:28:0x0039} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read() {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r6.j     // Catch:{ all -> 0x003d }
            java.io.InputStream r1 = r6.in     // Catch:{ all -> 0x003d }
            r2 = 0
            if (r0 == 0) goto L_0x0039
            if (r1 == 0) goto L_0x0039
            int r3 = r6.n     // Catch:{ all -> 0x003d }
            int r4 = r6.k     // Catch:{ all -> 0x003d }
            r5 = -1
            if (r3 < r4) goto L_0x0019
            int r1 = r6.c(r1, r0)     // Catch:{ all -> 0x003d }
            if (r1 != r5) goto L_0x0019
            monitor-exit(r6)
            return r5
        L_0x0019:
            byte[] r1 = r6.j     // Catch:{ all -> 0x003d }
            if (r0 == r1) goto L_0x0026
            byte[] r0 = r6.j     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0022
            goto L_0x0026
        L_0x0022:
            i()     // Catch:{ all -> 0x003d }
            throw r2
        L_0x0026:
            int r1 = r6.k     // Catch:{ all -> 0x003d }
            int r2 = r6.n     // Catch:{ all -> 0x003d }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x0037
            int r1 = r2 + 1
            r6.n = r1     // Catch:{ all -> 0x003d }
            byte r0 = r0[r2]     // Catch:{ all -> 0x003d }
            r0 = r0 & 255(0xff, float:3.57E-43)
            monitor-exit(r6)
            return r0
        L_0x0037:
            monitor-exit(r6)
            return r5
        L_0x0039:
            i()     // Catch:{ all -> 0x003d }
            throw r2
        L_0x003d:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.n.q.c.q.read():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0032, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0048, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0055, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r8, int r9, int r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            byte[] r0 = r7.j     // Catch:{ all -> 0x008e }
            r1 = 0
            if (r0 == 0) goto L_0x008a
            if (r10 != 0) goto L_0x000b
            r8 = 0
            monitor-exit(r7)
            return r8
        L_0x000b:
            java.io.InputStream r2 = r7.in     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x0086
            int r3 = r7.n     // Catch:{ all -> 0x008e }
            int r4 = r7.k     // Catch:{ all -> 0x008e }
            if (r3 >= r4) goto L_0x0033
            int r5 = r4 - r3
            if (r5 < r10) goto L_0x001b
            r4 = r10
            goto L_0x001c
        L_0x001b:
            int r4 = r4 - r3
        L_0x001c:
            java.lang.System.arraycopy(r0, r3, r8, r9, r4)     // Catch:{ all -> 0x008e }
            int r3 = r7.n     // Catch:{ all -> 0x008e }
            int r3 = r3 + r4
            r7.n = r3     // Catch:{ all -> 0x008e }
            if (r4 == r10) goto L_0x0031
            int r3 = r2.available()     // Catch:{ all -> 0x008e }
            if (r3 != 0) goto L_0x002d
            goto L_0x0031
        L_0x002d:
            int r9 = r9 + r4
            int r3 = r10 - r4
            goto L_0x0034
        L_0x0031:
            monitor-exit(r7)
            return r4
        L_0x0033:
            r3 = r10
        L_0x0034:
            int r4 = r7.m     // Catch:{ all -> 0x008e }
            r5 = -1
            if (r4 != r5) goto L_0x0049
            int r4 = r0.length     // Catch:{ all -> 0x008e }
            if (r3 < r4) goto L_0x0049
            int r4 = r2.read(r8, r9, r3)     // Catch:{ all -> 0x008e }
            if (r4 != r5) goto L_0x0076
            if (r3 != r10) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            int r5 = r10 - r3
        L_0x0047:
            monitor-exit(r7)
            return r5
        L_0x0049:
            int r4 = r7.c(r2, r0)     // Catch:{ all -> 0x008e }
            if (r4 != r5) goto L_0x0056
            if (r3 != r10) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            int r5 = r10 - r3
        L_0x0054:
            monitor-exit(r7)
            return r5
        L_0x0056:
            byte[] r4 = r7.j     // Catch:{ all -> 0x008e }
            if (r0 == r4) goto L_0x0063
            byte[] r0 = r7.j     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x005f
            goto L_0x0063
        L_0x005f:
            i()     // Catch:{ all -> 0x008e }
            throw r1
        L_0x0063:
            int r4 = r7.k     // Catch:{ all -> 0x008e }
            int r5 = r7.n     // Catch:{ all -> 0x008e }
            int r6 = r4 - r5
            if (r6 < r3) goto L_0x006d
            r4 = r3
            goto L_0x006e
        L_0x006d:
            int r4 = r4 - r5
        L_0x006e:
            java.lang.System.arraycopy(r0, r5, r8, r9, r4)     // Catch:{ all -> 0x008e }
            int r5 = r7.n     // Catch:{ all -> 0x008e }
            int r5 = r5 + r4
            r7.n = r5     // Catch:{ all -> 0x008e }
        L_0x0076:
            int r3 = r3 - r4
            if (r3 != 0) goto L_0x007b
            monitor-exit(r7)
            return r10
        L_0x007b:
            int r5 = r2.available()     // Catch:{ all -> 0x008e }
            if (r5 != 0) goto L_0x0084
            int r10 = r10 - r3
            monitor-exit(r7)
            return r10
        L_0x0084:
            int r9 = r9 + r4
            goto L_0x0034
        L_0x0086:
            i()     // Catch:{ all -> 0x008e }
            throw r1
        L_0x008a:
            i()     // Catch:{ all -> 0x008e }
            throw r1
        L_0x008e:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x0092
        L_0x0091:
            throw r8
        L_0x0092:
            goto L_0x0091
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.n.q.c.q.read(byte[], int, int):int");
    }

    public synchronized void reset() {
        if (this.j != null) {
            int i = this.m;
            if (-1 != i) {
                this.n = i;
            } else {
                throw new a("Mark has been invalidated, pos: " + this.n + " markLimit: " + this.l);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    public synchronized long skip(long j2) {
        if (j2 < 1) {
            return 0;
        }
        byte[] bArr = this.j;
        if (bArr != null) {
            InputStream inputStream = this.in;
            if (inputStream != null) {
                int i = this.k;
                int i2 = this.n;
                if (((long) (i - i2)) >= j2) {
                    this.n = (int) (((long) i2) + j2);
                    return j2;
                }
                long j3 = ((long) i) - ((long) i2);
                this.n = i;
                if (this.m == -1 || j2 > ((long) this.l)) {
                    return j3 + inputStream.skip(j2 - j3);
                } else if (c(inputStream, bArr) == -1) {
                    return j3;
                } else {
                    int i3 = this.k;
                    int i4 = this.n;
                    if (((long) (i3 - i4)) >= j2 - j3) {
                        this.n = (int) ((((long) i4) + j2) - j3);
                        return j2;
                    }
                    long j4 = (j3 + ((long) i3)) - ((long) i4);
                    this.n = i3;
                    return j4;
                }
            } else {
                i();
                throw null;
            }
        } else {
            i();
            throw null;
        }
    }
}
