package org.cocos2dx.okio;

import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    @Nullable
    d head;
    long size;

    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        private d segment;
        public int start = -1;

        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public final long expandBuffer(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i);
            } else if (i <= 8192) {
                Buffer buffer2 = this.buffer;
                if (buffer2 == null) {
                    throw new IllegalStateException("not attached to a buffer");
                } else if (this.readWrite) {
                    long j = buffer2.size;
                    d writableSegment = buffer2.writableSegment(i);
                    int i2 = 8192 - writableSegment.f3263c;
                    writableSegment.f3263c = 8192;
                    long j2 = (long) i2;
                    this.buffer.size = j + j2;
                    this.segment = writableSegment;
                    this.offset = j;
                    this.data = writableSegment.f3261a;
                    this.start = 8192 - i2;
                    this.end = 8192;
                    return j2;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
            } else {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i);
            }
        }

        public final int next() {
            long j = this.offset;
            if (j != this.buffer.size) {
                return seek(j == -1 ? 0 : j + ((long) (this.end - this.start)));
            }
            throw new IllegalStateException();
        }

        public final long resizeBuffer(long j) {
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer");
            } else if (this.readWrite) {
                long j2 = buffer2.size;
                if (j <= j2) {
                    if (j >= 0) {
                        long j3 = j2 - j;
                        while (true) {
                            if (j3 <= 0) {
                                break;
                            }
                            Buffer buffer3 = this.buffer;
                            d dVar = buffer3.head.g;
                            int i = dVar.f3263c;
                            long j4 = (long) (i - dVar.f3262b);
                            if (j4 > j3) {
                                dVar.f3263c = (int) (((long) i) - j3);
                                break;
                            }
                            buffer3.head = dVar.b();
                            e.a(dVar);
                            j3 -= j4;
                        }
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException("newSize < 0: " + j);
                    }
                } else if (j > j2) {
                    long j5 = j - j2;
                    boolean z = true;
                    while (j5 > 0) {
                        d writableSegment = this.buffer.writableSegment(1);
                        int min = (int) Math.min(j5, (long) (8192 - writableSegment.f3263c));
                        int i2 = writableSegment.f3263c + min;
                        writableSegment.f3263c = i2;
                        j5 -= (long) min;
                        if (z) {
                            this.segment = writableSegment;
                            this.offset = j2;
                            this.data = writableSegment.f3261a;
                            this.start = i2 - min;
                            this.end = i2;
                            z = false;
                        }
                    }
                }
                this.buffer.size = j;
                return j2;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
        }

        public final int seek(long j) {
            if (j >= -1) {
                Buffer buffer2 = this.buffer;
                long j2 = buffer2.size;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    long j3 = 0;
                    d dVar = buffer2.head;
                    d dVar2 = this.segment;
                    if (dVar2 != null) {
                        long j4 = this.offset - ((long) (this.start - dVar2.f3262b));
                        if (j4 > j) {
                            j2 = j4;
                            d dVar3 = dVar2;
                            dVar2 = dVar;
                            dVar = dVar3;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        dVar2 = dVar;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            int i = dVar2.f3263c;
                            int i2 = dVar2.f3262b;
                            if (j < ((long) (i - i2)) + j3) {
                                break;
                            }
                            j3 += (long) (i - i2);
                            dVar2 = dVar2.f3266f;
                        }
                    } else {
                        while (j2 > j) {
                            dVar = dVar.g;
                            j2 -= (long) (dVar.f3263c - dVar.f3262b);
                        }
                        dVar2 = dVar;
                        j3 = j2;
                    }
                    if (this.readWrite && dVar2.f3264d) {
                        d f2 = dVar2.f();
                        Buffer buffer3 = this.buffer;
                        if (buffer3.head == dVar2) {
                            buffer3.head = f2;
                        }
                        dVar2.c(f2);
                        f2.g.b();
                        dVar2 = f2;
                    }
                    this.segment = dVar2;
                    this.offset = j;
                    this.data = dVar2.f3261a;
                    int i3 = dVar2.f3262b + ((int) (j - j3));
                    this.start = i3;
                    int i4 = dVar2.f3263c;
                    this.end = i4;
                    return i4 - i3;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j), Long.valueOf(this.buffer.size)}));
        }
    }

    class a extends OutputStream {
        a() {
        }

        public void close() {
        }

        public void flush() {
        }

        public String toString() {
            return Buffer.this + ".outputStream()";
        }

        public void write(int i) {
            Buffer.this.writeByte((int) (byte) i);
        }

        public void write(byte[] bArr, int i, int i2) {
            Buffer.this.write(bArr, i, i2);
        }
    }

    class b extends InputStream {
        b() {
        }

        public int available() {
            return (int) Math.min(Buffer.this.size, 2147483647L);
        }

        public void close() {
        }

        public int read() {
            Buffer buffer = Buffer.this;
            if (buffer.size > 0) {
                return buffer.readByte() & 255;
            }
            return -1;
        }

        public int read(byte[] bArr, int i, int i2) {
            return Buffer.this.read(bArr, i, i2);
        }

        public String toString() {
            return Buffer.this + ".inputStream()";
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            d dVar = this.head;
            if (dVar != null) {
                byte[] bArr = dVar.f3261a;
                int i = dVar.f3262b;
                instance.update(bArr, i, dVar.f3263c - i);
                d dVar2 = this.head;
                while (true) {
                    dVar2 = dVar2.f3266f;
                    if (dVar2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = dVar2.f3261a;
                    int i2 = dVar2.f3262b;
                    instance.update(bArr2, i2, dVar2.f3263c - i2);
                }
            }
            return ByteString.of(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            d dVar = this.head;
            if (dVar != null) {
                byte[] bArr = dVar.f3261a;
                int i = dVar.f3262b;
                instance.update(bArr, i, dVar.f3263c - i);
                d dVar2 = this.head;
                while (true) {
                    dVar2 = dVar2.f3266f;
                    if (dVar2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = dVar2.f3261a;
                    int i2 = dVar2.f3262b;
                    instance.update(bArr2, i2, dVar2.f3263c - i2);
                }
            }
            return ByteString.of(instance.doFinal());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private boolean rangeEquals(d dVar, int i, ByteString byteString, int i2, int i3) {
        int i4 = dVar.f3263c;
        byte[] bArr = dVar.f3261a;
        while (i2 < i3) {
            if (i == i4) {
                dVar = dVar.f3266f;
                byte[] bArr2 = dVar.f3261a;
                int i5 = dVar.f3262b;
                bArr = bArr2;
                i = i5;
                i4 = dVar.f3263c;
            }
            if (bArr[i] != byteString.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    private void readFrom(InputStream inputStream, long j, boolean z) {
        if (inputStream != null) {
            while (true) {
                if (j > 0 || z) {
                    d writableSegment = writableSegment(1);
                    int read = inputStream.read(writableSegment.f3261a, writableSegment.f3263c, (int) Math.min(j, (long) (8192 - writableSegment.f3263c)));
                    if (read != -1) {
                        writableSegment.f3263c += read;
                        long j2 = (long) read;
                        this.size += j2;
                        j -= j2;
                    } else if (!z) {
                        throw new EOFException();
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("in == null");
        }
    }

    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        d d2 = this.head.d();
        buffer.head = d2;
        d2.g = d2;
        d2.f3266f = d2;
        d dVar = this.head;
        while (true) {
            dVar = dVar.f3266f;
            if (dVar != this.head) {
                buffer.head.g.c(dVar.d());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0;
        }
        d dVar = this.head.g;
        int i = dVar.f3263c;
        return (i >= 8192 || !dVar.f3265e) ? j : j - ((long) (i - dVar.f3262b));
    }

    public final Buffer copyTo(OutputStream outputStream) {
        return copyTo(outputStream, 0, this.size);
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) {
        if (outputStream != null) {
            g.b(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            d dVar = this.head;
            while (true) {
                int i = dVar.f3263c;
                int i2 = dVar.f3262b;
                if (j < ((long) (i - i2))) {
                    break;
                }
                j -= (long) (i - i2);
                dVar = dVar.f3266f;
            }
            while (j2 > 0) {
                int i3 = (int) (((long) dVar.f3262b) + j);
                int min = (int) Math.min((long) (dVar.f3263c - i3), j2);
                outputStream.write(dVar.f3261a, i3, min);
                j2 -= (long) min;
                dVar = dVar.f3266f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            g.b(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.size += j2;
            d dVar = this.head;
            while (true) {
                int i = dVar.f3263c;
                int i2 = dVar.f3262b;
                if (j < ((long) (i - i2))) {
                    break;
                }
                j -= (long) (i - i2);
                dVar = dVar.f3266f;
            }
            while (j2 > 0) {
                d d2 = dVar.d();
                int i3 = (int) (((long) d2.f3262b) + j);
                d2.f3262b = i3;
                d2.f3263c = Math.min(i3 + ((int) j2), d2.f3263c);
                d dVar2 = buffer.head;
                if (dVar2 == null) {
                    d2.g = d2;
                    d2.f3266f = d2;
                    buffer.head = d2;
                } else {
                    dVar2.g.c(d2);
                }
                j2 -= (long) (d2.f3263c - d2.f3262b);
                dVar = dVar.f3266f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public BufferedSink emit() {
        return this;
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j = this.size;
        if (j != buffer.size) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        d dVar = this.head;
        d dVar2 = buffer.head;
        int i = dVar.f3262b;
        int i2 = dVar2.f3262b;
        while (j2 < this.size) {
            long min = (long) Math.min(dVar.f3263c - i, dVar2.f3263c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (dVar.f3261a[i] != dVar2.f3261a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == dVar.f3263c) {
                dVar = dVar.f3266f;
                i = dVar.f3262b;
            }
            if (i2 == dVar2.f3263c) {
                dVar2 = dVar2.f3266f;
                i2 = dVar2.f3262b;
            }
            j2 += min;
        }
        return true;
    }

    public boolean exhausted() {
        return this.size == 0;
    }

    public void flush() {
    }

    public final byte getByte(long j) {
        int i;
        g.b(this.size, j, 1);
        long j2 = this.size;
        if (j2 - j > j) {
            d dVar = this.head;
            while (true) {
                int i2 = dVar.f3263c;
                int i3 = dVar.f3262b;
                long j3 = (long) (i2 - i3);
                if (j < j3) {
                    return dVar.f3261a[i3 + ((int) j)];
                }
                j -= j3;
                dVar = dVar.f3266f;
            }
        } else {
            long j4 = j - j2;
            d dVar2 = this.head;
            do {
                dVar2 = dVar2.g;
                int i4 = dVar2.f3263c;
                i = dVar2.f3262b;
                j4 += (long) (i4 - i);
            } while (j4 < 0);
            return dVar2.f3261a[i + ((int) j4)];
        }
    }

    public int hashCode() {
        d dVar = this.head;
        if (dVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = dVar.f3263c;
            for (int i3 = dVar.f3262b; i3 < i2; i3++) {
                i = (i * 31) + dVar.f3261a[i3];
            }
            dVar = dVar.f3266f;
        } while (dVar != this.head);
        return i;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    public long indexOf(byte b2) {
        return indexOf(b2, 0, Long.MAX_VALUE);
    }

    public long indexOf(byte b2, long j) {
        return indexOf(b2, j, Long.MAX_VALUE);
    }

    public long indexOf(byte b2, long j, long j2) {
        d dVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.size), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j4 = this.size;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (dVar = this.head) == null) {
            return -1;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                dVar = dVar.g;
                j4 -= (long) (dVar.f3263c - dVar.f3262b);
            }
        } else {
            while (true) {
                long j6 = ((long) (dVar.f3263c - dVar.f3262b)) + j3;
                if (j6 >= j) {
                    break;
                }
                dVar = dVar.f3266f;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = dVar.f3261a;
            int min = (int) Math.min((long) dVar.f3263c, (((long) dVar.f3262b) + j5) - j4);
            for (int i = (int) ((((long) dVar.f3262b) + j7) - j4); i < min; i++) {
                if (bArr[i] == b2) {
                    return ((long) (i - dVar.f3262b)) + j4;
                }
            }
            byte b3 = b2;
            j4 += (long) (dVar.f3263c - dVar.f3262b);
            dVar = dVar.f3266f;
            j7 = j4;
        }
        return -1;
    }

    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j) {
        byte[] bArr;
        if (byteString.size() != 0) {
            long j2 = 0;
            if (j >= 0) {
                d dVar = this.head;
                long j3 = -1;
                if (dVar == null) {
                    return -1;
                }
                long j4 = this.size;
                if (j4 - j < j) {
                    while (j4 > j) {
                        dVar = dVar.g;
                        j4 -= (long) (dVar.f3263c - dVar.f3262b);
                    }
                } else {
                    while (true) {
                        long j5 = ((long) (dVar.f3263c - dVar.f3262b)) + j2;
                        if (j5 >= j) {
                            break;
                        }
                        dVar = dVar.f3266f;
                        j2 = j5;
                    }
                    j4 = j2;
                }
                byte b2 = byteString.getByte(0);
                int size2 = byteString.size();
                long j6 = 1 + (this.size - ((long) size2));
                long j7 = j;
                d dVar2 = dVar;
                long j8 = j4;
                while (j8 < j6) {
                    byte[] bArr2 = dVar2.f3261a;
                    int min = (int) Math.min((long) dVar2.f3263c, (((long) dVar2.f3262b) + j6) - j8);
                    int i = (int) ((((long) dVar2.f3262b) + j7) - j8);
                    while (i < min) {
                        if (bArr2[i] == b2) {
                            bArr = bArr2;
                            if (rangeEquals(dVar2, i + 1, byteString, 1, size2)) {
                                return ((long) (i - dVar2.f3262b)) + j8;
                            }
                        } else {
                            bArr = bArr2;
                        }
                        i++;
                        bArr2 = bArr;
                    }
                    j8 += (long) (dVar2.f3263c - dVar2.f3262b);
                    dVar2 = dVar2.f3266f;
                    j7 = j8;
                    j3 = -1;
                }
                return j3;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public long indexOfElement(ByteString byteString, long j) {
        int i;
        long j2 = 0;
        if (j >= 0) {
            d dVar = this.head;
            if (dVar == null) {
                return -1;
            }
            long j3 = this.size;
            if (j3 - j < j) {
                while (j3 > j) {
                    dVar = dVar.g;
                    j3 -= (long) (dVar.f3263c - dVar.f3262b);
                }
            } else {
                while (true) {
                    long j4 = ((long) (dVar.f3263c - dVar.f3262b)) + j2;
                    if (j4 >= j) {
                        break;
                    }
                    dVar = dVar.f3266f;
                    j2 = j4;
                }
                j3 = j2;
            }
            if (byteString.size() == 2) {
                byte b2 = byteString.getByte(0);
                byte b3 = byteString.getByte(1);
                while (j3 < this.size) {
                    byte[] bArr = dVar.f3261a;
                    i = (int) ((((long) dVar.f3262b) + j) - j3);
                    int i2 = dVar.f3263c;
                    while (i < i2) {
                        byte b4 = bArr[i];
                        if (!(b4 == b2 || b4 == b3)) {
                            i++;
                        }
                    }
                    j3 += (long) (dVar.f3263c - dVar.f3262b);
                    dVar = dVar.f3266f;
                    j = j3;
                }
                return -1;
            }
            byte[] internalArray = byteString.internalArray();
            while (j3 < this.size) {
                byte[] bArr2 = dVar.f3261a;
                int i3 = (int) ((((long) dVar.f3262b) + j) - j3);
                int i4 = dVar.f3263c;
                while (i < i4) {
                    byte b5 = bArr2[i];
                    int length = internalArray.length;
                    int i5 = 0;
                    while (i5 < length) {
                        if (b5 != internalArray[i5]) {
                            i5++;
                        }
                    }
                    i3 = i + 1;
                }
                j3 += (long) (dVar.f3263c - dVar.f3262b);
                dVar = dVar.f3266f;
                j = j3;
            }
            return -1;
            return ((long) (i - dVar.f3262b)) + j3;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public InputStream inputStream() {
        return new b();
    }

    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    public OutputStream outputStream() {
        return new a();
    }

    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    public boolean rangeEquals(long j, ByteString byteString, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.size - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public int read(ByteBuffer byteBuffer) {
        d dVar = this.head;
        if (dVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), dVar.f3263c - dVar.f3262b);
        byteBuffer.put(dVar.f3261a, dVar.f3262b, min);
        int i = dVar.f3262b + min;
        dVar.f3262b = i;
        this.size -= (long) min;
        if (i == dVar.f3263c) {
            this.head = dVar.b();
            e.a(dVar);
        }
        return min;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        g.b((long) bArr.length, (long) i, (long) i2);
        d dVar = this.head;
        if (dVar == null) {
            return -1;
        }
        int min = Math.min(i2, dVar.f3263c - dVar.f3262b);
        System.arraycopy(dVar.f3261a, dVar.f3262b, bArr, i, min);
        int i3 = dVar.f3262b + min;
        dVar.f3262b = i3;
        this.size -= (long) min;
        if (i3 == dVar.f3263c) {
            this.head = dVar.b();
            e.a(dVar);
        }
        return min;
    }

    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.size;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    public long readAll(Sink sink) {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public byte readByte() {
        long j = this.size;
        if (j != 0) {
            d dVar = this.head;
            int i = dVar.f3262b;
            int i2 = dVar.f3263c;
            int i3 = i + 1;
            byte b2 = dVar.f3261a[i];
            this.size = j - 1;
            if (i3 == i2) {
                this.head = dVar.b();
                e.a(dVar);
            } else {
                dVar.f3262b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public byte[] readByteArray(long j) {
        g.b(this.size, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    public ByteString readByteString(long j) {
        return new ByteString(readByteArray(j));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c1, code lost:
        if (r8 == false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return -r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.size
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00c6
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            r5 = -7
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0014:
            org.cocos2dx.okio.d r10 = r0.head
            byte[] r11 = r10.f3261a
            int r12 = r10.f3262b
            int r13 = r10.f3263c
        L_0x001c:
            if (r12 >= r13) goto L_0x009f
            byte r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L_0x006c
            r14 = 57
            if (r15 > r14) goto L_0x006c
            int r14 = 48 - r15
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L_0x003f
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 != 0) goto L_0x0038
            long r1 = (long) r14
            int r16 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r16 >= 0) goto L_0x0038
            goto L_0x003f
        L_0x0038:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L_0x0076
        L_0x003f:
            org.cocos2dx.okio.Buffer r1 = new org.cocos2dx.okio.Buffer
            r1.<init>()
            org.cocos2dx.okio.Buffer r1 = r1.writeDecimalLong((long) r3)
            org.cocos2dx.okio.Buffer r1 = r1.writeByte((int) r15)
            if (r8 != 0) goto L_0x0051
            r1.readByte()
        L_0x0051:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006c:
            r1 = 45
            if (r15 != r1) goto L_0x0080
            if (r7 != 0) goto L_0x0080
            r1 = 1
            long r5 = r5 - r1
            r8 = 1
        L_0x0076:
            int r12 = r12 + 1
            int r7 = r7 + 1
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L_0x001c
        L_0x0080:
            if (r7 == 0) goto L_0x0084
            r9 = 1
            goto L_0x009f
        L_0x0084:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x009f:
            if (r12 != r13) goto L_0x00ab
            org.cocos2dx.okio.d r1 = r10.b()
            r0.head = r1
            org.cocos2dx.okio.e.a(r10)
            goto L_0x00ad
        L_0x00ab:
            r10.f3262b = r12
        L_0x00ad:
            if (r9 != 0) goto L_0x00bb
            org.cocos2dx.okio.d r1 = r0.head
            if (r1 != 0) goto L_0x00b4
            goto L_0x00bb
        L_0x00b4:
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            goto L_0x0014
        L_0x00bb:
            long r1 = r0.size
            long r5 = (long) r7
            long r1 = r1 - r5
            r0.size = r1
            if (r8 == 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            long r3 = -r3
        L_0x00c5:
            return r3
        L_0x00c6:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto L_0x00cf
        L_0x00ce:
            throw r1
        L_0x00cf:
            goto L_0x00ce
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream inputStream, long j) {
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    public void readFully(Buffer buffer, long j) {
        long j2 = this.size;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    public void readFully(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r8 != r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r15.head = r6.b();
        org.cocos2dx.okio.e.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        r6.f3262b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009f, code lost:
        if (r1 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ac
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            org.cocos2dx.okio.d r6 = r15.head
            byte[] r7 = r6.f3261a
            int r8 = r6.f3262b
            int r9 = r6.f3263c
        L_0x0013:
            if (r8 >= r9) goto L_0x0091
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x003a
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002f
            int r11 = r10 + -97
        L_0x002c:
            int r11 = r11 + 10
            goto L_0x003a
        L_0x002f:
            r11 = 65
            if (r10 < r11) goto L_0x0072
            r11 = 70
            if (r10 > r11) goto L_0x0072
            int r11 = r10 + -65
            goto L_0x002c
        L_0x003a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x004a:
            org.cocos2dx.okio.Buffer r0 = new org.cocos2dx.okio.Buffer
            r0.<init>()
            org.cocos2dx.okio.Buffer r0 = r0.writeHexadecimalUnsignedLong((long) r4)
            org.cocos2dx.okio.Buffer r0 = r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0072:
            if (r0 == 0) goto L_0x0076
            r1 = 1
            goto L_0x0091
        L_0x0076:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0091:
            if (r8 != r9) goto L_0x009d
            org.cocos2dx.okio.d r7 = r6.b()
            r15.head = r7
            org.cocos2dx.okio.e.a(r6)
            goto L_0x009f
        L_0x009d:
            r6.f3262b = r8
        L_0x009f:
            if (r1 != 0) goto L_0x00a5
            org.cocos2dx.okio.d r6 = r15.head
            if (r6 != 0) goto L_0x000b
        L_0x00a5:
            long r1 = r15.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.size = r1
            return r4
        L_0x00ac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto L_0x00b5
        L_0x00b4:
            throw r0
        L_0x00b5:
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public int readInt() {
        long j = this.size;
        if (j >= 4) {
            d dVar = this.head;
            int i = dVar.f3262b;
            int i2 = dVar.f3263c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = dVar.f3261a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b3 = b2 | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b4 = b3 | (bArr[i5] & 255);
            this.size = j - 4;
            if (i6 == i2) {
                this.head = dVar.b();
                e.a(dVar);
            } else {
                dVar.f3262b = i6;
            }
            return b4;
        }
        throw new IllegalStateException("size < 4: " + this.size);
    }

    public int readIntLe() {
        return g.c(readInt());
    }

    public long readLong() {
        long j = this.size;
        if (j >= 8) {
            d dVar = this.head;
            int i = dVar.f3262b;
            int i2 = dVar.f3263c;
            if (i2 - i < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = dVar.f3261a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            long j2 = (((long) bArr[i3]) & 255) << 48;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j3 = j2 | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16) | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
            this.size = j - 8;
            if (i10 == i2) {
                this.head = dVar.b();
                e.a(dVar);
            } else {
                dVar.f3262b = i10;
            }
            return j3;
        }
        throw new IllegalStateException("size < 8: " + this.size);
    }

    public long readLongLe() {
        return g.d(readLong());
    }

    public short readShort() {
        long j = this.size;
        if (j >= 2) {
            d dVar = this.head;
            int i = dVar.f3262b;
            int i2 = dVar.f3263c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = dVar.f3261a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.size = j - 2;
            if (i4 == i2) {
                this.head = dVar.b();
                e.a(dVar);
            } else {
                dVar.f3262b = i4;
            }
            return (short) b2;
        }
        throw new IllegalStateException("size < 2: " + this.size);
    }

    public short readShortLe() {
        return g.e(readShort());
    }

    public String readString(long j, Charset charset) {
        g.b(this.size, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            d dVar = this.head;
            if (((long) dVar.f3262b) + j > ((long) dVar.f3263c)) {
                return new String(readByteArray(j), charset);
            }
            String str = new String(dVar.f3261a, dVar.f3262b, (int) j, charset);
            int i = (int) (((long) dVar.f3262b) + j);
            dVar.f3262b = i;
            this.size -= j;
            if (i == dVar.f3263c) {
                this.head = dVar.b();
                e.a(dVar);
            }
            return str;
        }
    }

    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public String readUtf8() {
        try {
            return readString(this.size, g.f3269a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String readUtf8(long j) {
        return readString(j, g.f3269a);
    }

    public int readUtf8CodePoint() {
        byte b2;
        int i;
        byte b3;
        if (this.size != 0) {
            byte b4 = getByte(0);
            int i2 = 1;
            if ((b4 & 128) == 0) {
                b3 = b4 & Byte.MAX_VALUE;
                i = 1;
                b2 = 0;
            } else if ((b4 & 224) == 192) {
                b3 = b4 & 31;
                i = 2;
                b2 = 128;
            } else if ((b4 & 240) == 224) {
                b3 = b4 & 15;
                i = 3;
                b2 = 2048;
            } else if ((b4 & 248) == 240) {
                b3 = b4 & 7;
                i = 4;
                b2 = 65536;
            } else {
                skip(1);
                return REPLACEMENT_CHARACTER;
            }
            long j = (long) i;
            if (this.size >= j) {
                while (i2 < i) {
                    long j2 = (long) i2;
                    byte b5 = getByte(j2);
                    if ((b5 & 192) == 128) {
                        b3 = (b3 << 6) | (b5 & 63);
                        i2++;
                    } else {
                        skip(j2);
                        return REPLACEMENT_CHARACTER;
                    }
                }
                skip(j);
                return b3 > 1114111 ? REPLACEMENT_CHARACTER : ((b3 < 55296 || b3 > 57343) && b3 >= b2) ? b3 : REPLACEMENT_CHARACTER;
            }
            throw new EOFException("size < " + i + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b4) + ")");
        }
        throw new EOFException();
    }

    @Nullable
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        long j = this.size;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String readUtf8Line(long j) {
        String readUtf8;
        long j2 = 1;
        if (j > 0) {
            long j3 = j - 1;
            if (getByte(j3) == 13) {
                readUtf8 = readUtf8(j3);
                j2 = 2;
                skip(j2);
                return readUtf8;
            }
        }
        readUtf8 = readUtf8(j);
        skip(j2);
        return readUtf8;
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public String readUtf8LineStrict(long j) {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long indexOf = indexOf((byte) 10, 0, j2);
            if (indexOf != -1) {
                return readUtf8Line(indexOf);
            }
            if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
                return readUtf8Line(j2);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    public boolean request(long j) {
        return this.size >= j;
    }

    public void require(long j) {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: package-private */
    public List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        d dVar = this.head;
        arrayList.add(Integer.valueOf(dVar.f3263c - dVar.f3262b));
        d dVar2 = this.head;
        while (true) {
            dVar2 = dVar2.f3266f;
            if (dVar2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(dVar2.f3263c - dVar2.f3262b));
        }
    }

    public int select(Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip((long) options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public int selectPrefix(Options options, boolean z) {
        int i;
        int i2;
        int i3;
        d dVar;
        int i4;
        Options options2 = options;
        d dVar2 = this.head;
        int i5 = -2;
        if (dVar2 != null) {
            byte[] bArr = dVar2.f3261a;
            int i6 = dVar2.f3262b;
            int i7 = dVar2.f3263c;
            int[] iArr = options2.trie;
            d dVar3 = dVar2;
            int i8 = 0;
            int i9 = -1;
            loop0:
            while (true) {
                int i10 = i8 + 1;
                int i11 = iArr[i8];
                int i12 = i10 + 1;
                int i13 = iArr[i10];
                if (i13 != -1) {
                    i9 = i13;
                }
                if (dVar3 == null) {
                    break;
                }
                if (i11 < 0) {
                    int i14 = i12 + (i11 * -1);
                    while (true) {
                        int i15 = i6 + 1;
                        int i16 = i12 + 1;
                        if ((bArr[i6] & 255) != iArr[i12]) {
                            return i9;
                        }
                        boolean z2 = i16 == i14;
                        if (i15 == i7) {
                            d dVar4 = dVar3.f3266f;
                            i4 = dVar4.f3262b;
                            byte[] bArr2 = dVar4.f3261a;
                            i3 = dVar4.f3263c;
                            if (dVar4 != dVar2) {
                                byte[] bArr3 = bArr2;
                                dVar = dVar4;
                                bArr = bArr3;
                            } else if (!z2) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                dVar = null;
                            }
                        } else {
                            d dVar5 = dVar3;
                            i3 = i7;
                            i4 = i15;
                            dVar = dVar5;
                        }
                        if (z2) {
                            i = iArr[i16];
                            i2 = i4;
                            i7 = i3;
                            dVar3 = dVar;
                            break;
                        }
                        i6 = i4;
                        i7 = i3;
                        i12 = i16;
                        dVar3 = dVar;
                    }
                } else {
                    int i17 = i6 + 1;
                    byte b2 = bArr[i6] & 255;
                    int i18 = i12 + i11;
                    while (i12 != i18) {
                        if (b2 == iArr[i12]) {
                            i = iArr[i12 + i11];
                            if (i17 == i7) {
                                dVar3 = dVar3.f3266f;
                                i2 = dVar3.f3262b;
                                bArr = dVar3.f3261a;
                                i7 = dVar3.f3263c;
                                if (dVar3 == dVar2) {
                                    dVar3 = null;
                                }
                            } else {
                                i2 = i17;
                            }
                        } else {
                            i12++;
                        }
                    }
                    return i9;
                }
                if (i >= 0) {
                    return i;
                }
                i8 = -i;
                i6 = i2;
                i5 = -2;
            }
            return z ? i5 : i9;
        } else if (z) {
            return -2;
        } else {
            return options2.indexOf(ByteString.EMPTY);
        }
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    public void skip(long j) {
        while (j > 0) {
            d dVar = this.head;
            if (dVar != null) {
                int min = (int) Math.min(j, (long) (dVar.f3263c - dVar.f3262b));
                long j2 = (long) min;
                this.size -= j2;
                j -= j2;
                d dVar2 = this.head;
                int i = dVar2.f3262b + min;
                dVar2.f3262b = i;
                if (i == dVar2.f3263c) {
                    this.head = dVar2.b();
                    e.a(dVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString snapshot() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public final ByteString snapshot(int i) {
        return i == 0 ? ByteString.EMPTY : new f(this, i);
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    /* access modifiers changed from: package-private */
    public d writableSegment(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        d dVar = this.head;
        if (dVar == null) {
            d b2 = e.b();
            this.head = b2;
            b2.g = b2;
            b2.f3266f = b2;
            return b2;
        }
        d dVar2 = dVar.g;
        if (dVar2.f3263c + i <= 8192 && dVar2.f3265e) {
            return dVar2;
        }
        d b3 = e.b();
        dVar2.c(b3);
        return b3;
    }

    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                d writableSegment = writableSegment(1);
                int min = Math.min(i, 8192 - writableSegment.f3263c);
                byteBuffer.get(writableSegment.f3261a, writableSegment.f3263c, min);
                i -= min;
                writableSegment.f3263c += min;
            }
            this.size += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            g.b((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                d writableSegment = writableSegment(1);
                int min = Math.min(i3 - i, 8192 - writableSegment.f3263c);
                System.arraycopy(bArr, i, writableSegment.f3261a, writableSegment.f3263c, min);
                i += min;
                writableSegment.f3263c += min;
            }
            this.size += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public BufferedSink write(Source source, long j) {
        while (j > 0) {
            long read = source.read(this, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer != this) {
            g.b(buffer.size, 0, j);
            while (j > 0) {
                d dVar = buffer.head;
                if (j < ((long) (dVar.f3263c - dVar.f3262b))) {
                    d dVar2 = this.head;
                    d dVar3 = dVar2 != null ? dVar2.g : null;
                    if (dVar3 != null && dVar3.f3265e) {
                        if ((((long) dVar3.f3263c) + j) - ((long) (dVar3.f3264d ? 0 : dVar3.f3262b)) <= 8192) {
                            dVar.g(dVar3, (int) j);
                            buffer.size -= j;
                            this.size += j;
                            return;
                        }
                    }
                    buffer.head = dVar.e((int) j);
                }
                d dVar4 = buffer.head;
                long j2 = (long) (dVar4.f3263c - dVar4.f3262b);
                buffer.head = dVar4.b();
                d dVar5 = this.head;
                if (dVar5 == null) {
                    this.head = dVar4;
                    dVar4.g = dVar4;
                    dVar4.f3266f = dVar4;
                } else {
                    dVar5.g.c(dVar4);
                    dVar4.a();
                }
                buffer.size -= j2;
                this.size += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long writeAll(Source source) {
        if (source != null) {
            long j = 0;
            while (true) {
                long read = source.read(this, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public Buffer writeByte(int i) {
        d writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.f3261a;
        int i2 = writableSegment.f3263c;
        writableSegment.f3263c = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    public Buffer writeDecimalLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        d writableSegment = writableSegment(i);
        byte[] bArr = writableSegment.f3261a;
        int i2 = writableSegment.f3263c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        writableSegment.f3263c += i;
        this.size += (long) i;
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        d writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.f3261a;
        int i = writableSegment.f3263c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment.f3263c += numberOfTrailingZeros;
        this.size += (long) numberOfTrailingZeros;
        return this;
    }

    public Buffer writeInt(int i) {
        d writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.f3261a;
        int i2 = writableSegment.f3263c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment.f3263c = i5 + 1;
        this.size += 4;
        return this;
    }

    public Buffer writeIntLe(int i) {
        return writeInt(g.c(i));
    }

    public Buffer writeLong(long j) {
        d writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.f3261a;
        int i = writableSegment.f3263c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        writableSegment.f3263c = i8 + 1;
        this.size += 8;
        return this;
    }

    public Buffer writeLongLe(long j) {
        return writeLong(g.d(j));
    }

    public Buffer writeShort(int i) {
        d writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.f3261a;
        int i2 = writableSegment.f3263c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment.f3263c = i3 + 1;
        this.size += 2;
        return this;
    }

    public Buffer writeShortLe(int i) {
        return writeShort((int) g.e((short) i));
    }

    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(g.f3269a)) {
            return writeUtf8(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public final Buffer writeTo(OutputStream outputStream) {
        return writeTo(outputStream, this.size);
    }

    public final Buffer writeTo(OutputStream outputStream, long j) {
        if (outputStream != null) {
            g.b(this.size, 0, j);
            d dVar = this.head;
            while (j > 0) {
                int min = (int) Math.min(j, (long) (dVar.f3263c - dVar.f3262b));
                outputStream.write(dVar.f3261a, dVar.f3262b, min);
                int i = dVar.f3262b + min;
                dVar.f3262b = i;
                long j2 = (long) min;
                this.size -= j2;
                j -= j2;
                if (i == dVar.f3263c) {
                    d b2 = dVar.b();
                    this.head = b2;
                    e.a(dVar);
                    dVar = b2;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    public Buffer writeUtf8(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    d writableSegment = writableSegment(1);
                    byte[] bArr = writableSegment.f3261a;
                    int i4 = writableSegment.f3263c - i;
                    int min = Math.min(i2, 8192 - i4);
                    int i5 = i + 1;
                    bArr[i + i4] = (byte) charAt;
                    while (i5 < min) {
                        char charAt2 = str.charAt(i5);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i5 + i4] = (byte) charAt2;
                        i5++;
                    }
                    int i6 = writableSegment.f3263c;
                    int i7 = (i4 + i5) - i6;
                    writableSegment.f3263c = i6 + i7;
                    this.size += (long) i7;
                    i = i5;
                } else {
                    if (charAt < 2048) {
                        i3 = (charAt >> 6) | 192;
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        i3 = ((charAt >> 6) & 63) | 128;
                    } else {
                        int i8 = i + 1;
                        char charAt3 = i8 < i2 ? str.charAt(i8) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i = i8;
                        } else {
                            int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 0;
                            writeByte((i9 >> 18) | 240);
                            writeByte(((i9 >> 12) & 63) | 128);
                            writeByte(((i9 >> 6) & 63) | 128);
                            writeByte((i9 & 63) | 128);
                            i += 2;
                        }
                    }
                    writeByte(i3);
                    writeByte((int) (charAt & '?') | 128);
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    public Buffer writeUtf8CodePoint(int i) {
        int i2;
        int i3;
        if (i >= 128) {
            if (i < 2048) {
                i3 = (i >> 6) | 192;
            } else {
                if (i < 65536) {
                    if (i < 55296 || i > 57343) {
                        i2 = (i >> 12) | 224;
                    } else {
                        writeByte(63);
                        return this;
                    }
                } else if (i <= 1114111) {
                    writeByte((i >> 18) | 240);
                    i2 = ((i >> 12) & 63) | 128;
                } else {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                }
                writeByte(i2);
                i3 = ((i >> 6) & 63) | 128;
            }
            writeByte(i3);
            i = (i & 63) | 128;
        }
        writeByte(i);
        return this;
    }
}
