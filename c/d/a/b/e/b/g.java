package c.d.a.b.e.b;

import android.os.Build;

final class g {
    static boolean a() {
        return Build.VERSION.SDK_INT >= 33 || Build.VERSION.CODENAME.charAt(0) == 'T';
    }
}
