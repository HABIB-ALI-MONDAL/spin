package com.soundcloud.android.crop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;

class c {

    /* renamed from: a  reason: collision with root package name */
    RectF f3058a;

    /* renamed from: b  reason: collision with root package name */
    Rect f3059b;

    /* renamed from: c  reason: collision with root package name */
    Matrix f3060c;

    /* renamed from: d  reason: collision with root package name */
    private RectF f3061d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f3062e = new Paint();

    /* renamed from: f  reason: collision with root package name */
    private final Paint f3063f = new Paint();
    private final Paint g = new Paint();
    private View h;
    private boolean i;
    private boolean j;
    private int k;
    private b l = b.None;
    private a m = a.Changing;
    private boolean n;
    private float o;
    private float p;
    private float q;
    private boolean r;

    enum a {
        Changing,
        Always,
        Never
    }

    enum b {
        None,
        Move,
        Grow
    }

    public c(View view) {
        this.h = view;
        m(view.getContext());
    }

    private Rect a() {
        RectF rectF = this.f3058a;
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        this.f3060c.mapRect(rectF2);
        return new Rect(Math.round(rectF2.left), Math.round(rectF2.top), Math.round(rectF2.right), Math.round(rectF2.bottom));
    }

    private float b(float f2) {
        return f2 * this.h.getResources().getDisplayMetrics().density;
    }

    private void d(Canvas canvas) {
        this.f3063f.setStrokeWidth(1.0f);
        canvas.drawOval(new RectF(this.f3059b), this.f3063f);
    }

    private void e(Canvas canvas) {
        Rect rect = this.f3059b;
        int i2 = rect.left;
        int i3 = ((rect.right - i2) / 2) + i2;
        int i4 = rect.top;
        int i5 = i4 + ((rect.bottom - i4) / 2);
        float f2 = (float) i2;
        float f3 = (float) i5;
        canvas.drawCircle(f2, f3, this.p, this.g);
        float f4 = (float) i3;
        canvas.drawCircle(f4, (float) this.f3059b.top, this.p, this.g);
        canvas.drawCircle((float) this.f3059b.right, f3, this.p, this.g);
        canvas.drawCircle(f4, (float) this.f3059b.bottom, this.p, this.g);
    }

    private void f(Canvas canvas) {
        Canvas canvas2 = canvas;
        canvas2.drawRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) this.f3059b.top, this.f3062e);
        canvas2.drawRect(0.0f, (float) this.f3059b.bottom, (float) canvas.getWidth(), (float) canvas.getHeight(), this.f3062e);
        Rect rect = this.f3059b;
        Canvas canvas3 = canvas;
        canvas3.drawRect(0.0f, (float) rect.top, (float) rect.left, (float) rect.bottom, this.f3062e);
        Rect rect2 = this.f3059b;
        canvas3.drawRect((float) rect2.right, (float) rect2.top, (float) canvas.getWidth(), (float) this.f3059b.bottom, this.f3062e);
    }

    private void g(Canvas canvas) {
        this.f3063f.setStrokeWidth(1.0f);
        Rect rect = this.f3059b;
        int i2 = rect.right;
        int i3 = rect.left;
        float f2 = (float) ((i2 - i3) / 3);
        int i4 = rect.bottom;
        int i5 = rect.top;
        float f3 = (float) ((i4 - i5) / 3);
        Canvas canvas2 = canvas;
        canvas2.drawLine(((float) i3) + f2, (float) i5, ((float) i3) + f2, (float) i4, this.f3063f);
        Rect rect2 = this.f3059b;
        int i6 = rect2.left;
        float f4 = f2 * 2.0f;
        canvas2.drawLine(((float) i6) + f4, (float) rect2.top, ((float) i6) + f4, (float) rect2.bottom, this.f3063f);
        Rect rect3 = this.f3059b;
        float f5 = (float) rect3.left;
        int i7 = rect3.top;
        canvas2.drawLine(f5, ((float) i7) + f3, (float) rect3.right, ((float) i7) + f3, this.f3063f);
        Rect rect4 = this.f3059b;
        float f6 = (float) rect4.left;
        int i8 = rect4.top;
        float f7 = f3 * 2.0f;
        canvas2.drawLine(f6, ((float) i8) + f7, (float) rect4.right, ((float) i8) + f7, this.f3063f);
    }

    private void m(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(g.cropImageStyle, typedValue, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(typedValue.resourceId, k.f3064a);
        try {
            this.i = obtainStyledAttributes.getBoolean(k.f3068e, false);
            this.j = obtainStyledAttributes.getBoolean(k.f3066c, false);
            this.k = obtainStyledAttributes.getColor(k.f3065b, -13388315);
            this.m = a.values()[obtainStyledAttributes.getInt(k.f3067d, 0)];
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @SuppressLint({"NewApi"})
    private boolean o(Canvas canvas) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 17) {
            return false;
        }
        if (i2 < 14 || i2 > 15) {
            return true;
        }
        return !canvas.isHardwareAccelerated();
    }

    /* access modifiers changed from: protected */
    public void c(Canvas canvas) {
        canvas.save();
        Path path = new Path();
        this.f3063f.setStrokeWidth(this.q);
        if (!l()) {
            this.f3063f.setColor(-16777216);
            canvas.drawRect(this.f3059b, this.f3063f);
            return;
        }
        Rect rect = new Rect();
        this.h.getDrawingRect(rect);
        path.addRect(new RectF(this.f3059b), Path.Direction.CW);
        this.f3063f.setColor(this.k);
        if (o(canvas)) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawRect(rect, this.f3062e);
        } else {
            f(canvas);
        }
        canvas.restore();
        canvas.drawPath(path, this.f3063f);
        if (this.i) {
            g(canvas);
        }
        if (this.j) {
            d(canvas);
        }
        a aVar = this.m;
        if (aVar == a.Always || (aVar == a.Changing && this.l == b.Grow)) {
            e(canvas);
        }
    }

    public int h(float f2, float f3) {
        Rect a2 = a();
        boolean z = false;
        boolean z2 = f3 >= ((float) a2.top) - 20.0f && f3 < ((float) a2.bottom) + 20.0f;
        int i2 = a2.left;
        if (f2 >= ((float) i2) - 20.0f && f2 < ((float) a2.right) + 20.0f) {
            z = true;
        }
        int i3 = (Math.abs(((float) i2) - f2) >= 20.0f || !z2) ? 1 : 3;
        if (Math.abs(((float) a2.right) - f2) < 20.0f && z2) {
            i3 |= 4;
        }
        if (Math.abs(((float) a2.top) - f3) < 20.0f && z) {
            i3 |= 8;
        }
        if (Math.abs(((float) a2.bottom) - f3) < 20.0f && z) {
            i3 |= 16;
        }
        if (i3 != 1 || !a2.contains((int) f2, (int) f3)) {
            return i3;
        }
        return 32;
    }

    public Rect i(float f2) {
        RectF rectF = this.f3058a;
        return new Rect((int) (rectF.left * f2), (int) (rectF.top * f2), (int) (rectF.right * f2), (int) (rectF.bottom * f2));
    }

    /* access modifiers changed from: package-private */
    public void j(float f2, float f3) {
        if (this.n) {
            if (f2 != 0.0f) {
                f3 = f2 / this.o;
            } else if (f3 != 0.0f) {
                f2 = this.o * f3;
            }
        }
        RectF rectF = new RectF(this.f3058a);
        if (f2 > 0.0f && rectF.width() + (f2 * 2.0f) > this.f3061d.width()) {
            f2 = (this.f3061d.width() - rectF.width()) / 2.0f;
            if (this.n) {
                f3 = f2 / this.o;
            }
        }
        if (f3 > 0.0f && rectF.height() + (f3 * 2.0f) > this.f3061d.height()) {
            f3 = (this.f3061d.height() - rectF.height()) / 2.0f;
            if (this.n) {
                f2 = this.o * f3;
            }
        }
        rectF.inset(-f2, -f3);
        float f4 = 25.0f;
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        if (this.n) {
            f4 = 25.0f / this.o;
        }
        if (rectF.height() < f4) {
            rectF.inset(0.0f, (-(f4 - rectF.height())) / 2.0f);
        }
        float f5 = rectF.left;
        RectF rectF2 = this.f3061d;
        float f6 = rectF2.left;
        if (f5 < f6) {
            rectF.offset(f6 - f5, 0.0f);
        } else {
            float f7 = rectF.right;
            float f8 = rectF2.right;
            if (f7 > f8) {
                rectF.offset(-(f7 - f8), 0.0f);
            }
        }
        float f9 = rectF.top;
        RectF rectF3 = this.f3061d;
        float f10 = rectF3.top;
        if (f9 < f10) {
            rectF.offset(0.0f, f10 - f9);
        } else {
            float f11 = rectF.bottom;
            float f12 = rectF3.bottom;
            if (f11 > f12) {
                rectF.offset(0.0f, -(f11 - f12));
            }
        }
        this.f3058a.set(rectF);
        this.f3059b = a();
        this.h.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void k(int i2, float f2, float f3) {
        Rect a2 = a();
        if (i2 == 32) {
            p(f2 * (this.f3058a.width() / ((float) a2.width())), f3 * (this.f3058a.height() / ((float) a2.height())));
            return;
        }
        if ((i2 & 6) == 0) {
            f2 = 0.0f;
        }
        if ((i2 & 24) == 0) {
            f3 = 0.0f;
        }
        float width = f2 * (this.f3058a.width() / ((float) a2.width()));
        float height = f3 * (this.f3058a.height() / ((float) a2.height()));
        int i3 = -1;
        float f4 = ((float) ((i2 & 2) != 0 ? -1 : 1)) * width;
        if ((i2 & 8) == 0) {
            i3 = 1;
        }
        j(f4, ((float) i3) * height);
    }

    public boolean l() {
        return this.r;
    }

    public void n() {
        this.f3059b = a();
    }

    /* access modifiers changed from: package-private */
    public void p(float f2, float f3) {
        Rect rect = new Rect(this.f3059b);
        this.f3058a.offset(f2, f3);
        RectF rectF = this.f3058a;
        rectF.offset(Math.max(0.0f, this.f3061d.left - rectF.left), Math.max(0.0f, this.f3061d.top - this.f3058a.top));
        RectF rectF2 = this.f3058a;
        rectF2.offset(Math.min(0.0f, this.f3061d.right - rectF2.right), Math.min(0.0f, this.f3061d.bottom - this.f3058a.bottom));
        Rect a2 = a();
        this.f3059b = a2;
        rect.union(a2);
        float f4 = this.p;
        rect.inset(-((int) f4), -((int) f4));
        this.h.invalidate(rect);
    }

    public void q(boolean z) {
        this.r = z;
    }

    public void r(b bVar) {
        if (bVar != this.l) {
            this.l = bVar;
            this.h.invalidate();
        }
    }

    public void s(Matrix matrix, Rect rect, RectF rectF, boolean z) {
        this.f3060c = new Matrix(matrix);
        this.f3058a = rectF;
        this.f3061d = new RectF(rect);
        this.n = z;
        this.o = this.f3058a.width() / this.f3058a.height();
        this.f3059b = a();
        this.f3062e.setARGB(125, 50, 50, 50);
        this.f3063f.setStyle(Paint.Style.STROKE);
        this.f3063f.setAntiAlias(true);
        this.q = b(2.0f);
        this.g.setColor(this.k);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setAntiAlias(true);
        this.p = b(12.0f);
        this.l = b.None;
    }
}
