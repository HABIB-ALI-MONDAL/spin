package c.d.a.b.e.e;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import c.d.a.b.d.b;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.internal.q4;

final class t1 extends j2 {
    final /* synthetic */ String n;
    final /* synthetic */ String o;
    final /* synthetic */ Context p;
    final /* synthetic */ Bundle q;
    final /* synthetic */ t2 r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    t1(t2 t2Var, String str, String str2, Context context, Bundle bundle) {
        super(t2Var, true);
        this.r = t2Var;
        this.n = str;
        this.o = str2;
        this.p = context;
        this.q = bundle;
    }

    public final void a() {
        String str;
        String str2;
        String str3;
        try {
            if (this.r.l(this.n, this.o)) {
                String str4 = this.o;
                str2 = this.n;
                str = str4;
                str3 = this.r.f1746a;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            n.i(this.p);
            t2 t2Var = this.r;
            t2Var.g = t2Var.q(this.p, true);
            if (this.r.g == null) {
                Log.w(this.r.f1746a, "Failed to connect to measurement client.");
                return;
            }
            int a2 = DynamiteModule.a(this.p, ModuleDescriptor.MODULE_ID);
            int b2 = DynamiteModule.b(this.p, ModuleDescriptor.MODULE_ID);
            n1 n1Var = new n1(74029, (long) Math.max(a2, b2), b2 < a2, str3, str2, str, this.q, q4.a(this.p));
            f1 p2 = this.r.g;
            n.i(p2);
            p2.initialize(b.b0(this.p), n1Var, this.j);
        } catch (Exception e2) {
            this.r.i(e2, true, false);
        }
    }
}
