package c.d.a.b.e.e;

import com.google.android.gms.common.internal.n;

final class g2 extends j2 {
    final /* synthetic */ boolean n;
    final /* synthetic */ t2 o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    g2(t2 t2Var, boolean z) {
        super(t2Var, true);
        this.o = t2Var;
        this.n = z;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        f1 p = this.o.g;
        n.i(p);
        p.setDataCollectionEnabled(this.n);
    }
}
