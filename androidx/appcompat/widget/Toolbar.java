package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.u;
import androidx.appcompat.widget.ActionMenuView;
import b.d.k.p;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int A;
    private int B;
    private l0 C;
    private int D;
    private int E;
    private int F;
    private CharSequence G;
    private CharSequence H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;
    private final ArrayList<View> M;
    private final ArrayList<View> N;
    private final int[] O;
    f P;
    private final ActionMenuView.e Q;
    private u0 R;
    private c S;
    private d T;
    private o.a U;
    private h.a V;
    private boolean W;
    private final Runnable a0;
    private ActionMenuView j;
    private TextView k;
    private TextView l;
    private ImageButton m;
    private ImageView n;
    private Drawable o;
    private CharSequence p;
    ImageButton q;
    View r;
    private Context s;
    private int t;
    private int u;
    private int v;
    int w;
    private int x;
    private int y;
    private int z;

    class a implements ActionMenuView.e {
        a() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            f fVar = Toolbar.this.P;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            Toolbar.this.N();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    private class d implements o {
        h j;
        j k;

        d() {
        }

        public void a(h hVar, boolean z) {
        }

        public boolean c() {
            return false;
        }

        public void d(Context context, h hVar) {
            j jVar;
            h hVar2 = this.j;
            if (!(hVar2 == null || (jVar = this.k) == null)) {
                hVar2.f(jVar);
            }
            this.j = hVar;
        }

        public boolean e(h hVar, j jVar) {
            View view = Toolbar.this.r;
            if (view instanceof b.a.m.c) {
                ((b.a.m.c) view).d();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.r);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.q);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.r = null;
            toolbar3.a();
            this.k = null;
            Toolbar.this.requestLayout();
            jVar.r(false);
            return true;
        }

        public boolean h(h hVar, j jVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.q.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.q);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.q);
            }
            Toolbar.this.r = jVar.getActionView();
            this.k = jVar;
            ViewParent parent2 = Toolbar.this.r.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.r);
                }
                e m = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                m.f76a = 8388611 | (toolbar4.w & b.a.j.H0);
                m.f192b = 2;
                toolbar4.r.setLayoutParams(m);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.r);
            }
            Toolbar.this.F();
            Toolbar.this.requestLayout();
            jVar.r(true);
            View view = Toolbar.this.r;
            if (view instanceof b.a.m.c) {
                ((b.a.m.c) view).c();
            }
            return true;
        }

        public boolean j(u uVar) {
            return false;
        }

        public void k(boolean z) {
            if (this.k != null) {
                h hVar = this.j;
                boolean z2 = false;
                if (hVar != null) {
                    int size = hVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.j.getItem(i) == this.k) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    e(this.j, this.k);
                }
            }
        }
    }

    public static class e extends a.C0007a {

        /* renamed from: b  reason: collision with root package name */
        int f192b = 0;

        public e(int i, int i2) {
            super(i, i2);
            this.f76a = 8388627;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            a(marginLayoutParams);
        }

        public e(a.C0007a aVar) {
            super(aVar);
        }

        public e(e eVar) {
            super((a.C0007a) eVar);
            this.f192b = eVar.f192b;
        }

        /* access modifiers changed from: package-private */
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class g extends b.f.a.a {
        public static final Parcelable.Creator<g> CREATOR = new a();
        int l;
        boolean m;

        static class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            /* renamed from: c */
            public g[] newArray(int i) {
                return new g[i];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.l = parcel.readInt();
            this.m = parcel.readInt() != 0;
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.l);
            parcel.writeInt(this.m ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = 8388627;
        this.M = new ArrayList<>();
        this.N = new ArrayList<>();
        this.O = new int[2];
        this.Q = new a();
        this.a0 = new b();
        t0 t2 = t0.t(getContext(), attributeSet, b.a.j.K2, i, 0);
        this.u = t2.m(b.a.j.l3, 0);
        this.v = t2.m(b.a.j.c3, 0);
        this.F = t2.k(b.a.j.L2, this.F);
        this.w = t2.k(b.a.j.M2, 48);
        int d2 = t2.d(b.a.j.f3, 0);
        int i2 = b.a.j.k3;
        d2 = t2.q(i2) ? t2.d(i2, d2) : d2;
        this.B = d2;
        this.A = d2;
        this.z = d2;
        this.y = d2;
        int d3 = t2.d(b.a.j.i3, -1);
        if (d3 >= 0) {
            this.y = d3;
        }
        int d4 = t2.d(b.a.j.h3, -1);
        if (d4 >= 0) {
            this.z = d4;
        }
        int d5 = t2.d(b.a.j.j3, -1);
        if (d5 >= 0) {
            this.A = d5;
        }
        int d6 = t2.d(b.a.j.g3, -1);
        if (d6 >= 0) {
            this.B = d6;
        }
        this.x = t2.e(b.a.j.X2, -1);
        int d7 = t2.d(b.a.j.T2, Integer.MIN_VALUE);
        int d8 = t2.d(b.a.j.P2, Integer.MIN_VALUE);
        int e2 = t2.e(b.a.j.R2, 0);
        int e3 = t2.e(b.a.j.S2, 0);
        h();
        this.C.e(e2, e3);
        if (!(d7 == Integer.MIN_VALUE && d8 == Integer.MIN_VALUE)) {
            this.C.g(d7, d8);
        }
        this.D = t2.d(b.a.j.U2, Integer.MIN_VALUE);
        this.E = t2.d(b.a.j.Q2, Integer.MIN_VALUE);
        this.o = t2.f(b.a.j.O2);
        this.p = t2.o(b.a.j.N2);
        CharSequence o2 = t2.o(b.a.j.e3);
        if (!TextUtils.isEmpty(o2)) {
            setTitle(o2);
        }
        CharSequence o3 = t2.o(b.a.j.b3);
        if (!TextUtils.isEmpty(o3)) {
            setSubtitle(o3);
        }
        this.s = getContext();
        setPopupTheme(t2.m(b.a.j.a3, 0));
        Drawable f2 = t2.f(b.a.j.Z2);
        if (f2 != null) {
            setNavigationIcon(f2);
        }
        CharSequence o4 = t2.o(b.a.j.Y2);
        if (!TextUtils.isEmpty(o4)) {
            setNavigationContentDescription(o4);
        }
        Drawable f3 = t2.f(b.a.j.V2);
        if (f3 != null) {
            setLogo(f3);
        }
        CharSequence o5 = t2.o(b.a.j.W2);
        if (!TextUtils.isEmpty(o5)) {
            setLogoDescription(o5);
        }
        int i3 = b.a.j.m3;
        if (t2.q(i3)) {
            setTitleTextColor(t2.b(i3, -1));
        }
        int i4 = b.a.j.d3;
        if (t2.q(i4)) {
            setSubtitleTextColor(t2.b(i4, -1));
        }
        t2.u();
    }

    private int A(View view, int i, int[] iArr, int i2) {
        e eVar = (e) view.getLayoutParams();
        int i3 = eVar.leftMargin - iArr[0];
        int max = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int q2 = q(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, q2, max + measuredWidth, view.getMeasuredHeight() + q2);
        return max + measuredWidth + eVar.rightMargin;
    }

    private int B(View view, int i, int[] iArr, int i2) {
        e eVar = (e) view.getLayoutParams();
        int i3 = eVar.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int q2 = q(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, q2, max, view.getMeasuredHeight() + q2);
        return max - (measuredWidth + eVar.leftMargin);
    }

    private int C(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void D(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void E() {
        removeCallbacks(this.a0);
        post(this.a0);
    }

    private boolean L() {
        if (!this.W) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (M(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean M(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i) {
        boolean z2 = p.k(this) == 1;
        int childCount = getChildCount();
        int a2 = b.d.k.c.a(i, p.k(this));
        list.clear();
        if (z2) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f192b == 0 && M(childAt) && p(eVar.f76a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f192b == 0 && M(childAt2) && p(eVar2.f76a) == a2) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e m2 = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        m2.f192b = 1;
        if (!z2 || this.r == null) {
            addView(view, m2);
            return;
        }
        view.setLayoutParams(m2);
        this.N.add(view);
    }

    private MenuInflater getMenuInflater() {
        return new b.a.m.g(getContext());
    }

    private void h() {
        if (this.C == null) {
            this.C = new l0();
        }
    }

    private void i() {
        if (this.n == null) {
            this.n = new o(getContext());
        }
    }

    private void j() {
        k();
        if (this.j.L() == null) {
            h hVar = (h) this.j.getMenu();
            if (this.T == null) {
                this.T = new d();
            }
            this.j.setExpandedActionViewsExclusive(true);
            hVar.c(this.T, this.s);
        }
    }

    private void k() {
        if (this.j == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.j = actionMenuView;
            actionMenuView.setPopupTheme(this.t);
            this.j.setOnMenuItemClickListener(this.Q);
            this.j.M(this.U, this.V);
            e m2 = generateDefaultLayoutParams();
            m2.f76a = 8388613 | (this.w & b.a.j.H0);
            this.j.setLayoutParams(m2);
            c(this.j, false);
        }
    }

    private void l() {
        if (this.m == null) {
            this.m = new m(getContext(), (AttributeSet) null, b.a.a.toolbarNavigationButtonStyle);
            e m2 = generateDefaultLayoutParams();
            m2.f76a = 8388611 | (this.w & b.a.j.H0);
            this.m.setLayoutParams(m2);
        }
    }

    private int p(int i) {
        int k2 = p.k(this);
        int a2 = b.d.k.c.a(i, k2) & 7;
        return (a2 == 1 || a2 == 3 || a2 == 5) ? a2 : k2 == 1 ? 5 : 3;
    }

    private int q(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int r2 = r(eVar.f76a);
        if (r2 == 48) {
            return getPaddingTop() - i2;
        }
        if (r2 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - eVar.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = eVar.topMargin;
        if (i3 < i4) {
            i3 = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
            int i6 = eVar.bottomMargin;
            if (i5 < i6) {
                i3 = Math.max(0, i3 - (i6 - i5));
            }
        }
        return paddingTop + i3;
    }

    private int r(int i) {
        int i2 = i & b.a.j.H0;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.F & b.a.j.H0;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return b.d.k.f.b(marginLayoutParams) + b.d.k.f.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            View view = list.get(i3);
            e eVar = (e) view.getLayoutParams();
            int i5 = eVar.leftMargin - i;
            int i6 = eVar.rightMargin - i2;
            int max = Math.max(0, i5);
            int max2 = Math.max(0, i6);
            int max3 = Math.max(0, -i5);
            int max4 = Math.max(0, -i6);
            i4 += max + view.getMeasuredWidth() + max2;
            i3++;
            i2 = max4;
            i = max3;
        }
        return i4;
    }

    private boolean x(View view) {
        return view.getParent() == this || this.N.contains(view);
    }

    /* access modifiers changed from: package-private */
    public void F() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((e) childAt.getLayoutParams()).f192b == 2 || childAt == this.j)) {
                removeViewAt(childCount);
                this.N.add(childAt);
            }
        }
    }

    public void G(int i, int i2) {
        h();
        this.C.g(i, i2);
    }

    public void H(h hVar, c cVar) {
        if (hVar != null || this.j != null) {
            k();
            h L2 = this.j.L();
            if (L2 != hVar) {
                if (L2 != null) {
                    L2.O(this.S);
                    L2.O(this.T);
                }
                if (this.T == null) {
                    this.T = new d();
                }
                cVar.F(true);
                if (hVar != null) {
                    hVar.c(cVar, this.s);
                    hVar.c(this.T, this.s);
                } else {
                    cVar.d(this.s, (h) null);
                    this.T.d(this.s, (h) null);
                    cVar.k(true);
                    this.T.k(true);
                }
                this.j.setPopupTheme(this.t);
                this.j.setPresenter(cVar);
                this.S = cVar;
            }
        }
    }

    public void I(o.a aVar, h.a aVar2) {
        this.U = aVar;
        this.V = aVar2;
        ActionMenuView actionMenuView = this.j;
        if (actionMenuView != null) {
            actionMenuView.M(aVar, aVar2);
        }
    }

    public void J(Context context, int i) {
        this.v = i;
        TextView textView = this.l;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void K(Context context, int i) {
        this.u = i;
        TextView textView = this.k;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public boolean N() {
        ActionMenuView actionMenuView = this.j;
        return actionMenuView != null && actionMenuView.N();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (int size = this.N.size() - 1; size >= 0; size--) {
            addView(this.N.get(size));
        }
        this.N.clear();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.j;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r1 = this;
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0012
            androidx.appcompat.widget.ActionMenuView r0 = r1.j
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.I()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.d():boolean");
    }

    public void e() {
        d dVar = this.T;
        j jVar = dVar == null ? null : dVar.k;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.j;
        if (actionMenuView != null) {
            actionMenuView.z();
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.q == null) {
            m mVar = new m(getContext(), (AttributeSet) null, b.a.a.toolbarNavigationButtonStyle);
            this.q = mVar;
            mVar.setImageDrawable(this.o);
            this.q.setContentDescription(this.p);
            e m2 = generateDefaultLayoutParams();
            m2.f76a = 8388611 | (this.w & b.a.j.H0);
            m2.f192b = 2;
            this.q.setLayoutParams(m2);
            this.q.setOnClickListener(new c());
        }
    }

    public int getContentInsetEnd() {
        l0 l0Var = this.C;
        if (l0Var != null) {
            return l0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.E;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        l0 l0Var = this.C;
        if (l0Var != null) {
            return l0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        l0 l0Var = this.C;
        if (l0Var != null) {
            return l0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        l0 l0Var = this.C;
        if (l0Var != null) {
            return l0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.D;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.L();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCurrentContentInsetEnd() {
        /*
            r3 = this;
            androidx.appcompat.widget.ActionMenuView r0 = r3.j
            r1 = 0
            if (r0 == 0) goto L_0x0013
            androidx.appcompat.view.menu.h r0 = r0.L()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.hasVisibleItems()
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0025
            int r0 = r3.getContentInsetEnd()
            int r2 = r3.E
            int r1 = java.lang.Math.max(r2, r1)
            int r0 = java.lang.Math.max(r0, r1)
            goto L_0x0029
        L_0x0025:
            int r0 = r3.getContentInsetEnd()
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.getCurrentContentInsetEnd():int");
    }

    public int getCurrentContentInsetLeft() {
        return p.k(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return p.k(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.D, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.n;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.n;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.j.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.m;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.m;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public c getOuterActionMenuPresenter() {
        return this.S;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.j.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.s;
    }

    public int getPopupTheme() {
        return this.t;
    }

    public CharSequence getSubtitle() {
        return this.H;
    }

    public CharSequence getTitle() {
        return this.G;
    }

    public int getTitleMarginBottom() {
        return this.B;
    }

    public int getTitleMarginEnd() {
        return this.z;
    }

    public int getTitleMarginStart() {
        return this.y;
    }

    public int getTitleMarginTop() {
        return this.A;
    }

    public b0 getWrapper() {
        if (this.R == null) {
            this.R = new u0(this, true);
        }
        return this.R;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    /* renamed from: n */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof a.C0007a ? new e((a.C0007a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.a0);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.L = false;
        }
        if (!this.L) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.L = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.L = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0299 A[LOOP:0: B:106:0x0297->B:107:0x0299, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02bb A[LOOP:1: B:109:0x02b9->B:110:0x02bb, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02f4 A[LOOP:2: B:117:0x02f2->B:118:0x02f4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x021f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = b.d.k.p.k(r19)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.O
            r11[r2] = r3
            r11[r3] = r3
            int r12 = b.d.k.p.l(r19)
            if (r12 < 0) goto L_0x003a
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = 0
        L_0x003b:
            android.widget.ImageButton r13 = r0.m
            boolean r13 = r0.M(r13)
            if (r13 == 0) goto L_0x0053
            android.widget.ImageButton r13 = r0.m
            if (r1 == 0) goto L_0x004e
            int r13 = r0.B(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x0055
        L_0x004e:
            int r13 = r0.A(r13, r6, r11, r12)
            goto L_0x0054
        L_0x0053:
            r13 = r6
        L_0x0054:
            r14 = r10
        L_0x0055:
            android.widget.ImageButton r15 = r0.q
            boolean r15 = r0.M(r15)
            if (r15 == 0) goto L_0x006a
            android.widget.ImageButton r15 = r0.q
            if (r1 == 0) goto L_0x0066
            int r14 = r0.B(r15, r14, r11, r12)
            goto L_0x006a
        L_0x0066:
            int r13 = r0.A(r15, r13, r11, r12)
        L_0x006a:
            androidx.appcompat.widget.ActionMenuView r15 = r0.j
            boolean r15 = r0.M(r15)
            if (r15 == 0) goto L_0x007f
            androidx.appcompat.widget.ActionMenuView r15 = r0.j
            if (r1 == 0) goto L_0x007b
            int r13 = r0.A(r15, r13, r11, r12)
            goto L_0x007f
        L_0x007b:
            int r14 = r0.B(r15, r14, r11, r12)
        L_0x007f:
            int r15 = r19.getCurrentContentInsetLeft()
            int r16 = r19.getCurrentContentInsetRight()
            int r2 = r15 - r13
            int r2 = java.lang.Math.max(r3, r2)
            r11[r3] = r2
            int r2 = r10 - r14
            int r2 = r16 - r2
            int r2 = java.lang.Math.max(r3, r2)
            r17 = 1
            r11[r17] = r2
            int r2 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.r
            boolean r13 = r0.M(r13)
            if (r13 == 0) goto L_0x00ba
            android.view.View r13 = r0.r
            if (r1 == 0) goto L_0x00b6
            int r10 = r0.B(r13, r10, r11, r12)
            goto L_0x00ba
        L_0x00b6:
            int r2 = r0.A(r13, r2, r11, r12)
        L_0x00ba:
            android.widget.ImageView r13 = r0.n
            boolean r13 = r0.M(r13)
            if (r13 == 0) goto L_0x00cf
            android.widget.ImageView r13 = r0.n
            if (r1 == 0) goto L_0x00cb
            int r10 = r0.B(r13, r10, r11, r12)
            goto L_0x00cf
        L_0x00cb:
            int r2 = r0.A(r13, r2, r11, r12)
        L_0x00cf:
            android.widget.TextView r13 = r0.k
            boolean r13 = r0.M(r13)
            android.widget.TextView r14 = r0.l
            boolean r14 = r0.M(r14)
            if (r13 == 0) goto L_0x00f6
            android.widget.TextView r15 = r0.k
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r15 = (androidx.appcompat.widget.Toolbar.e) r15
            int r3 = r15.topMargin
            r23 = r7
            android.widget.TextView r7 = r0.k
            int r7 = r7.getMeasuredHeight()
            int r3 = r3 + r7
            int r7 = r15.bottomMargin
            int r3 = r3 + r7
            r7 = 0
            int r3 = r3 + r7
            goto L_0x00f9
        L_0x00f6:
            r23 = r7
            r3 = 0
        L_0x00f9:
            if (r14 == 0) goto L_0x0113
            android.widget.TextView r7 = r0.l
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r7 = (androidx.appcompat.widget.Toolbar.e) r7
            int r15 = r7.topMargin
            r16 = r4
            android.widget.TextView r4 = r0.l
            int r4 = r4.getMeasuredHeight()
            int r15 = r15 + r4
            int r4 = r7.bottomMargin
            int r15 = r15 + r4
            int r3 = r3 + r15
            goto L_0x0115
        L_0x0113:
            r16 = r4
        L_0x0115:
            if (r13 != 0) goto L_0x0121
            if (r14 == 0) goto L_0x011a
            goto L_0x0121
        L_0x011a:
            r18 = r6
            r22 = r12
        L_0x011e:
            r1 = 0
            goto L_0x028a
        L_0x0121:
            if (r13 == 0) goto L_0x0126
            android.widget.TextView r4 = r0.k
            goto L_0x0128
        L_0x0126:
            android.widget.TextView r4 = r0.l
        L_0x0128:
            if (r14 == 0) goto L_0x012d
            android.widget.TextView r7 = r0.l
            goto L_0x012f
        L_0x012d:
            android.widget.TextView r7 = r0.k
        L_0x012f:
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r4 = (androidx.appcompat.widget.Toolbar.e) r4
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r7 = (androidx.appcompat.widget.Toolbar.e) r7
            if (r13 == 0) goto L_0x0145
            android.widget.TextView r15 = r0.k
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x014f
        L_0x0145:
            if (r14 == 0) goto L_0x0152
            android.widget.TextView r15 = r0.l
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x0152
        L_0x014f:
            r17 = 1
            goto L_0x0154
        L_0x0152:
            r17 = 0
        L_0x0154:
            int r15 = r0.F
            r15 = r15 & 112(0x70, float:1.57E-43)
            r18 = r6
            r6 = 48
            if (r15 == r6) goto L_0x019c
            r6 = 80
            if (r15 == r6) goto L_0x018e
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r3
            int r6 = r6 / 2
            int r15 = r4.topMargin
            r22 = r12
            int r12 = r0.A
            r24 = r2
            int r2 = r15 + r12
            if (r6 >= r2) goto L_0x0177
            int r6 = r15 + r12
            goto L_0x018c
        L_0x0177:
            int r5 = r5 - r9
            int r5 = r5 - r3
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r2 = r4.bottomMargin
            int r3 = r0.B
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x018c
            int r2 = r7.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r6 = r6 - r2
            r2 = 0
            int r6 = java.lang.Math.max(r2, r6)
        L_0x018c:
            int r8 = r8 + r6
            goto L_0x01ab
        L_0x018e:
            r24 = r2
            r22 = r12
            int r5 = r5 - r9
            int r2 = r7.bottomMargin
            int r5 = r5 - r2
            int r2 = r0.B
            int r5 = r5 - r2
            int r8 = r5 - r3
            goto L_0x01ab
        L_0x019c:
            r24 = r2
            r22 = r12
            int r2 = r19.getPaddingTop()
            int r3 = r4.topMargin
            int r2 = r2 + r3
            int r3 = r0.A
            int r8 = r2 + r3
        L_0x01ab:
            if (r1 == 0) goto L_0x021f
            if (r17 == 0) goto L_0x01b2
            int r1 = r0.y
            goto L_0x01b3
        L_0x01b2:
            r1 = 0
        L_0x01b3:
            r2 = 1
            r3 = r11[r2]
            int r1 = r1 - r3
            r3 = 0
            int r4 = java.lang.Math.max(r3, r1)
            int r10 = r10 - r4
            int r1 = -r1
            int r1 = java.lang.Math.max(r3, r1)
            r11[r2] = r1
            if (r13 == 0) goto L_0x01ea
            android.widget.TextView r1 = r0.k
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r1 = (androidx.appcompat.widget.Toolbar.e) r1
            android.widget.TextView r2 = r0.k
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.k
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.k
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.z
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01eb
        L_0x01ea:
            r2 = r10
        L_0x01eb:
            if (r14 == 0) goto L_0x0213
            android.widget.TextView r1 = r0.l
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r1 = (androidx.appcompat.widget.Toolbar.e) r1
            int r3 = r1.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.l
            int r3 = r3.getMeasuredWidth()
            int r3 = r10 - r3
            android.widget.TextView r4 = r0.l
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            android.widget.TextView r5 = r0.l
            r5.layout(r3, r8, r10, r4)
            int r3 = r0.z
            int r3 = r10 - r3
            int r1 = r1.bottomMargin
            goto L_0x0214
        L_0x0213:
            r3 = r10
        L_0x0214:
            if (r17 == 0) goto L_0x021b
            int r1 = java.lang.Math.min(r2, r3)
            r10 = r1
        L_0x021b:
            r2 = r24
            goto L_0x011e
        L_0x021f:
            if (r17 == 0) goto L_0x0225
            int r7 = r0.y
            r1 = 0
            goto L_0x0227
        L_0x0225:
            r1 = 0
            r7 = 0
        L_0x0227:
            r2 = r11[r1]
            int r7 = r7 - r2
            int r2 = java.lang.Math.max(r1, r7)
            int r2 = r24 + r2
            int r3 = -r7
            int r3 = java.lang.Math.max(r1, r3)
            r11[r1] = r3
            if (r13 == 0) goto L_0x025c
            android.widget.TextView r3 = r0.k
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r3 = (androidx.appcompat.widget.Toolbar.e) r3
            android.widget.TextView r4 = r0.k
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r2
            android.widget.TextView r5 = r0.k
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.k
            r6.layout(r2, r8, r4, r5)
            int r6 = r0.z
            int r4 = r4 + r6
            int r3 = r3.bottomMargin
            int r8 = r5 + r3
            goto L_0x025d
        L_0x025c:
            r4 = r2
        L_0x025d:
            if (r14 == 0) goto L_0x0283
            android.widget.TextView r3 = r0.l
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$e r3 = (androidx.appcompat.widget.Toolbar.e) r3
            int r5 = r3.topMargin
            int r8 = r8 + r5
            android.widget.TextView r5 = r0.l
            int r5 = r5.getMeasuredWidth()
            int r5 = r5 + r2
            android.widget.TextView r6 = r0.l
            int r6 = r6.getMeasuredHeight()
            int r6 = r6 + r8
            android.widget.TextView r7 = r0.l
            r7.layout(r2, r8, r5, r6)
            int r6 = r0.z
            int r5 = r5 + r6
            int r3 = r3.bottomMargin
            goto L_0x0284
        L_0x0283:
            r5 = r2
        L_0x0284:
            if (r17 == 0) goto L_0x028a
            int r2 = java.lang.Math.max(r4, r5)
        L_0x028a:
            java.util.ArrayList<android.view.View> r3 = r0.M
            r4 = 3
            r0.b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.M
            int r3 = r3.size()
            r7 = 0
        L_0x0297:
            if (r7 >= r3) goto L_0x02aa
            java.util.ArrayList<android.view.View> r4 = r0.M
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            r12 = r22
            int r2 = r0.A(r4, r2, r11, r12)
            int r7 = r7 + 1
            goto L_0x0297
        L_0x02aa:
            r12 = r22
            java.util.ArrayList<android.view.View> r3 = r0.M
            r4 = 5
            r0.b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.M
            int r3 = r3.size()
            r7 = 0
        L_0x02b9:
            if (r7 >= r3) goto L_0x02ca
            java.util.ArrayList<android.view.View> r4 = r0.M
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.B(r4, r10, r11, r12)
            int r7 = r7 + 1
            goto L_0x02b9
        L_0x02ca:
            java.util.ArrayList<android.view.View> r3 = r0.M
            r4 = 1
            r0.b(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.M
            int r3 = r0.u(r3, r11)
            int r4 = r16 - r18
            int r4 = r4 - r23
            int r4 = r4 / 2
            int r6 = r18 + r4
            int r4 = r3 / 2
            int r6 = r6 - r4
            int r3 = r3 + r6
            if (r6 >= r2) goto L_0x02e5
            goto L_0x02ec
        L_0x02e5:
            if (r3 <= r10) goto L_0x02eb
            int r3 = r3 - r10
            int r2 = r6 - r3
            goto L_0x02ec
        L_0x02eb:
            r2 = r6
        L_0x02ec:
            java.util.ArrayList<android.view.View> r3 = r0.M
            int r3 = r3.size()
        L_0x02f2:
            if (r1 >= r3) goto L_0x0303
            java.util.ArrayList<android.view.View> r4 = r0.M
            java.lang.Object r4 = r4.get(r1)
            android.view.View r4 = (android.view.View) r4
            int r2 = r0.A(r4, r2, r11, r12)
            int r1 = r1 + 1
            goto L_0x02f2
        L_0x0303:
            java.util.ArrayList<android.view.View> r1 = r0.M
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        char c2;
        char c3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.O;
        int i10 = 0;
        if (z0.b(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c3 = 0;
            c2 = 1;
        }
        if (M(this.m)) {
            D(this.m, i, 0, i2, 0, this.x);
            i5 = this.m.getMeasuredWidth() + s(this.m);
            i4 = Math.max(0, this.m.getMeasuredHeight() + t(this.m));
            i3 = View.combineMeasuredStates(0, this.m.getMeasuredState());
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (M(this.q)) {
            D(this.q, i, 0, i2, 0, this.x);
            i5 = this.q.getMeasuredWidth() + s(this.q);
            i4 = Math.max(i4, this.q.getMeasuredHeight() + t(this.q));
            i3 = View.combineMeasuredStates(i3, this.q.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i5);
        iArr[c3] = Math.max(0, currentContentInsetStart - i5);
        if (M(this.j)) {
            D(this.j, i, max, i2, 0, this.x);
            i6 = this.j.getMeasuredWidth() + s(this.j);
            i4 = Math.max(i4, this.j.getMeasuredHeight() + t(this.j));
            i3 = View.combineMeasuredStates(i3, this.j.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i6);
        if (M(this.r)) {
            max2 += C(this.r, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.r.getMeasuredHeight() + t(this.r));
            i3 = View.combineMeasuredStates(i3, this.r.getMeasuredState());
        }
        if (M(this.n)) {
            max2 += C(this.n, i, max2, i2, 0, iArr);
            i4 = Math.max(i4, this.n.getMeasuredHeight() + t(this.n));
            i3 = View.combineMeasuredStates(i3, this.n.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (((e) childAt.getLayoutParams()).f192b == 0 && M(childAt)) {
                max2 += C(childAt, i, max2, i2, 0, iArr);
                i4 = Math.max(i4, childAt.getMeasuredHeight() + t(childAt));
                i3 = View.combineMeasuredStates(i3, childAt.getMeasuredState());
            }
        }
        int i12 = this.A + this.B;
        int i13 = this.y + this.z;
        if (M(this.k)) {
            C(this.k, i, max2 + i13, i2, i12, iArr);
            int measuredWidth = this.k.getMeasuredWidth() + s(this.k);
            i7 = this.k.getMeasuredHeight() + t(this.k);
            i9 = View.combineMeasuredStates(i3, this.k.getMeasuredState());
            i8 = measuredWidth;
        } else {
            i9 = i3;
            i8 = 0;
            i7 = 0;
        }
        if (M(this.l)) {
            int i14 = i7 + i12;
            i8 = Math.max(i8, C(this.l, i, max2 + i13, i2, i14, iArr));
            i7 += this.l.getMeasuredHeight() + t(this.l);
            i9 = View.combineMeasuredStates(i9, this.l.getMeasuredState());
        } else {
            int i15 = i9;
        }
        int max3 = Math.max(i4, i7);
        int paddingLeft = max2 + i8 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, -16777216 & i9);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i9 << 16);
        if (!L()) {
            i10 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i10);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.a());
        ActionMenuView actionMenuView = this.j;
        h L2 = actionMenuView != null ? actionMenuView.L() : null;
        int i = gVar.l;
        if (!(i == 0 || this.T == null || L2 == null || (findItem = L2.findItem(i)) == null)) {
            findItem.expandActionView();
        }
        if (gVar.m) {
            E();
        }
    }

    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        h();
        l0 l0Var = this.C;
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        l0Var.f(z2);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        j jVar;
        g gVar = new g(super.onSaveInstanceState());
        d dVar = this.T;
        if (!(dVar == null || (jVar = dVar.k) == null)) {
            gVar.l = jVar.getItemId();
        }
        gVar.m = z();
        return gVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.K = false;
        }
        if (!this.K) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.K = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.K = false;
        }
        return true;
    }

    public void setCollapsible(boolean z2) {
        this.W = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.E) {
            this.E = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.D) {
            this.D = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(b.a.k.a.a.d(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!x(this.n)) {
                c(this.n, true);
            }
        } else {
            ImageView imageView = this.n;
            if (imageView != null && x(imageView)) {
                removeView(this.n);
                this.N.remove(this.n);
            }
        }
        ImageView imageView2 = this.n;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.n;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.m;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(b.a.k.a.a.d(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!x(this.m)) {
                c(this.m, true);
            }
        } else {
            ImageButton imageButton = this.m;
            if (imageButton != null && x(imageButton)) {
                removeView(this.m);
                this.N.remove(this.m);
            }
        }
        ImageButton imageButton2 = this.m;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.m.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.P = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.j.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.t != i) {
            this.t = i;
            if (i == 0) {
                this.s = getContext();
            } else {
                this.s = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.l == null) {
                Context context = getContext();
                y yVar = new y(context);
                this.l = yVar;
                yVar.setSingleLine();
                this.l.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.v;
                if (i != 0) {
                    this.l.setTextAppearance(context, i);
                }
                int i2 = this.J;
                if (i2 != 0) {
                    this.l.setTextColor(i2);
                }
            }
            if (!x(this.l)) {
                c(this.l, true);
            }
        } else {
            TextView textView = this.l;
            if (textView != null && x(textView)) {
                removeView(this.l);
                this.N.remove(this.l);
            }
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.H = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.J = i;
        TextView textView = this.l;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.k == null) {
                Context context = getContext();
                y yVar = new y(context);
                this.k = yVar;
                yVar.setSingleLine();
                this.k.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.u;
                if (i != 0) {
                    this.k.setTextAppearance(context, i);
                }
                int i2 = this.I;
                if (i2 != 0) {
                    this.k.setTextColor(i2);
                }
            }
            if (!x(this.k)) {
                c(this.k, true);
            }
        } else {
            TextView textView = this.k;
            if (textView != null && x(textView)) {
                removeView(this.k);
                this.N.remove(this.k);
            }
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.G = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.B = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.z = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.y = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.A = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        this.I = i;
        TextView textView = this.k;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public boolean v() {
        d dVar = this.T;
        return (dVar == null || dVar.k == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.j;
        return actionMenuView != null && actionMenuView.F();
    }

    public boolean y() {
        ActionMenuView actionMenuView = this.j;
        return actionMenuView != null && actionMenuView.G();
    }

    public boolean z() {
        ActionMenuView actionMenuView = this.j;
        return actionMenuView != null && actionMenuView.H();
    }
}
