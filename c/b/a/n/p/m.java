package c.b.a.n.p;

import c.b.a.t.e;
import c.b.a.t.i;
import java.util.Queue;

public class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final e<b<A>, B> f1074a;

    class a extends e<b<A>, B> {
        a(m mVar, long j) {
            super(j);
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public void j(b<A> bVar, B b2) {
            bVar.c();
        }
    }

    static final class b<A> {

        /* renamed from: d  reason: collision with root package name */
        private static final Queue<b<?>> f1075d = i.e(0);

        /* renamed from: a  reason: collision with root package name */
        private int f1076a;

        /* renamed from: b  reason: collision with root package name */
        private int f1077b;

        /* renamed from: c  reason: collision with root package name */
        private A f1078c;

        private b() {
        }

        static <A> b<A> a(A a2, int i, int i2) {
            b<A> poll;
            Queue<b<?>> queue = f1075d;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new b<>();
            }
            poll.b(a2, i, i2);
            return poll;
        }

        private void b(A a2, int i, int i2) {
            this.f1078c = a2;
            this.f1077b = i;
            this.f1076a = i2;
        }

        public void c() {
            Queue<b<?>> queue = f1075d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f1077b == bVar.f1077b && this.f1076a == bVar.f1076a && this.f1078c.equals(bVar.f1078c);
        }

        public int hashCode() {
            return (((this.f1076a * 31) + this.f1077b) * 31) + this.f1078c.hashCode();
        }
    }

    public m(long j) {
        this.f1074a = new a(this, j);
    }

    public B a(A a2, int i, int i2) {
        b a3 = b.a(a2, i, i2);
        B g = this.f1074a.g(a3);
        a3.c();
        return g;
    }

    public void b(A a2, int i, int i2, B b2) {
        this.f1074a.k(b.a(a2, i, i2), b2);
    }
}
