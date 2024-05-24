package c.d.a.b.e.e;

final class i9 extends l9 {
    /* synthetic */ i9(h9 h9Var) {
        super((j9) null);
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j) {
        ((x8) kb.k(obj, j)).b();
    }

    /* access modifiers changed from: package-private */
    public final void b(Object obj, Object obj2, long j) {
        x8 x8Var = (x8) kb.k(obj, j);
        x8 x8Var2 = (x8) kb.k(obj2, j);
        int size = x8Var.size();
        int size2 = x8Var2.size();
        if (size > 0 && size2 > 0) {
            if (!x8Var.c()) {
                x8Var = x8Var.h(size2 + size);
            }
            x8Var.addAll(x8Var2);
        }
        if (size > 0) {
            x8Var2 = x8Var;
        }
        kb.x(obj, j, x8Var2);
    }
}
