package c.d.a.b.e.e;

import android.app.Activity;
import android.os.Bundle;
import c.d.a.b.d.b;
import com.google.android.gms.common.internal.n;

final class k2 extends j2 {
    final /* synthetic */ Bundle n;
    final /* synthetic */ Activity o;
    final /* synthetic */ s2 p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k2(s2 s2Var, Bundle bundle, Activity activity) {
        super(s2Var.j, true);
        this.p = s2Var;
        this.n = bundle;
        this.o = activity;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Bundle bundle;
        if (this.n != null) {
            bundle = new Bundle();
            if (this.n.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.n.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        f1 p2 = this.p.j.g;
        n.i(p2);
        p2.onActivityCreated(b.b0(this.o), bundle, this.k);
    }
}
