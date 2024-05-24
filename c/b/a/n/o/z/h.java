package c.b.a.n.o.z;

import c.b.a.n.o.z.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f1019a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f1020b = new HashMap();

    private static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f1021a;

        /* renamed from: b  reason: collision with root package name */
        private List<V> f1022b;

        /* renamed from: c  reason: collision with root package name */
        a<K, V> f1023c;

        /* renamed from: d  reason: collision with root package name */
        a<K, V> f1024d;

        a() {
            this((Object) null);
        }

        a(K k) {
            this.f1024d = this;
            this.f1023c = this;
            this.f1021a = k;
        }

        public void a(V v) {
            if (this.f1022b == null) {
                this.f1022b = new ArrayList();
            }
            this.f1022b.add(v);
        }

        public V b() {
            int c2 = c();
            if (c2 > 0) {
                return this.f1022b.remove(c2 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f1022b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    h() {
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f1019a;
        aVar.f1024d = aVar2;
        aVar.f1023c = aVar2.f1023c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f1019a;
        aVar.f1024d = aVar2.f1024d;
        aVar.f1023c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f1024d;
        aVar2.f1023c = aVar.f1023c;
        aVar.f1023c.f1024d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f1023c.f1024d = aVar;
        aVar.f1024d.f1023c = aVar;
    }

    public V a(K k) {
        a aVar = this.f1020b.get(k);
        if (aVar == null) {
            aVar = new a(k);
            this.f1020b.put(k, aVar);
        } else {
            k.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k, V v) {
        a aVar = this.f1020b.get(k);
        if (aVar == null) {
            aVar = new a(k);
            c(aVar);
            this.f1020b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public V f() {
        a<K, V> aVar = this.f1019a;
        while (true) {
            aVar = aVar.f1024d;
            if (aVar.equals(this.f1019a)) {
                return null;
            }
            V b2 = aVar.b();
            if (b2 != null) {
                return b2;
            }
            e(aVar);
            this.f1020b.remove(aVar.f1021a);
            ((m) aVar.f1021a).a();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a<K, V> aVar = this.f1019a.f1023c; !aVar.equals(this.f1019a); aVar = aVar.f1023c) {
            z = true;
            sb.append('{');
            sb.append(aVar.f1021a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
