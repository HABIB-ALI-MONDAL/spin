package c.b.a.n.q.c;

import android.util.Log;
import c.b.a.n.f;
import c.b.a.t.h;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class i implements f {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f1135a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1136b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f1137a;

        a(ByteBuffer byteBuffer) {
            this.f1137a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return ((d() << 8) & 65280) | (d() & 255);
        }

        public int b(byte[] bArr, int i) {
            int min = Math.min(i, this.f1137a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f1137a.get(bArr, 0, min);
            return min;
        }

        public short c() {
            return (short) (d() & 255);
        }

        public int d() {
            if (this.f1137a.remaining() < 1) {
                return -1;
            }
            return this.f1137a.get();
        }

        public long skip(long j) {
            int min = (int) Math.min((long) this.f1137a.remaining(), j);
            ByteBuffer byteBuffer = this.f1137a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f1138a;

        b(byte[] bArr, int i) {
            this.f1138a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        private boolean c(int i, int i2) {
            return this.f1138a.remaining() - i >= i2;
        }

        /* access modifiers changed from: package-private */
        public short a(int i) {
            if (c(i, 2)) {
                return this.f1138a.getShort(i);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            if (c(i, 4)) {
                return this.f1138a.getInt(i);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return this.f1138a.remaining();
        }

        /* access modifiers changed from: package-private */
        public void e(ByteOrder byteOrder) {
            this.f1138a.order(byteOrder);
        }
    }

    private interface c {
        int a();

        int b(byte[] bArr, int i);

        short c();

        int d();

        long skip(long j);
    }

    private static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f1139a;

        d(InputStream inputStream) {
            this.f1139a = inputStream;
        }

        public int a() {
            return ((this.f1139a.read() << 8) & 65280) | (this.f1139a.read() & 255);
        }

        public int b(byte[] bArr, int i) {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f1139a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        public short c() {
            return (short) (this.f1139a.read() & 255);
        }

        public int d() {
            return this.f1139a.read();
        }

        public long skip(long j) {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f1139a.skip(j2);
                if (skip <= 0) {
                    if (this.f1139a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    private static int d(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private int e(c cVar, c.b.a.n.o.z.b bVar) {
        int a2 = cVar.a();
        if (!g(a2)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + a2);
            }
            return -1;
        }
        int i = i(cVar);
        if (i == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.e(i, byte[].class);
        try {
            return k(cVar, bArr, i);
        } finally {
            bVar.d(bArr);
        }
    }

    private f.a f(c cVar) {
        int a2 = cVar.a();
        if (a2 == 65496) {
            return f.a.JPEG;
        }
        int a3 = ((a2 << 16) & -65536) | (cVar.a() & 65535);
        if (a3 == -1991225785) {
            cVar.skip(21);
            return cVar.d() >= 3 ? f.a.PNG_A : f.a.PNG;
        } else if ((a3 >> 8) == 4671814) {
            return f.a.GIF;
        } else {
            if (a3 != 1380533830) {
                return f.a.UNKNOWN;
            }
            cVar.skip(4);
            if ((((cVar.a() << 16) & -65536) | (cVar.a() & 65535)) != 1464156752) {
                return f.a.UNKNOWN;
            }
            int a4 = ((cVar.a() << 16) & -65536) | (cVar.a() & 65535);
            if ((a4 & -256) != 1448097792) {
                return f.a.UNKNOWN;
            }
            int i = a4 & 255;
            if (i == 88) {
                cVar.skip(4);
                return (cVar.d() & 16) != 0 ? f.a.WEBP_A : f.a.WEBP;
            } else if (i != 76) {
                return f.a.WEBP;
            } else {
                cVar.skip(4);
                return (cVar.d() & 8) != 0 ? f.a.WEBP_A : f.a.WEBP;
            }
        }
    }

    private static boolean g(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    private boolean h(byte[] bArr, int i) {
        boolean z = bArr != null && i > f1135a.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = f1135a;
                if (i2 >= bArr2.length) {
                    break;
                } else if (bArr[i2] != bArr2[i2]) {
                    return false;
                } else {
                    i2++;
                }
            }
        }
        return z;
    }

    private int i(c cVar) {
        short c2;
        int a2;
        long j;
        long skip;
        do {
            short c3 = cVar.c();
            if (c3 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + c3);
                }
                return -1;
            }
            c2 = cVar.c();
            if (c2 == 218) {
                return -1;
            }
            if (c2 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = cVar.a() - 2;
            if (c2 == 225) {
                return a2;
            }
            j = (long) a2;
            skip = cVar.skip(j);
        } while (skip == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + c2 + ", wanted to skip: " + a2 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private static int j(b bVar) {
        ByteOrder byteOrder;
        String str;
        StringBuilder sb;
        String str2;
        short a2 = bVar.a(6);
        if (a2 != 18761) {
            if (a2 != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + a2);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.e(byteOrder);
        int b2 = bVar.b(10) + 6;
        short a3 = bVar.a(b2);
        for (int i = 0; i < a3; i++) {
            int d2 = d(b2, i);
            short a4 = bVar.a(d2);
            if (a4 == 274) {
                short a5 = bVar.a(d2 + 2);
                if (a5 >= 1 && a5 <= 12) {
                    int b3 = bVar.b(d2 + 4);
                    if (b3 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i + " tagType=" + a4 + " formatCode=" + a5 + " componentCount=" + b3);
                        }
                        int i2 = b3 + f1136b[a5];
                        if (i2 <= 4) {
                            int i3 = d2 + 8;
                            if (i3 < 0 || i3 > bVar.d()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    str = "Illegal tagValueOffset=" + i3 + " tagType=" + a4;
                                    Log.d("DfltImageHeaderParser", str);
                                }
                            } else if (i2 >= 0 && i2 + i3 <= bVar.d()) {
                                return bVar.a(i3);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    sb = new StringBuilder();
                                    sb.append("Illegal number of bytes for TI tag data tagType=");
                                    sb.append(a4);
                                    str = sb.toString();
                                    Log.d("DfltImageHeaderParser", str);
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            sb = new StringBuilder();
                            str2 = "Got byte count > 4, not orientation, continuing, formatCode=";
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        str = "Negative tiff component count";
                        Log.d("DfltImageHeaderParser", str);
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    sb = new StringBuilder();
                    str2 = "Got invalid format code = ";
                }
                sb.append(str2);
                sb.append(a5);
                str = sb.toString();
                Log.d("DfltImageHeaderParser", str);
            }
        }
        return -1;
    }

    private int k(c cVar, byte[] bArr, int i) {
        int b2 = cVar.b(bArr, i);
        if (b2 != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + b2);
            }
            return -1;
        } else if (h(bArr, i)) {
            return j(new b(bArr, i));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    public f.a a(ByteBuffer byteBuffer) {
        h.d(byteBuffer);
        return f(new a(byteBuffer));
    }

    public int b(InputStream inputStream, c.b.a.n.o.z.b bVar) {
        h.d(inputStream);
        d dVar = new d(inputStream);
        h.d(bVar);
        return e(dVar, bVar);
    }

    public f.a c(InputStream inputStream) {
        h.d(inputStream);
        return f(new d(inputStream));
    }
}
