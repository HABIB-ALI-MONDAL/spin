package com.soundcloud.android.crop;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Handler;
import com.soundcloud.android.crop.f;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class b {

    private static class a extends f.a implements Runnable {
        /* access modifiers changed from: private */
        public final f j;
        /* access modifiers changed from: private */
        public final ProgressDialog k;
        private final Runnable l;
        private final Handler m;
        private final Runnable n = new C0079a();

        /* renamed from: com.soundcloud.android.crop.b$a$a  reason: collision with other inner class name */
        class C0079a implements Runnable {
            C0079a() {
            }

            public void run() {
                a.this.j.b(a.this);
                if (a.this.k.getWindow() != null) {
                    a.this.k.dismiss();
                }
            }
        }

        public a(f fVar, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
            this.j = fVar;
            this.k = progressDialog;
            this.l = runnable;
            fVar.a(this);
            this.m = handler;
        }

        public void a(f fVar) {
            this.k.show();
        }

        public void b(f fVar) {
            this.n.run();
            this.m.removeCallbacks(this.n);
        }

        public void d(f fVar) {
            this.k.hide();
        }

        public void run() {
            try {
                this.l.run();
            } finally {
                this.m.post(this.n);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean b(File file, File file2) {
        if (!(file == null || file2 == null)) {
            try {
                ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
                ExifInterface exifInterface2 = new ExifInterface(file2.getAbsolutePath());
                exifInterface2.setAttribute("Orientation", exifInterface.getAttribute("Orientation"));
                exifInterface2.saveAttributes();
                return true;
            } catch (IOException e2) {
                e.a("Error copying Exif data", e2);
            }
        }
        return false;
    }

    public static int c(File file) {
        if (file == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt("Orientation", 0);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e2) {
            e.a("Error getting Exif data", e2);
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
        if (r3 != null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0079, code lost:
        if (r3 != null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007b, code lost:
        r3.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x007f */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File d(android.content.Context r9, android.content.ContentResolver r10, android.net.Uri r11) {
        /*
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = r11.getScheme()
            java.lang.String r2 = "file"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x001a
            java.io.File r9 = new java.io.File
            java.lang.String r10 = r11.getPath()
            r9.<init>(r10)
            return r9
        L_0x001a:
            java.lang.String r1 = r11.getScheme()
            java.lang.String r2 = "content"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x008f
            java.lang.String r1 = "_data"
            java.lang.String r2 = "_display_name"
            java.lang.String[] r5 = new java.lang.String[]{r1, r2}
            r6 = 0
            r7 = 0
            r8 = 0
            r3 = r10
            r4 = r11
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ IllegalArgumentException -> 0x007f, SecurityException -> 0x0078 }
            if (r3 == 0) goto L_0x0073
            boolean r4 = r3.moveToFirst()     // Catch:{ IllegalArgumentException -> 0x0071, SecurityException -> 0x006f, all -> 0x006c }
            if (r4 == 0) goto L_0x0073
            java.lang.String r4 = r11.toString()     // Catch:{ IllegalArgumentException -> 0x0071, SecurityException -> 0x006f, all -> 0x006c }
            java.lang.String r5 = "content://com.google.android.gallery3d"
            boolean r4 = r4.startsWith(r5)     // Catch:{ IllegalArgumentException -> 0x0071, SecurityException -> 0x006f, all -> 0x006c }
            if (r4 == 0) goto L_0x0050
            int r1 = r3.getColumnIndex(r2)     // Catch:{ IllegalArgumentException -> 0x0071, SecurityException -> 0x006f, all -> 0x006c }
            goto L_0x0054
        L_0x0050:
            int r1 = r3.getColumnIndex(r1)     // Catch:{ IllegalArgumentException -> 0x0071, SecurityException -> 0x006f, all -> 0x006c }
        L_0x0054:
            r2 = -1
            if (r1 == r2) goto L_0x0073
            java.lang.String r1 = r3.getString(r1)     // Catch:{ IllegalArgumentException -> 0x0071, SecurityException -> 0x006f, all -> 0x006c }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IllegalArgumentException -> 0x0071, SecurityException -> 0x006f, all -> 0x006c }
            if (r2 != 0) goto L_0x0073
            java.io.File r2 = new java.io.File     // Catch:{ IllegalArgumentException -> 0x0071, SecurityException -> 0x006f, all -> 0x006c }
            r2.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x0071, SecurityException -> 0x006f, all -> 0x006c }
            if (r3 == 0) goto L_0x006b
            r3.close()
        L_0x006b:
            return r2
        L_0x006c:
            r9 = move-exception
            r0 = r3
            goto L_0x0089
        L_0x006f:
            goto L_0x0079
        L_0x0071:
            r0 = r3
            goto L_0x007f
        L_0x0073:
            if (r3 == 0) goto L_0x008f
            goto L_0x007b
        L_0x0076:
            r9 = move-exception
            goto L_0x0089
        L_0x0078:
            r3 = r0
        L_0x0079:
            if (r3 == 0) goto L_0x008f
        L_0x007b:
            r3.close()
            goto L_0x008f
        L_0x007f:
            java.io.File r9 = e(r9, r10, r11)     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0088
            r0.close()
        L_0x0088:
            return r9
        L_0x0089:
            if (r0 == 0) goto L_0x008e
            r0.close()
        L_0x008e:
            throw r9
        L_0x008f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soundcloud.android.crop.b.d(android.content.Context, android.content.ContentResolver, android.net.Uri):java.io.File");
    }

    private static File e(Context context, ContentResolver contentResolver, Uri uri) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        String f2;
        FileInputStream fileInputStream2 = null;
        if (uri == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(contentResolver.openFileDescriptor(uri, "r").getFileDescriptor());
            try {
                f2 = f(context);
                fileOutputStream = new FileOutputStream(f2);
            } catch (IOException unused) {
                fileOutputStream = null;
                a(fileInputStream);
                a(fileOutputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                a(fileInputStream2);
                a(fileOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        File file = new File(f2);
                        a(fileInputStream);
                        a(fileOutputStream);
                        return file;
                    }
                }
            } catch (IOException unused2) {
                a(fileInputStream);
                a(fileOutputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                a(fileInputStream2);
                a(fileOutputStream);
                throw th;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            fileInputStream = null;
            a(fileInputStream);
            a(fileOutputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            a(fileInputStream2);
            a(fileOutputStream);
            throw th;
        }
    }

    private static String f(Context context) {
        return File.createTempFile("image", "tmp", context.getCacheDir()).getAbsolutePath();
    }

    public static void g(f fVar, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new a(fVar, runnable, ProgressDialog.show(fVar, str, str2, true, false), handler)).start();
    }
}
