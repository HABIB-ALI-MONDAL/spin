package c.b.a.n.n;

import c.b.a.n.o.z.b;
import java.io.OutputStream;

public final class c extends OutputStream {
    private final OutputStream j;
    private byte[] k;
    private b l;
    private int m;

    public c(OutputStream outputStream, b bVar) {
        this(outputStream, bVar, 65536);
    }

    c(OutputStream outputStream, b bVar, int i) {
        this.j = outputStream;
        this.l = bVar;
        this.k = (byte[]) bVar.e(i, byte[].class);
    }

    private void c() {
        int i = this.m;
        if (i > 0) {
            this.j.write(this.k, 0, i);
            this.m = 0;
        }
    }

    private void f() {
        if (this.m == this.k.length) {
            c();
        }
    }

    private void h() {
        byte[] bArr = this.k;
        if (bArr != null) {
            this.l.d(bArr);
            this.k = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() {
        try {
            flush();
            this.j.close();
            h();
        } catch (Throwable th) {
            this.j.close();
            throw th;
        }
    }

    public void flush() {
        c();
        this.j.flush();
    }

    public void write(int i) {
        byte[] bArr = this.k;
        int i2 = this.m;
        this.m = i2 + 1;
        bArr[i2] = (byte) i;
        f();
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.m;
            if (i6 != 0 || i4 < this.k.length) {
                int min = Math.min(i4, this.k.length - i6);
                System.arraycopy(bArr, i5, this.k, this.m, min);
                this.m += min;
                i3 += min;
                f();
            } else {
                this.j.write(bArr, i5, i4);
                return;
            }
        } while (i3 < i2);
    }
}
