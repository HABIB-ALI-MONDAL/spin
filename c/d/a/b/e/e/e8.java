package c.d.a.b.e.e;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class e8 {

    /* renamed from: b  reason: collision with root package name */
    private static volatile e8 f1625b;

    /* renamed from: c  reason: collision with root package name */
    static final e8 f1626c = new e8(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map f1627a;

    e8() {
        this.f1627a = new HashMap();
    }

    e8(boolean z) {
        this.f1627a = Collections.emptyMap();
    }

    public static e8 a() {
        Class<e8> cls = e8.class;
        e8 e8Var = f1625b;
        if (e8Var != null) {
            return e8Var;
        }
        synchronized (cls) {
            e8 e8Var2 = f1625b;
            if (e8Var2 != null) {
                return e8Var2;
            }
            e8 b2 = m8.b(cls);
            f1625b = b2;
            return b2;
        }
    }

    public final r8 b(x9 x9Var, int i) {
        return (r8) this.f1627a.get(new d8(x9Var, i));
    }
}
