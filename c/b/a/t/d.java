package c.b.a.t;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final double f1276a;

    static {
        double d2 = 1.0d;
        if (Build.VERSION.SDK_INT >= 17) {
            d2 = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f1276a = d2;
    }

    public static double a(long j) {
        double b2 = (double) (b() - j);
        double d2 = f1276a;
        Double.isNaN(b2);
        return b2 * d2;
    }

    @TargetApi(17)
    public static long b() {
        return Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.uptimeMillis();
    }
}
