package c.d.a.b.e.e;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class ua extends AbstractSet {
    final /* synthetic */ wa j;

    /* synthetic */ ua(wa waVar, ta taVar) {
        this.j = waVar;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.j.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public final void clear() {
        this.j.clear();
    }

    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.j.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public final Iterator iterator() {
        return new sa(this.j, (ra) null);
    }

    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.j.remove(entry.getKey());
        return true;
    }

    public final int size() {
        return this.j.size();
    }
}
