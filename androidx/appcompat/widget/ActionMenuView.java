package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.g0;

public class ActionMenuView extends g0 implements h.b, p {
    private int A;
    private boolean B;
    private c C;
    private o.a D;
    h.a E;
    private boolean F;
    private int G;
    private int H;
    private int I;
    e J;
    private h y;
    private Context z;

    public interface a {
        boolean a();

        boolean b();
    }

    private static class b implements o.a {
        b() {
        }

        public void a(h hVar, boolean z) {
        }

        public boolean b(h hVar) {
            return false;
        }
    }

    public static class c extends g0.a {
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public boolean f175c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public int f176d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public int f177e;
        @ViewDebug.ExportedProperty

        /* renamed from: f  reason: collision with root package name */
        public boolean f178f;
        @ViewDebug.ExportedProperty
        public boolean g;
        boolean h;

        public c(int i, int i2) {
            super(i, i2);
            this.f175c = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f175c = cVar.f175c;
        }
    }

    private class d implements h.a {
        d() {
        }

        public boolean a(h hVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.J;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        public void b(h hVar) {
            h.a aVar = ActionMenuView.this.E;
            if (aVar != null) {
                aVar.b(hVar);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.H = (int) (56.0f * f2);
        this.I = (int) (f2 * 4.0f);
        this.z = context;
        this.A = 0;
    }

    static int J(View view, int i, int i2, int i3, int i4) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = true;
        boolean z3 = actionMenuItemView != null && actionMenuItemView.f();
        int i5 = 2;
        if (i2 <= 0 || (z3 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z3 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (cVar.f175c || !z3) {
            z2 = false;
        }
        cVar.f178f = z2;
        cVar.f176d = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    private void K(int i, int i2) {
        int i3;
        boolean z2;
        int i4;
        int i5;
        boolean z3;
        boolean z4;
        int i6;
        boolean z5;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingTop, -2);
        int i7 = size - paddingLeft;
        int i8 = this.H;
        int i9 = i7 / i8;
        int i10 = i7 % i8;
        if (i9 == 0) {
            setMeasuredDimension(i7, 0);
            return;
        }
        int i11 = i8 + (i10 / i9);
        int childCount = getChildCount();
        int i12 = 0;
        int i13 = 0;
        boolean z6 = false;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        long j = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            int i17 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z7 = childAt instanceof ActionMenuItemView;
                int i18 = i14 + 1;
                if (z7) {
                    int i19 = this.I;
                    i6 = i18;
                    z5 = false;
                    childAt.setPadding(i19, 0, i19, 0);
                } else {
                    i6 = i18;
                    z5 = false;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.h = z5;
                cVar.f177e = z5 ? 1 : 0;
                cVar.f176d = z5;
                cVar.f178f = z5;
                cVar.leftMargin = z5;
                cVar.rightMargin = z5;
                cVar.g = z7 && ((ActionMenuItemView) childAt).f();
                int J2 = J(childAt, i11, cVar.f175c ? 1 : i9, childMeasureSpec, paddingTop);
                i15 = Math.max(i15, J2);
                if (cVar.f178f) {
                    i16++;
                }
                if (cVar.f175c) {
                    z6 = true;
                }
                i9 -= J2;
                i12 = Math.max(i12, childAt.getMeasuredHeight());
                if (J2 == 1) {
                    j |= (long) (1 << i13);
                    i12 = i12;
                } else {
                    int i20 = i12;
                }
                i14 = i6;
            }
            i13++;
            size2 = i17;
        }
        int i21 = size2;
        boolean z8 = z6 && i14 == 2;
        boolean z9 = false;
        while (true) {
            if (i16 <= 0 || i9 <= 0) {
                i5 = mode;
                i3 = i7;
                z2 = z9;
                i4 = i12;
            } else {
                int i22 = 0;
                int i23 = 0;
                int i24 = Integer.MAX_VALUE;
                long j2 = 0;
                while (i23 < childCount) {
                    boolean z10 = z9;
                    c cVar2 = (c) getChildAt(i23).getLayoutParams();
                    int i25 = i12;
                    if (cVar2.f178f) {
                        int i26 = cVar2.f176d;
                        if (i26 < i24) {
                            j2 = 1 << i23;
                            i24 = i26;
                            i22 = 1;
                        } else if (i26 == i24) {
                            i22++;
                            j2 |= 1 << i23;
                        }
                    }
                    i23++;
                    i12 = i25;
                    z9 = z10;
                }
                z2 = z9;
                i4 = i12;
                j |= j2;
                if (i22 > i9) {
                    i5 = mode;
                    i3 = i7;
                    break;
                }
                int i27 = i24 + 1;
                int i28 = 0;
                while (i28 < childCount) {
                    View childAt2 = getChildAt(i28);
                    c cVar3 = (c) childAt2.getLayoutParams();
                    int i29 = i7;
                    int i30 = mode;
                    long j3 = (long) (1 << i28);
                    if ((j2 & j3) == 0) {
                        if (cVar3.f176d == i27) {
                            j |= j3;
                        }
                        z4 = z8;
                    } else {
                        if (!z8 || !cVar3.g || i9 != 1) {
                            z4 = z8;
                        } else {
                            int i31 = this.I;
                            z4 = z8;
                            childAt2.setPadding(i31 + i11, 0, i31, 0);
                        }
                        cVar3.f176d++;
                        cVar3.h = true;
                        i9--;
                    }
                    i28++;
                    mode = i30;
                    i7 = i29;
                    z8 = z4;
                }
                i12 = i4;
                z9 = true;
            }
        }
        boolean z11 = !z6 && i14 == 1;
        if (i9 <= 0 || j == 0 || (i9 >= i14 - 1 && !z11 && i15 <= 1)) {
            z3 = z2;
        } else {
            float bitCount = (float) Long.bitCount(j);
            if (!z11) {
                if ((j & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).g) {
                    bitCount -= 0.5f;
                }
                int i32 = childCount - 1;
                if ((j & ((long) (1 << i32))) != 0 && !((c) getChildAt(i32).getLayoutParams()).g) {
                    bitCount -= 0.5f;
                }
            }
            int i33 = bitCount > 0.0f ? (int) (((float) (i9 * i11)) / bitCount) : 0;
            z3 = z2;
            for (int i34 = 0; i34 < childCount; i34++) {
                if ((j & ((long) (1 << i34))) != 0) {
                    View childAt3 = getChildAt(i34);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f177e = i33;
                        cVar4.h = true;
                        if (i34 == 0 && !cVar4.g) {
                            cVar4.leftMargin = (-i33) / 2;
                        }
                    } else if (cVar4.f175c) {
                        cVar4.f177e = i33;
                        cVar4.h = true;
                        cVar4.rightMargin = (-i33) / 2;
                    } else {
                        if (i34 != 0) {
                            cVar4.leftMargin = i33 / 2;
                        }
                        if (i34 != childCount - 1) {
                            cVar4.rightMargin = i33 / 2;
                        }
                    }
                    z3 = true;
                }
            }
        }
        if (z3) {
            for (int i35 = 0; i35 < childCount; i35++) {
                View childAt4 = getChildAt(i35);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.h) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f176d * i11) + cVar5.f177e, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i3, i5 != 1073741824 ? i4 : i21);
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public c k() {
        c cVar = new c(-2, -2);
        cVar.f205b = 16;
        return cVar;
    }

    /* renamed from: B */
    public c l(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public c m(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return k();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.f205b <= 0) {
            cVar.f205b = 16;
        }
        return cVar;
    }

    public c D() {
        c A2 = k();
        A2.f175c = true;
        return A2;
    }

    /* access modifiers changed from: protected */
    public boolean E(int i) {
        boolean z2 = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z2 = false | ((a) childAt).a();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z2 : z2 | ((a) childAt2).b();
    }

    public boolean F() {
        c cVar = this.C;
        return cVar != null && cVar.A();
    }

    public boolean G() {
        c cVar = this.C;
        return cVar != null && cVar.C();
    }

    public boolean H() {
        c cVar = this.C;
        return cVar != null && cVar.D();
    }

    public boolean I() {
        return this.B;
    }

    public h L() {
        return this.y;
    }

    public void M(o.a aVar, h.a aVar2) {
        this.D = aVar;
        this.E = aVar2;
    }

    public boolean N() {
        c cVar = this.C;
        return cVar != null && cVar.J();
    }

    public boolean a(j jVar) {
        return this.y.L(jVar, 0);
    }

    public void b(h hVar) {
        this.y = hVar;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof c);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.y == null) {
            Context context = getContext();
            h hVar = new h(context);
            this.y = hVar;
            hVar.R(new d());
            c cVar = new c(context);
            this.C = cVar;
            cVar.I(true);
            c cVar2 = this.C;
            o.a aVar = this.D;
            if (aVar == null) {
                aVar = new b();
            }
            cVar2.i(aVar);
            this.y.c(this.C, this.z);
            this.C.G(this);
        }
        return this.y;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.C.z();
    }

    public int getPopupTheme() {
        return this.A;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c cVar = this.C;
        if (cVar != null) {
            cVar.k(false);
            if (this.C.D()) {
                this.C.A();
                this.C.J();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (!this.F) {
            super.onLayout(z2, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i3 - i;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean b2 = z0.b(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f175c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (E(i11)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b2) {
                        i5 = getPaddingLeft() + cVar.leftMargin;
                        i6 = i5 + measuredWidth;
                    } else {
                        i6 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i5 = i6 - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(i5, i12, i6, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    E(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        int max = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (b2) {
            int width = getWidth() - getPaddingRight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f175c) {
                    int i17 = width - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width = i17 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f175c) {
                int i20 = paddingLeft + cVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = i20 + measuredWidth4 + cVar3.rightMargin + max;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        h hVar;
        boolean z2 = this.F;
        boolean z3 = View.MeasureSpec.getMode(i) == 1073741824;
        this.F = z3;
        if (z2 != z3) {
            this.G = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.F || (hVar = this.y) == null || size == this.G)) {
            this.G = size;
            hVar.K(true);
        }
        int childCount = getChildCount();
        if (!this.F || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                c cVar = (c) getChildAt(i3).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        K(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.C.F(z2);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.J = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.C.H(drawable);
    }

    public void setOverflowReserved(boolean z2) {
        this.B = z2;
    }

    public void setPopupTheme(int i) {
        if (this.A != i) {
            this.A = i;
            if (i == 0) {
                this.z = getContext();
            } else {
                this.z = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(c cVar) {
        this.C = cVar;
        cVar.G(this);
    }

    public void z() {
        c cVar = this.C;
        if (cVar != null) {
            cVar.x();
        }
    }
}
