package c.b.a.n.p;

import b.d.j.d;
import c.b.a.g;
import c.b.a.n.j;
import c.b.a.n.n.d;
import c.b.a.n.o.p;
import c.b.a.n.p.n;
import c.b.a.t.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n<Model, Data>> f1086a;

    /* renamed from: b  reason: collision with root package name */
    private final d<List<Throwable>> f1087b;

    static class a<Data> implements c.b.a.n.n.d<Data>, d.a<Data> {
        private final List<c.b.a.n.n.d<Data>> j;
        private final b.d.j.d<List<Throwable>> k;
        private int l = 0;
        private g m;
        private d.a<? super Data> n;
        private List<Throwable> o;

        a(List<c.b.a.n.n.d<Data>> list, b.d.j.d<List<Throwable>> dVar) {
            this.k = dVar;
            h.c(list);
            this.j = list;
        }

        private void e() {
            if (this.l < this.j.size() - 1) {
                this.l++;
                d(this.m, this.n);
                return;
            }
            h.d(this.o);
            this.n.g(new p("Fetch failed", (List<Throwable>) new ArrayList(this.o)));
        }

        public Class<Data> a() {
            return this.j.get(0).a();
        }

        public void b() {
            List<Throwable> list = this.o;
            if (list != null) {
                this.k.a(list);
            }
            this.o = null;
            for (c.b.a.n.n.d<Data> b2 : this.j) {
                b2.b();
            }
        }

        public c.b.a.n.a c() {
            return this.j.get(0).c();
        }

        public void cancel() {
            for (c.b.a.n.n.d<Data> cancel : this.j) {
                cancel.cancel();
            }
        }

        public void d(g gVar, d.a<? super Data> aVar) {
            this.m = gVar;
            this.n = aVar;
            this.o = this.k.b();
            this.j.get(this.l).d(gVar, this);
        }

        public void g(Exception exc) {
            List<Throwable> list = this.o;
            h.d(list);
            list.add(exc);
            e();
        }

        public void h(Data data) {
            if (data != null) {
                this.n.h(data);
            } else {
                e();
            }
        }
    }

    q(List<n<Model, Data>> list, b.d.j.d<List<Throwable>> dVar) {
        this.f1086a = list;
        this.f1087b = dVar;
    }

    public n.a<Data> a(Model model, int i, int i2, j jVar) {
        n.a a2;
        int size = this.f1086a.size();
        ArrayList arrayList = new ArrayList(size);
        c.b.a.n.h hVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = this.f1086a.get(i3);
            if (nVar.b(model) && (a2 = nVar.a(model, i, i2, jVar)) != null) {
                hVar = a2.f1079a;
                arrayList.add(a2.f1081c);
            }
        }
        if (!arrayList.isEmpty()) {
            return new n.a<>(hVar, new a(arrayList, this.f1087b));
        }
        return null;
    }

    public boolean b(Model model) {
        for (n<Model, Data> b2 : this.f1086a) {
            if (b2.b(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f1086a.toArray()) + '}';
    }
}
