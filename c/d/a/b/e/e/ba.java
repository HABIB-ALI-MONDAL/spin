package c.d.a.b.e.e;

final class ba implements ia {

    /* renamed from: a  reason: collision with root package name */
    private final x9 f1586a;

    /* renamed from: b  reason: collision with root package name */
    private final ab f1587b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1588c;

    /* renamed from: d  reason: collision with root package name */
    private final f8 f1589d;

    private ba(ab abVar, f8 f8Var, x9 x9Var) {
        this.f1587b = abVar;
        this.f1588c = f8Var.c(x9Var);
        this.f1589d = f8Var;
        this.f1586a = x9Var;
    }

    static ba j(ab abVar, f8 f8Var, x9 x9Var) {
        return new ba(abVar, f8Var, x9Var);
    }

    public final void a(Object obj) {
        this.f1587b.g(obj);
        this.f1589d.b(obj);
    }

    public final int b(Object obj) {
        ab abVar = this.f1587b;
        int b2 = abVar.b(abVar.d(obj));
        if (!this.f1588c) {
            return b2;
        }
        this.f1589d.a(obj);
        throw null;
    }

    public final void c(Object obj, Object obj2) {
        ka.f(this.f1587b, obj, obj2);
        if (this.f1588c) {
            ka.e(this.f1589d, obj, obj2);
            throw null;
        }
    }

    public final boolean d(Object obj, Object obj2) {
        if (!this.f1587b.d(obj).equals(this.f1587b.d(obj2))) {
            return false;
        }
        if (!this.f1588c) {
            return true;
        }
        this.f1589d.a(obj);
        this.f1589d.a(obj2);
        throw null;
    }

    public final Object e() {
        x9 x9Var = this.f1586a;
        return x9Var instanceof s8 ? ((s8) x9Var).m() : x9Var.g().f();
    }

    public final void f(Object obj, tb tbVar) {
        this.f1589d.a(obj);
        throw null;
    }

    public final boolean g(Object obj) {
        this.f1589d.a(obj);
        throw null;
    }

    public final void h(Object obj, byte[] bArr, int i, int i2, g7 g7Var) {
        s8 s8Var = (s8) obj;
        if (s8Var.zzc == bb.c()) {
            s8Var.zzc = bb.f();
        }
        q8 q8Var = (q8) obj;
        throw null;
    }

    public final int i(Object obj) {
        int hashCode = this.f1587b.d(obj).hashCode();
        if (!this.f1588c) {
            return hashCode;
        }
        this.f1589d.a(obj);
        throw null;
    }
}
