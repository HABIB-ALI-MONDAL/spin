package f.a.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import java.io.File;
import java.io.FileNotFoundException;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f3093a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3094b;

    /* renamed from: c  reason: collision with root package name */
    Handler f3095c = new Handler();

    class a implements Runnable {
        final /* synthetic */ Bitmap j;
        final /* synthetic */ String k;
        final /* synthetic */ c l;

        a(Bitmap bitmap, String str, c cVar) {
            this.j = bitmap;
            this.k = str;
            this.l = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
            if (r3 == 5) goto L_0x0031;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
                r0.<init>()
                android.graphics.Bitmap r1 = r6.j
                android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG
                r3 = 100
                r1.compress(r2, r3, r0)
            L_0x000e:
                byte[] r1 = r0.toByteArray()
                int r1 = r1.length
                f.a.a.c.d r2 = f.a.a.c.d.this
                f.a.a.c.a r2 = r2.f3093a
                int r2 = r2.d()
                if (r1 <= r2) goto L_0x0031
                r0.reset()
                int r3 = r3 + -5
                r1 = 5
                if (r3 > r1) goto L_0x0028
                r3 = 5
            L_0x0028:
                android.graphics.Bitmap r2 = r6.j
                android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG
                r2.compress(r4, r3, r0)
                if (r3 != r1) goto L_0x000e
            L_0x0031:
                f.a.a.c.d r1 = f.a.a.c.d.this     // Catch:{ Exception -> 0x005e }
                java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x005e }
                java.lang.String r3 = r6.k     // Catch:{ Exception -> 0x005e }
                r2.<init>(r3)     // Catch:{ Exception -> 0x005e }
                java.io.File r1 = r1.g(r2)     // Catch:{ Exception -> 0x005e }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005e }
                r2.<init>(r1)     // Catch:{ Exception -> 0x005e }
                byte[] r0 = r0.toByteArray()     // Catch:{ Exception -> 0x005e }
                r2.write(r0)     // Catch:{ Exception -> 0x005e }
                r2.flush()     // Catch:{ Exception -> 0x005e }
                r2.close()     // Catch:{ Exception -> 0x005e }
                f.a.a.c.d r0 = f.a.a.c.d.this     // Catch:{ Exception -> 0x005e }
                r2 = 1
                java.lang.String r1 = r1.getPath()     // Catch:{ Exception -> 0x005e }
                r3 = 0
                f.a.a.c.d$c r4 = r6.l     // Catch:{ Exception -> 0x005e }
                r0.h(r2, r1, r3, r4)     // Catch:{ Exception -> 0x005e }
                goto L_0x006e
            L_0x005e:
                r0 = move-exception
                f.a.a.c.d r1 = f.a.a.c.d.this
                r2 = 0
                java.lang.String r3 = r6.k
                f.a.a.c.d$c r4 = r6.l
                java.lang.String r5 = "质量压缩失败"
                r1.h(r2, r3, r5, r4)
                r0.printStackTrace()
            L_0x006e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: f.a.a.c.d.a.run():void");
        }
    }

    class b implements Runnable {
        final /* synthetic */ boolean j;
        final /* synthetic */ c k;
        final /* synthetic */ String l;
        final /* synthetic */ String m;

        b(d dVar, boolean z, c cVar, String str, String str2) {
            this.j = z;
            this.k = cVar;
            this.l = str;
            this.m = str2;
        }

        public void run() {
            if (this.j) {
                this.k.b(this.l);
            } else {
                this.k.a(this.l, this.m);
            }
        }
    }

    public interface c {
        void a(String str, String str2);

        void b(String str);
    }

    public d(Context context, a aVar) {
        this.f3094b = context;
        this.f3093a = aVar == null ? a.h() : aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(java.lang.String r7, f.a.a.c.d.c r8) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0009
            java.lang.String r1 = "要压缩的文件不存在"
            r6.h(r0, r7, r1, r8)
            return
        L_0x0009:
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r2 = 1
            r1.inJustDecodeBounds = r2
            android.graphics.BitmapFactory.decodeFile(r7, r1)
            r1.inJustDecodeBounds = r0
            int r0 = r1.outWidth
            int r3 = r1.outHeight
            f.a.a.c.a r4 = r6.f3093a
            int r4 = r4.c()
            float r4 = (float) r4
            if (r0 < r3) goto L_0x002f
            float r5 = (float) r0
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x002f
            int r0 = r1.outWidth
        L_0x002a:
            float r0 = (float) r0
            float r0 = r0 / r4
            int r0 = (int) r0
            int r0 = r0 + r2
            goto L_0x003a
        L_0x002f:
            if (r0 >= r3) goto L_0x0039
            float r0 = (float) r3
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0039
            int r0 = r1.outHeight
            goto L_0x002a
        L_0x0039:
            r0 = 1
        L_0x003a:
            r1.inSampleSize = r0
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            r1.inPreferredConfig = r0
            r1.inPurgeable = r2
            r1.inInputShareable = r2
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r7, r1)
            f.a.a.c.a r1 = r6.f3093a
            boolean r1 = r1.f()
            if (r1 == 0) goto L_0x0054
            r6.f(r0, r7, r8)
            goto L_0x0070
        L_0x0054:
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            java.io.File r7 = r6.g(r1)
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
            r2 = 100
            java.io.FileOutputStream r3 = new java.io.FileOutputStream
            r3.<init>(r7)
            r0.compress(r1, r2, r3)
            java.lang.String r7 = r7.getPath()
            r8.b(r7)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.a.a.c.d.e(java.lang.String, f.a.a.c.d$c):void");
    }

    private void f(Bitmap bitmap, String str, c cVar) {
        if (bitmap == null) {
            h(false, str, "像素压缩失败,bitmap is null", cVar);
        } else {
            new Thread(new a(bitmap, str, cVar)).start();
        }
    }

    /* access modifiers changed from: private */
    public File g(File file) {
        return (file == null || !file.exists()) ? file : f.a.a.f.d.b(this.f3094b, file);
    }

    /* access modifiers changed from: private */
    public void h(boolean z, String str, String str2, c cVar) {
        this.f3095c.post(new b(this, z, cVar, str, str2));
    }

    public void d(String str, c cVar) {
        if (this.f3093a.e()) {
            try {
                e(str, cVar);
            } catch (FileNotFoundException e2) {
                cVar.a(str, String.format("图片压缩失败,%s", new Object[]{e2.toString()}));
                e2.printStackTrace();
            }
        } else {
            f(BitmapFactory.decodeFile(str), str, cVar);
        }
    }
}
