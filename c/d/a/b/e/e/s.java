package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class s implements Iterator {
    private int j = 0;
    final /* synthetic */ u k;

    s(u uVar) {
        this.k = uVar;
    }

    public final boolean hasNext() {
        return this.j < this.k.j.length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.j;
        if (i < this.k.j.length()) {
            this.j = i + 1;
            return new u(String.valueOf(i));
        }
        throw new NoSuchElementException();
    }
}
