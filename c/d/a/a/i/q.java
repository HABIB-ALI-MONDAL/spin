package c.d.a.a.i;

import c.d.a.a.b;
import c.d.a.a.e;
import c.d.a.a.f;
import c.d.a.a.g;
import java.util.Set;

final class q implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f1459a;

    /* renamed from: b  reason: collision with root package name */
    private final p f1460b;

    /* renamed from: c  reason: collision with root package name */
    private final s f1461c;

    q(Set<b> set, p pVar, s sVar) {
        this.f1459a = set;
        this.f1460b = pVar;
        this.f1461c = sVar;
    }

    public <T> f<T> a(String str, Class<T> cls, b bVar, e<T, byte[]> eVar) {
        if (this.f1459a.contains(bVar)) {
            return new r(this.f1460b, str, bVar, eVar, this.f1461c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{bVar, this.f1459a}));
    }
}
