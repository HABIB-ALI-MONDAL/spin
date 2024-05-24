package c.d.a.b.e.e;

import c.d.a.b.d.b;
import com.google.android.gms.common.internal.n;

final class d2 extends j2 {
    final /* synthetic */ String n;
    final /* synthetic */ Object o;
    final /* synthetic */ t2 p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    d2(t2 t2Var, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(t2Var, false);
        this.p = t2Var;
        this.n = str;
        this.o = obj;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        f1 p2 = this.p.g;
        n.i(p2);
        p2.logHealthData(5, this.n, b.b0(this.o), b.b0(null), b.b0(null));
    }
}
