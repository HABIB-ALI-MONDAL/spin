package org.cocos2dx.javascript;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.content.FileProvider;
import c.d.a.b.h.i;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.File;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class PlatformAndroidApi {
    public static String channelex = "";
    public static String channelstr = "";
    public static String constracts = "";
    public static AppActivity context = ((AppActivity) Cocos2dxActivity.getContext());
    public static String firebaseMsgToken = "";
    public static boolean googleService = true;
    public static String openAppUrlDataString = "";

    class a implements c.d.a.b.h.d<String> {
        a() {
        }

        public void a(i<String> iVar) {
            if (iVar.m()) {
                String i = iVar.i();
                PlatformAndroidApi.firebaseMsgToken = i;
                Log.w("FCM", i);
            }
        }
    }

    class b implements c.d.a.b.h.d<Void> {
        b() {
        }

        public void a(i<Void> iVar) {
            Log.d("FCM", !iVar.m() ? "Subscribe failed" : "Subscribed");
        }
    }

    class c implements c.d.a.b.h.d<Void> {
        c() {
        }

        public void a(i<Void> iVar) {
            Log.d("FCM", !iVar.m() ? "unSubscribe failed" : "unSubscribed");
        }
    }

    class d implements Runnable {
        final /* synthetic */ String j;

        d(String str) {
            this.j = str;
        }

        public void run() {
            ((ClipboardManager) PlatformAndroidApi.context.getSystemService("clipboard")).setText(this.j);
        }
    }

    class e implements Runnable {
        final /* synthetic */ String j;

        e(String str) {
            this.j = str;
        }

        public void run() {
            AppActivity appActivity;
            int i;
            if (this.j.equals("portrait")) {
                appActivity = PlatformAndroidApi.context;
                i = 7;
            } else if (this.j.equals("landscape")) {
                appActivity = PlatformAndroidApi.context;
                i = 6;
            } else {
                return;
            }
            appActivity.setRequestedOrientation(i);
        }
    }

    class f implements Runnable {
        final /* synthetic */ String j;

        f(String str) {
            this.j = str;
        }

        public void run() {
            Intent intent = new Intent(PlatformAndroidApi.context, TakePhotoActivity.class);
            intent.putExtra("param", this.j);
            PlatformAndroidApi.context.startActivity(intent);
        }
    }

    class g implements Runnable {
        final /* synthetic */ String j;
        final /* synthetic */ String k;

        g(String str, String str2) {
            this.j = str;
            this.k = str2;
        }

        public void run() {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/*");
            intent.putExtra("android.intent.extra.TEXT", this.j);
            intent.putExtra("android.intent.extra.TITLE", this.k);
            PlatformAndroidApi.context.startActivity(Intent.createChooser(intent, (CharSequence) null));
        }
    }

    public static void ADTrackEvent(String str) {
    }

    public static void FbFriendsInApp() {
    }

    public static void KoTrackEvent(String str) {
    }

    public static boolean OpenFB(String str) {
        return false;
    }

    public static int SaveToAlumb(String str) {
        return ProjUtil.saveToAlumb(str);
    }

    public static int SaveUrlToAlumb(String str) {
        String[] strArr = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        if (androidx.core.content.a.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            androidx.core.app.a.m(context, strArr, 1);
            return 0;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(ProjUtil.getHtmlStream(str));
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append(".jpg");
        return ProjUtil.saveImageToGallery(context, decodeStream, sb.toString()) ? 1 : 0;
    }

    public static void SdkPay(String str) {
    }

    public static void SystemImageShare(String str) {
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                String[] strArr = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
                if (androidx.core.content.a.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    androidx.core.app.a.m(context, strArr, 1);
                    return;
                }
            }
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("imgUrl");
            File saveBitmap = ProjUtil.saveBitmap(context, BitmapFactory.decodeFile(string2), new File(string2).getName(), (String) null, "shareData");
            Uri fileProvider = i >= 24 ? getFileProvider(context, saveBitmap) : Uri.fromFile(saveBitmap);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.STREAM", fileProvider);
            context.startActivity(Intent.createChooser(intent, string));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void callPhone(String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + str));
        context.startActivity(intent);
    }

    public static void clearOpenAppUrlDataString() {
        openAppUrlDataString = "";
    }

    public static void closeSpalsh() {
        AppActivity.hideSplash();
    }

    public static void fbSdkLogin() {
    }

    public static void fbSdkLoginOut() {
    }

    public static void fbSdkShare(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 1;
            if (jSONObject.has("shareWhere")) {
                i = jSONObject.getInt("shareWhere");
            }
            if (i == 3 && ProjUtil.isAppInstall(context, "com.whatsapp")) {
                String string = jSONObject.getString("msgStr");
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", string);
                intent.setType("text/plain");
                intent.setPackage("com.whatsapp");
                context.startActivity(intent);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static String getADTrackId() {
        return "";
    }

    public static String getAPPBundleId() {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.packageName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getAppName() {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            return applicationInfo.loadLabel(context.getPackageManager()) + "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getAppVersion() {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "1.0.0";
        }
    }

    public static String getApplicationLanguage() {
        return "2";
    }

    public static String getChannelExStr() {
        return channelex;
    }

    public static String getChannelstr() {
        return channelstr;
    }

    public static String getContracts() {
        return constracts;
    }

    public static String getDeviceBrand() {
        String deviceBrand = ProjUtil.getDeviceBrand();
        String deviceModel = ProjUtil.getDeviceModel();
        return deviceBrand + "_" + deviceModel;
    }

    public static String getDeviceId() {
        return ProjUtil.getAnroidId();
    }

    public static String getDeviceOpSysVision() {
        return ProjUtil.getSystempVision();
    }

    public static String getFMCToken() {
        return firebaseMsgToken;
    }

    public static Uri getFileProvider(Context context2, File file) {
        return FileProvider.getUriForFile(context2, getAPPBundleId() + ".fileprovider", file);
    }

    public static String getGSFId() {
        return ProjUtil.getGSFID();
    }

    public static String getKoTrackUUID() {
        return "";
    }

    public static String getOpenAppUrlDataString() {
        String str = openAppUrlDataString;
        openAppUrlDataString = "";
        return str;
    }

    public static String getSimOperator() {
        return "";
    }

    public static String getSimacardid() {
        return "";
    }

    @SuppressLint({"NewApi"})
    public static String getTxtFromClipboard() {
        ClipData primaryClip = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip();
        return (primaryClip == null || primaryClip.getItemAt(0) == null) ? "" : primaryClip.getItemAt(0).getText().toString();
    }

    public static void googleInstallReff() {
    }

    public static void googleLogin() {
    }

    public static void gpCheckOwned() {
    }

    public static int isCloner() {
        boolean isCloner = ProjUtil.isCloner(context);
        if (!googleService) {
            return 1;
        }
        return isCloner ? 1 : 0;
    }

    public static int isInstallFB() {
        return 0;
    }

    public static boolean isOpenGPS() {
        return false;
    }

    public static void joinVoiceChannel(String str) {
    }

    public static void levelVoiceChannel() {
    }

    public static void loadAdMobRewardAd() {
    }

    public static void loadReviewComment() {
    }

    public static void loadTradPlusRewardedVideo(String str) {
    }

    public static void openGPSSetting() {
    }

    public static boolean openRating() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getAPPBundleId()));
        intent.addFlags(268435456);
        context.startActivity(intent);
        return true;
    }

    public static void openURL(String str) {
        if (str.length() <= 0) {
            str = "https://www.baidu.com";
        }
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static void packageAppShare(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("packname");
            if (ProjUtil.isAppInstall(context, string)) {
                String string2 = jSONObject.getString("msgStr");
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", string2);
                intent.setType("text/plain");
                intent.setPackage(string);
                context.startActivity(intent);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("packname", string);
            jSONObject2.put("result", "-1");
            JsTool.sendToPlatformApiCbFunc("packageAppShareCall", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void phoneShock(String str) {
        ProjUtil.phoneShock(str);
    }

    public static void queryAllSKU(String str) {
    }

    public static void reGetFMCToken() {
        FirebaseMessaging.f().i().b(new a());
    }

    public static void requestContracts() {
    }

    public static void sendMail(String str) {
        Intent intent;
        AppActivity appActivity;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("sender");
            String string2 = jSONObject.getString("title");
            String string3 = jSONObject.getString("content");
            if ((jSONObject.has("sendway") ? jSONObject.getString("sendway") : "send") == "send") {
                intent = new Intent("android.intent.action.SEND");
                intent.setType("message/rfc822");
            } else {
                intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("mailto:"));
            }
            intent.putExtra("android.intent.extra.EMAIL", new String[]{string});
            intent.putExtra("android.intent.extra.SUBJECT", string2);
            intent.putExtra("android.intent.extra.TEXT", string3);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                appActivity = context;
            } else {
                appActivity = context;
                intent = Intent.createChooser(intent, "");
            }
            appActivity.startActivity(intent);
        } catch (JSONException e2) {
            e2.printStackTrace();
            ProjUtil.showToast("There are no email clients installed.");
        }
    }

    public static void setLocalMute(String str) {
    }

    public static void setOrientation(String str) {
        context.runOnUiThread(new e(str));
    }

    public static void setRemoteMute(String str) {
    }

    @SuppressLint({"NewApi"})
    public static void setTxtToClipboard(String str) {
        context.runOnUiThread(new d(str));
    }

    public static void showTradPlusRewardedVideo(String str) {
    }

    public static void subscribeFCMTopic(String str) {
        FirebaseMessaging.f().F(str).b(new b());
    }

    public static void systemShare(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("title");
            context.runOnUiThread(new g(jSONObject.getString("content"), string));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void takePhoto(String str) {
        context.runOnUiThread(new f(str));
    }

    public static void unsubscribeFCMTopic(String str) {
        FirebaseMessaging.f().I(str).b(new c());
    }
}
