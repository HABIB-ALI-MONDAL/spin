package c.b.a.n.p;

import c.b.a.n.h;
import c.b.a.n.j;
import c.b.a.n.n.d;
import java.util.Collections;
import java.util.List;

public interface n<Model, Data> {

    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final h f1079a;

        /* renamed from: b  reason: collision with root package name */
        public final List<h> f1080b;

        /* renamed from: c  reason: collision with root package name */
        public final d<Data> f1081c;

        public a(h hVar, d<Data> dVar) {
            this(hVar, Collections.emptyList(), dVar);
        }

        public a(h hVar, List<h> list, d<Data> dVar) {
            c.b.a.t.h.d(hVar);
            this.f1079a = hVar;
            c.b.a.t.h.d(list);
            this.f1080b = list;
            c.b.a.t.h.d(dVar);
            this.f1081c = dVar;
        }
    }

    a<Data> a(Model model, int i, int i2, j jVar);

    boolean b(Model model);
}
