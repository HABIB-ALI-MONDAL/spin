package c.d.a.b.e.e;

final class cb extends ab {
    cb() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int a(Object obj) {
        return ((bb) obj).a();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int b(Object obj) {
        return ((bb) obj).b();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object c(Object obj) {
        s8 s8Var = (s8) obj;
        bb bbVar = s8Var.zzc;
        if (bbVar != bb.c()) {
            return bbVar;
        }
        bb f2 = bb.f();
        s8Var.zzc = f2;
        return f2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object d(Object obj) {
        return ((s8) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object e(Object obj, Object obj2) {
        if (bb.c().equals(obj2)) {
            return obj;
        }
        bb bbVar = (bb) obj2;
        if (bb.c().equals(obj)) {
            return bb.e((bb) obj, bbVar);
        }
        ((bb) obj).d(bbVar);
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void f(Object obj, int i, long j) {
        ((bb) obj).j(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final void g(Object obj) {
        ((s8) obj).zzc.h();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void h(Object obj, Object obj2) {
        ((s8) obj).zzc = (bb) obj2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void i(Object obj, tb tbVar) {
        ((bb) obj).k(tbVar);
    }
}
