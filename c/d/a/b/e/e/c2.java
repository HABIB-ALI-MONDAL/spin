package c.d.a.b.e.e;

import android.os.Bundle;
import com.google.android.gms.common.internal.n;

final class c2 extends j2 {
    final /* synthetic */ String n;
    final /* synthetic */ String o;
    final /* synthetic */ boolean p;
    final /* synthetic */ b1 q;
    final /* synthetic */ t2 r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    c2(t2 t2Var, String str, String str2, boolean z, b1 b1Var) {
        super(t2Var, true);
        this.r = t2Var;
        this.n = str;
        this.o = str2;
        this.p = z;
        this.q = b1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        f1 p2 = this.r.g;
        n.i(p2);
        p2.getUserProperties(this.n, this.o, this.p, this.q);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.q.x((Bundle) null);
    }
}
