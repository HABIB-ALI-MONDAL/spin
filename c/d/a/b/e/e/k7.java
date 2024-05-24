package c.d.a.b.e.e;

import java.util.NoSuchElementException;

final class k7 extends l7 {
    private int j = 0;
    private final int k;
    final /* synthetic */ r7 l;

    k7(r7 r7Var) {
        this.l = r7Var;
        this.k = r7Var.i();
    }

    public final byte a() {
        int i = this.j;
        if (i < this.k) {
            this.j = i + 1;
            return this.l.g(i);
        }
        throw new NoSuchElementException();
    }

    public final boolean hasNext() {
        return this.j < this.k;
    }
}
