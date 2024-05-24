package c.b.a.t;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class c extends InputStream {
    private static final Queue<c> l = i.e(0);
    private InputStream j;
    private IOException k;

    c() {
    }

    public static c f(InputStream inputStream) {
        c poll;
        Queue<c> queue = l;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new c();
        }
        poll.i(inputStream);
        return poll;
    }

    public int available() {
        return this.j.available();
    }

    public IOException c() {
        return this.k;
    }

    public void close() {
        this.j.close();
    }

    public void h() {
        this.k = null;
        this.j = null;
        Queue<c> queue = l;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(InputStream inputStream) {
        this.j = inputStream;
    }

    public void mark(int i) {
        this.j.mark(i);
    }

    public boolean markSupported() {
        return this.j.markSupported();
    }

    public int read() {
        try {
            return this.j.read();
        } catch (IOException e2) {
            this.k = e2;
            return -1;
        }
    }

    public int read(byte[] bArr) {
        try {
            return this.j.read(bArr);
        } catch (IOException e2) {
            this.k = e2;
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.j.read(bArr, i, i2);
        } catch (IOException e2) {
            this.k = e2;
            return -1;
        }
    }

    public synchronized void reset() {
        this.j.reset();
    }

    public long skip(long j2) {
        try {
            return this.j.skip(j2);
        } catch (IOException e2) {
            this.k = e2;
            return 0;
        }
    }
}
