package c.b.a.q;

import c.b.a.n.l;
import java.util.ArrayList;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f1253a = new ArrayList();

    private static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f1254a;

        /* renamed from: b  reason: collision with root package name */
        final l<T> f1255b;

        a(Class<T> cls, l<T> lVar) {
            this.f1254a = cls;
            this.f1255b = lVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Class<?> cls) {
            return this.f1254a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, l<Z> lVar) {
        this.f1253a.add(new a(cls, lVar));
    }

    public synchronized <Z> l<Z> b(Class<Z> cls) {
        int size = this.f1253a.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f1253a.get(i);
            if (aVar.a(cls)) {
                return aVar.f1255b;
            }
        }
        return null;
    }
}
