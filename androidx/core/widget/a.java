package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import b.d.k.p;

public abstract class a implements View.OnTouchListener {
    private static final int A = ViewConfiguration.getTapTimeout();
    final C0015a j = new C0015a();
    private final Interpolator k = new AccelerateInterpolator();
    final View l;
    private Runnable m;
    private float[] n = {0.0f, 0.0f};
    private float[] o = {Float.MAX_VALUE, Float.MAX_VALUE};
    private int p;
    private int q;
    private float[] r = {0.0f, 0.0f};
    private float[] s = {0.0f, 0.0f};
    private float[] t = {Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean u;
    boolean v;
    boolean w;
    boolean x;
    private boolean y;
    private boolean z;

    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    private static class C0015a {

        /* renamed from: a  reason: collision with root package name */
        private int f364a;

        /* renamed from: b  reason: collision with root package name */
        private int f365b;

        /* renamed from: c  reason: collision with root package name */
        private float f366c;

        /* renamed from: d  reason: collision with root package name */
        private float f367d;

        /* renamed from: e  reason: collision with root package name */
        private long f368e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        private long f369f = 0;
        private int g = 0;
        private int h = 0;
        private long i = -1;
        private float j;
        private int k;

        C0015a() {
        }

        private float e(long j2) {
            long j3 = this.f368e;
            if (j2 < j3) {
                return 0.0f;
            }
            long j4 = this.i;
            if (j4 < 0 || j2 < j4) {
                return a.e(((float) (j2 - j3)) / ((float) this.f364a), 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.j;
            return (1.0f - f2) + (f2 * a.e(((float) (j2 - j4)) / ((float) this.k), 0.0f, 1.0f));
        }

        private float g(float f2) {
            return (-4.0f * f2 * f2) + (f2 * 4.0f);
        }

        public void a() {
            if (this.f369f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g2 = g(e(currentAnimationTimeMillis));
                this.f369f = currentAnimationTimeMillis;
                float f2 = ((float) (currentAnimationTimeMillis - this.f369f)) * g2;
                this.g = (int) (this.f366c * f2);
                this.h = (int) (f2 * this.f367d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.g;
        }

        public int c() {
            return this.h;
        }

        public int d() {
            float f2 = this.f366c;
            return (int) (f2 / Math.abs(f2));
        }

        public int f() {
            float f2 = this.f367d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean h() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.f((int) (currentAnimationTimeMillis - this.f368e), 0, this.f365b);
            this.j = e(currentAnimationTimeMillis);
            this.i = currentAnimationTimeMillis;
        }

        public void j(int i2) {
            this.f365b = i2;
        }

        public void k(int i2) {
            this.f364a = i2;
        }

        public void l(float f2, float f3) {
            this.f366c = f2;
            this.f367d = f3;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f368e = currentAnimationTimeMillis;
            this.i = -1;
            this.f369f = currentAnimationTimeMillis;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            a aVar = a.this;
            if (aVar.x) {
                if (aVar.v) {
                    aVar.v = false;
                    aVar.j.m();
                }
                C0015a aVar2 = a.this.j;
                if (aVar2.h() || !a.this.u()) {
                    a.this.x = false;
                    return;
                }
                a aVar3 = a.this;
                if (aVar3.w) {
                    aVar3.w = false;
                    aVar3.c();
                }
                aVar2.a();
                a.this.j(aVar2.b(), aVar2.c());
                p.y(a.this.l, this);
            }
        }
    }

    public a(View view) {
        this.l = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (float) ((int) ((1575.0f * f2) + 0.5f));
        o(f3, f3);
        float f4 = (float) ((int) ((f2 * 315.0f) + 0.5f));
        p(f4, f4);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(A);
        r(500);
        q(500);
    }

    private float d(int i, float f2, float f3, float f4) {
        float h = h(this.n[i], f3, this.o[i], f2);
        if (h == 0.0f) {
            return 0.0f;
        }
        float f5 = this.r[i];
        float f6 = this.s[i];
        float f7 = this.t[i];
        float f8 = f5 * f4;
        return h > 0.0f ? e(h * f8, f6, f7) : -e((-h) * f8, f6, f7);
    }

    static float e(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int f(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private float g(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i = this.p;
        if (i == 0 || i == 1) {
            if (f2 < f3) {
                return f2 >= 0.0f ? 1.0f - (f2 / f3) : (!this.x || i != 1) ? 0.0f : 1.0f;
            }
        } else if (i == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
    }

    private float h(float f2, float f3, float f4, float f5) {
        float f6;
        float e2 = e(f2 * f3, 0.0f, f4);
        float g = g(f3 - f5, e2) - g(f5, e2);
        if (g < 0.0f) {
            f6 = -this.k.getInterpolation(-g);
        } else if (g <= 0.0f) {
            return 0.0f;
        } else {
            f6 = this.k.getInterpolation(g);
        }
        return e(f6, -1.0f, 1.0f);
    }

    private void i() {
        if (this.v) {
            this.x = false;
        } else {
            this.j.i();
        }
    }

    private void v() {
        int i;
        if (this.m == null) {
            this.m = new b();
        }
        this.x = true;
        this.v = true;
        if (this.u || (i = this.q) <= 0) {
            this.m.run();
        } else {
            p.z(this.l, this.m, (long) i);
        }
        this.u = true;
    }

    public abstract boolean a(int i);

    public abstract boolean b(int i);

    /* access modifiers changed from: package-private */
    public void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.l.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i, int i2);

    public a k(int i) {
        this.q = i;
        return this;
    }

    public a l(int i) {
        this.p = i;
        return this;
    }

    public a m(boolean z2) {
        if (this.y && !z2) {
            i();
        }
        this.y = z2;
        return this;
    }

    public a n(float f2, float f3) {
        float[] fArr = this.o;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a o(float f2, float f3) {
        float[] fArr = this.t;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.y
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.i()
            goto L_0x0058
        L_0x001a:
            r5.w = r2
            r5.u = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.l
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.l
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.j
            r7.l(r0, r6)
            boolean r6 = r5.x
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.u()
            if (r6 == 0) goto L_0x0058
            r5.v()
        L_0x0058:
            boolean r6 = r5.z
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.x
            if (r6 == 0) goto L_0x0061
            r1 = 1
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f2, float f3) {
        float[] fArr = this.s;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a q(int i) {
        this.j.j(i);
        return this;
    }

    public a r(int i) {
        this.j.k(i);
        return this;
    }

    public a s(float f2, float f3) {
        float[] fArr = this.n;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a t(float f2, float f3) {
        float[] fArr = this.r;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        C0015a aVar = this.j;
        int f2 = aVar.f();
        int d2 = aVar.d();
        return (f2 != 0 && b(f2)) || (d2 != 0 && a(d2));
    }
}
