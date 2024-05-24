package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.f;
import b.a.g;
import b.a.j;
import b.a.m.b;
import b.d.k.p;

public class ActionBarContextView extends a {
    private boolean A;
    private int B;
    private CharSequence r;
    private CharSequence s;
    private View t;
    private View u;
    private LinearLayout v;
    private TextView w;
    private TextView x;
    private int y;
    private int z;

    class a implements View.OnClickListener {
        final /* synthetic */ b j;

        a(ActionBarContextView actionBarContextView, b bVar) {
            this.j = bVar;
        }

        public void onClick(View view) {
            this.j.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        t0 t2 = t0.t(context, attributeSet, j.x, i, 0);
        p.D(this, t2.f(j.y));
        this.y = t2.m(j.C, 0);
        this.z = t2.m(j.B, 0);
        this.n = t2.l(j.A, 0);
        this.B = t2.m(j.z, g.abc_action_mode_close_item_material);
        t2.u();
    }

    private void i() {
        if (this.v == null) {
            LayoutInflater.from(getContext()).inflate(g.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.v = linearLayout;
            this.w = (TextView) linearLayout.findViewById(f.action_bar_title);
            this.x = (TextView) this.v.findViewById(f.action_bar_subtitle);
            if (this.y != 0) {
                this.w.setTextAppearance(getContext(), this.y);
            }
            if (this.z != 0) {
                this.x.setTextAppearance(getContext(), this.z);
            }
        }
        this.w.setText(this.r);
        this.x.setText(this.s);
        boolean z2 = !TextUtils.isEmpty(this.r);
        boolean z3 = !TextUtils.isEmpty(this.s);
        int i = 0;
        this.x.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout2 = this.v;
        if (!z2 && !z3) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
        if (this.v.getParent() == null) {
            addView(this.v);
        }
    }

    public void g() {
        if (this.t == null) {
            k();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.s;
    }

    public CharSequence getTitle() {
        return this.r;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(b.a.m.b r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.t
            if (r0 != 0) goto L_0x0019
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.B
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r3, r2)
            r3.t = r0
        L_0x0015:
            r3.addView(r0)
            goto L_0x0022
        L_0x0019:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L_0x0022
            android.view.View r0 = r3.t
            goto L_0x0015
        L_0x0022:
            android.view.View r0 = r3.t
            int r1 = b.a.f.action_mode_close_button
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.ActionBarContextView$a r1 = new androidx.appcompat.widget.ActionBarContextView$a
            r1.<init>(r3, r4)
            r0.setOnClickListener(r1)
            android.view.Menu r4 = r4.e()
            androidx.appcompat.view.menu.h r4 = (androidx.appcompat.view.menu.h) r4
            androidx.appcompat.widget.c r0 = r3.m
            if (r0 == 0) goto L_0x003f
            r0.x()
        L_0x003f:
            androidx.appcompat.widget.c r0 = new androidx.appcompat.widget.c
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.m = r0
            r1 = 1
            r0.I(r1)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -2
            r2 = -1
            r0.<init>(r1, r2)
            androidx.appcompat.widget.c r1 = r3.m
            android.content.Context r2 = r3.k
            r4.c(r1, r2)
            androidx.appcompat.widget.c r4 = r3.m
            androidx.appcompat.view.menu.p r4 = r4.o(r3)
            androidx.appcompat.widget.ActionMenuView r4 = (androidx.appcompat.widget.ActionMenuView) r4
            r3.l = r4
            r1 = 0
            b.d.k.p.D(r4, r1)
            androidx.appcompat.widget.ActionMenuView r4 = r3.l
            r3.addView(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.h(b.a.m.b):void");
    }

    public boolean j() {
        return this.A;
    }

    public void k() {
        removeAllViews();
        this.u = null;
        this.l = null;
    }

    public boolean l() {
        c cVar = this.m;
        if (cVar != null) {
            return cVar.J();
        }
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.m;
        if (cVar != null) {
            cVar.A();
            this.m.B();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.r);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        boolean b2 = z0.b(this);
        int paddingRight = b2 ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.t;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.t.getLayoutParams();
            int i5 = b2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = b2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int d2 = a.d(paddingRight, i5, b2);
            paddingRight = a.d(d2 + e(this.t, d2, paddingTop, paddingTop2, b2), i6, b2);
        }
        int i7 = paddingRight;
        LinearLayout linearLayout = this.v;
        if (!(linearLayout == null || this.u != null || linearLayout.getVisibility() == 8)) {
            i7 += e(this.v, i7, paddingTop, paddingTop2, b2);
        }
        int i8 = i7;
        View view2 = this.u;
        if (view2 != null) {
            e(view2, i8, paddingTop, paddingTop2, b2);
        }
        int paddingLeft = b2 ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.l;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i2) != 0) {
            int size = View.MeasureSpec.getSize(i);
            int i4 = this.n;
            if (i4 <= 0) {
                i4 = View.MeasureSpec.getSize(i2);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = i4 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            View view = this.t;
            if (view != null) {
                int c2 = c(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.t.getLayoutParams();
                paddingLeft = c2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.l;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = c(this.l, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.v;
            if (linearLayout != null && this.u == null) {
                if (this.A) {
                    this.v.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.v.getMeasuredWidth();
                    boolean z2 = measuredWidth <= paddingLeft;
                    if (z2) {
                        paddingLeft -= measuredWidth;
                    }
                    this.v.setVisibility(z2 ? 0 : 8);
                } else {
                    paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.u;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i6 = layoutParams.width;
                int i7 = i6 != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (i6 >= 0) {
                    paddingLeft = Math.min(i6, paddingLeft);
                }
                int i8 = layoutParams.height;
                if (i8 == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (i8 >= 0) {
                    i5 = Math.min(i8, i5);
                }
                this.u.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i7), View.MeasureSpec.makeMeasureSpec(i5, i3));
            }
            if (this.n <= 0) {
                int childCount = getChildCount();
                int i9 = 0;
                for (int i10 = 0; i10 < childCount; i10++) {
                    int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i9) {
                        i9 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i9);
                return;
            }
            setMeasuredDimension(size, i4);
        } else {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        }
    }

    public void setContentHeight(int i) {
        this.n = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.u;
        if (view2 != null) {
            removeView(view2);
        }
        this.u = view;
        if (!(view == null || (linearLayout = this.v) == null)) {
            removeView(linearLayout);
            this.v = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.s = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.r = charSequence;
        i();
    }

    public void setTitleOptional(boolean z2) {
        if (z2 != this.A) {
            requestLayout();
        }
        this.A = z2;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
