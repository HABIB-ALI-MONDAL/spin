package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.o;
import b.a.f;
import b.d.k.l;
import b.d.k.m;
import b.d.k.p;

public class ActionBarOverlayLayout extends ViewGroup implements a0, l {
    static final int[] K = {b.a.a.actionBarSize, 16842841};
    private final Rect A = new Rect();
    private final Rect B = new Rect();
    private final Rect C = new Rect();
    private d D;
    private OverScroller E;
    ViewPropertyAnimator F;
    final AnimatorListenerAdapter G = new a();
    private final Runnable H = new b();
    private final Runnable I = new c();
    private final m J;
    private int j;
    private int k = 0;
    private ContentFrameLayout l;
    ActionBarContainer m;
    private b0 n;
    private Drawable o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    boolean t;
    private int u;
    private int v;
    private final Rect w = new Rect();
    private final Rect x = new Rect();
    private final Rect y = new Rect();
    private final Rect z = new Rect();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = null;
            actionBarOverlayLayout.t = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = null;
            actionBarOverlayLayout.t = false;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = actionBarOverlayLayout.m.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.G);
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.F = actionBarOverlayLayout.m.animate().translationY((float) (-ActionBarOverlayLayout.this.m.getHeight())).setListener(ActionBarOverlayLayout.this.G);
        }
    }

    public interface d {
        void a(boolean z);

        void b();

        void c();

        void d(int i);

        void e();

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int i, int i2) {
            super(i, i2);
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        v(context);
        this.J = new m(this);
    }

    private void A() {
        u();
        this.H.run();
    }

    private boolean B(float f2, float f3) {
        this.E.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.E.getFinalY() > this.m.getHeight();
    }

    private void p() {
        u();
        this.I.run();
    }

    private boolean q(View view, Rect rect, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        int i;
        int i2;
        int i3;
        int i4;
        e eVar = (e) view.getLayoutParams();
        if (!z2 || eVar.leftMargin == (i4 = rect.left)) {
            z6 = false;
        } else {
            eVar.leftMargin = i4;
            z6 = true;
        }
        if (z3 && eVar.topMargin != (i3 = rect.top)) {
            eVar.topMargin = i3;
            z6 = true;
        }
        if (z5 && eVar.rightMargin != (i2 = rect.right)) {
            eVar.rightMargin = i2;
            z6 = true;
        }
        if (!z4 || eVar.bottomMargin == (i = rect.bottom)) {
            return z6;
        }
        eVar.bottomMargin = i;
        return true;
    }

    private b0 t(View view) {
        if (view instanceof b0) {
            return (b0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(K);
        boolean z2 = false;
        this.j = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.o = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.p = z2;
        this.E = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.I, 600);
    }

    private void y() {
        u();
        postDelayed(this.H, 600);
    }

    public void a(Menu menu, o.a aVar) {
        z();
        this.n.a(menu, aVar);
    }

    public boolean b() {
        z();
        return this.n.b();
    }

    public boolean c() {
        z();
        return this.n.c();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public boolean d() {
        z();
        return this.n.d();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.o != null && !this.p) {
            int bottom = this.m.getVisibility() == 0 ? (int) (((float) this.m.getBottom()) + this.m.getTranslationY() + 0.5f) : 0;
            this.o.setBounds(0, bottom, getWidth(), this.o.getIntrinsicHeight() + bottom);
            this.o.draw(canvas);
        }
    }

    public boolean e() {
        z();
        return this.n.e();
    }

    public void f() {
        z();
        this.n.f();
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        z();
        int n2 = p.n(this) & 256;
        boolean q2 = q(this.m, rect, true, true, false, true);
        this.z.set(rect);
        z0.a(this, this.z, this.w);
        if (!this.A.equals(this.z)) {
            this.A.set(this.z);
            q2 = true;
        }
        if (!this.x.equals(this.w)) {
            this.x.set(this.w);
            q2 = true;
        }
        if (q2) {
            requestLayout();
        }
        return true;
    }

    public boolean g() {
        z();
        return this.n.g();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.m;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.J.a();
    }

    public CharSequence getTitle() {
        z();
        return this.n.getTitle();
    }

    public void k(int i) {
        z();
        if (i == 2) {
            this.n.t();
        } else if (i == 5) {
            this.n.v();
        } else if (i == 109) {
            setOverlayMode(true);
        }
    }

    public void l() {
        z();
        this.n.h();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        p.A(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = eVar.leftMargin + paddingLeft;
                int i7 = eVar.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        z();
        measureChildWithMargins(this.m, i, 0, i2, 0);
        e eVar = (e) this.m.getLayoutParams();
        int max = Math.max(0, this.m.getMeasuredWidth() + eVar.leftMargin + eVar.rightMargin);
        int max2 = Math.max(0, this.m.getMeasuredHeight() + eVar.topMargin + eVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.m.getMeasuredState());
        boolean z2 = (p.n(this) & 256) != 0;
        if (z2) {
            i3 = this.j;
            if (this.r && this.m.getTabContainer() != null) {
                i3 += this.j;
            }
        } else {
            i3 = this.m.getVisibility() != 8 ? this.m.getMeasuredHeight() : 0;
        }
        this.y.set(this.w);
        this.B.set(this.z);
        Rect rect = (this.q || z2) ? this.B : this.y;
        rect.top += i3;
        rect.bottom += 0;
        q(this.l, this.y, true, true, true, true);
        if (!this.C.equals(this.B)) {
            this.C.set(this.B);
            this.l.a(this.B);
        }
        measureChildWithMargins(this.l, i, 0, i2, 0);
        e eVar2 = (e) this.l.getLayoutParams();
        int max3 = Math.max(max, this.l.getMeasuredWidth() + eVar2.leftMargin + eVar2.rightMargin);
        int max4 = Math.max(max2, this.l.getMeasuredHeight() + eVar2.topMargin + eVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.l.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (!this.s || !z2) {
            return false;
        }
        if (B(f2, f3)) {
            p();
        } else {
            A();
        }
        this.t = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.u + i2;
        this.u = i5;
        setActionBarHideOffset(i5);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.J.b(view, view2, i);
        this.u = getActionBarHideOffset();
        u();
        d dVar = this.D;
        if (dVar != null) {
            dVar.c();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.m.getVisibility() != 0) {
            return false;
        }
        return this.s;
    }

    public void onStopNestedScroll(View view) {
        if (this.s && !this.t) {
            if (this.u <= this.m.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.D;
        if (dVar != null) {
            dVar.f();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        z();
        int i2 = this.v ^ i;
        this.v = i;
        boolean z2 = false;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z2 = true;
        }
        d dVar = this.D;
        if (dVar != null) {
            dVar.a(!z2);
            if (z3 || !z2) {
                this.D.b();
            } else {
                this.D.e();
            }
        }
        if ((i2 & 256) != 0 && this.D != null) {
            p.A(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.k = i;
        d dVar = this.D;
        if (dVar != null) {
            dVar.d(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    /* renamed from: s */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i) {
        u();
        this.m.setTranslationY((float) (-Math.max(0, Math.min(i, this.m.getHeight()))));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.D = dVar;
        if (getWindowToken() != null) {
            this.D.d(this.k);
            int i = this.v;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                p.A(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.r = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.s) {
            this.s = z2;
            if (!z2) {
                u();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        z();
        this.n.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.n.setIcon(drawable);
    }

    public void setLogo(int i) {
        z();
        this.n.m(i);
    }

    public void setOverlayMode(boolean z2) {
        this.q = z2;
        this.p = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Window.Callback callback) {
        z();
        this.n.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.n.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        removeCallbacks(this.H);
        removeCallbacks(this.I);
        ViewPropertyAnimator viewPropertyAnimator = this.F;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        if (this.l == null) {
            this.l = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.m = (ActionBarContainer) findViewById(f.action_bar_container);
            this.n = t(findViewById(f.action_bar));
        }
    }
}
