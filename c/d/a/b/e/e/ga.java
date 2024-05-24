package c.d.a.b.e.e;

import java.util.Arrays;
import java.util.RandomAccess;

final class ga extends e7 implements RandomAccess {
    private static final ga m;
    private Object[] k;
    private int l;

    static {
        ga gaVar = new ga(new Object[0], 0);
        m = gaVar;
        gaVar.b();
    }

    private ga(Object[] objArr, int i) {
        this.k = objArr;
        this.l = i;
    }

    public static ga g() {
        return m;
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

    public final void add(int i, Object obj) {
        int i2;
        d();
        if (i < 0 || i > (i2 = this.l)) {
            throw new IndexOutOfBoundsException(i(i));
        }
        Object[] objArr = this.k;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[(((i2 * 3) / 2) + 1)];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.k, i, objArr2, i + 1, this.l - i);
            this.k = objArr2;
        }
        this.k[i] = obj;
        this.l++;
        this.modCount++;
    }

    public final boolean add(Object obj) {
        d();
        int i = this.l;
        Object[] objArr = this.k;
        if (i == objArr.length) {
            this.k = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.k;
        int i2 = this.l;
        this.l = i2 + 1;
        objArr2[i2] = obj;
        this.modCount++;
        return true;
    }

    public final Object get(int i) {
        j(i);
        return this.k[i];
    }

    public final /* bridge */ /* synthetic */ x8 h(int i) {
        if (i >= this.l) {
            return new ga(Arrays.copyOf(this.k, i), this.l);
        }
        throw new IllegalArgumentException();
    }

    public final Object remove(int i) {
        d();
        j(i);
        Object[] objArr = this.k;
        Object obj = objArr[i];
        int i2 = this.l;
        if (i < i2 - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (i2 - i) - 1);
        }
        this.l--;
        this.modCount++;
        return obj;
    }

    public final Object set(int i, Object obj) {
        d();
        j(i);
        Object[] objArr = this.k;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        this.modCount++;
        return obj2;
    }

    public final int size() {
        return this.l;
    }
}
