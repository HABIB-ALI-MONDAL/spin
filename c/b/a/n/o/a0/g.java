package c.b.a.n.o.a0;

import android.annotation.SuppressLint;
import c.b.a.n.h;
import c.b.a.n.o.a0.h;
import c.b.a.n.o.u;
import c.b.a.t.e;

public class g extends e<h, u<?>> implements h {

    /* renamed from: d  reason: collision with root package name */
    private h.a f919d;

    public g(long j) {
        super(j);
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 40) {
            b();
        } else if (i >= 20) {
            m(h() / 2);
        }
    }

    public /* bridge */ /* synthetic */ u c(c.b.a.n.h hVar, u uVar) {
        return (u) super.k(hVar, uVar);
    }

    public /* bridge */ /* synthetic */ u d(c.b.a.n.h hVar) {
        return (u) super.l(hVar);
    }

    public void e(h.a aVar) {
        this.f919d = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public int i(u<?> uVar) {
        return uVar == null ? super.i(null) : uVar.c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void j(c.b.a.n.h hVar, u<?> uVar) {
        h.a aVar = this.f919d;
        if (aVar != null && uVar != null) {
            aVar.b(uVar);
        }
    }
}
