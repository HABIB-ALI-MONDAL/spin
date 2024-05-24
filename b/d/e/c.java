package b.d.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.c.c;
import androidx.core.content.c.f;
import b.c.e;
import b.d.h.b;

@SuppressLint({"NewApi"})
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final i f556a;

    /* renamed from: b  reason: collision with root package name */
    private static final e<String, Typeface> f557b = new e<>(16);

    static {
        int i = Build.VERSION.SDK_INT;
        f556a = i >= 29 ? new h() : i >= 28 ? new g() : i >= 26 ? new f() : (i < 24 || !e.l()) ? i >= 21 ? new d() : new i() : new e();
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        return f556a.c(context, cancellationSignal, fVarArr, i);
    }

    public static Typeface b(Context context, c.a aVar, Resources resources, int i, int i2, f.a aVar2, Handler handler, boolean z) {
        Typeface typeface;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            typeface = b.g(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            typeface = f556a.b(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.b(typeface, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f557b.d(d(resources, i, i2), typeface);
        }
        return typeface;
    }

    public static Typeface c(Context context, Resources resources, int i, String str, int i2) {
        Typeface e2 = f556a.e(context, resources, i, str, i2);
        if (e2 != null) {
            f557b.d(d(resources, i, i2), e2);
        }
        return e2;
    }

    private static String d(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface e(Resources resources, int i, int i2) {
        return f557b.c(d(resources, i, i2));
    }
}
