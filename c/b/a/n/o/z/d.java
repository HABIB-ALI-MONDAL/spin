package c.b.a.n.o.z;

import c.b.a.n.o.z.m;
import c.b.a.t.i;
import java.util.Queue;

abstract class d<T extends m> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f1018a = i.e(20);

    d() {
    }

    /* access modifiers changed from: package-private */
    public abstract T a();

    /* access modifiers changed from: package-private */
    public T b() {
        T t = (m) this.f1018a.poll();
        return t == null ? a() : t;
    }

    public void c(T t) {
        if (this.f1018a.size() < 20) {
            this.f1018a.offer(t);
        }
    }
}
