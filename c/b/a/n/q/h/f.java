package c.b.a.n.q.h;

import java.util.ArrayList;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?, ?>> f1212a = new ArrayList();

    private static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Z> f1213a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<R> f1214b;

        /* renamed from: c  reason: collision with root package name */
        final e<Z, R> f1215c;

        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.f1213a = cls;
            this.f1214b = cls2;
            this.f1215c = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f1213a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f1214b);
        }
    }

    public synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a next : this.f1212a) {
            if (next.a(cls, cls2)) {
                return next.f1215c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> a2 : this.f1212a) {
            if (a2.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.f1212a.add(new a(cls, cls2, eVar));
    }
}
