package c.d.a.b.c;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import c.d.a.b.e.c.e;
import c.d.a.b.h.i;
import com.google.android.gms.common.util.p.a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class x {
    @GuardedBy("MessengerIpcClient.class")

    /* renamed from: e  reason: collision with root package name */
    private static x f1543e;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f1544a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f1545b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private r f1546c = new r(this, (q) null);
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private int f1547d = 1;

    x(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f1545b = scheduledExecutorService;
        this.f1544a = context.getApplicationContext();
    }

    public static synchronized x b(Context context) {
        x xVar;
        synchronized (x.class) {
            if (f1543e == null) {
                e.a();
                f1543e = new x(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new a("MessengerIpcClient"))));
            }
            xVar = f1543e;
        }
        return xVar;
    }

    private final synchronized int f() {
        int i;
        i = this.f1547d;
        this.f1547d = i + 1;
        return i;
    }

    private final synchronized <T> i<T> g(u<T> uVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(uVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.f1546c.g(uVar)) {
            r rVar = new r(this, (q) null);
            this.f1546c = rVar;
            rVar.g(uVar);
        }
        return uVar.f1540b.a();
    }

    public final i<Void> c(int i, Bundle bundle) {
        return g(new t(f(), 2, bundle));
    }

    public final i<Bundle> d(int i, Bundle bundle) {
        return g(new w(f(), 1, bundle));
    }
}
