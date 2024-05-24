package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.Toolbar;
import b.a.e;
import b.a.f;
import b.a.h;
import b.a.j;
import b.d.k.p;
import b.d.k.t;
import b.d.k.v;

public class u0 implements b0 {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f259a;

    /* renamed from: b  reason: collision with root package name */
    private int f260b;

    /* renamed from: c  reason: collision with root package name */
    private View f261c;

    /* renamed from: d  reason: collision with root package name */
    private View f262d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f263e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f264f;
    private Drawable g;
    private boolean h;
    CharSequence i;
    private CharSequence j;
    private CharSequence k;
    Window.Callback l;
    boolean m;
    private c n;
    private int o;
    private int p;
    private Drawable q;

    class a implements View.OnClickListener {
        final androidx.appcompat.view.menu.a j;

        a() {
            this.j = new androidx.appcompat.view.menu.a(u0.this.f259a.getContext(), 0, 16908332, 0, 0, u0.this.i);
        }

        public void onClick(View view) {
            u0 u0Var = u0.this;
            Window.Callback callback = u0Var.l;
            if (callback != null && u0Var.m) {
                callback.onMenuItemSelected(0, this.j);
            }
        }
    }

    class b extends v {

        /* renamed from: a  reason: collision with root package name */
        private boolean f265a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f266b;

        b(int i) {
            this.f266b = i;
        }

        public void a(View view) {
            if (!this.f265a) {
                u0.this.f259a.setVisibility(this.f266b);
            }
        }

        public void b(View view) {
            u0.this.f259a.setVisibility(0);
        }

        public void c(View view) {
            this.f265a = true;
        }
    }

    public u0(Toolbar toolbar, boolean z) {
        this(toolbar, z, h.abc_action_bar_up_description, e.abc_ic_ab_back_material);
    }

    public u0(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f259a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        t0 t = t0.t(toolbar.getContext(), (AttributeSet) null, j.f457a, b.a.a.actionBarStyle, 0);
        this.q = t.f(j.l);
        if (z) {
            CharSequence o2 = t.o(j.r);
            if (!TextUtils.isEmpty(o2)) {
                setTitle(o2);
            }
            CharSequence o3 = t.o(j.p);
            if (!TextUtils.isEmpty(o3)) {
                G(o3);
            }
            Drawable f2 = t.f(j.n);
            if (f2 != null) {
                D(f2);
            }
            Drawable f3 = t.f(j.m);
            if (f3 != null) {
                setIcon(f3);
            }
            if (this.g == null && (drawable = this.q) != null) {
                w(drawable);
            }
            y(t.j(j.h, 0));
            int m2 = t.m(j.g, 0);
            if (m2 != 0) {
                B(LayoutInflater.from(this.f259a.getContext()).inflate(m2, this.f259a, false));
                y(this.f260b | 16);
            }
            int l2 = t.l(j.j, 0);
            if (l2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f259a.getLayoutParams();
                layoutParams.height = l2;
                this.f259a.setLayoutParams(layoutParams);
            }
            int d2 = t.d(j.f462f, -1);
            int d3 = t.d(j.f461e, -1);
            if (d2 >= 0 || d3 >= 0) {
                this.f259a.G(Math.max(d2, 0), Math.max(d3, 0));
            }
            int m3 = t.m(j.s, 0);
            if (m3 != 0) {
                Toolbar toolbar2 = this.f259a;
                toolbar2.K(toolbar2.getContext(), m3);
            }
            int m4 = t.m(j.q, 0);
            if (m4 != 0) {
                Toolbar toolbar3 = this.f259a;
                toolbar3.J(toolbar3.getContext(), m4);
            }
            int m5 = t.m(j.o, 0);
            if (m5 != 0) {
                this.f259a.setPopupTheme(m5);
            }
        } else {
            this.f260b = A();
        }
        t.u();
        C(i2);
        this.k = this.f259a.getNavigationContentDescription();
        this.f259a.setNavigationOnClickListener(new a());
    }

    private int A() {
        if (this.f259a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f259a.getNavigationIcon();
        return 15;
    }

    private void H(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.f260b & 8) != 0) {
            this.f259a.setTitle(charSequence);
        }
    }

    private void I() {
        if ((this.f260b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.k)) {
            this.f259a.setNavigationContentDescription(this.p);
        } else {
            this.f259a.setNavigationContentDescription(this.k);
        }
    }

    private void J() {
        Drawable drawable;
        Toolbar toolbar;
        if ((this.f260b & 4) != 0) {
            toolbar = this.f259a;
            drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
        } else {
            toolbar = this.f259a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void K() {
        Drawable drawable;
        int i2 = this.f260b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f264f) == null) {
            drawable = this.f263e;
        }
        this.f259a.setLogo(drawable);
    }

    public void B(View view) {
        View view2 = this.f262d;
        if (!(view2 == null || (this.f260b & 16) == 0)) {
            this.f259a.removeView(view2);
        }
        this.f262d = view;
        if (view != null && (this.f260b & 16) != 0) {
            this.f259a.addView(view);
        }
    }

    public void C(int i2) {
        if (i2 != this.p) {
            this.p = i2;
            if (TextUtils.isEmpty(this.f259a.getNavigationContentDescription())) {
                E(this.p);
            }
        }
    }

    public void D(Drawable drawable) {
        this.f264f = drawable;
        K();
    }

    public void E(int i2) {
        F(i2 == 0 ? null : q().getString(i2));
    }

    public void F(CharSequence charSequence) {
        this.k = charSequence;
        I();
    }

    public void G(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.f260b & 8) != 0) {
            this.f259a.setSubtitle(charSequence);
        }
    }

    public void a(Menu menu, o.a aVar) {
        if (this.n == null) {
            c cVar = new c(this.f259a.getContext());
            this.n = cVar;
            cVar.p(f.action_menu_presenter);
        }
        this.n.i(aVar);
        this.f259a.H((androidx.appcompat.view.menu.h) menu, this.n);
    }

    public boolean b() {
        return this.f259a.y();
    }

    public boolean c() {
        return this.f259a.z();
    }

    public void collapseActionView() {
        this.f259a.e();
    }

    public boolean d() {
        return this.f259a.w();
    }

    public boolean e() {
        return this.f259a.N();
    }

    public void f() {
        this.m = true;
    }

    public boolean g() {
        return this.f259a.d();
    }

    public CharSequence getTitle() {
        return this.f259a.getTitle();
    }

    public void h() {
        this.f259a.f();
    }

    public void i(o.a aVar, h.a aVar2) {
        this.f259a.I(aVar, aVar2);
    }

    public int j() {
        return this.f260b;
    }

    public void k(int i2) {
        this.f259a.setVisibility(i2);
    }

    public Menu l() {
        return this.f259a.getMenu();
    }

    public void m(int i2) {
        D(i2 != 0 ? b.a.k.a.a.d(q(), i2) : null);
    }

    public void n(m0 m0Var) {
        Toolbar toolbar;
        View view = this.f261c;
        if (view != null && view.getParent() == (toolbar = this.f259a)) {
            toolbar.removeView(this.f261c);
        }
        this.f261c = m0Var;
        if (m0Var != null && this.o == 2) {
            this.f259a.addView(m0Var, 0);
            Toolbar.e eVar = (Toolbar.e) this.f261c.getLayoutParams();
            eVar.width = -2;
            eVar.height = -2;
            eVar.f76a = 8388691;
            m0Var.setAllowCollapse(true);
        }
    }

    public ViewGroup o() {
        return this.f259a;
    }

    public void p(boolean z) {
    }

    public Context q() {
        return this.f259a.getContext();
    }

    public int r() {
        return this.o;
    }

    public t s(int i2, long j2) {
        t b2 = p.b(this.f259a);
        b2.a(i2 == 0 ? 1.0f : 0.0f);
        b2.d(j2);
        b2.f(new b(i2));
        return b2;
    }

    public void setIcon(int i2) {
        setIcon(i2 != 0 ? b.a.k.a.a.d(q(), i2) : null);
    }

    public void setIcon(Drawable drawable) {
        this.f263e = drawable;
        K();
    }

    public void setTitle(CharSequence charSequence) {
        this.h = true;
        H(charSequence);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.h) {
            H(charSequence);
        }
    }

    public void t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean u() {
        return this.f259a.v();
    }

    public void v() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void w(Drawable drawable) {
        this.g = drawable;
        J();
    }

    public void x(boolean z) {
        this.f259a.setCollapsible(z);
    }

    public void y(int i2) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i3 = this.f260b ^ i2;
        this.f260b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    I();
                }
                J();
            }
            if ((i3 & 3) != 0) {
                K();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f259a.setTitle(this.i);
                    toolbar = this.f259a;
                    charSequence = this.j;
                } else {
                    charSequence = null;
                    this.f259a.setTitle((CharSequence) null);
                    toolbar = this.f259a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i3 & 16) != 0 && (view = this.f262d) != null) {
                if ((i2 & 16) != 0) {
                    this.f259a.addView(view);
                } else {
                    this.f259a.removeView(view);
                }
            }
        }
    }

    public void z(int i2) {
        w(i2 != 0 ? b.a.k.a.a.d(q(), i2) : null);
    }
}
