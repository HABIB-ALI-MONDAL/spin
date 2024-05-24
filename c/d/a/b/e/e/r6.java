package c.d.a.b.e.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import b.c.a;
import java.util.Iterator;
import java.util.Map;

public final class r6 implements y5 {

    /* renamed from: c  reason: collision with root package name */
    private static final Map f1740c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f1741a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f1742b;

    static r6 b(Context context, String str, Runnable runnable) {
        r6 r6Var;
        if (!p5.b()) {
            synchronized (r6.class) {
                r6Var = (r6) f1740c.get((Object) null);
                if (r6Var == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return r6Var;
        }
        throw null;
    }

    static synchronized void c() {
        synchronized (r6.class) {
            Map map = f1740c;
            Iterator it = map.values().iterator();
            if (!it.hasNext()) {
                map.clear();
            } else {
                r6 r6Var = (r6) it.next();
                SharedPreferences sharedPreferences = r6Var.f1741a;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = r6Var.f1742b;
                throw null;
            }
        }
    }

    public final Object a(String str) {
        throw null;
    }
}
