package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.m0;
import b.a.f;
import b.a.j;
import b.a.m.b;
import b.a.m.g;
import b.a.m.h;
import b.d.k.p;
import b.d.k.t;
import b.d.k.u;
import b.d.k.v;
import b.d.k.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class l extends a implements ActionBarOverlayLayout.d {
    private static final Interpolator B = new AccelerateInterpolator();
    private static final Interpolator C = new DecelerateInterpolator();
    final w A = new c();

    /* renamed from: a  reason: collision with root package name */
    Context f127a;

    /* renamed from: b  reason: collision with root package name */
    private Context f128b;

    /* renamed from: c  reason: collision with root package name */
    ActionBarOverlayLayout f129c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarContainer f130d;

    /* renamed from: e  reason: collision with root package name */
    b0 f131e;

    /* renamed from: f  reason: collision with root package name */
    ActionBarContextView f132f;
    View g;
    m0 h;
    private boolean i;
    d j;
    b.a.m.b k;
    b.a l;
    private boolean m;
    private ArrayList<a.b> n = new ArrayList<>();
    private boolean o;
    private int p = 0;
    boolean q = true;
    boolean r;
    boolean s;
    private boolean t;
    private boolean u = true;
    h v;
    private boolean w;
    boolean x;
    final u y = new a();
    final u z = new b();

    class a extends v {
        a() {
        }

        public void a(View view) {
            View view2;
            l lVar = l.this;
            if (lVar.q && (view2 = lVar.g) != null) {
                view2.setTranslationY(0.0f);
                l.this.f130d.setTranslationY(0.0f);
            }
            l.this.f130d.setVisibility(8);
            l.this.f130d.setTransitioning(false);
            l lVar2 = l.this;
            lVar2.v = null;
            lVar2.C();
            ActionBarOverlayLayout actionBarOverlayLayout = l.this.f129c;
            if (actionBarOverlayLayout != null) {
                p.A(actionBarOverlayLayout);
            }
        }
    }

    class b extends v {
        b() {
        }

        public void a(View view) {
            l lVar = l.this;
            lVar.v = null;
            lVar.f130d.requestLayout();
        }
    }

    class c implements w {
        c() {
        }

        public void a(View view) {
            ((View) l.this.f130d.getParent()).invalidate();
        }
    }

    public class d extends b.a.m.b implements h.a {
        private final Context l;
        private final androidx.appcompat.view.menu.h m;
        private b.a n;
        private WeakReference<View> o;

        public d(Context context, b.a aVar) {
            this.l = context;
            this.n = aVar;
            androidx.appcompat.view.menu.h hVar = new androidx.appcompat.view.menu.h(context);
            hVar.S(1);
            this.m = hVar;
            hVar.R(this);
        }

        public boolean a(androidx.appcompat.view.menu.h hVar, MenuItem menuItem) {
            b.a aVar = this.n;
            if (aVar != null) {
                return aVar.b(this, menuItem);
            }
            return false;
        }

        public void b(androidx.appcompat.view.menu.h hVar) {
            if (this.n != null) {
                k();
                l.this.f132f.l();
            }
        }

        public void c() {
            l lVar = l.this;
            if (lVar.j == this) {
                if (!l.B(lVar.r, lVar.s, false)) {
                    l lVar2 = l.this;
                    lVar2.k = this;
                    lVar2.l = this.n;
                } else {
                    this.n.d(this);
                }
                this.n = null;
                l.this.A(false);
                l.this.f132f.g();
                l.this.f131e.o().sendAccessibilityEvent(32);
                l lVar3 = l.this;
                lVar3.f129c.setHideOnContentScrollEnabled(lVar3.x);
                l.this.j = null;
            }
        }

        public View d() {
            WeakReference<View> weakReference = this.o;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public Menu e() {
            return this.m;
        }

        public MenuInflater f() {
            return new g(this.l);
        }

        public CharSequence g() {
            return l.this.f132f.getSubtitle();
        }

        public CharSequence i() {
            return l.this.f132f.getTitle();
        }

        public void k() {
            if (l.this.j == this) {
                this.m.d0();
                try {
                    this.n.a(this, this.m);
                } finally {
                    this.m.c0();
                }
            }
        }

        public boolean l() {
            return l.this.f132f.j();
        }

        public void m(View view) {
            l.this.f132f.setCustomView(view);
            this.o = new WeakReference<>(view);
        }

        public void n(int i) {
            o(l.this.f127a.getResources().getString(i));
        }

        public void o(CharSequence charSequence) {
            l.this.f132f.setSubtitle(charSequence);
        }

        public void q(int i) {
            r(l.this.f127a.getResources().getString(i));
        }

        public void r(CharSequence charSequence) {
            l.this.f132f.setTitle(charSequence);
        }

        public void s(boolean z) {
            super.s(z);
            l.this.f132f.setTitleOptional(z);
        }

        public boolean t() {
            this.m.d0();
            try {
                return this.n.c(this, this.m);
            } finally {
                this.m.c0();
            }
        }
    }

    public l(Activity activity, boolean z2) {
        new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        I(decorView);
        if (!z2) {
            this.g = decorView.findViewById(16908290);
        }
    }

    public l(Dialog dialog) {
        new ArrayList();
        I(dialog.getWindow().getDecorView());
    }

    static boolean B(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    private b0 F(View view) {
        if (view instanceof b0) {
            return (b0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void H() {
        if (this.t) {
            this.t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f129c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            R(false);
        }
    }

    private void I(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(f.decor_content_parent);
        this.f129c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f131e = F(view.findViewById(f.action_bar));
        this.f132f = (ActionBarContextView) view.findViewById(f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(f.action_bar_container);
        this.f130d = actionBarContainer;
        b0 b0Var = this.f131e;
        if (b0Var == null || this.f132f == null || actionBarContainer == null) {
            throw new IllegalStateException(l.class.getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f127a = b0Var.q();
        boolean z2 = (this.f131e.j() & 4) != 0;
        if (z2) {
            this.i = true;
        }
        b.a.m.a b2 = b.a.m.a.b(this.f127a);
        N(b2.a() || z2);
        L(b2.g());
        TypedArray obtainStyledAttributes = this.f127a.obtainStyledAttributes((AttributeSet) null, j.f457a, b.a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.k, false)) {
            M(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.i, 0);
        if (dimensionPixelSize != 0) {
            K((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void L(boolean z2) {
        this.o = z2;
        if (!z2) {
            this.f131e.n((m0) null);
            this.f130d.setTabContainer(this.h);
        } else {
            this.f130d.setTabContainer((m0) null);
            this.f131e.n(this.h);
        }
        boolean z3 = true;
        boolean z4 = G() == 2;
        m0 m0Var = this.h;
        if (m0Var != null) {
            if (z4) {
                m0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f129c;
                if (actionBarOverlayLayout != null) {
                    p.A(actionBarOverlayLayout);
                }
            } else {
                m0Var.setVisibility(8);
            }
        }
        this.f131e.x(!this.o && z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f129c;
        if (this.o || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z3);
    }

    private boolean P() {
        return p.s(this.f130d);
    }

    private void Q() {
        if (!this.t) {
            this.t = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f129c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            R(false);
        }
    }

    private void R(boolean z2) {
        if (B(this.r, this.s, this.t)) {
            if (!this.u) {
                this.u = true;
                E(z2);
            }
        } else if (this.u) {
            this.u = false;
            D(z2);
        }
    }

    public void A(boolean z2) {
        t tVar;
        t tVar2;
        if (z2) {
            Q();
        } else {
            H();
        }
        if (P()) {
            if (z2) {
                tVar = this.f131e.s(4, 100);
                tVar2 = this.f132f.f(0, 200);
            } else {
                tVar2 = this.f131e.s(0, 200);
                tVar = this.f132f.f(8, 100);
            }
            b.a.m.h hVar = new b.a.m.h();
            hVar.d(tVar, tVar2);
            hVar.h();
        } else if (z2) {
            this.f131e.k(4);
            this.f132f.setVisibility(0);
        } else {
            this.f131e.k(0);
            this.f132f.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void C() {
        b.a aVar = this.l;
        if (aVar != null) {
            aVar.d(this.k);
            this.k = null;
            this.l = null;
        }
    }

    public void D(boolean z2) {
        View view;
        b.a.m.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        if (this.p != 0 || (!this.w && !z2)) {
            this.y.a((View) null);
            return;
        }
        this.f130d.setAlpha(1.0f);
        this.f130d.setTransitioning(true);
        b.a.m.h hVar2 = new b.a.m.h();
        float f2 = (float) (-this.f130d.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.f130d.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        t b2 = p.b(this.f130d);
        b2.k(f2);
        b2.i(this.A);
        hVar2.c(b2);
        if (this.q && (view = this.g) != null) {
            t b3 = p.b(view);
            b3.k(f2);
            hVar2.c(b3);
        }
        hVar2.f(B);
        hVar2.e(250);
        hVar2.g(this.y);
        this.v = hVar2;
        hVar2.h();
    }

    public void E(boolean z2) {
        View view;
        View view2;
        b.a.m.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        this.f130d.setVisibility(0);
        if (this.p != 0 || (!this.w && !z2)) {
            this.f130d.setAlpha(1.0f);
            this.f130d.setTranslationY(0.0f);
            if (this.q && (view = this.g) != null) {
                view.setTranslationY(0.0f);
            }
            this.z.a((View) null);
        } else {
            this.f130d.setTranslationY(0.0f);
            float f2 = (float) (-this.f130d.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.f130d.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.f130d.setTranslationY(f2);
            b.a.m.h hVar2 = new b.a.m.h();
            t b2 = p.b(this.f130d);
            b2.k(0.0f);
            b2.i(this.A);
            hVar2.c(b2);
            if (this.q && (view2 = this.g) != null) {
                view2.setTranslationY(f2);
                t b3 = p.b(this.g);
                b3.k(0.0f);
                hVar2.c(b3);
            }
            hVar2.f(C);
            hVar2.e(250);
            hVar2.g(this.z);
            this.v = hVar2;
            hVar2.h();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f129c;
        if (actionBarOverlayLayout != null) {
            p.A(actionBarOverlayLayout);
        }
    }

    public int G() {
        return this.f131e.r();
    }

    public void J(int i2, int i3) {
        int j2 = this.f131e.j();
        if ((i3 & 4) != 0) {
            this.i = true;
        }
        this.f131e.y((i2 & i3) | ((i3 ^ -1) & j2));
    }

    public void K(float f2) {
        p.G(this.f130d, f2);
    }

    public void M(boolean z2) {
        if (!z2 || this.f129c.w()) {
            this.x = z2;
            this.f129c.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void N(boolean z2) {
        this.f131e.p(z2);
    }

    public void O(CharSequence charSequence) {
        this.f131e.setTitle(charSequence);
    }

    public void a(boolean z2) {
        this.q = z2;
    }

    public void b() {
        if (this.s) {
            this.s = false;
            R(true);
        }
    }

    public void c() {
        b.a.m.h hVar = this.v;
        if (hVar != null) {
            hVar.a();
            this.v = null;
        }
    }

    public void d(int i2) {
        this.p = i2;
    }

    public void e() {
        if (!this.s) {
            this.s = true;
            R(true);
        }
    }

    public void f() {
    }

    public boolean h() {
        b0 b0Var = this.f131e;
        if (b0Var == null || !b0Var.u()) {
            return false;
        }
        this.f131e.collapseActionView();
        return true;
    }

    public void i(boolean z2) {
        if (z2 != this.m) {
            this.m = z2;
            int size = this.n.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.n.get(i2).a(z2);
            }
        }
    }

    public int j() {
        return this.f131e.j();
    }

    public Context k() {
        if (this.f128b == null) {
            TypedValue typedValue = new TypedValue();
            this.f127a.getTheme().resolveAttribute(b.a.a.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f128b = new ContextThemeWrapper(this.f127a, i2);
            } else {
                this.f128b = this.f127a;
            }
        }
        return this.f128b;
    }

    public void m(Configuration configuration) {
        L(b.a.m.a.b(this.f127a).g());
    }

    public boolean o(int i2, KeyEvent keyEvent) {
        Menu e2;
        d dVar = this.j;
        if (dVar == null || (e2 = dVar.e()) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        e2.setQwertyMode(z2);
        return e2.performShortcut(i2, keyEvent, 0);
    }

    public void r(boolean z2) {
        if (!this.i) {
            s(z2);
        }
    }

    public void s(boolean z2) {
        J(z2 ? 4 : 0, 4);
    }

    public void t(boolean z2) {
        J(z2 ? 8 : 0, 8);
    }

    public void u(int i2) {
        this.f131e.z(i2);
    }

    public void v(Drawable drawable) {
        this.f131e.w(drawable);
    }

    public void w(boolean z2) {
        b.a.m.h hVar;
        this.w = z2;
        if (!z2 && (hVar = this.v) != null) {
            hVar.a();
        }
    }

    public void x(int i2) {
        O(this.f127a.getString(i2));
    }

    public void y(CharSequence charSequence) {
        this.f131e.setWindowTitle(charSequence);
    }

    public b.a.m.b z(b.a aVar) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.c();
        }
        this.f129c.setHideOnContentScrollEnabled(false);
        this.f132f.k();
        d dVar2 = new d(this.f132f.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.j = dVar2;
        dVar2.k();
        this.f132f.h(dVar2);
        A(true);
        this.f132f.sendAccessibilityEvent(32);
        return dVar2;
    }
}
