package c.d.a.b.e.e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class s2 implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ t2 j;

    s2(t2 t2Var) {
        this.j = t2Var;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.j.k(new k2(this, bundle, activity));
    }

    public final void onActivityDestroyed(Activity activity) {
        this.j.k(new r2(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        this.j.k(new o2(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        this.j.k(new m2(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        b1 b1Var = new b1();
        this.j.k(new q2(this, activity, b1Var));
        Bundle i = b1Var.i(50);
        if (i != null) {
            bundle.putAll(i);
        }
    }

    public final void onActivityStarted(Activity activity) {
        this.j.k(new l2(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        this.j.k(new p2(this, activity));
    }
}
