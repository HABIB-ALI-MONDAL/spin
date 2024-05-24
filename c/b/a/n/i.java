package c.b.a.n;

import c.b.a.t.h;
import java.security.MessageDigest;

public final class i<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final b<Object> f874e = new a();

    /* renamed from: a  reason: collision with root package name */
    private final T f875a;

    /* renamed from: b  reason: collision with root package name */
    private final b<T> f876b;

    /* renamed from: c  reason: collision with root package name */
    private final String f877c;

    /* renamed from: d  reason: collision with root package name */
    private volatile byte[] f878d;

    class a implements b<Object> {
        a() {
        }

        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    public interface b<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    private i(String str, T t, b<T> bVar) {
        h.b(str);
        this.f877c = str;
        this.f875a = t;
        h.d(bVar);
        this.f876b = bVar;
    }

    public static <T> i<T> a(String str, T t, b<T> bVar) {
        return new i<>(str, t, bVar);
    }

    private static <T> b<T> b() {
        return f874e;
    }

    private byte[] d() {
        if (this.f878d == null) {
            this.f878d = this.f877c.getBytes(h.f873a);
        }
        return this.f878d;
    }

    public static <T> i<T> e(String str) {
        return new i<>(str, (Object) null, b());
    }

    public static <T> i<T> f(String str, T t) {
        return new i<>(str, t, b());
    }

    public T c() {
        return this.f875a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f877c.equals(((i) obj).f877c);
        }
        return false;
    }

    public void g(T t, MessageDigest messageDigest) {
        this.f876b.a(d(), t, messageDigest);
    }

    public int hashCode() {
        return this.f877c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f877c + '\'' + '}';
    }
}
