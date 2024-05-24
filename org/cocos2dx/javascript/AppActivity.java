package org.cocos2dx.javascript;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import c.e.a.a.g;
import com.google.android.gms.common.e;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;
import org.cocos2dx.lib.R;
import org.json.JSONException;
import org.json.JSONObject;

public class AppActivity extends Cocos2dxActivity {
    private static final int REQUEST_NOTIFY_CODE = 1;
    private static Cocos2dxActivity sCocos2dxActivity;
    /* access modifiers changed from: private */
    public static ImageView sSplashBgImageView;
    Handler handler = new Handler();
    Runnable runnable = new a(this);

    class a implements Runnable {
        a(AppActivity appActivity) {
        }

        public void run() {
            System.exit(0);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            if (AppActivity.sSplashBgImageView != null) {
                AppActivity.sSplashBgImageView.setVisibility(8);
            }
        }
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            String string = getString(R.string.channel_name);
            String string2 = getString(R.string.channel_description);
            NotificationChannel notificationChannel = new NotificationChannel(getString(R.string.default_notification_channel_id), string, 3);
            notificationChannel.setDescription(string2);
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }

    public static void hideSplash() {
        sCocos2dxActivity.runOnUiThread(new b());
    }

    private boolean onCheckGooglePlayService() {
        int g = e.n().g(this);
        if (g == 0) {
            return true;
        }
        e.n().o(this);
        if (e.n().j(g)) {
            Dialog k = e.n().k(this, g, 200);
            k.setCancelable(false);
            k.setCanceledOnTouchOutside(false);
            k.show();
        }
        this.handler.postDelayed(this.runnable, 6000);
        return false;
    }

    private void onOpenAppByUrl(Intent intent) {
        Uri data;
        String query;
        if (intent != null && (data = intent.getData()) != null && (query = data.getQuery()) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (String split : query.split("[&]")) {
                    String[] split2 = split.split("[=]");
                    if (split2.length > 1) {
                        jSONObject.put(split2[0], split2[1]);
                    } else if (split2[0] != "") {
                        jSONObject.put(split2[0], "");
                    }
                }
                PlatformAndroidApi.openAppUrlDataString = jSONObject.toString();
                JsTool.sendToPlatformApiCbFunc("OpenAppUrlLink", jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    private void showActivity(String str) {
        startActivity(getPackageManager().getLaunchIntentForPackage(str));
    }

    private void showActivity(String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.addFlags(268435456);
        startActivity(intent);
    }

    private static void showSplash() {
        ImageView imageView = new ImageView(sCocos2dxActivity);
        sSplashBgImageView = imageView;
        imageView.setBackgroundColor(sCocos2dxActivity.getResources().getColor(R.color.splash_slogan_bg));
        sSplashBgImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        sCocos2dxActivity.addContentView(sSplashBgImageView, new WindowManager.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        SDKWrapper.getInstance().onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        SDKWrapper.getInstance().onBackPressed();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", "Back");
            JsTool.sendToPlatformApiCbFunc("BackPressedCallback", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        SDKWrapper.getInstance().onConfigurationChanged(configuration);
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isTaskRoot()) {
            sCocos2dxActivity = this;
            getWindow().addFlags(128);
            showSplash();
            SDKWrapper.getInstance().init(this);
            c.e.a.a.b b2 = g.b(Cocos2dxActivity.getContext());
            if (b2 != null) {
                PlatformAndroidApi.channelstr = b2.a();
                try {
                    PlatformAndroidApi.channelex = ProjUtil.map2json(b2.b()).toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            onOpenAppByUrl(getIntent());
            PlatformAndroidApi.googleService = onCheckGooglePlayService();
            createNotificationChannel();
            PlatformAndroidApi.reGetFMCToken();
        }
    }

    public Cocos2dxGLSurfaceView onCreateView() {
        Cocos2dxGLSurfaceView cocos2dxGLSurfaceView = new Cocos2dxGLSurfaceView(this);
        cocos2dxGLSurfaceView.setEGLConfigChooser(5, 6, 5, 0, 16, 8);
        SDKWrapper.getInstance().setGLSurfaceView(cocos2dxGLSurfaceView, this);
        return cocos2dxGLSurfaceView;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (isTaskRoot()) {
            SDKWrapper.getInstance().onDestroy();
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SDKWrapper.getInstance().onNewIntent(intent);
        onOpenAppByUrl(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SDKWrapper.getInstance().onPause();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        SDKWrapper.getInstance().onRestart();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        SDKWrapper.getInstance().onRestoreInstanceState(bundle);
        super.onRestoreInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SDKWrapper.getInstance().onResume();
        PlatformAndroidApi.googleService = onCheckGooglePlayService();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        SDKWrapper.getInstance().onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        SDKWrapper.getInstance().onStart();
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        SDKWrapper.getInstance().onStop();
    }
}
