package com.soundcloud.android.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;

abstract class d extends ImageView {
    protected Matrix j = new Matrix();
    protected Matrix k = new Matrix();
    private final Matrix l = new Matrix();
    private final float[] m = new float[9];
    protected final l n = new l((Bitmap) null, 0);
    int o = -1;
    int p = -1;
    float q;
    private Runnable r;
    protected Handler s = new Handler();
    private c t;

    class a implements Runnable {
        final /* synthetic */ l j;
        final /* synthetic */ boolean k;

        a(l lVar, boolean z) {
            this.j = lVar;
            this.k = z;
        }

        public void run() {
            d.this.n(this.j, this.k);
        }
    }

    class b implements Runnable {
        final /* synthetic */ float j;
        final /* synthetic */ long k;
        final /* synthetic */ float l;
        final /* synthetic */ float m;
        final /* synthetic */ float n;
        final /* synthetic */ float o;

        b(float f2, long j2, float f3, float f4, float f5, float f6) {
            this.j = f2;
            this.k = j2;
            this.l = f3;
            this.m = f4;
            this.n = f5;
            this.o = f6;
        }

        public void run() {
            float min = Math.min(this.j, (float) (System.currentTimeMillis() - this.k));
            d.this.p(this.l + (this.m * min), this.n, this.o);
            if (min < this.j) {
                d.this.s.post(this);
            }
        }
    }

    public interface c {
        void a(Bitmap bitmap);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i();
    }

    private float c(RectF rectF, float f2, float f3) {
        float f4;
        float width = (float) getWidth();
        if (f2 < width) {
            width = (width - f2) / 2.0f;
            f4 = rectF.left;
        } else {
            float f5 = rectF.left;
            if (f5 > 0.0f) {
                return -f5;
            }
            f4 = rectF.right;
            if (f4 >= width) {
                return f3;
            }
        }
        return width - f4;
    }

    private float d(RectF rectF, float f2, float f3) {
        float height = (float) getHeight();
        if (f2 < height) {
            return ((height - f2) / 2.0f) - rectF.top;
        }
        float f4 = rectF.top;
        return f4 > 0.0f ? -f4 : rectF.bottom < height ? ((float) getHeight()) - rectF.bottom : f3;
    }

    private void f(l lVar, Matrix matrix, boolean z) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        float e2 = (float) lVar.e();
        float b2 = (float) lVar.b();
        matrix.reset();
        float min = Math.min(Math.min(width / e2, 3.0f), Math.min(height / b2, 3.0f));
        if (z) {
            matrix.postConcat(lVar.c());
        }
        matrix.postScale(min, min);
        matrix.postTranslate((width - (e2 * min)) / 2.0f, (height - (b2 * min)) / 2.0f);
    }

    private void i() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void l(Bitmap bitmap, int i) {
        c cVar;
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap a2 = this.n.a();
        this.n.h(bitmap);
        this.n.i(i);
        if (a2 != null && a2 != bitmap && (cVar = this.t) != null) {
            cVar.a(a2);
        }
    }

    /* access modifiers changed from: protected */
    public float a() {
        if (this.n.a() == null) {
            return 1.0f;
        }
        return Math.max(((float) this.n.e()) / ((float) this.o), ((float) this.n.b()) / ((float) this.p)) * 4.0f;
    }

    /* access modifiers changed from: protected */
    public void b() {
        Bitmap a2 = this.n.a();
        if (a2 != null) {
            Matrix imageViewMatrix = getImageViewMatrix();
            RectF rectF = new RectF(0.0f, 0.0f, (float) a2.getWidth(), (float) a2.getHeight());
            imageViewMatrix.mapRect(rectF);
            float height = rectF.height();
            float width = rectF.width();
            k(c(rectF, width, 0.0f), d(rectF, height, 0.0f));
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void e() {
        m((Bitmap) null, true);
    }

    /* access modifiers changed from: protected */
    public float g(Matrix matrix) {
        return h(matrix, 0);
    }

    /* access modifiers changed from: protected */
    public Matrix getImageViewMatrix() {
        this.l.set(this.j);
        this.l.postConcat(this.k);
        return this.l;
    }

    /* access modifiers changed from: protected */
    public float getScale() {
        return g(this.k);
    }

    public Matrix getUnrotatedMatrix() {
        Matrix matrix = new Matrix();
        f(this.n, matrix, false);
        matrix.postConcat(this.k);
        return matrix;
    }

    /* access modifiers changed from: protected */
    public float h(Matrix matrix, int i) {
        matrix.getValues(this.m);
        return this.m[i];
    }

    /* access modifiers changed from: protected */
    public void j(float f2, float f3) {
        k(f2, f3);
        setImageMatrix(getImageViewMatrix());
    }

    /* access modifiers changed from: protected */
    public void k(float f2, float f3) {
        this.k.postTranslate(f2, f3);
    }

    public void m(Bitmap bitmap, boolean z) {
        n(new l(bitmap, 0), z);
    }

    public void n(l lVar, boolean z) {
        if (getWidth() <= 0) {
            this.r = new a(lVar, z);
            return;
        }
        if (lVar.a() != null) {
            f(lVar, this.j, true);
            l(lVar.a(), lVar.d());
        } else {
            this.j.reset();
            setImageBitmap((Bitmap) null);
        }
        if (z) {
            this.k.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.q = a();
    }

    /* access modifiers changed from: protected */
    public void o(float f2) {
        p(f2, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || !keyEvent.isTracking() || keyEvent.isCanceled() || getScale() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        o(1.0f);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.o = i3 - i;
        this.p = i4 - i2;
        Runnable runnable = this.r;
        if (runnable != null) {
            this.r = null;
            runnable.run();
        }
        if (this.n.a() != null) {
            f(this.n, this.j, true);
            setImageMatrix(getImageViewMatrix());
        }
    }

    /* access modifiers changed from: protected */
    public void p(float f2, float f3, float f4) {
        float f5 = this.q;
        if (f2 > f5) {
            f2 = f5;
        }
        float scale = f2 / getScale();
        this.k.postScale(scale, scale, f3, f4);
        setImageMatrix(getImageViewMatrix());
        b();
    }

    /* access modifiers changed from: protected */
    public void q(float f2, float f3, float f4, float f5) {
        float scale = (f2 - getScale()) / f5;
        float scale2 = getScale();
        this.s.post(new b(f5, System.currentTimeMillis(), scale2, scale, f3, f4));
    }

    public void setImageBitmap(Bitmap bitmap) {
        l(bitmap, 0);
    }

    public void setRecycler(c cVar) {
        this.t = cVar;
    }
}
