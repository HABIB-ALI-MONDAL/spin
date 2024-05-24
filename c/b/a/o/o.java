package c.b.a.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import b.g.a.d;
import b.g.a.e;
import c.b.a.c;
import c.b.a.j;
import java.util.HashSet;
import java.util.Set;

public class o extends d {
    private final a h0;
    private final m i0;
    private final Set<o> j0;
    private o k0;
    private j l0;
    private d m0;

    private class a implements m {
        a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }

    public o() {
        this(new a());
    }

    @SuppressLint({"ValidFragment"})
    public o(a aVar) {
        this.i0 = new a();
        this.j0 = new HashSet();
        this.h0 = aVar;
    }

    private void j1(o oVar) {
        this.j0.add(oVar);
    }

    private d l1() {
        d A = A();
        return A != null ? A : this.m0;
    }

    private void o1(e eVar) {
        s1();
        o h = c.c(eVar).k().h(eVar.m(), (d) null);
        this.k0 = h;
        if (!equals(h)) {
            this.k0.j1(this);
        }
    }

    private void p1(o oVar) {
        this.j0.remove(oVar);
    }

    private void s1() {
        o oVar = this.k0;
        if (oVar != null) {
            oVar.p1(this);
            this.k0 = null;
        }
    }

    public void V(Context context) {
        super.V(context);
        try {
            o1(k());
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    public void d0() {
        super.d0();
        this.h0.c();
        s1();
    }

    public void g0() {
        super.g0();
        this.m0 = null;
        s1();
    }

    /* access modifiers changed from: package-private */
    public a k1() {
        return this.h0;
    }

    public j m1() {
        return this.l0;
    }

    public m n1() {
        return this.i0;
    }

    /* access modifiers changed from: package-private */
    public void q1(d dVar) {
        this.m0 = dVar;
        if (dVar != null && dVar.k() != null) {
            o1(dVar.k());
        }
    }

    public void r1(j jVar) {
        this.l0 = jVar;
    }

    public String toString() {
        return super.toString() + "{parent=" + l1() + "}";
    }

    public void u0() {
        super.u0();
        this.h0.d();
    }

    public void v0() {
        super.v0();
        this.h0.e();
    }
}
