package c.b.a.r.i;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import c.b.a.r.j.b;

public abstract class d<Z> extends i<ImageView, Z> implements b.a {
    private Animatable h;

    public d(ImageView imageView) {
        super(imageView);
    }

    private void m(Z z) {
        if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.h = animatable;
            animatable.start();
            return;
        }
        this.h = null;
    }

    private void p(Z z) {
        o(z);
        m(z);
    }

    public void b(Drawable drawable) {
        super.b(drawable);
        p((Object) null);
        n(drawable);
    }

    public void c(Z z, b<? super Z> bVar) {
        if (bVar == null || !bVar.a(z, this)) {
            p(z);
        } else {
            m(z);
        }
    }

    public void d(Drawable drawable) {
        super.d(drawable);
        p((Object) null);
        n(drawable);
    }

    public void f(Drawable drawable) {
        super.f(drawable);
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.stop();
        }
        p((Object) null);
        n(drawable);
    }

    public void n(Drawable drawable) {
        ((ImageView) this.f1259b).setImageDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public abstract void o(Z z);

    public void onStart() {
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void onStop() {
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
