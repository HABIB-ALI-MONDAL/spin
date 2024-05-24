package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import b.a.j;
import b.d.k.p;

class e {

    /* renamed from: a  reason: collision with root package name */
    private final View f198a;

    /* renamed from: b  reason: collision with root package name */
    private final j f199b;

    /* renamed from: c  reason: collision with root package name */
    private int f200c = -1;

    /* renamed from: d  reason: collision with root package name */
    private r0 f201d;

    /* renamed from: e  reason: collision with root package name */
    private r0 f202e;

    /* renamed from: f  reason: collision with root package name */
    private r0 f203f;

    e(View view) {
        this.f198a = view;
        this.f199b = j.n();
    }

    private boolean a(Drawable drawable) {
        if (this.f203f == null) {
            this.f203f = new r0();
        }
        r0 r0Var = this.f203f;
        r0Var.a();
        ColorStateList i = p.i(this.f198a);
        if (i != null) {
            r0Var.f254d = true;
            r0Var.f251a = i;
        }
        PorterDuff.Mode j = p.j(this.f198a);
        if (j != null) {
            r0Var.f253c = true;
            r0Var.f252b = j;
        }
        if (!r0Var.f254d && !r0Var.f253c) {
            return false;
        }
        j.C(drawable, r0Var, this.f198a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f201d != null : i == 21;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f198a.getBackground();
        if (background == null) {
            return;
        }
        if (!k() || !a(background)) {
            r0 r0Var = this.f202e;
            if (r0Var != null) {
                j.C(background, r0Var, this.f198a.getDrawableState());
                return;
            }
            r0 r0Var2 = this.f201d;
            if (r0Var2 != null) {
                j.C(background, r0Var2, this.f198a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        r0 r0Var = this.f202e;
        if (r0Var != null) {
            return r0Var.f251a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        r0 r0Var = this.f202e;
        if (r0Var != null) {
            return r0Var.f252b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i) {
        t0 t = t0.t(this.f198a.getContext(), attributeSet, j.q3, i, 0);
        try {
            int i2 = j.r3;
            if (t.q(i2)) {
                this.f200c = t.m(i2, -1);
                ColorStateList s = this.f199b.s(this.f198a.getContext(), this.f200c);
                if (s != null) {
                    h(s);
                }
            }
            int i3 = j.s3;
            if (t.q(i3)) {
                p.E(this.f198a, t.c(i3));
            }
            int i4 = j.t3;
            if (t.q(i4)) {
                p.F(this.f198a, c0.d(t.j(i4, -1), (PorterDuff.Mode) null));
            }
        } finally {
            t.u();
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f200c = -1;
        h((ColorStateList) null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void g(int i) {
        this.f200c = i;
        j jVar = this.f199b;
        h(jVar != null ? jVar.s(this.f198a.getContext(), i) : null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f201d == null) {
                this.f201d = new r0();
            }
            r0 r0Var = this.f201d;
            r0Var.f251a = colorStateList;
            r0Var.f254d = true;
        } else {
            this.f201d = null;
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f202e == null) {
            this.f202e = new r0();
        }
        r0 r0Var = this.f202e;
        r0Var.f251a = colorStateList;
        r0Var.f254d = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f202e == null) {
            this.f202e = new r0();
        }
        r0 r0Var = this.f202e;
        r0Var.f252b = mode;
        r0Var.f253c = true;
        b();
    }
}
