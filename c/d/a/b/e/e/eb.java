package c.d.a.b.e.e;

import java.util.Iterator;

final class eb implements Iterator {
    final Iterator j;
    final /* synthetic */ fb k;

    eb(fb fbVar) {
        this.k = fbVar;
        this.j = fbVar.j.iterator();
    }

    public final boolean hasNext() {
        return this.j.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.j.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
