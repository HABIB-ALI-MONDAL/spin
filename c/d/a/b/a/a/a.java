package c.d.a.b.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import c.d.a.b.e.a.e;
import c.d.a.b.e.a.f;
import com.google.android.gms.common.g;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.n;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
public class a {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    com.google.android.gms.common.a f1507a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    f f1508b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    boolean f1509c;

    /* renamed from: d  reason: collision with root package name */
    final Object f1510d = new Object();
    @GuardedBy("mAutoDisconnectTaskLock")

    /* renamed from: e  reason: collision with root package name */
    c f1511e;
    @GuardedBy("this")

    /* renamed from: f  reason: collision with root package name */
    private final Context f1512f;
    final long g;

    /* renamed from: c.d.a.b.a.a.a$a  reason: collision with other inner class name */
    public static final class C0063a {

        /* renamed from: a  reason: collision with root package name */
        private final String f1513a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f1514b;

        @Deprecated
        public C0063a(String str, boolean z) {
            this.f1513a = str;
            this.f1514b = z;
        }

        public String a() {
            return this.f1513a;
        }

        public boolean b() {
            return this.f1514b;
        }

        public String toString() {
            String str = this.f1513a;
            boolean z = this.f1514b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    public a(Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        n.i(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f1512f = context;
        this.f1509c = false;
        this.g = j;
    }

    public static C0063a a(Context context) {
        a aVar = new a(context, -1, true, false);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            aVar.d(false);
            C0063a f2 = aVar.f(-1);
            aVar.e(f2, true, 0.0f, SystemClock.elapsedRealtime() - elapsedRealtime, "", (Throwable) null);
            aVar.c();
            return f2;
        } catch (Throwable th) {
            aVar.c();
            throw th;
        }
    }

    public static void b(boolean z) {
    }

    private final C0063a f(int i) {
        C0063a aVar;
        n.h("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f1509c) {
                synchronized (this.f1510d) {
                    c cVar = this.f1511e;
                    if (cVar == null || !cVar.m) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    d(false);
                    if (!this.f1509c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e2) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                    throw new IOException("Remote exception");
                } catch (Exception e3) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e3);
                }
            }
            n.i(this.f1507a);
            n.i(this.f1508b);
            aVar = new C0063a(this.f1508b.c(), this.f1508b.L(true));
        }
        g();
        return aVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(3:5|6|7)|8|9|(1:11)|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void g() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f1510d
            monitor-enter(r0)
            c.d.a.b.a.a.c r1 = r6.f1511e     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0011
            java.util.concurrent.CountDownLatch r1 = r1.l     // Catch:{ all -> 0x0022 }
            r1.countDown()     // Catch:{ all -> 0x0022 }
            c.d.a.b.a.a.c r1 = r6.f1511e     // Catch:{ InterruptedException -> 0x0011 }
            r1.join()     // Catch:{ InterruptedException -> 0x0011 }
        L_0x0011:
            long r1 = r6.g     // Catch:{ all -> 0x0022 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0020
            c.d.a.b.a.a.c r3 = new c.d.a.b.a.a.c     // Catch:{ all -> 0x0022 }
            r3.<init>(r6, r1)     // Catch:{ all -> 0x0022 }
            r6.f1511e = r3     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return
        L_0x0022:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.a.a.a.g():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.n.h(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.f1512f     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.common.a r0 = r3.f1507a     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x000f
            goto L_0x0031
        L_0x000f:
            boolean r0 = r3.f1509c     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0027
            com.google.android.gms.common.m.a r0 = com.google.android.gms.common.m.a.b()     // Catch:{ all -> 0x001f }
            android.content.Context r1 = r3.f1512f     // Catch:{ all -> 0x001f }
            com.google.android.gms.common.a r2 = r3.f1507a     // Catch:{ all -> 0x001f }
            r0.c(r1, r2)     // Catch:{ all -> 0x001f }
            goto L_0x0027
        L_0x001f:
            r0 = move-exception
            java.lang.String r1 = "AdvertisingIdClient"
            java.lang.String r2 = "AdvertisingIdClient unbindService failed."
            android.util.Log.i(r1, r2, r0)     // Catch:{ all -> 0x0033 }
        L_0x0027:
            r0 = 0
            r3.f1509c = r0     // Catch:{ all -> 0x0033 }
            r0 = 0
            r3.f1508b = r0     // Catch:{ all -> 0x0033 }
            r3.f1507a = r0     // Catch:{ all -> 0x0033 }
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return
        L_0x0031:
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return
        L_0x0033:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.a.a.a.c():void");
    }

    /* access modifiers changed from: protected */
    public final void d(boolean z) {
        n.h("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f1509c) {
                c();
            }
            Context context = this.f1512f;
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                int h = com.google.android.gms.common.f.f().h(context, i.f2162a);
                if (h != 0) {
                    if (h != 2) {
                        throw new IOException("Google Play services not available");
                    }
                }
                com.google.android.gms.common.a aVar = new com.google.android.gms.common.a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (com.google.android.gms.common.m.a.b().a(context, intent, aVar, 1)) {
                    this.f1507a = aVar;
                    this.f1508b = e.h(aVar.a(10000, TimeUnit.MILLISECONDS));
                    this.f1509c = true;
                    if (z) {
                        g();
                    }
                } else {
                    throw new IOException("Connection failure");
                }
            } catch (PackageManager.NameNotFoundException unused) {
                throw new g(9);
            } catch (InterruptedException unused2) {
                throw new IOException("Interrupted exception");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean e(C0063a aVar, boolean z, float f2, long j, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String str2 = "1";
        hashMap.put("app_context", str2);
        if (aVar != null) {
            if (true != aVar.b()) {
                str2 = "0";
            }
            hashMap.put("limit_ad_tracking", str2);
            String a2 = aVar.a();
            if (a2 != null) {
                hashMap.put("ad_id_size", Integer.toString(a2.length()));
            }
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new b(this, hashMap).start();
        return true;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        c();
        super.finalize();
    }
}
