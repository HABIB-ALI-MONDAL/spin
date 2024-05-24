package c.d.a.b.e.e;

import android.os.Bundle;
import com.google.android.gms.common.internal.n;

final class h2 extends j2 {
    final /* synthetic */ Long n;
    final /* synthetic */ String o;
    final /* synthetic */ String p;
    final /* synthetic */ Bundle q;
    final /* synthetic */ boolean r;
    final /* synthetic */ boolean s;
    final /* synthetic */ t2 t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    h2(t2 t2Var, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(t2Var, true);
        this.t = t2Var;
        this.n = l;
        this.o = str;
        this.p = str2;
        this.q = bundle;
        this.r = z;
        this.s = z2;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Long l = this.n;
        long longValue = l == null ? this.j : l.longValue();
        f1 p2 = this.t.g;
        n.i(p2);
        p2.logEvent(this.o, this.p, this.q, this.r, this.s, longValue);
    }
}
