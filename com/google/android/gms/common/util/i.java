package com.google.android.gms.common.util;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f2268a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f2269b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length + length)];
        int i = 0;
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            int i2 = i + 1;
            char[] cArr2 = f2269b;
            cArr[i] = cArr2[b3 >>> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b3 & 15];
        }
        return new String(cArr);
    }

    public static String b(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        int i = 0;
        while (i < length && (!z || i != length - 1 || (bArr[i] & 255) != 0)) {
            char[] cArr = f2268a;
            sb.append(cArr[(bArr[i] & 240) >>> 4]);
            sb.append(cArr[bArr[i] & 15]);
            i++;
        }
        return sb.toString();
    }
}
