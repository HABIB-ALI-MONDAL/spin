package c.e.a.a;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

public final class e {
    public static byte[] a(File file, int i) {
        ByteBuffer byteBuffer;
        Map<Integer, ByteBuffer> b2 = b(file);
        if (b2 == null || (byteBuffer = b2.get(Integer.valueOf(i))) == null) {
            return null;
        }
        return c(byteBuffer);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:12|(2:20|21)|(2:24|25)|26|27) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|(7:1|2|3|4|5|6|(2:8|9))|10|11|36|(2:(0)|(0))) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0043, code lost:
        if (r1 == null) goto L_0x0046;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0039 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002f A[SYNTHETIC, Splitter:B:20:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0036 A[SYNTHETIC, Splitter:B:24:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x003e A[SYNTHETIC, Splitter:B:32:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[ExcHandler: f (unused c.e.a.a.f), SYNTHETIC, Splitter:B:10:0x001f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<java.lang.Integer, java.nio.ByteBuffer> b(java.io.File r3) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x003a, all -> 0x002a }
            java.lang.String r2 = "r"
            r1.<init>(r3, r2)     // Catch:{ IOException -> 0x003a, all -> 0x002a }
            java.nio.channels.FileChannel r3 = r1.getChannel()     // Catch:{ IOException -> 0x0028, all -> 0x0025 }
            c.e.a.a.d r2 = c.e.a.a.a.b(r3)     // Catch:{ IOException -> 0x003c, all -> 0x0023 }
            java.lang.Object r2 = r2.a()     // Catch:{ IOException -> 0x003c, all -> 0x0023 }
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2     // Catch:{ IOException -> 0x003c, all -> 0x0023 }
            java.util.Map r0 = c.e.a.a.a.f(r2)     // Catch:{ IOException -> 0x003c, all -> 0x0023 }
            if (r3 == 0) goto L_0x001f
            r3.close()     // Catch:{ IOException -> 0x001f }
        L_0x001f:
            r1.close()     // Catch:{ f -> 0x0046, f -> 0x0046 }
            goto L_0x0046
        L_0x0023:
            r2 = move-exception
            goto L_0x002d
        L_0x0025:
            r2 = move-exception
            r3 = r0
            goto L_0x002d
        L_0x0028:
            r3 = r0
            goto L_0x003c
        L_0x002a:
            r2 = move-exception
            r3 = r0
            r1 = r3
        L_0x002d:
            if (r3 == 0) goto L_0x0034
            r3.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0034
        L_0x0033:
        L_0x0034:
            if (r1 == 0) goto L_0x0039
            r1.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            throw r2     // Catch:{  }
        L_0x003a:
            r3 = r0
            r1 = r3
        L_0x003c:
            if (r3 == 0) goto L_0x0043
            r3.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0043
        L_0x0042:
        L_0x0043:
            if (r1 == 0) goto L_0x0046
            goto L_0x001f
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.a.a.e.b(java.io.File):java.util.Map");
    }

    private static byte[] c(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        return Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, arrayOffset + byteBuffer.limit());
    }

    public static String d(File file, int i) {
        byte[] a2 = a(file, i);
        if (a2 == null) {
            return null;
        }
        try {
            return new String(a2, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
