package c.b.a.q;

import b.c.a;
import b.d.j.d;
import c.b.a.n.o.h;
import c.b.a.n.o.s;
import c.b.a.n.q.h.g;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final s<?, ?, ?> f1243c = new s(Object.class, Object.class, Object.class, Collections.singletonList(new h(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), (d<List<Throwable>>) null)), (d<List<Throwable>>) null);

    /* renamed from: a  reason: collision with root package name */
    private final a<c.b.a.t.g, s<?, ?, ?>> f1244a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<c.b.a.t.g> f1245b = new AtomicReference<>();

    private c.b.a.t.g b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        c.b.a.t.g andSet = this.f1245b.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new c.b.a.t.g();
        }
        andSet.b(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> s<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        s<Data, TResource, Transcode> sVar;
        c.b.a.t.g b2 = b(cls, cls2, cls3);
        synchronized (this.f1244a) {
            sVar = this.f1244a.get(b2);
        }
        this.f1245b.set(b2);
        return sVar;
    }

    public boolean c(s<?, ?, ?> sVar) {
        return f1243c.equals(sVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, s<?, ?, ?> sVar) {
        synchronized (this.f1244a) {
            a<c.b.a.t.g, s<?, ?, ?>> aVar = this.f1244a;
            c.b.a.t.g gVar = new c.b.a.t.g(cls, cls2, cls3);
            if (sVar == null) {
                sVar = f1243c;
            }
            aVar.put(gVar, sVar);
        }
    }
}
