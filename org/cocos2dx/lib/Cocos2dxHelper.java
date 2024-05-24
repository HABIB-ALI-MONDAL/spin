package org.cocos2dx.lib;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import org.cocos2dx.lib.Cocos2dxAccelerometer;

public class Cocos2dxHelper {
    public static final int NETWORK_TYPE_LAN = 1;
    public static final int NETWORK_TYPE_NONE = 0;
    public static final int NETWORK_TYPE_WWAN = 2;
    private static final String PREFS_NAME = "Cocos2dxPrefsFile";
    private static final int RUNNABLES_PER_FRAME = 5;
    private static final String TAG = "Cocos2dxHelper";
    private static Set<PreferenceManager.OnActivityResultListener> onActivityResultListeners = new LinkedHashSet();
    private static boolean sAccelerometerEnabled;
    /* access modifiers changed from: private */
    public static Activity sActivity;
    private static boolean sActivityVisible;
    private static AssetManager sAssetManager;
    private static String sAssetsPath = "";
    private static c sBatteryReceiver = new c();
    private static Cocos2dxAccelerometer sCocos2dxAccelerometer;
    private static Cocos2dxHelperListener sCocos2dxHelperListener;
    private static boolean sCompassEnabled;
    private static float[] sDeviceMotionValues = new float[9];
    private static String sFileDirectory;
    private static boolean sInited = false;
    private static c.a.a.a.a.b sOBBFile = null;
    private static OnGameInfoUpdatedListener sOnGameInfoUpdatedListener;
    private static String sPackageName;
    private static Vibrator sVibrateService = null;

    public interface Cocos2dxHelperListener {
        void runOnGLThread(Runnable runnable);

        void showDialog(String str, String str2);
    }

    public interface OnGameInfoUpdatedListener {
        void onDisableBatchGLCommandsToNative();

        void onFPSUpdated(float f2);

        void onGameInfoUpdated_0(String str);

        void onGameInfoUpdated_1(String str);

        void onGameInfoUpdated_2(String str);

        void onJSBInvocationCountUpdated(int i);

        void onOpenDebugView();
    }

    class a implements Runnable {
        final /* synthetic */ String j;

        a(String str) {
            this.j = str;
        }

        public void run() {
            ((ClipboardManager) Cocos2dxHelper.sActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", this.j));
        }
    }

    class b implements Runnable {
        final /* synthetic */ byte[] j;

        b(byte[] bArr) {
            this.j = bArr;
        }

        public void run() {
            Cocos2dxHelper.nativeSetEditTextDialogResult(this.j);
        }
    }

    static class c extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public float f3145a = 0.0f;

        c() {
        }

        public void a(Intent intent) {
            if (intent != null) {
                this.f3145a = Math.min(Math.max((((float) intent.getIntExtra("level", 0)) * 1.0f) / ((float) intent.getIntExtra("scale", 1)), 0.0f), 1.0f);
            }
        }

        public void onReceive(Context context, Intent intent) {
            a(intent);
        }
    }

    public static void addOnActivityResultListener(PreferenceManager.OnActivityResultListener onActivityResultListener) {
        onActivityResultListeners.add(onActivityResultListener);
    }

    public static byte[] conversionEncoding(byte[] bArr, String str, String str2) {
        try {
            return new String(bArr, str).getBytes(str2);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void copyTextToClipboard(String str) {
        sActivity.runOnUiThread(new a(str));
    }

    public static void disableAccelerometer() {
        sAccelerometerEnabled = false;
        sCocos2dxAccelerometer.disable();
    }

    private static void disableBatchGLCommandsToNative() {
        OnGameInfoUpdatedListener onGameInfoUpdatedListener = sOnGameInfoUpdatedListener;
        if (onGameInfoUpdatedListener != null) {
            onGameInfoUpdatedListener.onDisableBatchGLCommandsToNative();
        }
    }

    public static void enableAccelerometer() {
        sAccelerometerEnabled = true;
        sCocos2dxAccelerometer.enable();
    }

    public static void endApplication() {
        Activity activity = sActivity;
        if (activity != null) {
            activity.finish();
        }
    }

    public static Activity getActivity() {
        return sActivity;
    }

    public static AssetManager getAssetManager() {
        return sAssetManager;
    }

    public static String getAssetsPath() {
        if (sAssetsPath == "") {
            int i = 1;
            try {
                i = sActivity.getPackageManager().getPackageInfo(sPackageName, 0).versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/" + sPackageName + "/main." + i + "." + sPackageName + ".obb";
            if (!new File(str).exists()) {
                str = sActivity.getApplicationInfo().sourceDir;
            }
            sAssetsPath = str;
        }
        return sAssetsPath;
    }

    public static float getBatteryLevel() {
        return sBatteryReceiver.f3145a;
    }

    public static String getCurrentLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getCurrentLanguageCode() {
        return Locale.getDefault().toString();
    }

    public static int getDPI() {
        Display defaultDisplay;
        if (sActivity == null) {
            return -1;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = sActivity.getWindowManager();
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return -1;
        }
        defaultDisplay.getMetrics(displayMetrics);
        return (int) (displayMetrics.density * 160.0f);
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    private static float[] getDeviceMotionValue() {
        Cocos2dxAccelerometer.b deviceMotionEvent = sCocos2dxAccelerometer.getDeviceMotionEvent();
        float[] fArr = sDeviceMotionValues;
        Cocos2dxAccelerometer.a aVar = deviceMotionEvent.f3132a;
        fArr[0] = aVar.f3129a;
        fArr[1] = aVar.f3130b;
        fArr[2] = aVar.f3131c;
        Cocos2dxAccelerometer.a aVar2 = deviceMotionEvent.f3133b;
        fArr[3] = aVar2.f3129a;
        fArr[4] = aVar2.f3130b;
        fArr[5] = aVar2.f3131c;
        Cocos2dxAccelerometer.c cVar = deviceMotionEvent.f3134c;
        fArr[6] = cVar.f3136a;
        fArr[7] = cVar.f3137b;
        fArr[8] = cVar.f3138c;
        return fArr;
    }

    public static int getDeviceRotation() {
        try {
            return ((WindowManager) sActivity.getSystemService("window")).getDefaultDisplay().getRotation();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int getNetworkType() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) sActivity.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                return 2;
            }
            return type == 1 ? 1 : 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static long[] getObbAssetFileDescriptor(String str) {
        AssetFileDescriptor b2;
        String str2;
        String str3;
        long[] jArr = new long[3];
        c.a.a.a.a.b bVar = sOBBFile;
        if (!(bVar == null || (b2 = bVar.b(str)) == null)) {
            try {
                ParcelFileDescriptor parcelFileDescriptor = b2.getParcelFileDescriptor();
                jArr[0] = (long) ((Integer) parcelFileDescriptor.getClass().getMethod("getFd", new Class[0]).invoke(parcelFileDescriptor, new Object[0])).intValue();
                jArr[1] = b2.getStartOffset();
                jArr[2] = b2.getLength();
            } catch (NoSuchMethodException unused) {
                Log.e(TAG, "Accessing file descriptor directly from the OBB is only supported from Android 3.1 (API level 12) and above.");
            } catch (IllegalAccessException e2) {
                str3 = TAG;
                str2 = e2.toString();
                Log.e(str3, str2);
            } catch (InvocationTargetException e3) {
                str3 = TAG;
                str2 = e3.toString();
                Log.e(str3, str2);
            }
        }
        return jArr;
    }

    public static c.a.a.a.a.b getObbFile() {
        return sOBBFile;
    }

    public static Set<PreferenceManager.OnActivityResultListener> getOnActivityResultListeners() {
        return onActivityResultListeners;
    }

    public static OnGameInfoUpdatedListener getOnGameInfoUpdatedListener() {
        return sOnGameInfoUpdatedListener;
    }

    public static String getPackageName() {
        return sPackageName;
    }

    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static float[] getSafeArea() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT >= 28 && (rootWindowInsets = getActivity().getWindow().getDecorView().getRootWindowInsets()) != null) {
            try {
                Object invoke = WindowInsets.class.getMethod("getDisplayCutout", new Class[0]).invoke(rootWindowInsets, new Object[0]);
                if (invoke != null) {
                    Class<?> cls = invoke.getClass();
                    Method method = cls.getMethod("getSafeInsetLeft", new Class[0]);
                    Method method2 = cls.getMethod("getSafeInsetRight", new Class[0]);
                    Method method3 = cls.getMethod("getSafeInsetBottom", new Class[0]);
                    Method method4 = cls.getMethod("getSafeInsetTop", new Class[0]);
                    if (!(method == null || method2 == null || method3 == null || method4 == null)) {
                        int intValue = ((Integer) method.invoke(invoke, new Object[0])).intValue();
                        int intValue2 = ((Integer) method2.invoke(invoke, new Object[0])).intValue();
                        return new float[]{(float) ((Integer) method4.invoke(invoke, new Object[0])).intValue(), (float) intValue, (float) ((Integer) method3.invoke(invoke, new Object[0])).intValue(), (float) intValue2};
                    }
                }
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getVersion() {
        try {
            return Cocos2dxActivity.getContext().getPackageManager().getPackageInfo(Cocos2dxActivity.getContext().getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getWritablePath() {
        return sFileDirectory;
    }

    public static void init(Activity activity) {
        String str;
        Class<String> cls = String.class;
        sActivity = activity;
        sCocos2dxHelperListener = (Cocos2dxHelperListener) activity;
        if (!sInited) {
            boolean hasSystemFeature = activity.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
            String str2 = TAG;
            Log.d(str2, "isSupportLowLatency:" + hasSystemFeature);
            int i = 44100;
            int i2 = 192;
            int i3 = 1;
            if (Build.VERSION.SDK_INT >= 17) {
                AudioManager audioManager = (AudioManager) activity.getSystemService("audio");
                Class cls2 = AudioManager.class;
                Object[] objArr = {Cocos2dxReflectionHelper.getConstantValue(cls2, "PROPERTY_OUTPUT_SAMPLE_RATE")};
                Object[] objArr2 = {Cocos2dxReflectionHelper.getConstantValue(cls2, "PROPERTY_OUTPUT_FRAMES_PER_BUFFER")};
                i = Integer.parseInt((String) Cocos2dxReflectionHelper.invokeInstanceMethod(audioManager, "getProperty", new Class[]{cls}, objArr));
                i2 = Integer.parseInt((String) Cocos2dxReflectionHelper.invokeInstanceMethod(audioManager, "getProperty", new Class[]{cls}, objArr2));
                str = "sampleRate: " + i + ", framesPerBuffer: " + i2;
            } else {
                str = "android version is lower than 17";
            }
            Log.d(str2, str);
            nativeSetAudioDeviceInfo(hasSystemFeature, i, i2);
            sPackageName = activity.getApplicationInfo().packageName;
            sFileDirectory = activity.getFilesDir().getAbsolutePath();
            nativeSetApkPath(getAssetsPath());
            sCocos2dxAccelerometer = new Cocos2dxAccelerometer(activity);
            AssetManager assets = activity.getAssets();
            sAssetManager = assets;
            nativeSetContext(activity, assets);
            sVibrateService = (Vibrator) activity.getSystemService("vibrator");
            sInited = true;
            try {
                i3 = Cocos2dxActivity.getContext().getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            try {
                sOBBFile = c.a.a.a.a.a.b(Cocos2dxActivity.getContext(), i3, 0);
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static boolean isActivityVisible() {
        return sActivityVisible;
    }

    private static native void nativeSetApkPath(String str);

    private static native void nativeSetAudioDeviceInfo(boolean z, int i, int i2);

    private static native void nativeSetContext(Context context, AssetManager assetManager);

    /* access modifiers changed from: private */
    public static native void nativeSetEditTextDialogResult(byte[] bArr);

    public static void onEnterBackground() {
    }

    public static void onEnterForeground() {
    }

    public static void onPause() {
        sActivityVisible = false;
        if (sAccelerometerEnabled) {
            sCocos2dxAccelerometer.disable();
        }
    }

    public static void onResume() {
        sActivityVisible = true;
        if (sAccelerometerEnabled) {
            sCocos2dxAccelerometer.enable();
        }
    }

    private static void openDebugView() {
        OnGameInfoUpdatedListener onGameInfoUpdatedListener = sOnGameInfoUpdatedListener;
        if (onGameInfoUpdatedListener != null) {
            onGameInfoUpdatedListener.onOpenDebugView();
        }
    }

    public static boolean openURL(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            sActivity.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    static void registerBatteryLevelReceiver(Context context) {
        sBatteryReceiver.a(context.registerReceiver(sBatteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED")));
    }

    public static void runOnGLThread(Runnable runnable) {
        ((Cocos2dxActivity) sActivity).runOnGLThread(runnable);
    }

    public static void setAccelerometerInterval(float f2) {
        sCocos2dxAccelerometer.setInterval(f2);
    }

    public static void setEditTextDialogResult(String str) {
        try {
            sCocos2dxHelperListener.runOnGLThread(new b(str.getBytes("UTF8")));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    private static void setGameInfoDebugViewText(int i, String str) {
        OnGameInfoUpdatedListener onGameInfoUpdatedListener = sOnGameInfoUpdatedListener;
        if (onGameInfoUpdatedListener == null) {
            return;
        }
        if (i == 0) {
            onGameInfoUpdatedListener.onGameInfoUpdated_0(str);
        } else if (i == 1) {
            onGameInfoUpdatedListener.onGameInfoUpdated_1(str);
        } else if (i == 2) {
            onGameInfoUpdatedListener.onGameInfoUpdated_2(str);
        }
    }

    private static void setJSBInvocationCount(int i) {
        OnGameInfoUpdatedListener onGameInfoUpdatedListener = sOnGameInfoUpdatedListener;
        if (onGameInfoUpdatedListener != null) {
            onGameInfoUpdatedListener.onJSBInvocationCountUpdated(i);
        }
    }

    public static void setKeepScreenOn(boolean z) {
        ((Cocos2dxActivity) sActivity).setKeepScreenOn(z);
    }

    public static void setOnGameInfoUpdatedListener(OnGameInfoUpdatedListener onGameInfoUpdatedListener) {
        sOnGameInfoUpdatedListener = onGameInfoUpdatedListener;
    }

    private static void showDialog(String str, String str2) {
        sCocos2dxHelperListener.showDialog(str, str2);
    }

    public static void terminateProcess() {
        Process.killProcess(Process.myPid());
    }

    static void unregisterBatteryLevelReceiver(Context context) {
        context.unregisterReceiver(sBatteryReceiver);
    }

    public static void vibrate(float f2) {
        try {
            Vibrator vibrator = sVibrateService;
            if (vibrator != null && vibrator.hasVibrator()) {
                if (Build.VERSION.SDK_INT >= 26) {
                    Class<?> cls = Class.forName("android.os.VibrationEffect");
                    if (cls != null) {
                        int intValue = ((Integer) Cocos2dxReflectionHelper.getConstantValue(cls, "DEFAULT_AMPLITUDE")).intValue();
                        Method method = cls.getMethod("createOneShot", new Class[]{Long.TYPE, Integer.TYPE});
                        Class<?> returnType = method.getReturnType();
                        Object invoke = method.invoke(cls, new Object[]{Long.valueOf((long) (f2 * 1000.0f)), Integer.valueOf(intValue)});
                        Cocos2dxReflectionHelper.invokeInstanceMethod(sVibrateService, "vibrate", new Class[]{returnType}, new Object[]{invoke});
                        return;
                    }
                    return;
                }
                sVibrateService.vibrate((long) (f2 * 1000.0f));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
