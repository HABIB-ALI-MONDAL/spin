package c.b.a.q;

import b.c.a;
import c.b.a.t.g;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<g> f1246a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final a<g, List<Class<?>>> f1247b = new a<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2) {
        List<Class<?>> list;
        g andSet = this.f1246a.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new g(cls, cls2);
        } else {
            andSet.a(cls, cls2);
        }
        synchronized (this.f1247b) {
            list = this.f1247b.get(andSet);
        }
        this.f1246a.set(andSet);
        return list;
    }

    public void b(Class<?> cls, Class<?> cls2, List<Class<?>> list) {
        synchronized (this.f1247b) {
            this.f1247b.put(new g(cls, cls2), list);
        }
    }
}
