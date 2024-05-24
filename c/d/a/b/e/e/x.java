package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.List;

public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    final List f1778a = new ArrayList();

    protected x() {
    }

    public abstract q a(String str, n4 n4Var, List list);

    /* access modifiers changed from: package-private */
    public final q b(String str) {
        if (this.f1778a.contains(n5.e(str))) {
            throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(str)));
        }
        throw new IllegalArgumentException("Command not supported");
    }
}
