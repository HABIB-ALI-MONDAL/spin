package org.cocos2dx.javascript;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.provider.Settings;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxJavascriptJavaBridge;
import org.json.JSONException;
import org.json.JSONObject;

public class ProjUtil {
    public static AppActivity context = ((AppActivity) Cocos2dxActivity.getContext());

    class a implements Runnable {
        final /* synthetic */ String j;
        final /* synthetic */ String k;

        a(String str, String str2) {
            this.j = str;
            this.k = str2;
        }

        public void run() {
            Cocos2dxJavascriptJavaBridge.evalString(this.j + "(" + this.k + ")");
        }
    }

    class b implements Runnable {
        final /* synthetic */ String j;

        b(String str) {
            this.j = str;
        }

        public void run() {
            Toast.makeText(ProjUtil.context, this.j, 1).show();
        }
    }

    public static void callJS(String str) {
        callJS(str, new JSONObject());
    }

    public static void callJS(String str, JSONObject jSONObject) {
        callJS(str, jSONObject, "cc.vv.PlatformApiMgr.trigerCallback");
    }

    public static void callJS(String str, JSONObject jSONObject, String str2) {
        if (str != null && jSONObject != null && str2 != null) {
            try {
                jSONObject.put("cbName", str);
                context.runOnGLThread(new a(str2, jSONObject.toString()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String getAnroidId() {
        return Settings.System.getString(context.getContentResolver(), "android_id");
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getGSFID() {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.google.android.gsf.gservices"), (String[]) null, (String) null, new String[]{"android_id"}, (String) null);
        if (query.moveToFirst() && query.getColumnCount() >= 2) {
            try {
                return Long.toHexString(Long.parseLong(query.getString(1)));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static byte[] getHtmlByteArray(String str) {
        return inputStreamToByte(getHtmlStream(str));
    }

    public static InputStream getHtmlStream(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection.getResponseCode() == 200) {
                return httpURLConnection.getInputStream();
            }
            return null;
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String getPackagePath(Context context2) {
        if (context2 != null) {
            return context2.getPackageCodePath();
        }
        return null;
    }

    private static String getRealPathFromURI(Uri uri, Context context2) {
        Cursor query = context2.getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
        query.moveToFirst();
        String string = query.getString(columnIndexOrThrow);
        query.close();
        return string;
    }

    public static String getSystempVision() {
        return Build.VERSION.RELEASE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0030 A[SYNTHETIC, Splitter:B:18:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0038 A[SYNTHETIC, Splitter:B:24:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String imageToBase64(java.lang.String r3) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            int r3 = r0.available()     // Catch:{ Exception -> 0x0025 }
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0025 }
            r0.read(r3)     // Catch:{ Exception -> 0x0025 }
            r2 = 16
            java.lang.String r1 = android.util.Base64.encodeToString(r3, r2)     // Catch:{ Exception -> 0x0025 }
            r0.close()     // Catch:{ IOException -> 0x0020 }
            goto L_0x0033
        L_0x0020:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x0033
        L_0x0025:
            r3 = move-exception
            goto L_0x002b
        L_0x0027:
            r3 = move-exception
            goto L_0x0036
        L_0x0029:
            r3 = move-exception
            r0 = r1
        L_0x002b:
            r3.printStackTrace()     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0033
            r0.close()     // Catch:{ IOException -> 0x0020 }
        L_0x0033:
            return r1
        L_0x0034:
            r3 = move-exception
            r1 = r0
        L_0x0036:
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0040:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.javascript.ProjUtil.imageToBase64(java.lang.String):java.lang.String");
    }

    public static byte[] inputStreamToByte(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean isAppInstall(Context context2, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context2.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean isCloner(Context context2) {
        try {
            String str = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).applicationInfo.packageName;
            String absolutePath = context2.getFilesDir().getAbsolutePath();
            String str2 = "/data/data/" + str + "/files";
            StringBuilder sb = new StringBuilder();
            sb.append("/data/user/0/");
            sb.append(str);
            sb.append("/files");
            return !str2.equals(absolutePath) && !sb.toString().equals(absolutePath);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static JSONObject map2json(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            jSONObject.put((String) next.getKey(), (String) next.getValue());
        }
        return jSONObject;
    }

    public static void phoneShock(String str) {
        ((Vibrator) context.getSystemService("vibrator")).vibrate((long) Integer.parseInt(str));
    }

    public static String readApk(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            byte[] bArr = new byte[2];
            long length = randomAccessFile.length() - ((long) 2);
            randomAccessFile.seek(length);
            randomAccessFile.readFully(bArr);
            int stream2Short = stream2Short(bArr, 0);
            byte[] bArr2 = new byte[stream2Short];
            randomAccessFile.seek(length - ((long) stream2Short));
            randomAccessFile.readFully(bArr2);
            return new String(bArr2, "utf-8");
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static File saveBitmap(Context context2, Bitmap bitmap, String str, String str2, String str3) {
        File file = new File(Build.VERSION.SDK_INT >= 29 ? context2.getExternalFilesDir(str2) : Environment.getExternalStorageDirectory(), str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return file2;
    }

    public static boolean saveImageToGallery(Context context2, Bitmap bitmap, String str) {
        try {
            savePhotoToMedia(context2, saveBitmap(context2, bitmap, str, Environment.DIRECTORY_PICTURES, "myQrcode"), str);
            return true;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void savePhotoToMedia(Context context2, File file, String str) {
        updatePhotoMedia(new File(getRealPathFromURI(Uri.parse(MediaStore.Images.Media.insertImage(context2.getContentResolver(), file.getAbsolutePath(), str, (String) null)), context2)), context2);
    }

    public static int saveToAlumb(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append(".jpg");
        return saveImageToGallery(context, decodeFile, sb.toString()) ? 1 : 0;
    }

    private static byte[] short2Stream(short s) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putShort(s);
        allocate.flip();
        return allocate.array();
    }

    public static void showToast(String str) {
        context.runOnUiThread(new b(str));
    }

    private static short stream2Short(byte[] bArr, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(bArr[i]);
        allocate.put(bArr[i + 1]);
        return allocate.getShort(0);
    }

    private static void updatePhotoMedia(File file, Context context2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context2.sendBroadcast(intent);
    }
}
