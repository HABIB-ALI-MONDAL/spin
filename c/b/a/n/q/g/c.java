package c.b.a.n.q.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import b.a.j;
import c.b.a.n.m;
import c.b.a.n.q.g.g;
import c.b.a.t.h;
import java.nio.ByteBuffer;

public class c extends Drawable implements g.b, Animatable {
    private final a j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private boolean q;
    private Paint r;
    private Rect s;

    static final class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        final g f1188a;

        a(g gVar) {
            this.f1188a = gVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new c(this);
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public c(Context context, c.b.a.m.a aVar, m<Bitmap> mVar, int i, int i2, Bitmap bitmap) {
        this(new a(new g(c.b.a.c.c(context), aVar, i, i2, mVar, bitmap)));
    }

    c(a aVar) {
        this.n = true;
        this.p = -1;
        h.d(aVar);
        this.j = aVar;
    }

    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.s == null) {
            this.s = new Rect();
        }
        return this.s;
    }

    private Paint h() {
        if (this.r == null) {
            this.r = new Paint(2);
        }
        return this.r;
    }

    private void k() {
        this.o = 0;
    }

    private void m() {
        h.a(!this.m, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.j.f1188a.f() != 1) {
            if (!this.k) {
                this.k = true;
                this.j.f1188a.s(this);
            } else {
                return;
            }
        }
        invalidateSelf();
    }

    private void n() {
        this.k = false;
        this.j.f1188a.t(this);
    }

    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.o++;
        }
        int i = this.p;
        if (i != -1 && this.o >= i) {
            stop();
        }
    }

    public ByteBuffer c() {
        return this.j.f1188a.b();
    }

    public void draw(Canvas canvas) {
        if (!this.m) {
            if (this.q) {
                Gravity.apply(j.O0, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
                this.q = false;
            }
            canvas.drawBitmap(this.j.f1188a.c(), (Rect) null, d(), h());
        }
    }

    public Bitmap e() {
        return this.j.f1188a.e();
    }

    public int f() {
        return this.j.f1188a.f();
    }

    public int g() {
        return this.j.f1188a.d();
    }

    public Drawable.ConstantState getConstantState() {
        return this.j;
    }

    public int getIntrinsicHeight() {
        return this.j.f1188a.i();
    }

    public int getIntrinsicWidth() {
        return this.j.f1188a.l();
    }

    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.j.f1188a.k();
    }

    public boolean isRunning() {
        return this.k;
    }

    public void j() {
        this.m = true;
        this.j.f1188a.a();
    }

    public void l(m<Bitmap> mVar, Bitmap bitmap) {
        this.j.f1188a.p(mVar, bitmap);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.q = true;
    }

    public void setAlpha(int i) {
        h().setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        h.a(!this.m, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.n = z;
        if (!z) {
            n();
        } else if (this.l) {
            m();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.l = true;
        k();
        if (this.n) {
            m();
        }
    }

    public void stop() {
        this.l = false;
        n();
    }
}
