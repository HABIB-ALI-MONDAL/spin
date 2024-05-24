package c.d.a.b.e.e;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class b8 extends e7 implements RandomAccess, x8, ea {
    private static final b8 m;
    private double[] k;
    private int l;

    static {
        b8 b8Var = new b8(new double[0], 0);
        m = b8Var;
        b8Var.b();
    }

    b8() {
        this(new double[10], 0);
    }

    private b8(double[] dArr, int i) {
        this.k = dArr;
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
        double doubleValue = ((Double) obj).doubleValue();
        d();
        if (i < 0 || i > (i2 = this.l)) {
            throw new IndexOutOfBoundsException(i(i));
        }
        double[] dArr = this.k;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.k, i, dArr2, i + 1, this.l - i);
            this.k = dArr2;
        }
        this.k[i] = doubleValue;
        this.l++;
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        g(((Double) obj).doubleValue());
        return true;
    }

    public final boolean addAll(Collection collection) {
        d();
        y8.e(collection);
        if (!(collection instanceof b8)) {
            return super.addAll(collection);
        }
        b8 b8Var = (b8) collection;
        int i = b8Var.l;
        if (i == 0) {
            return false;
        }
        int i2 = this.l;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.k;
            if (i3 > dArr.length) {
                this.k = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(b8Var.k, 0, this.k, this.l, b8Var.l);
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
        if (!(obj instanceof b8)) {
            return super.equals(obj);
        }
        b8 b8Var = (b8) obj;
        if (this.l != b8Var.l) {
            return false;
        }
        double[] dArr = b8Var.k;
        for (int i = 0; i < this.l; i++) {
            if (Double.doubleToLongBits(this.k[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final void g(double d2) {
        d();
        int i = this.l;
        double[] dArr = this.k;
        if (i == dArr.length) {
            double[] dArr2 = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.k = dArr2;
        }
        double[] dArr3 = this.k;
        int i2 = this.l;
        this.l = i2 + 1;
        dArr3[i2] = d2;
    }

    public final /* synthetic */ Object get(int i) {
        j(i);
        return Double.valueOf(this.k[i]);
    }

    public final /* bridge */ /* synthetic */ x8 h(int i) {
        if (i >= this.l) {
            return new b8(Arrays.copyOf(this.k, i), this.l);
        }
        throw new IllegalArgumentException();
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.l; i2++) {
            i = (i * 31) + y8.c(Double.doubleToLongBits(this.k[i2]));
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.k[i2] == doubleValue) {
                return i2;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        d();
        j(i);
        double[] dArr = this.k;
        double d2 = dArr[i];
        int i2 = this.l;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.l--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        d();
        if (i2 >= i) {
            double[] dArr = this.k;
            System.arraycopy(dArr, i2, dArr, i, this.l - i2);
            this.l -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        d();
        j(i);
        double[] dArr = this.k;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    public final int size() {
        return this.l;
    }
}
