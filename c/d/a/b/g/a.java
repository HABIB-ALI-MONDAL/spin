package c.d.a.b.g;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import c.d.a.b.e.f.b;
import c.d.a.b.e.f.c;
import c.d.a.b.e.f.h;
import c.d.a.b.e.f.i;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.g;
import com.google.android.gms.common.util.m;
import com.google.android.gms.common.util.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class a {
    private static final long p = TimeUnit.DAYS.toMillis(366);
    private static volatile ScheduledExecutorService q = null;
    private static final Object r = new Object();
    private static volatile e s = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Object f1807a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f1808b;

    /* renamed from: c  reason: collision with root package name */
    private int f1809c = 0;

    /* renamed from: d  reason: collision with root package name */
    private Future<?> f1810d;

    /* renamed from: e  reason: collision with root package name */
    private long f1811e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<f> f1812f = new HashSet();
    private boolean g = true;
    private int h;
    b i;
    private d j = g.d();
    private WorkSource k;
    private final String l;
    private final Map<String, d> m = new HashMap();
    private AtomicInteger n = new AtomicInteger(0);
    private final ScheduledExecutorService o;

    public a(Context context, int i2, String str) {
        String packageName = context.getPackageName();
        n.j(context, "WakeLock: context must not be null");
        n.f(str, "WakeLock: wakeLockName must not be empty");
        context.getApplicationContext();
        this.i = null;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.l = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.l = str;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("expected a non-null reference", 0, 29);
            throw new i(sb.toString());
        }
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i2, str);
        this.f1808b = newWakeLock;
        if (o.c(context)) {
            WorkSource b2 = o.b(context, m.a(packageName) ? context.getPackageName() : packageName);
            this.k = b2;
            if (b2 != null) {
                i(newWakeLock, b2);
            }
        }
        ScheduledExecutorService scheduledExecutorService = q;
        if (scheduledExecutorService == null) {
            synchronized (r) {
                scheduledExecutorService = q;
                if (scheduledExecutorService == null) {
                    h.a();
                    scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                    q = scheduledExecutorService;
                }
            }
        }
        this.o = scheduledExecutorService;
    }

    public static /* synthetic */ void e(a aVar) {
        synchronized (aVar.f1807a) {
            if (aVar.b()) {
                Log.e("WakeLock", String.valueOf(aVar.l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                aVar.g();
                if (aVar.b()) {
                    aVar.f1809c = 1;
                    aVar.h(0);
                }
            }
        }
    }

    private final String f(String str) {
        if (!this.g || !TextUtils.isEmpty((CharSequence) null)) {
        }
        return null;
    }

    private final void g() {
        if (!this.f1812f.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.f1812f);
            this.f1812f.clear();
            if (arrayList.size() > 0) {
                f fVar = (f) arrayList.get(0);
                throw null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
        if (r5.i != null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        r5.i = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0084, code lost:
        if (r5.i != null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a1, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void h(int r6) {
        /*
            r5 = this;
            java.lang.Object r6 = r5.f1807a
            monitor-enter(r6)
            boolean r0 = r5.b()     // Catch:{ all -> 0x00a2 }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r6)     // Catch:{ all -> 0x00a2 }
            return
        L_0x000b:
            boolean r0 = r5.g     // Catch:{ all -> 0x00a2 }
            r1 = 0
            if (r0 == 0) goto L_0x001b
            int r0 = r5.f1809c     // Catch:{ all -> 0x00a2 }
            int r0 = r0 + -1
            r5.f1809c = r0     // Catch:{ all -> 0x00a2 }
            if (r0 > 0) goto L_0x0019
            goto L_0x001d
        L_0x0019:
            monitor-exit(r6)     // Catch:{ all -> 0x00a2 }
            return
        L_0x001b:
            r5.f1809c = r1     // Catch:{ all -> 0x00a2 }
        L_0x001d:
            r5.g()     // Catch:{ all -> 0x00a2 }
            java.util.Map<java.lang.String, c.d.a.b.g.d> r0 = r5.m     // Catch:{ all -> 0x00a2 }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x00a2 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00a2 }
        L_0x002a:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00a2 }
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00a2 }
            c.d.a.b.g.d r2 = (c.d.a.b.g.d) r2     // Catch:{ all -> 0x00a2 }
            r2.f1813a = r1     // Catch:{ all -> 0x00a2 }
            goto L_0x002a
        L_0x0039:
            java.util.Map<java.lang.String, c.d.a.b.g.d> r0 = r5.m     // Catch:{ all -> 0x00a2 }
            r0.clear()     // Catch:{ all -> 0x00a2 }
            java.util.concurrent.Future<?> r0 = r5.f1810d     // Catch:{ all -> 0x00a2 }
            r2 = 0
            if (r0 == 0) goto L_0x004c
            r0.cancel(r1)     // Catch:{ all -> 0x00a2 }
            r5.f1810d = r2     // Catch:{ all -> 0x00a2 }
            r3 = 0
            r5.f1811e = r3     // Catch:{ all -> 0x00a2 }
        L_0x004c:
            r5.h = r1     // Catch:{ all -> 0x00a2 }
            android.os.PowerManager$WakeLock r0 = r5.f1808b     // Catch:{ all -> 0x00a2 }
            boolean r0 = r0.isHeld()     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x008f
            android.os.PowerManager$WakeLock r0 = r5.f1808b     // Catch:{ RuntimeException -> 0x0064 }
            r0.release()     // Catch:{ RuntimeException -> 0x0064 }
            c.d.a.b.e.f.b r0 = r5.i     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x00a0
        L_0x005f:
            r5.i = r2     // Catch:{ all -> 0x00a2 }
            goto L_0x00a0
        L_0x0062:
            r0 = move-exception
            goto L_0x0088
        L_0x0064:
            r0 = move-exception
            java.lang.Class r1 = r0.getClass()     // Catch:{ all -> 0x0062 }
            java.lang.Class<java.lang.RuntimeException> r3 = java.lang.RuntimeException.class
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x0087
            java.lang.String r1 = "WakeLock"
            java.lang.String r3 = r5.l     // Catch:{ all -> 0x0062 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = " failed to release!"
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x0062 }
            android.util.Log.e(r1, r3, r0)     // Catch:{ all -> 0x0062 }
            c.d.a.b.e.f.b r0 = r5.i     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x00a0
            goto L_0x005f
        L_0x0087:
            throw r0     // Catch:{ all -> 0x0062 }
        L_0x0088:
            c.d.a.b.e.f.b r1 = r5.i     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x008e
            r5.i = r2     // Catch:{ all -> 0x00a2 }
        L_0x008e:
            throw r0     // Catch:{ all -> 0x00a2 }
        L_0x008f:
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r5.l     // Catch:{ all -> 0x00a2 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = " should be held!"
            java.lang.String r1 = r1.concat(r2)     // Catch:{ all -> 0x00a2 }
            android.util.Log.e(r0, r1)     // Catch:{ all -> 0x00a2 }
        L_0x00a0:
            monitor-exit(r6)     // Catch:{ all -> 0x00a2 }
            return
        L_0x00a2:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00a2 }
            goto L_0x00a6
        L_0x00a5:
            throw r0
        L_0x00a6:
            goto L_0x00a5
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.g.a.h(int):void");
    }

    private static void i(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
            Log.wtf("WakeLock", e2.toString());
        }
    }

    public void a(long j2) {
        this.n.incrementAndGet();
        long j3 = Long.MAX_VALUE;
        long max = Math.max(Math.min(Long.MAX_VALUE, p), 1);
        if (j2 > 0) {
            max = Math.min(j2, max);
        }
        synchronized (this.f1807a) {
            if (!b()) {
                this.i = b.c(false, (c) null);
                this.f1808b.acquire();
                this.j.b();
            }
            this.f1809c++;
            this.h++;
            f((String) null);
            d dVar = this.m.get((Object) null);
            if (dVar == null) {
                dVar = new d((c) null);
                this.m.put((Object) null, dVar);
            }
            dVar.f1813a++;
            long b2 = this.j.b();
            if (Long.MAX_VALUE - b2 > max) {
                j3 = b2 + max;
            }
            if (j3 > this.f1811e) {
                this.f1811e = j3;
                Future<?> future = this.f1810d;
                if (future != null) {
                    future.cancel(false);
                }
                this.f1810d = this.o.schedule(new b(this), max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this.f1807a) {
            z = this.f1809c > 0;
        }
        return z;
    }

    public void c() {
        if (this.n.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.l).concat(" release without a matched acquire!"));
        }
        synchronized (this.f1807a) {
            f((String) null);
            if (this.m.containsKey((Object) null)) {
                d dVar = this.m.get((Object) null);
                if (dVar != null) {
                    int i2 = dVar.f1813a - 1;
                    dVar.f1813a = i2;
                    if (i2 == 0) {
                        this.m.remove((Object) null);
                    }
                }
            } else {
                Log.w("WakeLock", String.valueOf(this.l).concat(" counter does not exist"));
            }
            h(0);
        }
    }

    public void d(boolean z) {
        synchronized (this.f1807a) {
            this.g = z;
        }
    }
}
