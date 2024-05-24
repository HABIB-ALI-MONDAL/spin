package c.b.a.n.o.z;

import android.util.Log;
import c.b.a.t.h;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final h<a, Object> f1025a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    private final b f1026b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f1027c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, a<?>> f1028d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final int f1029e;

    /* renamed from: f  reason: collision with root package name */
    private int f1030f;

    private static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f1031a;

        /* renamed from: b  reason: collision with root package name */
        int f1032b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f1033c;

        a(b bVar) {
            this.f1031a = bVar;
        }

        public void a() {
            this.f1031a.c(this);
        }

        /* access modifiers changed from: package-private */
        public void b(int i, Class<?> cls) {
            this.f1032b = i;
            this.f1033c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1032b == aVar.f1032b && this.f1033c == aVar.f1033c;
        }

        public int hashCode() {
            int i = this.f1032b * 31;
            Class<?> cls = this.f1033c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f1032b + "array=" + this.f1033c + '}';
        }
    }

    private static final class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        /* access modifiers changed from: package-private */
        public a e(int i, Class<?> cls) {
            a aVar = (a) b();
            aVar.b(i, cls);
            return aVar;
        }
    }

    public j(int i) {
        this.f1029e = i;
    }

    private void f(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> m = m(cls);
        Integer num = (Integer) m.get(Integer.valueOf(i));
        if (num != null) {
            int intValue = num.intValue();
            Integer valueOf = Integer.valueOf(i);
            if (intValue == 1) {
                m.remove(valueOf);
            } else {
                m.put(valueOf, Integer.valueOf(num.intValue() - 1));
            }
        } else {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        }
    }

    private void g() {
        h(this.f1029e);
    }

    private void h(int i) {
        while (this.f1030f > i) {
            Object f2 = this.f1025a.f();
            h.d(f2);
            a i2 = i(f2);
            this.f1030f -= i2.b(f2) * i2.c();
            f(i2.b(f2), f2.getClass());
            if (Log.isLoggable(i2.a(), 2)) {
                Log.v(i2.a(), "evicted: " + i2.b(f2));
            }
        }
    }

    private <T> a<T> i(T t) {
        return j(t.getClass());
    }

    private <T> a<T> j(Class<T> cls) {
        a<T> aVar = this.f1028d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new i();
            } else if (cls.equals(byte[].class)) {
                aVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f1028d.put(cls, aVar);
        }
        return aVar;
    }

    private <T> T k(a aVar) {
        return this.f1025a.a(aVar);
    }

    private <T> T l(a aVar, Class<T> cls) {
        a<T> j = j(cls);
        T k = k(aVar);
        if (k != null) {
            this.f1030f -= j.b(k) * j.c();
            f(j.b(k), cls);
        }
        if (k != null) {
            return k;
        }
        if (Log.isLoggable(j.a(), 2)) {
            Log.v(j.a(), "Allocated " + aVar.f1032b + " bytes");
        }
        return j.newArray(aVar.f1032b);
    }

    private NavigableMap<Integer, Integer> m(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f1027c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f1027c.put(cls, treeMap);
        return treeMap;
    }

    private boolean n() {
        int i = this.f1030f;
        return i == 0 || this.f1029e / i >= 2;
    }

    private boolean o(int i) {
        return i <= this.f1029e / 2;
    }

    private boolean p(int i, Integer num) {
        return num != null && (n() || num.intValue() <= i * 8);
    }

    public synchronized void a(int i) {
        if (i >= 40) {
            try {
                b();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i >= 20) {
            h(this.f1029e / 2);
        }
    }

    public synchronized void b() {
        h(0);
    }

    public synchronized <T> T c(int i, Class<T> cls) {
        return l(this.f1026b.e(i, cls), cls);
    }

    public synchronized <T> void d(T t) {
        Class<?> cls = t.getClass();
        a<?> j = j(cls);
        int b2 = j.b(t);
        int c2 = j.c() * b2;
        if (o(c2)) {
            a e2 = this.f1026b.e(b2, cls);
            this.f1025a.d(e2, t);
            NavigableMap<Integer, Integer> m = m(cls);
            Integer num = (Integer) m.get(Integer.valueOf(e2.f1032b));
            Integer valueOf = Integer.valueOf(e2.f1032b);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            m.put(valueOf, Integer.valueOf(i));
            this.f1030f += c2;
            g();
        }
    }

    public synchronized <T> T e(int i, Class<T> cls) {
        Integer ceilingKey;
        ceilingKey = m(cls).ceilingKey(Integer.valueOf(i));
        return l(p(i, ceilingKey) ? this.f1026b.e(ceilingKey.intValue(), cls) : this.f1026b.e(i, cls), cls);
    }
}
