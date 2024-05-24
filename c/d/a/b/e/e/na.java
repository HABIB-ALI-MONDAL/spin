package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class na implements Iterator {
    na() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
