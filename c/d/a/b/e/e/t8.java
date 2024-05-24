package c.d.a.b.e.e;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class t8 extends e7 implements RandomAccess, v8, ea {
    private static final t8 m;
    private int[] k;
    private int l;

    static {
        t8 t8Var = new t8(new int[0], 0);
        m = t8Var;
        t8Var.b();
    }

    t8() {
        this(new int[10], 0);
    }

    private t8(int[] iArr, int i) {
        this.k = iArr;
        this.l = i;
    }

    public static t8 i() {
        return m;
    }

    private final String k(int i) {
        int i2 = this.l;
        return "Index:" + i + ", Size:" + i2;
    }

    private final void l(int i) {
        if (i < 0 || i >= this.l) {
            throw new IndexOutOfBoundsException(k(i));
        }
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        d();
        if (i < 0 || i > (i2 = this.l)) {
            throw new IndexOutOfBoundsException(k(i));
        }
        int[] iArr = this.k;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.k, i, iArr2, i + 1, this.l - i);
            this.k = iArr2;
        }
        this.k[i] = intValue;
        this.l++;
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        j(((Integer) obj).intValue());
        return true;
    }

    public final boolean addAll(Collection collection) {
        d();
        y8.e(collection);
        if (!(collection instanceof t8)) {
            return super.addAll(collection);
        }
        t8 t8Var = (t8) collection;
        int i = t8Var.l;
        if (i == 0) {
            return false;
        }
        int i2 = this.l;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.k;
            if (i3 > iArr.length) {
                this.k = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(t8Var.k, 0, this.k, this.l, t8Var.l);
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
        if (!(obj instanceof t8)) {
            return super.equals(obj);
        }
        t8 t8Var = (t8) obj;
        if (this.l != t8Var.l) {
            return false;
        }
        int[] iArr = t8Var.k;
        for (int i = 0; i < this.l; i++) {
            if (this.k[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int g(int i) {
        l(i);
        return this.k[i];
    }

    public final /* synthetic */ Object get(int i) {
        l(i);
        return Integer.valueOf(this.k[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.l; i2++) {
            i = (i * 31) + this.k[i2];
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.k[i2] == intValue) {
                return i2;
            }
        }
        return -1;
    }

    public final void j(int i) {
        d();
        int i2 = this.l;
        int[] iArr = this.k;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.k = iArr2;
        }
        int[] iArr3 = this.k;
        int i3 = this.l;
        this.l = i3 + 1;
        iArr3[i3] = i;
    }

    /* renamed from: o */
    public final v8 h(int i) {
        if (i >= this.l) {
            return new t8(Arrays.copyOf(this.k, i), this.l);
        }
        throw new IllegalArgumentException();
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        d();
        l(i);
        int[] iArr = this.k;
        int i2 = iArr[i];
        int i3 = this.l;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.l--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        d();
        if (i2 >= i) {
            int[] iArr = this.k;
            System.arraycopy(iArr, i2, iArr, i, this.l - i2);
            this.l -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        d();
        l(i);
        int[] iArr = this.k;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.l;
    }
}
