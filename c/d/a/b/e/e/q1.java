package c.d.a.b.e.e;

import android.os.Bundle;
import com.google.android.gms.common.internal.n;

final class q1 extends j2 {
    final /* synthetic */ String n;
    final /* synthetic */ String o;
    final /* synthetic */ Bundle p;
    final /* synthetic */ t2 q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q1(t2 t2Var, String str, String str2, Bundle bundle) {
        super(t2Var, true);
        this.q = t2Var;
        this.n = str;
        this.o = str2;
        this.p = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        f1 p2 = this.q.g;
        n.i(p2);
        p2.clearConditionalUserProperty(this.n, this.o, this.p);
    }
}
