package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.c.f;

public class t0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f256a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f257b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f258c;

    private t0(Context context, TypedArray typedArray) {
        this.f256a = context;
        this.f257b = typedArray;
    }

    public static t0 r(Context context, int i, int[] iArr) {
        return new t0(context, context.obtainStyledAttributes(i, iArr));
    }

    public static t0 s(Context context, AttributeSet attributeSet, int[] iArr) {
        return new t0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static t0 t(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new t0(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean a(int i, boolean z) {
        return this.f257b.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.f257b.getColor(i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = b.a.k.a.a.c(r2.f256a, (r0 = r2.f257b.getResourceId(r3, 0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.res.ColorStateList c(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f257b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x001a
            android.content.res.TypedArray r0 = r2.f257b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x001a
            android.content.Context r1 = r2.f256a
            android.content.res.ColorStateList r0 = b.a.k.a.a.c(r1, r0)
            if (r0 == 0) goto L_0x001a
            return r0
        L_0x001a:
            android.content.res.TypedArray r0 = r2.f257b
            android.content.res.ColorStateList r3 = r0.getColorStateList(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.t0.c(int):android.content.res.ColorStateList");
    }

    public int d(int i, int i2) {
        return this.f257b.getDimensionPixelOffset(i, i2);
    }

    public int e(int i, int i2) {
        return this.f257b.getDimensionPixelSize(i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.f257b.getResourceId(r3, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable f(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f257b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x0018
            android.content.res.TypedArray r0 = r2.f257b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x0018
            android.content.Context r3 = r2.f256a
            android.graphics.drawable.Drawable r3 = b.a.k.a.a.d(r3, r0)
            return r3
        L_0x0018:
            android.content.res.TypedArray r0 = r2.f257b
            android.graphics.drawable.Drawable r3 = r0.getDrawable(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.t0.f(int):android.graphics.drawable.Drawable");
    }

    public Drawable g(int i) {
        int resourceId;
        if (!this.f257b.hasValue(i) || (resourceId = this.f257b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return j.n().q(this.f256a, resourceId, true);
    }

    public float h(int i, float f2) {
        return this.f257b.getFloat(i, f2);
    }

    public Typeface i(int i, int i2, f.a aVar) {
        int resourceId = this.f257b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f258c == null) {
            this.f258c = new TypedValue();
        }
        return f.b(this.f256a, resourceId, this.f258c, i2, aVar);
    }

    public int j(int i, int i2) {
        return this.f257b.getInt(i, i2);
    }

    public int k(int i, int i2) {
        return this.f257b.getInteger(i, i2);
    }

    public int l(int i, int i2) {
        return this.f257b.getLayoutDimension(i, i2);
    }

    public int m(int i, int i2) {
        return this.f257b.getResourceId(i, i2);
    }

    public String n(int i) {
        return this.f257b.getString(i);
    }

    public CharSequence o(int i) {
        return this.f257b.getText(i);
    }

    public CharSequence[] p(int i) {
        return this.f257b.getTextArray(i);
    }

    public boolean q(int i) {
        return this.f257b.hasValue(i);
    }

    public void u() {
        this.f257b.recycle();
    }
}
