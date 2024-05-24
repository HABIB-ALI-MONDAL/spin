package c.d.a.b.e.e;

import c.d.a.b.d.b;
import com.google.android.gms.common.internal.n;

final class i2 extends j2 {
    final /* synthetic */ String n;
    final /* synthetic */ String o;
    final /* synthetic */ Object p;
    final /* synthetic */ boolean q;
    final /* synthetic */ t2 r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    i2(t2 t2Var, String str, String str2, Object obj, boolean z) {
        super(t2Var, true);
        this.r = t2Var;
        this.n = str;
        this.o = str2;
        this.p = obj;
        this.q = z;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        f1 p2 = this.r.g;
        n.i(p2);
        p2.setUserProperty(this.n, this.o, b.b0(this.p), this.q, this.j);
    }
}
