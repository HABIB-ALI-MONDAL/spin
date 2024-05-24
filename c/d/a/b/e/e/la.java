package c.d.a.b.e.e;

import java.util.List;

final class la extends j {
    final /* synthetic */ nc l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    la(mb mbVar, String str, nc ncVar) {
        super("getValue");
        this.l = ncVar;
    }

    public final q a(n4 n4Var, List list) {
        n5.h("getValue", 2, list);
        q b2 = n4Var.b((q) list.get(0));
        q b3 = n4Var.b((q) list.get(1));
        String a2 = this.l.a(b2.g());
        return a2 != null ? new u(a2) : b3;
    }
}
