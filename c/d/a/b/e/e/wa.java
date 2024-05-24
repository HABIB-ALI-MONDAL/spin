package c.d.a.b.e.e;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class wa extends AbstractMap {
    private final int j;
    /* access modifiers changed from: private */
    public List k = Collections.emptyList();
    /* access modifiers changed from: private */
    public Map l = Collections.emptyMap();
    private boolean m;
    private volatile ua n;
    private Map o = Collections.emptyMap();

    /* synthetic */ wa(int i, va vaVar) {
        this.j = i;
    }

    private final int k(Comparable comparable) {
        int size = this.k.size() - 1;
        int i = 0;
        if (size >= 0) {
            int compareTo = comparable.compareTo(((qa) this.k.get(size)).d());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = comparable.compareTo(((qa) this.k.get(i2)).d());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* access modifiers changed from: private */
    public final Object l(int i) {
        n();
        Object value = ((qa) this.k.remove(i)).getValue();
        if (!this.l.isEmpty()) {
            Iterator it = m().entrySet().iterator();
            List list = this.k;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new qa(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap m() {
        n();
        if (this.l.isEmpty() && !(this.l instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.l = treeMap;
            this.o = treeMap.descendingMap();
        }
        return (SortedMap) this.l;
    }

    /* access modifiers changed from: private */
    public final void n() {
        if (this.m) {
            throw new UnsupportedOperationException();
        }
    }

    public void a() {
        if (!this.m) {
            this.l = this.l.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.l);
            this.o = this.o.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.o);
            this.m = true;
        }
    }

    public final int b() {
        return this.k.size();
    }

    public final Iterable c() {
        return this.l.isEmpty() ? pa.a() : this.l.entrySet();
    }

    public final void clear() {
        n();
        if (!this.k.isEmpty()) {
            this.k.clear();
        }
        if (!this.l.isEmpty()) {
            this.l.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return k(comparable) >= 0 || this.l.containsKey(comparable);
    }

    /* renamed from: e */
    public final Object put(Comparable comparable, Object obj) {
        n();
        int k2 = k(comparable);
        if (k2 >= 0) {
            return ((qa) this.k.get(k2)).setValue(obj);
        }
        n();
        if (this.k.isEmpty() && !(this.k instanceof ArrayList)) {
            this.k = new ArrayList(this.j);
        }
        int i = -(k2 + 1);
        if (i >= this.j) {
            return m().put(comparable, obj);
        }
        int size = this.k.size();
        int i2 = this.j;
        if (size == i2) {
            qa qaVar = (qa) this.k.remove(i2 - 1);
            m().put(qaVar.d(), qaVar.getValue());
        }
        this.k.add(i, new qa(this, comparable, obj));
        return null;
    }

    public final Set entrySet() {
        if (this.n == null) {
            this.n = new ua(this, (ta) null);
        }
        return this.n;
    }

    public final boolean equals(Object obj) {
        Object entrySet;
        Object entrySet2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wa)) {
            return super.equals(obj);
        }
        wa waVar = (wa) obj;
        int size = size();
        if (size != waVar.size()) {
            return false;
        }
        int b2 = b();
        if (b2 == waVar.b()) {
            for (int i = 0; i < b2; i++) {
                if (!g(i).equals(waVar.g(i))) {
                    return false;
                }
            }
            if (b2 == size) {
                return true;
            }
            entrySet = this.l;
            entrySet2 = waVar.l;
        } else {
            entrySet = entrySet();
            entrySet2 = waVar.entrySet();
        }
        return entrySet.equals(entrySet2);
    }

    public final Map.Entry g(int i) {
        return (Map.Entry) this.k.get(i);
    }

    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int k2 = k(comparable);
        return k2 >= 0 ? ((qa) this.k.get(k2)).getValue() : this.l.get(comparable);
    }

    public final int hashCode() {
        int b2 = b();
        int i = 0;
        for (int i2 = 0; i2 < b2; i2++) {
            i += ((qa) this.k.get(i2)).hashCode();
        }
        return this.l.size() > 0 ? i + this.l.hashCode() : i;
    }

    public final boolean j() {
        return this.m;
    }

    public final Object remove(Object obj) {
        n();
        Comparable comparable = (Comparable) obj;
        int k2 = k(comparable);
        if (k2 >= 0) {
            return l(k2);
        }
        if (this.l.isEmpty()) {
            return null;
        }
        return this.l.remove(comparable);
    }

    public final int size() {
        return this.k.size() + this.l.size();
    }
}
