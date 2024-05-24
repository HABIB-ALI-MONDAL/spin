package org.cocos2dx.javascript;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import androidx.core.content.a;
import f.a.a.b.b;
import f.a.a.c.a;
import f.a.a.d.a;
import f.a.a.d.h;
import f.a.a.d.j;
import f.a.a.d.k;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class TakePhotoActivity extends b {
    private static String[] PERMISSIONS_STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String TAG = "TAKEPHOTO";
    private static int configCrop = 1;
    private static int configFrom;
    private static int configHeight;
    private static int configSize;
    private static int configWidth;

    private boolean checkSelfPermission(String str, int i) {
        Log.i(TAG, "checkSelfPermission " + str + " " + i);
        if (a.a(this, str) == 0) {
            return true;
        }
        androidx.core.app.a.m(this, PERMISSIONS_STORAGE, i);
        return false;
    }

    private void configCompress(f.a.a.b.a aVar) {
        int i = configSize;
        int i2 = configWidth;
        int i3 = configHeight;
        a.b bVar = new a.b();
        bVar.d(i);
        if (i2 < i3) {
            i2 = i3;
        }
        bVar.c(i2);
        bVar.b(true);
        aVar.e(bVar.a(), true);
    }

    private void configTakePhotoOption(f.a.a.b.a aVar) {
        k.b bVar = new k.b();
        bVar.b(true);
        aVar.c(bVar.a());
    }

    private f.a.a.d.a getCropOptions() {
        int i = configHeight;
        int i2 = configWidth;
        Log.d("Crop_W:", "" + i2);
        Log.d("Crop_H:", "" + i);
        a.b bVar = new a.b();
        bVar.b(i2);
        bVar.c(i);
        bVar.d(true);
        return bVar.a();
    }

    private void sendActionResult(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
            if (!str.isEmpty()) {
                jSONObject.put("data", str);
            }
        } catch (JSONException unused) {
        }
        ProjUtil.callJS("TakePhotoCallback", jSONObject);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            JSONObject jSONObject = new JSONObject((String) getIntent().getSerializableExtra("param"));
            configHeight = Integer.parseInt(jSONObject.getString("height"));
            configWidth = Integer.parseInt(jSONObject.getString("width"));
            configSize = Integer.parseInt(jSONObject.getString("size"));
            configFrom = Integer.parseInt(jSONObject.getString("from"));
            if (jSONObject.has("crop")) {
                configCrop = Integer.parseInt(jSONObject.getString("crop"));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE", 1)) {
            showPhoto();
        } else {
            Log.d(TAG, "Premission");
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Log.i(TAG, "onRequestPermissionsResult " + iArr[0] + " " + i);
        if (i == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                sendActionResult(-1, "PERMISSION");
                finish();
                return;
            }
            showPhoto();
        }
    }

    public void showPhoto() {
        f.a.a.b.a takePhoto = getTakePhoto();
        File externalFilesDir = Build.VERSION.SDK_INT >= 29 ? getExternalFilesDir(Environment.DIRECTORY_PICTURES) : Environment.getExternalStorageDirectory();
        File file = new File(externalFilesDir, "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri fromFile = Uri.fromFile(file);
        configCompress(takePhoto);
        configTakePhotoOption(takePhoto);
        if (configFrom == 1) {
            if (configCrop == 0) {
                takePhoto.b(fromFile);
            } else {
                takePhoto.a(fromFile, getCropOptions());
            }
        } else if (configCrop == 0) {
            takePhoto.g();
        } else {
            takePhoto.d(fromFile, getCropOptions());
        }
    }

    public void takeCancel() {
        super.takeCancel();
        sendActionResult(-1, "");
        finish();
    }

    public void takeFail(j jVar, String str) {
        super.takeFail(jVar, str);
        sendActionResult(0, "");
        finish();
    }

    public void takeSuccess(j jVar) {
        super.takeSuccess(jVar);
        h a2 = jVar.a();
        sendActionResult(1, ProjUtil.imageToBase64(a2.c() ? a2.a() : a2.b()));
        finish();
    }
}
