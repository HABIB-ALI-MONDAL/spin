package c.b.a.l;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class b implements Closeable {
    private final InputStream j;
    /* access modifiers changed from: private */
    public final Charset k;
    private byte[] l;
    private int m;
    private int n;

    class a extends ByteArrayOutputStream {
        a(int i) {
            super(i);
        }

        public String toString() {
            int i = this.count;
            if (i > 0 && this.buf[i - 1] == 13) {
                i--;
            }
            try {
                return new String(this.buf, 0, i, b.this.k.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(c.f850a)) {
            this.j = inputStream;
            this.k = charset;
            this.l = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void f() {
        InputStream inputStream = this.j;
        byte[] bArr = this.l;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.m = 0;
            this.n = read;
            return;
        }
        throw new EOFException();
    }

    public void close() {
        synchronized (this.j) {
            if (this.l != null) {
                this.l = null;
                this.j.close();
            }
        }
    }

    public boolean h() {
        return this.n == -1;
    }

    public String i() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.j) {
            if (this.l != null) {
                if (this.m >= this.n) {
                    f();
                }
                for (int i3 = this.m; i3 != this.n; i3++) {
                    byte[] bArr2 = this.l;
                    if (bArr2[i3] == 10) {
                        if (i3 != this.m) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                byte[] bArr3 = this.l;
                                int i4 = this.m;
                                String str = new String(bArr3, i4, i2 - i4, this.k.name());
                                this.m = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        byte[] bArr32 = this.l;
                        int i42 = this.m;
                        String str2 = new String(bArr32, i42, i2 - i42, this.k.name());
                        this.m = i3 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.n - this.m) + 80);
                loop1:
                while (true) {
                    byte[] bArr4 = this.l;
                    int i5 = this.m;
                    aVar.write(bArr4, i5, this.n - i5);
                    this.n = -1;
                    f();
                    i = this.m;
                    while (true) {
                        if (i != this.n) {
                            bArr = this.l;
                            if (bArr[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                int i6 = this.m;
                if (i != i6) {
                    aVar.write(bArr, i6, i - i6);
                }
                this.m = i + 1;
                String byteArrayOutputStream = aVar.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }
}
