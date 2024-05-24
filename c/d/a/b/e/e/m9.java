package c.d.a.b.e.e;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class m9 extends e7 implements RandomAccess, w8, ea {
    private static final m9 m;
    private long[] k;
    private int l;

    static {
        m9 m9Var = new m9(new long[0], 0);
        m = m9Var;
        m9Var.b();
    }

    m9() {
        this(new long[10], 0);
    }

    private m9(long[] jArr, int i) {
        this.k = jArr;
        this.l = i;
    }

    public static m9 g() {
        return m;
    }

    private final String j(int i) {
        int i2 = this.l;
        return "Index:" + i + ", Size:" + i2;
    }

    private final void k(int i) {
        if (i < 0 || i >= this.l) {
            throw new IndexOutOfBoundsException(j(i));
        }
    }

    public final long a(int i) {
        k(i);
        return this.k[i];
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        d();
        if (i < 0 || i > (i2 = this.l)) {
            throw new IndexOutOfBoundsException(j(i));
        }
        long[] jArr = this.k;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.k, i, jArr2, i + 1, this.l - i);
            this.k = jArr2;
        }
        this.k[i] = longValue;
        this.l++;
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        i(((Long) obj).longValue());
        return true;
    }

    public final boolean addAll(Collection collection) {
        d();
        y8.e(collection);
        if (!(collection instanceof m9)) {
            return super.addAll(collection);
        }
        m9 m9Var = (m9) collection;
        int i = m9Var.l;
        if (i == 0) {
            return false;
        }
        int i2 = this.l;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.k;
            if (i3 > jArr.length) {
                this.k = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(m9Var.k, 0, this.k, this.l, m9Var.l);
            this.l = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m9)) {
            return super.equals(obj);
        }
        m9 m9Var = (m9) obj;
        if (this.l != m9Var.l) {
            return false;
        }
        long[] jArr = m9Var.k;
        for (int i = 0; i < this.l; i++) {
            if (this.k[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        k(i);
        return Long.valueOf(this.k[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.l; i2++) {
            i = (i * 31) + y8.c(this.k[i2]);
        }
        return i;
    }

    public final void i(long j) {
        d();
        int i = this.l;
        long[] jArr = this.k;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.k = jArr2;
        }
        long[] jArr3 = this.k;
        int i2 = this.l;
        this.l = i2 + 1;
        jArr3[i2] = j;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.k[i2] == longValue) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: m */
    public final w8 h(int i) {
        if (i >= this.l) {
            return new m9(Arrays.copyOf(this.k, i), this.l);
        }
        throw new IllegalArgumentException();
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        d();
        k(i);
        long[] jArr = this.k;
        long j = jArr[i];
        int i2 = this.l;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.l--;
        this.modCount++;
        return Long.valueOf(j);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        d();
        if (i2 >= i) {
            long[] jArr = this.k;
            System.arraycopy(jArr, i2, jArr, i, this.l - i2);
            this.l -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        d();
        k(i);
        long[] jArr = this.k;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.l;
    }
}
