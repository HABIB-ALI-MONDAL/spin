package b.d.j;

public class f<T> extends e<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Object f616c = new Object();

    public f(int i) {
        super(i);
    }

    public boolean a(T t) {
        boolean a2;
        synchronized (this.f616c) {
            a2 = super.a(t);
        }
        return a2;
    }

    public T b() {
        T b2;
        synchronized (this.f616c) {
            b2 = super.b();
        }
        return b2;
    }
}
