package com.soundcloud.android.crop;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.soundcloud.android.crop.d;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;

public class CropImageActivity extends f {
    /* access modifiers changed from: private */
    public final Handler k = new Handler();
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private Uri r;
    private Uri s;
    private boolean t;
    private int u;
    /* access modifiers changed from: private */
    public l v;
    /* access modifiers changed from: private */
    public CropImageView w;
    /* access modifiers changed from: private */
    public c x;

    class a implements d.c {
        a(CropImageActivity cropImageActivity) {
        }

        public void a(Bitmap bitmap) {
            bitmap.recycle();
            System.gc();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            CropImageActivity.this.setResult(0);
            CropImageActivity.this.finish();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            CropImageActivity.this.s();
        }
    }

    class d implements Runnable {

        class a implements Runnable {
            final /* synthetic */ CountDownLatch j;

            a(CountDownLatch countDownLatch) {
                this.j = countDownLatch;
            }

            public void run() {
                if (CropImageActivity.this.w.getScale() == 1.0f) {
                    CropImageActivity.this.w.b();
                }
                this.j.countDown();
            }
        }

        d() {
        }

        public void run() {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            CropImageActivity.this.k.post(new a(countDownLatch));
            try {
                countDownLatch.await();
                new g(CropImageActivity.this, (a) null).b();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    class e implements Runnable {
        final /* synthetic */ Bitmap j;

        e(Bitmap bitmap) {
            this.j = bitmap;
        }

        public void run() {
            CropImageActivity.this.u(this.j);
        }
    }

    class f implements Runnable {
        final /* synthetic */ Bitmap j;

        f(Bitmap bitmap) {
            this.j = bitmap;
        }

        public void run() {
            CropImageActivity.this.w.e();
            this.j.recycle();
        }
    }

    private class g {

        class a implements Runnable {
            a() {
            }

            public void run() {
                g.this.c();
                CropImageActivity.this.w.invalidate();
                if (CropImageActivity.this.w.u.size() == 1) {
                    CropImageActivity cropImageActivity = CropImageActivity.this;
                    c unused = cropImageActivity.x = cropImageActivity.w.u.get(0);
                    CropImageActivity.this.x.q(true);
                }
            }
        }

        private g() {
        }

        /* synthetic */ g(CropImageActivity cropImageActivity, a aVar) {
            this();
        }

        /* access modifiers changed from: private */
        public void c() {
            int i;
            if (CropImageActivity.this.v != null) {
                c cVar = new c(CropImageActivity.this.w);
                int e2 = CropImageActivity.this.v.e();
                int b2 = CropImageActivity.this.v.b();
                boolean z = false;
                Rect rect = new Rect(0, 0, e2, b2);
                int min = (Math.min(e2, b2) * 4) / 5;
                if (CropImageActivity.this.l == 0 || CropImageActivity.this.m == 0) {
                    i = min;
                } else if (CropImageActivity.this.l > CropImageActivity.this.m) {
                    i = (CropImageActivity.this.m * min) / CropImageActivity.this.l;
                } else {
                    i = min;
                    min = (CropImageActivity.this.l * min) / CropImageActivity.this.m;
                }
                int i2 = (e2 - min) / 2;
                int i3 = (b2 - i) / 2;
                RectF rectF = new RectF((float) i2, (float) i3, (float) (i2 + min), (float) (i3 + i));
                Matrix unrotatedMatrix = CropImageActivity.this.w.getUnrotatedMatrix();
                if (!(CropImageActivity.this.l == 0 || CropImageActivity.this.m == 0)) {
                    z = true;
                }
                cVar.s(unrotatedMatrix, rect, rectF, z);
                CropImageActivity.this.w.r(cVar);
            }
        }

        public void b() {
            CropImageActivity.this.k.post(new a());
        }
    }

    private int l(Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i = 1;
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            InputStream openInputStream = getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
                b.a(openInputStream);
                int o2 = o();
                while (true) {
                    if (options.outHeight / i <= o2 && options.outWidth / i <= o2) {
                        return i;
                    }
                    i <<= 1;
                }
            } catch (Throwable th) {
                th = th;
                inputStream = openInputStream;
                b.a(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            b.a(inputStream);
            throw th;
        }
    }

    private void m() {
        this.w.e();
        l lVar = this.v;
        if (lVar != null) {
            lVar.g();
        }
        System.gc();
    }

    private Bitmap n(Rect rect, int i, int i2) {
        IOException iOException;
        Bitmap bitmap;
        Bitmap bitmap2;
        OutOfMemoryError outOfMemoryError;
        OutOfMemoryError outOfMemoryError2;
        int width;
        int height;
        Rect rect2;
        int i3 = i;
        int i4 = i2;
        m();
        InputStream inputStream = null;
        try {
            InputStream openInputStream = getContentResolver().openInputStream(this.r);
            try {
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(openInputStream, false);
                width = newInstance.getWidth();
                height = newInstance.getHeight();
                if (this.p != 0) {
                    Matrix matrix = new Matrix();
                    matrix.setRotate((float) (-this.p));
                    RectF rectF = new RectF();
                    matrix.mapRect(rectF, new RectF(rect));
                    float f2 = 0.0f;
                    float f3 = rectF.left < 0.0f ? (float) width : 0.0f;
                    if (rectF.top < 0.0f) {
                        f2 = (float) height;
                    }
                    rectF.offset(f3, f2);
                    rect2 = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                } else {
                    rect2 = rect;
                }
                Bitmap decodeRegion = newInstance.decodeRegion(rect2, new BitmapFactory.Options());
                if (decodeRegion != null && (rect2.width() > i3 || rect2.height() > i4)) {
                    Matrix matrix2 = new Matrix();
                    matrix2.postScale(((float) i3) / ((float) rect2.width()), ((float) i4) / ((float) rect2.height()));
                    decodeRegion = Bitmap.createBitmap(decodeRegion, 0, 0, decodeRegion.getWidth(), decodeRegion.getHeight(), matrix2, true);
                }
                b.a(openInputStream);
                return decodeRegion;
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Rectangle " + rect2 + " is outside of the image (" + width + "," + height + "," + this.p + ")", e2);
            } catch (IOException e3) {
                iOException = e3;
                bitmap2 = null;
                inputStream = openInputStream;
                e.a("Error cropping image: " + iOException.getMessage(), iOException);
                outOfMemoryError = iOException;
                v(outOfMemoryError);
                b.a(inputStream);
                return bitmap;
            } catch (OutOfMemoryError e4) {
                outOfMemoryError2 = e4;
                bitmap = null;
                inputStream = openInputStream;
                e.a("OOM cropping image: " + outOfMemoryError2.getMessage(), outOfMemoryError2);
                outOfMemoryError = outOfMemoryError2;
                v(outOfMemoryError);
                b.a(inputStream);
                return bitmap;
            } catch (Throwable th) {
                th = th;
                inputStream = openInputStream;
                b.a(inputStream);
                throw th;
            }
        } catch (IOException e5) {
            iOException = e5;
            bitmap2 = null;
            e.a("Error cropping image: " + iOException.getMessage(), iOException);
            outOfMemoryError = iOException;
            v(outOfMemoryError);
            b.a(inputStream);
            return bitmap;
        } catch (OutOfMemoryError e6) {
            outOfMemoryError2 = e6;
            bitmap = null;
            e.a("OOM cropping image: " + outOfMemoryError2.getMessage(), outOfMemoryError2);
            outOfMemoryError = outOfMemoryError2;
            v(outOfMemoryError);
            b.a(inputStream);
            return bitmap;
        } catch (Throwable th2) {
            th = th2;
            b.a(inputStream);
            throw th;
        }
    }

    private int o() {
        int p2 = p();
        if (p2 == 0) {
            return 2048;
        }
        return Math.min(p2, 4096);
    }

    private int p() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        return iArr[0];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.io.IOException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.io.IOException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.OutOfMemoryError} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: android.net.Uri} */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v21 */
    /* JADX WARNING: type inference failed for: r1v22 */
    /* JADX WARNING: type inference failed for: r1v28 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r() {
        /*
            r5 = this;
            android.content.Intent r0 = r5.getIntent()
            android.os.Bundle r1 = r0.getExtras()
            if (r1 == 0) goto L_0x003d
            java.lang.String r2 = "aspect_x"
            int r2 = r1.getInt(r2)
            r5.l = r2
            java.lang.String r2 = "aspect_y"
            int r2 = r1.getInt(r2)
            r5.m = r2
            java.lang.String r2 = "max_x"
            int r2 = r1.getInt(r2)
            r5.n = r2
            java.lang.String r2 = "max_y"
            int r2 = r1.getInt(r2)
            r5.o = r2
            r2 = 0
            java.lang.String r3 = "as_png"
            boolean r2 = r1.getBoolean(r3, r2)
            r5.q = r2
            java.lang.String r2 = "output"
            android.os.Parcelable r1 = r1.getParcelable(r2)
            android.net.Uri r1 = (android.net.Uri) r1
            r5.s = r1
        L_0x003d:
            android.net.Uri r0 = r0.getData()
            r5.r = r0
            if (r0 == 0) goto L_0x00cd
            android.content.ContentResolver r0 = r5.getContentResolver()
            android.net.Uri r1 = r5.r
            java.io.File r0 = com.soundcloud.android.crop.b.d(r5, r0, r1)
            int r0 = com.soundcloud.android.crop.b.c(r0)
            r5.p = r0
            r0 = 0
            android.net.Uri r1 = r5.r     // Catch:{ IOException -> 0x00a5, OutOfMemoryError -> 0x0088, all -> 0x0083 }
            int r1 = r5.l(r1)     // Catch:{ IOException -> 0x00a5, OutOfMemoryError -> 0x0088, all -> 0x0083 }
            r5.u = r1     // Catch:{ IOException -> 0x00a5, OutOfMemoryError -> 0x0088, all -> 0x0083 }
            android.content.ContentResolver r1 = r5.getContentResolver()     // Catch:{ IOException -> 0x00a5, OutOfMemoryError -> 0x0088, all -> 0x0083 }
            android.net.Uri r2 = r5.r     // Catch:{ IOException -> 0x00a5, OutOfMemoryError -> 0x0088, all -> 0x0083 }
            java.io.InputStream r1 = r1.openInputStream(r2)     // Catch:{ IOException -> 0x00a5, OutOfMemoryError -> 0x0088, all -> 0x0083 }
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x0081, OutOfMemoryError -> 0x007f }
            r2.<init>()     // Catch:{ IOException -> 0x0081, OutOfMemoryError -> 0x007f }
            int r3 = r5.u     // Catch:{ IOException -> 0x0081, OutOfMemoryError -> 0x007f }
            r2.inSampleSize = r3     // Catch:{ IOException -> 0x0081, OutOfMemoryError -> 0x007f }
            com.soundcloud.android.crop.l r3 = new com.soundcloud.android.crop.l     // Catch:{ IOException -> 0x0081, OutOfMemoryError -> 0x007f }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch:{ IOException -> 0x0081, OutOfMemoryError -> 0x007f }
            int r2 = r5.p     // Catch:{ IOException -> 0x0081, OutOfMemoryError -> 0x007f }
            r3.<init>(r0, r2)     // Catch:{ IOException -> 0x0081, OutOfMemoryError -> 0x007f }
            r5.v = r3     // Catch:{ IOException -> 0x0081, OutOfMemoryError -> 0x007f }
            goto L_0x00c4
        L_0x007f:
            r0 = move-exception
            goto L_0x008c
        L_0x0081:
            r0 = move-exception
            goto L_0x00a9
        L_0x0083:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x00c9
        L_0x0088:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x008c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
            r2.<init>()     // Catch:{ all -> 0x00c8 }
            java.lang.String r3 = "OOM reading image: "
            r2.append(r3)     // Catch:{ all -> 0x00c8 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x00c8 }
            r2.append(r3)     // Catch:{ all -> 0x00c8 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c8 }
            com.soundcloud.android.crop.e.a(r2, r0)     // Catch:{ all -> 0x00c8 }
            goto L_0x00c1
        L_0x00a5:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x00a9:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
            r2.<init>()     // Catch:{ all -> 0x00c8 }
            java.lang.String r3 = "Error reading image: "
            r2.append(r3)     // Catch:{ all -> 0x00c8 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x00c8 }
            r2.append(r3)     // Catch:{ all -> 0x00c8 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c8 }
            com.soundcloud.android.crop.e.a(r2, r0)     // Catch:{ all -> 0x00c8 }
        L_0x00c1:
            r5.v(r0)     // Catch:{ all -> 0x00c8 }
        L_0x00c4:
            com.soundcloud.android.crop.b.a(r1)
            goto L_0x00cd
        L_0x00c8:
            r0 = move-exception
        L_0x00c9:
            com.soundcloud.android.crop.b.a(r1)
            throw r0
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soundcloud.android.crop.CropImageActivity.r():void");
    }

    /* access modifiers changed from: private */
    public void s() {
        int i;
        c cVar = this.x;
        if (cVar != null && !this.t) {
            this.t = true;
            Rect i2 = cVar.i((float) this.u);
            int width = i2.width();
            int height = i2.height();
            int i3 = this.n;
            if (i3 > 0 && (i = this.o) > 0 && (width > i3 || height > i)) {
                float f2 = ((float) width) / ((float) height);
                if (((float) i3) / ((float) i) > f2) {
                    width = (int) ((((float) i) * f2) + 0.5f);
                    height = i;
                } else {
                    height = (int) ((((float) i3) / f2) + 0.5f);
                    width = i3;
                }
            }
            try {
                Bitmap n2 = n(i2, width, height);
                if (n2 != null) {
                    this.w.n(new l(n2, this.p), true);
                    this.w.b();
                    this.w.u.clear();
                }
                t(n2);
            } catch (IllegalArgumentException e2) {
                v(e2);
                finish();
            }
        }
    }

    private void t(Bitmap bitmap) {
        if (bitmap != null) {
            b.g(this, (String) null, getResources().getString(j.crop__saving), new e(bitmap), this.k);
        } else {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void u(Bitmap bitmap) {
        if (this.s != null) {
            OutputStream outputStream = null;
            try {
                outputStream = getContentResolver().openOutputStream(this.s);
                if (outputStream != null) {
                    bitmap.compress(this.q ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 90, outputStream);
                }
            } catch (IOException e2) {
                v(e2);
                e.a("Cannot open file: " + this.s, e2);
            } catch (Throwable th) {
                b.a((Closeable) null);
                throw th;
            }
            b.a(outputStream);
            b.b(b.d(this, getContentResolver(), this.r), b.d(this, getContentResolver(), this.s));
            w(this.s);
        }
        this.k.post(new f(bitmap));
        finish();
    }

    private void v(Throwable th) {
        setResult(404, new Intent().putExtra("error", th));
    }

    private void w(Uri uri) {
        setResult(-1, new Intent().putExtra("output", uri));
    }

    private void x() {
        setContentView(i.crop__activity_crop);
        CropImageView cropImageView = (CropImageView) findViewById(h.crop_image);
        this.w = cropImageView;
        cropImageView.w = this;
        cropImageView.setRecycler(new a(this));
        findViewById(h.btn_cancel).setOnClickListener(new b());
        findViewById(h.btn_done).setOnClickListener(new c());
    }

    @TargetApi(19)
    private void y() {
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().clearFlags(67108864);
        }
    }

    private void z() {
        if (!isFinishing()) {
            this.w.n(this.v, true);
            b.g(this, (String) null, getResources().getString(j.crop__wait), new d(), this.k);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y();
        x();
        r();
        if (this.v == null) {
            finish();
        } else {
            z();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        l lVar = this.v;
        if (lVar != null) {
            lVar.g();
        }
    }

    public boolean onSearchRequested() {
        return false;
    }

    public boolean q() {
        return this.t;
    }
}
