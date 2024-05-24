package c.d.a.b.e.e;

import android.app.Activity;
import c.d.a.b.d.b;
import com.google.android.gms.common.internal.n;

final class s1 extends j2 {
    final /* synthetic */ Activity n;
    final /* synthetic */ String o;
    final /* synthetic */ String p;
    final /* synthetic */ t2 q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s1(t2 t2Var, Activity activity, String str, String str2) {
        super(t2Var, true);
        this.q = t2Var;
        this.n = activity;
        this.o = str;
        this.p = str2;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        f1 p2 = this.q.g;
        n.i(p2);
        p2.setCurrentScreen(b.b0(this.n), this.o, this.p, this.j);
    }
}
