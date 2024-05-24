package org.cocos2dx.lib;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.widget.FrameLayout;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Cocos2dxWebViewHelper {
    private static final String TAG = "Cocos2dxWebViewHelper";
    /* access modifiers changed from: private */
    public static Cocos2dxActivity sCocos2dxActivity;
    private static Handler sHandler;
    /* access modifiers changed from: private */
    public static FrameLayout sLayout;
    private static int viewTag;
    /* access modifiers changed from: private */
    public static SparseArray<Cocos2dxWebView> webViews;

    class a implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ String k;

        a(int i, String str) {
            this.j = i;
            this.k = str;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.loadUrl(this.k);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ int j;

        b(int i) {
            this.j = i;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.stopLoading();
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ int j;

        c(int i) {
            this.j = i;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.reload();
            }
        }
    }

    class d implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3155a;

        d(int i) {
            this.f3155a = i;
        }

        /* renamed from: a */
        public Boolean call() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.f3155a);
            return Boolean.valueOf(cocos2dxWebView != null && cocos2dxWebView.canGoBack());
        }
    }

    class e implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3156a;

        e(int i) {
            this.f3156a = i;
        }

        /* renamed from: a */
        public Boolean call() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.f3156a);
            return Boolean.valueOf(cocos2dxWebView != null && cocos2dxWebView.canGoForward());
        }
    }

    class f implements Runnable {
        final /* synthetic */ int j;

        f(int i) {
            this.j = i;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.goBack();
            }
        }
    }

    class g implements Runnable {
        final /* synthetic */ int j;

        g(int i) {
            this.j = i;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.goForward();
            }
        }
    }

    class h implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ String k;

        h(int i, String str) {
            this.j = i;
            this.k = str;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.loadUrl("javascript:" + this.k);
            }
        }
    }

    class i implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ boolean k;

        i(int i, boolean z) {
            this.j = i;
            this.k = z;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.setScalesPageToFit(this.k);
            }
        }
    }

    class j implements Runnable {
        final /* synthetic */ int j;

        j(int i) {
            this.j = i;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = new Cocos2dxWebView(Cocos2dxWebViewHelper.sCocos2dxActivity, this.j);
            Cocos2dxWebViewHelper.sLayout.addView(cocos2dxWebView, new FrameLayout.LayoutParams(-2, -2));
            Cocos2dxWebViewHelper.webViews.put(this.j, cocos2dxWebView);
        }
    }

    class k implements Runnable {
        final /* synthetic */ int j;

        k(int i) {
            this.j = i;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                Cocos2dxWebViewHelper.webViews.remove(this.j);
                Cocos2dxWebViewHelper.sLayout.removeView(cocos2dxWebView);
                cocos2dxWebView.destroy();
            }
        }
    }

    class l implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ boolean k;

        l(int i, boolean z) {
            this.j = i;
            this.k = z;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.setVisibility(this.k ? 0 : 8);
            }
        }
    }

    class m implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ int k;
        final /* synthetic */ int l;
        final /* synthetic */ int m;
        final /* synthetic */ int n;

        m(int i, int i2, int i3, int i4, int i5) {
            this.j = i;
            this.k = i2;
            this.l = i3;
            this.m = i4;
            this.n = i5;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.setWebViewRect(this.k, this.l, this.m, this.n);
            }
        }
    }

    class n implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ boolean k;

        n(int i, boolean z) {
            this.j = i;
            this.k = z;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.setBackgroundColor(this.k ? 0 : -1);
                cocos2dxWebView.setLayerType(1, (Paint) null);
            }
        }
    }

    class o implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ String k;

        o(int i, String str) {
            this.j = i;
            this.k = str;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.setJavascriptInterfaceScheme(this.k);
            }
        }
    }

    class p implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ String k;
        final /* synthetic */ String l;
        final /* synthetic */ String m;
        final /* synthetic */ String n;

        p(int i, String str, String str2, String str3, String str4) {
            this.j = i;
            this.k = str;
            this.l = str2;
            this.m = str3;
            this.n = str4;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.loadDataWithBaseURL(this.k, this.l, this.m, this.n, (String) null);
            }
        }
    }

    class q implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ String k;
        final /* synthetic */ String l;

        q(int i, String str, String str2) {
            this.j = i;
            this.k = str;
            this.l = str2;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.loadDataWithBaseURL(this.k, this.l, (String) null, (String) null, (String) null);
            }
        }
    }

    class r implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ String k;

        r(int i, String str) {
            this.j = i;
            this.k = str;
        }

        public void run() {
            Cocos2dxWebView cocos2dxWebView = (Cocos2dxWebView) Cocos2dxWebViewHelper.webViews.get(this.j);
            if (cocos2dxWebView != null) {
                cocos2dxWebView.loadUrl(this.k);
            }
        }
    }

    public Cocos2dxWebViewHelper(FrameLayout frameLayout) {
        sLayout = frameLayout;
        sHandler = new Handler(Looper.myLooper());
        sCocos2dxActivity = (Cocos2dxActivity) Cocos2dxActivity.getContext();
        webViews = new SparseArray<>();
    }

    public static void _didFailLoading(int i2, String str) {
        didFailLoading(i2, str);
    }

    public static void _didFinishLoading(int i2, String str) {
        didFinishLoading(i2, str);
    }

    public static void _onJsCallback(int i2, String str) {
        onJsCallback(i2, str);
    }

    public static boolean _shouldStartLoading(int i2, String str) {
        return !shouldStartLoading(i2, str);
    }

    public static <T> T callInMainThread(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        sHandler.post(futureTask);
        return futureTask.get();
    }

    public static boolean canGoBack(int i2) {
        try {
            return ((Boolean) callInMainThread(new d(i2))).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            return false;
        }
    }

    public static boolean canGoForward(int i2) {
        try {
            return ((Boolean) callInMainThread(new e(i2))).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            return false;
        }
    }

    public static int createWebView() {
        sCocos2dxActivity.runOnUiThread(new j(viewTag));
        int i2 = viewTag;
        viewTag = i2 + 1;
        return i2;
    }

    private static native void didFailLoading(int i2, String str);

    private static native void didFinishLoading(int i2, String str);

    public static void evaluateJS(int i2, String str) {
        sCocos2dxActivity.runOnUiThread(new h(i2, str));
    }

    public static void goBack(int i2) {
        sCocos2dxActivity.runOnUiThread(new f(i2));
    }

    public static void goForward(int i2) {
        sCocos2dxActivity.runOnUiThread(new g(i2));
    }

    public static void loadData(int i2, String str, String str2, String str3, String str4) {
        sCocos2dxActivity.runOnUiThread(new p(i2, str4, str, str2, str3));
    }

    public static void loadFile(int i2, String str) {
        sCocos2dxActivity.runOnUiThread(new a(i2, str));
    }

    public static void loadHTMLString(int i2, String str, String str2) {
        sCocos2dxActivity.runOnUiThread(new q(i2, str2, str));
    }

    public static void loadUrl(int i2, String str) {
        sCocos2dxActivity.runOnUiThread(new r(i2, str));
    }

    private static native void onJsCallback(int i2, String str);

    public static void reload(int i2) {
        sCocos2dxActivity.runOnUiThread(new c(i2));
    }

    public static void removeWebView(int i2) {
        sCocos2dxActivity.runOnUiThread(new k(i2));
    }

    public static void setBackgroundTransparent(int i2, boolean z) {
        sCocos2dxActivity.runOnUiThread(new n(i2, z));
    }

    public static void setJavascriptInterfaceScheme(int i2, String str) {
        sCocos2dxActivity.runOnUiThread(new o(i2, str));
    }

    public static void setScalesPageToFit(int i2, boolean z) {
        sCocos2dxActivity.runOnUiThread(new i(i2, z));
    }

    public static void setVisible(int i2, boolean z) {
        sCocos2dxActivity.runOnUiThread(new l(i2, z));
    }

    public static void setWebViewRect(int i2, int i3, int i4, int i5, int i6) {
        sCocos2dxActivity.runOnUiThread(new m(i2, i3, i4, i5, i6));
    }

    private static native boolean shouldStartLoading(int i2, String str);

    public static void stopLoading(int i2) {
        sCocos2dxActivity.runOnUiThread(new b(i2));
    }

    public void onActivityResultAboveL(int i2, int i3, Intent intent) {
        Cocos2dxWebView cocos2dxWebView = webViews.get(viewTag - 1);
        if (cocos2dxWebView != null) {
            cocos2dxWebView.onActivityResultAboveL(i2, i3, intent);
        }
    }
}
