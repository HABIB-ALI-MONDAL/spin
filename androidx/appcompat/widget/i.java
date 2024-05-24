package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.c;
import b.a.j;

class i {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f208a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f209b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f210c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f211d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f212e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f213f;

    i(CompoundButton compoundButton) {
        this.f208a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable a2 = c.a(this.f208a);
        if (a2 == null) {
            return;
        }
        if (this.f211d || this.f212e) {
            Drawable mutate = a.p(a2).mutate();
            if (this.f211d) {
                a.n(mutate, this.f209b);
            }
            if (this.f212e) {
                a.o(mutate, this.f210c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f208a.getDrawableState());
            }
            this.f208a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = androidx.core.widget.c.a(r2.f208a);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b(int r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 >= r1) goto L_0x0013
            android.widget.CompoundButton r0 = r2.f208a
            android.graphics.drawable.Drawable r0 = androidx.core.widget.c.a(r0)
            if (r0 == 0) goto L_0x0013
            int r0 = r0.getIntrinsicWidth()
            int r3 = r3 + r0
        L_0x0013:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i.b(int):int");
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f209b;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.f210c;
    }

    /* access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f208a.getContext().obtainStyledAttributes(attributeSet, j.S0, i, 0);
        try {
            int i2 = j.T0;
            if (obtainStyledAttributes.hasValue(i2) && (resourceId = obtainStyledAttributes.getResourceId(i2, 0)) != 0) {
                CompoundButton compoundButton = this.f208a;
                compoundButton.setButtonDrawable(b.a.k.a.a.d(compoundButton.getContext(), resourceId));
            }
            int i3 = j.U0;
            if (obtainStyledAttributes.hasValue(i3)) {
                c.b(this.f208a, obtainStyledAttributes.getColorStateList(i3));
            }
            int i4 = j.V0;
            if (obtainStyledAttributes.hasValue(i4)) {
                c.c(this.f208a, c0.d(obtainStyledAttributes.getInt(i4, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.f213f) {
            this.f213f = false;
            return;
        }
        this.f213f = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void g(ColorStateList colorStateList) {
        this.f209b = colorStateList;
        this.f211d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void h(PorterDuff.Mode mode) {
        this.f210c = mode;
        this.f212e = true;
        a();
    }
}
