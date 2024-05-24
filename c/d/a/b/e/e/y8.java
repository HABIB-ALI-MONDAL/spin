package c.d.a.b.e.e;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class y8 {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f1783a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f1784b;

    static {
        Charset.forName("US-ASCII");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f1784b = bArr;
        ByteBuffer.wrap(bArr);
        int i = v7.f1772a;
        try {
            new t7(bArr, 0, 0, false, (s7) null).c(0);
        } catch (a9 e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        int d2 = d(length, bArr, 0, length);
        if (d2 == 0) {
            return 1;
        }
        return d2;
    }

    public static int c(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static int d(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object e(Object obj) {
        Objects.requireNonNull(obj);
        return obj;
    }

    static Object f(Object obj, String str) {
        Objects.requireNonNull(obj, str);
        return obj;
    }

    public static String g(byte[] bArr) {
        return new String(bArr, f1783a);
    }

    public static boolean h(byte[] bArr) {
        return qb.e(bArr);
    }
}
