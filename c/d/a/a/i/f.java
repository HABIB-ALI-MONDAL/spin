package c.d.a.a.i;

import android.content.Context;
import c.d.a.a.i.a0.c;
import c.d.a.a.i.a0.g;
import c.d.a.a.i.a0.i;
import c.d.a.a.i.a0.j.j0;
import c.d.a.a.i.a0.j.m0;
import c.d.a.a.i.a0.j.n0;
import c.d.a.a.i.a0.j.o0;
import c.d.a.a.i.a0.j.p0;
import c.d.a.a.i.a0.j.r0;
import c.d.a.a.i.a0.j.s0;
import c.d.a.a.i.a0.j.u0;
import c.d.a.a.i.u;
import c.d.a.a.i.w.a.d;
import com.google.android.datatransport.runtime.backends.j;
import com.google.android.datatransport.runtime.backends.l;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.u;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.v;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.w;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.x;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.y;
import java.util.concurrent.Executor;

final class f extends u {
    private d.a.a<Executor> j;
    private d.a.a<Context> k;
    private d.a.a l;
    private d.a.a m;
    private d.a.a n;
    private d.a.a<String> o;
    private d.a.a<r0> p;
    private d.a.a<t> q;
    private d.a.a<y> r;
    private d.a.a<c> s;
    private d.a.a<u> t;
    private d.a.a<w> u;
    private d.a.a<t> v;

    private static final class b implements u.a {

        /* renamed from: a  reason: collision with root package name */
        private Context f1453a;

        private b() {
        }

        public u a() {
            d.a(this.f1453a, Context.class);
            return new f(this.f1453a);
        }

        public /* bridge */ /* synthetic */ u.a b(Context context) {
            c(context);
            return this;
        }

        public b c(Context context) {
            d.b(context);
            this.f1453a = context;
            return this;
        }
    }

    private f(Context context) {
        i(context);
    }

    public static u.a h() {
        return new b();
    }

    private void i(Context context) {
        this.j = c.d.a.a.i.w.a.a.a(l.a());
        c.d.a.a.i.w.a.b a2 = c.d.a.a.i.w.a.c.a(context);
        this.k = a2;
        j a3 = j.a(a2, c.d.a.a.i.c0.c.a(), c.d.a.a.i.c0.d.a());
        this.l = a3;
        this.m = c.d.a.a.i.w.a.a.a(l.a(this.k, a3));
        this.n = u0.a(this.k, m0.a(), o0.a());
        this.o = c.d.a.a.i.w.a.a.a(n0.a(this.k));
        this.p = c.d.a.a.i.w.a.a.a(s0.a(c.d.a.a.i.c0.c.a(), c.d.a.a.i.c0.d.a(), p0.a(), this.n, this.o));
        g b2 = g.b(c.d.a.a.i.c0.c.a());
        this.q = b2;
        i a4 = i.a(this.k, this.p, b2, c.d.a.a.i.c0.d.a());
        this.r = a4;
        d.a.a<Executor> aVar = this.j;
        d.a.a aVar2 = this.m;
        d.a.a<r0> aVar3 = this.p;
        this.s = c.d.a.a.i.a0.d.a(aVar, aVar2, a4, aVar3, aVar3);
        d.a.a<Context> aVar4 = this.k;
        d.a.a aVar5 = this.m;
        d.a.a<r0> aVar6 = this.p;
        this.t = v.a(aVar4, aVar5, aVar6, this.r, this.j, aVar6, c.d.a.a.i.c0.c.a(), c.d.a.a.i.c0.d.a(), this.p);
        d.a.a<Executor> aVar7 = this.j;
        d.a.a<r0> aVar8 = this.p;
        this.u = x.a(aVar7, aVar8, this.r, aVar8);
        this.v = c.d.a.a.i.w.a.a.a(v.a(c.d.a.a.i.c0.c.a(), c.d.a.a.i.c0.d.a(), this.s, this.t, this.u));
    }

    /* access modifiers changed from: package-private */
    public j0 c() {
        return this.p.get();
    }

    /* access modifiers changed from: package-private */
    public t f() {
        return this.v.get();
    }
}
