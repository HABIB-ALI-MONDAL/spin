package c.b.a.n.q.c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import c.b.a.n.f;
import c.b.a.n.g;
import c.b.a.n.i;
import c.b.a.n.o.u;
import c.b.a.n.o.z.e;
import c.b.a.n.q.c.j;
import c.b.a.t.d;
import c.b.a.t.h;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class k {

    /* renamed from: f  reason: collision with root package name */
    public static final i<c.b.a.n.b> f1144f = i.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", c.b.a.n.b.m);
    public static final i<j> g = i.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", j.f1143d);
    public static final i<Boolean> h = i.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);
    public static final i<Boolean> i = i.e("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
    private static final Set<String> j = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
    private static final b k = new a();
    private static final Set<f.a> l = Collections.unmodifiableSet(EnumSet.of(f.a.JPEG, f.a.PNG_A, f.a.PNG));
    private static final Queue<BitmapFactory.Options> m = c.b.a.t.i.e(0);

    /* renamed from: a  reason: collision with root package name */
    private final e f1145a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayMetrics f1146b;

    /* renamed from: c  reason: collision with root package name */
    private final c.b.a.n.o.z.b f1147c;

    /* renamed from: d  reason: collision with root package name */
    private final List<f> f1148d;

    /* renamed from: e  reason: collision with root package name */
    private final o f1149e = o.a();

    class a implements b {
        a() {
        }

        public void a(e eVar, Bitmap bitmap) {
        }

        public void b() {
        }
    }

    public interface b {
        void a(e eVar, Bitmap bitmap);

        void b();
    }

    public k(List<f> list, DisplayMetrics displayMetrics, e eVar, c.b.a.n.o.z.b bVar) {
        this.f1148d = list;
        h.d(displayMetrics);
        this.f1146b = displayMetrics;
        h.d(eVar);
        this.f1145a = eVar;
        h.d(bVar);
        this.f1147c = bVar;
    }

    private static int a(double d2) {
        int j2 = j(d2);
        double d3 = (double) j2;
        Double.isNaN(d3);
        int t = t(d3 * d2);
        double d4 = (double) (((float) t) / ((float) j2));
        Double.isNaN(d4);
        double d5 = (double) t;
        Double.isNaN(d5);
        return t((d2 / d4) * d5);
    }

    private void b(InputStream inputStream, c.b.a.n.b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (!this.f1149e.c(i2, i3, options, bVar, z, z2)) {
            if (bVar == c.b.a.n.b.PREFER_ARGB_8888 || bVar == c.b.a.n.b.PREFER_ARGB_8888_DISALLOW_HARDWARE || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z3 = false;
            try {
                z3 = g.b(this.f1148d, inputStream, this.f1147c).d();
            } catch (IOException e2) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e2);
                }
            }
            Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    private static void c(f.a aVar, InputStream inputStream, b bVar, e eVar, j jVar, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) {
        int i7;
        int i8;
        int i9;
        int i10;
        f.a aVar2 = aVar;
        j jVar2 = jVar;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        BitmapFactory.Options options2 = options;
        if (i12 <= 0 || i13 <= 0) {
            String str = "Downsampler";
            String str2 = "x";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to determine dimensions for: " + aVar2 + " with target [" + i14 + str2 + i15 + "]");
                return;
            }
            return;
        }
        float b2 = (i11 == 90 || i11 == 270) ? jVar2.b(i13, i12, i14, i15) : jVar2.b(i12, i13, i14, i15);
        if (b2 > 0.0f) {
            j.d a2 = jVar2.a(i12, i13, i14, i15);
            if (a2 != null) {
                float f2 = (float) i12;
                float f3 = (float) i13;
                String str3 = "Downsampler";
                String str4 = "x";
                int t = i12 / t((double) (b2 * f2));
                int t2 = i13 / t((double) (b2 * f3));
                j.d dVar = j.d.MEMORY;
                int max = a2 == dVar ? Math.max(t, t2) : Math.min(t, t2);
                int i16 = Build.VERSION.SDK_INT;
                String str5 = "], target: [";
                if (i16 > 23 || !j.contains(options2.outMimeType)) {
                    int max2 = Math.max(1, Integer.highestOneBit(max));
                    i7 = (a2 != dVar || ((float) max2) >= 1.0f / b2) ? max2 : max2 << 1;
                } else {
                    i7 = 1;
                }
                options2.inSampleSize = i7;
                if (aVar2 == f.a.JPEG) {
                    float min = (float) Math.min(i7, 8);
                    i9 = i16;
                    i8 = (int) Math.ceil((double) (f2 / min));
                    i10 = (int) Math.ceil((double) (f3 / min));
                    int i17 = i7 / 8;
                    if (i17 > 0) {
                        i8 /= i17;
                        i10 /= i17;
                    }
                } else {
                    i9 = i16;
                    if (!(aVar2 == f.a.PNG || aVar2 == f.a.PNG_A)) {
                        if (aVar2 == f.a.WEBP || aVar2 == f.a.WEBP_A) {
                            if (i9 >= 24) {
                                float f4 = (float) i7;
                                i8 = Math.round(f2 / f4);
                                i10 = Math.round(f3 / f4);
                            }
                        } else if (i12 % i7 == 0 && i13 % i7 == 0) {
                            i8 = i12 / i7;
                            i10 = i13 / i7;
                        } else {
                            int[] k2 = k(inputStream, options2, bVar, eVar);
                            int i18 = k2[0];
                            i10 = k2[1];
                            i8 = i18;
                        }
                    }
                    float f5 = (float) i7;
                    i8 = (int) Math.floor((double) (f2 / f5));
                    i10 = (int) Math.floor((double) (f3 / f5));
                }
                double b3 = (double) jVar2.b(i8, i10, i14, i15);
                if (i9 >= 19) {
                    options2.inTargetDensity = a(b3);
                    options2.inDensity = j(b3);
                }
                if (o(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                String str6 = str3;
                if (Log.isLoggable(str6, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculate scaling, source: [");
                    sb.append(i12);
                    String str7 = str4;
                    sb.append(str7);
                    sb.append(i13);
                    sb.append(str5);
                    sb.append(i14);
                    sb.append(str7);
                    sb.append(i15);
                    sb.append("], power of two scaled: [");
                    sb.append(i8);
                    sb.append(str7);
                    sb.append(i10);
                    sb.append("], exact scale factor: ");
                    sb.append(b2);
                    sb.append(", power of 2 sample size: ");
                    sb.append(i7);
                    sb.append(", adjusted scale factor: ");
                    sb.append(b3);
                    sb.append(", target density: ");
                    sb.append(options2.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options2.inDensity);
                    Log.v(str6, sb.toString());
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        String str8 = "x";
        throw new IllegalArgumentException("Cannot scale with factor: " + b2 + " from: " + jVar2 + ", source: [" + i12 + str8 + i13 + "], target: [" + i14 + str8 + i15 + "]");
    }

    private Bitmap f(InputStream inputStream, BitmapFactory.Options options, j jVar, c.b.a.n.b bVar, boolean z, int i2, int i3, boolean z2, b bVar2) {
        k kVar;
        int i4;
        int i5;
        int i6;
        InputStream inputStream2 = inputStream;
        BitmapFactory.Options options2 = options;
        b bVar3 = bVar2;
        long b2 = d.b();
        int[] k2 = k(inputStream2, options2, bVar3, this.f1145a);
        boolean z3 = false;
        int i7 = k2[0];
        int i8 = k2[1];
        String str = options2.outMimeType;
        boolean z4 = (i7 == -1 || i8 == -1) ? false : z;
        int a2 = g.a(this.f1148d, inputStream2, this.f1147c);
        int g2 = t.g(a2);
        boolean j2 = t.j(a2);
        int i9 = i2;
        int i10 = i3;
        int i11 = i9 == Integer.MIN_VALUE ? i7 : i9;
        int i12 = i10 == Integer.MIN_VALUE ? i8 : i10;
        f.a b3 = g.b(this.f1148d, inputStream2, this.f1147c);
        e eVar = this.f1145a;
        f.a aVar = b3;
        c(b3, inputStream, bVar2, eVar, jVar, g2, i7, i8, i11, i12, options);
        int i13 = a2;
        String str2 = str;
        int i14 = i8;
        int i15 = i7;
        b bVar4 = bVar3;
        BitmapFactory.Options options3 = options2;
        b(inputStream, bVar, z4, j2, options, i11, i12);
        if (Build.VERSION.SDK_INT >= 19) {
            z3 = true;
        }
        if (options3.inSampleSize == 1 || z3) {
            kVar = this;
            if (kVar.v(aVar)) {
                if (i15 < 0 || i14 < 0 || !z2 || !z3) {
                    float f2 = o(options) ? ((float) options3.inTargetDensity) / ((float) options3.inDensity) : 1.0f;
                    int i16 = options3.inSampleSize;
                    float f3 = (float) i16;
                    i6 = Math.round(((float) ((int) Math.ceil((double) (((float) i15) / f3)))) * f2);
                    i5 = Math.round(((float) ((int) Math.ceil((double) (((float) i14) / f3)))) * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + i6 + "x" + i5 + "] for source [" + i15 + "x" + i14 + "], sampleSize: " + i16 + ", targetDensity: " + options3.inTargetDensity + ", density: " + options3.inDensity + ", density multiplier: " + f2);
                    }
                } else {
                    i6 = i11;
                    i5 = i12;
                }
                if (i6 > 0 && i5 > 0) {
                    u(options3, kVar.f1145a, i6, i5);
                }
            }
        } else {
            kVar = this;
        }
        Bitmap g3 = g(inputStream, options3, bVar4, kVar.f1145a);
        bVar4.a(kVar.f1145a, g3);
        if (Log.isLoggable("Downsampler", 2)) {
            i4 = i13;
            p(i15, i14, str2, options, g3, i2, i3, b2);
        } else {
            i4 = i13;
        }
        Bitmap bitmap = null;
        if (g3 != null) {
            g3.setDensity(kVar.f1146b.densityDpi);
            bitmap = t.k(kVar.f1145a, g3, i4);
            if (!g3.equals(bitmap)) {
                kVar.f1145a.d(g3);
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap g(java.io.InputStream r6, android.graphics.BitmapFactory.Options r7, c.b.a.n.q.c.k.b r8, c.b.a.n.o.z.e r9) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r7.inJustDecodeBounds
            if (r1 == 0) goto L_0x000c
            r1 = 10485760(0xa00000, float:1.469368E-38)
            r6.mark(r1)
            goto L_0x000f
        L_0x000c:
            r8.b()
        L_0x000f:
            int r1 = r7.outWidth
            int r2 = r7.outHeight
            java.lang.String r3 = r7.outMimeType
            java.util.concurrent.locks.Lock r4 = c.b.a.n.q.c.t.f()
            r4.lock()
            r4 = 0
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r6, r4, r7)     // Catch:{ IllegalArgumentException -> 0x0032 }
            java.util.concurrent.locks.Lock r9 = c.b.a.n.q.c.t.f()
            r9.unlock()
            boolean r7 = r7.inJustDecodeBounds
            if (r7 == 0) goto L_0x002f
            r6.reset()
        L_0x002f:
            return r8
        L_0x0030:
            r6 = move-exception
            goto L_0x005f
        L_0x0032:
            r5 = move-exception
            java.io.IOException r1 = q(r5, r1, r2, r3, r7)     // Catch:{ all -> 0x0030 }
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch:{ all -> 0x0030 }
            if (r2 == 0) goto L_0x0043
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch:{ all -> 0x0030 }
        L_0x0043:
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x005e
            r6.reset()     // Catch:{ IOException -> 0x005d }
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch:{ IOException -> 0x005d }
            r9.d(r0)     // Catch:{ IOException -> 0x005d }
            r7.inBitmap = r4     // Catch:{ IOException -> 0x005d }
            android.graphics.Bitmap r6 = g(r6, r7, r8, r9)     // Catch:{ IOException -> 0x005d }
            java.util.concurrent.locks.Lock r7 = c.b.a.n.q.c.t.f()
            r7.unlock()
            return r6
        L_0x005d:
            throw r1     // Catch:{ all -> 0x0030 }
        L_0x005e:
            throw r1     // Catch:{ all -> 0x0030 }
        L_0x005f:
            java.util.concurrent.locks.Lock r7 = c.b.a.n.q.c.t.f()
            r7.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.n.q.c.k.g(java.io.InputStream, android.graphics.BitmapFactory$Options, c.b.a.n.q.c.k$b, c.b.a.n.o.z.e):android.graphics.Bitmap");
    }

    @TargetApi(19)
    private static String h(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static synchronized BitmapFactory.Options i() {
        BitmapFactory.Options poll;
        synchronized (k.class) {
            Queue<BitmapFactory.Options> queue = m;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                s(poll);
            }
        }
        return poll;
    }

    private static int j(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int[] k(InputStream inputStream, BitmapFactory.Options options, b bVar, e eVar) {
        options.inJustDecodeBounds = true;
        g(inputStream, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String l(BitmapFactory.Options options) {
        return h(options.inBitmap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.inDensity;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean o(android.graphics.BitmapFactory.Options r1) {
        /*
            int r0 = r1.inTargetDensity
            if (r0 <= 0) goto L_0x000c
            int r1 = r1.inDensity
            if (r1 <= 0) goto L_0x000c
            if (r0 == r1) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.n.q.c.k.o(android.graphics.BitmapFactory$Options):boolean");
    }

    private static void p(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + h(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + l(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + d.a(j2));
    }

    private static IOException q(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + l(options), illegalArgumentException);
    }

    private static void r(BitmapFactory.Options options) {
        s(options);
        Queue<BitmapFactory.Options> queue = m;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void s(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int t(double d2) {
        return (int) (d2 + 0.5d);
    }

    @TargetApi(26)
    private static void u(BitmapFactory.Options options, e eVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.e(i2, i3, config);
    }

    private boolean v(f.a aVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return l.contains(aVar);
    }

    public u<Bitmap> d(InputStream inputStream, int i2, int i3, c.b.a.n.j jVar) {
        return e(inputStream, i2, i3, jVar, k);
    }

    public u<Bitmap> e(InputStream inputStream, int i2, int i3, c.b.a.n.j jVar, b bVar) {
        c.b.a.n.j jVar2 = jVar;
        h.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f1147c.e(65536, byte[].class);
        BitmapFactory.Options i4 = i();
        i4.inTempStorage = bArr;
        c.b.a.n.b bVar2 = (c.b.a.n.b) jVar2.c(f1144f);
        j jVar3 = (j) jVar2.c(g);
        boolean booleanValue = ((Boolean) jVar2.c(h)).booleanValue();
        i iVar = i;
        try {
            return d.f(f(inputStream, i4, jVar3, bVar2, bVar2 == c.b.a.n.b.PREFER_ARGB_8888_DISALLOW_HARDWARE ? false : jVar2.c(iVar) != null && ((Boolean) jVar2.c(iVar)).booleanValue(), i2, i3, booleanValue, bVar), this.f1145a);
        } finally {
            r(i4);
            this.f1147c.d(bArr);
        }
    }

    public boolean m(InputStream inputStream) {
        return true;
    }

    public boolean n(ByteBuffer byteBuffer) {
        return true;
    }
}
