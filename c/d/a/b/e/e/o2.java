package c.d.a.b.e.e;

import android.app.Activity;
import c.d.a.b.d.b;
import com.google.android.gms.common.internal.n;

final class o2 extends j2 {
    final /* synthetic */ Activity n;
    final /* synthetic */ s2 o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    o2(s2 s2Var, Activity activity) {
        super(s2Var.j, true);
        this.o = s2Var;
        this.n = activity;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        f1 p = this.o.j.g;
        n.i(p);
        p.onActivityPaused(b.b0(this.n), this.k);
    }
}
