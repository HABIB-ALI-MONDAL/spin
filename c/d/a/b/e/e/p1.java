package c.d.a.b.e.e;

import android.os.Bundle;
import com.google.android.gms.common.internal.n;

final class p1 extends j2 {
    final /* synthetic */ Bundle n;
    final /* synthetic */ t2 o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p1(t2 t2Var, Bundle bundle) {
        super(t2Var, true);
        this.o = t2Var;
        this.n = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        f1 p = this.o.g;
        n.i(p);
        p.setConditionalUserProperty(this.n, this.j);
    }
}
