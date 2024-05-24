package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.j0;
import b.a.d;
import b.a.g;
import b.d.k.p;

final class t extends m implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, o, View.OnKeyListener {
    private static final int E = g.abc_popup_menu_item_layout;
    private boolean A;
    private int B;
    private int C = 0;
    private boolean D;
    private final Context k;
    private final h l;
    private final g m;
    private final boolean n;
    private final int o;
    private final int p;
    private final int q;
    final j0 r;
    final ViewTreeObserver.OnGlobalLayoutListener s = new a();
    private final View.OnAttachStateChangeListener t = new b();
    private PopupWindow.OnDismissListener u;
    private View v;
    View w;
    private o.a x;
    ViewTreeObserver y;
    private boolean z;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        public void onGlobalLayout() {
            if (t.this.f() && !t.this.r.p()) {
                View view = t.this.w;
                if (view == null || !view.isShown()) {
                    t.this.dismiss();
                } else {
                    t.this.r.b();
                }
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = t.this.y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    t.this.y = view.getViewTreeObserver();
                }
                t tVar = t.this;
                tVar.y.removeGlobalOnLayoutListener(tVar.s);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public t(Context context, h hVar, View view, int i, int i2, boolean z2) {
        this.k = context;
        this.l = hVar;
        this.n = z2;
        this.m = new g(hVar, LayoutInflater.from(context), z2, E);
        this.p = i;
        this.q = i2;
        Resources resources = context.getResources();
        this.o = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.v = view;
        this.r = new j0(context, (AttributeSet) null, i, i2);
        hVar.c(this, context);
    }

    private boolean z() {
        View view;
        if (f()) {
            return true;
        }
        if (this.z || (view = this.v) == null) {
            return false;
        }
        this.w = view;
        this.r.B(this);
        this.r.C(this);
        this.r.A(true);
        View view2 = this.w;
        boolean z2 = this.y == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.y = viewTreeObserver;
        if (z2) {
            viewTreeObserver.addOnGlobalLayoutListener(this.s);
        }
        view2.addOnAttachStateChangeListener(this.t);
        this.r.s(view2);
        this.r.w(this.C);
        if (!this.A) {
            this.B = m.o(this.m, (ViewGroup) null, this.k, this.o);
            this.A = true;
        }
        this.r.v(this.B);
        this.r.z(2);
        this.r.x(n());
        this.r.b();
        ListView g = this.r.g();
        g.setOnKeyListener(this);
        if (this.D && this.l.x() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.k).inflate(g.abc_popup_menu_header_item_layout, g, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.l.x());
            }
            frameLayout.setEnabled(false);
            g.addHeaderView(frameLayout, (Object) null, false);
        }
        this.r.r(this.m);
        this.r.b();
        return true;
    }

    public void a(h hVar, boolean z2) {
        if (hVar == this.l) {
            dismiss();
            o.a aVar = this.x;
            if (aVar != null) {
                aVar.a(hVar, z2);
            }
        }
    }

    public void b() {
        if (!z()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public boolean c() {
        return false;
    }

    public void dismiss() {
        if (f()) {
            this.r.dismiss();
        }
    }

    public boolean f() {
        return !this.z && this.r.f();
    }

    public ListView g() {
        return this.r.g();
    }

    public void i(o.a aVar) {
        this.x = aVar;
    }

    public boolean j(u uVar) {
        if (uVar.hasVisibleItems()) {
            n nVar = new n(this.k, uVar, this.w, this.n, this.p, this.q);
            nVar.j(this.x);
            nVar.g(m.x(uVar));
            nVar.i(this.u);
            this.u = null;
            this.l.e(false);
            int k2 = this.r.k();
            int m2 = this.r.m();
            if ((Gravity.getAbsoluteGravity(this.C, p.k(this.v)) & 7) == 5) {
                k2 += this.v.getWidth();
            }
            if (nVar.n(k2, m2)) {
                o.a aVar = this.x;
                if (aVar == null) {
                    return true;
                }
                aVar.b(uVar);
                return true;
            }
        }
        return false;
    }

    public void k(boolean z2) {
        this.A = false;
        g gVar = this.m;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    public void l(h hVar) {
    }

    public void onDismiss() {
        this.z = true;
        this.l.close();
        ViewTreeObserver viewTreeObserver = this.y;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.y = this.w.getViewTreeObserver();
            }
            this.y.removeGlobalOnLayoutListener(this.s);
            this.y = null;
        }
        this.w.removeOnAttachStateChangeListener(this.t);
        PopupWindow.OnDismissListener onDismissListener = this.u;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void p(View view) {
        this.v = view;
    }

    public void r(boolean z2) {
        this.m.d(z2);
    }

    public void s(int i) {
        this.C = i;
    }

    public void t(int i) {
        this.r.y(i);
    }

    public void u(PopupWindow.OnDismissListener onDismissListener) {
        this.u = onDismissListener;
    }

    public void v(boolean z2) {
        this.D = z2;
    }

    public void w(int i) {
        this.r.H(i);
    }
}
