package c.d.a.b.e.e;

final class o9 implements v9 {

    /* renamed from: a  reason: collision with root package name */
    private final v9[] f1712a;

    o9(v9... v9VarArr) {
        this.f1712a = v9VarArr;
    }

    public final u9 a(Class cls) {
        v9[] v9VarArr = this.f1712a;
        for (int i = 0; i < 2; i++) {
            v9 v9Var = v9VarArr[i];
            if (v9Var.b(cls)) {
                return v9Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean b(Class cls) {
        v9[] v9VarArr = this.f1712a;
        for (int i = 0; i < 2; i++) {
            if (v9VarArr[i].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
