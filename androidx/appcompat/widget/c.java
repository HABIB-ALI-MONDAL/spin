package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.s;
import androidx.appcompat.view.menu.u;
import androidx.appcompat.widget.ActionMenuView;
import b.a.g;
import b.d.k.b;
import java.util.ArrayList;

class c extends androidx.appcompat.view.menu.b implements b.a {
    private boolean A;
    private boolean B;
    private boolean C;
    private int D;
    private final SparseBooleanArray E = new SparseBooleanArray();
    private View F;
    e G;
    a H;
    C0010c I;
    private b J;
    final f K = new f();
    int L;
    d r;
    private Drawable s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private boolean z;

    private class a extends n {
        public a(Context context, u uVar, View view) {
            super(context, uVar, view, false, b.a.a.actionOverflowMenuStyle);
            if (!((j) uVar.getItem()).l()) {
                View view2 = c.this.r;
                f(view2 == null ? (View) c.this.q : view2);
            }
            j(c.this.K);
        }

        /* access modifiers changed from: protected */
        public void e() {
            c cVar = c.this;
            cVar.H = null;
            cVar.L = 0;
            super.e();
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        public s a() {
            a aVar = c.this.H;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$c  reason: collision with other inner class name */
    private class C0010c implements Runnable {
        private e j;

        public C0010c(e eVar) {
            this.j = eVar;
        }

        public void run() {
            if (c.this.l != null) {
                c.this.l.d();
            }
            View view = (View) c.this.q;
            if (!(view == null || view.getWindowToken() == null || !this.j.m())) {
                c.this.G = this.j;
            }
            c.this.I = null;
        }
    }

    private class d extends o implements ActionMenuView.a {

        class a extends f0 {
            a(View view, c cVar) {
                super(view);
            }

            public s b() {
                e eVar = c.this.G;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            public boolean c() {
                c.this.J();
                return true;
            }

            public boolean d() {
                c cVar = c.this;
                if (cVar.I != null) {
                    return false;
                }
                cVar.A();
                return true;
            }
        }

        public d(Context context) {
            super(context, (AttributeSet) null, b.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            v0.a(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.J();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.k(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    private class e extends n {
        public e(Context context, h hVar, View view, boolean z) {
            super(context, hVar, view, z, b.a.a.actionOverflowMenuStyle);
            h(8388613);
            j(c.this.K);
        }

        /* access modifiers changed from: protected */
        public void e() {
            if (c.this.l != null) {
                c.this.l.close();
            }
            c.this.G = null;
            super.e();
        }
    }

    private class f implements o.a {
        f() {
        }

        public void a(h hVar, boolean z) {
            if (hVar instanceof u) {
                hVar.D().e(false);
            }
            o.a m = c.this.m();
            if (m != null) {
                m.a(hVar, z);
            }
        }

        public boolean b(h hVar) {
            if (hVar == null) {
                return false;
            }
            c.this.L = ((u) hVar).getItem().getItemId();
            o.a m = c.this.m();
            if (m != null) {
                return m.b(hVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, g.abc_action_menu_layout, g.abc_action_menu_item_layout);
    }

    private View y(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.q;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof p.a) && ((p.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean A() {
        p pVar;
        C0010c cVar = this.I;
        if (cVar == null || (pVar = this.q) == null) {
            e eVar = this.G;
            if (eVar == null) {
                return false;
            }
            eVar.b();
            return true;
        }
        ((View) pVar).removeCallbacks(cVar);
        this.I = null;
        return true;
    }

    public boolean B() {
        a aVar = this.H;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean C() {
        return this.I != null || D();
    }

    public boolean D() {
        e eVar = this.G;
        return eVar != null && eVar.d();
    }

    public void E(Configuration configuration) {
        if (!this.z) {
            this.y = b.a.m.a.b(this.k).d();
        }
        h hVar = this.l;
        if (hVar != null) {
            hVar.K(true);
        }
    }

    public void F(boolean z2) {
        this.C = z2;
    }

    public void G(ActionMenuView actionMenuView) {
        this.q = actionMenuView;
        actionMenuView.b(this.l);
    }

    public void H(Drawable drawable) {
        d dVar = this.r;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.t = true;
        this.s = drawable;
    }

    public void I(boolean z2) {
        this.u = z2;
        this.v = true;
    }

    public boolean J() {
        h hVar;
        if (!this.u || D() || (hVar = this.l) == null || this.q == null || this.I != null || hVar.z().isEmpty()) {
            return false;
        }
        C0010c cVar = new C0010c(new e(this.k, this.l, this.r, true));
        this.I = cVar;
        ((View) this.q).post(cVar);
        super.j((u) null);
        return true;
    }

    public void a(h hVar, boolean z2) {
        x();
        super.a(hVar, z2);
    }

    public boolean c() {
        int i;
        ArrayList<j> arrayList;
        int i2;
        int i3;
        int i4;
        c cVar = this;
        h hVar = cVar.l;
        int i5 = 0;
        if (hVar != null) {
            arrayList = hVar.E();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = cVar.y;
        int i7 = cVar.x;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.q;
        boolean z2 = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            j jVar = arrayList.get(i10);
            if (jVar.o()) {
                i8++;
            } else if (jVar.n()) {
                i9++;
            } else {
                z2 = true;
            }
            if (cVar.C && jVar.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (cVar.u && (z2 || i9 + i8 > i6)) {
            i6--;
        }
        int i11 = i6 - i8;
        SparseBooleanArray sparseBooleanArray = cVar.E;
        sparseBooleanArray.clear();
        if (cVar.A) {
            int i12 = cVar.D;
            i2 = i7 / i12;
            i3 = i12 + ((i7 % i12) / i2);
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i) {
            j jVar2 = arrayList.get(i13);
            if (jVar2.o()) {
                View n = cVar.n(jVar2, cVar.F, viewGroup);
                if (cVar.F == null) {
                    cVar.F = n;
                }
                if (cVar.A) {
                    i2 -= ActionMenuView.J(n, i3, i2, makeMeasureSpec, i5);
                } else {
                    n.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = n.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                int groupId = jVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                jVar2.u(true);
                i4 = i;
            } else if (jVar2.n()) {
                int groupId2 = jVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i11 > 0 || z3) && i7 > 0 && (!cVar.A || i2 > 0);
                boolean z5 = z4;
                if (z4) {
                    View n2 = cVar.n(jVar2, cVar.F, viewGroup);
                    i4 = i;
                    if (cVar.F == null) {
                        cVar.F = n2;
                    }
                    if (cVar.A) {
                        int J2 = ActionMenuView.J(n2, i3, i2, makeMeasureSpec, 0);
                        i2 -= J2;
                        if (J2 == 0) {
                            z5 = false;
                        }
                    } else {
                        n2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = n2.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z4 = z5 & (!cVar.A ? i7 + i14 > 0 : i7 >= 0);
                } else {
                    i4 = i;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    int i15 = 0;
                    while (i15 < i13) {
                        j jVar3 = arrayList.get(i15);
                        if (jVar3.getGroupId() == groupId2) {
                            if (jVar3.l()) {
                                i11++;
                            }
                            jVar3.u(false);
                        }
                        i15++;
                    }
                }
                if (z4) {
                    i11--;
                }
                jVar2.u(z4);
            } else {
                i4 = i;
                jVar2.u(false);
                i13++;
                cVar = this;
                i = i4;
                i5 = 0;
            }
            i13++;
            cVar = this;
            i = i4;
            i5 = 0;
        }
        return true;
    }

    public void d(Context context, h hVar) {
        super.d(context, hVar);
        Resources resources = context.getResources();
        b.a.m.a b2 = b.a.m.a.b(context);
        if (!this.v) {
            this.u = b2.h();
        }
        if (!this.B) {
            this.w = b2.c();
        }
        if (!this.z) {
            this.y = b2.d();
        }
        int i = this.w;
        if (this.u) {
            if (this.r == null) {
                d dVar = new d(this.j);
                this.r = dVar;
                if (this.t) {
                    dVar.setImageDrawable(this.s);
                    this.s = null;
                    this.t = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.r.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.r.getMeasuredWidth();
        } else {
            this.r = null;
        }
        this.x = i;
        this.D = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.F = null;
    }

    public void f(j jVar, p.a aVar) {
        aVar.d(jVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.q);
        if (this.J == null) {
            this.J = new b();
        }
        actionMenuItemView.setPopupCallback(this.J);
    }

    public boolean j(u uVar) {
        boolean z2 = false;
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        u uVar2 = uVar;
        while (uVar2.e0() != this.l) {
            uVar2 = (u) uVar2.e0();
        }
        View y2 = y(uVar2.getItem());
        if (y2 == null) {
            return false;
        }
        uVar.getItem().getItemId();
        int size = uVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = uVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i++;
        }
        a aVar = new a(this.k, uVar, y2);
        this.H = aVar;
        aVar.g(z2);
        this.H.k();
        super.j(uVar);
        return true;
    }

    public void k(boolean z2) {
        p pVar;
        super.k(z2);
        ((View) this.q).requestLayout();
        h hVar = this.l;
        boolean z3 = false;
        if (hVar != null) {
            ArrayList<j> s2 = hVar.s();
            int size = s2.size();
            for (int i = 0; i < size; i++) {
                b.d.k.b b2 = s2.get(i).b();
                if (b2 != null) {
                    b2.i(this);
                }
            }
        }
        h hVar2 = this.l;
        ArrayList<j> z4 = hVar2 != null ? hVar2.z() : null;
        if (this.u && z4 != null) {
            int size2 = z4.size();
            if (size2 == 1) {
                z3 = !z4.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        d dVar = this.r;
        if (z3) {
            if (dVar == null) {
                this.r = new d(this.j);
            }
            ViewGroup viewGroup = (ViewGroup) this.r.getParent();
            if (viewGroup != this.q) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.r);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.q;
                actionMenuView.addView(this.r, actionMenuView.D());
            }
        } else if (dVar != null && dVar.getParent() == (pVar = this.q)) {
            ((ViewGroup) pVar).removeView(this.r);
        }
        ((ActionMenuView) this.q).setOverflowReserved(this.u);
    }

    public boolean l(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.r) {
            return false;
        }
        return super.l(viewGroup, i);
    }

    public View n(j jVar, View view, ViewGroup viewGroup) {
        View actionView = jVar.getActionView();
        if (actionView == null || jVar.j()) {
            actionView = super.n(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m(layoutParams));
        }
        return actionView;
    }

    public p o(ViewGroup viewGroup) {
        p pVar = this.q;
        p o = super.o(viewGroup);
        if (pVar != o) {
            ((ActionMenuView) o).setPresenter(this);
        }
        return o;
    }

    public boolean q(int i, j jVar) {
        return jVar.l();
    }

    public boolean x() {
        return A() | B();
    }

    public Drawable z() {
        d dVar = this.r;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.t) {
            return this.s;
        }
        return null;
    }
}
