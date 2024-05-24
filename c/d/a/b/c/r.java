package c.d.a.b.c;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import c.d.a.b.e.c.f;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.m.a;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

final class r implements ServiceConnection {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    int f1531a = 0;

    /* renamed from: b  reason: collision with root package name */
    final Messenger f1532b = new Messenger(new f(Looper.getMainLooper(), new k(this)));

    /* renamed from: c  reason: collision with root package name */
    s f1533c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    final Queue<u<?>> f1534d = new ArrayDeque();
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    final SparseArray<u<?>> f1535e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ x f1536f;

    /* synthetic */ r(x xVar, q qVar) {
        this.f1536f = xVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(int i, String str) {
        b(i, str, (Throwable) null);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(int i, String str, Throwable th) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i2 = this.f1531a;
        if (i2 == 0) {
            throw new IllegalStateException();
        } else if (i2 == 1 || i2 == 2) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f1531a = 4;
            a.b().c(this.f1536f.f1544a, this);
            v vVar = new v(i, str, th);
            for (u c2 : this.f1534d) {
                c2.c(vVar);
            }
            this.f1534d.clear();
            for (int i3 = 0; i3 < this.f1535e.size(); i3++) {
                this.f1535e.valueAt(i3).c(vVar);
            }
            this.f1535e.clear();
        } else if (i2 == 3) {
            this.f1531a = 4;
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f1536f.f1545b.execute(new m(this));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void d() {
        if (this.f1531a == 1) {
            a(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void e(int i) {
        u uVar = this.f1535e.get(i);
        if (uVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.f1535e.remove(i);
            uVar.c(new v(3, "Timed out waiting for response", (Throwable) null));
            f();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void f() {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.f1531a     // Catch:{ all -> 0x0039 }
            r1 = 2
            if (r0 != r1) goto L_0x0037
            java.util.Queue<c.d.a.b.c.u<?>> r0 = r2.f1534d     // Catch:{ all -> 0x0039 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0037
            android.util.SparseArray<c.d.a.b.c.u<?>> r0 = r2.f1535e     // Catch:{ all -> 0x0039 }
            int r0 = r0.size()     // Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x0037
            java.lang.String r0 = "MessengerIpcClient"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = "MessengerIpcClient"
            java.lang.String r1 = "Finished handling requests, unbinding"
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x0039 }
        L_0x0025:
            r0 = 3
            r2.f1531a = r0     // Catch:{ all -> 0x0039 }
            com.google.android.gms.common.m.a r0 = com.google.android.gms.common.m.a.b()     // Catch:{ all -> 0x0039 }
            c.d.a.b.c.x r1 = r2.f1536f     // Catch:{ all -> 0x0039 }
            android.content.Context r1 = r1.f1544a     // Catch:{ all -> 0x0039 }
            r0.c(r1, r2)     // Catch:{ all -> 0x0039 }
            monitor-exit(r2)
            return
        L_0x0037:
            monitor-exit(r2)
            return
        L_0x0039:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.c.r.f():void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean g(u<?> uVar) {
        int i = this.f1531a;
        if (i == 0) {
            this.f1534d.add(uVar);
            n.l(this.f1531a == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.f1531a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            try {
                if (!a.b().a(this.f1536f.f1544a, intent, this, 1)) {
                    a(0, "Unable to bind to service");
                } else {
                    this.f1536f.f1545b.schedule(new n(this), 30, TimeUnit.SECONDS);
                }
            } catch (SecurityException e2) {
                b(0, "Unable to bind to service", e2);
            }
        } else if (i == 1) {
            this.f1534d.add(uVar);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.f1534d.add(uVar);
            c();
            return true;
        }
        return true;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f1536f.f1545b.execute(new o(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f1536f.f1545b.execute(new l(this));
    }
}
