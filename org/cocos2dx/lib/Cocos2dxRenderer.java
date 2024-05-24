package org.cocos2dx.lib;

import android.opengl.GLSurfaceView;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.cocos2dx.lib.Cocos2dxHelper;

public class Cocos2dxRenderer implements GLSurfaceView.Renderer {
    private static final long INTERVAL_60_FPS = 16666666;
    private static final long NANOSECONDSPERMICROSECOND = 1000000;
    private static final long NANOSECONDSPERSECOND = 1000000000;
    private static final String TAG = "Cocos2dxRenderer";
    private static long sAnimationInterval = 16666666;
    private static WeakReference<Cocos2dxRenderer> sRenderer;
    private String mDefaultResourcePath = "";
    private long mFrameCount = 0;
    /* access modifiers changed from: private */
    public OnGameEngineInitializedListener mGameEngineInitializedListener;
    private long mLastTickInNanoSeconds;
    private boolean mNativeInitCompleted = false;
    private boolean mNeedShowFPS = false;
    private boolean mNeedToPause = false;
    private long mOldNanoTime = 0;
    private int mScreenHeight;
    private int mScreenWidth;

    public interface OnGameEngineInitializedListener {
        void onGameEngineInitialized();
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            Cocos2dxRenderer.this.mGameEngineInitializedListener.onGameEngineInitialized();
        }
    }

    private static native void nativeDeleteBackward();

    private static native String nativeGetContentText();

    private static native void nativeInit(int i, int i2, String str);

    private static native void nativeInsertText(String str);

    private static native boolean nativeKeyEvent(int i, boolean z);

    private static native void nativeOnPause();

    private static native void nativeOnResume();

    private static native void nativeOnSurfaceChanged(int i, int i2);

    private static native void nativeRender();

    private static native void nativeTouchesBegin(int i, float f2, float f3);

    private static native void nativeTouchesCancel(int[] iArr, float[] fArr, float[] fArr2);

    private static native void nativeTouchesEnd(int i, float f2, float f3);

    private static native void nativeTouchesMove(int[] iArr, float[] fArr, float[] fArr2);

    public static void setPreferredFramesPerSecond(int i) {
        double d2 = (double) i;
        Double.isNaN(d2);
        sAnimationInterval = (long) ((1.0d / d2) * 1.0E9d);
    }

    public String getContentText() {
        return nativeGetContentText();
    }

    public void handleActionCancel(int[] iArr, float[] fArr, float[] fArr2) {
        if (this.mNativeInitCompleted) {
            nativeTouchesCancel(iArr, fArr, fArr2);
        }
    }

    public void handleActionDown(int i, float f2, float f3) {
        if (this.mNativeInitCompleted) {
            nativeTouchesBegin(i, f2, f3);
        }
    }

    public void handleActionMove(int[] iArr, float[] fArr, float[] fArr2) {
        if (this.mNativeInitCompleted) {
            nativeTouchesMove(iArr, fArr, fArr2);
        }
    }

    public void handleActionUp(int i, float f2, float f3) {
        if (this.mNativeInitCompleted) {
            nativeTouchesEnd(i, f2, f3);
        }
    }

    public void handleDeleteBackward() {
        nativeDeleteBackward();
    }

    public void handleInsertText(String str) {
        nativeInsertText(str);
    }

    public void handleKeyDown(int i) {
        if (this.mNativeInitCompleted) {
            nativeKeyEvent(i, true);
        }
    }

    public void handleKeyUp(int i) {
        if (this.mNativeInitCompleted) {
            nativeKeyEvent(i, false);
        }
    }

    public void handleOnPause() {
        if (this.mNativeInitCompleted) {
            Cocos2dxHelper.onEnterBackground();
            nativeOnPause();
        }
    }

    public void handleOnResume() {
        Cocos2dxHelper.onEnterForeground();
        nativeOnResume();
    }

    public void onDrawFrame(GL10 gl10) {
        if (!this.mNeedToPause) {
            if (this.mNeedShowFPS) {
                this.mFrameCount++;
                long nanoTime = System.nanoTime() - this.mOldNanoTime;
                if (nanoTime > NANOSECONDSPERSECOND) {
                    double d2 = (double) this.mFrameCount;
                    Double.isNaN(d2);
                    double d3 = (double) nanoTime;
                    Double.isNaN(d3);
                    double d4 = (d2 * 1.0E9d) / d3;
                    Cocos2dxHelper.OnGameInfoUpdatedListener onGameInfoUpdatedListener = Cocos2dxHelper.getOnGameInfoUpdatedListener();
                    if (onGameInfoUpdatedListener != null) {
                        onGameInfoUpdatedListener.onFPSUpdated((float) d4);
                    }
                    this.mFrameCount = 0;
                    this.mOldNanoTime = System.nanoTime();
                }
            }
            if (sAnimationInterval > INTERVAL_60_FPS) {
                long nanoTime2 = System.nanoTime() - this.mLastTickInNanoSeconds;
                long j = sAnimationInterval;
                if (nanoTime2 < j) {
                    try {
                        Thread.sleep((j - nanoTime2) / NANOSECONDSPERMICROSECOND);
                    } catch (Exception unused) {
                    }
                }
                this.mLastTickInNanoSeconds = System.nanoTime();
            }
            nativeRender();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        nativeOnSurfaceChanged(i, i2);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.mNativeInitCompleted = false;
        nativeInit(this.mScreenWidth, this.mScreenHeight, this.mDefaultResourcePath);
        this.mOldNanoTime = System.nanoTime();
        this.mLastTickInNanoSeconds = System.nanoTime();
        this.mNativeInitCompleted = true;
        if (this.mGameEngineInitializedListener != null) {
            Cocos2dxHelper.getActivity().runOnUiThread(new a());
        }
    }

    public void setDefaultResourcePath(String str) {
        if (str != null) {
            this.mDefaultResourcePath = str;
        }
    }

    public void setOnGameEngineInitializedListener(OnGameEngineInitializedListener onGameEngineInitializedListener) {
        this.mGameEngineInitializedListener = onGameEngineInitializedListener;
    }

    public void setPauseInMainThread(boolean z) {
        this.mNeedToPause = z;
    }

    public void setScreenWidthAndHeight(int i, int i2) {
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
    }

    public void showFPS() {
        this.mNeedShowFPS = true;
    }
}
