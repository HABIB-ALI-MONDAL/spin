package org.cocos2dx.lib;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Cocos2dxEditBox {
    /* access modifiers changed from: private */
    public static final int DARK_GREEN = Color.parseColor("#1fa014");
    private static final int DARK_GREEN_PRESS = Color.parseColor("#008e26");
    /* access modifiers changed from: private */
    public static Cocos2dxEditBox sThis = null;
    private boolean bSendImg = true;
    /* access modifiers changed from: private */
    public Cocos2dxActivity mActivity = null;
    private Button mButton = null;
    private RelativeLayout mButtonLayout = null;
    private int mButtonLayoutID = 2;
    private RelativeLayout.LayoutParams mButtonParams;
    /* access modifiers changed from: private */
    public String mButtonTitle = null;
    /* access modifiers changed from: private */
    public boolean mConfirmHold = true;
    /* access modifiers changed from: private */
    public g mEditText = null;
    private int mEditTextID = 1;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            Cocos2dxEditBox cocos2dxEditBox = Cocos2dxEditBox.this;
            cocos2dxEditBox.onKeyboardConfirm(cocos2dxEditBox.mEditText.getText().toString());
            if (!Cocos2dxEditBox.this.mConfirmHold) {
                Cocos2dxEditBox.this.hide();
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ String j;
        final /* synthetic */ int k;
        final /* synthetic */ boolean l;
        final /* synthetic */ boolean m;
        final /* synthetic */ String n;
        final /* synthetic */ String o;

        b(String str, int i, boolean z, boolean z2, String str2, String str3) {
            this.j = str;
            this.k = i;
            this.l = z;
            this.m = z2;
            this.n = str2;
            this.o = str3;
        }

        public void run() {
            Cocos2dxEditBox.sThis.show(this.j, this.k, this.l, this.m, this.n, this.o);
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            Cocos2dxEditBox.sThis.hide();
        }
    }

    class d implements Runnable {
        final /* synthetic */ String j;

        d(Cocos2dxEditBox cocos2dxEditBox, String str) {
            this.j = str;
        }

        public void run() {
            Cocos2dxEditBox.onKeyboardInputNative(this.j);
        }
    }

    class e implements Runnable {
        final /* synthetic */ String j;

        e(Cocos2dxEditBox cocos2dxEditBox, String str) {
            this.j = str;
        }

        public void run() {
            Cocos2dxEditBox.onKeyboardCompleteNative(this.j);
        }
    }

    class f implements Runnable {
        final /* synthetic */ String j;

        f(Cocos2dxEditBox cocos2dxEditBox, String str) {
            this.j = str;
        }

        public void run() {
            Cocos2dxEditBox.onKeyboardConfirmNative(this.j);
        }
    }

    class g extends EditText {
        /* access modifiers changed from: private */
        public boolean j = false;
        private TextWatcher k = null;
        private Paint l;
        private int m = Cocos2dxEditBox.DARK_GREEN;
        private float n = 2.0f;
        /* access modifiers changed from: private */
        public boolean o = false;
        /* access modifiers changed from: private */
        public int p;
        /* access modifiers changed from: private */
        public int q = 0;

        class a implements TextWatcher {
            a(Cocos2dxEditBox cocos2dxEditBox) {
            }

            public void afterTextChanged(Editable editable) {
                Cocos2dxEditBox.this.onKeyboardInput(editable.toString());
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        }

        class b implements TextView.OnEditorActionListener {
            b() {
            }

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (g.this.j) {
                    return false;
                }
                Cocos2dxEditBox.this.hide();
                return false;
            }
        }

        class c implements ViewTreeObserver.OnGlobalLayoutListener {
            c() {
            }

            public void onGlobalLayout() {
                Rect rect = new Rect();
                g.this.getWindowVisibleDisplayFrame(rect);
                if (g.this.getRootView().getHeight() - (rect.bottom - rect.top) > g.this.p / 4) {
                    if (!g.this.o) {
                        boolean unused = g.this.o = true;
                    }
                } else if (g.this.o) {
                    boolean unused2 = g.this.o = false;
                    Cocos2dxEditBox.this.hide();
                }
                if (g.this.q == 0 && rect.bottom != g.this.getRootView().getHeight()) {
                    g.this.m(rect.bottom);
                }
            }
        }

        public g(Cocos2dxActivity cocos2dxActivity) {
            super(cocos2dxActivity);
            setBackground((Drawable) null);
            setTextColor(-16777216);
            this.p = ((WindowManager) cocos2dxActivity.getSystemService("window")).getDefaultDisplay().getHeight();
            Paint paint = new Paint();
            this.l = paint;
            paint.setStrokeWidth(this.n);
            this.l.setStyle(Paint.Style.FILL);
            this.l.setColor(this.m);
            this.k = new a(Cocos2dxEditBox.this);
            i();
        }

        private void g() {
            setOnEditorActionListener(new b());
            addTextChangedListener(this.k);
        }

        private void i() {
            getViewTreeObserver().addOnGlobalLayoutListener(new c());
        }

        private void j() {
            setOnEditorActionListener((TextView.OnEditorActionListener) null);
            removeTextChangedListener(this.k);
        }

        private void k(String str) {
            Cocos2dxEditBox cocos2dxEditBox;
            Resources resources;
            int i;
            if (str.contentEquals("done")) {
                setImeOptions(268435462);
                cocos2dxEditBox = Cocos2dxEditBox.this;
                resources = cocos2dxEditBox.mActivity.getResources();
                i = R.string.done;
            } else if (str.contentEquals("next")) {
                setImeOptions(268435461);
                cocos2dxEditBox = Cocos2dxEditBox.this;
                resources = cocos2dxEditBox.mActivity.getResources();
                i = R.string.next;
            } else if (str.contentEquals("search")) {
                setImeOptions(268435459);
                cocos2dxEditBox = Cocos2dxEditBox.this;
                resources = cocos2dxEditBox.mActivity.getResources();
                i = R.string.search;
            } else if (str.contentEquals("go")) {
                setImeOptions(268435458);
                cocos2dxEditBox = Cocos2dxEditBox.this;
                resources = cocos2dxEditBox.mActivity.getResources();
                i = R.string.go;
            } else if (str.contentEquals("send")) {
                setImeOptions(268435460);
                cocos2dxEditBox = Cocos2dxEditBox.this;
                resources = cocos2dxEditBox.mActivity.getResources();
                i = R.string.send;
            } else {
                String unused = Cocos2dxEditBox.this.mButtonTitle = null;
                Log.e("Cocos2dxEditBox", "unknown confirm type " + str);
                return;
            }
            String unused2 = cocos2dxEditBox.mButtonTitle = resources.getString(i);
        }

        private void l(String str, boolean z) {
            int i;
            if (str.contentEquals("text")) {
                i = z ? 131073 : 1;
            } else if (str.contentEquals("email")) {
                i = 32;
            } else if (str.contentEquals("number")) {
                i = 12290;
            } else if (str.contentEquals("phone")) {
                i = 3;
            } else if (str.contentEquals("password")) {
                i = 129;
            } else {
                Log.e("Cocos2dxEditBox", "unknown input type " + str);
                return;
            }
            setInputType(i);
        }

        /* access modifiers changed from: private */
        public void m(int i) {
            this.q = i;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) Cocos2dxEditBox.this.mEditText.getLayoutParams();
            layoutParams.topMargin = this.q - getHeight();
            setLayoutParams(layoutParams);
            requestLayout();
        }

        public void h() {
            Cocos2dxEditBox.this.mEditText.setVisibility(4);
            j();
        }

        public void n(String str, int i, boolean z, boolean z2, String str2, String str3) {
            this.j = z;
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
            setText(str);
            setSelection(getText().length() >= str.length() ? str.length() : getText().length());
            k(str2);
            l(str3, this.j);
            setVisibility(0);
            requestFocus();
            g();
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            int paddingBottom = getPaddingBottom() / 2;
            canvas.drawLine((float) getScrollX(), ((float) (getHeight() - paddingBottom)) - this.n, (float) (getScrollX() + getWidth()), ((float) (getHeight() - paddingBottom)) - this.n, this.l);
            super.onDraw(canvas);
        }
    }

    public Cocos2dxEditBox(Cocos2dxActivity cocos2dxActivity, FrameLayout frameLayout) {
        sThis = this;
        this.mActivity = cocos2dxActivity;
        addItems(cocos2dxActivity, frameLayout);
    }

    private void addButton(Cocos2dxActivity cocos2dxActivity, RelativeLayout relativeLayout) {
        this.mButton = new Button(cocos2dxActivity);
        this.mButtonParams = new RelativeLayout.LayoutParams(-2, -2);
        this.mButton.setTextColor(-1);
        if (this.bSendImg) {
            this.mButton.setBackground(cocos2dxActivity.getResources().getDrawable(R.drawable.edit_send));
        } else {
            this.mButton.setBackground(getRoundRectShape());
        }
        RelativeLayout relativeLayout2 = new RelativeLayout(Cocos2dxHelper.getActivity());
        this.mButtonLayout = relativeLayout2;
        relativeLayout2.setVisibility(4);
        this.mButtonLayout.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(8, this.mEditTextID);
        layoutParams.addRule(6, this.mEditTextID);
        this.mButtonLayout.addView(this.mButton, this.mButtonParams);
        this.mButtonLayout.setId(this.mButtonLayoutID);
        relativeLayout.addView(this.mButtonLayout, layoutParams);
        this.mButton.setOnClickListener(new a());
    }

    private void addEditText(Cocos2dxActivity cocos2dxActivity, RelativeLayout relativeLayout) {
        g gVar = new g(cocos2dxActivity);
        this.mEditText = gVar;
        gVar.setVisibility(4);
        this.mEditText.setBackgroundColor(-1);
        this.mEditText.setId(this.mEditTextID);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(0, this.mButtonLayoutID);
        relativeLayout.addView(this.mEditText, layoutParams);
    }

    private void addItems(Cocos2dxActivity cocos2dxActivity, FrameLayout frameLayout) {
        RelativeLayout relativeLayout = new RelativeLayout(cocos2dxActivity);
        addEditText(cocos2dxActivity, relativeLayout);
        addButton(cocos2dxActivity, relativeLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        frameLayout.addView(relativeLayout, layoutParams);
    }

    private void closeKeyboard() {
        ((InputMethodManager) this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.mEditText.getWindowToken(), 0);
        onKeyboardComplete(this.mEditText.getText().toString());
    }

    public static void complete() {
        sThis.hide();
    }

    private Drawable getRoundRectShape() {
        float f2 = (float) 7;
        RoundRectShape roundRectShape = new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, (RectF) null, (float[]) null);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(roundRectShape);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.getPaint().setColor(DARK_GREEN);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable();
        shapeDrawable2.setShape(roundRectShape);
        shapeDrawable2.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable2.getPaint().setColor(DARK_GREEN_PRESS);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, shapeDrawable2);
        stateListDrawable.addState(new int[0], shapeDrawable);
        return stateListDrawable;
    }

    /* access modifiers changed from: private */
    public void hide() {
        Utils.hideVirtualButton();
        this.mEditText.h();
        this.mButtonLayout.setVisibility(4);
        closeKeyboard();
        this.mActivity.getGLSurfaceView().requestFocus();
        this.mActivity.getGLSurfaceView().setStopHandleTouchAndKeyEvents(false);
    }

    private static void hideNative() {
        Cocos2dxEditBox cocos2dxEditBox = sThis;
        if (cocos2dxEditBox != null) {
            cocos2dxEditBox.mActivity.runOnUiThread(new c());
        }
    }

    private void onKeyboardComplete(String str) {
        this.mActivity.getGLSurfaceView().requestFocus();
        this.mActivity.getGLSurfaceView().setStopHandleTouchAndKeyEvents(false);
        this.mActivity.runOnGLThread(new e(this, str));
    }

    /* access modifiers changed from: private */
    public static native void onKeyboardCompleteNative(String str);

    /* access modifiers changed from: private */
    public void onKeyboardConfirm(String str) {
        this.mActivity.runOnGLThread(new f(this, str));
    }

    /* access modifiers changed from: private */
    public static native void onKeyboardConfirmNative(String str);

    /* access modifiers changed from: private */
    public void onKeyboardInput(String str) {
        this.mActivity.runOnGLThread(new d(this, str));
    }

    /* access modifiers changed from: private */
    public static native void onKeyboardInputNative(String str);

    private void openKeyboard() {
        ((InputMethodManager) this.mActivity.getSystemService("input_method")).showSoftInput(this.mEditText, 1);
    }

    /* access modifiers changed from: private */
    public void show(String str, int i, boolean z, boolean z2, String str2, String str3) {
        this.mConfirmHold = z2;
        this.mEditText.n(str, i, z, z2, str2, str3);
        int paddingBottom = this.mEditText.getPaddingBottom();
        int paddingTop = this.mEditText.getPaddingTop();
        this.mEditText.setPadding(paddingTop, paddingTop, paddingTop, paddingBottom);
        if (!this.bSendImg) {
            this.mButton.setText(this.mButtonTitle);
        }
        if (TextUtils.isEmpty(this.mButtonTitle)) {
            this.mButton.setPadding(0, 0, 0, 0);
            this.mButtonParams.setMargins(0, 0, 0, 0);
            this.mButtonLayout.setVisibility(4);
        } else {
            int paddingBottom2 = this.mEditText.getPaddingBottom() / 2;
            this.mButton.setPadding(paddingTop, paddingBottom2, paddingTop, paddingBottom2);
            this.mButtonParams.setMargins(0, paddingBottom2, 2, 0);
            this.mButtonLayout.setVisibility(0);
        }
        this.mActivity.getGLSurfaceView().setStopHandleTouchAndKeyEvents(true);
        openKeyboard();
    }

    private static void showNative(String str, int i, boolean z, boolean z2, String str2, String str3) {
        Cocos2dxEditBox cocos2dxEditBox = sThis;
        if (cocos2dxEditBox != null) {
            cocos2dxEditBox.mActivity.runOnUiThread(new b(str, i, z, z2, str2, str3));
        }
    }
}
