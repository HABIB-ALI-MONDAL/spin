package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final c n = new c();
    private final AtomicBoolean j = new AtomicBoolean();
    private final AtomicBoolean k = new AtomicBoolean();
    @GuardedBy("sInstance")
    private final ArrayList l = new ArrayList();
    @GuardedBy("sInstance")
    private boolean m = false;

    public interface a {
        void a(boolean z);
    }

    private c() {
    }

    public static c b() {
        return n;
    }

    public static void c(Application application) {
        c cVar = n;
        synchronized (cVar) {
            if (!cVar.m) {
                application.registerActivityLifecycleCallbacks(cVar);
                application.registerComponentCallbacks(cVar);
                cVar.m = true;
            }
        }
    }

    private final void f(boolean z) {
        synchronized (n) {
            Iterator it = this.l.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(z);
            }
        }
    }

    public void a(a aVar) {
        synchronized (n) {
            this.l.add(aVar);
        }
    }

    public boolean d() {
        return this.j.get();
    }

    @TargetApi(16)
    public boolean e(boolean z) {
        if (!this.k.get()) {
            if (!k.b()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.k.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.j.set(true);
            }
        }
        return d();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.j.compareAndSet(true, false);
        this.k.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.j.compareAndSet(true, false);
        this.k.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.j.compareAndSet(false, true)) {
            this.k.set(true);
            f(true);
        }
    }
}
