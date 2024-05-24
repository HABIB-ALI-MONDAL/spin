package b.c;

public class d<E> implements Cloneable {
    private static final Object n = new Object();
    private boolean j;
    private long[] k;
    private Object[] l;
    private int m;

    public d() {
        this(10);
    }

    public d(int i) {
        this.j = false;
        if (i == 0) {
            this.k = c.f526b;
            this.l = c.f527c;
        } else {
            int f2 = c.f(i);
            this.k = new long[f2];
            this.l = new Object[f2];
        }
        this.m = 0;
    }

    private void g() {
        int i = this.m;
        long[] jArr = this.k;
        Object[] objArr = this.l;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != n) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.j = false;
        this.m = i2;
    }

    public void a(long j2, E e2) {
        int i = this.m;
        if (i == 0 || j2 > this.k[i - 1]) {
            if (this.j && i >= this.k.length) {
                g();
            }
            int i2 = this.m;
            if (i2 >= this.k.length) {
                int f2 = c.f(i2 + 1);
                long[] jArr = new long[f2];
                Object[] objArr = new Object[f2];
                long[] jArr2 = this.k;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.l;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.k = jArr;
                this.l = objArr;
            }
            this.k[i2] = j2;
            this.l[i2] = e2;
            this.m = i2 + 1;
            return;
        }
        l(j2, e2);
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
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.k = (long[]) this.k.clone();
            dVar.l = (Object[]) this.l.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.l;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.k
            int r1 = r2.m
            int r3 = b.c.c.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.l
            r0 = r4[r3]
            java.lang.Object r1 = n
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.j = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.d.e(long):void");
    }

    public E i(long j2) {
        return j(j2, (Object) null);
    }

    public E j(long j2, E e2) {
        int b2 = c.b(this.k, this.m, j2);
        if (b2 >= 0) {
            E[] eArr = this.l;
            if (eArr[b2] != n) {
                return eArr[b2];
            }
        }
        return e2;
    }

    public long k(int i) {
        if (this.j) {
            g();
        }
        return this.k[i];
    }

    public void l(long j2, E e2) {
        int b2 = c.b(this.k, this.m, j2);
        if (b2 >= 0) {
            this.l[b2] = e2;
            return;
        }
        int i = b2 ^ -1;
        int i2 = this.m;
        if (i < i2) {
            Object[] objArr = this.l;
            if (objArr[i] == n) {
                this.k[i] = j2;
                objArr[i] = e2;
                return;
            }
        }
        if (this.j && i2 >= this.k.length) {
            g();
            i = c.b(this.k, this.m, j2) ^ -1;
        }
        int i3 = this.m;
        if (i3 >= this.k.length) {
            int f2 = c.f(i3 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.k;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.l;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.k = jArr;
            this.l = objArr2;
        }
        int i4 = this.m;
        if (i4 - i != 0) {
            long[] jArr3 = this.k;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.l;
            System.arraycopy(objArr4, i, objArr4, i5, this.m - i);
        }
        this.k[i] = j2;
        this.l[i] = e2;
        this.m++;
    }

    public int m() {
        if (this.j) {
            g();
        }
        return this.m;
    }

    public E n(int i) {
        if (this.j) {
            g();
        }
        return this.l[i];
    }

    public String toString() {
        if (m() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.m * 28);
        sb.append('{');
        for (int i = 0; i < this.m; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(k(i));
            sb.append('=');
            Object n2 = n(i);
            if (n2 != this) {
                sb.append(n2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
