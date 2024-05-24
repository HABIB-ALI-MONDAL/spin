package c.b.a.n.q.c;

import android.graphics.Bitmap;
import c.b.a.n.i;
import c.b.a.n.j;
import c.b.a.n.l;
import c.b.a.n.o.z.b;

public class c implements l<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    public static final i<Integer> f1129b = i.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c  reason: collision with root package name */
    public static final i<Bitmap.CompressFormat> f1130c = i.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: a  reason: collision with root package name */
    private final b f1131a;

    public c(b bVar) {
        this.f1131a = bVar;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, j jVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) jVar.c(f1130c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    public c.b.a.n.c b(j jVar) {
        return c.b.a.n.c.TRANSFORMED;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|(2:38|39)|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        if (r6 == null) goto L_0x0080;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00d6 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0078 A[Catch:{ all -> 0x006e }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d3 A[SYNTHETIC, Splitter:B:38:0x00d3] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(c.b.a.n.o.u<android.graphics.Bitmap> r9, java.io.File r10, c.b.a.n.j r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r1 = r8.d(r9, r11)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "encode: ["
            r2.append(r3)
            int r3 = r9.getWidth()
            r2.append(r3)
            java.lang.String r3 = "x"
            r2.append(r3)
            int r3 = r9.getHeight()
            r2.append(r3)
            java.lang.String r3 = "] "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            b.d.g.f.a(r2)
            long r2 = c.b.a.t.d.b()     // Catch:{ all -> 0x00d7 }
            c.b.a.n.i<java.lang.Integer> r4 = f1129b     // Catch:{ all -> 0x00d7 }
            java.lang.Object r4 = r11.c(r4)     // Catch:{ all -> 0x00d7 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x00d7 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x00d7 }
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0070 }
            r7.<init>(r10)     // Catch:{ IOException -> 0x0070 }
            c.b.a.n.o.z.b r10 = r8.f1131a     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            if (r10 == 0) goto L_0x005c
            c.b.a.n.n.c r10 = new c.b.a.n.n.c     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            c.b.a.n.o.z.b r6 = r8.f1131a     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r10.<init>(r7, r6)     // Catch:{ IOException -> 0x006b, all -> 0x0068 }
            r6 = r10
            goto L_0x005d
        L_0x005c:
            r6 = r7
        L_0x005d:
            r9.compress(r1, r4, r6)     // Catch:{ IOException -> 0x0070 }
            r6.close()     // Catch:{ IOException -> 0x0070 }
            r5 = 1
        L_0x0064:
            r6.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0080
        L_0x0068:
            r9 = move-exception
            r6 = r7
            goto L_0x00d1
        L_0x006b:
            r10 = move-exception
            r6 = r7
            goto L_0x0071
        L_0x006e:
            r9 = move-exception
            goto L_0x00d1
        L_0x0070:
            r10 = move-exception
        L_0x0071:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x007d
            java.lang.String r4 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r4, r10)     // Catch:{ all -> 0x006e }
        L_0x007d:
            if (r6 == 0) goto L_0x0080
            goto L_0x0064
        L_0x0080:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch:{ all -> 0x00d7 }
            if (r10 == 0) goto L_0x00cd
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d7 }
            r10.<init>()     // Catch:{ all -> 0x00d7 }
            java.lang.String r4 = "Compressed with type: "
            r10.append(r4)     // Catch:{ all -> 0x00d7 }
            r10.append(r1)     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = " of size "
            r10.append(r1)     // Catch:{ all -> 0x00d7 }
            int r1 = c.b.a.t.i.g(r9)     // Catch:{ all -> 0x00d7 }
            r10.append(r1)     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = " in "
            r10.append(r1)     // Catch:{ all -> 0x00d7 }
            double r1 = c.b.a.t.d.a(r2)     // Catch:{ all -> 0x00d7 }
            r10.append(r1)     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = ", options format: "
            r10.append(r1)     // Catch:{ all -> 0x00d7 }
            c.b.a.n.i<android.graphics.Bitmap$CompressFormat> r1 = f1130c     // Catch:{ all -> 0x00d7 }
            java.lang.Object r11 = r11.c(r1)     // Catch:{ all -> 0x00d7 }
            r10.append(r11)     // Catch:{ all -> 0x00d7 }
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch:{ all -> 0x00d7 }
            boolean r9 = r9.hasAlpha()     // Catch:{ all -> 0x00d7 }
            r10.append(r9)     // Catch:{ all -> 0x00d7 }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x00d7 }
            android.util.Log.v(r0, r9)     // Catch:{ all -> 0x00d7 }
        L_0x00cd:
            b.d.g.f.b()
            return r5
        L_0x00d1:
            if (r6 == 0) goto L_0x00d6
            r6.close()     // Catch:{ IOException -> 0x00d6 }
        L_0x00d6:
            throw r9     // Catch:{ all -> 0x00d7 }
        L_0x00d7:
            r9 = move-exception
            b.d.g.f.b()
            goto L_0x00dd
        L_0x00dc:
            throw r9
        L_0x00dd:
            goto L_0x00dc
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.n.q.c.c.a(c.b.a.n.o.u, java.io.File, c.b.a.n.j):boolean");
    }
}
