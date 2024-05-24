package b.c;

public class h<E> implements Cloneable {
    private static final Object n = new Object();
    private boolean j;
    private int[] k;
    private Object[] l;
    private int m;

    public h() {
        this(10);
    }

    public h(int i) {
        this.j = false;
        if (i == 0) {
            this.k = c.f525a;
            this.l = c.f527c;
        } else {
            int e2 = c.e(i);
            this.k = new int[e2];
            this.l = new Object[e2];
        }
        this.m = 0;
    }

    private void g() {
        int i = this.m;
        int[] iArr = this.k;
        Object[] objArr = this.l;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != n) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.j = false;
        this.m = i2;
    }

    public void a(int i, E e2) {
        int i2 = this.m;
        if (i2 == 0 || i > this.k[i2 - 1]) {
            if (this.j && i2 >= this.k.length) {
                g();
            }
            int i3 = this.m;
            if (i3 >= this.k.length) {
                int e3 = c.e(i3 + 1);
                int[] iArr = new int[e3];
                Object[] objArr = new Object[e3];
                int[] iArr2 = this.k;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.l;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.k = iArr;
                this.l = objArr;
            }
            this.k[i3] = i;
            this.l[i3] = e2;
            this.m = i3 + 1;
            return;
        }
        m(i, e2);
    }

    public void b() {
        int i = this.m;
        Object[] objArr = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.m = 0;
        this.j = false;
    }

    /* renamed from: d */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.k = (int[]) this.k.clone();
            hVar.l = (Object[]) this.l.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.l;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.k
            int r1 = r3.m
            int r4 = b.c.c.a(r0, r1, r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.l
            r1 = r0[r4]
            java.lang.Object r2 = n
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.j = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.h.e(int):void");
    }

    public E i(int i) {
        return j(i, (Object) null);
    }

    public E j(int i, E e2) {
        int a2 = c.a(this.k, this.m, i);
        if (a2 >= 0) {
            E[] eArr = this.l;
            if (eArr[a2] != n) {
                return eArr[a2];
            }
        }
        return e2;
    }

    public int k(int i) {
        if (this.j) {
            g();
        }
        return c.a(this.k, this.m, i);
    }

    public int l(int i) {
        if (this.j) {
            g();
        }
        return this.k[i];
    }

    public void m(int i, E e2) {
        int a2 = c.a(this.k, this.m, i);
        if (a2 >= 0) {
            this.l[a2] = e2;
            return;
        }
        int i2 = a2 ^ -1;
        int i3 = this.m;
        if (i2 < i3) {
            Object[] objArr = this.l;
            if (objArr[i2] == n) {
                this.k[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.j && i3 >= this.k.length) {
            g();
            i2 = c.a(this.k, this.m, i) ^ -1;
        }
        int i4 = this.m;
        if (i4 >= this.k.length) {
            int e3 = c.e(i4 + 1);
            int[] iArr = new int[e3];
            Object[] objArr2 = new Object[e3];
            int[] iArr2 = this.k;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.l;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.k = iArr;
            this.l = objArr2;
        }
        int i5 = this.m;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.k;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.l;
            System.arraycopy(objArr4, i2, objArr4, i6, this.m - i2);
        }
        this.k[i2] = i;
        this.l[i2] = e2;
        this.m++;
    }

    public void n(int i) {
        e(i);
    }

    public int o() {
        if (this.j) {
            g();
        }
        return this.m;
    }

    public E p(int i) {
        if (this.j) {
            g();
        }
        return this.l[i];
    }

    public String toString() {
        if (o() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.m * 28);
        sb.append('{');
        for (int i = 0; i < this.m; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(l(i));
            sb.append('=');
            Object p = p(i);
            if (p != this) {
                sb.append(p);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
