package c.d.a.b.e.e;

import java.util.Arrays;

public final class bb {

    /* renamed from: f  reason: collision with root package name */
    private static final bb f1590f = new bb(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f1591a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f1592b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f1593c;

    /* renamed from: d  reason: collision with root package name */
    private int f1594d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1595e;

    private bb() {
        this(0, new int[8], new Object[8], true);
    }

    private bb(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f1594d = -1;
        this.f1591a = i;
        this.f1592b = iArr;
        this.f1593c = objArr;
        this.f1595e = z;
    }

    public static bb c() {
        return f1590f;
    }

    static bb e(bb bbVar, bb bbVar2) {
        int i = bbVar.f1591a + bbVar2.f1591a;
        int[] copyOf = Arrays.copyOf(bbVar.f1592b, i);
        System.arraycopy(bbVar2.f1592b, 0, copyOf, bbVar.f1591a, bbVar2.f1591a);
        Object[] copyOf2 = Arrays.copyOf(bbVar.f1593c, i);
        System.arraycopy(bbVar2.f1593c, 0, copyOf2, bbVar.f1591a, bbVar2.f1591a);
        return new bb(i, copyOf, copyOf2, true);
    }

    static bb f() {
        return new bb(0, new int[8], new Object[8], true);
    }

    private final void l(int i) {
        int[] iArr = this.f1592b;
        if (i > iArr.length) {
            int i2 = this.f1591a;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.f1592b = Arrays.copyOf(iArr, i);
            this.f1593c = Arrays.copyOf(this.f1593c, i);
        }
    }

    public final int a() {
        int i;
        int i2;
        int i3;
        int i4 = this.f1594d;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f1591a; i6++) {
            int i7 = this.f1592b[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.f1593c[i6]).longValue();
                    i = z7.a(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int a2 = z7.a(i8 << 3);
                    int i10 = ((r7) this.f1593c[i6]).i();
                    i5 += a2 + z7.a(i10) + i10;
                } else if (i9 == 3) {
                    int D = z7.D(i8);
                    i3 = D + D;
                    i2 = ((bb) this.f1593c[i6]).a();
                } else if (i9 == 5) {
                    ((Integer) this.f1593c[i6]).intValue();
                    i = z7.a(i8 << 3) + 4;
                } else {
                    throw new IllegalStateException(a9.a());
                }
                i5 += i;
            } else {
                long longValue = ((Long) this.f1593c[i6]).longValue();
                i3 = z7.a(i8 << 3);
                i2 = z7.b(longValue);
            }
            i = i3 + i2;
            i5 += i;
        }
        this.f1594d = i5;
        return i5;
    }

    public final int b() {
        int i = this.f1594d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f1591a; i3++) {
            int i4 = this.f1592b[i3];
            int a2 = z7.a(8);
            int i5 = ((r7) this.f1593c[i3]).i();
            i2 += a2 + a2 + z7.a(16) + z7.a(i4 >>> 3) + z7.a(24) + z7.a(i5) + i5;
        }
        this.f1594d = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final bb d(bb bbVar) {
        if (bbVar.equals(f1590f)) {
            return this;
        }
        g();
        int i = this.f1591a + bbVar.f1591a;
        l(i);
        System.arraycopy(bbVar.f1592b, 0, this.f1592b, this.f1591a, bbVar.f1591a);
        System.arraycopy(bbVar.f1593c, 0, this.f1593c, this.f1591a, bbVar.f1591a);
        this.f1591a = i;
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof bb)) {
            return false;
        }
        bb bbVar = (bb) obj;
        int i = this.f1591a;
        if (i == bbVar.f1591a) {
            int[] iArr = this.f1592b;
            int[] iArr2 = bbVar.f1592b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.f1593c;
                    Object[] objArr2 = bbVar.f1593c;
                    int i3 = this.f1591a;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        if (!this.f1595e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void h() {
        this.f1595e = false;
    }

    public final int hashCode() {
        int i = this.f1591a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f1592b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f1593c;
        int i7 = this.f1591a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void i(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f1591a; i2++) {
            z9.b(sb, i, String.valueOf(this.f1592b[i2] >>> 3), this.f1593c[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void j(int i, Object obj) {
        g();
        l(this.f1591a + 1);
        int[] iArr = this.f1592b;
        int i2 = this.f1591a;
        iArr[i2] = i;
        this.f1593c[i2] = obj;
        this.f1591a = i2 + 1;
    }

    public final void k(tb tbVar) {
        if (this.f1591a != 0) {
            for (int i = 0; i < this.f1591a; i++) {
                int i2 = this.f1592b[i];
                Object obj = this.f1593c[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    tbVar.I(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    tbVar.v(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    tbVar.s(i3, (r7) obj);
                } else if (i4 == 3) {
                    tbVar.p(i3);
                    ((bb) obj).k(tbVar);
                    tbVar.H(i3);
                } else if (i4 == 5) {
                    tbVar.A(i3, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(a9.a());
                }
            }
        }
    }
}
