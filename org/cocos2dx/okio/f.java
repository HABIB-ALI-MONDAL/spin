package org.cocos2dx.okio;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class f extends ByteString {
    final transient byte[][] j;
    final transient int[] k;

    f(Buffer buffer, int i) {
        super((byte[]) null);
        g.b(buffer.size, 0, (long) i);
        d dVar = buffer.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = dVar.f3263c;
            int i6 = dVar.f3262b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                dVar = dVar.f3266f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.j = new byte[i4][];
        this.k = new int[(i4 * 2)];
        d dVar2 = buffer.head;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.j;
            bArr[i7] = dVar2.f3261a;
            int i8 = dVar2.f3263c;
            int i9 = dVar2.f3262b;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.k;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            dVar2.f3264d = true;
            i7++;
            dVar2 = dVar2.f3266f;
        }
    }

    private int d(int i) {
        int binarySearch = Arrays.binarySearch(this.k, 0, this.j.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    private ByteString e() {
        return new ByteString(toByteArray());
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public String base64() {
        return e().base64();
    }

    public String base64Url() {
        return e().base64Url();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.size() == size() && rangeEquals(0, byteString, 0, size());
        }
    }

    public byte getByte(int i) {
        g.b((long) this.k[this.j.length - 1], (long) i, 1);
        int d2 = d(i);
        int i2 = d2 == 0 ? 0 : this.k[d2 - 1];
        int[] iArr = this.k;
        byte[][] bArr = this.j;
        return bArr[d2][(i - i2) + iArr[bArr.length + d2]];
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.j.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.j[i2];
            int[] iArr = this.k;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.hashCode = i4;
        return i4;
    }

    public String hex() {
        return e().hex();
    }

    public ByteString hmacSha1(ByteString byteString) {
        return e().hmacSha1(byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return e().hmacSha256(byteString);
    }

    public int indexOf(byte[] bArr, int i) {
        return e().indexOf(bArr, i);
    }

    /* access modifiers changed from: package-private */
    public byte[] internalArray() {
        return toByteArray();
    }

    public int lastIndexOf(byte[] bArr, int i) {
        return e().lastIndexOf(bArr, i);
    }

    public ByteString md5() {
        return e().md5();
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int d2 = d(i);
        while (i3 > 0) {
            int i4 = d2 == 0 ? 0 : this.k[d2 - 1];
            int min = Math.min(i3, ((this.k[d2] - i4) + i4) - i);
            int[] iArr = this.k;
            byte[][] bArr = this.j;
            if (!byteString.rangeEquals(i2, bArr[d2], (i - i4) + iArr[bArr.length + d2], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            d2++;
        }
        return true;
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int d2 = d(i);
        while (i3 > 0) {
            int i4 = d2 == 0 ? 0 : this.k[d2 - 1];
            int min = Math.min(i3, ((this.k[d2] - i4) + i4) - i);
            int[] iArr = this.k;
            byte[][] bArr2 = this.j;
            if (!g.a(bArr2[d2], (i - i4) + iArr[bArr2.length + d2], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            d2++;
        }
        return true;
    }

    public ByteString sha1() {
        return e().sha1();
    }

    public ByteString sha256() {
        return e().sha256();
    }

    public int size() {
        return this.k[this.j.length - 1];
    }

    public String string(Charset charset) {
        return e().string(charset);
    }

    public ByteString substring(int i) {
        return e().substring(i);
    }

    public ByteString substring(int i, int i2) {
        return e().substring(i, i2);
    }

    public ByteString toAsciiLowercase() {
        return e().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return e().toAsciiUppercase();
    }

    public byte[] toByteArray() {
        int[] iArr = this.k;
        byte[][] bArr = this.j;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.k;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.j[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    public String toString() {
        return e().toString();
    }

    public String utf8() {
        return e().utf8();
    }

    public void write(OutputStream outputStream) {
        if (outputStream != null) {
            int length = this.j.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int[] iArr = this.k;
                int i3 = iArr[length + i];
                int i4 = iArr[i];
                outputStream.write(this.j[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* access modifiers changed from: package-private */
    public void write(Buffer buffer) {
        int length = this.j.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.k;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            d dVar = new d(this.j[i], i3, (i3 + i4) - i2, true, false);
            d dVar2 = buffer.head;
            if (dVar2 == null) {
                dVar.g = dVar;
                dVar.f3266f = dVar;
                buffer.head = dVar;
            } else {
                dVar2.g.c(dVar);
            }
            i++;
            i2 = i4;
        }
        buffer.size += (long) i2;
    }
}
