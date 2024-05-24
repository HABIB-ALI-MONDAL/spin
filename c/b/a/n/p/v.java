package c.b.a.n.p;

import c.b.a.g;
import c.b.a.n.j;
import c.b.a.n.n.d;
import c.b.a.n.p.n;

public class v<Model> implements n<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final v<?> f1105a = new v<>();

    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final a<?> f1106a = new a<>();

        public static <T> a<T> a() {
            return f1106a;
        }

        public n<Model, Model> b(r rVar) {
            return v.c();
        }
    }

    private static class b<Model> implements d<Model> {
        private final Model j;

        b(Model model) {
            this.j = model;
        }

        public Class<Model> a() {
            return this.j.getClass();
        }

        public void b() {
        }

        public c.b.a.n.a c() {
            return c.b.a.n.a.LOCAL;
        }

        public void cancel() {
        }

        public void d(g gVar, d.a<? super Model> aVar) {
            aVar.h(this.j);
        }
    }

    public static <T> v<T> c() {
        return f1105a;
    }

    public n.a<Model> a(Model model, int i, int i2, j jVar) {
        return new n.a<>(new c.b.a.s.b(model), new b(model));
    }

    public boolean b(Model model) {
        return true;
    }
}
