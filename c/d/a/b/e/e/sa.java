package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.Map;

final class sa implements Iterator {
    private int j = -1;
    private boolean k;
    private Iterator l;
    final /* synthetic */ wa m;

    /* synthetic */ sa(wa waVar, ra raVar) {
        this.m = waVar;
    }

    private final Iterator b() {
        if (this.l == null) {
            this.l = this.m.l.entrySet().iterator();
        }
        return this.l;
    }

    public final boolean hasNext() {
        if (this.j + 1 >= this.m.k.size()) {
            return !this.m.l.isEmpty() && b().hasNext();
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.k = true;
        int i = this.j + 1;
        this.j = i;
        return (Map.Entry) (i < this.m.k.size() ? this.m.k.get(this.j) : b().next());
    }

    public final void remove() {
        if (this.k) {
            this.k = false;
            this.m.n();
            if (this.j < this.m.k.size()) {
                wa waVar = this.m;
                int i = this.j;
                this.j = i - 1;
                Object unused = waVar.l(i);
                return;
            }
            b().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
