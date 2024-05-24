package org.cocos2dx.okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;

final class WebSocketReader {

    /* renamed from: a  reason: collision with root package name */
    final boolean f3246a;

    /* renamed from: b  reason: collision with root package name */
    final BufferedSource f3247b;

    /* renamed from: c  reason: collision with root package name */
    final FrameCallback f3248c;

    /* renamed from: d  reason: collision with root package name */
    boolean f3249d;

    /* renamed from: e  reason: collision with root package name */
    int f3250e;

    /* renamed from: f  reason: collision with root package name */
    long f3251f;
    boolean g;
    boolean h;
    private final Buffer i = new Buffer();
    private final Buffer j = new Buffer();
    private final byte[] k;
    private final Buffer.UnsafeCursor l;

    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str);

        void onReadMessage(ByteString byteString);

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        Objects.requireNonNull(bufferedSource, "source == null");
        Objects.requireNonNull(frameCallback, "frameCallback == null");
        this.f3246a = z;
        this.f3247b = bufferedSource;
        this.f3248c = frameCallback;
        Buffer.UnsafeCursor unsafeCursor = null;
        this.k = z ? null : new byte[4];
        this.l = !z ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    private void b() {
        String str;
        long j2 = this.f3251f;
        if (j2 > 0) {
            this.f3247b.readFully(this.i, j2);
            if (!this.f3246a) {
                this.i.readAndWriteUnsafe(this.l);
                this.l.seek(0);
                WebSocketProtocol.toggleMask(this.l, this.k);
                this.l.close();
            }
        }
        switch (this.f3250e) {
            case 8:
                short s = 1005;
                long size = this.i.size();
                if (size != 1) {
                    if (size != 0) {
                        s = this.i.readShort();
                        str = this.i.readUtf8();
                        String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        str = "";
                    }
                    this.f3248c.onReadClose(s, str);
                    this.f3249d = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.f3248c.onReadPing(this.i.readByteString());
                return;
            case 10:
                this.f3248c.onReadPong(this.i.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f3250e));
        }
    }

    /* JADX INFO: finally extract failed */
    private void c() {
        if (!this.f3249d) {
            long timeoutNanos = this.f3247b.timeout().timeoutNanos();
            this.f3247b.timeout().clearTimeout();
            try {
                byte readByte = this.f3247b.readByte() & 255;
                this.f3247b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.f3250e = readByte & 15;
                boolean z = true;
                boolean z2 = (readByte & 128) != 0;
                this.g = z2;
                boolean z3 = (readByte & 8) != 0;
                this.h = z3;
                if (!z3 || z2) {
                    boolean z4 = (readByte & 64) != 0;
                    boolean z5 = (readByte & 32) != 0;
                    boolean z6 = (readByte & 16) != 0;
                    if (z4 || z5 || z6) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte readByte2 = this.f3247b.readByte() & 255;
                    if ((readByte2 & 128) == 0) {
                        z = false;
                    }
                    if (z == this.f3246a) {
                        throw new ProtocolException(this.f3246a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    long j2 = (long) (readByte2 & Byte.MAX_VALUE);
                    this.f3251f = j2;
                    if (j2 == 126) {
                        this.f3251f = ((long) this.f3247b.readShort()) & 65535;
                    } else if (j2 == 127) {
                        long readLong = this.f3247b.readLong();
                        this.f3251f = readLong;
                        if (readLong < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f3251f) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    if (this.h && this.f3251f > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (z) {
                        this.f3247b.readFully(this.k);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.f3247b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    private void d() {
        while (!this.f3249d) {
            long j2 = this.f3251f;
            if (j2 > 0) {
                this.f3247b.readFully(this.j, j2);
                if (!this.f3246a) {
                    this.j.readAndWriteUnsafe(this.l);
                    this.l.seek(this.j.size() - this.f3251f);
                    WebSocketProtocol.toggleMask(this.l, this.k);
                    this.l.close();
                }
            }
            if (!this.g) {
                f();
                if (this.f3250e != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f3250e));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }

    private void e() {
        int i2 = this.f3250e;
        if (i2 == 1 || i2 == 2) {
            d();
            if (i2 == 1) {
                this.f3248c.onReadMessage(this.j.readUtf8());
            } else {
                this.f3248c.onReadMessage(this.j.readByteString());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i2));
        }
    }

    private void f() {
        while (!this.f3249d) {
            c();
            if (this.h) {
                b();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        c();
        if (this.h) {
            b();
        } else {
            e();
        }
    }
}
