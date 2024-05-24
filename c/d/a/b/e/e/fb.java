package c.d.a.b.e.e;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class fb extends AbstractList implements RandomAccess, e9 {
    /* access modifiers changed from: private */
    public final e9 j;

    public fb(e9 e9Var) {
        this.j = e9Var;
    }

    public final e9 e() {
        return this;
    }

    public final List f() {
        return this.j.f();
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        return ((d9) this.j).get(i);
    }

    public final Iterator iterator() {
        return new eb(this);
    }

    public final ListIterator listIterator(int i) {
        return new db(this, i);
    }

    public final void n(r7 r7Var) {
        throw new UnsupportedOperationException();
    }

    public final Object q(int i) {
        return this.j.q(i);
    }

    public final int size() {
        return this.j.size();
    }
}
