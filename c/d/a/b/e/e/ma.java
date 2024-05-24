package c.d.a.b.e.e;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class ma extends wa {
    ma(int i) {
        super(i, (va) null);
    }

    public final void a() {
        if (!j()) {
            for (int i = 0; i < b(); i++) {
                Map.Entry g = g(i);
                if (((i8) g.getKey()).c()) {
                    g.setValue(Collections.unmodifiableList((List) g.getValue()));
                }
            }
            for (Map.Entry entry : c()) {
                if (((i8) entry.getKey()).c()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
