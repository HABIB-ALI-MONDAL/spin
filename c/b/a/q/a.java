package c.b.a.q;

import c.b.a.n.d;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C0054a<?>> f1239a = new ArrayList();

    /* renamed from: c.b.a.q.a$a  reason: collision with other inner class name */
    private static final class C0054a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f1240a;

        /* renamed from: b  reason: collision with root package name */
        final d<T> f1241b;

        C0054a(Class<T> cls, d<T> dVar) {
            this.f1240a = cls;
            this.f1241b = dVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Class<?> cls) {
            return this.f1240a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(Class<T> cls, d<T> dVar) {
        this.f1239a.add(new C0054a(cls, dVar));
    }

    public synchronized <T> d<T> b(Class<T> cls) {
        for (C0054a next : this.f1239a) {
            if (next.a(cls)) {
                return next.f1241b;
            }
        }
        return null;
    }
}
