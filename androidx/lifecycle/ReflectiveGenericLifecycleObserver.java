package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.d;

class ReflectiveGenericLifecycleObserver implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f400a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0016a f401b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f400a = obj;
        this.f401b = a.f407c.c(obj.getClass());
    }

    public void d(g gVar, d.b bVar) {
        this.f401b.a(gVar, bVar, this.f400a);
    }
}
