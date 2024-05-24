package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class d9 extends e7 implements RandomAccess, e9 {
    private static final d9 l;
    private final List k;

    static {
        d9 d9Var = new d9(10);
        l = d9Var;
        d9Var.b();
    }

    public d9() {
        this(10);
    }

    public d9(int i) {
        this.k = new ArrayList(i);
    }

    private d9(ArrayList arrayList) {
        this.k = arrayList;
    }

    private static String i(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof r7 ? ((r7) obj).w(y8.f1783a) : y8.g((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        d();
        this.k.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection collection) {
        d();
        if (collection instanceof e9) {
            collection = ((e9) collection).f();
        }
        boolean addAll = this.k.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        d();
        this.k.clear();
        this.modCount++;
    }

    public final e9 e() {
        return c() ? new fb(this) : this;
    }

    public final List f() {
        return Collections.unmodifiableList(this.k);
    }

    /* renamed from: g */
    public final String get(int i) {
        Object obj = this.k.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof r7) {
            r7 r7Var = (r7) obj;
            String w = r7Var.w(y8.f1783a);
            if (r7Var.r()) {
                this.k.set(i, w);
            }
            return w;
        }
        byte[] bArr = (byte[]) obj;
        String g = y8.g(bArr);
        if (y8.h(bArr)) {
            this.k.set(i, g);
        }
        return g;
    }

    public final /* bridge */ /* synthetic */ x8 h(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.k);
            return new d9(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final void n(r7 r7Var) {
        d();
        this.k.add(r7Var);
        this.modCount++;
    }

    public final Object q(int i) {
        return this.k.get(i);
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        d();
        Object remove = this.k.remove(i);
        this.modCount++;
        return i(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        d();
        return i(this.k.set(i, (String) obj));
    }

    public final int size() {
        return this.k.size();
    }
}
