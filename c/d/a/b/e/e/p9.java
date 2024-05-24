package c.d.a.b.e.e;

final class p9 implements ja {

    /* renamed from: b  reason: collision with root package name */
    private static final v9 f1715b = new n9();

    /* renamed from: a  reason: collision with root package name */
    private final v9 f1716a;

    public p9() {
        v9 v9Var;
        v9[] v9VarArr = new v9[2];
        v9VarArr[0] = o8.c();
        try {
            v9Var = (v9) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            v9Var = f1715b;
        }
        v9VarArr[1] = v9Var;
        o9 o9Var = new o9(v9VarArr);
        y8.f(o9Var, "messageInfoFactory");
        this.f1716a = o9Var;
    }

    private static boolean b(u9 u9Var) {
        return u9Var.c() == 1;
    }

    public final ia a(Class cls) {
        s9 s9Var;
        f8 f8Var;
        ab abVar;
        l9 l9Var;
        ca caVar;
        f8 f8Var2;
        ab b0;
        f8 a2;
        Class<s8> cls2 = s8.class;
        ka.g(cls);
        u9 a3 = this.f1716a.a(cls);
        if (a3.b()) {
            if (cls2.isAssignableFrom(cls)) {
                b0 = ka.b();
                a2 = h8.b();
            } else {
                b0 = ka.b0();
                a2 = h8.a();
            }
            return ba.j(b0, a2, a3.a());
        }
        if (cls2.isAssignableFrom(cls)) {
            boolean b2 = b(a3);
            caVar = da.b();
            l9Var = l9.d();
            abVar = ka.b();
            f8Var = b2 ? h8.b() : null;
            s9Var = t9.b();
        } else {
            boolean b3 = b(a3);
            caVar = da.a();
            l9Var = l9.c();
            if (b3) {
                abVar = ka.b0();
                f8Var2 = h8.a();
            } else {
                abVar = ka.a();
                f8Var2 = null;
            }
            s9Var = t9.a();
        }
        return aa.L(cls, a3, caVar, l9Var, abVar, f8Var, s9Var);
    }
}
