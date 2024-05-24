package c.d.a.b.e.e;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class l8 extends e7 implements RandomAccess, x8, ea {
    private static final l8 m;
    private float[] k;
    private int l;

    static {
        l8 l8Var = new l8(new float[0], 0);
        m = l8Var;
        l8Var.b();
    }

    l8() {
        this(new float[10], 0);
    }

    private l8(float[] fArr, int i) {
        this.k = fArr;
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
        float floatValue = ((Float) obj).floatValue();
        d();
        if (i < 0 || i > (i2 = this.l)) {
            throw new IndexOutOfBoundsException(i(i));
        }
        float[] fArr = this.k;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.k, i, fArr2, i + 1, this.l - i);
            this.k = fArr2;
        }
        this.k[i] = floatValue;
        this.l++;
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        g(((Float) obj).floatValue());
        return true;
    }

    public final boolean addAll(Collection collection) {
        d();
        y8.e(collection);
        if (!(collection instanceof l8)) {
            return super.addAll(collection);
        }
        l8 l8Var = (l8) collection;
        int i = l8Var.l;
        if (i == 0) {
            return false;
        }
        int i2 = this.l;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.k;
            if (i3 > fArr.length) {
                this.k = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(l8Var.k, 0, this.k, this.l, l8Var.l);
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
        if (!(obj instanceof l8)) {
            return super.equals(obj);
        }
        l8 l8Var = (l8) obj;
        if (this.l != l8Var.l) {
            return false;
        }
        float[] fArr = l8Var.k;
        for (int i = 0; i < this.l; i++) {
            if (Float.floatToIntBits(this.k[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final void g(float f2) {
        d();
        int i = this.l;
        float[] fArr = this.k;
        if (i == fArr.length) {
            float[] fArr2 = new float[(((i * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.k = fArr2;
        }
        float[] fArr3 = this.k;
        int i2 = this.l;
        this.l = i2 + 1;
        fArr3[i2] = f2;
    }

    public final /* synthetic */ Object get(int i) {
        j(i);
        return Float.valueOf(this.k[i]);
    }

    public final /* bridge */ /* synthetic */ x8 h(int i) {
        if (i >= this.l) {
            return new l8(Arrays.copyOf(this.k, i), this.l);
        }
        throw new IllegalArgumentException();
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.l; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.k[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.k[i2] == floatValue) {
                return i2;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i) {
        d();
        j(i);
        float[] fArr = this.k;
        float f2 = fArr[i];
        int i2 = this.l;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.l--;
        this.modCount++;
        return Float.valueOf(f2);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        d();
        if (i2 >= i) {
            float[] fArr = this.k;
            System.arraycopy(fArr, i2, fArr, i, this.l - i2);
            this.l -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        d();
        j(i);
        float[] fArr = this.k;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    public final int size() {
        return this.l;
    }
}
