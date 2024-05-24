package b.b.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    c<K, V> j;
    private c<K, V> k;
    private WeakHashMap<f<K, V>, Boolean> l = new WeakHashMap<>();
    private int m = 0;

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> c(c<K, V> cVar) {
            return cVar.m;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> d(c<K, V> cVar) {
            return cVar.l;
        }
    }

    /* renamed from: b.b.a.b.b$b  reason: collision with other inner class name */
    private static class C0020b<K, V> extends e<K, V> {
        C0020b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> c(c<K, V> cVar) {
            return cVar.l;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> d(c<K, V> cVar) {
            return cVar.m;
        }
    }

    static class c<K, V> implements Map.Entry<K, V> {
        final K j;
        final V k;
        c<K, V> l;
        c<K, V> m;

        c(K k2, V v) {
            this.j = k2;
            this.k = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.j.equals(cVar.j) && this.k.equals(cVar.k);
        }

        public K getKey() {
            return this.j;
        }

        public V getValue() {
            return this.k;
        }

        public int hashCode() {
            return this.j.hashCode() ^ this.k.hashCode();
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.j + "=" + this.k;
        }
    }

    private class d implements Iterator<Map.Entry<K, V>>, f<K, V> {
        private c<K, V> j;
        private boolean k = true;

        d() {
        }

        public void b(c<K, V> cVar) {
            c<K, V> cVar2 = this.j;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.m;
                this.j = cVar3;
                this.k = cVar3 == null;
            }
        }

        /* renamed from: c */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.k) {
                this.k = false;
                cVar = b.this.j;
            } else {
                c<K, V> cVar2 = this.j;
                cVar = cVar2 != null ? cVar2.l : null;
            }
            this.j = cVar;
            return this.j;
        }

        public boolean hasNext() {
            if (this.k) {
                return b.this.j != null;
            }
            c<K, V> cVar = this.j;
            return (cVar == null || cVar.l == null) ? false : true;
        }
    }

    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {
        c<K, V> j;
        c<K, V> k;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.j = cVar2;
            this.k = cVar;
        }

        private c<K, V> f() {
            c<K, V> cVar = this.k;
            c<K, V> cVar2 = this.j;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        public void b(c<K, V> cVar) {
            if (this.j == cVar && cVar == this.k) {
                this.k = null;
                this.j = null;
            }
            c<K, V> cVar2 = this.j;
            if (cVar2 == cVar) {
                this.j = c(cVar2);
            }
            if (this.k == cVar) {
                this.k = f();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract c<K, V> c(c<K, V> cVar);

        /* access modifiers changed from: package-private */
        public abstract c<K, V> d(c<K, V> cVar);

        /* renamed from: e */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.k;
            this.k = f();
            return cVar;
        }

        public boolean hasNext() {
            return this.k != null;
        }
    }

    interface f<K, V> {
        void b(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> d() {
        C0020b bVar = new C0020b(this.k, this.j);
        this.l.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it.hasNext() && !it2.hasNext();
    }

    public Map.Entry<K, V> g() {
        return this.j;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map.Entry) it.next()).hashCode();
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public c<K, V> i(K k2) {
        c<K, V> cVar = this.j;
        while (cVar != null && !cVar.j.equals(k2)) {
            cVar = cVar.l;
        }
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.j, this.k);
        this.l.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public b<K, V>.d j() {
        b<K, V>.d dVar = new d();
        this.l.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> k() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    public c<K, V> l(K k2, V v) {
        c<K, V> cVar = new c<>(k2, v);
        this.m++;
        c<K, V> cVar2 = this.k;
        if (cVar2 == null) {
            this.j = cVar;
        } else {
            cVar2.l = cVar;
            cVar.m = cVar2;
        }
        this.k = cVar;
        return cVar;
    }

    public V p(K k2, V v) {
        c i = i(k2);
        if (i != null) {
            return i.k;
        }
        l(k2, v);
        return null;
    }

    public V r(K k2) {
        c i = i(k2);
        if (i == null) {
            return null;
        }
        this.m--;
        if (!this.l.isEmpty()) {
            for (f<K, V> b2 : this.l.keySet()) {
                b2.b(i);
            }
        }
        c<K, V> cVar = i.m;
        c<K, V> cVar2 = i.l;
        if (cVar != null) {
            cVar.l = cVar2;
        } else {
            this.j = cVar2;
        }
        c<K, V> cVar3 = i.l;
        if (cVar3 != null) {
            cVar3.m = cVar;
        } else {
            this.k = cVar;
        }
        i.l = null;
        i.m = null;
        return i.k;
    }

    public int size() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
