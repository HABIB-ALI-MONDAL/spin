package c.b.a.n.p;

import b.d.j.d;
import c.b.a.h;
import c.b.a.n.j;
import c.b.a.n.p.n;
import c.b.a.t.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class r {

    /* renamed from: e  reason: collision with root package name */
    private static final c f1088e = new c();

    /* renamed from: f  reason: collision with root package name */
    private static final n<Object, Object> f1089f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<b<?, ?>> f1090a;

    /* renamed from: b  reason: collision with root package name */
    private final c f1091b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<b<?, ?>> f1092c;

    /* renamed from: d  reason: collision with root package name */
    private final d<List<Throwable>> f1093d;

    private static class a implements n<Object, Object> {
        a() {
        }

        public n.a<Object> a(Object obj, int i, int i2, j jVar) {
            return null;
        }

        public boolean b(Object obj) {
            return false;
        }
    }

    private static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Model> f1094a;

        /* renamed from: b  reason: collision with root package name */
        final Class<Data> f1095b;

        /* renamed from: c  reason: collision with root package name */
        final o<? extends Model, ? extends Data> f1096c;

        public b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
            this.f1094a = cls;
            this.f1095b = cls2;
            this.f1096c = oVar;
        }

        public boolean a(Class<?> cls) {
            return this.f1094a.isAssignableFrom(cls);
        }

        public boolean b(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f1095b.isAssignableFrom(cls2);
        }
    }

    static class c {
        c() {
        }

        public <Model, Data> q<Model, Data> a(List<n<Model, Data>> list, d<List<Throwable>> dVar) {
            return new q<>(list, dVar);
        }
    }

    public r(d<List<Throwable>> dVar) {
        this(dVar, f1088e);
    }

    r(d<List<Throwable>> dVar, c cVar) {
        this.f1090a = new ArrayList();
        this.f1092c = new HashSet();
        this.f1093d = dVar;
        this.f1091b = cVar;
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar, boolean z) {
        b bVar = new b(cls, cls2, oVar);
        List<b<?, ?>> list = this.f1090a;
        list.add(z ? list.size() : 0, bVar);
    }

    private <Model, Data> n<Model, Data> c(b<?, ?> bVar) {
        n<? extends Model, ? extends Data> b2 = bVar.f1096c.b(this);
        h.d(b2);
        return b2;
    }

    private static <Model, Data> n<Model, Data> f() {
        return f1089f;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    public synchronized <Model, Data> n<Model, Data> d(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b next : this.f1090a) {
                if (this.f1092c.contains(next)) {
                    z = true;
                } else if (next.b(cls, cls2)) {
                    this.f1092c.add(next);
                    arrayList.add(c(next));
                    this.f1092c.remove(next);
                }
            }
            if (arrayList.size() > 1) {
                return this.f1091b.a(arrayList, this.f1093d);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z) {
                return f();
            } else {
                throw new h.c(cls, cls2);
            }
        } catch (Throwable th) {
            this.f1092c.clear();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model> List<n<Model, ?>> e(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b next : this.f1090a) {
                if (!this.f1092c.contains(next)) {
                    if (next.a(cls)) {
                        this.f1092c.add(next);
                        arrayList.add(c(next));
                        this.f1092c.remove(next);
                    }
                }
            }
        } catch (Throwable th) {
            this.f1092c.clear();
            throw th;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized List<Class<?>> g(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b next : this.f1090a) {
            if (!arrayList.contains(next.f1095b) && next.a(cls)) {
                arrayList.add(next.f1095b);
            }
        }
        return arrayList;
    }
}
