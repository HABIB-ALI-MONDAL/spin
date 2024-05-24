package b.c;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class g<K, V> {
    static Object[] m;
    static int n;
    static Object[] o;
    static int p;
    int[] j;
    Object[] k;
    int l;

    public g() {
        this.j = c.f525a;
        this.k = c.f527c;
        this.l = 0;
    }

    public g(int i) {
        if (i == 0) {
            this.j = c.f525a;
            this.k = c.f527c;
        } else {
            a(i);
        }
        this.l = 0;
    }

    private void a(int i) {
        if (i == 8) {
            synchronized (a.class) {
                Object[] objArr = o;
                if (objArr != null) {
                    this.k = objArr;
                    o = (Object[]) objArr[0];
                    this.j = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    p--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                Object[] objArr2 = m;
                if (objArr2 != null) {
                    this.k = objArr2;
                    m = (Object[]) objArr2[0];
                    this.j = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    n--;
                    return;
                }
            }
        }
        this.j = new int[i];
        this.k = new Object[(i << 1)];
    }

    private static int b(int[] iArr, int i, int i2) {
        try {
            return c.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (p < 10) {
                    objArr[0] = o;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    o = objArr;
                    p++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (n < 10) {
                    objArr[0] = m;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    m = objArr;
                    n++;
                }
            }
        }
    }

    public void c(int i) {
        int i2 = this.l;
        int[] iArr = this.j;
        if (iArr.length < i) {
            Object[] objArr = this.k;
            a(i);
            if (this.l > 0) {
                System.arraycopy(iArr, 0, this.j, 0, i2);
                System.arraycopy(objArr, 0, this.k, 0, i2 << 1);
            }
            d(iArr, objArr, i2);
        }
        if (this.l != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i = this.l;
        if (i > 0) {
            int[] iArr = this.j;
            Object[] objArr = this.k;
            this.j = c.f525a;
            this.k = c.f527c;
            this.l = 0;
            d(iArr, objArr, i);
        }
        if (this.l > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    /* access modifiers changed from: package-private */
    public int e(Object obj, int i) {
        int i2 = this.l;
        if (i2 == 0) {
            return -1;
        }
        int b2 = b(this.j, i2, i);
        if (b2 < 0 || obj.equals(this.k[b2 << 1])) {
            return b2;
        }
        int i3 = b2 + 1;
        while (i3 < i2 && this.j[i3] == i) {
            if (obj.equals(this.k[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = b2 - 1;
        while (i4 >= 0 && this.j[i4] == i) {
            if (obj.equals(this.k[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            int i = 0;
            while (i < this.l) {
                try {
                    Object i2 = i(i);
                    Object m2 = m(i);
                    Object obj2 = gVar.get(i2);
                    if (m2 == null) {
                        if (obj2 != null || !gVar.containsKey(i2)) {
                            return false;
                        }
                    } else if (!m2.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i3 = 0;
            while (i3 < this.l) {
                try {
                    Object i4 = i(i3);
                    Object m3 = m(i3);
                    Object obj3 = map.get(i4);
                    if (m3 == null) {
                        if (obj3 != null || !map.containsKey(i4)) {
                            return false;
                        }
                    } else if (!m3.equals(obj3)) {
                        return false;
                    }
                    i3++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public int g() {
        int i = this.l;
        if (i == 0) {
            return -1;
        }
        int b2 = b(this.j, i, 0);
        if (b2 < 0 || this.k[b2 << 1] == null) {
            return b2;
        }
        int i2 = b2 + 1;
        while (i2 < i && this.j[i2] == 0) {
            if (this.k[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = b2 - 1;
        while (i3 >= 0 && this.j[i3] == 0) {
            if (this.k[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    public V get(Object obj) {
        int f2 = f(obj);
        if (f2 >= 0) {
            return this.k[(f2 << 1) + 1];
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int h(Object obj) {
        int i = this.l * 2;
        Object[] objArr = this.k;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.j;
        Object[] objArr = this.k;
        int i = this.l;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public K i(int i) {
        return this.k[i << 1];
    }

    public boolean isEmpty() {
        return this.l <= 0;
    }

    public void j(g<? extends K, ? extends V> gVar) {
        int i = gVar.l;
        c(this.l + i);
        if (this.l != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(gVar.i(i2), gVar.m(i2));
            }
        } else if (i > 0) {
            System.arraycopy(gVar.j, 0, this.j, 0, i);
            System.arraycopy(gVar.k, 0, this.k, 0, i << 1);
            this.l = i;
        }
    }

    public V k(int i) {
        V[] vArr = this.k;
        int i2 = i << 1;
        V v = vArr[i2 + 1];
        int i3 = this.l;
        int i4 = 0;
        if (i3 <= 1) {
            d(this.j, vArr, i3);
            this.j = c.f525a;
            this.k = c.f527c;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.j;
            int i6 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(iArr, i7, iArr, i, i8);
                    Object[] objArr = this.k;
                    System.arraycopy(objArr, i7 << 1, objArr, i2, i8 << 1);
                }
                Object[] objArr2 = this.k;
                int i9 = i5 << 1;
                objArr2[i9] = null;
                objArr2[i9 + 1] = null;
            } else {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                a(i6);
                if (i3 == this.l) {
                    if (i > 0) {
                        System.arraycopy(iArr, 0, this.j, 0, i);
                        System.arraycopy(vArr, 0, this.k, 0, i2);
                    }
                    if (i < i5) {
                        int i10 = i + 1;
                        int i11 = i5 - i;
                        System.arraycopy(iArr, i10, this.j, i, i11);
                        System.arraycopy(vArr, i10 << 1, this.k, i2, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i4 = i5;
        }
        if (i3 == this.l) {
            this.l = i4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V l(int i, V v) {
        int i2 = (i << 1) + 1;
        V[] vArr = this.k;
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }

    public V m(int i) {
        return this.k[(i << 1) + 1];
    }

    public V put(K k2, V v) {
        int i;
        int i2;
        int i3 = this.l;
        if (k2 == null) {
            i2 = g();
            i = 0;
        } else {
            int hashCode = k2.hashCode();
            i = hashCode;
            i2 = e(k2, hashCode);
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            V[] vArr = this.k;
            V v2 = vArr[i4];
            vArr[i4] = v;
            return v2;
        }
        int i5 = i2 ^ -1;
        int[] iArr = this.j;
        if (i3 >= iArr.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            Object[] objArr = this.k;
            a(i6);
            if (i3 == this.l) {
                int[] iArr2 = this.j;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.k, 0, objArr.length);
                }
                d(iArr, objArr, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr3 = this.j;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr2 = this.k;
            System.arraycopy(objArr2, i5 << 1, objArr2, i7 << 1, (this.l - i5) << 1);
        }
        int i8 = this.l;
        if (i3 == i8) {
            int[] iArr4 = this.j;
            if (i5 < iArr4.length) {
                iArr4[i5] = i;
                Object[] objArr3 = this.k;
                int i9 = i5 << 1;
                objArr3[i9] = k2;
                objArr3[i9 + 1] = v;
                this.l = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int f2 = f(obj);
        if (f2 >= 0) {
            return k(f2);
        }
        return null;
    }

    public int size() {
        return this.l;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.l * 28);
        sb.append('{');
        for (int i = 0; i < this.l; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object i2 = i(i);
            if (i2 != this) {
                sb.append(i2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object m2 = m(i);
            if (m2 != this) {
                sb.append(m2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
