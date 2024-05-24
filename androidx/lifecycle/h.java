package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.d;
import b.b.a.b.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class h extends d {

    /* renamed from: a  reason: collision with root package name */
    private b.b.a.b.a<f, a> f416a;

    /* renamed from: b  reason: collision with root package name */
    private d.c f417b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<g> f418c;

    /* renamed from: d  reason: collision with root package name */
    private int f419d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f420e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f421f;
    private ArrayList<d.c> g;
    private final boolean h;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        d.c f422a;

        /* renamed from: b  reason: collision with root package name */
        e f423b;

        a(f fVar, d.c cVar) {
            this.f423b = j.f(fVar);
            this.f422a = cVar;
        }

        /* access modifiers changed from: package-private */
        public void a(g gVar, d.b bVar) {
            d.c e2 = bVar.e();
            this.f422a = h.k(this.f422a, e2);
            this.f423b.d(gVar, bVar);
            this.f422a = e2;
        }
    }

    public h(g gVar) {
        this(gVar, true);
    }

    private h(g gVar, boolean z) {
        this.f416a = new b.b.a.b.a<>();
        this.f419d = 0;
        this.f420e = false;
        this.f421f = false;
        this.g = new ArrayList<>();
        this.f418c = new WeakReference<>(gVar);
        this.f417b = d.c.INITIALIZED;
        this.h = z;
    }

    private void d(g gVar) {
        Iterator<Map.Entry<f, a>> d2 = this.f416a.d();
        while (d2.hasNext() && !this.f421f) {
            Map.Entry next = d2.next();
            a aVar = (a) next.getValue();
            while (aVar.f422a.compareTo(this.f417b) > 0 && !this.f421f && this.f416a.contains(next.getKey())) {
                d.b d3 = d.b.d(aVar.f422a);
                if (d3 != null) {
                    n(d3.e());
                    aVar.a(gVar, d3);
                    m();
                } else {
                    throw new IllegalStateException("no event down from " + aVar.f422a);
                }
            }
        }
    }

    private d.c e(f fVar) {
        Map.Entry<f, a> s = this.f416a.s(fVar);
        d.c cVar = null;
        d.c cVar2 = s != null ? s.getValue().f422a : null;
        if (!this.g.isEmpty()) {
            ArrayList<d.c> arrayList = this.g;
            cVar = arrayList.get(arrayList.size() - 1);
        }
        return k(k(this.f417b, cVar2), cVar);
    }

    @SuppressLint({"RestrictedApi"})
    private void f(String str) {
        if (this.h && !b.b.a.a.a.b().a()) {
            throw new IllegalStateException("Method " + str + " must be called on the main thread");
        }
    }

    private void g(g gVar) {
        b<K, V>.d j = this.f416a.j();
        while (j.hasNext() && !this.f421f) {
            Map.Entry entry = (Map.Entry) j.next();
            a aVar = (a) entry.getValue();
            while (aVar.f422a.compareTo(this.f417b) < 0 && !this.f421f && this.f416a.contains(entry.getKey())) {
                n(aVar.f422a);
                d.b f2 = d.b.f(aVar.f422a);
                if (f2 != null) {
                    aVar.a(gVar, f2);
                    m();
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f422a);
                }
            }
        }
    }

    private boolean i() {
        if (this.f416a.size() == 0) {
            return true;
        }
        d.c cVar = this.f416a.g().getValue().f422a;
        d.c cVar2 = this.f416a.k().getValue().f422a;
        return cVar == cVar2 && this.f417b == cVar2;
    }

    static d.c k(d.c cVar, d.c cVar2) {
        return (cVar2 == null || cVar2.compareTo(cVar) >= 0) ? cVar : cVar2;
    }

    private void l(d.c cVar) {
        if (this.f417b != cVar) {
            this.f417b = cVar;
            if (this.f420e || this.f419d != 0) {
                this.f421f = true;
                return;
            }
            this.f420e = true;
            p();
            this.f420e = false;
        }
    }

    private void m() {
        ArrayList<d.c> arrayList = this.g;
        arrayList.remove(arrayList.size() - 1);
    }

    private void n(d.c cVar) {
        this.g.add(cVar);
    }

    private void p() {
        g gVar = (g) this.f418c.get();
        if (gVar != null) {
            while (true) {
                boolean i = i();
                this.f421f = false;
                if (!i) {
                    if (this.f417b.compareTo(this.f416a.g().getValue().f422a) < 0) {
                        d(gVar);
                    }
                    Map.Entry<f, a> k = this.f416a.k();
                    if (!this.f421f && k != null && this.f417b.compareTo(k.getValue().f422a) > 0) {
                        g(gVar);
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
    }

    public void a(f fVar) {
        g gVar;
        f("addObserver");
        d.c cVar = this.f417b;
        d.c cVar2 = d.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = d.c.INITIALIZED;
        }
        a aVar = new a(fVar, cVar2);
        if (this.f416a.p(fVar, aVar) == null && (gVar = (g) this.f418c.get()) != null) {
            boolean z = this.f419d != 0 || this.f420e;
            d.c e2 = e(fVar);
            this.f419d++;
            while (aVar.f422a.compareTo(e2) < 0 && this.f416a.contains(fVar)) {
                n(aVar.f422a);
                d.b f2 = d.b.f(aVar.f422a);
                if (f2 != null) {
                    aVar.a(gVar, f2);
                    m();
                    e2 = e(fVar);
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f422a);
                }
            }
            if (!z) {
                p();
            }
            this.f419d--;
        }
    }

    public d.c b() {
        return this.f417b;
    }

    public void c(f fVar) {
        f("removeObserver");
        this.f416a.r(fVar);
    }

    public void h(d.b bVar) {
        f("handleLifecycleEvent");
        l(bVar.e());
    }

    @Deprecated
    public void j(d.c cVar) {
        f("markState");
        o(cVar);
    }

    public void o(d.c cVar) {
        f("setCurrentState");
        l(cVar);
    }
}
