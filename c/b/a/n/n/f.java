package c.b.a.n.n;

import c.b.a.n.n.e;
import c.b.a.t.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final e.a<?> f880b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f881a = new HashMap();

    class a implements e.a<Object> {
        a() {
        }

        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        public e<Object> b(Object obj) {
            return new b(obj);
        }
    }

    private static final class b implements e<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f882a;

        b(Object obj) {
            this.f882a = obj;
        }

        public Object a() {
            return this.f882a;
        }

        public void b() {
        }
    }

    public synchronized <T> e<T> a(T t) {
        e.a<?> aVar;
        h.d(t);
        aVar = this.f881a.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f881a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f880b;
        }
        return aVar.b(t);
    }

    public synchronized void b(e.a<?> aVar) {
        this.f881a.put(aVar.a(), aVar);
    }
}
