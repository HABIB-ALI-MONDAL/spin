package c.b.a;

import c.b.a.n.k;
import c.b.a.n.l;
import c.b.a.n.n.e;
import c.b.a.n.o.s;
import c.b.a.n.o.u;
import c.b.a.n.p.n;
import c.b.a.n.p.o;
import c.b.a.n.p.p;
import c.b.a.q.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final p f823a;

    /* renamed from: b  reason: collision with root package name */
    private final c.b.a.q.a f824b;

    /* renamed from: c  reason: collision with root package name */
    private final c.b.a.q.e f825c;

    /* renamed from: d  reason: collision with root package name */
    private final f f826d;

    /* renamed from: e  reason: collision with root package name */
    private final c.b.a.n.n.f f827e;

    /* renamed from: f  reason: collision with root package name */
    private final c.b.a.n.q.h.f f828f;
    private final c.b.a.q.b g;
    private final c.b.a.q.d h = new c.b.a.q.d();
    private final c.b.a.q.c i = new c.b.a.q.c();
    private final b.d.j.d<List<Throwable>> j;

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    public static class c extends a {
        public c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        public c(Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }
    }

    public static class d extends a {
        public d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class e extends a {
        public e(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public h() {
        b.d.j.d<List<Throwable>> f2 = c.b.a.t.j.a.f();
        this.j = f2;
        this.f823a = new p(f2);
        this.f824b = new c.b.a.q.a();
        this.f825c = new c.b.a.q.e();
        this.f826d = new f();
        this.f827e = new c.b.a.n.n.f();
        this.f828f = new c.b.a.n.q.h.f();
        this.g = new c.b.a.q.b();
        r(Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
    }

    private <Data, TResource, Transcode> List<c.b.a.n.o.h<Data, TResource, Transcode>> f(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class next : this.f825c.d(cls, cls2)) {
            for (Class next2 : this.f828f.b(next, cls3)) {
                arrayList.add(new c.b.a.n.o.h(cls, next, next2, this.f825c.b(cls, next), this.f828f.a(next, next2), this.j));
            }
        }
        return arrayList;
    }

    public <Data> h a(Class<Data> cls, c.b.a.n.d<Data> dVar) {
        this.f824b.a(cls, dVar);
        return this;
    }

    public <TResource> h b(Class<TResource> cls, l<TResource> lVar) {
        this.f826d.a(cls, lVar);
        return this;
    }

    public <Data, TResource> h c(Class<Data> cls, Class<TResource> cls2, k<Data, TResource> kVar) {
        e("legacy_append", cls, cls2, kVar);
        return this;
    }

    public <Model, Data> h d(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.f823a.a(cls, cls2, oVar);
        return this;
    }

    public <Data, TResource> h e(String str, Class<Data> cls, Class<TResource> cls2, k<Data, TResource> kVar) {
        this.f825c.a(str, kVar, cls, cls2);
        return this;
    }

    public List<c.b.a.n.f> g() {
        List<c.b.a.n.f> b2 = this.g.b();
        if (!b2.isEmpty()) {
            return b2;
        }
        throw new b();
    }

    public <Data, TResource, Transcode> s<Data, TResource, Transcode> h(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        s<Data, TResource, Transcode> a2 = this.i.a(cls, cls2, cls3);
        if (this.i.c(a2)) {
            return null;
        }
        if (a2 == null) {
            List<c.b.a.n.o.h<Data, TResource, Transcode>> f2 = f(cls, cls2, cls3);
            if (f2.isEmpty()) {
                a2 = null;
            } else {
                a2 = new s<>(cls, cls2, cls3, f2, this.j);
            }
            this.i.d(cls, cls2, cls3, a2);
        }
        return a2;
    }

    public <Model> List<n<Model, ?>> i(Model model) {
        List<n<Model, ?>> d2 = this.f823a.d(model);
        if (!d2.isEmpty()) {
            return d2;
        }
        throw new c(model);
    }

    public <Model, TResource, Transcode> List<Class<?>> j(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a2 = this.h.a(cls, cls2);
        if (a2 == null) {
            a2 = new ArrayList<>();
            for (Class<?> d2 : this.f823a.c(cls)) {
                for (Class next : this.f825c.d(d2, cls2)) {
                    if (!this.f828f.b(next, cls3).isEmpty() && !a2.contains(next)) {
                        a2.add(next);
                    }
                }
            }
            this.h.b(cls, cls2, Collections.unmodifiableList(a2));
        }
        return a2;
    }

    public <X> l<X> k(u<X> uVar) {
        l<X> b2 = this.f826d.b(uVar.d());
        if (b2 != null) {
            return b2;
        }
        throw new d(uVar.d());
    }

    public <X> c.b.a.n.n.e<X> l(X x) {
        return this.f827e.a(x);
    }

    public <X> c.b.a.n.d<X> m(X x) {
        c.b.a.n.d<X> b2 = this.f824b.b(x.getClass());
        if (b2 != null) {
            return b2;
        }
        throw new e(x.getClass());
    }

    public boolean n(u<?> uVar) {
        return this.f826d.b(uVar.d()) != null;
    }

    public h o(c.b.a.n.f fVar) {
        this.g.a(fVar);
        return this;
    }

    public h p(e.a<?> aVar) {
        this.f827e.b(aVar);
        return this;
    }

    public <TResource, Transcode> h q(Class<TResource> cls, Class<Transcode> cls2, c.b.a.n.q.h.e<TResource, Transcode> eVar) {
        this.f828f.c(cls, cls2, eVar);
        return this;
    }

    public final h r(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f825c.e(arrayList);
        return this;
    }
}
