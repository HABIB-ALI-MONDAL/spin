package c.b.a.n.o;

import c.b.a.e;
import c.b.a.n.d;
import c.b.a.n.h;
import c.b.a.n.j;
import c.b.a.n.l;
import c.b.a.n.m;
import c.b.a.n.o.a0.a;
import c.b.a.n.o.g;
import c.b.a.n.o.z.b;
import c.b.a.n.p.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class f<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n.a<?>> f949a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<h> f950b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private e f951c;

    /* renamed from: d  reason: collision with root package name */
    private Object f952d;

    /* renamed from: e  reason: collision with root package name */
    private int f953e;

    /* renamed from: f  reason: collision with root package name */
    private int f954f;
    private Class<?> g;
    private g.e h;
    private j i;
    private Map<Class<?>, m<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private h n;
    private c.b.a.g o;
    private i p;
    private boolean q;
    private boolean r;

    f() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f951c = null;
        this.f952d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f949a.clear();
        this.l = false;
        this.f950b.clear();
        this.m = false;
    }

    /* access modifiers changed from: package-private */
    public b b() {
        return this.f951c.b();
    }

    /* access modifiers changed from: package-private */
    public List<h> c() {
        if (!this.m) {
            this.m = true;
            this.f950b.clear();
            List<n.a<?>> g2 = g();
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                n.a aVar = g2.get(i2);
                if (!this.f950b.contains(aVar.f1079a)) {
                    this.f950b.add(aVar.f1079a);
                }
                for (int i3 = 0; i3 < aVar.f1080b.size(); i3++) {
                    if (!this.f950b.contains(aVar.f1080b.get(i3))) {
                        this.f950b.add(aVar.f1080b.get(i3));
                    }
                }
            }
        }
        return this.f950b;
    }

    /* access modifiers changed from: package-private */
    public a d() {
        return this.h.a();
    }

    /* access modifiers changed from: package-private */
    public i e() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f954f;
    }

    /* access modifiers changed from: package-private */
    public List<n.a<?>> g() {
        if (!this.l) {
            this.l = true;
            this.f949a.clear();
            List i2 = this.f951c.g().i(this.f952d);
            int size = i2.size();
            for (int i3 = 0; i3 < size; i3++) {
                n.a a2 = ((n) i2.get(i3)).a(this.f952d, this.f953e, this.f954f, this.i);
                if (a2 != null) {
                    this.f949a.add(a2);
                }
            }
        }
        return this.f949a;
    }

    /* access modifiers changed from: package-private */
    public <Data> s<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f951c.g().h(cls, this.g, this.k);
    }

    /* access modifiers changed from: package-private */
    public Class<?> i() {
        return this.f952d.getClass();
    }

    /* access modifiers changed from: package-private */
    public List<n<File, ?>> j(File file) {
        return this.f951c.g().i(file);
    }

    /* access modifiers changed from: package-private */
    public j k() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public c.b.a.g l() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public List<Class<?>> m() {
        return this.f951c.g().j(this.f952d.getClass(), this.g, this.k);
    }

    /* access modifiers changed from: package-private */
    public <Z> l<Z> n(u<Z> uVar) {
        return this.f951c.g().k(uVar);
    }

    /* access modifiers changed from: package-private */
    public h o() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public <X> d<X> p(X x) {
        return this.f951c.g().m(x);
    }

    /* access modifiers changed from: package-private */
    public Class<?> q() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public <Z> m<Z> r(Class<Z> cls) {
        m<Z> mVar = this.j.get(cls);
        if (mVar == null) {
            Iterator<Map.Entry<Class<?>, m<?>>> it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    mVar = (m) next.getValue();
                    break;
                }
            }
        }
        if (mVar != null) {
            return mVar;
        }
        if (!this.j.isEmpty() || !this.q) {
            return c.b.a.n.q.b.c();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* access modifiers changed from: package-private */
    public int s() {
        return this.f953e;
    }

    /* access modifiers changed from: package-private */
    public boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    /* access modifiers changed from: package-private */
    public <R> void u(e eVar, Object obj, h hVar, int i2, int i3, i iVar, Class<?> cls, Class<R> cls2, c.b.a.g gVar, j jVar, Map<Class<?>, m<?>> map, boolean z, boolean z2, g.e eVar2) {
        this.f951c = eVar;
        this.f952d = obj;
        this.n = hVar;
        this.f953e = i2;
        this.f954f = i3;
        this.p = iVar;
        this.g = cls;
        this.h = eVar2;
        this.k = cls2;
        this.o = gVar;
        this.i = jVar;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean v(u<?> uVar) {
        return this.f951c.g().n(uVar);
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public boolean x(h hVar) {
        List<n.a<?>> g2 = g();
        int size = g2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (g2.get(i2).f1079a.equals(hVar)) {
                return true;
            }
        }
        return false;
    }
}
