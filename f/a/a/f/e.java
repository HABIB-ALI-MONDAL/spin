package f.a.a.f;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import f.a.a.a;
import f.a.a.d.f;
import f.a.a.d.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3122a = b.class.getName();

    public static boolean a(Context context, String str) {
        boolean z = !TextUtils.isEmpty(str) && ".jpg|.gif|.png|.bmp|.jpeg|.webp|".contains(str.toLowerCase());
        if (!z) {
            Toast.makeText(context, context.getResources().getText(a.tip_type_not_image), 0).show();
        }
        return z;
    }

    public static String b(Activity activity, Uri uri) {
        String str;
        if ("content".equals(uri.getScheme())) {
            str = MimeTypeMap.getSingleton().getExtensionFromMimeType(activity.getContentResolver().getType(uri));
            if (TextUtils.isEmpty(str)) {
                str = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
            }
        } else {
            str = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
            if (TextUtils.isEmpty(str)) {
                str = MimeTypeMap.getSingleton().getExtensionFromMimeType(activity.getContentResolver().getType(uri));
            }
        }
        return TextUtils.isEmpty(str) ? c(f.d(uri, activity).getName()) : str;
    }

    public static String c(String str) {
        return str.substring(str.lastIndexOf("."), str.length());
    }

    public static File d(Activity activity, Uri uri) {
        String b2 = b(activity, uri);
        if (a(activity, b2)) {
            File externalFilesDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            return new File(externalFilesDir, UUID.randomUUID().toString() + "." + b2);
        }
        throw new f(g.TYPE_NOT_IMAGE);
    }

    public static void e(InputStream inputStream, File file) {
        if (file != null) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            try {
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                                inputStream.close();
                                return;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    try {
                        String str = f3122a;
                        Log.e(str, "InputStream 写入文件出错:" + e.toString());
                        throw new f(g.TYPE_WRITE_FAIL);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                String str2 = f3122a;
                Log.e(str2, "InputStream 写入文件出错:" + e.toString());
                throw new f(g.TYPE_WRITE_FAIL);
            }
        } else {
            Log.i(f3122a, "inputStreamToFile:file not be null");
            throw new f(g.TYPE_WRITE_FAIL);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040 A[SYNTHETIC, Splitter:B:17:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f A[SYNTHETIC, Splitter:B:23:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f(android.graphics.Bitmap r3, android.net.Uri r4) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.io.File r0 = new java.io.File
            java.lang.String r4 = r4.getPath()
            r0.<init>(r4)
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
            r2 = 100
            r3.compress(r1, r2, r4)
            r3 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0038, all -> 0x0034 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0038, all -> 0x0034 }
            byte[] r3 = r4.toByteArray()     // Catch:{ IOException -> 0x0032 }
            r1.write(r3)     // Catch:{ IOException -> 0x0032 }
            r4.flush()     // Catch:{ IOException -> 0x0032 }
            r1.flush()     // Catch:{ IOException -> 0x0032 }
            r1.close()     // Catch:{ IOException -> 0x0047 }
            r4.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004b
        L_0x0032:
            r3 = move-exception
            goto L_0x003b
        L_0x0034:
            r0 = move-exception
            r1 = r3
            r3 = r0
            goto L_0x004d
        L_0x0038:
            r0 = move-exception
            r1 = r3
            r3 = r0
        L_0x003b:
            r3.printStackTrace()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x004b
            r1.close()     // Catch:{ IOException -> 0x0047 }
            r4.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r3 = move-exception
            r3.printStackTrace()
        L_0x004b:
            return
        L_0x004c:
            r3 = move-exception
        L_0x004d:
            if (r1 == 0) goto L_0x005a
            r1.close()     // Catch:{ IOException -> 0x0056 }
            r4.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r4 = move-exception
            r4.printStackTrace()
        L_0x005a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: f.a.a.f.e.f(android.graphics.Bitmap, android.net.Uri):void");
    }
}
