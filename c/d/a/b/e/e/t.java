package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class t implements Iterator {
    private int j = 0;
    final /* synthetic */ u k;

    t(u uVar) {
        this.k = uVar;
    }

    public final boolean hasNext() {
        return this.j < this.k.j.length();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.j;
        u uVar = this.k;
        if (i < uVar.j.length()) {
            String j2 = uVar.j;
            this.j = i + 1;
            return new u(String.valueOf(j2.charAt(i)));
        }
        throw new NoSuchElementException();
    }
}
