package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class e implements Iterator {
    private int j = 0;
    final /* synthetic */ f k;

    e(f fVar) {
        this.k = fVar;
    }

    public final boolean hasNext() {
        return this.j < this.k.t();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        if (this.j < this.k.t()) {
            f fVar = this.k;
            int i = this.j;
            this.j = i + 1;
            return fVar.u(i);
        }
        int i2 = this.j;
        throw new NoSuchElementException("Out of bounds index: " + i2);
    }
}
