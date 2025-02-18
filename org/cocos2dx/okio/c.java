package org.cocos2dx.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;

final class c implements BufferedSource {
    public final Buffer j = new Buffer();
    public final Source k;
    boolean l;

    class a extends InputStream {
        a() {
        }

        public int available() {
            c cVar = c.this;
            if (!cVar.l) {
                return (int) Math.min(cVar.j.size, 2147483647L);
            }
            throw new IOException("closed");
        }

        public void close() {
            c.this.close();
        }

        public int read() {
            c cVar = c.this;
            if (!cVar.l) {
                Buffer buffer = cVar.j;
                if (buffer.size == 0 && cVar.k.read(buffer, 8192) == -1) {
                    return -1;
                }
                return c.this.j.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public int read(byte[] bArr, int i, int i2) {
            if (!c.this.l) {
                g.b((long) bArr.length, (long) i, (long) i2);
                c cVar = c.this;
                Buffer buffer = cVar.j;
                if (buffer.size == 0 && cVar.k.read(buffer, 8192) == -1) {
                    return -1;
                }
                return c.this.j.read(bArr, i, i2);
            }
            throw new IOException("closed");
        }

        public String toString() {
            return c.this + ".inputStream()";
        }
    }

    c(Source source) {
        Objects.requireNonNull(source, "source == null");
        this.k = source;
    }

    public Buffer buffer() {
        return this.j;
    }

    public void close() {
        if (!this.l) {
            this.l = true;
            this.k.close();
            this.j.clear();
        }
    }

    public boolean exhausted() {
        if (!this.l) {
            return this.j.exhausted() && this.k.read(this.j, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public long indexOf(byte b2) {
        return indexOf(b2, 0, Long.MAX_VALUE);
    }

    public long indexOf(byte b2, long j2) {
        return indexOf(b2, j2, Long.MAX_VALUE);
    }

    public long indexOf(byte b2, long j2, long j3) {
        if (this.l) {
            throw new IllegalStateException("closed");
        } else if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j2), Long.valueOf(j3)}));
        } else {
            while (j2 < j3) {
                long indexOf = this.j.indexOf(b2, j2, j3);
                if (indexOf == -1) {
                    Buffer buffer = this.j;
                    long j4 = buffer.size;
                    if (j4 >= j3 || this.k.read(buffer, 8192) == -1) {
                        break;
                    }
                    j2 = Math.max(j2, j4);
                } else {
                    return indexOf;
                }
            }
            return -1;
        }
    }

    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j2) {
        if (!this.l) {
            while (true) {
                long indexOf = this.j.indexOf(byteString, j2);
                if (indexOf != -1) {
                    return indexOf;
                }
                Buffer buffer = this.j;
                long j3 = buffer.size;
                if (this.k.read(buffer, 8192) == -1) {
                    return -1;
                }
                j2 = Math.max(j2, (j3 - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public long indexOfElement(ByteString byteString, long j2) {
        if (!this.l) {
            while (true) {
                long indexOfElement = this.j.indexOfElement(byteString, j2);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                Buffer buffer = this.j;
                long j3 = buffer.size;
                if (this.k.read(buffer, 8192) == -1) {
                    return -1;
                }
                j2 = Math.max(j2, j3);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public InputStream inputStream() {
        return new a();
    }

    public boolean isOpen() {
        return !this.l;
    }

    public boolean rangeEquals(long j2, ByteString byteString) {
        return rangeEquals(j2, byteString, 0, byteString.size());
    }

    public boolean rangeEquals(long j2, ByteString byteString, int i, int i2) {
        if (this.l) {
            throw new IllegalStateException("closed");
        } else if (j2 < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                long j3 = ((long) i3) + j2;
                if (!request(1 + j3) || this.j.getByte(j3) != byteString.getByte(i + i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    public int read(ByteBuffer byteBuffer) {
        Buffer buffer = this.j;
        if (buffer.size == 0 && this.k.read(buffer, 8192) == -1) {
            return -1;
        }
        return this.j.read(byteBuffer);
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        long j2 = (long) i2;
        g.b((long) bArr.length, (long) i, j2);
        Buffer buffer = this.j;
        if (buffer.size == 0 && this.k.read(buffer, 8192) == -1) {
            return -1;
        }
        return this.j.read(bArr, i, (int) Math.min(j2, this.j.size));
    }

    public long read(Buffer buffer, long j2) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (!this.l) {
            Buffer buffer2 = this.j;
            if (buffer2.size == 0 && this.k.read(buffer2, 8192) == -1) {
                return -1;
            }
            return this.j.read(buffer, Math.min(j2, this.j.size));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public long readAll(Sink sink) {
        Buffer buffer;
        if (sink != null) {
            long j2 = 0;
            while (true) {
                int i = (this.k.read(this.j, 8192) > -1 ? 1 : (this.k.read(this.j, 8192) == -1 ? 0 : -1));
                buffer = this.j;
                if (i == 0) {
                    break;
                }
                long completeSegmentByteCount = buffer.completeSegmentByteCount();
                if (completeSegmentByteCount > 0) {
                    j2 += completeSegmentByteCount;
                    sink.write(this.j, completeSegmentByteCount);
                }
            }
            if (buffer.size() <= 0) {
                return j2;
            }
            long size = j2 + this.j.size();
            Buffer buffer2 = this.j;
            sink.write(buffer2, buffer2.size());
            return size;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public byte readByte() {
        require(1);
        return this.j.readByte();
    }

    public byte[] readByteArray() {
        this.j.writeAll(this.k);
        return this.j.readByteArray();
    }

    public byte[] readByteArray(long j2) {
        require(j2);
        return this.j.readByteArray(j2);
    }

    public ByteString readByteString() {
        this.j.writeAll(this.k);
        return this.j.readByteString();
    }

    public ByteString readByteString(long j2) {
        require(j2);
        return this.j.readByteString(j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r6 = this;
            r0 = 1
            r6.require(r0)
            r0 = 0
            r1 = 0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.request(r3)
            if (r3 == 0) goto L_0x0040
            org.cocos2dx.okio.Buffer r3 = r6.j
            long r4 = (long) r1
            byte r3 = r3.getByte(r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0026
        L_0x001f:
            if (r1 != 0) goto L_0x0028
            r4 = 45
            if (r3 == r4) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r2
            goto L_0x0007
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x0040:
            org.cocos2dx.okio.Buffer r0 = r6.j
            long r0 = r0.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okio.c.readDecimalLong():long");
    }

    public void readFully(Buffer buffer, long j2) {
        try {
            require(j2);
            this.j.readFully(buffer, j2);
        } catch (EOFException e2) {
            buffer.writeAll(this.j);
            throw e2;
        }
    }

    public void readFully(byte[] bArr) {
        try {
            require((long) bArr.length);
            this.j.readFully(bArr);
        } catch (EOFException e2) {
            int i = 0;
            while (true) {
                Buffer buffer = this.j;
                long j2 = buffer.size;
                if (j2 > 0) {
                    int read = buffer.read(bArr, i, (int) j2);
                    if (read != -1) {
                        i += read;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e2;
                }
            }
        }
    }

    public long readHexadecimalUnsignedLong() {
        require(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request((long) i2)) {
                break;
            }
            byte b2 = this.j.getByte((long) i);
            if ((b2 >= 48 && b2 <= 57) || ((b2 >= 97 && b2 <= 102) || (b2 >= 65 && b2 <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b2)}));
            }
        }
        return this.j.readHexadecimalUnsignedLong();
    }

    public int readInt() {
        require(4);
        return this.j.readInt();
    }

    public int readIntLe() {
        require(4);
        return this.j.readIntLe();
    }

    public long readLong() {
        require(8);
        return this.j.readLong();
    }

    public long readLongLe() {
        require(8);
        return this.j.readLongLe();
    }

    public short readShort() {
        require(2);
        return this.j.readShort();
    }

    public short readShortLe() {
        require(2);
        return this.j.readShortLe();
    }

    public String readString(long j2, Charset charset) {
        require(j2);
        if (charset != null) {
            return this.j.readString(j2, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String readString(Charset charset) {
        if (charset != null) {
            this.j.writeAll(this.k);
            return this.j.readString(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String readUtf8() {
        this.j.writeAll(this.k);
        return this.j.readUtf8();
    }

    public String readUtf8(long j2) {
        require(j2);
        return this.j.readUtf8(j2);
    }

    public int readUtf8CodePoint() {
        long j2;
        require(1);
        byte b2 = this.j.getByte(0);
        if ((b2 & 224) == 192) {
            j2 = 2;
        } else if ((b2 & 240) == 224) {
            j2 = 3;
        } else {
            if ((b2 & 248) == 240) {
                j2 = 4;
            }
            return this.j.readUtf8CodePoint();
        }
        require(j2);
        return this.j.readUtf8CodePoint();
    }

    @Nullable
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.j.readUtf8Line(indexOf);
        }
        long j2 = this.j.size;
        if (j2 != 0) {
            return readUtf8(j2);
        }
        return null;
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public String readUtf8LineStrict(long j2) {
        if (j2 >= 0) {
            long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
            long indexOf = indexOf((byte) 10, 0, j3);
            if (indexOf != -1) {
                return this.j.readUtf8Line(indexOf);
            }
            if (j3 < Long.MAX_VALUE && request(j3) && this.j.getByte(j3 - 1) == 13 && request(1 + j3) && this.j.getByte(j3) == 10) {
                return this.j.readUtf8Line(j3);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.j;
            buffer2.copyTo(buffer, 0, Math.min(32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.j.size(), j2) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j2);
    }

    public boolean request(long j2) {
        Buffer buffer;
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (!this.l) {
            do {
                buffer = this.j;
                if (buffer.size >= j2) {
                    return true;
                }
            } while (this.k.read(buffer, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void require(long j2) {
        if (!request(j2)) {
            throw new EOFException();
        }
    }

    public int select(Options options) {
        if (!this.l) {
            do {
                int selectPrefix = this.j.selectPrefix(options, true);
                if (selectPrefix == -1) {
                    return -1;
                }
                if (selectPrefix != -2) {
                    this.j.skip((long) options.byteStrings[selectPrefix].size());
                    return selectPrefix;
                }
            } while (this.k.read(this.j, 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    public void skip(long j2) {
        if (!this.l) {
            while (j2 > 0) {
                Buffer buffer = this.j;
                if (buffer.size == 0 && this.k.read(buffer, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j2, this.j.size());
                this.j.skip(min);
                j2 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public Timeout timeout() {
        return this.k.timeout();
    }

    public String toString() {
        return "buffer(" + this.k + ")";
    }
}
