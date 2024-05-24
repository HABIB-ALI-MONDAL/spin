package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class p extends j implements m {
    protected final List l;
    protected final List m;
    protected n4 n;

    private p(p pVar) {
        super(pVar.j);
        ArrayList arrayList = new ArrayList(pVar.l.size());
        this.l = arrayList;
        arrayList.addAll(pVar.l);
        ArrayList arrayList2 = new ArrayList(pVar.m.size());
        this.m = arrayList2;
        arrayList2.addAll(pVar.m);
        this.n = pVar.n;
    }

    public p(String str, List list, List list2, n4 n4Var) {
        super(str);
        this.l = new ArrayList();
        this.n = n4Var;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.l.add(((q) it.next()).g());
            }
        }
        this.m = new ArrayList(list2);
    }

    public final q a(n4 n4Var, List list) {
        q qVar;
        String str;
        n4 a2 = this.n.a();
        for (int i = 0; i < this.l.size(); i++) {
            if (i < list.size()) {
                str = (String) this.l.get(i);
                qVar = n4Var.b((q) list.get(i));
            } else {
                str = (String) this.l.get(i);
                qVar = q.f1722b;
            }
            a2.e(str, qVar);
        }
        for (q qVar2 : this.m) {
            q b2 = a2.b(qVar2);
            if (b2 instanceof r) {
                b2 = a2.b(qVar2);
            }
            if (b2 instanceof h) {
                return ((h) b2).a();
            }
        }
        return q.f1722b;
    }

    public final q d() {
        return new p(this);
    }
}
