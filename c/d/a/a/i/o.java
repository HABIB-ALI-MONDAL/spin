package c.d.a.a.i;

import c.d.a.a.b;
import c.d.a.a.c;
import c.d.a.a.e;
import c.d.a.a.i.d;
import com.google.auto.value.AutoValue;

@AutoValue
abstract class o {

    @AutoValue.Builder
    public static abstract class a {
        public abstract o a();

        /* access modifiers changed from: package-private */
        public abstract a b(b bVar);

        /* access modifiers changed from: package-private */
        public abstract a c(c<?> cVar);

        /* access modifiers changed from: package-private */
        public abstract a d(e<?, byte[]> eVar);

        public abstract a e(p pVar);

        public abstract a f(String str);
    }

    o() {
    }

    public static a a() {
        return new d.b();
    }

    public abstract b b();

    /* access modifiers changed from: package-private */
    public abstract c<?> c();

    public byte[] d() {
        return e().a(c().b());
    }

    /* access modifiers changed from: package-private */
    public abstract e<?, byte[]> e();

    public abstract p f();

    public abstract String g();
}
