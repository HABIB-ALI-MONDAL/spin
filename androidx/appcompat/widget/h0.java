package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.s;
import androidx.core.widget.h;
import b.a.j;
import b.d.k.p;
import java.lang.reflect.Method;

public class h0 implements s {
    private static Method O;
    private static Method P;
    private static Method Q;
    private DataSetObserver A;
    private View B;
    private Drawable C;
    private AdapterView.OnItemClickListener D;
    private AdapterView.OnItemSelectedListener E;
    final f F;
    private final e G;
    private final d H;
    private final b I;
    final Handler J;
    private final Rect K;
    private Rect L;
    private boolean M;
    PopupWindow N;
    private Context j;
    private ListAdapter k;
    d0 l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private boolean v;
    private boolean w;
    int x;
    private View y;
    private int z;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
            d0 d0Var;
            if (i != -1 && (d0Var = h0.this.l) != null) {
                d0Var.setListSelectionHidden(false);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            h0.this.e();
        }
    }

    private class c extends DataSetObserver {
        c() {
        }

        public void onChanged() {
            if (h0.this.f()) {
                h0.this.b();
            }
        }

        public void onInvalidated() {
            h0.this.dismiss();
        }
    }

    private class d implements AbsListView.OnScrollListener {
        d() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !h0.this.o() && h0.this.N.getContentView() != null) {
                h0 h0Var = h0.this;
                h0Var.J.removeCallbacks(h0Var.F);
                h0.this.F.run();
            }
        }
    }

    private class e implements View.OnTouchListener {
        e() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = h0.this.N) != null && popupWindow.isShowing() && x >= 0 && x < h0.this.N.getWidth() && y >= 0 && y < h0.this.N.getHeight()) {
                h0 h0Var = h0.this;
                h0Var.J.postDelayed(h0Var.F, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                h0 h0Var2 = h0.this;
                h0Var2.J.removeCallbacks(h0Var2.F);
                return false;
            }
        }
    }

    private class f implements Runnable {
        f() {
        }

        public void run() {
            d0 d0Var = h0.this.l;
            if (d0Var != null && p.r(d0Var) && h0.this.l.getCount() > h0.this.l.getChildCount()) {
                int childCount = h0.this.l.getChildCount();
                h0 h0Var = h0.this;
                if (childCount <= h0Var.x) {
                    h0Var.N.setInputMethodMode(2);
                    h0.this.b();
                }
            }
        }
    }

    static {
        Class cls = Boolean.TYPE;
        try {
            O = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{cls});
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        Class<PopupWindow> cls2 = PopupWindow.class;
        try {
            P = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, cls});
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            Q = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public h0(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public h0(Context context, AttributeSet attributeSet, int i, int i2) {
        this.m = -2;
        this.n = -2;
        this.q = 1002;
        this.u = 0;
        this.v = false;
        this.w = false;
        this.x = Integer.MAX_VALUE;
        this.z = 0;
        this.F = new f();
        this.G = new e();
        this.H = new d();
        this.I = new b();
        this.K = new Rect();
        this.j = context;
        this.J = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.j1, i, i2);
        this.o = obtainStyledAttributes.getDimensionPixelOffset(j.k1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(j.l1, 0);
        this.p = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.r = true;
        }
        obtainStyledAttributes.recycle();
        q qVar = new q(context, attributeSet, i, i2);
        this.N = qVar;
        qVar.setInputMethodMode(1);
    }

    private void E(boolean z2) {
        Method method = O;
        if (method != null) {
            try {
                method.invoke(this.N, new Object[]{Boolean.valueOf(z2)});
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: androidx.appcompat.widget.d0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.d0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: androidx.appcompat.widget.d0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int d() {
        /*
            r12 = this;
            androidx.appcompat.widget.d0 r0 = r12.l
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00b8
            android.content.Context r0 = r12.j
            boolean r5 = r12.M
            r5 = r5 ^ r3
            androidx.appcompat.widget.d0 r5 = r12.h(r0, r5)
            r12.l = r5
            android.graphics.drawable.Drawable r6 = r12.C
            if (r6 == 0) goto L_0x001b
            r5.setSelector(r6)
        L_0x001b:
            androidx.appcompat.widget.d0 r5 = r12.l
            android.widget.ListAdapter r6 = r12.k
            r5.setAdapter(r6)
            androidx.appcompat.widget.d0 r5 = r12.l
            android.widget.AdapterView$OnItemClickListener r6 = r12.D
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.d0 r5 = r12.l
            r5.setFocusable(r3)
            androidx.appcompat.widget.d0 r5 = r12.l
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.d0 r5 = r12.l
            androidx.appcompat.widget.h0$a r6 = new androidx.appcompat.widget.h0$a
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.d0 r5 = r12.l
            androidx.appcompat.widget.h0$d r6 = r12.H
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.E
            if (r5 == 0) goto L_0x004d
            androidx.appcompat.widget.d0 r6 = r12.l
            r6.setOnItemSelectedListener(r5)
        L_0x004d:
            androidx.appcompat.widget.d0 r5 = r12.l
            android.view.View r6 = r12.y
            if (r6 == 0) goto L_0x00b1
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.z
            if (r8 == 0) goto L_0x0088
            if (r8 == r3) goto L_0x0081
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.z
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x008e
        L_0x0081:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x008e
        L_0x0088:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x008e:
            int r0 = r12.n
            if (r0 < 0) goto L_0x0095
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0097
        L_0x0095:
            r0 = 0
            r5 = 0
        L_0x0097:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00b2
        L_0x00b1:
            r0 = 0
        L_0x00b2:
            android.widget.PopupWindow r6 = r12.N
            r6.setContentView(r5)
            goto L_0x00d6
        L_0x00b8:
            android.widget.PopupWindow r0 = r12.N
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.y
            if (r0 == 0) goto L_0x00d5
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00d6
        L_0x00d5:
            r0 = 0
        L_0x00d6:
            android.widget.PopupWindow r5 = r12.N
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00f2
            android.graphics.Rect r6 = r12.K
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.K
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.r
            if (r7 != 0) goto L_0x00f8
            int r6 = -r6
            r12.p = r6
            goto L_0x00f8
        L_0x00f2:
            android.graphics.Rect r5 = r12.K
            r5.setEmpty()
            r5 = 0
        L_0x00f8:
            android.widget.PopupWindow r6 = r12.N
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0102
            goto L_0x0103
        L_0x0102:
            r3 = 0
        L_0x0103:
            android.view.View r4 = r12.i()
            int r6 = r12.p
            int r3 = r12.l(r4, r6, r3)
            boolean r4 = r12.v
            if (r4 != 0) goto L_0x015b
            int r4 = r12.m
            if (r4 != r2) goto L_0x0116
            goto L_0x015b
        L_0x0116:
            int r4 = r12.n
            r6 = -2
            if (r4 == r6) goto L_0x0124
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x0124
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
            goto L_0x013c
        L_0x0124:
            android.content.Context r2 = r12.j
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.K
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
        L_0x013c:
            r7 = r1
            androidx.appcompat.widget.d0 r6 = r12.l
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.d(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0159
            androidx.appcompat.widget.d0 r2 = r12.l
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.d0 r3 = r12.l
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0159:
            int r1 = r1 + r0
            return r1
        L_0x015b:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.h0.d():int");
    }

    private int l(View view, int i, boolean z2) {
        Method method = P;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.N, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z2)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.N.getMaxAvailableHeight(view, i);
    }

    private void q() {
        View view = this.y;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.y);
            }
        }
    }

    public void A(boolean z2) {
        this.M = z2;
        this.N.setFocusable(z2);
    }

    public void B(PopupWindow.OnDismissListener onDismissListener) {
        this.N.setOnDismissListener(onDismissListener);
    }

    public void C(AdapterView.OnItemClickListener onItemClickListener) {
        this.D = onItemClickListener;
    }

    public void D(boolean z2) {
        this.t = true;
        this.s = z2;
    }

    public void F(int i) {
        this.z = i;
    }

    public void G(int i) {
        d0 d0Var = this.l;
        if (f() && d0Var != null) {
            d0Var.setListSelectionHidden(false);
            d0Var.setSelection(i);
            if (d0Var.getChoiceMode() != 0) {
                d0Var.setItemChecked(i, true);
            }
        }
    }

    public void H(int i) {
        this.p = i;
        this.r = true;
    }

    public void I(int i) {
        this.n = i;
    }

    public void b() {
        int d2 = d();
        boolean o2 = o();
        h.b(this.N, this.q);
        boolean z2 = true;
        if (!this.N.isShowing()) {
            int i = this.n;
            if (i == -1) {
                i = -1;
            } else if (i == -2) {
                i = i().getWidth();
            }
            int i2 = this.m;
            if (i2 == -1) {
                d2 = -1;
            } else if (i2 != -2) {
                d2 = i2;
            }
            this.N.setWidth(i);
            this.N.setHeight(d2);
            E(true);
            this.N.setOutsideTouchable(!this.w && !this.v);
            this.N.setTouchInterceptor(this.G);
            if (this.t) {
                h.a(this.N, this.s);
            }
            Method method = Q;
            if (method != null) {
                try {
                    method.invoke(this.N, new Object[]{this.L});
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
            h.c(this.N, i(), this.o, this.p, this.u);
            this.l.setSelection(-1);
            if (!this.M || this.l.isInTouchMode()) {
                e();
            }
            if (!this.M) {
                this.J.post(this.I);
            }
        } else if (p.r(i())) {
            int i3 = this.n;
            if (i3 == -1) {
                i3 = -1;
            } else if (i3 == -2) {
                i3 = i().getWidth();
            }
            int i4 = this.m;
            if (i4 == -1) {
                if (!o2) {
                    d2 = -1;
                }
                if (o2) {
                    this.N.setWidth(this.n == -1 ? -1 : 0);
                    this.N.setHeight(0);
                } else {
                    this.N.setWidth(this.n == -1 ? -1 : 0);
                    this.N.setHeight(-1);
                }
            } else if (i4 != -2) {
                d2 = i4;
            }
            PopupWindow popupWindow = this.N;
            if (this.w || this.v) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            this.N.update(i(), this.o, this.p, i3 < 0 ? -1 : i3, d2 < 0 ? -1 : d2);
        }
    }

    public void dismiss() {
        this.N.dismiss();
        q();
        this.N.setContentView((View) null);
        this.l = null;
        this.J.removeCallbacks(this.F);
    }

    public void e() {
        d0 d0Var = this.l;
        if (d0Var != null) {
            d0Var.setListSelectionHidden(true);
            d0Var.requestLayout();
        }
    }

    public boolean f() {
        return this.N.isShowing();
    }

    public ListView g() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public d0 h(Context context, boolean z2) {
        return new d0(context, z2);
    }

    public View i() {
        return this.B;
    }

    public Drawable j() {
        return this.N.getBackground();
    }

    public int k() {
        return this.o;
    }

    public int m() {
        if (!this.r) {
            return 0;
        }
        return this.p;
    }

    public int n() {
        return this.n;
    }

    public boolean o() {
        return this.N.getInputMethodMode() == 2;
    }

    public boolean p() {
        return this.M;
    }

    public void r(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.A;
        if (dataSetObserver == null) {
            this.A = new c();
        } else {
            ListAdapter listAdapter2 = this.k;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.k = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.A);
        }
        d0 d0Var = this.l;
        if (d0Var != null) {
            d0Var.setAdapter(this.k);
        }
    }

    public void s(View view) {
        this.B = view;
    }

    public void t(int i) {
        this.N.setAnimationStyle(i);
    }

    public void u(Drawable drawable) {
        this.N.setBackgroundDrawable(drawable);
    }

    public void v(int i) {
        Drawable background = this.N.getBackground();
        if (background != null) {
            background.getPadding(this.K);
            Rect rect = this.K;
            this.n = rect.left + rect.right + i;
            return;
        }
        I(i);
    }

    public void w(int i) {
        this.u = i;
    }

    public void x(Rect rect) {
        this.L = rect;
    }

    public void y(int i) {
        this.o = i;
    }

    public void z(int i) {
        this.N.setInputMethodMode(i);
    }
}
