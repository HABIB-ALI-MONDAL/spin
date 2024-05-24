package org.cocos2dx.okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.http2.a;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.Source;
import org.cocos2dx.okio.Timeout;

final class b implements Closeable {
    static final Logger n = Logger.getLogger(Http2.class.getName());
    private final BufferedSource j;
    private final a k;
    private final boolean l;
    final a.C0088a m;

    static final class a implements Source {
        private final BufferedSource j;
        int k;
        byte l;
        int m;
        int n;
        short o;

        a(BufferedSource bufferedSource) {
            this.j = bufferedSource;
        }

        private void c() {
            int i = this.m;
            int q = b.q(this.j);
            this.n = q;
            this.k = q;
            byte readByte = (byte) (this.j.readByte() & 255);
            this.l = (byte) (this.j.readByte() & 255);
            Logger logger = b.n;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.frameLog(true, this.m, this.k, readByte, this.l));
            }
            int readInt = this.j.readInt() & Integer.MAX_VALUE;
            this.m = readInt;
            if (readByte != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (readInt != i) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public void close() {
        }

        public long read(Buffer buffer, long j2) {
            while (true) {
                int i = this.n;
                if (i == 0) {
                    this.j.skip((long) this.o);
                    this.o = 0;
                    if ((this.l & 4) != 0) {
                        return -1;
                    }
                    c();
                } else {
                    long read = this.j.read(buffer, Math.min(j2, (long) i));
                    if (read == -1) {
                        return -1;
                    }
                    this.n = (int) (((long) this.n) - read);
                    return read;
                }
            }
        }

        public Timeout timeout() {
            return this.j.timeout();
        }
    }

    /* renamed from: org.cocos2dx.okhttp3.internal.http2.b$b  reason: collision with other inner class name */
    interface C0089b {
        void a(boolean z, int i, int i2, List<Header> list);

        void b();

        void c(int i, long j);

        void d(boolean z, Settings settings);

        void e(int i, int i2, List<Header> list);

        void f(int i, ErrorCode errorCode, ByteString byteString);

        void g(int i, ErrorCode errorCode);

        void h(boolean z, int i, int i2);

        void i(int i, int i2, int i3, boolean z);

        void j(boolean z, int i, BufferedSource bufferedSource, int i2);
    }

    b(BufferedSource bufferedSource, boolean z) {
        this.j = bufferedSource;
        this.l = z;
        a aVar = new a(bufferedSource);
        this.k = aVar;
        this.m = new a.C0088a(4096, aVar);
    }

    static int c(int i, byte b2, short s) {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    private void i(C0089b bVar, int i, byte b2, int i2) {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b2 & 1) != 0;
            if ((b2 & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b2 & 8) != 0) {
                    s = (short) (this.j.readByte() & 255);
                }
                bVar.j(z2, i2, this.j, c(i, b2, s));
                this.j.skip((long) s);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void n(C0089b bVar, int i, byte b2, int i2) {
        if (i < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int readInt = this.j.readInt();
            int readInt2 = this.j.readInt();
            int i3 = i - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i3 > 0) {
                    byteString = this.j.readByteString((long) i3);
                }
                bVar.f(readInt, fromHttp2, byteString);
                return;
            }
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        } else {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private List<Header> o(int i, short s, byte b2, int i2) {
        a aVar = this.k;
        aVar.n = i;
        aVar.k = i;
        aVar.o = s;
        aVar.l = b2;
        aVar.m = i2;
        this.m.k();
        return this.m.e();
    }

    private void p(C0089b bVar, int i, byte b2, int i2) {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b2 & 1) != 0;
            if ((b2 & 8) != 0) {
                s = (short) (this.j.readByte() & 255);
            }
            if ((b2 & 32) != 0) {
                s(bVar, i2);
                i -= 5;
            }
            bVar.a(z, i2, -1, o(c(i, b2, s), s, b2, i2));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    static int q(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private void r(C0089b bVar, int i, byte b2, int i2) {
        boolean z = false;
        if (i != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int readInt = this.j.readInt();
            int readInt2 = this.j.readInt();
            if ((b2 & 1) != 0) {
                z = true;
            }
            bVar.h(z, readInt, readInt2);
        } else {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void s(C0089b bVar, int i) {
        int readInt = this.j.readInt();
        bVar.i(i, readInt & Integer.MAX_VALUE, (this.j.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void t(C0089b bVar, int i, byte b2, int i2) {
        if (i != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 != 0) {
            s(bVar, i2);
        } else {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void u(C0089b bVar, int i, byte b2, int i2) {
        short s = 0;
        if (i2 != 0) {
            if ((b2 & 8) != 0) {
                s = (short) (this.j.readByte() & 255);
            }
            bVar.e(i2, this.j.readInt() & Integer.MAX_VALUE, o(c(i - 4, b2, s), s, b2, i2));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void v(C0089b bVar, int i, byte b2, int i2) {
        if (i != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 != 0) {
            int readInt = this.j.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 != null) {
                bVar.g(i2, fromHttp2);
            } else {
                throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            }
        } else {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void w(C0089b bVar, int i, byte b2, int i2) {
        if (i2 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b2 & 1) != 0) {
            if (i == 0) {
                bVar.b();
                return;
            }
            throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i % 6 == 0) {
            Settings settings = new Settings();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short readShort = this.j.readShort() & 65535;
                int readInt = this.j.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                settings.set(readShort, readInt);
            }
            bVar.d(false, settings);
        } else {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
    }

    private void x(C0089b bVar, int i, byte b2, int i2) {
        if (i == 4) {
            long readInt = ((long) this.j.readInt()) & 2147483647L;
            if (readInt != 0) {
                bVar.c(i2, readInt);
            } else {
                throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(readInt));
            }
        } else {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
    }

    public void close() {
        this.j.close();
    }

    public boolean f(boolean z, C0089b bVar) {
        try {
            this.j.require(9);
            int q = q(this.j);
            if (q < 0 || q > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(q));
            }
            byte readByte = (byte) (this.j.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.j.readByte() & 255);
                int readInt = this.j.readInt() & Integer.MAX_VALUE;
                Logger logger = n;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Http2.frameLog(true, readInt, q, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        i(bVar, q, readByte2, readInt);
                        break;
                    case 1:
                        p(bVar, q, readByte2, readInt);
                        break;
                    case 2:
                        t(bVar, q, readByte2, readInt);
                        break;
                    case 3:
                        v(bVar, q, readByte2, readInt);
                        break;
                    case 4:
                        w(bVar, q, readByte2, readInt);
                        break;
                    case 5:
                        u(bVar, q, readByte2, readInt);
                        break;
                    case 6:
                        r(bVar, q, readByte2, readInt);
                        break;
                    case 7:
                        n(bVar, q, readByte2, readInt);
                        break;
                    case 8:
                        x(bVar, q, readByte2, readInt);
                        break;
                    default:
                        this.j.skip((long) q);
                        break;
                }
                return true;
            }
            throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException unused) {
            return false;
        }
    }

    public void h(C0089b bVar) {
        if (!this.l) {
            BufferedSource bufferedSource = this.j;
            ByteString byteString = Http2.CONNECTION_PREFACE;
            ByteString readByteString = bufferedSource.readByteString((long) byteString.size());
            Logger logger = n;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format("<< CONNECTION %s", readByteString.hex()));
            }
            if (!byteString.equals(readByteString)) {
                throw Http2.ioException("Expected a connection header but was %s", readByteString.utf8());
            }
        } else if (!f(true, bVar)) {
            throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
        }
    }
}
