package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.graphics.drawable.a;
import b.a.j;
import b.d.k.p;

class v extends r {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f268d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f269e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f270f = null;
    private PorterDuff.Mode g = null;
    private boolean h = false;
    private boolean i = false;

    v(SeekBar seekBar) {
        super(seekBar);
        this.f268d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f269e;
        if (drawable == null) {
            return;
        }
        if (this.h || this.i) {
            Drawable p = a.p(drawable.mutate());
            this.f269e = p;
            if (this.h) {
                a.n(p, this.f270f);
            }
            if (this.i) {
                a.o(this.f269e, this.g);
            }
            if (this.f269e.isStateful()) {
                this.f269e.setState(this.f268d.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i2) {
        super.c(attributeSet, i2);
        t0 t = t0.t(this.f268d.getContext(), attributeSet, j.f0, i2, 0);
        Drawable g2 = t.g(j.g0);
        if (g2 != null) {
            this.f268d.setThumb(g2);
        }
        j(t.f(j.h0));
        int i3 = j.j0;
        if (t.q(i3)) {
            this.g = c0.d(t.j(i3, -1), this.g);
            this.i = true;
        }
        int i4 = j.i0;
        if (t.q(i4)) {
            this.f270f = t.c(i4);
            this.h = true;
        }
        t.u();
        f();
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.f269e != null) {
            int max = this.f268d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f269e.getIntrinsicWidth();
                int intrinsicHeight = this.f269e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f269e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f268d.getWidth() - this.f268d.getPaddingLeft()) - this.f268d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f268d.getPaddingLeft(), (float) (this.f268d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f269e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f269e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f268d.getDrawableState())) {
            this.f268d.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f269e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Drawable drawable) {
        Drawable drawable2 = this.f269e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f269e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f268d);
            a.l(drawable, p.k(this.f268d));
            if (drawable.isStateful()) {
                drawable.setState(this.f268d.getDrawableState());
            }
            f();
        }
        this.f268d.invalidate();
    }
}
