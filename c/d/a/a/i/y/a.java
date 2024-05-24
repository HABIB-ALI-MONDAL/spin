package c.d.a.a.i.y;

import android.os.Build;
import android.util.Log;

public final class a {
    private static String a(String str, String str2) {
        String str3 = str + str2;
        return str3.length() > 23 ? str3.substring(0, 23) : str3;
    }

    public static void b(String str, String str2, Object obj) {
        String e2 = e(str);
        if (Log.isLoggable(e2, 3)) {
            Log.d(e2, String.format(str2, new Object[]{obj}));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        String e2 = e(str);
        if (Log.isLoggable(e2, 3)) {
            Log.d(e2, String.format(str2, objArr));
        }
    }

    public static void d(String str, String str2, Throwable th) {
        String e2 = e(str);
        if (Log.isLoggable(e2, 6)) {
            Log.e(e2, str2, th);
        }
    }

    private static String e(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return a("TRuntime.", str);
        }
        return "TRuntime." + str;
    }

    public static void f(String str, String str2, Object obj) {
        String e2 = e(str);
        if (Log.isLoggable(e2, 4)) {
            Log.i(e2, String.format(str2, new Object[]{obj}));
        }
    }

    public static void g(String str, String str2, Object obj) {
        String e2 = e(str);
        if (Log.isLoggable(e2, 5)) {
            Log.w(e2, String.format(str2, new Object[]{obj}));
        }
    }
}
