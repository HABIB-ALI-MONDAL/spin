package b.b.a.b;

import b.b.a.b.b;
import java.util.HashMap;
import java.util.Map;

public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> n = new HashMap<>();

    public boolean contains(K k) {
        return this.n.containsKey(k);
    }

    /* access modifiers changed from: protected */
    public b.c<K, V> i(K k) {
        return this.n.get(k);
    }

    public V p(K k, V v) {
        b.c i = i(k);
        if (i != null) {
            return i.k;
        }
        this.n.put(k, l(k, v));
        return null;
    }

    public V r(K k) {
        V r = super.r(k);
        this.n.remove(k);
        return r;
    }

    public Map.Entry<K, V> s(K k) {
        if (contains(k)) {
            return this.n.get(k).m;
        }
        return null;
    }
}
