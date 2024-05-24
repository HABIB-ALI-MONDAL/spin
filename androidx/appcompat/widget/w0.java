package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import b.d.k.p;
import b.d.k.q;

class w0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static w0 s;
    private static w0 t;
    private final View j;
    private final CharSequence k;
    private final int l;
    private final Runnable m = new a();
    private final Runnable n = new b();
    private int o;
    private int p;
    private x0 q;
    private boolean r;

    class a implements Runnable {
        a() {
        }

        public void run() {
            w0.this.g(false);
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            w0.this.c();
        }
    }

    private w0(View view, CharSequence charSequence) {
        this.j = view;
        this.k = charSequence;
        this.l = q.a(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.j.removeCallbacks(this.m);
    }

    private void b() {
        this.o = Integer.MAX_VALUE;
        this.p = Integer.MAX_VALUE;
    }

    private void d() {
        this.j.postDelayed(this.m, (long) ViewConfiguration.getLongPressTimeout());
    }

    private static void e(w0 w0Var) {
        w0 w0Var2 = s;
        if (w0Var2 != null) {
            w0Var2.a();
        }
        s = w0Var;
        if (w0Var != null) {
            w0Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        w0 w0Var = s;
        if (w0Var != null && w0Var.j == view) {
            e((w0) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            w0 w0Var2 = t;
            if (w0Var2 != null && w0Var2.j == view) {
                w0Var2.c();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new w0(view, charSequence);
    }

    private boolean h(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.o) <= this.l && Math.abs(y - this.p) <= this.l) {
            return false;
        }
        this.o = x;
        this.p = y;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (t == this) {
            t = null;
            x0 x0Var = this.q;
            if (x0Var != null) {
                x0Var.c();
                this.q = null;
                b();
                this.j.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (s == this) {
            e((w0) null);
        }
        this.j.removeCallbacks(this.n);
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z) {
        long j2;
        if (p.r(this.j)) {
            e((w0) null);
            w0 w0Var = t;
            if (w0Var != null) {
                w0Var.c();
            }
            t = this;
            this.r = z;
            x0 x0Var = new x0(this.j.getContext());
            this.q = x0Var;
            x0Var.e(this.j, this.o, this.p, this.r, this.k);
            this.j.addOnAttachStateChangeListener(this);
            if (this.r) {
                j2 = 2500;
            } else {
                j2 = ((p.n(this.j) & 1) == 1 ? 3000 : 15000) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.j.removeCallbacks(this.n);
            this.j.postDelayed(this.n, j2);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.q != null && this.r) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.j.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.j.isEnabled() && this.q == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.o = view.getWidth() / 2;
        this.p = view.getHeight() / 2;
        g(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
