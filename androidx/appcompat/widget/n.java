package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.e;
import b.a.j;
import b.a.k.a.a;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f227a;

    /* renamed from: b  reason: collision with root package name */
    private r0 f228b;

    /* renamed from: c  reason: collision with root package name */
    private r0 f229c;

    /* renamed from: d  reason: collision with root package name */
    private r0 f230d;

    public n(ImageView imageView) {
        this.f227a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f230d == null) {
            this.f230d = new r0();
        }
        r0 r0Var = this.f230d;
        r0Var.a();
        ColorStateList a2 = e.a(this.f227a);
        if (a2 != null) {
            r0Var.f254d = true;
            r0Var.f251a = a2;
        }
        PorterDuff.Mode b2 = e.b(this.f227a);
        if (b2 != null) {
            r0Var.f253c = true;
            r0Var.f252b = b2;
        }
        if (!r0Var.f254d && !r0Var.f253c) {
            return false;
        }
        j.C(drawable, r0Var, this.f227a.getDrawableState());
        return true;
    }

    private boolean j() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f228b != null : i == 21;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.f227a.getDrawable();
        if (drawable != null) {
            c0.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!j() || !a(drawable)) {
            r0 r0Var = this.f229c;
            if (r0Var != null) {
                j.C(drawable, r0Var, this.f227a.getDrawableState());
                return;
            }
            r0 r0Var2 = this.f228b;
            if (r0Var2 != null) {
                j.C(drawable, r0Var2, this.f227a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        r0 r0Var = this.f229c;
        if (r0Var != null) {
            return r0Var.f251a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        r0 r0Var = this.f229c;
        if (r0Var != null) {
            return r0Var.f252b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return Build.VERSION.SDK_INT < 21 || !(this.f227a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i) {
        int m;
        t0 t = t0.t(this.f227a.getContext(), attributeSet, j.b0, i, 0);
        try {
            Drawable drawable = this.f227a.getDrawable();
            if (!(drawable != null || (m = t.m(j.c0, -1)) == -1 || (drawable = a.d(this.f227a.getContext(), m)) == null)) {
                this.f227a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                c0.b(drawable);
            }
            int i2 = j.d0;
            if (t.q(i2)) {
                e.c(this.f227a, t.c(i2));
            }
            int i3 = j.e0;
            if (t.q(i3)) {
                e.d(this.f227a, c0.d(t.j(i3, -1), (PorterDuff.Mode) null));
            }
        } finally {
            t.u();
        }
    }

    public void g(int i) {
        if (i != 0) {
            Drawable d2 = a.d(this.f227a.getContext(), i);
            if (d2 != null) {
                c0.b(d2);
            }
            this.f227a.setImageDrawable(d2);
        } else {
            this.f227a.setImageDrawable((Drawable) null);
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (this.f229c == null) {
            this.f229c = new r0();
        }
        r0 r0Var = this.f229c;
        r0Var.f251a = colorStateList;
        r0Var.f254d = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public void i(PorterDuff.Mode mode) {
        if (this.f229c == null) {
            this.f229c = new r0();
        }
        r0 r0Var = this.f229c;
        r0Var.f252b = mode;
        r0Var.f253c = true;
        b();
    }
}
