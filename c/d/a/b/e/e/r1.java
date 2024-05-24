package c.d.a.b.e.e;

import android.os.Bundle;
import com.google.android.gms.common.internal.n;

final class r1 extends j2 {
    final /* synthetic */ String n;
    final /* synthetic */ String o;
    final /* synthetic */ b1 p;
    final /* synthetic */ t2 q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    r1(t2 t2Var, String str, String str2, b1 b1Var) {
        super(t2Var, true);
        this.q = t2Var;
        this.n = str;
        this.o = str2;
        this.p = b1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        f1 p2 = this.q.g;
        n.i(p2);
        p2.getConditionalUserProperties(this.n, this.o, this.p);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.p.x((Bundle) null);
    }
}
