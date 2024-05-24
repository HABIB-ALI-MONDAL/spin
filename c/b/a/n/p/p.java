package c.b.a.n.p;

import b.d.j.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private final r f1082a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1083b;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, C0050a<?>> f1084a = new HashMap();

        /* renamed from: c.b.a.n.p.p$a$a  reason: collision with other inner class name */
        private static class C0050a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<n<Model, ?>> f1085a;

            public C0050a(List<n<Model, ?>> list) {
                this.f1085a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f1084a.clear();
        }

        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0050a aVar = this.f1084a.get(cls);
            if (aVar == null) {
                return null;
            }
            return aVar.f1085a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f1084a.put(cls, new C0050a(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public p(d<List<Throwable>> dVar) {
        this(new r(dVar));
    }

    private p(r rVar) {
        this.f1083b = new a();
        this.f1082a = rVar;
    }

    private static <A> Class<A> b(A a2) {
        return a2.getClass();
    }

    private <A> List<n<A, ?>> e(Class<A> cls) {
        List<n<A, ?>> b2 = this.f1083b.b(cls);
        if (b2 != null) {
            return b2;
        }
        List<n<A, ?>> unmodifiableList = Collections.unmodifiableList(this.f1082a.e(cls));
        this.f1083b.c(cls, unmodifiableList);
        return unmodifiableList;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.f1082a.b(cls, cls2, oVar);
        this.f1083b.a();
    }

    public synchronized List<Class<?>> c(Class<?> cls) {
        return this.f1082a.g(cls);
    }

    public synchronized <A> List<n<A, ?>> d(A a2) {
        ArrayList arrayList;
        List e2 = e(b(a2));
        int size = e2.size();
        arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            n nVar = (n) e2.get(i);
            if (nVar.b(a2)) {
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }
}
