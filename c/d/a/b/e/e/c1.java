package c.d.a.b.e.e;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public final class c1 {

    /* renamed from: a  reason: collision with root package name */
    final m3 f1602a;

    /* renamed from: b  reason: collision with root package name */
    n4 f1603b;

    /* renamed from: c  reason: collision with root package name */
    final c f1604c = new c();

    /* renamed from: d  reason: collision with root package name */
    private final qe f1605d = new qe();

    public c1() {
        m3 m3Var = new m3();
        this.f1602a = m3Var;
        this.f1603b = m3Var.f1682b.a();
        m3Var.f1684d.a("internal.registerCallback", new a(this));
        m3Var.f1684d.a("internal.eventLogger", new b0(this));
    }

    public final c a() {
        return this.f1604c;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ j b() {
        return new me(this.f1605d);
    }

    public final void c(h5 h5Var) {
        j jVar;
        try {
            this.f1603b = this.f1602a.f1682b.a();
            if (!(this.f1602a.a(this.f1603b, (l5[]) h5Var.G().toArray(new l5[0])) instanceof h)) {
                for (f5 f5Var : h5Var.E().H()) {
                    List G = f5Var.G();
                    String F = f5Var.F();
                    Iterator it = G.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            q a2 = this.f1602a.a(this.f1603b, (l5) it.next());
                            if (a2 instanceof n) {
                                n4 n4Var = this.f1603b;
                                if (!n4Var.h(F)) {
                                    jVar = null;
                                } else {
                                    q d2 = n4Var.d(F);
                                    if (d2 instanceof j) {
                                        jVar = (j) d2;
                                    } else {
                                        throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(F)));
                                    }
                                }
                                if (jVar != null) {
                                    jVar.a(this.f1603b, Collections.singletonList(a2));
                                } else {
                                    throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(F)));
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid rule definition");
                            }
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th) {
            throw new w1(th);
        }
    }

    public final void d(String str, Callable callable) {
        this.f1602a.f1684d.a(str, callable);
    }

    public final boolean e(b bVar) {
        try {
            this.f1604c.d(bVar);
            this.f1602a.f1683c.g("runtime.counter", new i(Double.valueOf(0.0d)));
            this.f1605d.b(this.f1603b.a(), this.f1604c);
            return g() || f();
        } catch (Throwable th) {
            throw new w1(th);
        }
    }

    public final boolean f() {
        return !this.f1604c.c().isEmpty();
    }

    public final boolean g() {
        c cVar = this.f1604c;
        return !cVar.b().equals(cVar.a());
    }
}
