package c.d.a.b.e.e;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class fa {

    /* renamed from: c  reason: collision with root package name */
    private static final fa f1632c = new fa();

    /* renamed from: a  reason: collision with root package name */
    private final ja f1633a = new p9();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap f1634b = new ConcurrentHashMap();

    private fa() {
    }

    public static fa a() {
        return f1632c;
    }

    public final ia b(Class cls) {
        y8.f(cls, "messageType");
        ia iaVar = (ia) this.f1634b.get(cls);
        if (iaVar == null) {
            iaVar = this.f1633a.a(cls);
            y8.f(cls, "messageType");
            y8.f(iaVar, "schema");
            ia iaVar2 = (ia) this.f1634b.putIfAbsent(cls, iaVar);
            return iaVar2 == null ? iaVar : iaVar2;
        }
    }
}
