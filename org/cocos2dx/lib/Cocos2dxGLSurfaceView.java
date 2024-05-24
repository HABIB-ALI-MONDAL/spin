package org.cocos2dx.lib;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class Cocos2dxGLSurfaceView extends GLSurfaceView {
    private static final int HANDLER_CLOSE_IME_KEYBOARD = 3;
    private static final int HANDLER_OPEN_IME_KEYBOARD = 2;
    private static final String TAG = Cocos2dxGLSurfaceView.class.getSimpleName();
    private static Cocos2dxGLSurfaceView mCocos2dxGLSurfaceView;
    private static Handler sHandler;
    /* access modifiers changed from: private */
    public Cocos2dxRenderer mCocos2dxRenderer;
    private boolean mStopHandleTouchAndKeyEvents = false;

    class a implements Runnable {
        final /* synthetic */ int j;

        a(int i) {
            this.j = i;
        }

        public void run() {
            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleKeyDown(this.j);
        }
    }

    class b implements Runnable {
        final /* synthetic */ int j;

        b(int i) {
            this.j = i;
        }

        public void run() {
            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleKeyUp(this.j);
        }
    }

    class c implements Runnable {
        final /* synthetic */ float j;
        final /* synthetic */ float k;
        final /* synthetic */ float l;
        final /* synthetic */ long m;

        c(float f2, float f3, float f4, long j2) {
            this.j = f2;
            this.k = f3;
            this.l = f4;
            this.m = j2;
        }

        public void run() {
            Cocos2dxAccelerometer.onSensorChanged(this.j, this.k, this.l, this.m);
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleOnResume();
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleOnPause();
        }
    }

    class f implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ float k;
        final /* synthetic */ float l;

        f(int i, float f2, float f3) {
            this.j = i;
            this.k = f2;
            this.l = f3;
        }

        public void run() {
            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionDown(this.j, this.k, this.l);
        }
    }

    class g implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ float k;
        final /* synthetic */ float l;

        g(int i, float f2, float f3) {
            this.j = i;
            this.k = f2;
            this.l = f3;
        }

        public void run() {
            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionDown(this.j, this.k, this.l);
        }
    }

    class h implements Runnable {
        final /* synthetic */ int[] j;
        final /* synthetic */ float[] k;
        final /* synthetic */ float[] l;

        h(int[] iArr, float[] fArr, float[] fArr2) {
            this.j = iArr;
            this.k = fArr;
            this.l = fArr2;
        }

        public void run() {
            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionMove(this.j, this.k, this.l);
        }
    }

    class i implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ float k;
        final /* synthetic */ float l;

        i(int i, float f2, float f3) {
            this.j = i;
            this.k = f2;
            this.l = f3;
        }

        public void run() {
            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionUp(this.j, this.k, this.l);
        }
    }

    class j implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ float k;
        final /* synthetic */ float l;

        j(int i, float f2, float f3) {
            this.j = i;
            this.k = f2;
            this.l = f3;
        }

        public void run() {
            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionUp(this.j, this.k, this.l);
        }
    }

    class k implements Runnable {
        final /* synthetic */ int[] j;
        final /* synthetic */ float[] k;
        final /* synthetic */ float[] l;

        k(int[] iArr, float[] fArr, float[] fArr2) {
            this.j = iArr;
            this.k = fArr;
            this.l = fArr2;
        }

        public void run() {
            Cocos2dxGLSurfaceView.this.mCocos2dxRenderer.handleActionCancel(this.j, this.k, this.l);
        }
    }

    public Cocos2dxGLSurfaceView(Context context) {
        super(context);
        initView();
    }

    public Cocos2dxGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private static void dumpMotionEvent(MotionEvent motionEvent) {
        StringBuilder sb = new StringBuilder();
        int action = motionEvent.getAction();
        int i2 = action & 255;
        sb.append("event ACTION_");
        sb.append(new String[]{"DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE", "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?"}[i2]);
        if (i2 == 5 || i2 == 6) {
            sb.append("(pid ");
            sb.append(action >> 8);
            sb.append(")");
        }
        sb.append("[");
        int i3 = 0;
        while (i3 < motionEvent.getPointerCount()) {
            sb.append("#");
            sb.append(i3);
            sb.append("(pid ");
            sb.append(motionEvent.getPointerId(i3));
            sb.append(")=");
            sb.append((int) motionEvent.getX(i3));
            sb.append(",");
            sb.append((int) motionEvent.getY(i3));
            i3++;
            if (i3 < motionEvent.getPointerCount()) {
                sb.append(";");
            }
        }
        sb.append("]");
        Log.d(TAG, sb.toString());
    }

    private String getContentText() {
        return this.mCocos2dxRenderer.getContentText();
    }

    public static Cocos2dxGLSurfaceView getInstance() {
        return mCocos2dxGLSurfaceView;
    }

    public static native void nativeOnSizeChanged(int i2, int i3);

    public static void queueAccelerometer(float f2, float f3, float f4, long j2) {
        mCocos2dxGLSurfaceView.queueEvent(new c(f2, f3, f4, j2));
    }

    /* access modifiers changed from: protected */
    public void initView() {
        setEGLContextClientVersion(2);
        setFocusableInTouchMode(true);
        mCocos2dxGLSurfaceView = this;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            Cocos2dxVideoHelper.mVideoHandler.sendEmptyMessage(1000);
        } else if (!(i2 == 66 || i2 == 82 || i2 == 85)) {
            switch (i2) {
                case 19:
                case 20:
                case 21:
                case 22:
                case b.a.j.h3:
                    break;
                default:
                    return super.onKeyDown(i2, keyEvent);
            }
        }
        queueEvent(new a(i2));
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (!(i2 == 4 || i2 == 66 || i2 == 82 || i2 == 85)) {
            switch (i2) {
                case 19:
                case 20:
                case 21:
                case 22:
                case b.a.j.h3:
                    break;
                default:
                    return super.onKeyUp(i2, keyEvent);
            }
        }
        queueEvent(new b(i2));
        return true;
    }

    public void onPause() {
        queueEvent(new e());
        setRenderMode(0);
        this.mCocos2dxRenderer.setPauseInMainThread(true);
    }

    public void onResume() {
        super.onResume();
        setRenderMode(1);
        queueEvent(new d());
        this.mCocos2dxRenderer.setPauseInMainThread(false);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (!isInEditMode()) {
            this.mCocos2dxRenderer.setScreenWidthAndHeight(i2, i3);
            nativeOnSizeChanged(i2, i3);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Runnable gVar;
        Runnable runnable;
        Runnable fVar;
        int pointerCount = motionEvent.getPointerCount();
        int[] iArr = new int[pointerCount];
        float[] fArr = new float[pointerCount];
        float[] fArr2 = new float[pointerCount];
        for (int i2 = 0; i2 < pointerCount; i2++) {
            iArr[i2] = motionEvent.getPointerId(i2);
            fArr[i2] = motionEvent.getX(i2);
            fArr2[i2] = motionEvent.getY(i2);
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    runnable = new h(iArr, fArr, fArr2);
                } else if (action != 3) {
                    if (action != 5) {
                        if (action == 6) {
                            int action2 = motionEvent.getAction() >> 8;
                            fVar = new i(motionEvent.getPointerId(action2), motionEvent.getX(action2), motionEvent.getY(action2));
                        }
                        return true;
                    } else if (this.mStopHandleTouchAndKeyEvents) {
                        Cocos2dxEditBox.complete();
                        return true;
                    } else {
                        int action3 = motionEvent.getAction() >> 8;
                        fVar = new f(motionEvent.getPointerId(action3), motionEvent.getX(action3), motionEvent.getY(action3));
                    }
                    queueEvent(fVar);
                    return true;
                } else {
                    runnable = new k(iArr, fArr, fArr2);
                }
                queueEvent(runnable);
                return true;
            }
            gVar = new j(motionEvent.getPointerId(0), fArr[0], fArr2[0]);
        } else if (this.mStopHandleTouchAndKeyEvents) {
            Cocos2dxEditBox.complete();
            return true;
        } else {
            gVar = new g(motionEvent.getPointerId(0), fArr[0], fArr2[0]);
        }
        queueEvent(gVar);
        return true;
    }

    public void setCocos2dxRenderer(Cocos2dxRenderer cocos2dxRenderer) {
        this.mCocos2dxRenderer = cocos2dxRenderer;
        setRenderer(cocos2dxRenderer);
    }

    public void setStopHandleTouchAndKeyEvents(boolean z) {
        this.mStopHandleTouchAndKeyEvents = z;
    }
}
