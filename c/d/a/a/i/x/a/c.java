package c.d.a.a.i.x.a;

import com.google.firebase.l.j.e;
import com.google.firebase.l.j.f;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final long f1491a;

    /* renamed from: b  reason: collision with root package name */
    private final b f1492b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f1493a = 0;

        /* renamed from: b  reason: collision with root package name */
        private b f1494b = b.REASON_UNKNOWN;

        a() {
        }

        public c a() {
            return new c(this.f1493a, this.f1494b);
        }

        public a b(long j) {
            this.f1493a = j;
            return this;
        }

        public a c(b bVar) {
            this.f1494b = bVar;
            return this;
        }
    }

    public enum b implements e {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);
        
        private final int j;

        private b(int i) {
            this.j = i;
        }

        public int d() {
            return this.j;
        }
    }

    static {
        new a().a();
    }

    c(long j, b bVar) {
        this.f1491a = j;
        this.f1492b = bVar;
    }

    public static a c() {
        return new a();
    }

    @f(tag = 1)
    public long a() {
        return this.f1491a;
    }

    @f(tag = 3)
    public b b() {
        return this.f1492b;
    }
}
