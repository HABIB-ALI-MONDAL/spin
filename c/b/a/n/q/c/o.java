package c.b.a.n.q.c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import c.b.a.n.b;
import java.io.File;

final class o {

    /* renamed from: c  reason: collision with root package name */
    private static final File f1154c = new File("/proc/self/fd");

    /* renamed from: d  reason: collision with root package name */
    private static volatile o f1155d;

    /* renamed from: a  reason: collision with root package name */
    private volatile int f1156a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f1157b = true;

    private o() {
    }

    static o a() {
        if (f1155d == null) {
            synchronized (o.class) {
                if (f1155d == null) {
                    f1155d = new o();
                }
            }
        }
        return f1155d;
    }

    private synchronized boolean b() {
        boolean z = true;
        int i = this.f1156a + 1;
        this.f1156a = i;
        if (i >= 50) {
            this.f1156a = 0;
            int length = f1154c.list().length;
            if (length >= 700) {
                z = false;
            }
            this.f1157b = z;
            if (!this.f1157b && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + 700);
            }
        }
        return this.f1157b;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean c(int i, int i2, BitmapFactory.Options options, b bVar, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || bVar == b.PREFER_ARGB_8888_DISALLOW_HARDWARE || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && b();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }
}
