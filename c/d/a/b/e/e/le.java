package c.d.a.b.e.e;

import java.util.List;
import java.util.concurrent.Callable;

public final class le extends j {
    private final Callable l;

    public le(String str, Callable callable) {
        super("internal.appMetadata");
        this.l = callable;
    }

    public final q a(n4 n4Var, List list) {
        try {
            return o6.b(this.l.call());
        } catch (Exception unused) {
            return q.f1722b;
        }
    }
}
