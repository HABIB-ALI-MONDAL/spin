package c.b.a.n.o.a0;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f920a;

    /* renamed from: b  reason: collision with root package name */
    private final int f921b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f922c;

    /* renamed from: d  reason: collision with root package name */
    private final int f923d;

    public static final class a {
        static final int i = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: a  reason: collision with root package name */
        final Context f924a;

        /* renamed from: b  reason: collision with root package name */
        ActivityManager f925b;

        /* renamed from: c  reason: collision with root package name */
        c f926c;

        /* renamed from: d  reason: collision with root package name */
        float f927d = 2.0f;

        /* renamed from: e  reason: collision with root package name */
        float f928e = ((float) i);

        /* renamed from: f  reason: collision with root package name */
        float f929f = 0.4f;
        float g = 0.33f;
        int h = 4194304;

        public a(Context context) {
            this.f924a = context;
            this.f925b = (ActivityManager) context.getSystemService("activity");
            this.f926c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.e(this.f925b)) {
                this.f928e = 0.0f;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f930a;

        b(DisplayMetrics displayMetrics) {
            this.f930a = displayMetrics;
        }

        public int a() {
            return this.f930a.heightPixels;
        }

        public int b() {
            return this.f930a.widthPixels;
        }
    }

    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        this.f922c = aVar.f924a;
        int i = e(aVar.f925b) ? aVar.h / 2 : aVar.h;
        this.f923d = i;
        int c2 = c(aVar.f925b, aVar.f929f, aVar.g);
        float b2 = (float) (aVar.f926c.b() * aVar.f926c.a() * 4);
        int round = Math.round(aVar.f928e * b2);
        int round2 = Math.round(b2 * aVar.f927d);
        int i2 = c2 - i;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f921b = round2;
            this.f920a = round;
        } else {
            float f2 = (float) i2;
            float f3 = aVar.f928e;
            float f4 = aVar.f927d;
            float f5 = f2 / (f3 + f4);
            this.f921b = Math.round(f4 * f5);
            this.f920a = Math.round(f5 * aVar.f928e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f921b));
            sb.append(", pool size: ");
            sb.append(f(this.f920a));
            sb.append(", byte array size: ");
            sb.append(f(i));
            sb.append(", memory class limited? ");
            sb.append(i3 > c2);
            sb.append(", max size: ");
            sb.append(f(c2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f925b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.f925b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f2, float f3) {
        boolean e2 = e(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (e2) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    private String f(int i) {
        return Formatter.formatFileSize(this.f922c, (long) i);
    }

    public int a() {
        return this.f923d;
    }

    public int b() {
        return this.f920a;
    }

    public int d() {
        return this.f921b;
    }
}
