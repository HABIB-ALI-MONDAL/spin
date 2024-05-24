package c.d.a.b.e.e;

import android.app.Activity;
import c.d.a.b.d.b;
import com.google.android.gms.common.internal.n;

final class q2 extends j2 {
    final /* synthetic */ Activity n;
    final /* synthetic */ b1 o;
    final /* synthetic */ s2 p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q2(s2 s2Var, Activity activity, b1 b1Var) {
        super(s2Var.j, true);
        this.p = s2Var;
        this.n = activity;
        this.o = b1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        f1 p2 = this.p.j.g;
        n.i(p2);
        p2.onActivitySaveInstanceState(b.b0(this.n), this.o, this.k);
    }
}
