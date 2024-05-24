package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import b.d.e.a;

class o0 {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f236a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f237b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f238c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f239d = {16842919};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f240e = {16842912};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f241f = new int[0];
    private static final int[] g = new int[1];

    public static int a(Context context, int i) {
        ColorStateList d2 = d(context, i);
        if (d2 != null && d2.isStateful()) {
            return d2.getColorForState(f237b, d2.getDefaultColor());
        }
        TypedValue e2 = e();
        context.getTheme().resolveAttribute(16842803, e2, true);
        return c(context, i, e2.getFloat());
    }

    public static int b(Context context, int i) {
        int[] iArr = g;
        iArr[0] = i;
        t0 s = t0.s(context, (AttributeSet) null, iArr);
        try {
            return s.b(0, 0);
        } finally {
            s.u();
        }
    }

    static int c(Context context, int i, float f2) {
        int b2 = b(context, i);
        return a.d(b2, Math.round(((float) Color.alpha(b2)) * f2));
    }

    public static ColorStateList d(Context context, int i) {
        int[] iArr = g;
        iArr[0] = i;
        t0 s = t0.s(context, (AttributeSet) null, iArr);
        try {
            return s.c(0);
        } finally {
            s.u();
        }
    }

    private static TypedValue e() {
        ThreadLocal<TypedValue> threadLocal = f236a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
