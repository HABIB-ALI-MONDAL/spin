package androidx.lifecycle;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private final a f427a;

    /* renamed from: b  reason: collision with root package name */
    private final s f428b;

    public interface a {
        <T extends q> T a(Class<T> cls);
    }

    static abstract class b extends c implements a {
        b() {
        }

        public <T extends q> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends q> T c(String str, Class<T> cls);
    }

    static class c {
        c() {
        }

        /* access modifiers changed from: package-private */
        public void b(q qVar) {
        }
    }

    public r(s sVar, a aVar) {
        this.f427a = aVar;
        this.f428b = sVar;
    }

    public <T extends q> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends q> T b(String str, Class<T> cls) {
        T b2 = this.f428b.b(str);
        if (cls.isInstance(b2)) {
            a aVar = this.f427a;
            if (aVar instanceof c) {
                ((c) aVar).b(b2);
            }
            return b2;
        }
        a aVar2 = this.f427a;
        T c2 = aVar2 instanceof b ? ((b) aVar2).c(str, cls) : aVar2.a(cls);
        this.f428b.d(str, c2);
        return c2;
    }
}
