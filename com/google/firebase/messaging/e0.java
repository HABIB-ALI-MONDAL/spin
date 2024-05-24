package com.google.firebase.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

final class e0 {

    private static final class a extends FilterInputStream {
        private long j;
        private long k = -1;

        a(InputStream inputStream, long j2) {
            super(inputStream);
            this.j = j2;
        }

        public int available() {
            return (int) Math.min((long) this.in.available(), this.j);
        }

        public synchronized void mark(int i) {
            this.in.mark(i);
            this.k = this.j;
        }

        public int read() {
            if (this.j == 0) {
                return -1;
            }
            int read = this.in.read();
            if (read != -1) {
                this.j--;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) {
            long j2 = this.j;
            if (j2 == 0) {
                return -1;
            }
            int read = this.in.read(bArr, i, (int) Math.min((long) i2, j2));
            if (read != -1) {
                this.j -= (long) read;
            }
            return read;
        }

        public synchronized void reset() {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.k != -1) {
                this.in.reset();
                this.j = this.k;
            } else {
                throw new IOException("Mark not set");
            }
        }

        public long skip(long j2) {
            long skip = this.in.skip(Math.min(j2, this.j));
            this.j -= skip;
            return skip;
        }
    }

    private static byte[] a(Queue<byte[]> queue, int i) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i) {
            return remove;
        }
        int length = i - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i - length, min);
            length -= min;
        }
        return copyOf;
    }

    public static InputStream b(InputStream inputStream, long j) {
        return new a(inputStream, j);
    }

    private static int c(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static byte[] d(InputStream inputStream) {
        return e(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] e(InputStream inputStream, Queue<byte[]> queue, int i) {
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i) * 2));
        while (i < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i2 = 0;
            while (i2 < min2) {
                int read = inputStream.read(bArr, i2, min2 - i2);
                if (read == -1) {
                    return a(queue, i);
                }
                i2 += read;
                i += read;
            }
            min = c(((long) min) * ((long) (min < 4096 ? 4 : 2)));
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
