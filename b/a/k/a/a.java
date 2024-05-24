package b.a.k.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.j;
import java.util.WeakHashMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f463a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0017a>> f464b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f465c = new Object();

    /* renamed from: b.a.k.a.a$a  reason: collision with other inner class name */
    private static class C0017a {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f466a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f467b;

        C0017a(ColorStateList colorStateList, Configuration configuration) {
            this.f466a = colorStateList;
            this.f467b = configuration;
        }
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f465c) {
            WeakHashMap<Context, SparseArray<C0017a>> weakHashMap = f464b;
            SparseArray sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i, new C0017a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList b(android.content.Context r4, int r5) {
        /*
            java.lang.Object r0 = f465c
            monitor-enter(r0)
            java.util.WeakHashMap<android.content.Context, android.util.SparseArray<b.a.k.a.a$a>> r1 = f464b     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0035 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0032
            int r2 = r1.size()     // Catch:{ all -> 0x0035 }
            if (r2 <= 0) goto L_0x0032
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0035 }
            b.a.k.a.a$a r2 = (b.a.k.a.a.C0017a) r2     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0032
            android.content.res.Configuration r3 = r2.f467b     // Catch:{ all -> 0x0035 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0035 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0035 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x002f
            android.content.res.ColorStateList r4 = r2.f466a     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r4
        L_0x002f:
            r1.remove(r5)     // Catch:{ all -> 0x0035 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            r4 = 0
            return r4
        L_0x0035:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.k.a.a.b(android.content.Context, int):android.content.res.ColorStateList");
    }

    public static ColorStateList c(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList b2 = b(context, i);
        if (b2 != null) {
            return b2;
        }
        ColorStateList f2 = f(context, i);
        if (f2 == null) {
            return androidx.core.content.a.e(context, i);
        }
        a(context, i, f2);
        return f2;
    }

    public static Drawable d(Context context, int i) {
        return j.n().p(context, i);
    }

    private static TypedValue e() {
        ThreadLocal<TypedValue> threadLocal = f463a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList f(Context context, int i) {
        if (g(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return androidx.core.content.c.a.a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean g(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue e2 = e();
        resources.getValue(i, e2, true);
        int i2 = e2.type;
        return i2 >= 28 && i2 <= 31;
    }
}
