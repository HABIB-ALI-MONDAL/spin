package c.d.a.b.e.e;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class e7 extends AbstractList implements x8 {
    private boolean j = true;

    e7() {
    }

    public boolean add(Object obj) {
        d();
        return super.add(obj);
    }

    public boolean addAll(int i, Collection collection) {
        d();
        return super.addAll(i, collection);
    }

    public boolean addAll(Collection collection) {
        d();
        return super.addAll(collection);
    }

    public final void b() {
        this.j = false;
    }

    public final boolean c() {
        return this.j;
    }

    public void clear() {
        d();
        super.clear();
    }

    /* access modifiers changed from: protected */
    public final void d() {
        if (!this.j) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public abstract Object remove(int i);

    public final boolean remove(Object obj) {
        d();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public final boolean removeAll(Collection collection) {
        d();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        d();
        return super.retainAll(collection);
    }
}
