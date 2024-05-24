package c.d.a.a;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class c<T> {
    public static <T> c<T> d(T t) {
        return new a((Integer) null, t, d.DEFAULT);
    }

    public abstract Integer a();

    public abstract T b();

    public abstract d c();
}
