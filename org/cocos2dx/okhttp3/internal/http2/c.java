package org.cocos2dx.okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.http2.a;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSink;

final class c implements Closeable {
    private static final Logger p = Logger.getLogger(Http2.class.getName());
    private final BufferedSink j;
    private final boolean k;
    private final Buffer l;
    private int m = 16384;
    private boolean n;
    final a.b o;

    c(BufferedSink bufferedSink, boolean z) {
        this.j = bufferedSink;
        this.k = z;
        Buffer buffer = new Buffer();
        this.l = buffer;
        this.o = new a.b(buffer);
    }

    private void y(int i, long j2) {
        while (j2 > 0) {
            int min = (int) Math.min((long) this.m, j2);
            long j3 = (long) min;
            j2 -= j3;
            n(i, min, (byte) 9, j2 == 0 ? (byte) 4 : 0);
            this.j.write(this.l, j3);
        }
    }

    private static void z(BufferedSink bufferedSink, int i) {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    public synchronized void c(Settings settings) {
        if (!this.n) {
            this.m = settings.getMaxFrameSize(this.m);
            if (settings.getHeaderTableSize() != -1) {
                this.o.e(settings.getHeaderTableSize());
            }
            n(0, 0, (byte) 4, (byte) 1);
            this.j.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void close() {
        this.n = true;
        this.j.close();
    }

    public synchronized void f() {
        if (this.n) {
            throw new IOException("closed");
        } else if (this.k) {
            Logger logger = p;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
            }
            this.j.write(Http2.CONNECTION_PREFACE.toByteArray());
            this.j.flush();
        }
    }

    public synchronized void flush() {
        if (!this.n) {
            this.j.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void h(boolean z, int i, Buffer buffer, int i2) {
        if (!this.n) {
            byte b2 = 0;
            if (z) {
                b2 = (byte) 1;
            }
            i(i, b2, buffer, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    public void i(int i, byte b2, Buffer buffer, int i2) {
        n(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.j.write(buffer, (long) i2);
        }
    }

    public void n(int i, int i2, byte b2, byte b3) {
        Logger logger = p;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.frameLog(false, i, i2, b2, b3));
        }
        int i3 = this.m;
        if (i2 > i3) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        } else if ((Integer.MIN_VALUE & i) == 0) {
            z(this.j, i2);
            this.j.writeByte(b2 & 255);
            this.j.writeByte(b3 & 255);
            this.j.writeInt(i & Integer.MAX_VALUE);
        } else {
            throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    public synchronized void o(int i, ErrorCode errorCode, byte[] bArr) {
        if (this.n) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            n(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.j.writeInt(i);
            this.j.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.j.write(bArr);
            }
            this.j.flush();
        } else {
            throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public void p(boolean z, int i, List<Header> list) {
        if (!this.n) {
            this.o.g(list);
            long size = this.l.size();
            int min = (int) Math.min((long) this.m, size);
            long j2 = (long) min;
            byte b2 = size == j2 ? (byte) 4 : 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            n(i, min, (byte) 1, b2);
            this.j.write(this.l, j2);
            if (size > j2) {
                y(i, size - j2);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public int q() {
        return this.m;
    }

    public synchronized void r(boolean z, int i, int i2) {
        if (!this.n) {
            n(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.j.writeInt(i);
            this.j.writeInt(i2);
            this.j.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void s(int i, int i2, List<Header> list) {
        if (!this.n) {
            this.o.g(list);
            long size = this.l.size();
            int min = (int) Math.min((long) (this.m - 4), size);
            long j2 = (long) min;
            n(i, min + 4, (byte) 5, size == j2 ? (byte) 4 : 0);
            this.j.writeInt(i2 & Integer.MAX_VALUE);
            this.j.write(this.l, j2);
            if (size > j2) {
                y(i, size - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void t(int i, ErrorCode errorCode) {
        if (this.n) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            n(i, 4, (byte) 3, (byte) 0);
            this.j.writeInt(errorCode.httpCode);
            this.j.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void u(Settings settings) {
        if (!this.n) {
            int i = 0;
            n(0, settings.size() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (settings.isSet(i)) {
                    this.j.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.j.writeInt(settings.get(i));
                }
                i++;
            }
            this.j.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void v(boolean z, int i, List<Header> list) {
        if (!this.n) {
            p(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void w(boolean z, int i, int i2, List<Header> list) {
        if (!this.n) {
            p(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void x(int i, long j2) {
        if (this.n) {
            throw new IOException("closed");
        } else if (j2 == 0 || j2 > 2147483647L) {
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
        } else {
            n(i, 4, (byte) 8, (byte) 0);
            this.j.writeInt((int) j2);
            this.j.flush();
        }
    }
}
