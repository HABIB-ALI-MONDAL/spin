package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class d implements Iterator {
    final /* synthetic */ Iterator j;
    final /* synthetic */ Iterator k;

    d(f fVar, Iterator it, Iterator it2) {
        this.j = it;
        this.k = it2;
    }

    public final boolean hasNext() {
        if (this.j.hasNext()) {
            return true;
        }
        return this.k.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        if (this.j.hasNext()) {
            return new u(((Integer) this.j.next()).toString());
        }
        if (this.k.hasNext()) {
            return new u((String) this.k.next());
        }
        throw new NoSuchElementException();
    }
}
