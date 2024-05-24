package b.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] n = new int[0];
    private static final Object[] o = new Object[0];
    private static Object[] p;
    private static int q;
    private static Object[] r;
    private static int s;
    private int[] j;
    Object[] k;
    int l;
    private f<E, E> m;

    class a extends f<E, E> {
        a() {
        }

        /* access modifiers changed from: protected */
        public void a() {
            b.this.clear();
        }

        /* access modifiers changed from: protected */
        public Object b(int i, int i2) {
            return b.this.k[i];
        }

        /* access modifiers changed from: protected */
        public Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        /* access modifiers changed from: protected */
        public int d() {
            return b.this.l;
        }

        /* access modifiers changed from: protected */
        public int e(Object obj) {
            return b.this.indexOf(obj);
        }

        /* access modifiers changed from: protected */
        public int f(Object obj) {
            return b.this.indexOf(obj);
        }

        /* access modifiers changed from: protected */
        public void g(E e2, E e3) {
            b.this.add(e2);
        }

        /* access modifiers changed from: protected */
        public void h(int i) {
            b.this.p(i);
        }

        /* access modifiers changed from: protected */
        public E i(int i, E e2) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public b(int i) {
        if (i == 0) {
            this.j = n;
            this.k = o;
        } else {
            d(i);
        }
        this.l = 0;
    }

    private void d(int i) {
        if (i == 8) {
            synchronized (b.class) {
                Object[] objArr = r;
                if (objArr != null) {
                    this.k = objArr;
                    r = (Object[]) objArr[0];
                    this.j = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    s--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (b.class) {
                Object[] objArr2 = p;
                if (objArr2 != null) {
                    this.k = objArr2;
                    p = (Object[]) objArr2[0];
                    this.j = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    q--;
                    return;
                }
            }
        }
        this.j = new int[i];
        this.k = new Object[i];
    }

    private static void i(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (s < 10) {
                    objArr[0] = r;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    r = objArr;
                    s++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (q < 10) {
                    objArr[0] = p;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    p = objArr;
                    q++;
                }
            }
        }
    }

    private f<E, E> j() {
        if (this.m == null) {
            this.m = new a();
        }
        return this.m;
    }

    private int k(Object obj, int i) {
        int i2 = this.l;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.j, i2, i);
        if (a2 < 0 || obj.equals(this.k[a2])) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.j[i3] == i) {
            if (obj.equals(this.k[i3])) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.j[i4] == i) {
            if (obj.equals(this.k[i4])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    private int l() {
        int i = this.l;
        if (i == 0) {
            return -1;
        }
        int a2 = c.a(this.j, i, 0);
        if (a2 < 0 || this.k[a2] == null) {
            return a2;
        }
        int i2 = a2 + 1;
        while (i2 < i && this.j[i2] == 0) {
            if (this.k[i2] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a2 - 1;
        while (i3 >= 0 && this.j[i3] == 0) {
            if (this.k[i3] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    public boolean add(E e2) {
        int i;
        int i2;
        if (e2 == null) {
            i2 = l();
            i = 0;
        } else {
            int hashCode = e2.hashCode();
            i = hashCode;
            i2 = k(e2, hashCode);
        }
        if (i2 >= 0) {
            return false;
        }
        int i3 = i2 ^ -1;
        int i4 = this.l;
        int[] iArr = this.j;
        if (i4 >= iArr.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            Object[] objArr = this.k;
            d(i5);
            int[] iArr2 = this.j;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.k, 0, objArr.length);
            }
            i(iArr, objArr, this.l);
        }
        int i6 = this.l;
        if (i3 < i6) {
            int[] iArr3 = this.j;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.k;
            System.arraycopy(objArr2, i3, objArr2, i7, this.l - i3);
        }
        this.j[i3] = i;
        this.k[i3] = e2;
        this.l++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        g(this.l + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public void clear() {
        int i = this.l;
        if (i != 0) {
            i(this.j, this.k, i);
            this.j = n;
            this.k = o;
            this.l = 0;
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i = 0;
            while (i < this.l) {
                try {
                    if (!set.contains(r(i))) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public void g(int i) {
        int[] iArr = this.j;
        if (iArr.length < i) {
            Object[] objArr = this.k;
            d(i);
            int i2 = this.l;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.j, 0, i2);
                System.arraycopy(objArr, 0, this.k, 0, this.l);
            }
            i(iArr, objArr, this.l);
        }
    }

    public int hashCode() {
        int[] iArr = this.j;
        int i = this.l;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(Object obj) {
        return obj == null ? l() : k(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.l <= 0;
    }

    public Iterator<E> iterator() {
        return j().m().iterator();
    }

    public E p(int i) {
        E[] eArr = this.k;
        E e2 = eArr[i];
        int i2 = this.l;
        if (i2 <= 1) {
            i(this.j, eArr, i2);
            this.j = n;
            this.k = o;
            this.l = 0;
        } else {
            int[] iArr = this.j;
            int i3 = 8;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i4 = i2 - 1;
                this.l = i4;
                if (i < i4) {
                    int i5 = i + 1;
                    System.arraycopy(iArr, i5, iArr, i, i4 - i);
                    Object[] objArr = this.k;
                    System.arraycopy(objArr, i5, objArr, i, this.l - i);
                }
                this.k[this.l] = null;
            } else {
                if (i2 > 8) {
                    i3 = i2 + (i2 >> 1);
                }
                d(i3);
                this.l--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.j, 0, i);
                    System.arraycopy(eArr, 0, this.k, 0, i);
                }
                int i6 = this.l;
                if (i < i6) {
                    int i7 = i + 1;
                    System.arraycopy(iArr, i7, this.j, i, i6 - i);
                    System.arraycopy(eArr, i7, this.k, i, this.l - i);
                }
            }
        }
        return e2;
    }

    public E r(int i) {
        return this.k[i];
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        p(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.l - 1; i >= 0; i--) {
            if (!collection.contains(this.k[i])) {
                p(i);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.l;
    }

    public Object[] toArray() {
        int i = this.l;
        Object[] objArr = new Object[i];
        System.arraycopy(this.k, 0, objArr, 0, i);
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.l) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.l);
        }
        System.arraycopy(this.k, 0, tArr, 0, this.l);
        int length = tArr.length;
        int i = this.l;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.l * 14);
        sb.append('{');
        for (int i = 0; i < this.l; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object r2 = r(i);
            if (r2 != this) {
                sb.append(r2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
