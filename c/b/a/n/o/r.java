package c.b.a.n.o;

import c.b.a.n.h;
import java.util.HashMap;
import java.util.Map;

final class r {

    /* renamed from: a  reason: collision with root package name */
    private final Map<h, k<?>> f1000a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<h, k<?>> f1001b = new HashMap();

    r() {
    }

    private Map<h, k<?>> b(boolean z) {
        return z ? this.f1001b : this.f1000a;
    }

    /* access modifiers changed from: package-private */
    public k<?> a(h hVar, boolean z) {
        return b(z).get(hVar);
    }

    /* access modifiers changed from: package-private */
    public void c(h hVar, k<?> kVar) {
        b(kVar.n()).put(hVar, kVar);
    }

    /* access modifiers changed from: package-private */
    public void d(h hVar, k<?> kVar) {
        Map<h, k<?>> b2 = b(kVar.n());
        if (kVar.equals(b2.get(hVar))) {
            b2.remove(hVar);
        }
    }
}
