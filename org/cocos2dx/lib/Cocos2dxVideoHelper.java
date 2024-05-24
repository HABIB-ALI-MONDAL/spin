package org.cocos2dx.lib;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.cocos2dx.lib.Cocos2dxVideoView;

public class Cocos2dxVideoHelper {
    static final int KeyEventBack = 1000;
    private static final int VideoTaskCreate = 0;
    private static final int VideoTaskFullScreen = 12;
    private static final int VideoTaskKeepRatio = 11;
    private static final int VideoTaskPause = 5;
    private static final int VideoTaskRemove = 1;
    private static final int VideoTaskRestart = 10;
    private static final int VideoTaskResume = 6;
    private static final int VideoTaskSeek = 8;
    private static final int VideoTaskSetRect = 3;
    private static final int VideoTaskSetSource = 2;
    private static final int VideoTaskSetVisible = 9;
    private static final int VideoTaskSetVolume = 13;
    private static final int VideoTaskStart = 4;
    private static final int VideoTaskStop = 7;
    static e mVideoHandler;
    private static Handler sHandler;
    /* access modifiers changed from: private */
    public static SparseArray<Cocos2dxVideoView> sVideoViews;
    private static int videoTag;
    /* access modifiers changed from: private */
    public Cocos2dxActivity mActivity = null;
    private FrameLayout mLayout = null;
    Cocos2dxVideoView.OnVideoEventListener videoEventListener = new a();

    class a implements Cocos2dxVideoView.OnVideoEventListener {
        a() {
        }

        public void onVideoEvent(int i, int i2) {
            Cocos2dxVideoHelper.this.mActivity.runOnGLThread(new d(Cocos2dxVideoHelper.this, i, i2));
        }
    }

    class b implements Callable<Float> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3147a;

        b(int i) {
            this.f3147a = i;
        }

        /* renamed from: a */
        public Float call() {
            Cocos2dxVideoView cocos2dxVideoView = (Cocos2dxVideoView) Cocos2dxVideoHelper.sVideoViews.get(this.f3147a);
            return new Float(cocos2dxVideoView != null ? ((float) cocos2dxVideoView.getCurrentPosition()) / 1000.0f : -1.0f);
        }
    }

    class c implements Callable<Float> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3148a;

        c(int i) {
            this.f3148a = i;
        }

        /* renamed from: a */
        public Float call() {
            Cocos2dxVideoView cocos2dxVideoView = (Cocos2dxVideoView) Cocos2dxVideoHelper.sVideoViews.get(this.f3148a);
            float duration = cocos2dxVideoView != null ? ((float) cocos2dxVideoView.getDuration()) / 1000.0f : -1.0f;
            if (duration <= 0.0f) {
                Log.w("Cocos2dxVideoHelper", "Video player's duration is not ready to get now!");
            }
            return new Float(duration);
        }
    }

    private class d implements Runnable {
        private int j;
        private int k;

        public d(Cocos2dxVideoHelper cocos2dxVideoHelper, int i, int i2) {
            this.j = i;
            this.k = i2;
        }

        public void run() {
            Cocos2dxVideoHelper.nativeExecuteVideoCallback(this.j, this.k);
        }
    }

    static class e extends Handler {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<Cocos2dxVideoHelper> f3149a;

        e(Cocos2dxVideoHelper cocos2dxVideoHelper) {
            this.f3149a = new WeakReference<>(cocos2dxVideoHelper);
        }

        public void handleMessage(Message message) {
            Cocos2dxVideoHelper cocos2dxVideoHelper = (Cocos2dxVideoHelper) this.f3149a.get();
            int i = message.what;
            if (i == 0) {
                cocos2dxVideoHelper._createVideoView(message.arg1);
            } else if (i == 1) {
                cocos2dxVideoHelper._removeVideoView(message.arg1);
            } else if (i == 2) {
                cocos2dxVideoHelper._setVideoURL(message.arg1, message.arg2, (String) message.obj);
            } else if (i == 3) {
                Rect rect = (Rect) message.obj;
                cocos2dxVideoHelper._setVideoRect(message.arg1, rect.left, rect.top, rect.right, rect.bottom);
            } else if (i == 4) {
                cocos2dxVideoHelper._startVideo(message.arg1);
            } else if (i == 5) {
                cocos2dxVideoHelper._pauseVideo(message.arg1);
            } else if (i == 7) {
                cocos2dxVideoHelper._stopVideo(message.arg1);
            } else if (i == 8) {
                cocos2dxVideoHelper._seekVideoTo(message.arg1, message.arg2);
            } else if (i != 9) {
                if (i != Cocos2dxVideoHelper.KeyEventBack) {
                    switch (i) {
                        case 11:
                            if (message.arg2 != 1) {
                                cocos2dxVideoHelper._setVideoKeepRatio(message.arg1, false);
                                break;
                            } else {
                                cocos2dxVideoHelper._setVideoKeepRatio(message.arg1, true);
                                break;
                            }
                        case 12:
                            if (message.arg2 != 1) {
                                cocos2dxVideoHelper._setFullScreenEnabled(message.arg1, false);
                                break;
                            } else {
                                cocos2dxVideoHelper._setFullScreenEnabled(message.arg1, true);
                                break;
                            }
                        case 13:
                            cocos2dxVideoHelper._setVolume(message.arg1, ((float) message.arg2) / 10.0f);
                            break;
                    }
                } else {
                    cocos2dxVideoHelper.onBackKeyEvent();
                }
            } else if (message.arg2 == 1) {
                cocos2dxVideoHelper._setVideoVisible(message.arg1, true);
            } else {
                cocos2dxVideoHelper._setVideoVisible(message.arg1, false);
            }
            super.handleMessage(message);
        }
    }

    Cocos2dxVideoHelper(Cocos2dxActivity cocos2dxActivity, FrameLayout frameLayout) {
        this.mActivity = cocos2dxActivity;
        this.mLayout = frameLayout;
        mVideoHandler = new e(this);
        sVideoViews = new SparseArray<>();
        sHandler = new Handler(Looper.myLooper());
    }

    /* access modifiers changed from: private */
    public void _createVideoView(int i) {
        Cocos2dxVideoView cocos2dxVideoView = new Cocos2dxVideoView(this.mActivity, i);
        sVideoViews.put(i, cocos2dxVideoView);
        this.mLayout.addView(cocos2dxVideoView, new FrameLayout.LayoutParams(-2, -2));
        cocos2dxVideoView.setZOrderOnTop(true);
        cocos2dxVideoView.setVideoViewEventListener(this.videoEventListener);
    }

    /* access modifiers changed from: private */
    public void _pauseVideo(int i) {
        Cocos2dxVideoView cocos2dxVideoView = sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.pause();
        }
    }

    /* access modifiers changed from: private */
    public void _removeVideoView(int i) {
        Cocos2dxVideoView cocos2dxVideoView = sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.stopPlayback();
            sVideoViews.remove(i);
            this.mLayout.removeView(cocos2dxVideoView);
        }
    }

    /* access modifiers changed from: private */
    public void _seekVideoTo(int i, int i2) {
        Cocos2dxVideoView cocos2dxVideoView = sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.seekTo(i2);
        }
    }

    /* access modifiers changed from: private */
    public void _setFullScreenEnabled(int i, boolean z) {
        Cocos2dxVideoView cocos2dxVideoView = sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.setFullScreenEnabled(z);
        }
    }

    /* access modifiers changed from: private */
    public void _setVideoKeepRatio(int i, boolean z) {
        Cocos2dxVideoView cocos2dxVideoView = sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.setKeepRatio(z);
        }
    }

    /* access modifiers changed from: private */
    public void _setVideoRect(int i, int i2, int i3, int i4, int i5) {
        Cocos2dxVideoView cocos2dxVideoView = sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.setVideoRect(i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: private */
    public void _setVideoURL(int i, int i2, String str) {
        Cocos2dxVideoView cocos2dxVideoView = sVideoViews.get(i);
        if (cocos2dxVideoView == null) {
            return;
        }
        if (i2 == 0) {
            cocos2dxVideoView.setVideoFileName(str);
        } else if (i2 == 1) {
            cocos2dxVideoView.setVideoURL(str);
        }
    }

    /* access modifiers changed from: private */
    public void _setVideoVisible(int i, boolean z) {
        int i2;
        Cocos2dxVideoView cocos2dxVideoView = sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            if (z) {
                cocos2dxVideoView.fixSize();
                i2 = 0;
            } else {
                i2 = 4;
            }
            cocos2dxVideoView.setVisibility(i2);
        }
    }

    /* access modifiers changed from: private */
    public void _setVolume(int i, float f2) {
        Cocos2dxVideoView cocos2dxVideoView = sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.setVolume(f2);
        }
    }

    /* access modifiers changed from: private */
    public void _startVideo(int i) {
        Cocos2dxVideoView cocos2dxVideoView = sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.start();
        }
    }

    /* access modifiers changed from: private */
    public void _stopVideo(int i) {
        Cocos2dxVideoView cocos2dxVideoView = sVideoViews.get(i);
        if (cocos2dxVideoView != null) {
            cocos2dxVideoView.stop();
        }
    }

    public static <T> T callInMainThread(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        sHandler.post(futureTask);
        return futureTask.get();
    }

    public static int createVideoWidget() {
        Message message = new Message();
        message.what = 0;
        message.arg1 = videoTag;
        mVideoHandler.sendMessage(message);
        int i = videoTag;
        videoTag = i + 1;
        return i;
    }

    public static float getCurrentTime(int i) {
        try {
            return ((Float) callInMainThread(new b(i))).floatValue();
        } catch (InterruptedException | ExecutionException unused) {
            return -1.0f;
        }
    }

    public static float getDuration(int i) {
        try {
            return ((Float) callInMainThread(new c(i))).floatValue();
        } catch (InterruptedException | ExecutionException unused) {
            return -1.0f;
        }
    }

    public static native void nativeExecuteVideoCallback(int i, int i2);

    /* access modifiers changed from: private */
    public void onBackKeyEvent() {
        int size = sVideoViews.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sVideoViews.keyAt(i);
            Cocos2dxVideoView cocos2dxVideoView = sVideoViews.get(keyAt);
            if (cocos2dxVideoView != null) {
                cocos2dxVideoView.setFullScreenEnabled(false);
                this.mActivity.runOnGLThread(new d(this, keyAt, KeyEventBack));
            }
        }
    }

    public static void pauseVideo(int i) {
        Message message = new Message();
        message.what = 5;
        message.arg1 = i;
        mVideoHandler.sendMessage(message);
    }

    public static void removeVideoWidget(int i) {
        Message message = new Message();
        message.what = 1;
        message.arg1 = i;
        mVideoHandler.sendMessage(message);
    }

    public static void seekVideoTo(int i, int i2) {
        Message message = new Message();
        message.what = 8;
        message.arg1 = i;
        message.arg2 = i2;
        mVideoHandler.sendMessage(message);
    }

    public static void setFullScreenEnabled(int i, boolean z) {
        Message message = new Message();
        message.what = 12;
        message.arg1 = i;
        message.arg2 = z ? 1 : 0;
        mVideoHandler.sendMessage(message);
    }

    public static void setVideoKeepRatioEnabled(int i, boolean z) {
        Message message = new Message();
        message.what = 11;
        message.arg1 = i;
        message.arg2 = z ? 1 : 0;
        mVideoHandler.sendMessage(message);
    }

    public static void setVideoRect(int i, int i2, int i3, int i4, int i5) {
        Message message = new Message();
        message.what = 3;
        message.arg1 = i;
        message.obj = new Rect(i2, i3, i4, i5);
        mVideoHandler.sendMessage(message);
    }

    public static void setVideoUrl(int i, int i2, String str) {
        Message message = new Message();
        message.what = 2;
        message.arg1 = i;
        message.arg2 = i2;
        message.obj = str;
        mVideoHandler.sendMessage(message);
    }

    public static void setVideoVisible(int i, boolean z) {
        Message message = new Message();
        message.what = 9;
        message.arg1 = i;
        message.arg2 = z ? 1 : 0;
        mVideoHandler.sendMessage(message);
    }

    public static void setVolume(int i, float f2) {
        Message message = new Message();
        message.what = 13;
        message.arg1 = i;
        message.arg2 = (int) (f2 * 10.0f);
        mVideoHandler.sendMessage(message);
    }

    public static void startVideo(int i) {
        Message message = new Message();
        message.what = 4;
        message.arg1 = i;
        mVideoHandler.sendMessage(message);
    }

    public static void stopVideo(int i) {
        Message message = new Message();
        message.what = 7;
        message.arg1 = i;
        mVideoHandler.sendMessage(message);
    }
}
