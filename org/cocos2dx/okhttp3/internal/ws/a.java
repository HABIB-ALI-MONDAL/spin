package org.cocos2dx.okhttp3.internal.ws;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.Sink;
import org.cocos2dx.okio.Timeout;

final class a {

    /* renamed from: a  reason: collision with root package name */
    final boolean f3252a;

    /* renamed from: b  reason: collision with root package name */
    final Random f3253b;

    /* renamed from: c  reason: collision with root package name */
    final BufferedSink f3254c;

    /* renamed from: d  reason: collision with root package name */
    final Buffer f3255d;

    /* renamed from: e  reason: collision with root package name */
    boolean f3256e;

    /* renamed from: f  reason: collision with root package name */
    final Buffer f3257f = new Buffer();
    final C0091a g = new C0091a();
    boolean h;
    private final byte[] i;
    private final Buffer.UnsafeCursor j;

    /* renamed from: org.cocos2dx.okhttp3.internal.ws.a$a  reason: collision with other inner class name */
    final class C0091a implements Sink {
        int j;
        long k;
        boolean l;
        boolean m;

        C0091a() {
        }

        public void close() {
            if (!this.m) {
                a aVar = a.this;
                aVar.d(this.j, aVar.f3257f.size(), this.l, true);
                this.m = true;
                a.this.h = false;
                return;
            }
            throw new IOException("closed");
        }

        public void flush() {
            if (!this.m) {
                a aVar = a.this;
                aVar.d(this.j, aVar.f3257f.size(), this.l, false);
                this.l = false;
                return;
            }
            throw new IOException("closed");
        }

        public Timeout timeout() {
            return a.this.f3254c.timeout();
        }

        public void write(Buffer buffer, long j2) {
            if (!this.m) {
                a.this.f3257f.write(buffer, j2);
                boolean z = this.l && this.k != -1 && a.this.f3257f.size() > this.k - 8192;
                long completeSegmentByteCount = a.this.f3257f.completeSegmentByteCount();
                if (completeSegmentByteCount > 0 && !z) {
                    a.this.d(this.j, completeSegmentByteCount, this.l, false);
                    this.l = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }
    }

    a(boolean z, BufferedSink bufferedSink, Random random) {
        Objects.requireNonNull(bufferedSink, "sink == null");
        Objects.requireNonNull(random, "random == null");
        this.f3252a = z;
        this.f3254c = bufferedSink;
        this.f3255d = bufferedSink.buffer();
        this.f3253b = random;
        Buffer.UnsafeCursor unsafeCursor = null;
        this.i = z ? new byte[4] : null;
        this.j = z ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    private void c(int i2, ByteString byteString) {
        if (!this.f3256e) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                this.f3255d.writeByte(i2 | 128);
                if (this.f3252a) {
                    this.f3255d.writeByte(size | 128);
                    this.f3253b.nextBytes(this.i);
                    this.f3255d.write(this.i);
                    if (size > 0) {
                        long size2 = this.f3255d.size();
                        this.f3255d.write(byteString);
                        this.f3255d.readAndWriteUnsafe(this.j);
                        this.j.seek(size2);
                        WebSocketProtocol.toggleMask(this.j, this.i);
                        this.j.close();
                    }
                } else {
                    this.f3255d.writeByte(size);
                    this.f3255d.write(byteString);
                }
                this.f3254c.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    public Sink a(int i2, long j2) {
        if (!this.h) {
            this.h = true;
            C0091a aVar = this.g;
            aVar.j = i2;
            aVar.k = j2;
            aVar.l = true;
            aVar.m = false;
            return aVar;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, ByteString byteString) {
        ByteString byteString2 = ByteString.EMPTY;
        if (!(i2 == 0 && byteString == null)) {
            if (i2 != 0) {
                WebSocketProtocol.validateCloseCode(i2);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i2);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            c(8, byteString2);
        } finally {
            this.f3256e = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, long j2, boolean z, boolean z2) {
        if (!this.f3256e) {
            int i3 = 0;
            if (!z) {
                i2 = 0;
            }
            if (z2) {
                i2 |= 128;
            }
            this.f3255d.writeByte(i2);
            if (this.f3252a) {
                i3 = 128;
            }
            if (j2 <= 125) {
                this.f3255d.writeByte(((int) j2) | i3);
            } else if (j2 <= 65535) {
                this.f3255d.writeByte(i3 | 126);
                this.f3255d.writeShort((int) j2);
            } else {
                this.f3255d.writeByte(i3 | 127);
                this.f3255d.writeLong(j2);
            }
            if (this.f3252a) {
                this.f3253b.nextBytes(this.i);
                this.f3255d.write(this.i);
                if (j2 > 0) {
                    long size = this.f3255d.size();
                    this.f3255d.write(this.f3257f, j2);
                    this.f3255d.readAndWriteUnsafe(this.j);
                    this.j.seek(size);
                    WebSocketProtocol.toggleMask(this.j, this.i);
                    this.j.close();
                }
            } else {
                this.f3255d.write(this.f3257f, j2);
            }
            this.f3254c.emit();
            return;
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    public void e(ByteString byteString) {
        c(9, byteString);
    }

    /* access modifiers changed from: package-private */
    public void f(ByteString byteString) {
        c(10, byteString);
    }
}
