package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class je extends j {
    final boolean l;
    final boolean m;
    final /* synthetic */ ke n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public je(ke keVar, boolean z, boolean z2) {
        super("log");
        this.n = keVar;
        this.l = z;
        this.m = z2;
    }

    public final q a(n4 n4Var, List list) {
        List arrayList;
        ie c2;
        n5.i("log", 1, list);
        if (list.size() == 1) {
            this.n.l.a(3, n4Var.b((q) list.get(0)).g(), Collections.emptyList(), this.l, this.m);
        } else {
            int b2 = n5.b(n4Var.b((q) list.get(0)).f().doubleValue());
            int i = b2 != 2 ? b2 != 3 ? b2 != 5 ? b2 != 6 ? 3 : 2 : 5 : 1 : 4;
            String g = n4Var.b((q) list.get(1)).g();
            if (list.size() == 2) {
                c2 = this.n.l;
                arrayList = Collections.emptyList();
            } else {
                arrayList = new ArrayList();
                for (int i2 = 2; i2 < Math.min(list.size(), 5); i2++) {
                    arrayList.add(n4Var.b((q) list.get(i2)).g());
                }
                c2 = this.n.l;
            }
            c2.a(i, g, arrayList, this.l, this.m);
        }
        return q.f1722b;
    }
}
