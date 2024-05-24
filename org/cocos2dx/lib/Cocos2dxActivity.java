package org.cocos2dx.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.reflect.Field;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import org.cocos2dx.lib.Cocos2dxHandler;
import org.cocos2dx.lib.Cocos2dxHelper;

public abstract class Cocos2dxActivity extends Activity implements Cocos2dxHelper.Cocos2dxHelperListener {
    /* access modifiers changed from: private */
    public static final String TAG = Cocos2dxActivity.class.getSimpleName();
    private static Cocos2dxActivity sContext = null;
    private boolean gainAudioFocus = false;
    private boolean hasFocus = false;
    private Cocos2dxEditBox mEditBox = null;
    /* access modifiers changed from: private */
    public TextView mFPSTextView;
    protected FrameLayout mFrameLayout = null;
    private int[] mGLContextAttrs = null;
    /* access modifiers changed from: private */
    public TextView mGLOptModeTextView;
    /* access modifiers changed from: private */
    public Cocos2dxGLSurfaceView mGLSurfaceView = null;
    /* access modifiers changed from: private */
    public TextView mGameInfoTextView_0;
    /* access modifiers changed from: private */
    public TextView mGameInfoTextView_1;
    /* access modifiers changed from: private */
    public TextView mGameInfoTextView_2;
    private Cocos2dxHandler mHandler = null;
    /* access modifiers changed from: private */
    public TextView mJSBInvocationTextView;
    /* access modifiers changed from: private */
    public LinearLayout mLinearLayoutForDebugView;
    private Cocos2dxVideoHelper mVideoHelper = null;
    private Cocos2dxWebViewHelper mWebViewHelper = null;
    private boolean paused = true;

    public class Cocos2dxEGLConfigChooser implements GLSurfaceView.EGLConfigChooser {
        protected int[] configAttribs;

        class a implements Comparable<a> {
            public EGLConfig j = null;
            public int[] k = null;
            public int l = 0;

            public a(Cocos2dxEGLConfigChooser cocos2dxEGLConfigChooser, EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
                this.j = eGLConfig;
                int[] iArr = new int[6];
                this.k = iArr;
                iArr[0] = cocos2dxEGLConfigChooser.findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                this.k[1] = cocos2dxEGLConfigChooser.findConfigAttrib(egl10, eGLDisplay2, eGLConfig2, 12323, 0);
                this.k[2] = cocos2dxEGLConfigChooser.findConfigAttrib(egl10, eGLDisplay2, eGLConfig2, 12322, 0);
                this.k[3] = cocos2dxEGLConfigChooser.findConfigAttrib(egl10, eGLDisplay2, eGLConfig2, 12321, 0);
                this.k[4] = cocos2dxEGLConfigChooser.findConfigAttrib(egl10, eGLDisplay2, eGLConfig2, 12325, 0);
                this.k[5] = cocos2dxEGLConfigChooser.findConfigAttrib(egl10, eGLDisplay2, eGLConfig2, 12326, 0);
                d();
            }

            public a(Cocos2dxEGLConfigChooser cocos2dxEGLConfigChooser, int[] iArr) {
                this.k = iArr;
                d();
            }

            private void d() {
                int[] iArr = this.k;
                if (iArr[4] > 0) {
                    this.l = this.l + 536870912 + ((iArr[4] % 64) << 6);
                }
                if (iArr[5] > 0) {
                    this.l = this.l + 268435456 + (iArr[5] % 64);
                }
                if (iArr[3] > 0) {
                    this.l = this.l + 1073741824 + ((iArr[3] % 16) << 24);
                }
                if (iArr[1] > 0) {
                    this.l += (iArr[1] % 16) << 20;
                }
                if (iArr[2] > 0) {
                    this.l += (iArr[2] % 16) << 16;
                }
                if (iArr[0] > 0) {
                    this.l += (iArr[0] % 16) << 12;
                }
            }

            /* renamed from: e */
            public int compareTo(a aVar) {
                int i = this.l;
                int i2 = aVar.l;
                if (i < i2) {
                    return -1;
                }
                return i > i2 ? 1 : 0;
            }

            public String toString() {
                return "{ color: " + this.k[3] + this.k[2] + this.k[1] + this.k[0] + "; depth: " + this.k[4] + "; stencil: " + this.k[5] + ";}";
            }
        }

        public Cocos2dxEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            this.configAttribs = new int[]{i, i2, i3, i4, i5, i6};
        }

        public Cocos2dxEGLConfigChooser(int[] iArr) {
            this.configAttribs = iArr;
        }

        /* access modifiers changed from: private */
        public int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            int[] iArr = new int[1];
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr) ? iArr[0] : i2;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int i = 0;
            int[] iArr = this.configAttribs;
            int[] iArr2 = {12324, iArr[0], 12323, iArr[1], 12322, iArr[2], 12321, iArr[3], 12325, iArr[4], 12326, iArr[5], 12352, 4, 12344};
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr3 = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, iArr2, eGLConfigArr, 1, iArr3) && iArr3[0] > 0) {
                return eGLConfigArr[0];
            }
            int[] iArr4 = {12352, 4, 12344};
            int[] iArr5 = iArr3;
            if (!egl10.eglChooseConfig(eGLDisplay, iArr4, (EGLConfig[]) null, 0, iArr5) || iArr5[0] <= 0) {
                Log.e("device_policy", "Can not select an EGLConfig for rendering.");
                return null;
            }
            int i2 = iArr5[0];
            a[] aVarArr = new a[i2];
            EGLConfig[] eGLConfigArr2 = new EGLConfig[i2];
            egl10.eglChooseConfig(eGLDisplay, iArr4, eGLConfigArr2, i2, iArr5);
            for (int i3 = 0; i3 < i2; i3++) {
                aVarArr[i3] = new a(this, egl10, eGLDisplay, eGLConfigArr2[i3]);
            }
            a aVar = new a(this, this.configAttribs);
            int i4 = i2;
            while (i < i4 - 1) {
                int i5 = (i + i4) / 2;
                if (aVar.compareTo(aVarArr[i5]) < 0) {
                    i4 = i5;
                } else {
                    i = i5;
                }
            }
            if (i != i2 - 1) {
                i++;
            }
            Log.w("cocos2d", "Can't find EGLConfig match: " + aVar + ", instead of closest one:" + aVarArr[i]);
            return aVarArr[i].j;
        }
    }

    class a implements Runnable {
        final /* synthetic */ boolean j;

        a(boolean z) {
            this.j = z;
        }

        public void run() {
            Cocos2dxActivity.this.mGLSurfaceView.setKeepScreenOn(this.j);
        }
    }

    class b implements Cocos2dxHelper.OnGameInfoUpdatedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayout.LayoutParams f3139a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Cocos2dxRenderer f3140b;

        class a implements Runnable {
            final /* synthetic */ float j;

            a(float f2) {
                this.j = f2;
            }

            public void run() {
                if (Cocos2dxActivity.this.mFPSTextView != null) {
                    TextView access$200 = Cocos2dxActivity.this.mFPSTextView;
                    access$200.setText("FPS: " + ((int) Math.ceil((double) this.j)));
                }
            }
        }

        /* renamed from: org.cocos2dx.lib.Cocos2dxActivity$b$b  reason: collision with other inner class name */
        class C0084b implements Runnable {
            final /* synthetic */ int j;

            C0084b(int i) {
                this.j = i;
            }

            public void run() {
                if (Cocos2dxActivity.this.mJSBInvocationTextView != null) {
                    TextView access$300 = Cocos2dxActivity.this.mJSBInvocationTextView;
                    access$300.setText("JSB: " + this.j);
                }
            }
        }

        class c implements Runnable {
            c() {
            }

            public void run() {
                if (Cocos2dxActivity.this.mLinearLayoutForDebugView == null) {
                    Cocos2dxActivity cocos2dxActivity = Cocos2dxActivity.this;
                    if (cocos2dxActivity.mFrameLayout != null) {
                        LinearLayout unused = cocos2dxActivity.mLinearLayoutForDebugView = new LinearLayout(Cocos2dxActivity.this);
                        Cocos2dxActivity.this.mLinearLayoutForDebugView.setOrientation(1);
                        Cocos2dxActivity cocos2dxActivity2 = Cocos2dxActivity.this;
                        cocos2dxActivity2.mFrameLayout.addView(cocos2dxActivity2.mLinearLayoutForDebugView);
                        TextView unused2 = Cocos2dxActivity.this.mFPSTextView = new TextView(Cocos2dxActivity.this);
                        Cocos2dxActivity.this.mFPSTextView.setBackgroundColor(-65536);
                        Cocos2dxActivity.this.mFPSTextView.setTextColor(-1);
                        Cocos2dxActivity.this.mLinearLayoutForDebugView.addView(Cocos2dxActivity.this.mFPSTextView, b.this.f3139a);
                        TextView unused3 = Cocos2dxActivity.this.mJSBInvocationTextView = new TextView(Cocos2dxActivity.this);
                        Cocos2dxActivity.this.mJSBInvocationTextView.setBackgroundColor(-16711936);
                        Cocos2dxActivity.this.mJSBInvocationTextView.setTextColor(-1);
                        Cocos2dxActivity.this.mLinearLayoutForDebugView.addView(Cocos2dxActivity.this.mJSBInvocationTextView, b.this.f3139a);
                        TextView unused4 = Cocos2dxActivity.this.mGLOptModeTextView = new TextView(Cocos2dxActivity.this);
                        Cocos2dxActivity.this.mGLOptModeTextView.setBackgroundColor(-16776961);
                        Cocos2dxActivity.this.mGLOptModeTextView.setTextColor(-1);
                        Cocos2dxActivity.this.mGLOptModeTextView.setText("GL Opt: Enabled");
                        Cocos2dxActivity.this.mLinearLayoutForDebugView.addView(Cocos2dxActivity.this.mGLOptModeTextView, b.this.f3139a);
                        TextView unused5 = Cocos2dxActivity.this.mGameInfoTextView_0 = new TextView(Cocos2dxActivity.this);
                        Cocos2dxActivity.this.mGameInfoTextView_0.setBackgroundColor(-65536);
                        Cocos2dxActivity.this.mGameInfoTextView_0.setTextColor(-1);
                        Cocos2dxActivity.this.mLinearLayoutForDebugView.addView(Cocos2dxActivity.this.mGameInfoTextView_0, b.this.f3139a);
                        TextView unused6 = Cocos2dxActivity.this.mGameInfoTextView_1 = new TextView(Cocos2dxActivity.this);
                        Cocos2dxActivity.this.mGameInfoTextView_1.setBackgroundColor(-16711936);
                        Cocos2dxActivity.this.mGameInfoTextView_1.setTextColor(-1);
                        Cocos2dxActivity.this.mLinearLayoutForDebugView.addView(Cocos2dxActivity.this.mGameInfoTextView_1, b.this.f3139a);
                        TextView unused7 = Cocos2dxActivity.this.mGameInfoTextView_2 = new TextView(Cocos2dxActivity.this);
                        Cocos2dxActivity.this.mGameInfoTextView_2.setBackgroundColor(-16776961);
                        Cocos2dxActivity.this.mGameInfoTextView_2.setTextColor(-1);
                        Cocos2dxActivity.this.mLinearLayoutForDebugView.addView(Cocos2dxActivity.this.mGameInfoTextView_2, b.this.f3139a);
                        return;
                    }
                }
                Log.e(Cocos2dxActivity.TAG, "onOpenDebugView: failed!");
            }
        }

        class d implements Runnable {
            d() {
            }

            public void run() {
                if (Cocos2dxActivity.this.mGLOptModeTextView != null) {
                    Cocos2dxActivity.this.mGLOptModeTextView.setText("GL Opt: Disabled");
                }
            }
        }

        class e implements Runnable {
            final /* synthetic */ String j;

            e(String str) {
                this.j = str;
            }

            public void run() {
                if (Cocos2dxActivity.this.mGameInfoTextView_0 != null) {
                    Cocos2dxActivity.this.mGameInfoTextView_0.setText(this.j);
                }
            }
        }

        class f implements Runnable {
            final /* synthetic */ String j;

            f(String str) {
                this.j = str;
            }

            public void run() {
                if (Cocos2dxActivity.this.mGameInfoTextView_1 != null) {
                    Cocos2dxActivity.this.mGameInfoTextView_1.setText(this.j);
                }
            }
        }

        class g implements Runnable {
            final /* synthetic */ String j;

            g(String str) {
                this.j = str;
            }

            public void run() {
                if (Cocos2dxActivity.this.mGameInfoTextView_2 != null) {
                    Cocos2dxActivity.this.mGameInfoTextView_2.setText(this.j);
                }
            }
        }

        b(LinearLayout.LayoutParams layoutParams, Cocos2dxRenderer cocos2dxRenderer) {
            this.f3139a = layoutParams;
            this.f3140b = cocos2dxRenderer;
        }

        public void onDisableBatchGLCommandsToNative() {
            Cocos2dxActivity.this.runOnUiThread(new d());
        }

        public void onFPSUpdated(float f2) {
            Cocos2dxActivity.this.runOnUiThread(new a(f2));
        }

        public void onGameInfoUpdated_0(String str) {
            Cocos2dxActivity.this.runOnUiThread(new e(str));
        }

        public void onGameInfoUpdated_1(String str) {
            Cocos2dxActivity.this.runOnUiThread(new f(str));
        }

        public void onGameInfoUpdated_2(String str) {
            Cocos2dxActivity.this.runOnUiThread(new g(str));
        }

        public void onJSBInvocationCountUpdated(int i) {
            Cocos2dxActivity.this.runOnUiThread(new C0084b(i));
        }

        public void onOpenDebugView() {
            Cocos2dxActivity.this.runOnUiThread(new c());
            this.f3140b.showFPS();
        }
    }

    private void addDebugInfo(Cocos2dxRenderer cocos2dxRenderer) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(30, 0, 0, 0);
        Cocos2dxHelper.setOnGameInfoUpdatedListener(new b(layoutParams, cocos2dxRenderer));
    }

    private Cocos2dxRenderer addSurfaceView() {
        Cocos2dxGLSurfaceView onCreateView = onCreateView();
        this.mGLSurfaceView = onCreateView;
        onCreateView.setPreserveEGLContextOnPause(true);
        this.mGLSurfaceView.setBackgroundColor(0);
        if (isAndroidEmulator()) {
            this.mGLSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
        Cocos2dxRenderer cocos2dxRenderer = new Cocos2dxRenderer();
        this.mGLSurfaceView.setCocos2dxRenderer(cocos2dxRenderer);
        this.mFrameLayout.addView(this.mGLSurfaceView);
        return cocos2dxRenderer;
    }

    public static Context getContext() {
        return sContext;
    }

    private static native int[] getGLContextAttrs();

    private static final boolean isAndroidEmulator() {
        String str = Build.MODEL;
        String str2 = TAG;
        Log.d(str2, "model=" + str);
        String str3 = Build.PRODUCT;
        Log.d(str2, "product=" + str3);
        boolean z = false;
        if (str3 != null && (str3.equals("sdk") || str3.contains("_sdk") || str3.contains("sdk_"))) {
            z = true;
        }
        Log.d(str2, "isEmulator=" + z);
        return z;
    }

    private void resumeIfHasFocus() {
        if (this.hasFocus && !this.paused) {
            Utils.hideVirtualButton();
            Cocos2dxHelper.onResume();
            this.mGLSurfaceView.onResume();
        }
    }

    public Cocos2dxGLSurfaceView getGLSurfaceView() {
        return this.mGLSurfaceView;
    }

    public void init() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this);
        this.mFrameLayout = frameLayout;
        frameLayout.setLayoutParams(layoutParams);
        addDebugInfo(addSurfaceView());
        this.mEditBox = new Cocos2dxEditBox(this, this.mFrameLayout);
        setContentView(this.mFrameLayout);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        try {
            Field field = attributes.getClass().getField("layoutInDisplayCutoutMode");
            if (field != null) {
                field.setInt(attributes, attributes.getClass().getDeclaredField("LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES").getInt((Object) null));
            }
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        for (PreferenceManager.OnActivityResultListener onActivityResult : Cocos2dxHelper.getOnActivityResultListeners()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
        this.mWebViewHelper.onActivityResultAboveL(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str = TAG;
        Log.d(str, "Cocos2dxActivity onCreate: " + this + ", savedInstanceState: " + bundle);
        super.onCreate(bundle);
        if (!isTaskRoot()) {
            finish();
            Log.w(str, "[Workaround] Ignore the activity started from icon!");
            return;
        }
        Utils.setActivity(this);
        Utils.hideVirtualButton();
        Cocos2dxHelper.registerBatteryLevelReceiver(this);
        onLoadNativeLibraries();
        sContext = this;
        this.mHandler = new Cocos2dxHandler(this);
        Cocos2dxHelper.init(this);
        CanvasRenderingContext2DImpl.init(this);
        this.mGLContextAttrs = getGLContextAttrs();
        init();
        if (this.mVideoHelper == null) {
            this.mVideoHelper = new Cocos2dxVideoHelper(this, this.mFrameLayout);
        }
        if (this.mWebViewHelper == null) {
            this.mWebViewHelper = new Cocos2dxWebViewHelper(this.mFrameLayout);
        }
        getWindow().setSoftInputMode(16);
        setVolumeControlStream(3);
    }

    public Cocos2dxGLSurfaceView onCreateView() {
        Cocos2dxGLSurfaceView cocos2dxGLSurfaceView = new Cocos2dxGLSurfaceView(this);
        if (this.mGLContextAttrs[3] > 0) {
            cocos2dxGLSurfaceView.getHolder().setFormat(-3);
        }
        cocos2dxGLSurfaceView.setEGLConfigChooser(new Cocos2dxEGLConfigChooser(this.mGLContextAttrs));
        return cocos2dxGLSurfaceView;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (isTaskRoot()) {
            if (this.gainAudioFocus) {
                Cocos2dxAudioFocusManager.c(this);
            }
            Cocos2dxHelper.unregisterBatteryLevelReceiver(this);
            CanvasRenderingContext2DImpl.destroy();
            String str = TAG;
            Log.d(str, "Cocos2dxActivity onDestroy: " + this + ", mGLSurfaceView" + this.mGLSurfaceView);
            if (this.mGLSurfaceView != null) {
                Cocos2dxHelper.terminateProcess();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLoadNativeLibraries() {
        try {
            System.loadLibrary(getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.getString("android.app.lib_name"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Log.d(TAG, "onPause()");
        this.paused = true;
        super.onPause();
        if (this.gainAudioFocus) {
            Cocos2dxAudioFocusManager.c(this);
        }
        Cocos2dxHelper.onPause();
        this.mGLSurfaceView.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Log.d(TAG, "onResume()");
        this.paused = false;
        super.onResume();
        if (this.gainAudioFocus) {
            Cocos2dxAudioFocusManager.b(this);
        }
        Utils.hideVirtualButton();
        resumeIfHasFocus();
    }

    public void onWindowFocusChanged(boolean z) {
        String str = TAG;
        Log.d(str, "onWindowFocusChanged() hasFocus=" + z);
        super.onWindowFocusChanged(z);
        this.hasFocus = z;
        resumeIfHasFocus();
    }

    public void runOnGLThread(Runnable runnable) {
        this.mGLSurfaceView.queueEvent(runnable);
    }

    public void setEnableAudioFocusGain(boolean z) {
        if (this.gainAudioFocus != z) {
            if (!this.paused) {
                if (z) {
                    Cocos2dxAudioFocusManager.b(this);
                } else {
                    Cocos2dxAudioFocusManager.c(this);
                }
            }
            this.gainAudioFocus = z;
        }
    }

    public void setKeepScreenOn(boolean z) {
        runOnUiThread(new a(z));
    }

    public void showDialog(String str, String str2) {
        Message message = new Message();
        message.what = 1;
        message.obj = new Cocos2dxHandler.DialogMessage(str, str2);
        this.mHandler.sendMessage(message);
    }
}
