package c.d.a.a.i.w.a;

public final class a<T> implements d.a.a<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1477c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile d.a.a<T> f1478a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f1479b = f1477c;

    private a(d.a.a<T> aVar) {
        this.f1478a = aVar;
    }

    public static <P extends d.a.a<T>, T> d.a.a<T> a(P p) {
        d.b(p);
        return p instanceof a ? p : new a(p);
    }

    public static Object b(Object obj, Object obj2) {
        if (!(obj != f1477c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t = this.f1479b;
        T t2 = f1477c;
        if (t == t2) {
            synchronized (this) {
                t = this.f1479b;
                if (t == t2) {
                    t = this.f1478a.get();
                    b(this.f1479b, t);
                    this.f1479b = t;
                    this.f1478a = null;
                }
            }
        }
        return t;
    }
}
