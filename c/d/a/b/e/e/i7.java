package c.d.a.b.e.e;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class i7 extends e7 implements RandomAccess, x8, ea {
    private static final i7 m;
    private boolean[] k;
    private int l;

    static {
        i7 i7Var = new i7(new boolean[0], 0);
        m = i7Var;
        i7Var.b();
    }

    i7() {
        this(new boolean[10], 0);
    }

    private i7(boolean[] zArr, int i) {
        this.k = zArr;
        this.l = i;
    }

    private final String i(int i) {
        int i2 = this.l;
        return "Index:" + i + ", Size:" + i2;
    }

    private final void j(int i) {
        if (i < 0 || i >= this.l) {
            throw new IndexOutOfBoundsException(i(i));
        }
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        d();
        if (i < 0 || i > (i2 = this.l)) {
            throw new IndexOutOfBoundsException(i(i));
        }
        boolean[] zArr = this.k;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.k, i, zArr2, i + 1, this.l - i);
            this.k = zArr2;
        }
        this.k[i] = booleanValue;
        this.l++;
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        g(((Boolean) obj).booleanValue());
        return true;
    }

    public final boolean addAll(Collection collection) {
        d();
        y8.e(collection);
        if (!(collection instanceof i7)) {
            return super.addAll(collection);
        }
        i7 i7Var = (i7) collection;
        int i = i7Var.l;
        if (i == 0) {
            return false;
        }
        int i2 = this.l;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.k;
            if (i3 > zArr.length) {
                this.k = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(i7Var.k, 0, this.k, this.l, i7Var.l);
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
        if (!(obj instanceof i7)) {
            return super.equals(obj);
        }
        i7 i7Var = (i7) obj;
        if (this.l != i7Var.l) {
            return false;
        }
        boolean[] zArr = i7Var.k;
        for (int i = 0; i < this.l; i++) {
            if (this.k[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final void g(boolean z) {
        d();
        int i = this.l;
        boolean[] zArr = this.k;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[(((i * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.k = zArr2;
        }
        boolean[] zArr3 = this.k;
        int i2 = this.l;
        this.l = i2 + 1;
        zArr3[i2] = z;
    }

    public final /* synthetic */ Object get(int i) {
        j(i);
        return Boolean.valueOf(this.k[i]);
    }

    public final /* bridge */ /* synthetic */ x8 h(int i) {
        if (i >= this.l) {
            return new i7(Arrays.copyOf(this.k, i), this.l);
        }
        throw new IllegalArgumentException();
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.l; i2++) {
            i = (i * 31) + y8.a(this.k[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.k[i2] == booleanValue) {
                return i2;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        d();
        j(i);
        boolean[] zArr = this.k;
        boolean z = zArr[i];
        int i2 = this.l;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.l--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        d();
        if (i2 >= i) {
            boolean[] zArr = this.k;
            System.arraycopy(zArr, i2, zArr, i, this.l - i2);
            this.l -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        d();
        j(i);
        boolean[] zArr = this.k;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.l;
    }
}
