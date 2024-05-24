package b.d.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.c.c;
import b.c.g;
import b.d.h.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

class e extends i {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f563b;

    /* renamed from: c  reason: collision with root package name */
    private static final Constructor<?> f564c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f565d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f566e;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class cls2 = Integer.TYPE;
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method2 = null;
            method = null;
        }
        f564c = constructor;
        f563b = cls;
        f565d = method;
        f566e = method2;
    }

    e() {
    }

    private static boolean j(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f565d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface k(Object obj) {
        try {
            Object newInstance = Array.newInstance(f563b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f566e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean l() {
        Method method = f565d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object m() {
        try {
            return f564c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Typeface b(Context context, c.b bVar, Resources resources, int i) {
        Object m = m();
        if (m == null) {
            return null;
        }
        for (c.C0013c cVar : bVar.a()) {
            ByteBuffer b2 = j.b(context, resources, cVar.b());
            if (b2 == null || !j(m, b2, cVar.c(), cVar.e(), cVar.f())) {
                return null;
            }
        }
        return k(m);
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        Object m = m();
        if (m == null) {
            return null;
        }
        g gVar = new g();
        for (b.f fVar : fVarArr) {
            Uri c2 = fVar.c();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(c2);
            if (byteBuffer == null) {
                byteBuffer = j.f(context, cancellationSignal, c2);
                gVar.put(c2, byteBuffer);
            }
            if (byteBuffer == null || !j(m, byteBuffer, fVar.b(), fVar.d(), fVar.e())) {
                return null;
            }
        }
        Typeface k = k(m);
        if (k == null) {
            return null;
        }
        return Typeface.create(k, i);
    }
}
