package c.d.a.b.e.e;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

public final class b1 extends h1 {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference f1581a = new AtomicReference();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1582b;

    public static final Object c0(Bundle bundle, Class cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get("r")) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e2) {
            Log.w("AM", String.format("Unexpected object type. Expected, Received: %s, %s", new Object[]{cls.getCanonicalName(), obj.getClass().getCanonicalName()}), e2);
            throw e2;
        }
    }

    public final String b0(long j) {
        return (String) c0(i(j), String.class);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle i(long r3) {
        /*
            r2 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r2.f1581a
            monitor-enter(r0)
            boolean r1 = r2.f1582b     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0010
            java.util.concurrent.atomic.AtomicReference r1 = r2.f1581a     // Catch:{ InterruptedException -> 0x000d }
            r1.wait(r3)     // Catch:{ InterruptedException -> 0x000d }
            goto L_0x0010
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            r3 = 0
            return r3
        L_0x0010:
            java.util.concurrent.atomic.AtomicReference r3 = r2.f1581a     // Catch:{ all -> 0x001a }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x001a }
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch:{ all -> 0x001a }
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return r3
        L_0x001a:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.b1.i(long):android.os.Bundle");
    }

    public final Long k(long j) {
        return (Long) c0(i(j), Long.class);
    }

    public final void x(Bundle bundle) {
        synchronized (this.f1581a) {
            try {
                this.f1581a.set(bundle);
                this.f1582b = true;
                this.f1581a.notify();
            } catch (Throwable th) {
                this.f1581a.notify();
                throw th;
            }
        }
    }
}
