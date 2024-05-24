package c.d.a.b.e.e;

public final class m3 {

    /* renamed from: a  reason: collision with root package name */
    final y f1681a;

    /* renamed from: b  reason: collision with root package name */
    final n4 f1682b;

    /* renamed from: c  reason: collision with root package name */
    final n4 f1683c;

    /* renamed from: d  reason: collision with root package name */
    final o7 f1684d;

    public m3() {
        y yVar = new y();
        this.f1681a = yVar;
        n4 n4Var = new n4((n4) null, yVar);
        this.f1683c = n4Var;
        this.f1682b = n4Var.a();
        o7 o7Var = new o7();
        this.f1684d = o7Var;
        n4Var.g("require", new ne(o7Var));
        o7Var.a("internal.platform", n2.f1693a);
        n4Var.g("runtime.counter", new i(Double.valueOf(0.0d)));
    }

    public final q a(n4 n4Var, l5... l5VarArr) {
        q qVar = q.f1722b;
        for (l5 a2 : l5VarArr) {
            qVar = o6.a(a2);
            n5.c(this.f1683c);
            if ((qVar instanceof r) || (qVar instanceof p)) {
                qVar = this.f1681a.a(n4Var, qVar);
            }
        }
        return qVar;
    }
}
