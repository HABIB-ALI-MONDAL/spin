package c.b.a.t.j;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final g<Object> f1286a = new C0058a();

    /* renamed from: c.b.a.t.j.a$a  reason: collision with other inner class name */
    class C0058a implements g<Object> {
        C0058a() {
        }

        public void a(Object obj) {
        }
    }

    class b implements d<List<T>> {
        b() {
        }

        /* renamed from: b */
        public List<T> a() {
            return new ArrayList();
        }
    }

    class c implements g<List<T>> {
        c() {
        }

        /* renamed from: b */
        public void a(List<T> list) {
            list.clear();
        }
    }

    public interface d<T> {
        T a();
    }

    private static final class e<T> implements b.d.j.d<T> {

        /* renamed from: a  reason: collision with root package name */
        private final d<T> f1287a;

        /* renamed from: b  reason: collision with root package name */
        private final g<T> f1288b;

        /* renamed from: c  reason: collision with root package name */
        private final b.d.j.d<T> f1289c;

        e(b.d.j.d<T> dVar, d<T> dVar2, g<T> gVar) {
            this.f1289c = dVar;
            this.f1287a = dVar2;
            this.f1288b = gVar;
        }

        public boolean a(T t) {
            if (t instanceof f) {
                ((f) t).k().b(true);
            }
            this.f1288b.a(t);
            return this.f1289c.a(t);
        }

        public T b() {
            T b2 = this.f1289c.b();
            if (b2 == null) {
                b2 = this.f1287a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + b2.getClass());
                }
            }
            if (b2 instanceof f) {
                ((f) b2).k().b(false);
            }
            return b2;
        }
    }

    public interface f {
        b k();
    }

    public interface g<T> {
        void a(T t);
    }

    private static <T extends f> b.d.j.d<T> a(b.d.j.d<T> dVar, d<T> dVar2) {
        return b(dVar, dVar2, c());
    }

    private static <T> b.d.j.d<T> b(b.d.j.d<T> dVar, d<T> dVar2, g<T> gVar) {
        return new e(dVar, dVar2, gVar);
    }

    private static <T> g<T> c() {
        return f1286a;
    }

    public static <T extends f> b.d.j.d<T> d(int i, d<T> dVar) {
        return a(new b.d.j.e(i), dVar);
    }

    public static <T extends f> b.d.j.d<T> e(int i, d<T> dVar) {
        return a(new b.d.j.f(i), dVar);
    }

    public static <T> b.d.j.d<List<T>> f() {
        return g(20);
    }

    public static <T> b.d.j.d<List<T>> g(int i) {
        return b(new b.d.j.f(i), new b(), new c());
    }
}
