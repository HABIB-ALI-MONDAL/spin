package c.d.a.b.e.e;

import java.util.Iterator;

final class l implements Iterator {
    final /* synthetic */ Iterator j;

    l(Iterator it) {
        this.j = it;
    }

    public final boolean hasNext() {
        return this.j.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return new u((String) this.j.next());
    }
}
