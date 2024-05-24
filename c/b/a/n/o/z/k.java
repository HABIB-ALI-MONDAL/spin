package c.b.a.n.o.z;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class k implements e {
    private static final Bitmap.Config j = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    private final l f1034a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Bitmap.Config> f1035b;

    /* renamed from: c  reason: collision with root package name */
    private final a f1036c;

    /* renamed from: d  reason: collision with root package name */
    private long f1037d;

    /* renamed from: e  reason: collision with root package name */
    private long f1038e;

    /* renamed from: f  reason: collision with root package name */
    private int f1039f;
    private int g;
    private int h;
    private int i;

    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    private static final class b implements a {
        b() {
        }

        public void a(Bitmap bitmap) {
        }

        public void b(Bitmap bitmap) {
        }
    }

    public k(long j2) {
        this(j2, l(), k());
    }

    k(long j2, l lVar, Set<Bitmap.Config> set) {
        this.f1037d = j2;
        this.f1034a = lVar;
        this.f1035b = set;
        this.f1036c = new b();
    }

    @TargetApi(26)
    private static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private static Bitmap g(int i2, int i3, Bitmap.Config config) {
        if (config == null) {
            config = j;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f1039f + ", misses=" + this.g + ", puts=" + this.h + ", evictions=" + this.i + ", currentSize=" + this.f1038e + ", maxSize=" + this.f1037d + "\nStrategy=" + this.f1034a);
    }

    private void j() {
        p(this.f1037d);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            hashSet.add((Object) null);
        }
        if (i2 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l l() {
        return Build.VERSION.SDK_INT >= 19 ? new n() : new c();
    }

    private synchronized Bitmap m(int i2, int i3, Bitmap.Config config) {
        Bitmap c2;
        f(config);
        c2 = this.f1034a.c(i2, i3, config != null ? config : j);
        if (c2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f1034a.e(i2, i3, config));
            }
            this.g++;
        } else {
            this.f1039f++;
            this.f1038e -= (long) this.f1034a.a(c2);
            this.f1036c.a(c2);
            o(c2);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f1034a.e(i2, i3, config));
        }
        h();
        return c2;
    }

    @TargetApi(19)
    private static void n(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private static void o(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        n(bitmap);
    }

    private synchronized void p(long j2) {
        while (this.f1038e > j2) {
            Bitmap b2 = this.f1034a.b();
            if (b2 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    i();
                }
                this.f1038e = 0;
                return;
            }
            this.f1036c.a(b2);
            this.f1038e -= (long) this.f1034a.a(b2);
            this.i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f1034a.f(b2));
            }
            h();
            b2.recycle();
        }
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i2);
        }
        if (i2 >= 40) {
            b();
        } else if (i2 >= 20) {
            p(this.f1037d / 2);
        }
    }

    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        p(0);
    }

    public Bitmap c(int i2, int i3, Bitmap.Config config) {
        Bitmap m = m(i2, i3, config);
        if (m == null) {
            return g(i2, i3, config);
        }
        m.eraseColor(0);
        return m;
    }

    public synchronized void d(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f1034a.a(bitmap)) <= this.f1037d) {
                        if (this.f1035b.contains(bitmap.getConfig())) {
                            int a2 = this.f1034a.a(bitmap);
                            this.f1034a.d(bitmap);
                            this.f1036c.b(bitmap);
                            this.h++;
                            this.f1038e += (long) a2;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f1034a.f(bitmap));
                            }
                            h();
                            j();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f1034a.f(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f1035b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        Bitmap m = m(i2, i3, config);
        return m == null ? g(i2, i3, config) : m;
    }
}
