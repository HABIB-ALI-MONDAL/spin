package c.d.a.b.e.e;

import android.os.Bundle;
import com.google.android.gms.common.internal.n;

final class f2 extends j2 {
    final /* synthetic */ String n;
    final /* synthetic */ b1 o;
    final /* synthetic */ t2 p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    f2(t2 t2Var, String str, b1 b1Var) {
        super(t2Var, true);
        this.p = t2Var;
        this.n = str;
        this.o = b1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        f1 p2 = this.p.g;
        n.i(p2);
        p2.getMaxUserProperties(this.n, this.o);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.o.x((Bundle) null);
    }
}
