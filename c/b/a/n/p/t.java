package c.b.a.n.p;

import c.b.a.n.d;
import c.b.a.n.o.z.b;
import java.io.InputStream;

public class t implements d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final b f1103a;

    public t(b bVar) {
        this.f1103a = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038 A[Catch:{ all -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003f A[SYNTHETIC, Splitter:B:23:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004a A[SYNTHETIC, Splitter:B:29:0x004a] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.io.InputStream r5, java.io.File r6, c.b.a.n.j r7) {
        /*
            r4 = this;
            java.lang.String r7 = "StreamEncoder"
            c.b.a.n.o.z.b r0 = r4.f1103a
            java.lang.Class<byte[]> r1 = byte[].class
            r2 = 65536(0x10000, float:9.18355E-41)
            java.lang.Object r0 = r0.e(r2, r1)
            byte[] r0 = (byte[]) r0
            r1 = 0
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0030 }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0030 }
        L_0x0015:
            int r6 = r5.read(r0)     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r2 = -1
            if (r6 == r2) goto L_0x0020
            r3.write(r0, r1, r6)     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            goto L_0x0015
        L_0x0020:
            r3.close()     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r1 = 1
            r3.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0042
        L_0x0028:
            r5 = move-exception
            r2 = r3
            goto L_0x0048
        L_0x002b:
            r5 = move-exception
            r2 = r3
            goto L_0x0031
        L_0x002e:
            r5 = move-exception
            goto L_0x0048
        L_0x0030:
            r5 = move-exception
        L_0x0031:
            r6 = 3
            boolean r6 = android.util.Log.isLoggable(r7, r6)     // Catch:{ all -> 0x002e }
            if (r6 == 0) goto L_0x003d
            java.lang.String r6 = "Failed to encode data onto the OutputStream"
            android.util.Log.d(r7, r6, r5)     // Catch:{ all -> 0x002e }
        L_0x003d:
            if (r2 == 0) goto L_0x0042
            r2.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            c.b.a.n.o.z.b r5 = r4.f1103a
            r5.d(r0)
            return r1
        L_0x0048:
            if (r2 == 0) goto L_0x004d
            r2.close()     // Catch:{ IOException -> 0x004d }
        L_0x004d:
            c.b.a.n.o.z.b r6 = r4.f1103a
            r6.d(r0)
            goto L_0x0054
        L_0x0053:
            throw r5
        L_0x0054:
            goto L_0x0053
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.n.p.t.a(java.io.InputStream, java.io.File, c.b.a.n.j):boolean");
    }
}
