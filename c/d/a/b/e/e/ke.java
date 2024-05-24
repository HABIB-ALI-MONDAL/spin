package c.d.a.b.e.e;

import java.util.List;

public final class ke extends j {
    /* access modifiers changed from: private */
    public final ie l;

    public ke(ie ieVar) {
        super("internal.logger");
        this.l = ieVar;
        this.k.put("log", new je(this, false, true));
        this.k.put("silent", new od(this, "silent"));
        ((j) this.k.get("silent")).r("log", new je(this, true, true));
        this.k.put("unmonitored", new he(this, "unmonitored"));
        ((j) this.k.get("unmonitored")).r("log", new je(this, false, false));
    }

    public final q a(n4 n4Var, List list) {
        return q.f1722b;
    }
}
