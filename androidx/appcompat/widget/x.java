package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.content.c.f;
import androidx.core.widget.b;
import b.a.j;
import java.lang.ref.WeakReference;

class x {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f271a;

    /* renamed from: b  reason: collision with root package name */
    private r0 f272b;

    /* renamed from: c  reason: collision with root package name */
    private r0 f273c;

    /* renamed from: d  reason: collision with root package name */
    private r0 f274d;

    /* renamed from: e  reason: collision with root package name */
    private r0 f275e;

    /* renamed from: f  reason: collision with root package name */
    private r0 f276f;
    private r0 g;
    private final z h;
    private int i = 0;
    private Typeface j;
    private boolean k;

    class a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WeakReference f277a;

        a(WeakReference weakReference) {
            this.f277a = weakReference;
        }

        public void c(int i) {
        }

        public void d(Typeface typeface) {
            x.this.l(this.f277a, typeface);
        }
    }

    x(TextView textView) {
        this.f271a = textView;
        this.h = new z(textView);
    }

    private void a(Drawable drawable, r0 r0Var) {
        if (drawable != null && r0Var != null) {
            j.C(drawable, r0Var, this.f271a.getDrawableState());
        }
    }

    private static r0 d(Context context, j jVar, int i2) {
        ColorStateList s = jVar.s(context, i2);
        if (s == null) {
            return null;
        }
        r0 r0Var = new r0();
        r0Var.f254d = true;
        r0Var.f251a = s;
        return r0Var;
    }

    private void t(int i2, float f2) {
        this.h.t(i2, f2);
    }

    private void u(Context context, t0 t0Var) {
        String n;
        Typeface typeface;
        this.i = t0Var.j(j.D2, this.i);
        int i2 = j.H2;
        boolean z = false;
        if (t0Var.q(i2) || t0Var.q(j.I2)) {
            this.j = null;
            int i3 = j.I2;
            if (t0Var.q(i3)) {
                i2 = i3;
            }
            if (!context.isRestricted()) {
                try {
                    Typeface i4 = t0Var.i(i2, this.i, new a(new WeakReference(this.f271a)));
                    this.j = i4;
                    if (i4 == null) {
                        z = true;
                    }
                    this.k = z;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.j == null && (n = t0Var.n(i2)) != null) {
                this.j = Typeface.create(n, this.i);
                return;
            }
            return;
        }
        int i5 = j.C2;
        if (t0Var.q(i5)) {
            this.k = false;
            int j2 = t0Var.j(i5, 1);
            if (j2 == 1) {
                typeface = Typeface.SANS_SERIF;
            } else if (j2 == 2) {
                typeface = Typeface.SERIF;
            } else if (j2 == 3) {
                typeface = Typeface.MONOSPACE;
            } else {
                return;
            }
            this.j = typeface;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!(this.f272b == null && this.f273c == null && this.f274d == null && this.f275e == null)) {
            Drawable[] compoundDrawables = this.f271a.getCompoundDrawables();
            a(compoundDrawables[0], this.f272b);
            a(compoundDrawables[1], this.f273c);
            a(compoundDrawables[2], this.f274d);
            a(compoundDrawables[3], this.f275e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f276f != null || this.g != null) {
            Drawable[] compoundDrawablesRelative = this.f271a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f276f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.h.a();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.h.g();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.h.h();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.h.i();
    }

    /* access modifiers changed from: package-private */
    public int[] h() {
        return this.h.j();
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.h.k();
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.h.n();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e9  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(android.util.AttributeSet r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            android.widget.TextView r3 = r0.f271a
            android.content.Context r3 = r3.getContext()
            androidx.appcompat.widget.j r4 = androidx.appcompat.widget.j.n()
            int[] r5 = b.a.j.k0
            r6 = 0
            androidx.appcompat.widget.t0 r5 = androidx.appcompat.widget.t0.t(r3, r1, r5, r2, r6)
            int r7 = b.a.j.l0
            r8 = -1
            int r7 = r5.m(r7, r8)
            int r9 = b.a.j.o0
            boolean r10 = r5.q(r9)
            if (r10 == 0) goto L_0x0030
            int r9 = r5.m(r9, r6)
            androidx.appcompat.widget.r0 r9 = d(r3, r4, r9)
            r0.f272b = r9
        L_0x0030:
            int r9 = b.a.j.m0
            boolean r10 = r5.q(r9)
            if (r10 == 0) goto L_0x0042
            int r9 = r5.m(r9, r6)
            androidx.appcompat.widget.r0 r9 = d(r3, r4, r9)
            r0.f273c = r9
        L_0x0042:
            int r9 = b.a.j.p0
            boolean r10 = r5.q(r9)
            if (r10 == 0) goto L_0x0054
            int r9 = r5.m(r9, r6)
            androidx.appcompat.widget.r0 r9 = d(r3, r4, r9)
            r0.f274d = r9
        L_0x0054:
            int r9 = b.a.j.n0
            boolean r10 = r5.q(r9)
            if (r10 == 0) goto L_0x0066
            int r9 = r5.m(r9, r6)
            androidx.appcompat.widget.r0 r9 = d(r3, r4, r9)
            r0.f275e = r9
        L_0x0066:
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 17
            if (r9 < r10) goto L_0x0090
            int r10 = b.a.j.q0
            boolean r11 = r5.q(r10)
            if (r11 == 0) goto L_0x007e
            int r10 = r5.m(r10, r6)
            androidx.appcompat.widget.r0 r10 = d(r3, r4, r10)
            r0.f276f = r10
        L_0x007e:
            int r10 = b.a.j.r0
            boolean r11 = r5.q(r10)
            if (r11 == 0) goto L_0x0090
            int r10 = r5.m(r10, r6)
            androidx.appcompat.widget.r0 r4 = d(r3, r4, r10)
            r0.g = r4
        L_0x0090:
            r5.u()
            android.widget.TextView r4 = r0.f271a
            android.text.method.TransformationMethod r4 = r4.getTransformationMethod()
            boolean r4 = r4 instanceof android.text.method.PasswordTransformationMethod
            r10 = 23
            r11 = 0
            if (r7 == r8) goto L_0x00ef
            int[] r12 = b.a.j.A2
            androidx.appcompat.widget.t0 r7 = androidx.appcompat.widget.t0.r(r3, r7, r12)
            if (r4 != 0) goto L_0x00b6
            int r12 = b.a.j.J2
            boolean r13 = r7.q(r12)
            if (r13 == 0) goto L_0x00b6
            boolean r12 = r7.a(r12, r6)
            r13 = 1
            goto L_0x00b8
        L_0x00b6:
            r12 = 0
            r13 = 0
        L_0x00b8:
            r0.u(r3, r7)
            if (r9 >= r10) goto L_0x00e9
            int r14 = b.a.j.E2
            boolean r15 = r7.q(r14)
            if (r15 == 0) goto L_0x00ca
            android.content.res.ColorStateList r14 = r7.c(r14)
            goto L_0x00cb
        L_0x00ca:
            r14 = r11
        L_0x00cb:
            int r15 = b.a.j.F2
            boolean r16 = r7.q(r15)
            if (r16 == 0) goto L_0x00d8
            android.content.res.ColorStateList r15 = r7.c(r15)
            goto L_0x00d9
        L_0x00d8:
            r15 = r11
        L_0x00d9:
            int r5 = b.a.j.G2
            boolean r17 = r7.q(r5)
            if (r17 == 0) goto L_0x00e6
            android.content.res.ColorStateList r5 = r7.c(r5)
            goto L_0x00e7
        L_0x00e6:
            r5 = r11
        L_0x00e7:
            r11 = r14
            goto L_0x00eb
        L_0x00e9:
            r5 = r11
            r15 = r5
        L_0x00eb:
            r7.u()
            goto L_0x00f3
        L_0x00ef:
            r5 = r11
            r15 = r5
            r12 = 0
            r13 = 0
        L_0x00f3:
            int[] r7 = b.a.j.A2
            androidx.appcompat.widget.t0 r7 = androidx.appcompat.widget.t0.t(r3, r1, r7, r2, r6)
            if (r4 != 0) goto L_0x0108
            int r14 = b.a.j.J2
            boolean r17 = r7.q(r14)
            if (r17 == 0) goto L_0x0108
            boolean r12 = r7.a(r14, r6)
            r13 = 1
        L_0x0108:
            if (r9 >= r10) goto L_0x012e
            int r10 = b.a.j.E2
            boolean r14 = r7.q(r10)
            if (r14 == 0) goto L_0x0116
            android.content.res.ColorStateList r11 = r7.c(r10)
        L_0x0116:
            int r10 = b.a.j.F2
            boolean r14 = r7.q(r10)
            if (r14 == 0) goto L_0x0122
            android.content.res.ColorStateList r15 = r7.c(r10)
        L_0x0122:
            int r10 = b.a.j.G2
            boolean r14 = r7.q(r10)
            if (r14 == 0) goto L_0x012e
            android.content.res.ColorStateList r5 = r7.c(r10)
        L_0x012e:
            r10 = 28
            if (r9 < r10) goto L_0x0146
            int r9 = b.a.j.B2
            boolean r10 = r7.q(r9)
            if (r10 == 0) goto L_0x0146
            int r9 = r7.e(r9, r8)
            if (r9 != 0) goto L_0x0146
            android.widget.TextView r9 = r0.f271a
            r10 = 0
            r9.setTextSize(r6, r10)
        L_0x0146:
            r0.u(r3, r7)
            r7.u()
            if (r11 == 0) goto L_0x0153
            android.widget.TextView r7 = r0.f271a
            r7.setTextColor(r11)
        L_0x0153:
            if (r15 == 0) goto L_0x015a
            android.widget.TextView r7 = r0.f271a
            r7.setHintTextColor(r15)
        L_0x015a:
            if (r5 == 0) goto L_0x0161
            android.widget.TextView r7 = r0.f271a
            r7.setLinkTextColor(r5)
        L_0x0161:
            if (r4 != 0) goto L_0x0168
            if (r13 == 0) goto L_0x0168
            r0.o(r12)
        L_0x0168:
            android.graphics.Typeface r4 = r0.j
            if (r4 == 0) goto L_0x0173
            android.widget.TextView r5 = r0.f271a
            int r7 = r0.i
            r5.setTypeface(r4, r7)
        L_0x0173:
            androidx.appcompat.widget.z r4 = r0.h
            r4.o(r1, r2)
            boolean r2 = androidx.core.widget.b.f370a
            if (r2 == 0) goto L_0x01b7
            androidx.appcompat.widget.z r2 = r0.h
            int r2 = r2.k()
            if (r2 == 0) goto L_0x01b7
            androidx.appcompat.widget.z r2 = r0.h
            int[] r2 = r2.j()
            int r4 = r2.length
            if (r4 <= 0) goto L_0x01b7
            android.widget.TextView r4 = r0.f271a
            int r4 = r4.getAutoSizeStepGranularity()
            float r4 = (float) r4
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x01b2
            android.widget.TextView r2 = r0.f271a
            androidx.appcompat.widget.z r4 = r0.h
            int r4 = r4.h()
            androidx.appcompat.widget.z r5 = r0.h
            int r5 = r5.g()
            androidx.appcompat.widget.z r7 = r0.h
            int r7 = r7.i()
            r2.setAutoSizeTextTypeUniformWithConfiguration(r4, r5, r7, r6)
            goto L_0x01b7
        L_0x01b2:
            android.widget.TextView r4 = r0.f271a
            r4.setAutoSizeTextTypeUniformWithPresetSizes(r2, r6)
        L_0x01b7:
            int[] r2 = b.a.j.s0
            androidx.appcompat.widget.t0 r1 = androidx.appcompat.widget.t0.s(r3, r1, r2)
            int r2 = b.a.j.y0
            int r2 = r1.e(r2, r8)
            int r3 = b.a.j.z0
            int r3 = r1.e(r3, r8)
            int r4 = b.a.j.A0
            int r4 = r1.e(r4, r8)
            r1.u()
            if (r2 == r8) goto L_0x01d9
            android.widget.TextView r1 = r0.f271a
            androidx.core.widget.i.f(r1, r2)
        L_0x01d9:
            if (r3 == r8) goto L_0x01e0
            android.widget.TextView r1 = r0.f271a
            androidx.core.widget.i.g(r1, r3)
        L_0x01e0:
            if (r4 == r8) goto L_0x01e7
            android.widget.TextView r1 = r0.f271a
            androidx.core.widget.i.h(r1, r4)
        L_0x01e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.x.k(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void l(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.k) {
            this.j = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z, int i2, int i3, int i4, int i5) {
        if (!b.f370a) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void n(Context context, int i2) {
        ColorStateList c2;
        t0 r = t0.r(context, i2, j.A2);
        int i3 = j.J2;
        if (r.q(i3)) {
            o(r.a(i3, false));
        }
        if (Build.VERSION.SDK_INT < 23) {
            int i4 = j.E2;
            if (r.q(i4) && (c2 = r.c(i4)) != null) {
                this.f271a.setTextColor(c2);
            }
        }
        int i5 = j.B2;
        if (r.q(i5) && r.e(i5, -1) == 0) {
            this.f271a.setTextSize(0, 0.0f);
        }
        u(context, r);
        r.u();
        Typeface typeface = this.j;
        if (typeface != null) {
            this.f271a.setTypeface(typeface, this.i);
        }
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z) {
        this.f271a.setAllCaps(z);
    }

    /* access modifiers changed from: package-private */
    public void p(int i2, int i3, int i4, int i5) {
        this.h.p(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void q(int[] iArr, int i2) {
        this.h.q(iArr, i2);
    }

    /* access modifiers changed from: package-private */
    public void r(int i2) {
        this.h.r(i2);
    }

    /* access modifiers changed from: package-private */
    public void s(int i2, float f2) {
        if (!b.f370a && !j()) {
            t(i2, f2);
        }
    }
}
