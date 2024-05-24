package org.cocos2dx.lib;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import java.net.URI;
import java.util.concurrent.CountDownLatch;

public class Cocos2dxWebView extends WebView {
    /* access modifiers changed from: private */
    public static final String TAG = Cocos2dxWebViewHelper.class.getSimpleName();
    private final int FILE_CHOOSER_RESULTCODE;
    /* access modifiers changed from: private */
    public String mJSScheme;
    /* access modifiers changed from: private */
    public ValueCallback<Uri[]> mUploadCallbackAboveL;
    /* access modifiers changed from: private */
    public ValueCallback<Uri> mUploadMessage;
    /* access modifiers changed from: private */
    public int mViewTag;

    class a extends WebChromeClient {
        a() {
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            ValueCallback unused = Cocos2dxWebView.this.mUploadCallbackAboveL = valueCallback;
            Cocos2dxWebView.this.openImageChooserActivity();
            return true;
        }
    }

    class b extends WebViewClient {

        class a implements Runnable {
            final /* synthetic */ String j;

            a(String str) {
                this.j = str;
            }

            public void run() {
                Cocos2dxWebViewHelper._onJsCallback(Cocos2dxWebView.this.mViewTag, this.j);
            }
        }

        /* renamed from: org.cocos2dx.lib.Cocos2dxWebView$b$b  reason: collision with other inner class name */
        class C0086b implements Runnable {
            final /* synthetic */ String j;

            C0086b(String str) {
                this.j = str;
            }

            public void run() {
                Cocos2dxWebViewHelper._didFinishLoading(Cocos2dxWebView.this.mViewTag, this.j);
            }
        }

        class c implements Runnable {
            final /* synthetic */ String j;

            c(String str) {
                this.j = str;
            }

            public void run() {
                Cocos2dxWebViewHelper._didFailLoading(Cocos2dxWebView.this.mViewTag, this.j);
            }
        }

        b() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ((Cocos2dxActivity) Cocos2dxWebView.this.getContext()).runOnGLThread(new C0086b(str));
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            ((Cocos2dxActivity) Cocos2dxWebView.this.getContext()).runOnGLThread(new c(str2));
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Cocos2dxActivity cocos2dxActivity = (Cocos2dxActivity) Cocos2dxWebView.this.getContext();
            try {
                URI create = URI.create(str);
                if (create != null && create.getScheme().equals(Cocos2dxWebView.this.mJSScheme)) {
                    cocos2dxActivity.runOnGLThread(new a(str));
                    return true;
                }
            } catch (Exception unused) {
                Log.d(Cocos2dxWebView.TAG, "Failed to create URI from url");
            }
            boolean[] zArr = {true};
            CountDownLatch countDownLatch = new CountDownLatch(1);
            cocos2dxActivity.runOnGLThread(new a(countDownLatch, zArr, Cocos2dxWebView.this.mViewTag, str));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused2) {
                Log.d(Cocos2dxWebView.TAG, "'shouldOverrideUrlLoading' failed");
            }
            return zArr[0];
        }
    }

    public Cocos2dxWebView(Context context) {
        this(context, -1);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public Cocos2dxWebView(Context context, int i) {
        super(context);
        this.FILE_CHOOSER_RESULTCODE = 77777;
        this.mViewTag = i;
        this.mJSScheme = "";
        setFocusable(true);
        setFocusableInTouchMode(true);
        getSettings().setSupportZoom(false);
        getSettings().setDomStorageEnabled(true);
        getSettings().setJavaScriptEnabled(true);
        try {
            getClass().getMethod("removeJavascriptInterface", new Class[]{String.class}).invoke(this, new Object[]{"searchBoxJavaBridge_"});
        } catch (Exception unused) {
            Log.d(TAG, "This API level do not support `removeJavascriptInterface`");
        }
        setWebViewClient(new b());
        setWebChromeClient(new a());
    }

    /* access modifiers changed from: private */
    public void openImageChooserActivity() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        ((Cocos2dxActivity) Cocos2dxActivity.getContext()).startActivityForResult(Intent.createChooser(intent, "Image Chooser"), 77777);
    }

    public void onActivityResultAboveL(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (i == 77777 && this.mUploadCallbackAboveL != null) {
            if (i2 != -1 || intent == null) {
                uriArr = null;
            } else {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    uriArr = new Uri[clipData.getItemCount()];
                    for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                        uriArr[i3] = clipData.getItemAt(i3).getUri();
                    }
                } else {
                    uriArr = null;
                }
                if (dataString != null) {
                    uriArr = new Uri[]{Uri.parse(dataString)};
                }
            }
            this.mUploadCallbackAboveL.onReceiveValue(uriArr);
            this.mUploadCallbackAboveL = null;
        }
    }

    public void setJavascriptInterfaceScheme(String str) {
        if (str == null) {
            str = "";
        }
        this.mJSScheme = str;
    }

    public void setScalesPageToFit(boolean z) {
        getSettings().setSupportZoom(z);
    }

    public void setWebViewRect(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.width = i3;
        layoutParams.height = i4;
        setLayoutParams(layoutParams);
    }
}
