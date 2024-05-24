package org.cocos2dx.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

final class b implements BufferedSink {
    public final Buffer j = new Buffer();
    public final Sink k;
    boolean l;

    class a extends OutputStream {
        a() {
        }

        public void close() {
            b.this.close();
        }

        public void flush() {
            b bVar = b.this;
            if (!bVar.l) {
                bVar.flush();
            }
        }

        public String toString() {
            return b.this + ".outputStream()";
        }

        public void write(int i) {
            b bVar = b.this;
            if (!bVar.l) {
                bVar.j.writeByte((int) (byte) i);
                b.this.emitCompleteSegments();
                return;
            }
            throw new IOException("closed");
        }

        public void write(byte[] bArr, int i, int i2) {
            b bVar = b.this;
            if (!bVar.l) {
                bVar.j.write(bArr, i, i2);
                b.this.emitCompleteSegments();
                return;
            }
            throw new IOException("closed");
        }
    }

    b(Sink sink) {
        Objects.requireNonNull(sink, "sink == null");
        this.k = sink;
    }

    public Buffer buffer() {
        return this.j;
    }

    public void close() {
        if (!this.l) {
            try {
                Buffer buffer = this.j;
                long j2 = buffer.size;
                if (j2 > 0) {
                    this.k.write(buffer, j2);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.k.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.l = true;
            if (th != null) {
                g.f(th);
                throw null;
            }
        }
    }

    public BufferedSink emit() {
        if (!this.l) {
            long size = this.j.size();
            if (size > 0) {
                this.k.write(this.j, size);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink emitCompleteSegments() {
        if (!this.l) {
            long completeSegmentByteCount = this.j.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.k.write(this.j, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() {
        if (!this.l) {
            Buffer buffer = this.j;
            long j2 = buffer.size;
            if (j2 > 0) {
                this.k.write(buffer, j2);
            }
            this.k.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.l;
    }

    public OutputStream outputStream() {
        return new a();
    }

    public Timeout timeout() {
        return this.k.timeout();
    }

    public String toString() {
        return "buffer(" + this.k + ")";
    }

    public int write(ByteBuffer byteBuffer) {
        if (!this.l) {
            int write = this.j.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(ByteString byteString) {
        if (!this.l) {
            this.j.write(byteString);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(Source source, long j2) {
        while (j2 > 0) {
            long read = source.read(this.j, j2);
            if (read != -1) {
                j2 -= read;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public BufferedSink write(byte[] bArr) {
        if (!this.l) {
            this.j.write(bArr);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(byte[] bArr, int i, int i2) {
        if (!this.l) {
            this.j.write(bArr, i, i2);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void write(Buffer buffer, long j2) {
        if (!this.l) {
            this.j.write(buffer, j2);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public long writeAll(Source source) {
        if (source != null) {
            long j2 = 0;
            while (true) {
                long read = source.read(this.j, 8192);
                if (read == -1) {
                    return j2;
                }
                j2 += read;
                emitCompleteSegments();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public BufferedSink writeByte(int i) {
        if (!this.l) {
            this.j.writeByte(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeDecimalLong(long j2) {
        if (!this.l) {
            this.j.writeDecimalLong(j2);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeHexadecimalUnsignedLong(long j2) {
        if (!this.l) {
            this.j.writeHexadecimalUnsignedLong(j2);
            return emitCompleteSegments();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeInt(int i) {
        if (!this.l) {
            this.j.writeInt(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeIntLe(int i) {
        if (!this.l) {
            this.j.writeIntLe(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeLong(long j2) {
        if (!this.l) {
            this.j.writeLong(j2);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeLongLe(long j2) {
        if (!this.l) {
            this.j.writeLongLe(j2);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeShort(int i) {
        if (!this.l) {
            this.j.writeShort(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeShortLe(int i) {
        if (!this.l) {
            this.j.writeShortLe(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeString(String str, int i, int i2, Charset charset) {
        if (!this.l) {
            this.j.writeString(str, i, i2, charset);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeString(String str, Charset charset) {
        if (!this.l) {
            this.j.writeString(str, charset);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeUtf8(String str) {
        if (!this.l) {
            this.j.writeUtf8(str);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeUtf8(String str, int i, int i2) {
        if (!this.l) {
            this.j.writeUtf8(str, i, i2);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeUtf8CodePoint(int i) {
        if (!this.l) {
            this.j.writeUtf8CodePoint(i);
            emitCompleteSegments();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
