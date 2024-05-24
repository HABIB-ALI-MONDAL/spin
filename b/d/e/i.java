package b.d.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.c.c;
import b.d.h.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

class i {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Long, c.b> f567a = new ConcurrentHashMap<>();

    class a implements c<b.f> {
        a(i iVar) {
        }

        /* renamed from: c */
        public int a(b.f fVar) {
            return fVar.d();
        }

        /* renamed from: d */
        public boolean b(b.f fVar) {
            return fVar.e();
        }
    }

    class b implements c<c.C0013c> {
        b(i iVar) {
        }

        /* renamed from: c */
        public int a(c.C0013c cVar) {
            return cVar.e();
        }

        /* renamed from: d */
        public boolean b(c.C0013c cVar) {
            return cVar.f();
        }
    }

    private interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    i() {
    }

    private void a(Typeface typeface, c.b bVar) {
        long i = i(typeface);
        if (i != 0) {
            this.f567a.put(Long.valueOf(i), bVar);
        }
    }

    private c.C0013c f(c.b bVar, int i) {
        return (c.C0013c) g(bVar.a(), i, new b(this));
    }

    private static <T> T g(T[] tArr, int i, c<T> cVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(cVar.a(t2) - i2) * 2) + (cVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    private static long i(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0;
        } catch (IllegalAccessException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0;
        }
    }

    public Typeface b(Context context, c.b bVar, Resources resources, int i) {
        c.C0013c f2 = f(bVar, i);
        if (f2 == null) {
            return null;
        }
        Typeface c2 = c.c(context, resources, f2.b(), f2.a(), i);
        a(c2, bVar);
        return c2;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(h(fVarArr, i).c());
            try {
                Typeface d2 = d(context, inputStream);
                j.a(inputStream);
                return d2;
            } catch (IOException unused) {
                j.a(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                j.a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            j.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            j.a(inputStream2);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public Typeface d(Context context, InputStream inputStream) {
        File e2 = j.e(context);
        if (e2 == null) {
            return null;
        }
        try {
            if (!j.d(e2, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e2.getPath());
            e2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e2.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i, String str, int i2) {
        File e2 = j.e(context);
        if (e2 == null) {
            return null;
        }
        try {
            if (!j.c(e2, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e2.getPath());
            e2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e2.delete();
        }
    }

    /* access modifiers changed from: protected */
    public b.f h(b.f[] fVarArr, int i) {
        return (b.f) g(fVarArr, i, new a(this));
    }
}
