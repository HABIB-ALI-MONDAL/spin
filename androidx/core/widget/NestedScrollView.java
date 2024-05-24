package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import b.d.k.h;
import b.d.k.i;
import b.d.k.k;
import b.d.k.m;
import b.d.k.p;
import b.d.k.y.b;
import b.d.k.y.d;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements k, h {
    private static final a J = new a();
    private static final int[] K = {16843130};
    private final int[] A;
    private final int[] B;
    private int C;
    private int D;
    private c E;
    private final m F;
    private final i G;
    private float H;
    private b I;
    private long j;
    private final Rect k;
    private OverScroller l;
    private EdgeEffect m;
    private EdgeEffect n;
    private int o;
    private boolean p;
    private boolean q;
    private View r;
    private boolean s;
    private VelocityTracker t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int z;

    static class a extends b.d.k.a {
        a() {
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            d.a(accessibilityEvent, nestedScrollView.getScrollX());
            d.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public void g(View view, b.d.k.y.b bVar) {
            int scrollRange;
            super.g(view, bVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            bVar.I(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                bVar.M(true);
                if (nestedScrollView.getScrollY() > 0) {
                    bVar.a(b.a.f665e);
                    bVar.a(b.a.f666f);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    bVar.a(b.a.f664d);
                    bVar.a(b.a.g);
                }
            }
        }

        public boolean j(View view, int i, Bundle bundle) {
            if (super.j(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.N(0, max, true);
                    return true;
                } else if (i != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.N(0, min, true);
            return true;
        }
    }

    public interface b {
        void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public int j;

        static class a implements Parcelable.Creator<c> {
            a() {
            }

            /* renamed from: a */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            /* renamed from: b */
            public c[] newArray(int i) {
                return new c[i];
            }
        }

        c(Parcel parcel) {
            super(parcel);
            this.j = parcel.readInt();
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.j + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.j);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new Rect();
        this.p = true;
        this.q = false;
        this.r = null;
        this.s = false;
        this.v = true;
        this.z = -1;
        this.A = new int[2];
        this.B = new int[2];
        x();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, K, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.F = new m(this);
        this.G = new i(this);
        setNestedScrollingEnabled(true);
        p.C(this, J);
    }

    private static boolean A(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && A((View) parent, view2);
    }

    private boolean B(View view, int i, int i2) {
        view.getDrawingRect(this.k);
        offsetDescendantRectToMyCoords(view, this.k);
        return this.k.bottom + i >= getScrollY() && this.k.top - i <= getScrollY() + i2;
    }

    private void C(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.G.d(0, scrollY2, 0, i - scrollY2, (int[]) null, i2, iArr);
    }

    private void D(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.z) {
            int i = actionIndex == 0 ? 1 : 0;
            this.o = (int) motionEvent.getY(i);
            this.z = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.t;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void G() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.t = null;
        }
    }

    private void H(boolean z2) {
        if (z2) {
            O(2, 1);
        } else {
            P(1);
        }
        this.D = getScrollY();
        p.x(this);
    }

    private boolean I(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z2 = false;
        boolean z3 = i == 33;
        View r2 = r(z3, i2, i3);
        if (r2 == null) {
            r2 = this;
        }
        if (i2 < scrollY || i3 > i4) {
            k(z3 ? i2 - scrollY : i3 - i4);
            z2 = true;
        }
        if (r2 != findFocus()) {
            r2.requestFocus(i);
        }
        return z2;
    }

    private void J(View view) {
        view.getDrawingRect(this.k);
        offsetDescendantRectToMyCoords(view, this.k);
        int e2 = e(this.k);
        if (e2 != 0) {
            scrollBy(0, e2);
        }
    }

    private boolean K(Rect rect, boolean z2) {
        int e2 = e(rect);
        boolean z3 = e2 != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, e2);
            } else {
                L(0, e2);
            }
        }
        return z3;
    }

    private void M(int i, int i2, boolean z2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.j > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                OverScroller overScroller = this.l;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY);
                H(z2);
            } else {
                if (!this.l.isFinished()) {
                    a();
                }
                scrollBy(i, i2);
            }
            this.j = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    private void a() {
        this.l.abortAnimation();
        P(1);
    }

    private boolean c() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int d(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.H == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.H = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.H;
    }

    private void k(int i) {
        if (i == 0) {
            return;
        }
        if (this.v) {
            L(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void l() {
        this.s = false;
        G();
        P(0);
        EdgeEffect edgeEffect = this.m;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.n.onRelease();
        }
    }

    private void p() {
        if (getOverScrollMode() == 2) {
            this.m = null;
            this.n = null;
        } else if (this.m == null) {
            Context context = getContext();
            this.m = new EdgeEffect(context);
            this.n = new EdgeEffect(context);
        }
    }

    private View r(boolean z2, int i, int i2) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z4 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4) {
                            if (!z5) {
                            }
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (!z5) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private boolean v(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void w() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker == null) {
            this.t = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void x() {
        this.l = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.w = viewConfiguration.getScaledTouchSlop();
        this.x = viewConfiguration.getScaledMinimumFlingVelocity();
        this.y = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void y() {
        if (this.t == null) {
            this.t = VelocityTracker.obtain();
        }
    }

    private boolean z(View view) {
        return !B(view, 0, getHeight());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean E(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x002a
            if (r1 != r5) goto L_0x0028
            if (r2 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r2 = 0
            goto L_0x002b
        L_0x002a:
            r2 = 1
        L_0x002b:
            if (r1 == 0) goto L_0x0034
            if (r1 != r5) goto L_0x0032
            if (r3 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r1 = 0
            goto L_0x0035
        L_0x0034:
            r1 = 1
        L_0x0035:
            int r3 = r15 + r13
            if (r2 != 0) goto L_0x003b
            r2 = 0
            goto L_0x003d
        L_0x003b:
            r2 = r19
        L_0x003d:
            int r6 = r16 + r14
            if (r1 != 0) goto L_0x0043
            r1 = 0
            goto L_0x0045
        L_0x0043:
            r1 = r20
        L_0x0045:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L_0x0050
            r3 = r2
        L_0x004e:
            r2 = 1
            goto L_0x0055
        L_0x0050:
            if (r3 >= r7) goto L_0x0054
            r3 = r7
            goto L_0x004e
        L_0x0054:
            r2 = 0
        L_0x0055:
            if (r6 <= r1) goto L_0x005a
            r6 = r1
        L_0x0058:
            r1 = 1
            goto L_0x005f
        L_0x005a:
            if (r6 >= r8) goto L_0x005e
            r6 = r8
            goto L_0x0058
        L_0x005e:
            r1 = 0
        L_0x005f:
            if (r1 == 0) goto L_0x007e
            boolean r7 = r12.u(r5)
            if (r7 != 0) goto L_0x007e
            android.widget.OverScroller r7 = r0.l
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L_0x007e:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L_0x0085
            if (r1 == 0) goto L_0x0086
        L_0x0085:
            r4 = 1
        L_0x0086:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.E(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    public boolean F(int i) {
        boolean z2 = i == 130;
        int height = getHeight();
        if (z2) {
            this.k.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.k;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.k.top = getScrollY() - height;
            Rect rect2 = this.k;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.k;
        int i2 = rect3.top;
        int i3 = height + i2;
        rect3.bottom = i3;
        return I(i, i2, i3);
    }

    public final void L(int i, int i2) {
        M(i, i2, false);
    }

    /* access modifiers changed from: package-private */
    public void N(int i, int i2, boolean z2) {
        M(i - getScrollX(), i2 - getScrollY(), z2);
    }

    public boolean O(int i, int i2) {
        return this.G.m(i, i2);
    }

    public void P(int i) {
        this.G.n(i);
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !B(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            k(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.k);
            offsetDescendantRectToMyCoords(findNextFocus, this.k);
            k(e(this.k));
            findNextFocus.requestFocus(i);
        }
        if (findFocus == null || !findFocus.isFocused() || !z(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (!this.l.isFinished()) {
            this.l.computeScrollOffset();
            int currY = this.l.getCurrY();
            int i = currY - this.D;
            this.D = currY;
            int[] iArr = this.B;
            boolean z2 = false;
            iArr[1] = 0;
            f(0, i, iArr, (int[]) null, 1);
            int i2 = i - this.B[1];
            int scrollRange = getScrollRange();
            if (i2 != 0) {
                int scrollY = getScrollY();
                E(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                int i3 = i2 - scrollY2;
                int[] iArr2 = this.B;
                iArr2[1] = 0;
                g(0, scrollY2, 0, i3, this.A, 1, iArr2);
                i2 = i3 - this.B[1];
            }
            if (i2 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z2 = true;
                }
                if (z2) {
                    p();
                    if (i2 < 0) {
                        if (this.m.isFinished()) {
                            edgeEffect = this.m;
                        }
                    } else if (this.n.isFinished()) {
                        edgeEffect = this.n;
                    }
                    edgeEffect.onAbsorb((int) this.l.getCurrVelocity());
                }
                a();
            }
            if (!this.l.isFinished()) {
                p.x(this);
            } else {
                P(1);
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || q(keyEvent);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.G.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.G.b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return f(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.G.e(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        super.draw(canvas);
        if (this.m != null) {
            int scrollY = getScrollY();
            int i3 = 0;
            if (!this.m.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (i2 < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i = getPaddingLeft() + 0;
                } else {
                    i = 0;
                }
                if (i2 >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate((float) i, (float) min);
                this.m.setSize(width, height);
                if (this.m.draw(canvas)) {
                    p.x(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.n.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (i2 < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i3 = 0 + getPaddingLeft();
                }
                if (i2 >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate((float) (i3 - width2), (float) max);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.n.setSize(width2, height2);
                if (this.n.draw(canvas)) {
                    p.x(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int e(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i2 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i - verticalFadingEdgeLength : i;
        int i3 = rect.bottom;
        if (i3 > i2 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i2) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i);
        } else if (rect.top >= scrollY || i3 >= i2) {
            return 0;
        } else {
            return Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
    }

    public boolean f(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.G.c(i, i2, iArr, iArr2, i3);
    }

    public void g(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        this.G.d(i, i2, i3, i4, iArr, i5, iArr2);
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.F.a();
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public void h(View view, View view2, int i, int i2) {
        this.F.c(view, view2, i, i2);
        O(2, i2);
    }

    public boolean hasNestedScrollingParent() {
        return u(0);
    }

    public void i(View view, int i) {
        this.F.d(view, i);
        P(i);
    }

    public boolean isNestedScrollingEnabled() {
        return this.G.j();
    }

    public void j(View view, int i, int i2, int[] iArr, int i3) {
        f(i, i2, iArr, (int[]) null, i3);
    }

    public void m(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        C(i4, i5, iArr);
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i, int i2) {
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void n(View view, int i, int i2, int i3, int i4, int i5) {
        C(i4, i5, (int[]) null);
    }

    public boolean o(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.s) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.s) {
            return true;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    int i2 = this.z;
                    if (i2 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i2);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                        } else {
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y2 - this.o) > this.w && (2 & getNestedScrollAxes()) == 0) {
                                this.s = true;
                                this.o = y2;
                                y();
                                this.t.addMovement(motionEvent);
                                this.C = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i != 3) {
                    if (i == 6) {
                        D(motionEvent);
                    }
                }
            }
            this.s = false;
            this.z = -1;
            G();
            if (this.l.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                p.x(this);
            }
            P(0);
        } else {
            int y3 = (int) motionEvent.getY();
            if (!v((int) motionEvent.getX(), y3)) {
                this.s = false;
                G();
            } else {
                this.o = y3;
                this.z = motionEvent.getPointerId(0);
                w();
                this.t.addMovement(motionEvent);
                this.l.computeScrollOffset();
                this.s = !this.l.isFinished();
                O(2, 0);
            }
        }
        return this.s;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        int i5 = 0;
        this.p = false;
        View view = this.r;
        if (view != null && A(view, this)) {
            J(this.r);
        }
        this.r = null;
        if (!this.q) {
            if (this.E != null) {
                scrollTo(getScrollX(), this.E.j);
                this.E = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i5 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int d2 = d(scrollY, paddingTop, i5);
            if (d2 != scrollY) {
                scrollTo(getScrollX(), d2);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.q = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.u && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        s((int) f3);
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        j(view, i, i2, iArr, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        C(i4, 0, (int[]) null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        h(view, view2, i, 0);
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i, int i2, boolean z2, boolean z3) {
        super.scrollTo(i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        FocusFinder instance = FocusFinder.getInstance();
        View findNextFocus = rect == null ? instance.findNextFocus(this, (View) null, i) : instance.findNextFocusFromRect(this, rect, i);
        if (findNextFocus != null && !z(findNextFocus)) {
            return findNextFocus.requestFocus(i, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.E = cVar;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.j = getScrollY();
        return cVar;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        b bVar = this.I;
        if (bVar != null) {
            bVar.a(this, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && B(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.k);
            offsetDescendantRectToMyCoords(findFocus, this.k);
            k(e(this.k));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return o(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        if (r10.l.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0210, code lost:
        if (r10.l.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x0078;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r24) {
        /*
            r23 = this;
            r10 = r23
            r11 = r24
            r23.y()
            int r0 = r24.getActionMasked()
            r12 = 0
            if (r0 != 0) goto L_0x0010
            r10.C = r12
        L_0x0010:
            android.view.MotionEvent r13 = android.view.MotionEvent.obtain(r24)
            int r1 = r10.C
            float r1 = (float) r1
            r2 = 0
            r13.offsetLocation(r2, r1)
            r1 = 2
            r14 = 1
            if (r0 == 0) goto L_0x0214
            r3 = -1
            if (r0 == r14) goto L_0x01cf
            if (r0 == r1) goto L_0x0082
            r1 = 3
            if (r0 == r1) goto L_0x0054
            r1 = 5
            if (r0 == r1) goto L_0x0041
            r1 = 6
            if (r0 == r1) goto L_0x002f
            goto L_0x024a
        L_0x002f:
            r23.D(r24)
            int r0 = r10.z
            int r0 = r11.findPointerIndex(r0)
            float r0 = r11.getY(r0)
            int r0 = (int) r0
            r10.o = r0
            goto L_0x024a
        L_0x0041:
            int r0 = r24.getActionIndex()
            float r1 = r11.getY(r0)
            int r1 = (int) r1
            r10.o = r1
            int r0 = r11.getPointerId(r0)
            r10.z = r0
            goto L_0x024a
        L_0x0054:
            boolean r0 = r10.s
            if (r0 == 0) goto L_0x007b
            int r0 = r23.getChildCount()
            if (r0 <= 0) goto L_0x007b
            android.widget.OverScroller r15 = r10.l
            int r16 = r23.getScrollX()
            int r17 = r23.getScrollY()
            r18 = 0
            r19 = 0
            r20 = 0
            int r21 = r23.getScrollRange()
            boolean r0 = r15.springBack(r16, r17, r18, r19, r20, r21)
            if (r0 == 0) goto L_0x007b
        L_0x0078:
            b.d.k.p.x(r23)
        L_0x007b:
            r10.z = r3
            r23.l()
            goto L_0x024a
        L_0x0082:
            int r0 = r10.z
            int r15 = r11.findPointerIndex(r0)
            if (r15 != r3) goto L_0x00a9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid pointerId="
            r0.append(r1)
            int r1 = r10.z
            r0.append(r1)
            java.lang.String r1 = " in onTouchEvent"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NestedScrollView"
            android.util.Log.e(r1, r0)
            goto L_0x024a
        L_0x00a9:
            float r0 = r11.getY(r15)
            int r6 = (int) r0
            int r0 = r10.o
            int r0 = r0 - r6
            boolean r1 = r10.s
            if (r1 != 0) goto L_0x00cf
            int r1 = java.lang.Math.abs(r0)
            int r2 = r10.w
            if (r1 <= r2) goto L_0x00cf
            android.view.ViewParent r1 = r23.getParent()
            if (r1 == 0) goto L_0x00c6
            r1.requestDisallowInterceptTouchEvent(r14)
        L_0x00c6:
            r10.s = r14
            int r1 = r10.w
            if (r0 <= 0) goto L_0x00ce
            int r0 = r0 - r1
            goto L_0x00cf
        L_0x00ce:
            int r0 = r0 + r1
        L_0x00cf:
            r7 = r0
            boolean r0 = r10.s
            if (r0 == 0) goto L_0x024a
            r1 = 0
            int[] r3 = r10.B
            int[] r4 = r10.A
            r5 = 0
            r0 = r23
            r2 = r7
            boolean r0 = r0.f(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00f1
            int[] r0 = r10.B
            r0 = r0[r14]
            int r7 = r7 - r0
            int r0 = r10.C
            int[] r1 = r10.A
            r1 = r1[r14]
            int r0 = r0 + r1
            r10.C = r0
        L_0x00f1:
            r16 = r7
            int[] r0 = r10.A
            r0 = r0[r14]
            int r6 = r6 - r0
            r10.o = r6
            int r17 = r23.getScrollY()
            int r9 = r23.getScrollRange()
            int r0 = r23.getOverScrollMode()
            if (r0 == 0) goto L_0x0110
            if (r0 != r14) goto L_0x010d
            if (r9 <= 0) goto L_0x010d
            goto L_0x0110
        L_0x010d:
            r18 = 0
            goto L_0x0112
        L_0x0110:
            r18 = 1
        L_0x0112:
            r1 = 0
            r3 = 0
            int r4 = r23.getScrollY()
            r5 = 0
            r7 = 0
            r8 = 0
            r19 = 1
            r0 = r23
            r2 = r16
            r6 = r9
            r22 = r9
            r9 = r19
            boolean r0 = r0.E(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x0137
            boolean r0 = r10.u(r12)
            if (r0 != 0) goto L_0x0137
            android.view.VelocityTracker r0 = r10.t
            r0.clear()
        L_0x0137:
            int r0 = r23.getScrollY()
            int r2 = r0 - r17
            int r4 = r16 - r2
            int[] r7 = r10.B
            r7[r14] = r12
            r1 = 0
            r3 = 0
            int[] r5 = r10.A
            r6 = 0
            r0 = r23
            r0.g(r1, r2, r3, r4, r5, r6, r7)
            int r0 = r10.o
            int[] r1 = r10.A
            r2 = r1[r14]
            int r0 = r0 - r2
            r10.o = r0
            int r0 = r10.C
            r1 = r1[r14]
            int r0 = r0 + r1
            r10.C = r0
            if (r18 == 0) goto L_0x024a
            int[] r0 = r10.B
            r0 = r0[r14]
            int r0 = r16 - r0
            r23.p()
            int r1 = r17 + r0
            if (r1 >= 0) goto L_0x0190
            android.widget.EdgeEffect r1 = r10.m
            float r0 = (float) r0
            int r2 = r23.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            float r2 = r11.getX(r15)
            int r3 = r23.getWidth()
            float r3 = (float) r3
            float r2 = r2 / r3
            androidx.core.widget.d.a(r1, r0, r2)
            android.widget.EdgeEffect r0 = r10.n
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01b8
            android.widget.EdgeEffect r0 = r10.n
        L_0x018c:
            r0.onRelease()
            goto L_0x01b8
        L_0x0190:
            r2 = r22
            if (r1 <= r2) goto L_0x01b8
            android.widget.EdgeEffect r1 = r10.n
            float r0 = (float) r0
            int r2 = r23.getHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            r2 = 1065353216(0x3f800000, float:1.0)
            float r3 = r11.getX(r15)
            int r4 = r23.getWidth()
            float r4 = (float) r4
            float r3 = r3 / r4
            float r2 = r2 - r3
            androidx.core.widget.d.a(r1, r0, r2)
            android.widget.EdgeEffect r0 = r10.m
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01b8
            android.widget.EdgeEffect r0 = r10.m
            goto L_0x018c
        L_0x01b8:
            android.widget.EdgeEffect r0 = r10.m
            if (r0 == 0) goto L_0x024a
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x01ca
            android.widget.EdgeEffect r0 = r10.n
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x024a
        L_0x01ca:
            b.d.k.p.x(r23)
            goto L_0x024a
        L_0x01cf:
            android.view.VelocityTracker r0 = r10.t
            r1 = 1000(0x3e8, float:1.401E-42)
            int r4 = r10.y
            float r4 = (float) r4
            r0.computeCurrentVelocity(r1, r4)
            int r1 = r10.z
            float r0 = r0.getYVelocity(r1)
            int r0 = (int) r0
            int r1 = java.lang.Math.abs(r0)
            int r4 = r10.x
            if (r1 < r4) goto L_0x01f8
            int r0 = -r0
            float r1 = (float) r0
            boolean r4 = r10.dispatchNestedPreFling(r2, r1)
            if (r4 != 0) goto L_0x007b
            r10.dispatchNestedFling(r2, r1, r14)
            r10.s(r0)
            goto L_0x007b
        L_0x01f8:
            android.widget.OverScroller r15 = r10.l
            int r16 = r23.getScrollX()
            int r17 = r23.getScrollY()
            r18 = 0
            r19 = 0
            r20 = 0
            int r21 = r23.getScrollRange()
            boolean r0 = r15.springBack(r16, r17, r18, r19, r20, r21)
            if (r0 == 0) goto L_0x007b
            goto L_0x0078
        L_0x0214:
            int r0 = r23.getChildCount()
            if (r0 != 0) goto L_0x021b
            return r12
        L_0x021b:
            android.widget.OverScroller r0 = r10.l
            boolean r0 = r0.isFinished()
            r0 = r0 ^ r14
            r10.s = r0
            if (r0 == 0) goto L_0x022f
            android.view.ViewParent r0 = r23.getParent()
            if (r0 == 0) goto L_0x022f
            r0.requestDisallowInterceptTouchEvent(r14)
        L_0x022f:
            android.widget.OverScroller r0 = r10.l
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x023a
            r23.a()
        L_0x023a:
            float r0 = r24.getY()
            int r0 = (int) r0
            r10.o = r0
            int r0 = r11.getPointerId(r12)
            r10.z = r0
            r10.O(r1, r12)
        L_0x024a:
            android.view.VelocityTracker r0 = r10.t
            if (r0 == 0) goto L_0x0251
            r0.addMovement(r13)
        L_0x0251:
            r13.recycle()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean q(KeyEvent keyEvent) {
        this.k.setEmpty();
        int i = 130;
        if (!c()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                return !keyEvent.isAltPressed() ? b(33) : t(33);
            }
            if (keyCode == 20) {
                return !keyEvent.isAltPressed() ? b(130) : t(130);
            }
            if (keyCode != 62) {
                return false;
            }
            if (keyEvent.isShiftPressed()) {
                i = 33;
            }
            F(i);
            return false;
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.p) {
            J(view2);
        } else {
            this.r = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return K(rect, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            G();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        this.p = true;
        super.requestLayout();
    }

    public void s(int i) {
        if (getChildCount() > 0) {
            this.l.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            H(true);
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int d2 = d(i, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int d3 = d(i2, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (d2 != getScrollX() || d3 != getScrollY()) {
                super.scrollTo(d2, d3);
            }
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.u) {
            this.u = z2;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.G.k(z2);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.I = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.v = z2;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i) {
        return O(i, 0);
    }

    public void stopNestedScroll() {
        P(0);
    }

    public boolean t(int i) {
        int childCount;
        boolean z2 = i == 130;
        int height = getHeight();
        Rect rect = this.k;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.k.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.k;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.k;
        return I(i, rect3.top, rect3.bottom);
    }

    public boolean u(int i) {
        return this.G.i(i);
    }
}
