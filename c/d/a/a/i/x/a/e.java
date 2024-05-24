package c.d.a.a.i.x.a;

import com.google.firebase.l.j.f;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final long f1499a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1500b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f1501a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f1502b = 0;

        a() {
        }

        public e a() {
            return new e(this.f1501a, this.f1502b);
        }

        public a b(long j) {
            this.f1501a = j;
            return this;
        }

        public a c(long j) {
            this.f1502b = j;
            return this;
        }
    }

    static {
        new a().a();
    }

    e(long j, long j2) {
        this.f1499a = j;
        this.f1500b = j2;
    }

    public static a c() {
        return new a();
    }

    @f(tag = 1)
    public long a() {
        return this.f1499a;
    }

    @f(tag = 2)
    public long b() {
        return this.f1500b;
    }
}
