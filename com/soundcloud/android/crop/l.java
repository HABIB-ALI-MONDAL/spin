package com.soundcloud.android.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;

class l {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f3069a;

    /* renamed from: b  reason: collision with root package name */
    private int f3070b;

    public l(Bitmap bitmap, int i) {
        this.f3069a = bitmap;
        this.f3070b = i % 360;
    }

    public Bitmap a() {
        return this.f3069a;
    }

    public int b() {
        if (this.f3069a == null) {
            return 0;
        }
        return f() ? this.f3069a.getWidth() : this.f3069a.getHeight();
    }

    public Matrix c() {
        Matrix matrix = new Matrix();
        Bitmap bitmap = this.f3069a;
        if (!(bitmap == null || this.f3070b == 0)) {
            matrix.preTranslate((float) (-(bitmap.getWidth() / 2)), (float) (-(this.f3069a.getHeight() / 2)));
            matrix.postRotate((float) this.f3070b);
            matrix.postTranslate((float) (e() / 2), (float) (b() / 2));
        }
        return matrix;
    }

    public int d() {
        return this.f3070b;
    }

    public int e() {
        if (this.f3069a == null) {
            return 0;
        }
        return f() ? this.f3069a.getHeight() : this.f3069a.getWidth();
    }

    public boolean f() {
        return (this.f3070b / 90) % 2 != 0;
    }

    public void g() {
        Bitmap bitmap = this.f3069a;
        if (bitmap != null) {
            bitmap.recycle();
            this.f3069a = null;
        }
    }

    public void h(Bitmap bitmap) {
        this.f3069a = bitmap;
    }

    public void i(int i) {
        this.f3070b = i;
    }
}
