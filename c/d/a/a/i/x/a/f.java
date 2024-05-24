package c.d.a.a.i.x.a;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final long f1503a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1504b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f1505a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f1506b = 0;

        a() {
        }

        public f a() {
            return new f(this.f1505a, this.f1506b);
        }

        public a b(long j) {
            this.f1506b = j;
            return this;
        }

        public a c(long j) {
            this.f1505a = j;
            return this;
        }
    }

    static {
        new a().a();
    }

    f(long j, long j2) {
        this.f1503a = j;
        this.f1504b = j2;
    }

    public static a c() {
        return new a();
    }

    @com.google.firebase.l.j.f(tag = 2)
    public long a() {
        return this.f1504b;
    }

    @com.google.firebase.l.j.f(tag = 1)
    public long b() {
        return this.f1503a;
    }
}
