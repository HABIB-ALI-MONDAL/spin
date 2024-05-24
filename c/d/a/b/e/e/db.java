package c.d.a.b.e.e;

import java.util.ListIterator;

final class db implements ListIterator {
    final ListIterator j;
    final /* synthetic */ int k;
    final /* synthetic */ fb l;

    db(fb fbVar, int i) {
        this.l = fbVar;
        this.k = i;
        this.j = fbVar.j.listIterator(i);
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.j.hasNext();
    }

    public final boolean hasPrevious() {
        return this.j.hasPrevious();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.j.next();
    }

    public final int nextIndex() {
        return this.j.nextIndex();
    }

    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.j.previous();
    }

    public final int previousIndex() {
        return this.j.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}
