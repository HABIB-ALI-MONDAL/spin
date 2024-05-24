package c.d.a.a.i.w.a;

public final class c<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f1480a;

    private c(T t) {
        this.f1480a = t;
    }

    public static <T> b<T> a(T t) {
        d.c(t, "instance cannot be null");
        return new c(t);
    }

    public T get() {
        return this.f1480a;
    }
}
