package c.d.a.b.e.e;

import b.a.j;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class aa<T> implements ia<T> {
    private static final int[] o = new int[0];
    private static final Unsafe p = kb.l();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f1570a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f1571b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1572c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1573d;

    /* renamed from: e  reason: collision with root package name */
    private final x9 f1574e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1575f;
    private final boolean g;
    private final int[] h;
    private final int i;
    private final int j;
    private final l9 k;
    private final ab l;
    private final f8 m;
    private final s9 n;

    private aa(int[] iArr, Object[] objArr, int i2, int i3, x9 x9Var, boolean z, boolean z2, int[] iArr2, int i4, int i5, ca caVar, l9 l9Var, ab abVar, f8 f8Var, s9 s9Var, byte[] bArr) {
        x9 x9Var2 = x9Var;
        f8 f8Var2 = f8Var;
        this.f1570a = iArr;
        this.f1571b = objArr;
        this.f1572c = i2;
        this.f1573d = i3;
        this.g = z;
        boolean z3 = false;
        if (f8Var2 != null && f8Var2.c(x9Var)) {
            z3 = true;
        }
        this.f1575f = z3;
        this.h = iArr2;
        this.i = i4;
        this.j = i5;
        this.k = l9Var;
        this.l = abVar;
        this.m = f8Var2;
        this.f1574e = x9Var2;
        this.n = s9Var;
    }

    private final void A(tb tbVar, int i2, Object obj, int i3) {
        if (obj != null) {
            q9 q9Var = (q9) o(i3);
            throw null;
        }
    }

    private final boolean B(Object obj, Object obj2, int i2) {
        return C(obj, i2) == C(obj2, i2);
    }

    private final boolean C(Object obj, int i2) {
        int Y = Y(i2);
        long j2 = (long) (Y & 1048575);
        if (j2 != 1048575) {
            return (kb.h(obj, j2) & (1 << (Y >>> 20))) != 0;
        }
        int k2 = k(i2);
        long j3 = (long) (k2 & 1048575);
        switch (j(k2)) {
            case 0:
                return Double.doubleToRawLongBits(kb.f(obj, j3)) != 0;
            case 1:
                return Float.floatToRawIntBits(kb.g(obj, j3)) != 0;
            case 2:
                return kb.i(obj, j3) != 0;
            case 3:
                return kb.i(obj, j3) != 0;
            case 4:
                return kb.h(obj, j3) != 0;
            case 5:
                return kb.i(obj, j3) != 0;
            case 6:
                return kb.h(obj, j3) != 0;
            case 7:
                return kb.B(obj, j3);
            case 8:
                Object k3 = kb.k(obj, j3);
                if (k3 instanceof String) {
                    return !((String) k3).isEmpty();
                }
                if (k3 instanceof r7) {
                    return !r7.k.equals(k3);
                }
                throw new IllegalArgumentException();
            case 9:
                return kb.k(obj, j3) != null;
            case 10:
                return !r7.k.equals(kb.k(obj, j3));
            case 11:
                return kb.h(obj, j3) != 0;
            case 12:
                return kb.h(obj, j3) != 0;
            case 13:
                return kb.h(obj, j3) != 0;
            case 14:
                return kb.i(obj, j3) != 0;
            case 15:
                return kb.h(obj, j3) != 0;
            case 16:
                return kb.i(obj, j3) != 0;
            case 17:
                return kb.k(obj, j3) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean D(Object obj, int i2, int i3, int i4, int i5) {
        return i3 == 1048575 ? C(obj, i2) : (i4 & i5) != 0;
    }

    private static boolean E(Object obj, int i2, ia iaVar) {
        return iaVar.g(kb.k(obj, (long) (i2 & 1048575)));
    }

    private static boolean F(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof s8) {
            return ((s8) obj).y();
        }
        return true;
    }

    private final boolean G(Object obj, int i2, int i3) {
        return kb.h(obj, (long) (Y(i3) & 1048575)) == i2;
    }

    private static boolean H(Object obj, long j2) {
        return ((Boolean) kb.k(obj, j2)).booleanValue();
    }

    private static final void I(int i2, Object obj, tb tbVar) {
        if (obj instanceof String) {
            tbVar.F(i2, (String) obj);
        } else {
            tbVar.s(i2, (r7) obj);
        }
    }

    static bb K(Object obj) {
        s8 s8Var = (s8) obj;
        bb bbVar = s8Var.zzc;
        if (bbVar != bb.c()) {
            return bbVar;
        }
        bb f2 = bb.f();
        s8Var.zzc = f2;
        return f2;
    }

    static aa L(Class cls, u9 u9Var, ca caVar, l9 l9Var, ab abVar, f8 f8Var, s9 s9Var) {
        if (u9Var instanceof ha) {
            return M((ha) u9Var, caVar, l9Var, abVar, f8Var, s9Var);
        }
        xa xaVar = (xa) u9Var;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0378  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static c.d.a.b.e.e.aa M(c.d.a.b.e.e.ha r34, c.d.a.b.e.e.ca r35, c.d.a.b.e.e.l9 r36, c.d.a.b.e.e.ab r37, c.d.a.b.e.e.f8 r38, c.d.a.b.e.e.s9 r39) {
        /*
            int r0 = r34.c()
            r1 = 0
            r3 = 2
            if (r0 != r3) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = 0
        L_0x000b:
            java.lang.String r0 = r34.d()
            int r3 = r0.length()
            char r4 = r0.charAt(r1)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0056
            int[] r6 = o
            r13 = r6
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            goto L_0x0165
        L_0x0056:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0062:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0072
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0062
        L_0x0072:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0075:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0094
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0081:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0091
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0081
        L_0x0091:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0094:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b3
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b0
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a0
        L_0x00b0:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b3:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0165:
            sun.misc.Unsafe r15 = p
            java.lang.Object[] r17 = r34.e()
            c.d.a.b.e.e.x9 r18 = r34.a()
            java.lang.Class r1 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0183:
            if (r4 >= r3) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ab
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x0193:
            int r26 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01a5
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r4 = r4 | r2
            int r24 = r24 + 13
            r2 = r26
            goto L_0x0193
        L_0x01a5:
            int r2 = r2 << r24
            r4 = r4 | r2
            r2 = r26
            goto L_0x01ad
        L_0x01ab:
            r2 = r24
        L_0x01ad:
            int r24 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r5) goto L_0x01da
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bb:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r3) goto L_0x01d4
            r3 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r2 = r2 | r3
            int r24 = r24 + 13
            r5 = r27
            r3 = r28
            goto L_0x01bb
        L_0x01d4:
            int r3 = r5 << r24
            r2 = r2 | r3
            r3 = r27
            goto L_0x01de
        L_0x01da:
            r28 = r3
            r3 = r24
        L_0x01de:
            r5 = r2 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r2 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ec
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ec:
            r14 = 51
            if (r5 < r14) goto L_0x0295
            int r14 = r3 + 1
            char r3 = r0.charAt(r3)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r14) goto L_0x0222
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0203:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021c
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r3 = r3 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0203
        L_0x021c:
            int r12 = r14 << r27
            r3 = r3 | r12
            r14 = r31
            goto L_0x0226
        L_0x0222:
            r32 = r12
            r14 = r27
        L_0x0226:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0247
            r14 = 17
            if (r12 != r14) goto L_0x0233
            goto L_0x0247
        L_0x0233:
            r14 = 12
            if (r12 != r14) goto L_0x0256
            if (r10 != 0) goto L_0x0256
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0254
        L_0x0247:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0254:
            r16 = r14
        L_0x0256:
            int r3 = r3 + r3
            r12 = r17[r3]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0260
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0268
        L_0x0260:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = r(r1, r12)
            r17[r3] = r12
        L_0x0268:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r8 = (int) r7
            int r3 = r3 + 1
            r7 = r17[r3]
            boolean r12 = r7 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027b
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0283
        L_0x027b:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = r(r1, r7)
            r17[r3] = r7
        L_0x0283:
            r3 = r8
            long r7 = r15.objectFieldOffset(r7)
            int r8 = (int) r7
            r30 = r0
            r7 = r1
            r1 = r8
            r29 = r11
            r25 = 1
            r8 = r3
            r3 = 0
            goto L_0x0391
        L_0x0295:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = r(r1, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030d
            r12 = 17
            if (r5 != r12) goto L_0x02ad
            goto L_0x030d
        L_0x02ad:
            r12 = 27
            if (r5 == r12) goto L_0x02fd
            r12 = 49
            if (r5 != r12) goto L_0x02b6
            goto L_0x02fd
        L_0x02b6:
            r12 = 12
            if (r5 == r12) goto L_0x02ed
            r12 = 30
            if (r5 == r12) goto L_0x02ed
            r12 = 44
            if (r5 != r12) goto L_0x02c3
            goto L_0x02ed
        L_0x02c3:
            r12 = 50
            if (r5 != r12) goto L_0x02e3
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r2 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e6
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e3:
            r25 = 1
            goto L_0x031a
        L_0x02e6:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031b
        L_0x02ed:
            if (r10 != 0) goto L_0x02e3
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030a
        L_0x02fd:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030a:
            r12 = r27
            goto L_0x031b
        L_0x030d:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031a:
            r12 = r7
        L_0x031b:
            long r7 = r15.objectFieldOffset(r8)
            int r8 = (int) r7
            r7 = r2 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r7 != r11) goto L_0x0378
            r7 = 17
            if (r5 > r7) goto L_0x0378
            int r7 = r3 + 1
            char r3 = r0.charAt(r3)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r11) goto L_0x0354
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033e:
            int r27 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r11) goto L_0x0350
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r26
            r3 = r3 | r7
            int r26 = r26 + 13
            r7 = r27
            goto L_0x033e
        L_0x0350:
            int r7 = r7 << r26
            r3 = r3 | r7
            goto L_0x0356
        L_0x0354:
            r27 = r7
        L_0x0356:
            int r7 = r6 + r6
            int r26 = r3 / 32
            int r7 = r7 + r26
            r11 = r17[r7]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0367
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x036f
        L_0x0367:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = r(r1, r11)
            r17[r7] = r11
        L_0x036f:
            r7 = r1
            long r0 = r15.objectFieldOffset(r11)
            int r1 = (int) r0
            int r3 = r3 % 32
            goto L_0x0381
        L_0x0378:
            r30 = r0
            r7 = r1
            r27 = r3
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r3 = 0
        L_0x0381:
            r0 = 18
            if (r5 < r0) goto L_0x038f
            r0 = 49
            if (r5 > r0) goto L_0x038f
            int r0 = r23 + 1
            r13[r23] = r8
            r23 = r0
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r0 = r9 + 1
            r31[r9] = r4
            int r4 = r0 + 1
            r9 = r2 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x039e
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r9 = 0
        L_0x039f:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03a6
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a7
        L_0x03a6:
            r2 = 0
        L_0x03a7:
            r2 = r2 | r9
            int r5 = r5 << 20
            r2 = r2 | r5
            r2 = r2 | r8
            r31[r0] = r2
            int r9 = r4 + 1
            int r0 = r3 << 20
            r0 = r0 | r1
            r31[r4] = r0
            r1 = r7
            r8 = r14
            r14 = r24
            r4 = r27
            r3 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0183
        L_0x03ca:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            c.d.a.b.e.e.aa r0 = new c.d.a.b.e.e.aa
            r4 = r0
            c.d.a.b.e.e.x9 r9 = r34.a()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.aa.M(c.d.a.b.e.e.ha, c.d.a.b.e.e.ca, c.d.a.b.e.e.l9, c.d.a.b.e.e.ab, c.d.a.b.e.e.f8, c.d.a.b.e.e.s9):c.d.a.b.e.e.aa");
    }

    private static double N(Object obj, long j2) {
        return ((Double) kb.k(obj, j2)).doubleValue();
    }

    private static float O(Object obj, long j2) {
        return ((Float) kb.k(obj, j2)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02ca, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x037f, code lost:
        r3 = c.d.a.b.e.e.z7.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x038e, code lost:
        r4 = c.d.a.b.e.e.z7.a(r11 << 3);
        r3 = ((c.d.a.b.e.e.r7) r3).i();
        r4 = r4 + (c.d.a.b.e.e.z7.a(r3) + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03ee, code lost:
        r3 = r2.getInt(r1, r3);
        r4 = c.d.a.b.e.e.z7.a(r11 << 3);
        r3 = c.d.a.b.e.e.z7.z(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03fc, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03fd, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x040a, code lost:
        r6 = r6 + (c.d.a.b.e.e.z7.a(r11 << 3) + c.d.a.b.e.e.z7.b(r2.getLong(r1, r3)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0420, code lost:
        r3 = c.d.a.b.e.e.z7.a(r11 << 3) + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x042f, code lost:
        r3 = c.d.a.b.e.e.z7.a(r11 << 3) + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0439, code lost:
        r5 = r5 + 3;
        r3 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008e, code lost:
        if (G(r1, r11, r5) != false) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0096, code lost:
        if (G(r1, r11, r5) != false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009e, code lost:
        if (G(r1, r11, r5) != false) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b2, code lost:
        r3 = c.d.a.b.e.e.z7.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c2, code lost:
        r4 = c.d.a.b.e.e.z7.a(r11 << 3);
        r3 = ((c.d.a.b.e.e.r7) r3).i();
        r4 = r4 + (c.d.a.b.e.e.z7.a(r3) + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x011a, code lost:
        if (G(r1, r11, r5) != false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0121, code lost:
        if (G(r1, r11, r5) != false) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0128, code lost:
        if (G(r1, r11, r5) != false) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x012a, code lost:
        r3 = R(r1, r3);
        r4 = c.d.a.b.e.e.z7.a(r11 << 3);
        r3 = c.d.a.b.e.e.z7.z(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013e, code lost:
        if (G(r1, r11, r5) != false) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0145, code lost:
        if (G(r1, r11, r5) != false) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0147, code lost:
        r6 = r6 + (c.d.a.b.e.e.z7.a(r11 << 3) + c.d.a.b.e.e.z7.b(l(r1, r3)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x015d, code lost:
        if (G(r1, r11, r5) != false) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x015f, code lost:
        r3 = c.d.a.b.e.e.z7.a(r11 << 3) + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x016d, code lost:
        if (G(r1, r11, r5) != false) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x016f, code lost:
        r3 = c.d.a.b.e.e.z7.a(r11 << 3) + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a0, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01ae, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01bc, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ca, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01d8, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01e6, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01f4, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0201, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x020e, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x021b, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0228, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0235, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0242, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x024f, code lost:
        if (r3 > 0) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0251, code lost:
        r4 = c.d.a.b.e.e.z7.D(r11) + c.d.a.b.e.e.z7.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x025a, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x025b, code lost:
        r6 = r6 + r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int P(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r2 = p
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
        L_0x000f:
            int[] r9 = r0.f1570a
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0440
            int r9 = r0.k(r5)
            int[] r10 = r0.f1570a
            r11 = r10[r5]
            int r12 = j(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0038
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r3
            int r10 = r10 >>> 20
            int r10 = r14 << r10
            if (r13 == r8) goto L_0x0039
            long r7 = (long) r13
            int r7 = r2.getInt(r1, r7)
            r8 = r13
            goto L_0x0039
        L_0x0038:
            r10 = 0
        L_0x0039:
            r9 = r9 & r3
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x042a;
                case 1: goto L_0x041b;
                case 2: goto L_0x0405;
                case 3: goto L_0x03ff;
                case 4: goto L_0x03e9;
                case 5: goto L_0x03e3;
                case 6: goto L_0x03dd;
                case 7: goto L_0x03cf;
                case 8: goto L_0x03b4;
                case 9: goto L_0x03a1;
                case 10: goto L_0x0385;
                case 11: goto L_0x0370;
                case 12: goto L_0x0369;
                case 13: goto L_0x0362;
                case 14: goto L_0x035b;
                case 15: goto L_0x0346;
                case 16: goto L_0x032c;
                case 17: goto L_0x0318;
                case 18: goto L_0x030a;
                case 19: goto L_0x02fe;
                case 20: goto L_0x02f2;
                case 21: goto L_0x02e6;
                case 22: goto L_0x02da;
                case 23: goto L_0x030a;
                case 24: goto L_0x02fe;
                case 25: goto L_0x02ce;
                case 26: goto L_0x02c0;
                case 27: goto L_0x02b1;
                case 28: goto L_0x02a6;
                case 29: goto L_0x029a;
                case 30: goto L_0x028e;
                case 31: goto L_0x0282;
                case 32: goto L_0x0276;
                case 33: goto L_0x026a;
                case 34: goto L_0x025e;
                case 35: goto L_0x0245;
                case 36: goto L_0x0238;
                case 37: goto L_0x022b;
                case 38: goto L_0x021e;
                case 39: goto L_0x0211;
                case 40: goto L_0x0204;
                case 41: goto L_0x01f7;
                case 42: goto L_0x01ea;
                case 43: goto L_0x01dc;
                case 44: goto L_0x01ce;
                case 45: goto L_0x01c0;
                case 46: goto L_0x01b2;
                case 47: goto L_0x01a4;
                case 48: goto L_0x0196;
                case 49: goto L_0x0186;
                case 50: goto L_0x0179;
                case 51: goto L_0x0169;
                case 52: goto L_0x0159;
                case 53: goto L_0x0141;
                case 54: goto L_0x013a;
                case 55: goto L_0x0124;
                case 56: goto L_0x011d;
                case 57: goto L_0x0116;
                case 58: goto L_0x0107;
                case 59: goto L_0x00ea;
                case 60: goto L_0x00d6;
                case 61: goto L_0x00b8;
                case 62: goto L_0x00a2;
                case 63: goto L_0x009a;
                case 64: goto L_0x0092;
                case 65: goto L_0x008a;
                case 66: goto L_0x0074;
                case 67: goto L_0x0058;
                case 68: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x02cb
        L_0x0042:
            boolean r9 = r0.G(r1, r11, r5)
            if (r9 == 0) goto L_0x02cb
            java.lang.Object r3 = r2.getObject(r1, r3)
            c.d.a.b.e.e.x9 r3 = (c.d.a.b.e.e.x9) r3
            c.d.a.b.e.e.ia r4 = r0.n(r5)
            int r3 = c.d.a.b.e.e.z7.y(r11, r3, r4)
            goto L_0x02ca
        L_0x0058:
            boolean r10 = r0.G(r1, r11, r5)
            if (r10 == 0) goto L_0x02cb
            long r3 = l(r1, r3)
            int r10 = r11 << 3
            int r10 = c.d.a.b.e.e.z7.a(r10)
            long r11 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r11
            int r3 = c.d.a.b.e.e.z7.b(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x02cb
        L_0x0074:
            boolean r9 = r0.G(r1, r11, r5)
            if (r9 == 0) goto L_0x02cb
            int r3 = R(r1, r3)
            int r4 = r11 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            goto L_0x00b2
        L_0x008a:
            boolean r3 = r0.G(r1, r11, r5)
            if (r3 == 0) goto L_0x02cb
            goto L_0x016f
        L_0x0092:
            boolean r3 = r0.G(r1, r11, r5)
            if (r3 == 0) goto L_0x02cb
            goto L_0x015f
        L_0x009a:
            boolean r9 = r0.G(r1, r11, r5)
            if (r9 == 0) goto L_0x02cb
            goto L_0x012a
        L_0x00a2:
            boolean r9 = r0.G(r1, r11, r5)
            if (r9 == 0) goto L_0x02cb
            int r3 = R(r1, r3)
            int r4 = r11 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
        L_0x00b2:
            int r3 = c.d.a.b.e.e.z7.a(r3)
            goto L_0x025a
        L_0x00b8:
            boolean r9 = r0.G(r1, r11, r5)
            if (r9 == 0) goto L_0x02cb
            java.lang.Object r3 = r2.getObject(r1, r3)
        L_0x00c2:
            c.d.a.b.e.e.r7 r3 = (c.d.a.b.e.e.r7) r3
            int r4 = r11 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
            int r3 = r3.i()
            int r9 = c.d.a.b.e.e.z7.a(r3)
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x025b
        L_0x00d6:
            boolean r9 = r0.G(r1, r11, r5)
            if (r9 == 0) goto L_0x02cb
            java.lang.Object r3 = r2.getObject(r1, r3)
            c.d.a.b.e.e.ia r4 = r0.n(r5)
            int r3 = c.d.a.b.e.e.ka.Q(r11, r3, r4)
            goto L_0x02ca
        L_0x00ea:
            boolean r9 = r0.G(r1, r11, r5)
            if (r9 == 0) goto L_0x02cb
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof c.d.a.b.e.e.r7
            if (r4 == 0) goto L_0x00f9
            goto L_0x00c2
        L_0x00f9:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
            int r3 = c.d.a.b.e.e.z7.C(r3)
            goto L_0x025a
        L_0x0107:
            boolean r3 = r0.G(r1, r11, r5)
            if (r3 == 0) goto L_0x02cb
            int r3 = r11 << 3
            int r3 = c.d.a.b.e.e.z7.a(r3)
            int r3 = r3 + r14
            goto L_0x02ca
        L_0x0116:
            boolean r3 = r0.G(r1, r11, r5)
            if (r3 == 0) goto L_0x02cb
            goto L_0x015f
        L_0x011d:
            boolean r3 = r0.G(r1, r11, r5)
            if (r3 == 0) goto L_0x02cb
            goto L_0x016f
        L_0x0124:
            boolean r9 = r0.G(r1, r11, r5)
            if (r9 == 0) goto L_0x02cb
        L_0x012a:
            int r3 = R(r1, r3)
            int r4 = r11 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
            int r3 = c.d.a.b.e.e.z7.z(r3)
            goto L_0x025a
        L_0x013a:
            boolean r9 = r0.G(r1, r11, r5)
            if (r9 == 0) goto L_0x02cb
            goto L_0x0147
        L_0x0141:
            boolean r9 = r0.G(r1, r11, r5)
            if (r9 == 0) goto L_0x02cb
        L_0x0147:
            long r3 = l(r1, r3)
            int r9 = r11 << 3
            int r9 = c.d.a.b.e.e.z7.a(r9)
            int r3 = c.d.a.b.e.e.z7.b(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x02cb
        L_0x0159:
            boolean r3 = r0.G(r1, r11, r5)
            if (r3 == 0) goto L_0x02cb
        L_0x015f:
            int r3 = r11 << 3
            int r3 = c.d.a.b.e.e.z7.a(r3)
            int r3 = r3 + 4
            goto L_0x02ca
        L_0x0169:
            boolean r3 = r0.G(r1, r11, r5)
            if (r3 == 0) goto L_0x02cb
        L_0x016f:
            int r3 = r11 << 3
            int r3 = c.d.a.b.e.e.z7.a(r3)
            int r3 = r3 + 8
            goto L_0x02ca
        L_0x0179:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r0.o(r5)
            c.d.a.b.e.e.s9.a(r11, r3, r4)
            goto L_0x02cb
        L_0x0186:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ia r4 = r0.n(r5)
            int r3 = c.d.a.b.e.e.ka.L(r11, r3, r4)
            goto L_0x02ca
        L_0x0196:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.V(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x01a4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.T(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x01b2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.K(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x01c0:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.I(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x01ce:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.G(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x01dc:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.Y(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x01ea:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.D(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x01f7:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.I(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x0204:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.K(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x0211:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.N(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x021e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.a0(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x022b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.P(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x0238:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.I(r3)
            if (r3 <= 0) goto L_0x02cb
            goto L_0x0251
        L_0x0245:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.K(r3)
            if (r3 <= 0) goto L_0x02cb
        L_0x0251:
            int r4 = c.d.a.b.e.e.z7.D(r11)
            int r9 = c.d.a.b.e.e.z7.a(r3)
            int r4 = r4 + r9
        L_0x025a:
            int r4 = r4 + r3
        L_0x025b:
            int r6 = r6 + r4
            goto L_0x02cb
        L_0x025e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = c.d.a.b.e.e.ka.U(r11, r3, r9)
            goto L_0x02ca
        L_0x026a:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.S(r11, r3, r9)
            goto L_0x02ca
        L_0x0276:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.J(r11, r3, r9)
            goto L_0x02ca
        L_0x0282:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.H(r11, r3, r9)
            goto L_0x02ca
        L_0x028e:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.F(r11, r3, r9)
            goto L_0x02ca
        L_0x029a:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.X(r11, r3, r9)
            goto L_0x02ca
        L_0x02a6:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.E(r11, r3)
            goto L_0x02ca
        L_0x02b1:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ia r4 = r0.n(r5)
            int r3 = c.d.a.b.e.e.ka.R(r11, r3, r4)
            goto L_0x02ca
        L_0x02c0:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.W(r11, r3)
        L_0x02ca:
            int r6 = r6 + r3
        L_0x02cb:
            r12 = 0
            goto L_0x0439
        L_0x02ce:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = c.d.a.b.e.e.ka.A(r11, r3, r12)
            goto L_0x0315
        L_0x02da:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.M(r11, r3, r12)
            goto L_0x0315
        L_0x02e6:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.Z(r11, r3, r12)
            goto L_0x0315
        L_0x02f2:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.O(r11, r3, r12)
            goto L_0x0315
        L_0x02fe:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.H(r11, r3, r12)
            goto L_0x0315
        L_0x030a:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = c.d.a.b.e.e.ka.J(r11, r3, r12)
        L_0x0315:
            int r6 = r6 + r3
            goto L_0x0439
        L_0x0318:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x0439
            java.lang.Object r3 = r2.getObject(r1, r3)
            c.d.a.b.e.e.x9 r3 = (c.d.a.b.e.e.x9) r3
            c.d.a.b.e.e.ia r4 = r0.n(r5)
            int r3 = c.d.a.b.e.e.z7.y(r11, r3, r4)
            goto L_0x0315
        L_0x032c:
            r12 = 0
            r10 = r10 & r7
            if (r10 == 0) goto L_0x0439
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            int r10 = c.d.a.b.e.e.z7.a(r10)
            long r14 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r14
            int r3 = c.d.a.b.e.e.z7.b(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x0439
        L_0x0346:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x0439
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            goto L_0x037f
        L_0x035b:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x0439
            goto L_0x042f
        L_0x0362:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x0439
            goto L_0x0420
        L_0x0369:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x0439
            goto L_0x03ee
        L_0x0370:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x0439
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
        L_0x037f:
            int r3 = c.d.a.b.e.e.z7.a(r3)
            goto L_0x03fc
        L_0x0385:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x0439
            java.lang.Object r3 = r2.getObject(r1, r3)
        L_0x038e:
            c.d.a.b.e.e.r7 r3 = (c.d.a.b.e.e.r7) r3
            int r4 = r11 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
            int r3 = r3.i()
            int r9 = c.d.a.b.e.e.z7.a(r3)
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x03fd
        L_0x03a1:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x0439
            java.lang.Object r3 = r2.getObject(r1, r3)
            c.d.a.b.e.e.ia r4 = r0.n(r5)
            int r3 = c.d.a.b.e.e.ka.Q(r11, r3, r4)
            goto L_0x0315
        L_0x03b4:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x0439
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof c.d.a.b.e.e.r7
            if (r4 == 0) goto L_0x03c2
            goto L_0x038e
        L_0x03c2:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
            int r3 = c.d.a.b.e.e.z7.C(r3)
            goto L_0x03fc
        L_0x03cf:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x0439
            int r3 = r11 << 3
            int r3 = c.d.a.b.e.e.z7.a(r3)
            int r3 = r3 + r14
            goto L_0x0315
        L_0x03dd:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x0439
            goto L_0x0420
        L_0x03e3:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x0439
            goto L_0x042f
        L_0x03e9:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x0439
        L_0x03ee:
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
            int r3 = c.d.a.b.e.e.z7.z(r3)
        L_0x03fc:
            int r4 = r4 + r3
        L_0x03fd:
            int r6 = r6 + r4
            goto L_0x0439
        L_0x03ff:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x0439
            goto L_0x040a
        L_0x0405:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x0439
        L_0x040a:
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = c.d.a.b.e.e.z7.a(r9)
            int r3 = c.d.a.b.e.e.z7.b(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x0439
        L_0x041b:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x0439
        L_0x0420:
            int r3 = r11 << 3
            int r3 = c.d.a.b.e.e.z7.a(r3)
            int r3 = r3 + 4
            goto L_0x0315
        L_0x042a:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x0439
        L_0x042f:
            int r3 = r11 << 3
            int r3 = c.d.a.b.e.e.z7.a(r3)
            int r3 = r3 + 8
            goto L_0x0315
        L_0x0439:
            int r5 = r5 + 3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000f
        L_0x0440:
            c.d.a.b.e.e.ab r2 = r0.l
            java.lang.Object r3 = r2.d(r1)
            int r2 = r2.a(r3)
            int r6 = r6 + r2
            boolean r2 = r0.f1575f
            if (r2 != 0) goto L_0x0450
            return r6
        L_0x0450:
            c.d.a.b.e.e.f8 r2 = r0.m
            r2.a(r1)
            r1 = 0
            goto L_0x0458
        L_0x0457:
            throw r1
        L_0x0458:
            goto L_0x0457
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.aa.P(java.lang.Object):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0263, code lost:
        r4 = c.d.a.b.e.e.z7.y(r6, (c.d.a.b.e.e.x9) c.d.a.b.e.e.kb.k(r12, r7), n(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x027c, code lost:
        r5 = c.d.a.b.e.e.z7.a(r6 << 3);
        r4 = c.d.a.b.e.e.z7.b((r7 >> 63) ^ (r7 + r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0297, code lost:
        r5 = c.d.a.b.e.e.z7.a(r6 << 3);
        r4 = (r4 >> 31) ^ (r4 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02c5, code lost:
        r5 = c.d.a.b.e.e.z7.a(r6 << 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02cb, code lost:
        r4 = c.d.a.b.e.e.z7.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02d7, code lost:
        r4 = c.d.a.b.e.e.kb.k(r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02db, code lost:
        r5 = c.d.a.b.e.e.z7.a(r6 << 3);
        r4 = ((c.d.a.b.e.e.r7) r4).i();
        r5 = r5 + (c.d.a.b.e.e.z7.a(r4) + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02f4, code lost:
        r4 = c.d.a.b.e.e.ka.Q(r6, c.d.a.b.e.e.kb.k(r12, r7), n(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x030e, code lost:
        if ((r4 instanceof c.d.a.b.e.e.r7) != false) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0311, code lost:
        r5 = c.d.a.b.e.e.z7.a(r6 << 3);
        r4 = c.d.a.b.e.e.z7.C((java.lang.String) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0324, code lost:
        r4 = c.d.a.b.e.e.z7.a(r6 << 3) + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0342, code lost:
        r4 = c.d.a.b.e.e.kb.h(r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0346, code lost:
        r5 = c.d.a.b.e.e.z7.a(r6 << 3);
        r4 = c.d.a.b.e.e.z7.z(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0350, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0351, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0360, code lost:
        r4 = c.d.a.b.e.e.kb.i(r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0364, code lost:
        r3 = r3 + (c.d.a.b.e.e.z7.a(r6 << 3) + c.d.a.b.e.e.z7.b(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0377, code lost:
        r4 = c.d.a.b.e.e.z7.a(r6 << 3) + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0387, code lost:
        r4 = c.d.a.b.e.e.z7.a(r6 << 3) + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0391, code lost:
        r2 = r2 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        if ((r4 instanceof c.d.a.b.e.e.r7) != false) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b9, code lost:
        r4 = R(r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cc, code lost:
        r4 = l(r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ba, code lost:
        r5 = c.d.a.b.e.e.z7.D(r6) + c.d.a.b.e.e.z7.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x025a, code lost:
        r3 = r3 + r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int Q(java.lang.Object r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = p
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0005:
            int[] r4 = r11.f1570a
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0395
            int r4 = r11.k(r2)
            int r5 = j(r4)
            int[] r6 = r11.f1570a
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            c.d.a.b.e.e.k8 r4 = c.d.a.b.e.e.k8.DOUBLE_LIST_PACKED
            int r4 = r4.a()
            if (r5 < r4) goto L_0x0031
            c.d.a.b.e.e.k8 r4 = c.d.a.b.e.e.k8.SINT64_LIST_PACKED
            int r4 = r4.a()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.f1570a
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0381;
                case 1: goto L_0x0371;
                case 2: goto L_0x035a;
                case 3: goto L_0x0353;
                case 4: goto L_0x033c;
                case 5: goto L_0x0335;
                case 6: goto L_0x032e;
                case 7: goto L_0x031e;
                case 8: goto L_0x0302;
                case 9: goto L_0x02ee;
                case 10: goto L_0x02d1;
                case 11: goto L_0x02bb;
                case 12: goto L_0x02b3;
                case 13: goto L_0x02ab;
                case 14: goto L_0x02a3;
                case 15: goto L_0x028d;
                case 16: goto L_0x0272;
                case 17: goto L_0x025d;
                case 18: goto L_0x0250;
                case 19: goto L_0x0245;
                case 20: goto L_0x023a;
                case 21: goto L_0x022f;
                case 22: goto L_0x0224;
                case 23: goto L_0x0250;
                case 24: goto L_0x0245;
                case 25: goto L_0x0219;
                case 26: goto L_0x020e;
                case 27: goto L_0x01ff;
                case 28: goto L_0x01f4;
                case 29: goto L_0x01e9;
                case 30: goto L_0x01dd;
                case 31: goto L_0x0245;
                case 32: goto L_0x0250;
                case 33: goto L_0x01d1;
                case 34: goto L_0x01c5;
                case 35: goto L_0x01ae;
                case 36: goto L_0x01a1;
                case 37: goto L_0x0194;
                case 38: goto L_0x0187;
                case 39: goto L_0x017a;
                case 40: goto L_0x016d;
                case 41: goto L_0x0160;
                case 42: goto L_0x0153;
                case 43: goto L_0x0145;
                case 44: goto L_0x0137;
                case 45: goto L_0x0129;
                case 46: goto L_0x011b;
                case 47: goto L_0x010d;
                case 48: goto L_0x00ff;
                case 49: goto L_0x00ef;
                case 50: goto L_0x00e2;
                case 51: goto L_0x00da;
                case 52: goto L_0x00d2;
                case 53: goto L_0x00c6;
                case 54: goto L_0x00bf;
                case 55: goto L_0x00b3;
                case 56: goto L_0x00ab;
                case 57: goto L_0x00a3;
                case 58: goto L_0x009b;
                case 59: goto L_0x008b;
                case 60: goto L_0x0083;
                case 61: goto L_0x007b;
                case 62: goto L_0x006f;
                case 63: goto L_0x0068;
                case 64: goto L_0x0060;
                case 65: goto L_0x0058;
                case 66: goto L_0x004c;
                case 67: goto L_0x0040;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0391
        L_0x0038:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0263
        L_0x0040:
            boolean r5 = r11.G(r12, r6, r2)
            if (r5 == 0) goto L_0x0391
            long r7 = l(r12, r7)
            goto L_0x027c
        L_0x004c:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            int r4 = R(r12, r7)
            goto L_0x0297
        L_0x0058:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0387
        L_0x0060:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0377
        L_0x0068:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x00b9
        L_0x006f:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            int r4 = R(r12, r7)
            goto L_0x02c5
        L_0x007b:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x02d7
        L_0x0083:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x02f4
        L_0x008b:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            boolean r5 = r4 instanceof c.d.a.b.e.e.r7
            if (r5 == 0) goto L_0x0311
            goto L_0x0310
        L_0x009b:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0324
        L_0x00a3:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0377
        L_0x00ab:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0387
        L_0x00b3:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
        L_0x00b9:
            int r4 = R(r12, r7)
            goto L_0x0346
        L_0x00bf:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x00cc
        L_0x00c6:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
        L_0x00cc:
            long r4 = l(r12, r7)
            goto L_0x0364
        L_0x00d2:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0377
        L_0x00da:
            boolean r4 = r11.G(r12, r6, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0387
        L_0x00e2:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.lang.Object r5 = r11.o(r2)
            c.d.a.b.e.e.s9.a(r6, r4, r5)
            goto L_0x0391
        L_0x00ef:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            c.d.a.b.e.e.ia r5 = r11.n(r2)
            int r4 = c.d.a.b.e.e.ka.L(r6, r4, r5)
            goto L_0x025a
        L_0x00ff:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.V(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x010d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.T(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x011b:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.K(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0129:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.I(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0137:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.G(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0145:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.Y(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0153:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.D(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0160:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.I(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x016d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.K(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x017a:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.N(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0187:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.a0(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x0194:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.P(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x01a1:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.I(r4)
            if (r4 <= 0) goto L_0x0391
            goto L_0x01ba
        L_0x01ae:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.K(r4)
            if (r4 <= 0) goto L_0x0391
        L_0x01ba:
            int r5 = c.d.a.b.e.e.z7.D(r6)
            int r6 = c.d.a.b.e.e.z7.a(r4)
            int r5 = r5 + r6
            goto L_0x0350
        L_0x01c5:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.U(r6, r4, r1)
            goto L_0x025a
        L_0x01d1:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.S(r6, r4, r1)
            goto L_0x025a
        L_0x01dd:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.F(r6, r4, r1)
            goto L_0x025a
        L_0x01e9:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.X(r6, r4, r1)
            goto L_0x025a
        L_0x01f4:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.E(r6, r4)
            goto L_0x025a
        L_0x01ff:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            c.d.a.b.e.e.ia r5 = r11.n(r2)
            int r4 = c.d.a.b.e.e.ka.R(r6, r4, r5)
            goto L_0x025a
        L_0x020e:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.W(r6, r4)
            goto L_0x025a
        L_0x0219:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.A(r6, r4, r1)
            goto L_0x025a
        L_0x0224:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.M(r6, r4, r1)
            goto L_0x025a
        L_0x022f:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.Z(r6, r4, r1)
            goto L_0x025a
        L_0x023a:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.O(r6, r4, r1)
            goto L_0x025a
        L_0x0245:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.H(r6, r4, r1)
            goto L_0x025a
        L_0x0250:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = c.d.a.b.e.e.ka.J(r6, r4, r1)
        L_0x025a:
            int r3 = r3 + r4
            goto L_0x0391
        L_0x025d:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x0263:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            c.d.a.b.e.e.x9 r4 = (c.d.a.b.e.e.x9) r4
            c.d.a.b.e.e.ia r5 = r11.n(r2)
            int r4 = c.d.a.b.e.e.z7.y(r6, r4, r5)
            goto L_0x025a
        L_0x0272:
            boolean r5 = r11.C(r12, r2)
            if (r5 == 0) goto L_0x0391
            long r7 = c.d.a.b.e.e.kb.i(r12, r7)
        L_0x027c:
            int r5 = r6 << 3
            int r5 = c.d.a.b.e.e.z7.a(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = c.d.a.b.e.e.z7.b(r6)
            goto L_0x0350
        L_0x028d:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
            int r4 = c.d.a.b.e.e.kb.h(r12, r7)
        L_0x0297:
            int r5 = r6 << 3
            int r5 = c.d.a.b.e.e.z7.a(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            goto L_0x02cb
        L_0x02a3:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0387
        L_0x02ab:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0377
        L_0x02b3:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0342
        L_0x02bb:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
            int r4 = c.d.a.b.e.e.kb.h(r12, r7)
        L_0x02c5:
            int r5 = r6 << 3
            int r5 = c.d.a.b.e.e.z7.a(r5)
        L_0x02cb:
            int r4 = c.d.a.b.e.e.z7.a(r4)
            goto L_0x0350
        L_0x02d1:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x02d7:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
        L_0x02db:
            c.d.a.b.e.e.r7 r4 = (c.d.a.b.e.e.r7) r4
            int r5 = r6 << 3
            int r5 = c.d.a.b.e.e.z7.a(r5)
            int r4 = r4.i()
            int r6 = c.d.a.b.e.e.z7.a(r4)
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x0351
        L_0x02ee:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x02f4:
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            c.d.a.b.e.e.ia r5 = r11.n(r2)
            int r4 = c.d.a.b.e.e.ka.Q(r6, r4, r5)
            goto L_0x025a
        L_0x0302:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r12, r7)
            boolean r5 = r4 instanceof c.d.a.b.e.e.r7
            if (r5 == 0) goto L_0x0311
        L_0x0310:
            goto L_0x02db
        L_0x0311:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = c.d.a.b.e.e.z7.a(r5)
            int r4 = c.d.a.b.e.e.z7.C(r4)
            goto L_0x0350
        L_0x031e:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x0324:
            int r4 = r6 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
            int r4 = r4 + 1
            goto L_0x025a
        L_0x032e:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0377
        L_0x0335:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0387
        L_0x033c:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x0342:
            int r4 = c.d.a.b.e.e.kb.h(r12, r7)
        L_0x0346:
            int r5 = r6 << 3
            int r5 = c.d.a.b.e.e.z7.a(r5)
            int r4 = c.d.a.b.e.e.z7.z(r4)
        L_0x0350:
            int r5 = r5 + r4
        L_0x0351:
            int r3 = r3 + r5
            goto L_0x0391
        L_0x0353:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
            goto L_0x0360
        L_0x035a:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x0360:
            long r4 = c.d.a.b.e.e.kb.i(r12, r7)
        L_0x0364:
            int r6 = r6 << 3
            int r6 = c.d.a.b.e.e.z7.a(r6)
            int r4 = c.d.a.b.e.e.z7.b(r4)
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0391
        L_0x0371:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x0377:
            int r4 = r6 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
            int r4 = r4 + 4
            goto L_0x025a
        L_0x0381:
            boolean r4 = r11.C(r12, r2)
            if (r4 == 0) goto L_0x0391
        L_0x0387:
            int r4 = r6 << 3
            int r4 = c.d.a.b.e.e.z7.a(r4)
            int r4 = r4 + 8
            goto L_0x025a
        L_0x0391:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0395:
            c.d.a.b.e.e.ab r0 = r11.l
            java.lang.Object r12 = r0.d(r12)
            int r12 = r0.a(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.aa.Q(java.lang.Object):int");
    }

    private static int R(Object obj, long j2) {
        return ((Integer) kb.k(obj, j2)).intValue();
    }

    private final int S(Object obj, byte[] bArr, int i2, int i3, int i4, long j2, g7 g7Var) {
        Unsafe unsafe = p;
        Object o2 = o(i4);
        Object object = unsafe.getObject(obj, j2);
        if (!((r9) object).g()) {
            r9 b2 = r9.a().b();
            s9.b(b2, object);
            unsafe.putObject(obj, j2, b2);
        }
        q9 q9Var = (q9) o2;
        throw null;
    }

    private final int T(Object obj, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, g7 g7Var) {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i10 = i2;
        int i11 = i4;
        int i12 = i5;
        int i13 = i6;
        long j3 = j2;
        int i14 = i9;
        g7 g7Var2 = g7Var;
        Unsafe unsafe = p;
        long j4 = (long) (this.f1570a[i14 + 2] & 1048575);
        switch (i8) {
            case 51:
                if (i13 == 1) {
                    unsafe.putObject(obj2, j3, Double.valueOf(Double.longBitsToDouble(h7.p(bArr, i2))));
                    unsafe.putInt(obj2, j4, i12);
                    return i10 + 8;
                }
                break;
            case 52:
                if (i13 == 5) {
                    unsafe.putObject(obj2, j3, Float.valueOf(Float.intBitsToFloat(h7.b(bArr, i2))));
                    unsafe.putInt(obj2, j4, i12);
                    return i10 + 4;
                }
                break;
            case 53:
            case 54:
                if (i13 == 0) {
                    int m2 = h7.m(bArr2, i10, g7Var2);
                    unsafe.putObject(obj2, j3, Long.valueOf(g7Var2.f1639b));
                    unsafe.putInt(obj2, j4, i12);
                    return m2;
                }
                break;
            case 55:
            case 62:
                if (i13 == 0) {
                    int j5 = h7.j(bArr2, i10, g7Var2);
                    unsafe.putObject(obj2, j3, Integer.valueOf(g7Var2.f1638a));
                    unsafe.putInt(obj2, j4, i12);
                    return j5;
                }
                break;
            case 56:
            case 65:
                if (i13 == 1) {
                    unsafe.putObject(obj2, j3, Long.valueOf(h7.p(bArr, i2)));
                    unsafe.putInt(obj2, j4, i12);
                    return i10 + 8;
                }
                break;
            case 57:
            case 64:
                if (i13 == 5) {
                    unsafe.putObject(obj2, j3, Integer.valueOf(h7.b(bArr, i2)));
                    unsafe.putInt(obj2, j4, i12);
                    return i10 + 4;
                }
                break;
            case 58:
                if (i13 == 0) {
                    int m3 = h7.m(bArr2, i10, g7Var2);
                    unsafe.putObject(obj2, j3, Boolean.valueOf(g7Var2.f1639b != 0));
                    unsafe.putInt(obj2, j4, i12);
                    return m3;
                }
                break;
            case 59:
                if (i13 == 2) {
                    int j6 = h7.j(bArr2, i10, g7Var2);
                    int i15 = g7Var2.f1638a;
                    if (i15 == 0) {
                        unsafe.putObject(obj2, j3, "");
                    } else if ((i7 & 536870912) == 0 || qb.f(bArr2, j6, j6 + i15)) {
                        unsafe.putObject(obj2, j3, new String(bArr2, j6, i15, y8.f1783a));
                        j6 += i15;
                    } else {
                        throw a9.c();
                    }
                    unsafe.putInt(obj2, j4, i12);
                    return j6;
                }
                break;
            case 60:
                if (i13 == 2) {
                    Object q = q(obj2, i12, i14);
                    int o2 = h7.o(q, n(i14), bArr, i2, i3, g7Var);
                    y(obj2, i12, i14, q);
                    return o2;
                }
                break;
            case 61:
                if (i13 == 2) {
                    int a2 = h7.a(bArr2, i10, g7Var2);
                    unsafe.putObject(obj2, j3, g7Var2.f1640c);
                    unsafe.putInt(obj2, j4, i12);
                    return a2;
                }
                break;
            case 63:
                if (i13 == 0) {
                    int j7 = h7.j(bArr2, i10, g7Var2);
                    int i16 = g7Var2.f1638a;
                    u8 m4 = m(i14);
                    if (m4 == null || m4.a(i16)) {
                        unsafe.putObject(obj2, j3, Integer.valueOf(i16));
                        unsafe.putInt(obj2, j4, i12);
                    } else {
                        K(obj).j(i11, Long.valueOf((long) i16));
                    }
                    return j7;
                }
                break;
            case 66:
                if (i13 == 0) {
                    int j8 = h7.j(bArr2, i10, g7Var2);
                    unsafe.putObject(obj2, j3, Integer.valueOf(v7.a(g7Var2.f1638a)));
                    unsafe.putInt(obj2, j4, i12);
                    return j8;
                }
                break;
            case 67:
                if (i13 == 0) {
                    int m5 = h7.m(bArr2, i10, g7Var2);
                    unsafe.putObject(obj2, j3, Long.valueOf(v7.b(g7Var2.f1639b)));
                    unsafe.putInt(obj2, j4, i12);
                    return m5;
                }
                break;
            case 68:
                if (i13 == 3) {
                    Object q2 = q(obj2, i12, i14);
                    int n2 = h7.n(q2, n(i14), bArr, i2, i3, (i11 & -8) | 4, g7Var);
                    y(obj2, i12, i14, q2);
                    return n2;
                }
                break;
        }
        return i10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02f8, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0343, code lost:
        if (r0 != r14) goto L_0x02e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f7, code lost:
        r7.putInt(r14, r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010e, code lost:
        r6 = r6 | r10;
        r13 = r34;
        r9 = r7;
        r2 = r15;
        r7 = r20;
        r1 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0141, code lost:
        r13 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0217, code lost:
        r0 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0235, code lost:
        r6 = r6 | r10;
        r9 = r7;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0238, code lost:
        r7 = r20;
        r1 = r23;
        r8 = 1048575;
        r10 = -1;
        r15 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0241, code lost:
        r13 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0245, code lost:
        r2 = r4;
        r29 = r7;
        r7 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02e5, code lost:
        if (r0 != r24) goto L_0x02e7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int U(java.lang.Object r31, byte[] r32, int r33, int r34, c.d.a.b.e.e.g7 r35) {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            s(r31)
            sun.misc.Unsafe r9 = p
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001d:
            if (r0 >= r13) goto L_0x036b
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002f
            int r0 = c.d.a.b.e.e.h7.k(r0, r12, r3, r11)
            int r3 = r11.f1638a
            r4 = r0
            r17 = r3
            goto L_0x0032
        L_0x002f:
            r17 = r0
            r4 = r3
        L_0x0032:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003f
            int r2 = r2 / 3
            int r0 = r15.X(r5, r2)
            goto L_0x0043
        L_0x003f:
            int r0 = r15.W(r5)
        L_0x0043:
            r2 = r0
            if (r2 != r10) goto L_0x0050
            r2 = r4
            r23 = r5
            r29 = r9
            r15 = 0
        L_0x004c:
            r18 = -1
            goto L_0x0346
        L_0x0050:
            int[] r0 = r15.f1570a
            int r1 = r2 + 1
            r1 = r0[r1]
            int r13 = j(r1)
            r10 = r1 & r8
            r19 = r9
            long r8 = (long) r10
            r10 = 17
            r33 = r5
            if (r13 > r10) goto L_0x024c
            int r10 = r2 + 2
            r0 = r0[r10]
            int r10 = r0 >>> 20
            r5 = 1
            int r10 = r5 << r10
            r15 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r15
            r22 = r1
            r20 = r2
            if (r0 == r7) goto L_0x008d
            if (r7 == r15) goto L_0x0081
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0083
        L_0x0081:
            r7 = r19
        L_0x0083:
            if (r0 == r15) goto L_0x008a
            long r1 = (long) r0
            int r6 = r7.getInt(r14, r1)
        L_0x008a:
            r2 = r7
            r7 = r0
            goto L_0x008f
        L_0x008d:
            r2 = r19
        L_0x008f:
            r0 = 5
            switch(r13) {
                case 0: goto L_0x021a;
                case 1: goto L_0x01fe;
                case 2: goto L_0x01dd;
                case 3: goto L_0x01dd;
                case 4: goto L_0x01c5;
                case 5: goto L_0x01a5;
                case 6: goto L_0x018e;
                case 7: goto L_0x016d;
                case 8: goto L_0x0148;
                case 9: goto L_0x0119;
                case 10: goto L_0x00fb;
                case 11: goto L_0x01c5;
                case 12: goto L_0x00e8;
                case 13: goto L_0x018e;
                case 14: goto L_0x01a5;
                case 15: goto L_0x00d4;
                case 16: goto L_0x00a1;
                default: goto L_0x0093;
            }
        L_0x0093:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            goto L_0x0245
        L_0x00a1:
            if (r3 != 0) goto L_0x00cb
            int r13 = c.d.a.b.e.e.h7.m(r12, r4, r11)
            long r0 = r11.f1639b
            long r4 = c.d.a.b.e.e.v7.b(r0)
            r0 = r2
            r1 = r31
            r15 = r20
            r20 = r7
            r7 = r2
            r2 = r8
            r23 = r33
            r0.putLong(r1, r2, r4)
            r6 = r6 | r10
            r9 = r7
            r0 = r13
            r2 = r15
            r7 = r20
            r1 = r23
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r15 = r30
            goto L_0x0241
        L_0x00cb:
            r23 = r33
            r15 = r20
            r20 = r7
            r7 = r2
            goto L_0x0141
        L_0x00d4:
            r23 = r33
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0141
            int r0 = c.d.a.b.e.e.h7.j(r12, r4, r11)
            int r1 = r11.f1638a
            int r1 = c.d.a.b.e.e.v7.a(r1)
            goto L_0x00f7
        L_0x00e8:
            r23 = r33
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0141
            int r0 = c.d.a.b.e.e.h7.j(r12, r4, r11)
            int r1 = r11.f1638a
        L_0x00f7:
            r7.putInt(r14, r8, r1)
            goto L_0x010e
        L_0x00fb:
            r23 = r33
            r15 = r20
            r0 = 2
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0141
            int r0 = c.d.a.b.e.e.h7.a(r12, r4, r11)
            java.lang.Object r1 = r11.f1640c
            r7.putObject(r14, r8, r1)
        L_0x010e:
            r6 = r6 | r10
            r13 = r34
            r9 = r7
            r2 = r15
            r7 = r20
            r1 = r23
            goto L_0x0363
        L_0x0119:
            r23 = r33
            r15 = r20
            r0 = 2
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0141
            r13 = r30
            r19 = 1048575(0xfffff, float:1.469367E-39)
            java.lang.Object r8 = r13.p(r14, r15)
            c.d.a.b.e.e.ia r1 = r13.n(r15)
            r0 = r8
            r2 = r32
            r3 = r4
            r4 = r34
            r5 = r35
            int r0 = c.d.a.b.e.e.h7.o(r0, r1, r2, r3, r4, r5)
            r13.x(r14, r15, r8)
            goto L_0x0235
        L_0x0141:
            r13 = r30
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0245
        L_0x0148:
            r13 = r30
            r23 = r33
            r15 = r20
            r0 = 2
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0245
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r22 & r0
            if (r0 != 0) goto L_0x0162
            int r0 = c.d.a.b.e.e.h7.g(r12, r4, r11)
            goto L_0x0166
        L_0x0162:
            int r0 = c.d.a.b.e.e.h7.h(r12, r4, r11)
        L_0x0166:
            java.lang.Object r1 = r11.f1640c
            r7.putObject(r14, r8, r1)
            goto L_0x0235
        L_0x016d:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0245
            int r0 = c.d.a.b.e.e.h7.m(r12, r4, r11)
            long r1 = r11.f1639b
            r3 = 0
            int r17 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r17 == 0) goto L_0x0188
            goto L_0x0189
        L_0x0188:
            r5 = 0
        L_0x0189:
            c.d.a.b.e.e.kb.r(r14, r8, r5)
            goto L_0x0235
        L_0x018e:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0245
            int r0 = c.d.a.b.e.e.h7.b(r12, r4)
            r7.putInt(r14, r8, r0)
            goto L_0x0217
        L_0x01a5:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r5) goto L_0x0245
            long r21 = c.d.a.b.e.e.h7.p(r12, r4)
            r0 = r7
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0235
        L_0x01c5:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0245
            int r0 = c.d.a.b.e.e.h7.j(r12, r4, r11)
            int r1 = r11.f1638a
            r7.putInt(r14, r8, r1)
            goto L_0x0235
        L_0x01dd:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0245
            int r17 = c.d.a.b.e.e.h7.m(r12, r4, r11)
            long r4 = r11.f1639b
            r0 = r7
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r10
            r9 = r7
            r2 = r15
            r0 = r17
            goto L_0x0238
        L_0x01fe:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0245
            int r0 = c.d.a.b.e.e.h7.b(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            c.d.a.b.e.e.kb.u(r14, r8, r0)
        L_0x0217:
            int r0 = r4 + 4
            goto L_0x0235
        L_0x021a:
            r13 = r30
            r23 = r33
            r15 = r20
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r5) goto L_0x0245
            long r0 = c.d.a.b.e.e.h7.p(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            c.d.a.b.e.e.kb.t(r14, r8, r0)
            int r0 = r4 + 8
        L_0x0235:
            r6 = r6 | r10
            r9 = r7
            r2 = r15
        L_0x0238:
            r7 = r20
            r1 = r23
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r15 = r13
        L_0x0241:
            r13 = r34
            goto L_0x001d
        L_0x0245:
            r2 = r4
            r29 = r7
            r7 = r20
            goto L_0x004c
        L_0x024c:
            r23 = r33
            r22 = r1
            r20 = r7
            r10 = r15
            r7 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r2
            r0 = 27
            if (r13 != r0) goto L_0x02ab
            r0 = 2
            if (r3 != r0) goto L_0x02a0
            java.lang.Object r0 = r7.getObject(r14, r8)
            c.d.a.b.e.e.x8 r0 = (c.d.a.b.e.e.x8) r0
            boolean r1 = r0.c()
            if (r1 != 0) goto L_0x027d
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0275
            r1 = 10
            goto L_0x0276
        L_0x0275:
            int r1 = r1 + r1
        L_0x0276:
            c.d.a.b.e.e.x8 r0 = r0.h(r1)
            r7.putObject(r14, r8, r0)
        L_0x027d:
            r5 = r0
            c.d.a.b.e.e.ia r0 = r10.n(r15)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = c.d.a.b.e.e.h7.e(r0, r1, r2, r3, r4, r5, r6)
            r13 = r34
            r9 = r7
            r6 = r8
            r2 = r15
            r7 = r20
            r1 = r23
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r10
            r10 = -1
            goto L_0x001d
        L_0x02a0:
            r14 = r4
            r25 = r6
            r29 = r7
            r26 = r20
            r18 = -1
            goto L_0x0312
        L_0x02ab:
            r0 = 49
            if (r13 > r0) goto L_0x02fa
            r1 = r22
            long r1 = (long) r1
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r5 = r3
            r3 = r4
            r24 = r4
            r4 = r34
            r33 = r5
            r5 = r17
            r25 = r6
            r6 = r23
            r26 = r20
            r20 = r7
            r7 = r33
            r27 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r15
            r29 = r20
            r18 = -1
            r9 = r21
            r11 = r13
            r12 = r27
            r14 = r35
            int r0 = r0.V(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r14 = r24
            if (r0 == r14) goto L_0x02f8
        L_0x02e7:
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r15
            r1 = r23
            r6 = r25
            r7 = r26
            goto L_0x0361
        L_0x02f8:
            r2 = r0
            goto L_0x0313
        L_0x02fa:
            r33 = r3
            r14 = r4
            r25 = r6
            r29 = r7
            r27 = r8
            r26 = r20
            r1 = r22
            r18 = -1
            r0 = 50
            r7 = r33
            if (r13 != r0) goto L_0x032b
            r0 = 2
            if (r7 == r0) goto L_0x0318
        L_0x0312:
            r2 = r14
        L_0x0313:
            r6 = r25
            r7 = r26
            goto L_0x0346
        L_0x0318:
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r14
            r4 = r34
            r5 = r15
            r6 = r27
            r8 = r35
            r0.S(r1, r2, r3, r4, r5, r6, r8)
            r0 = 0
            throw r0
        L_0x032b:
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r14
            r4 = r34
            r5 = r17
            r6 = r23
            r9 = r13
            r10 = r27
            r12 = r15
            r13 = r35
            int r0 = r0.T(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r14) goto L_0x02f8
            goto L_0x02e7
        L_0x0346:
            c.d.a.b.e.e.bb r4 = K(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = c.d.a.b.e.e.h7.i(r0, r1, r2, r3, r4, r5)
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r15
            r1 = r23
        L_0x0361:
            r9 = r29
        L_0x0363:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r15 = r30
            goto L_0x001d
        L_0x036b:
            r25 = r6
            r29 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x037e
            long r1 = (long) r7
            r3 = r31
            r6 = r25
            r4 = r29
            r4.putInt(r3, r1, r6)
        L_0x037e:
            r1 = r34
            if (r0 != r1) goto L_0x0383
            return r0
        L_0x0383:
            c.d.a.b.e.e.a9 r0 = c.d.a.b.e.e.a9.e()
            goto L_0x0389
        L_0x0388:
            throw r0
        L_0x0389:
            goto L_0x0388
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.aa.U(java.lang.Object, byte[], int, int, c.d.a.b.e.e.g7):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:134:0x024c, code lost:
        if (r7.f1639b != 0) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x024e, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0250, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0251, code lost:
        r12.g(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0254, code lost:
        if (r4 >= r5) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0256, code lost:
        r6 = c.d.a.b.e.e.h7.j(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x025c, code lost:
        if (r2 == r7.f1638a) goto L_0x025f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x025f, code lost:
        r4 = c.d.a.b.e.e.h7.m(r3, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0267, code lost:
        if (r7.f1639b == 0) goto L_0x0250;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x026a, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011b, code lost:
        if (r4 == 0) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011d, code lost:
        r12.add(c.d.a.b.e.e.r7.k);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0123, code lost:
        r12.add(c.d.a.b.e.e.r7.u(r3, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012b, code lost:
        if (r1 >= r5) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x012d, code lost:
        r4 = c.d.a.b.e.e.h7.j(r3, r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0133, code lost:
        if (r2 == r7.f1638a) goto L_0x0136;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0136, code lost:
        r1 = c.d.a.b.e.e.h7.j(r3, r4, r7);
        r4 = r7.f1638a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013c, code lost:
        if (r4 < 0) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0140, code lost:
        if (r4 > (r3.length - r1)) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0142, code lost:
        if (r4 != 0) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0149, code lost:
        throw c.d.a.b.e.e.a9.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014e, code lost:
        throw c.d.a.b.e.e.a9.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014f, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x019d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int V(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, c.d.a.b.e.e.g7 r29) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = p
            java.lang.Object r12 = r11.getObject(r1, r9)
            c.d.a.b.e.e.x8 r12 = (c.d.a.b.e.e.x8) r12
            boolean r13 = r12.c()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            c.d.a.b.e.e.x8 r12 = r12.h(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x0380;
                case 19: goto L_0x033a;
                case 20: goto L_0x0302;
                case 21: goto L_0x0302;
                case 22: goto L_0x02e7;
                case 23: goto L_0x02a9;
                case 24: goto L_0x026b;
                case 25: goto L_0x0218;
                case 26: goto L_0x0175;
                case 27: goto L_0x015a;
                case 28: goto L_0x010d;
                case 29: goto L_0x02e7;
                case 30: goto L_0x00dc;
                case 31: goto L_0x026b;
                case 32: goto L_0x02a9;
                case 33: goto L_0x009c;
                case 34: goto L_0x005c;
                case 35: goto L_0x0380;
                case 36: goto L_0x033a;
                case 37: goto L_0x0302;
                case 38: goto L_0x0302;
                case 39: goto L_0x02e7;
                case 40: goto L_0x02a9;
                case 41: goto L_0x026b;
                case 42: goto L_0x0218;
                case 43: goto L_0x02e7;
                case 44: goto L_0x00dc;
                case 45: goto L_0x026b;
                case 46: goto L_0x02a9;
                case 47: goto L_0x009c;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x03e3
            c.d.a.b.e.e.ia r1 = r15.n(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = c.d.a.b.e.e.h7.c(r21, r22, r23, r24, r25, r26)
        L_0x0055:
            java.lang.Object r8 = r7.f1640c
            r12.add(r8)
            goto L_0x03c5
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            c.d.a.b.e.e.m9 r12 = (c.d.a.b.e.e.m9) r12
            int r1 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r2 = r7.f1638a
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = c.d.a.b.e.e.h7.m(r3, r1, r7)
            long r4 = r7.f1639b
            long r4 = c.d.a.b.e.e.v7.b(r4)
            r12.i(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x03e4
        L_0x007b:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.f()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x03e3
            c.d.a.b.e.e.m9 r12 = (c.d.a.b.e.e.m9) r12
        L_0x0084:
            int r1 = c.d.a.b.e.e.h7.m(r3, r4, r7)
            long r8 = r7.f1639b
            long r8 = c.d.a.b.e.e.v7.b(r8)
            r12.i(r8)
            if (r1 >= r5) goto L_0x009b
            int r4 = c.d.a.b.e.e.h7.j(r3, r1, r7)
            int r6 = r7.f1638a
            if (r2 == r6) goto L_0x0084
        L_0x009b:
            return r1
        L_0x009c:
            if (r6 != r14) goto L_0x00c0
            c.d.a.b.e.e.t8 r12 = (c.d.a.b.e.e.t8) r12
            int r1 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r2 = r7.f1638a
            int r2 = r2 + r1
        L_0x00a7:
            if (r1 >= r2) goto L_0x00b7
            int r1 = c.d.a.b.e.e.h7.j(r3, r1, r7)
            int r4 = r7.f1638a
            int r4 = c.d.a.b.e.e.v7.a(r4)
            r12.j(r4)
            goto L_0x00a7
        L_0x00b7:
            if (r1 != r2) goto L_0x00bb
            goto L_0x03e4
        L_0x00bb:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.f()
            throw r1
        L_0x00c0:
            if (r6 != 0) goto L_0x03e3
            c.d.a.b.e.e.t8 r12 = (c.d.a.b.e.e.t8) r12
        L_0x00c4:
            int r1 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r4 = r7.f1638a
            int r4 = c.d.a.b.e.e.v7.a(r4)
            r12.j(r4)
            if (r1 >= r5) goto L_0x00db
            int r4 = c.d.a.b.e.e.h7.j(r3, r1, r7)
            int r6 = r7.f1638a
            if (r2 == r6) goto L_0x00c4
        L_0x00db:
            return r1
        L_0x00dc:
            if (r6 != r14) goto L_0x00e3
            int r2 = c.d.a.b.e.e.h7.f(r3, r4, r12, r7)
            goto L_0x00f4
        L_0x00e3:
            if (r6 != 0) goto L_0x03e3
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = c.d.a.b.e.e.h7.l(r2, r3, r4, r5, r6, r7)
        L_0x00f4:
            c.d.a.b.e.e.u8 r3 = r15.m(r8)
            r4 = 0
            c.d.a.b.e.e.ab r5 = r0.l
            r22 = r16
            r23 = r21
            r24 = r12
            r25 = r3
            r26 = r4
            r27 = r5
            c.d.a.b.e.e.ka.c(r22, r23, r24, r25, r26, r27)
        L_0x010a:
            r1 = r2
            goto L_0x03e4
        L_0x010d:
            if (r6 != r14) goto L_0x03e3
            int r1 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r4 = r7.f1638a
            if (r4 < 0) goto L_0x0155
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0150
            if (r4 != 0) goto L_0x0123
        L_0x011d:
            c.d.a.b.e.e.r7 r4 = c.d.a.b.e.e.r7.k
            r12.add(r4)
            goto L_0x012b
        L_0x0123:
            c.d.a.b.e.e.r7 r6 = c.d.a.b.e.e.r7.u(r3, r1, r4)
            r12.add(r6)
            int r1 = r1 + r4
        L_0x012b:
            if (r1 >= r5) goto L_0x014f
            int r4 = c.d.a.b.e.e.h7.j(r3, r1, r7)
            int r6 = r7.f1638a
            if (r2 == r6) goto L_0x0136
            goto L_0x014f
        L_0x0136:
            int r1 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r4 = r7.f1638a
            if (r4 < 0) goto L_0x014a
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0145
            if (r4 != 0) goto L_0x0123
            goto L_0x011d
        L_0x0145:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.f()
            throw r1
        L_0x014a:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.d()
            throw r1
        L_0x014f:
            return r1
        L_0x0150:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.f()
            throw r1
        L_0x0155:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.d()
            throw r1
        L_0x015a:
            if (r6 == r14) goto L_0x015e
            goto L_0x03e3
        L_0x015e:
            c.d.a.b.e.e.ia r1 = r15.n(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = c.d.a.b.e.e.h7.e(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x0175:
            if (r6 != r14) goto L_0x03e3
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            int r4 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            if (r6 != 0) goto L_0x01c2
            int r6 = r7.f1638a
            if (r6 < 0) goto L_0x01bd
            if (r6 != 0) goto L_0x0190
        L_0x018c:
            r12.add(r1)
            goto L_0x019b
        L_0x0190:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = c.d.a.b.e.e.y8.f1783a
            r8.<init>(r3, r4, r6, r9)
        L_0x0197:
            r12.add(r8)
            int r4 = r4 + r6
        L_0x019b:
            if (r4 >= r5) goto L_0x03e3
            int r6 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r8 = r7.f1638a
            if (r2 != r8) goto L_0x03e3
            int r4 = c.d.a.b.e.e.h7.j(r3, r6, r7)
            int r6 = r7.f1638a
            if (r6 < 0) goto L_0x01b8
            if (r6 != 0) goto L_0x01b0
            goto L_0x018c
        L_0x01b0:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = c.d.a.b.e.e.y8.f1783a
            r8.<init>(r3, r4, r6, r9)
            goto L_0x0197
        L_0x01b8:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.d()
            throw r1
        L_0x01bd:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.d()
            throw r1
        L_0x01c2:
            int r6 = r7.f1638a
            if (r6 < 0) goto L_0x0213
            if (r6 != 0) goto L_0x01cc
        L_0x01c8:
            r12.add(r1)
            goto L_0x01df
        L_0x01cc:
            int r8 = r4 + r6
            boolean r9 = c.d.a.b.e.e.qb.f(r3, r4, r8)
            if (r9 == 0) goto L_0x020e
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = c.d.a.b.e.e.y8.f1783a
            r9.<init>(r3, r4, r6, r10)
        L_0x01db:
            r12.add(r9)
            r4 = r8
        L_0x01df:
            if (r4 >= r5) goto L_0x03e3
            int r6 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r8 = r7.f1638a
            if (r2 != r8) goto L_0x03e3
            int r4 = c.d.a.b.e.e.h7.j(r3, r6, r7)
            int r6 = r7.f1638a
            if (r6 < 0) goto L_0x0209
            if (r6 != 0) goto L_0x01f4
            goto L_0x01c8
        L_0x01f4:
            int r8 = r4 + r6
            boolean r9 = c.d.a.b.e.e.qb.f(r3, r4, r8)
            if (r9 == 0) goto L_0x0204
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = c.d.a.b.e.e.y8.f1783a
            r9.<init>(r3, r4, r6, r10)
            goto L_0x01db
        L_0x0204:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.c()
            throw r1
        L_0x0209:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.d()
            throw r1
        L_0x020e:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.c()
            throw r1
        L_0x0213:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.d()
            throw r1
        L_0x0218:
            r1 = 0
            if (r6 != r14) goto L_0x0240
            c.d.a.b.e.e.i7 r12 = (c.d.a.b.e.e.i7) r12
            int r2 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r4 = r7.f1638a
            int r4 = r4 + r2
        L_0x0224:
            if (r2 >= r4) goto L_0x0237
            int r2 = c.d.a.b.e.e.h7.m(r3, r2, r7)
            long r5 = r7.f1639b
            int r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0232
            r5 = 1
            goto L_0x0233
        L_0x0232:
            r5 = 0
        L_0x0233:
            r12.g(r5)
            goto L_0x0224
        L_0x0237:
            if (r2 != r4) goto L_0x023b
            goto L_0x010a
        L_0x023b:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.f()
            throw r1
        L_0x0240:
            if (r6 != 0) goto L_0x03e3
            c.d.a.b.e.e.i7 r12 = (c.d.a.b.e.e.i7) r12
            int r4 = c.d.a.b.e.e.h7.m(r3, r4, r7)
            long r8 = r7.f1639b
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0250
        L_0x024e:
            r6 = 1
            goto L_0x0251
        L_0x0250:
            r6 = 0
        L_0x0251:
            r12.g(r6)
            if (r4 >= r5) goto L_0x026a
            int r6 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r8 = r7.f1638a
            if (r2 == r8) goto L_0x025f
            goto L_0x026a
        L_0x025f:
            int r4 = c.d.a.b.e.e.h7.m(r3, r6, r7)
            long r8 = r7.f1639b
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0250
            goto L_0x024e
        L_0x026a:
            return r4
        L_0x026b:
            if (r6 != r14) goto L_0x028b
            c.d.a.b.e.e.t8 r12 = (c.d.a.b.e.e.t8) r12
            int r1 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r2 = r7.f1638a
            int r2 = r2 + r1
        L_0x0276:
            if (r1 >= r2) goto L_0x0282
            int r4 = c.d.a.b.e.e.h7.b(r3, r1)
            r12.j(r4)
            int r1 = r1 + 4
            goto L_0x0276
        L_0x0282:
            if (r1 != r2) goto L_0x0286
            goto L_0x03e4
        L_0x0286:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.f()
            throw r1
        L_0x028b:
            if (r6 != r9) goto L_0x03e3
            c.d.a.b.e.e.t8 r12 = (c.d.a.b.e.e.t8) r12
            int r1 = c.d.a.b.e.e.h7.b(r17, r18)
        L_0x0293:
            r12.j(r1)
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02a8
            int r4 = c.d.a.b.e.e.h7.j(r3, r1, r7)
            int r6 = r7.f1638a
            if (r2 == r6) goto L_0x02a3
            goto L_0x02a8
        L_0x02a3:
            int r1 = c.d.a.b.e.e.h7.b(r3, r4)
            goto L_0x0293
        L_0x02a8:
            return r1
        L_0x02a9:
            if (r6 != r14) goto L_0x02c9
            c.d.a.b.e.e.m9 r12 = (c.d.a.b.e.e.m9) r12
            int r1 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r2 = r7.f1638a
            int r2 = r2 + r1
        L_0x02b4:
            if (r1 >= r2) goto L_0x02c0
            long r4 = c.d.a.b.e.e.h7.p(r3, r1)
            r12.i(r4)
            int r1 = r1 + 8
            goto L_0x02b4
        L_0x02c0:
            if (r1 != r2) goto L_0x02c4
            goto L_0x03e4
        L_0x02c4:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.f()
            throw r1
        L_0x02c9:
            if (r6 != r13) goto L_0x03e3
            c.d.a.b.e.e.m9 r12 = (c.d.a.b.e.e.m9) r12
            long r8 = c.d.a.b.e.e.h7.p(r17, r18)
        L_0x02d1:
            r12.i(r8)
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x02e6
            int r4 = c.d.a.b.e.e.h7.j(r3, r1, r7)
            int r6 = r7.f1638a
            if (r2 == r6) goto L_0x02e1
            goto L_0x02e6
        L_0x02e1:
            long r8 = c.d.a.b.e.e.h7.p(r3, r4)
            goto L_0x02d1
        L_0x02e6:
            return r1
        L_0x02e7:
            if (r6 != r14) goto L_0x02ef
            int r1 = c.d.a.b.e.e.h7.f(r3, r4, r12, r7)
            goto L_0x03e4
        L_0x02ef:
            if (r6 == 0) goto L_0x02f3
            goto L_0x03e3
        L_0x02f3:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = c.d.a.b.e.e.h7.l(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0302:
            if (r6 != r14) goto L_0x0322
            c.d.a.b.e.e.m9 r12 = (c.d.a.b.e.e.m9) r12
            int r1 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r2 = r7.f1638a
            int r2 = r2 + r1
        L_0x030d:
            if (r1 >= r2) goto L_0x0319
            int r1 = c.d.a.b.e.e.h7.m(r3, r1, r7)
            long r4 = r7.f1639b
            r12.i(r4)
            goto L_0x030d
        L_0x0319:
            if (r1 != r2) goto L_0x031d
            goto L_0x03e4
        L_0x031d:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.f()
            throw r1
        L_0x0322:
            if (r6 != 0) goto L_0x03e3
            c.d.a.b.e.e.m9 r12 = (c.d.a.b.e.e.m9) r12
        L_0x0326:
            int r1 = c.d.a.b.e.e.h7.m(r3, r4, r7)
            long r8 = r7.f1639b
            r12.i(r8)
            if (r1 >= r5) goto L_0x0339
            int r4 = c.d.a.b.e.e.h7.j(r3, r1, r7)
            int r6 = r7.f1638a
            if (r2 == r6) goto L_0x0326
        L_0x0339:
            return r1
        L_0x033a:
            if (r6 != r14) goto L_0x035e
            c.d.a.b.e.e.l8 r12 = (c.d.a.b.e.e.l8) r12
            int r1 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r2 = r7.f1638a
            int r2 = r2 + r1
        L_0x0345:
            if (r1 >= r2) goto L_0x0355
            int r4 = c.d.a.b.e.e.h7.b(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.g(r4)
            int r1 = r1 + 4
            goto L_0x0345
        L_0x0355:
            if (r1 != r2) goto L_0x0359
            goto L_0x03e4
        L_0x0359:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.f()
            throw r1
        L_0x035e:
            if (r6 != r9) goto L_0x03e3
            c.d.a.b.e.e.l8 r12 = (c.d.a.b.e.e.l8) r12
            int r1 = c.d.a.b.e.e.h7.b(r17, r18)
        L_0x0366:
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.g(r1)
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x037f
            int r4 = c.d.a.b.e.e.h7.j(r3, r1, r7)
            int r6 = r7.f1638a
            if (r2 == r6) goto L_0x037a
            goto L_0x037f
        L_0x037a:
            int r1 = c.d.a.b.e.e.h7.b(r3, r4)
            goto L_0x0366
        L_0x037f:
            return r1
        L_0x0380:
            if (r6 != r14) goto L_0x03a3
            c.d.a.b.e.e.b8 r12 = (c.d.a.b.e.e.b8) r12
            int r1 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r2 = r7.f1638a
            int r2 = r2 + r1
        L_0x038b:
            if (r1 >= r2) goto L_0x039b
            long r4 = c.d.a.b.e.e.h7.p(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.g(r4)
            int r1 = r1 + 8
            goto L_0x038b
        L_0x039b:
            if (r1 != r2) goto L_0x039e
            goto L_0x03e4
        L_0x039e:
            c.d.a.b.e.e.a9 r1 = c.d.a.b.e.e.a9.f()
            throw r1
        L_0x03a3:
            if (r6 != r13) goto L_0x03e3
            c.d.a.b.e.e.b8 r12 = (c.d.a.b.e.e.b8) r12
            long r8 = c.d.a.b.e.e.h7.p(r17, r18)
        L_0x03ab:
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.g(r8)
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x03c4
            int r4 = c.d.a.b.e.e.h7.j(r3, r1, r7)
            int r6 = r7.f1638a
            if (r2 == r6) goto L_0x03bf
            goto L_0x03c4
        L_0x03bf:
            long r8 = c.d.a.b.e.e.h7.p(r3, r4)
            goto L_0x03ab
        L_0x03c4:
            return r1
        L_0x03c5:
            if (r4 >= r5) goto L_0x03e2
            int r8 = c.d.a.b.e.e.h7.j(r3, r4, r7)
            int r9 = r7.f1638a
            if (r2 == r9) goto L_0x03d0
            goto L_0x03e2
        L_0x03d0:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = c.d.a.b.e.e.h7.c(r21, r22, r23, r24, r25, r26)
            goto L_0x0055
        L_0x03e2:
            return r4
        L_0x03e3:
            r1 = r4
        L_0x03e4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.aa.V(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, c.d.a.b.e.e.g7):int");
    }

    private final int W(int i2) {
        if (i2 < this.f1572c || i2 > this.f1573d) {
            return -1;
        }
        return Z(i2, 0);
    }

    private final int X(int i2, int i3) {
        if (i2 < this.f1572c || i2 > this.f1573d) {
            return -1;
        }
        return Z(i2, i3);
    }

    private final int Y(int i2) {
        return this.f1570a[i2 + 2];
    }

    private final int Z(int i2, int i3) {
        int length = (this.f1570a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f1570a[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private static int j(int i2) {
        return (i2 >>> 20) & 255;
    }

    private final int k(int i2) {
        return this.f1570a[i2 + 1];
    }

    private static long l(Object obj, long j2) {
        return ((Long) kb.k(obj, j2)).longValue();
    }

    private final u8 m(int i2) {
        int i3 = i2 / 3;
        return (u8) this.f1571b[i3 + i3 + 1];
    }

    private final ia n(int i2) {
        int i3 = i2 / 3;
        int i4 = i3 + i3;
        ia iaVar = (ia) this.f1571b[i4];
        if (iaVar != null) {
            return iaVar;
        }
        ia b2 = fa.a().b((Class) this.f1571b[i4 + 1]);
        this.f1571b[i4] = b2;
        return b2;
    }

    private final Object o(int i2) {
        int i3 = i2 / 3;
        return this.f1571b[i3 + i3];
    }

    private final Object p(Object obj, int i2) {
        ia n2 = n(i2);
        long k2 = (long) (k(i2) & 1048575);
        if (!C(obj, i2)) {
            return n2.e();
        }
        Object object = p.getObject(obj, k2);
        if (F(object)) {
            return object;
        }
        Object e2 = n2.e();
        if (object != null) {
            n2.c(e2, object);
        }
        return e2;
    }

    private final Object q(Object obj, int i2, int i3) {
        ia n2 = n(i3);
        if (!G(obj, i2, i3)) {
            return n2.e();
        }
        Object object = p.getObject(obj, (long) (k(i3) & 1048575));
        if (F(object)) {
            return object;
        }
        Object e2 = n2.e();
        if (object != null) {
            n2.c(e2, object);
        }
        return e2;
    }

    private static Field r(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void s(Object obj) {
        if (!F(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void t(Object obj, Object obj2, int i2) {
        if (C(obj2, i2)) {
            long k2 = (long) (k(i2) & 1048575);
            Unsafe unsafe = p;
            Object object = unsafe.getObject(obj2, k2);
            if (object != null) {
                ia n2 = n(i2);
                if (!C(obj, i2)) {
                    if (!F(object)) {
                        unsafe.putObject(obj, k2, object);
                    } else {
                        Object e2 = n2.e();
                        n2.c(e2, object);
                        unsafe.putObject(obj, k2, e2);
                    }
                    v(obj, i2);
                    return;
                }
                Object object2 = unsafe.getObject(obj, k2);
                if (!F(object2)) {
                    Object e3 = n2.e();
                    n2.c(e3, object2);
                    unsafe.putObject(obj, k2, e3);
                    object2 = e3;
                }
                n2.c(object2, object);
                return;
            }
            int i3 = this.f1570a[i2];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + obj3);
        }
    }

    private final void u(Object obj, Object obj2, int i2) {
        int i3 = this.f1570a[i2];
        if (G(obj2, i3, i2)) {
            long k2 = (long) (k(i2) & 1048575);
            Unsafe unsafe = p;
            Object object = unsafe.getObject(obj2, k2);
            if (object != null) {
                ia n2 = n(i2);
                if (!G(obj, i3, i2)) {
                    if (!F(object)) {
                        unsafe.putObject(obj, k2, object);
                    } else {
                        Object e2 = n2.e();
                        n2.c(e2, object);
                        unsafe.putObject(obj, k2, e2);
                    }
                    w(obj, i3, i2);
                    return;
                }
                Object object2 = unsafe.getObject(obj, k2);
                if (!F(object2)) {
                    Object e3 = n2.e();
                    n2.c(e3, object2);
                    unsafe.putObject(obj, k2, e3);
                    object2 = e3;
                }
                n2.c(object2, object);
                return;
            }
            int i4 = this.f1570a[i2];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i4 + " is present but null: " + obj3);
        }
    }

    private final void v(Object obj, int i2) {
        int Y = Y(i2);
        long j2 = (long) (1048575 & Y);
        if (j2 != 1048575) {
            kb.v(obj, j2, (1 << (Y >>> 20)) | kb.h(obj, j2));
        }
    }

    private final void w(Object obj, int i2, int i3) {
        kb.v(obj, (long) (Y(i3) & 1048575), i2);
    }

    private final void x(Object obj, int i2, Object obj2) {
        p.putObject(obj, (long) (k(i2) & 1048575), obj2);
        v(obj, i2);
    }

    private final void y(Object obj, int i2, int i3, Object obj2) {
        p.putObject(obj, (long) (k(i3) & 1048575), obj2);
        w(obj, i2, i3);
    }

    private final void z(Object obj, tb tbVar) {
        int i2;
        Object obj2 = obj;
        tb tbVar2 = tbVar;
        if (!this.f1575f) {
            int length = this.f1570a.length;
            Unsafe unsafe = p;
            int i3 = 1048575;
            int i4 = 0;
            int i5 = 0;
            int i6 = 1048575;
            while (i4 < length) {
                int k2 = k(i4);
                int[] iArr = this.f1570a;
                int i7 = iArr[i4];
                int j2 = j(k2);
                if (j2 <= 17) {
                    int i8 = iArr[i4 + 2];
                    int i9 = i8 & i3;
                    if (i9 != i6) {
                        i5 = unsafe.getInt(obj2, (long) i9);
                        i6 = i9;
                    }
                    i2 = 1 << (i8 >>> 20);
                } else {
                    i2 = 0;
                }
                long j3 = (long) (k2 & i3);
                switch (j2) {
                    case 0:
                        if ((i5 & i2) == 0) {
                            break;
                        } else {
                            tbVar2.f(i7, kb.f(obj2, j3));
                            continue;
                        }
                    case 1:
                        if ((i5 & i2) != 0) {
                            tbVar2.r(i7, kb.g(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if ((i5 & i2) != 0) {
                            tbVar2.I(i7, unsafe.getLong(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if ((i5 & i2) != 0) {
                            tbVar2.i(i7, unsafe.getLong(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if ((i5 & i2) != 0) {
                            tbVar2.J(i7, unsafe.getInt(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if ((i5 & i2) != 0) {
                            tbVar2.v(i7, unsafe.getLong(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if ((i5 & i2) != 0) {
                            tbVar2.A(i7, unsafe.getInt(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if ((i5 & i2) != 0) {
                            tbVar2.C(i7, kb.B(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        if ((i5 & i2) != 0) {
                            I(i7, unsafe.getObject(obj2, j3), tbVar2);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if ((i5 & i2) != 0) {
                            tbVar2.x(i7, unsafe.getObject(obj2, j3), n(i4));
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if ((i5 & i2) != 0) {
                            tbVar2.s(i7, (r7) unsafe.getObject(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if ((i5 & i2) != 0) {
                            tbVar2.g(i7, unsafe.getInt(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        if ((i5 & i2) != 0) {
                            tbVar2.z(i7, unsafe.getInt(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        if ((i5 & i2) != 0) {
                            tbVar2.o(i7, unsafe.getInt(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        if ((i5 & i2) != 0) {
                            tbVar2.c(i7, unsafe.getLong(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        if ((i5 & i2) != 0) {
                            tbVar2.E(i7, unsafe.getInt(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        if ((i5 & i2) != 0) {
                            tbVar2.G(i7, unsafe.getLong(obj2, j3));
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        if ((i5 & i2) != 0) {
                            tbVar2.l(i7, unsafe.getObject(obj2, j3), n(i4));
                            break;
                        } else {
                            continue;
                        }
                    case 18:
                        ka.j(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        continue;
                    case 19:
                        ka.n(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        continue;
                    case 20:
                        ka.q(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        continue;
                    case 21:
                        ka.y(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        continue;
                    case 22:
                        ka.p(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        continue;
                    case j.h3:
                        ka.m(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        continue;
                    case j.i3:
                        ka.l(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        continue;
                    case 25:
                        ka.h(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        continue;
                    case 26:
                        ka.w(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2);
                        break;
                    case 27:
                        ka.r(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, n(i4));
                        break;
                    case 28:
                        ka.i(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2);
                        break;
                    case 29:
                        ka.x(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        break;
                    case 30:
                        ka.k(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        break;
                    case 31:
                        ka.s(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        break;
                    case 32:
                        ka.t(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        break;
                    case 33:
                        ka.u(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        break;
                    case 34:
                        ka.v(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, false);
                        break;
                    case 35:
                        ka.j(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 36:
                        ka.n(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 37:
                        ka.q(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 38:
                        ka.y(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 39:
                        ka.p(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 40:
                        ka.m(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 41:
                        ka.l(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 42:
                        ka.h(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 43:
                        ka.x(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 44:
                        ka.k(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 45:
                        ka.s(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 46:
                        ka.t(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 47:
                        ka.u(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 48:
                        ka.v(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, true);
                        break;
                    case 49:
                        ka.o(this.f1570a[i4], (List) unsafe.getObject(obj2, j3), tbVar2, n(i4));
                        break;
                    case 50:
                        A(tbVar2, i7, unsafe.getObject(obj2, j3), i4);
                        break;
                    case 51:
                        if (G(obj2, i7, i4)) {
                            tbVar2.f(i7, N(obj2, j3));
                            break;
                        }
                        break;
                    case 52:
                        if (G(obj2, i7, i4)) {
                            tbVar2.r(i7, O(obj2, j3));
                            break;
                        }
                        break;
                    case 53:
                        if (G(obj2, i7, i4)) {
                            tbVar2.I(i7, l(obj2, j3));
                            break;
                        }
                        break;
                    case 54:
                        if (G(obj2, i7, i4)) {
                            tbVar2.i(i7, l(obj2, j3));
                            break;
                        }
                        break;
                    case 55:
                        if (G(obj2, i7, i4)) {
                            tbVar2.J(i7, R(obj2, j3));
                            break;
                        }
                        break;
                    case 56:
                        if (G(obj2, i7, i4)) {
                            tbVar2.v(i7, l(obj2, j3));
                            break;
                        }
                        break;
                    case 57:
                        if (G(obj2, i7, i4)) {
                            tbVar2.A(i7, R(obj2, j3));
                            break;
                        }
                        break;
                    case 58:
                        if (G(obj2, i7, i4)) {
                            tbVar2.C(i7, H(obj2, j3));
                            break;
                        }
                        break;
                    case 59:
                        if (G(obj2, i7, i4)) {
                            I(i7, unsafe.getObject(obj2, j3), tbVar2);
                            break;
                        }
                        break;
                    case 60:
                        if (G(obj2, i7, i4)) {
                            tbVar2.x(i7, unsafe.getObject(obj2, j3), n(i4));
                            break;
                        }
                        break;
                    case 61:
                        if (G(obj2, i7, i4)) {
                            tbVar2.s(i7, (r7) unsafe.getObject(obj2, j3));
                            break;
                        }
                        break;
                    case 62:
                        if (G(obj2, i7, i4)) {
                            tbVar2.g(i7, R(obj2, j3));
                            break;
                        }
                        break;
                    case 63:
                        if (G(obj2, i7, i4)) {
                            tbVar2.z(i7, R(obj2, j3));
                            break;
                        }
                        break;
                    case 64:
                        if (G(obj2, i7, i4)) {
                            tbVar2.o(i7, R(obj2, j3));
                            break;
                        }
                        break;
                    case 65:
                        if (G(obj2, i7, i4)) {
                            tbVar2.c(i7, l(obj2, j3));
                            break;
                        }
                        break;
                    case 66:
                        if (G(obj2, i7, i4)) {
                            tbVar2.E(i7, R(obj2, j3));
                            break;
                        }
                        break;
                    case 67:
                        if (G(obj2, i7, i4)) {
                            tbVar2.G(i7, l(obj2, j3));
                            break;
                        }
                        break;
                    case 68:
                        if (G(obj2, i7, i4)) {
                            tbVar2.l(i7, unsafe.getObject(obj2, j3), n(i4));
                            break;
                        }
                        break;
                }
                i4 += 3;
                i3 = 1048575;
            }
            ab abVar = this.l;
            abVar.i(abVar.d(obj2), tbVar2);
            return;
        }
        this.m.a(obj2);
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0337, code lost:
        if (r0 != r15) goto L_0x0339;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0353, code lost:
        r7 = r34;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x039c, code lost:
        if (r0 != r15) goto L_0x0339;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0110, code lost:
        r10.putInt(r14, r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x018b, code lost:
        r5 = r26 | r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x018d, code lost:
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0190, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01f3, code lost:
        r5 = r26 | r24;
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01f6, code lost:
        r2 = r11;
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01fa, code lost:
        r8 = r6;
        r6 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0291, code lost:
        r0 = r6 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0293, code lost:
        r5 = r26 | r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0295, code lost:
        r2 = r11;
        r3 = r13;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x029b, code lost:
        r8 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x029d, code lost:
        r7 = r34;
        r2 = r6;
        r28 = r10;
        r20 = r11;
        r21 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int J(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, c.d.a.b.e.e.g7 r35) {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            s(r30)
            sun.misc.Unsafe r10 = p
            r16 = 0
            r0 = r32
            r1 = 0
            r2 = -1
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001c:
            r17 = 0
            if (r0 >= r13) goto L_0x0407
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002f
            int r0 = c.d.a.b.e.e.h7.k(r0, r12, r1, r9)
            int r1 = r9.f1638a
            r4 = r1
            r1 = r0
            goto L_0x0030
        L_0x002f:
            r4 = r0
        L_0x0030:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r2) goto L_0x003d
            int r3 = r3 / r8
            int r2 = r15.X(r0, r3)
            goto L_0x0041
        L_0x003d:
            int r2 = r15.W(r0)
        L_0x0041:
            r3 = -1
            if (r2 != r3) goto L_0x0053
            r20 = r0
            r2 = r1
            r8 = r4
            r26 = r5
            r28 = r10
            r7 = r11
            r19 = -1
            r21 = 0
            goto L_0x039f
        L_0x0053:
            int[] r3 = r15.f1570a
            int r20 = r2 + 1
            r8 = r3[r20]
            int r11 = j(r8)
            r20 = r0
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r8 & r18
            r21 = r1
            long r0 = (long) r0
            r22 = r0
            r0 = 17
            if (r11 > r0) goto L_0x02a8
            int r0 = r2 + 2
            r0 = r3[r0]
            int r3 = r0 >>> 20
            r1 = 1
            int r24 = r1 << r3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r3
            r18 = r4
            if (r0 == r6) goto L_0x008e
            if (r6 == r3) goto L_0x0084
            long r3 = (long) r6
            r10.putInt(r14, r3, r5)
        L_0x0084:
            long r3 = (long) r0
            int r5 = r10.getInt(r14, r3)
            r27 = r0
            r26 = r5
            goto L_0x0092
        L_0x008e:
            r26 = r5
            r27 = r6
        L_0x0092:
            r0 = 5
            switch(r11) {
                case 0: goto L_0x0278;
                case 1: goto L_0x025c;
                case 2: goto L_0x023c;
                case 3: goto L_0x023c;
                case 4: goto L_0x0224;
                case 5: goto L_0x01fe;
                case 6: goto L_0x01da;
                case 7: goto L_0x01b8;
                case 8: goto L_0x0193;
                case 9: goto L_0x0163;
                case 10: goto L_0x0148;
                case 11: goto L_0x0224;
                case 12: goto L_0x0115;
                case 13: goto L_0x01da;
                case 14: goto L_0x01fe;
                case 15: goto L_0x00f6;
                case 16: goto L_0x00c2;
                default: goto L_0x0096;
            }
        L_0x0096:
            r13 = r2
            r11 = r20
            r6 = r21
            r0 = 3
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x029b
            java.lang.Object r7 = r15.p(r14, r13)
            c.d.a.b.e.e.ia r1 = r15.n(r13)
            int r0 = r11 << 3
            r5 = r0 | 4
            r0 = r7
            r2 = r31
            r3 = r6
            r4 = r33
            r8 = r18
            r6 = r35
            int r0 = c.d.a.b.e.e.h7.n(r0, r1, r2, r3, r4, r5, r6)
            r15.x(r14, r13, r7)
            goto L_0x018b
        L_0x00c2:
            if (r7 != 0) goto L_0x00e8
            r1 = r21
            int r6 = c.d.a.b.e.e.h7.m(r12, r1, r9)
            long r0 = r9.f1639b
            long r4 = c.d.a.b.e.e.v7.b(r0)
            r11 = r20
            r7 = r22
            r0 = r10
            r1 = r30
            r13 = r2
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r7
            r8 = r18
            r0.putLong(r1, r2, r4)
            r5 = r26 | r24
            r0 = r6
            goto L_0x018d
        L_0x00e8:
            r13 = r2
            r11 = r20
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r18
            r6 = r21
            goto L_0x029d
        L_0x00f6:
            r13 = r2
            r8 = r18
            r11 = r20
            r1 = r21
            r3 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x0190
            int r0 = c.d.a.b.e.e.h7.j(r12, r1, r9)
            int r1 = r9.f1638a
            int r1 = c.d.a.b.e.e.v7.a(r1)
        L_0x0110:
            r10.putInt(r14, r3, r1)
            goto L_0x018b
        L_0x0115:
            r13 = r2
            r8 = r18
            r11 = r20
            r1 = r21
            r3 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x0190
            int r0 = c.d.a.b.e.e.h7.j(r12, r1, r9)
            int r1 = r9.f1638a
            c.d.a.b.e.e.u8 r2 = r15.m(r13)
            if (r2 == 0) goto L_0x0110
            boolean r2 = r2.a(r1)
            if (r2 == 0) goto L_0x0138
            goto L_0x0110
        L_0x0138:
            c.d.a.b.e.e.bb r2 = K(r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.j(r8, r1)
            r1 = r8
            r2 = r11
            goto L_0x02f3
        L_0x0148:
            r13 = r2
            r8 = r18
            r11 = r20
            r1 = r21
            r3 = r22
            r0 = 2
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x0190
            int r0 = c.d.a.b.e.e.h7.a(r12, r1, r9)
            java.lang.Object r1 = r9.f1640c
            r10.putObject(r14, r3, r1)
            goto L_0x018b
        L_0x0163:
            r13 = r2
            r8 = r18
            r11 = r20
            r1 = r21
            r0 = 2
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x0190
            java.lang.Object r6 = r15.p(r14, r13)
            c.d.a.b.e.e.ia r2 = r15.n(r13)
            r0 = r6
            r5 = r1
            r1 = r2
            r2 = r31
            r3 = r5
            r4 = r33
            r5 = r35
            int r0 = c.d.a.b.e.e.h7.o(r0, r1, r2, r3, r4, r5)
            r15.x(r14, r13, r6)
        L_0x018b:
            r5 = r26 | r24
        L_0x018d:
            r1 = r8
            goto L_0x01f6
        L_0x0190:
            r6 = r1
            goto L_0x029d
        L_0x0193:
            r13 = r2
            r6 = r18
            r11 = r20
            r5 = r21
            r3 = r22
            r0 = 2
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x01fa
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r8
            if (r0 != 0) goto L_0x01ae
            int r0 = c.d.a.b.e.e.h7.g(r12, r5, r9)
            goto L_0x01b2
        L_0x01ae:
            int r0 = c.d.a.b.e.e.h7.h(r12, r5, r9)
        L_0x01b2:
            java.lang.Object r1 = r9.f1640c
            r10.putObject(r14, r3, r1)
            goto L_0x01f3
        L_0x01b8:
            r13 = r2
            r6 = r18
            r11 = r20
            r5 = r21
            r3 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x01fa
            int r0 = c.d.a.b.e.e.h7.m(r12, r5, r9)
            long r7 = r9.f1639b
            r17 = 0
            int r2 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r2 == 0) goto L_0x01d5
            goto L_0x01d6
        L_0x01d5:
            r1 = 0
        L_0x01d6:
            c.d.a.b.e.e.kb.r(r14, r3, r1)
            goto L_0x01f3
        L_0x01da:
            r13 = r2
            r6 = r18
            r11 = r20
            r5 = r21
            r3 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x01fa
            int r0 = c.d.a.b.e.e.h7.b(r12, r5)
            r10.putInt(r14, r3, r0)
            int r0 = r5 + 4
        L_0x01f3:
            r5 = r26 | r24
            r1 = r6
        L_0x01f6:
            r2 = r11
            r3 = r13
            goto L_0x02f6
        L_0x01fa:
            r8 = r6
            r6 = r5
            goto L_0x029d
        L_0x01fe:
            r13 = r2
            r6 = r18
            r11 = r20
            r5 = r21
            r3 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r1) goto L_0x021f
            long r7 = c.d.a.b.e.e.h7.p(r12, r5)
            r0 = r10
            r1 = r30
            r2 = r3
            r18 = r6
            r6 = r5
            r4 = r7
            r0.putLong(r1, r2, r4)
            goto L_0x0291
        L_0x021f:
            r18 = r6
            r6 = r5
            goto L_0x029b
        L_0x0224:
            r13 = r2
            r11 = r20
            r6 = r21
            r3 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x029b
            int r0 = c.d.a.b.e.e.h7.j(r12, r6, r9)
            int r1 = r9.f1638a
            r10.putInt(r14, r3, r1)
            goto L_0x0293
        L_0x023c:
            r13 = r2
            r11 = r20
            r6 = r21
            r3 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x029b
            int r6 = c.d.a.b.e.e.h7.m(r12, r6, r9)
            long r7 = r9.f1639b
            r0 = r10
            r1 = r30
            r2 = r3
            r4 = r7
            r0.putLong(r1, r2, r4)
            r5 = r26 | r24
            r0 = r6
            goto L_0x0295
        L_0x025c:
            r13 = r2
            r11 = r20
            r6 = r21
            r3 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x029b
            int r0 = c.d.a.b.e.e.h7.b(r12, r6)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            c.d.a.b.e.e.kb.u(r14, r3, r0)
            int r0 = r6 + 4
            goto L_0x0293
        L_0x0278:
            r13 = r2
            r11 = r20
            r6 = r21
            r3 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r1) goto L_0x029b
            long r0 = c.d.a.b.e.e.h7.p(r12, r6)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            c.d.a.b.e.e.kb.t(r14, r3, r0)
        L_0x0291:
            int r0 = r6 + 8
        L_0x0293:
            r5 = r26 | r24
        L_0x0295:
            r2 = r11
            r3 = r13
            r1 = r18
            goto L_0x02f6
        L_0x029b:
            r8 = r18
        L_0x029d:
            r7 = r34
            r2 = r6
            r28 = r10
            r20 = r11
            r21 = r13
            goto L_0x036e
        L_0x02a8:
            r13 = r2
            r2 = r4
            r27 = r6
            r1 = r20
            r6 = r21
            r3 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r0 = 27
            if (r11 != r0) goto L_0x030b
            r0 = 2
            if (r7 != r0) goto L_0x02fe
            java.lang.Object r0 = r10.getObject(r14, r3)
            c.d.a.b.e.e.x8 r0 = (c.d.a.b.e.e.x8) r0
            boolean r7 = r0.c()
            if (r7 != 0) goto L_0x02db
            int r7 = r0.size()
            if (r7 != 0) goto L_0x02d3
            r7 = 10
            goto L_0x02d4
        L_0x02d3:
            int r7 = r7 + r7
        L_0x02d4:
            c.d.a.b.e.e.x8 r0 = r0.h(r7)
            r10.putObject(r14, r3, r0)
        L_0x02db:
            r7 = r0
            c.d.a.b.e.e.ia r0 = r15.n(r13)
            r8 = r1
            r1 = r2
            r11 = r2
            r2 = r31
            r3 = r6
            r4 = r33
            r26 = r5
            r5 = r7
            r6 = r35
            int r0 = c.d.a.b.e.e.h7.e(r0, r1, r2, r3, r4, r5, r6)
            r2 = r8
            r1 = r11
        L_0x02f3:
            r3 = r13
            r5 = r26
        L_0x02f6:
            r6 = r27
            r13 = r33
            r11 = r34
            goto L_0x001c
        L_0x02fe:
            r26 = r5
            r20 = r1
            r18 = r2
            r15 = r6
            r28 = r10
            r21 = r13
            goto L_0x0369
        L_0x030b:
            r26 = r5
            r5 = r2
            r2 = r1
            r0 = 49
            if (r11 > r0) goto L_0x0357
            long r0 = (long) r8
            r21 = r0
            r0 = r29
            r1 = r30
            r8 = r2
            r2 = r31
            r24 = r3
            r3 = r6
            r4 = r33
            r18 = r5
            r15 = r6
            r6 = r8
            r20 = r8
            r8 = r13
            r28 = r10
            r9 = r21
            r21 = r13
            r12 = r24
            r14 = r35
            int r0 = r0.V(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0353
        L_0x0339:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r1 = r18
            r2 = r20
            r3 = r21
            r5 = r26
            r6 = r27
            r10 = r28
            goto L_0x001c
        L_0x0353:
            r7 = r34
            r2 = r0
            goto L_0x036c
        L_0x0357:
            r20 = r2
            r24 = r3
            r18 = r5
            r15 = r6
            r28 = r10
            r21 = r13
            r0 = 50
            if (r11 != r0) goto L_0x0384
            r0 = 2
            if (r7 == r0) goto L_0x0371
        L_0x0369:
            r7 = r34
            r2 = r15
        L_0x036c:
            r8 = r18
        L_0x036e:
            r6 = r27
            goto L_0x039f
        L_0x0371:
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r21
            r6 = r24
            r8 = r35
            r0.S(r1, r2, r3, r4, r5, r6, r8)
            throw r17
        L_0x0384:
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r20
            r9 = r11
            r10 = r24
            r12 = r21
            r13 = r35
            int r0 = r0.T(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0353
            goto L_0x0339
        L_0x039f:
            if (r8 != r7) goto L_0x03ad
            if (r7 == 0) goto L_0x03ad
            r9 = r29
            r12 = r30
            r0 = r2
            r1 = r8
            r5 = r26
            goto L_0x0410
        L_0x03ad:
            r9 = r29
            boolean r0 = r9.f1575f
            if (r0 == 0) goto L_0x03e0
            r10 = r35
            c.d.a.b.e.e.e8 r0 = r10.f1641d
            c.d.a.b.e.e.e8 r1 = c.d.a.b.e.e.e8.f1626c
            if (r0 == r1) goto L_0x03dd
            c.d.a.b.e.e.x9 r1 = r9.f1574e
            r11 = r20
            c.d.a.b.e.e.r8 r0 = r0.b(r1, r11)
            if (r0 != 0) goto L_0x03d7
            c.d.a.b.e.e.bb r4 = K(r30)
            r0 = r8
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = c.d.a.b.e.e.h7.i(r0, r1, r2, r3, r4, r5)
            r12 = r30
            goto L_0x03f5
        L_0x03d7:
            r12 = r30
            r0 = r12
            c.d.a.b.e.e.q8 r0 = (c.d.a.b.e.e.q8) r0
            throw r17
        L_0x03dd:
            r12 = r30
            goto L_0x03e4
        L_0x03e0:
            r12 = r30
            r10 = r35
        L_0x03e4:
            r11 = r20
            c.d.a.b.e.e.bb r4 = K(r30)
            r0 = r8
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = c.d.a.b.e.e.h7.i(r0, r1, r2, r3, r4, r5)
        L_0x03f5:
            r13 = r33
            r1 = r8
            r15 = r9
            r9 = r10
            r2 = r11
            r14 = r12
            r3 = r21
            r5 = r26
            r10 = r28
            r12 = r31
            r11 = r7
            goto L_0x001c
        L_0x0407:
            r26 = r5
            r27 = r6
            r28 = r10
            r7 = r11
            r12 = r14
            r9 = r15
        L_0x0410:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r2) goto L_0x041b
            long r3 = (long) r6
            r6 = r28
            r6.putInt(r12, r3, r5)
        L_0x041b:
            int r3 = r9.i
        L_0x041d:
            int r4 = r9.j
            if (r3 >= r4) goto L_0x0448
            int[] r4 = r9.h
            r4 = r4[r3]
            int[] r5 = r9.f1570a
            r5 = r5[r4]
            int r5 = r9.k(r4)
            r5 = r5 & r2
            long r5 = (long) r5
            java.lang.Object r5 = c.d.a.b.e.e.kb.k(r12, r5)
            if (r5 != 0) goto L_0x0436
            goto L_0x043c
        L_0x0436:
            c.d.a.b.e.e.u8 r6 = r9.m(r4)
            if (r6 != 0) goto L_0x043f
        L_0x043c:
            int r3 = r3 + 1
            goto L_0x041d
        L_0x043f:
            c.d.a.b.e.e.r9 r5 = (c.d.a.b.e.e.r9) r5
            java.lang.Object r0 = r9.o(r4)
            c.d.a.b.e.e.q9 r0 = (c.d.a.b.e.e.q9) r0
            throw r17
        L_0x0448:
            r2 = r33
            if (r7 != 0) goto L_0x0454
            if (r0 != r2) goto L_0x044f
            goto L_0x0458
        L_0x044f:
            c.d.a.b.e.e.a9 r0 = c.d.a.b.e.e.a9.e()
            throw r0
        L_0x0454:
            if (r0 > r2) goto L_0x0459
            if (r1 != r7) goto L_0x0459
        L_0x0458:
            return r0
        L_0x0459:
            c.d.a.b.e.e.a9 r0 = c.d.a.b.e.e.a9.e()
            goto L_0x045f
        L_0x045e:
            throw r0
        L_0x045f:
            goto L_0x045e
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.aa.J(java.lang.Object, byte[], int, int, int, c.d.a.b.e.e.g7):int");
    }

    public final void a(Object obj) {
        if (F(obj)) {
            if (obj instanceof s8) {
                s8 s8Var = (s8) obj;
                s8Var.x(Integer.MAX_VALUE);
                s8Var.zzb = 0;
                s8Var.v();
            }
            int length = this.f1570a.length;
            for (int i2 = 0; i2 < length; i2 += 3) {
                int k2 = k(i2);
                long j2 = (long) (1048575 & k2);
                int j3 = j(k2);
                if (j3 != 9) {
                    switch (j3) {
                        case 17:
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case j.h3:
                        case j.i3:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.k.a(obj, j2);
                            continue;
                        case 50:
                            Unsafe unsafe = p;
                            Object object = unsafe.getObject(obj, j2);
                            if (object != null) {
                                ((r9) object).d();
                                unsafe.putObject(obj, j2, object);
                                break;
                            } else {
                                continue;
                            }
                    }
                }
                if (C(obj, i2)) {
                    n(i2).a(p.getObject(obj, j2));
                }
            }
            this.l.g(obj);
            if (this.f1575f) {
                this.m.b(obj);
            }
        }
    }

    public final int b(Object obj) {
        return this.g ? Q(obj) : P(obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        c.d.a.b.e.e.kb.x(r7, r2, c.d.a.b.e.e.kb.k(r8, r2));
        w(r7, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008c, code lost:
        c.d.a.b.e.e.kb.x(r7, r2, c.d.a.b.e.e.kb.k(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b6, code lost:
        c.d.a.b.e.e.kb.v(r7, r2, c.d.a.b.e.e.kb.h(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cb, code lost:
        c.d.a.b.e.e.kb.w(r7, r2, c.d.a.b.e.e.kb.i(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ee, code lost:
        v(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f1, code lost:
        r0 = r0 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            s(r7)
            java.util.Objects.requireNonNull(r8)
            r0 = 0
        L_0x0007:
            int[] r1 = r6.f1570a
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00f5
            int r1 = r6.k(r0)
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r1
            long r2 = (long) r2
            int[] r4 = r6.f1570a
            r4 = r4[r0]
            int r1 = j(r1)
            switch(r1) {
                case 0: goto L_0x00e1;
                case 1: goto L_0x00d3;
                case 2: goto L_0x00c5;
                case 3: goto L_0x00be;
                case 4: goto L_0x00b0;
                case 5: goto L_0x00a9;
                case 6: goto L_0x00a2;
                case 7: goto L_0x0094;
                case 8: goto L_0x0086;
                case 9: goto L_0x0081;
                case 10: goto L_0x007a;
                case 11: goto L_0x0073;
                case 12: goto L_0x006c;
                case 13: goto L_0x0065;
                case 14: goto L_0x005d;
                case 15: goto L_0x0056;
                case 16: goto L_0x004e;
                case 17: goto L_0x0081;
                case 18: goto L_0x0047;
                case 19: goto L_0x0047;
                case 20: goto L_0x0047;
                case 21: goto L_0x0047;
                case 22: goto L_0x0047;
                case 23: goto L_0x0047;
                case 24: goto L_0x0047;
                case 25: goto L_0x0047;
                case 26: goto L_0x0047;
                case 27: goto L_0x0047;
                case 28: goto L_0x0047;
                case 29: goto L_0x0047;
                case 30: goto L_0x0047;
                case 31: goto L_0x0047;
                case 32: goto L_0x0047;
                case 33: goto L_0x0047;
                case 34: goto L_0x0047;
                case 35: goto L_0x0047;
                case 36: goto L_0x0047;
                case 37: goto L_0x0047;
                case 38: goto L_0x0047;
                case 39: goto L_0x0047;
                case 40: goto L_0x0047;
                case 41: goto L_0x0047;
                case 42: goto L_0x0047;
                case 43: goto L_0x0047;
                case 44: goto L_0x0047;
                case 45: goto L_0x0047;
                case 46: goto L_0x0047;
                case 47: goto L_0x0047;
                case 48: goto L_0x0047;
                case 49: goto L_0x0047;
                case 50: goto L_0x0040;
                case 51: goto L_0x002e;
                case 52: goto L_0x002e;
                case 53: goto L_0x002e;
                case 54: goto L_0x002e;
                case 55: goto L_0x002e;
                case 56: goto L_0x002e;
                case 57: goto L_0x002e;
                case 58: goto L_0x002e;
                case 59: goto L_0x002e;
                case 60: goto L_0x0029;
                case 61: goto L_0x0022;
                case 62: goto L_0x0022;
                case 63: goto L_0x0022;
                case 64: goto L_0x0022;
                case 65: goto L_0x0022;
                case 66: goto L_0x0022;
                case 67: goto L_0x0022;
                case 68: goto L_0x0029;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x00f1
        L_0x0022:
            boolean r1 = r6.G(r8, r4, r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0034
        L_0x0029:
            r6.u(r7, r8, r0)
            goto L_0x00f1
        L_0x002e:
            boolean r1 = r6.G(r8, r4, r0)
            if (r1 == 0) goto L_0x00f1
        L_0x0034:
            java.lang.Object r1 = c.d.a.b.e.e.kb.k(r8, r2)
            c.d.a.b.e.e.kb.x(r7, r2, r1)
            r6.w(r7, r4, r0)
            goto L_0x00f1
        L_0x0040:
            c.d.a.b.e.e.s9 r1 = r6.n
            c.d.a.b.e.e.ka.B(r1, r7, r8, r2)
            goto L_0x00f1
        L_0x0047:
            c.d.a.b.e.e.l9 r1 = r6.k
            r1.b(r7, r8, r2)
            goto L_0x00f1
        L_0x004e:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x00cb
        L_0x0056:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0072
        L_0x005d:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x00cb
        L_0x0065:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x0072
        L_0x006c:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
        L_0x0072:
            goto L_0x00b6
        L_0x0073:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x00b6
        L_0x007a:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x008c
        L_0x0081:
            r6.t(r7, r8, r0)
            goto L_0x00f1
        L_0x0086:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
        L_0x008c:
            java.lang.Object r1 = c.d.a.b.e.e.kb.k(r8, r2)
            c.d.a.b.e.e.kb.x(r7, r2, r1)
            goto L_0x00ee
        L_0x0094:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
            boolean r1 = c.d.a.b.e.e.kb.B(r8, r2)
            c.d.a.b.e.e.kb.r(r7, r2, r1)
            goto L_0x00ee
        L_0x00a2:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x00b6
        L_0x00a9:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x00cb
        L_0x00b0:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
        L_0x00b6:
            int r1 = c.d.a.b.e.e.kb.h(r8, r2)
            c.d.a.b.e.e.kb.v(r7, r2, r1)
            goto L_0x00ee
        L_0x00be:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
            goto L_0x00cb
        L_0x00c5:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
        L_0x00cb:
            long r4 = c.d.a.b.e.e.kb.i(r8, r2)
            c.d.a.b.e.e.kb.w(r7, r2, r4)
            goto L_0x00ee
        L_0x00d3:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
            float r1 = c.d.a.b.e.e.kb.g(r8, r2)
            c.d.a.b.e.e.kb.u(r7, r2, r1)
            goto L_0x00ee
        L_0x00e1:
            boolean r1 = r6.C(r8, r0)
            if (r1 == 0) goto L_0x00f1
            double r4 = c.d.a.b.e.e.kb.f(r8, r2)
            c.d.a.b.e.e.kb.t(r7, r2, r4)
        L_0x00ee:
            r6.v(r7, r0)
        L_0x00f1:
            int r0 = r0 + 3
            goto L_0x0007
        L_0x00f5:
            c.d.a.b.e.e.ab r0 = r6.l
            c.d.a.b.e.e.ka.f(r0, r7, r8)
            boolean r0 = r6.f1575f
            if (r0 != 0) goto L_0x00ff
            return
        L_0x00ff:
            c.d.a.b.e.e.f8 r0 = r6.m
            c.d.a.b.e.e.ka.e(r0, r7, r8)
            r7 = 0
            goto L_0x0107
        L_0x0106:
            throw r7
        L_0x0107:
            goto L_0x0106
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.aa.c(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b6, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(java.lang.Object r9, java.lang.Object r10) {
        /*
            r8 = this;
            int[] r0 = r8.f1570a
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r2 >= r0) goto L_0x01ba
            int r3 = r8.k(r2)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r3 & r4
            long r5 = (long) r5
            int r3 = j(r3)
            switch(r3) {
                case 0: goto L_0x019a;
                case 1: goto L_0x0181;
                case 2: goto L_0x016e;
                case 3: goto L_0x015b;
                case 4: goto L_0x014a;
                case 5: goto L_0x0136;
                case 6: goto L_0x0124;
                case 7: goto L_0x0112;
                case 8: goto L_0x00fc;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00d0;
                case 11: goto L_0x00be;
                case 12: goto L_0x00ac;
                case 13: goto L_0x009a;
                case 14: goto L_0x0086;
                case 15: goto L_0x0074;
                case 16: goto L_0x0060;
                case 17: goto L_0x004a;
                case 18: goto L_0x003a;
                case 19: goto L_0x003a;
                case 20: goto L_0x003a;
                case 21: goto L_0x003a;
                case 22: goto L_0x003a;
                case 23: goto L_0x003a;
                case 24: goto L_0x003a;
                case 25: goto L_0x003a;
                case 26: goto L_0x003a;
                case 27: goto L_0x003a;
                case 28: goto L_0x003a;
                case 29: goto L_0x003a;
                case 30: goto L_0x003a;
                case 31: goto L_0x003a;
                case 32: goto L_0x003a;
                case 33: goto L_0x003a;
                case 34: goto L_0x003a;
                case 35: goto L_0x003a;
                case 36: goto L_0x003a;
                case 37: goto L_0x003a;
                case 38: goto L_0x003a;
                case 39: goto L_0x003a;
                case 40: goto L_0x003a;
                case 41: goto L_0x003a;
                case 42: goto L_0x003a;
                case 43: goto L_0x003a;
                case 44: goto L_0x003a;
                case 45: goto L_0x003a;
                case 46: goto L_0x003a;
                case 47: goto L_0x003a;
                case 48: goto L_0x003a;
                case 49: goto L_0x003a;
                case 50: goto L_0x003a;
                case 51: goto L_0x001a;
                case 52: goto L_0x001a;
                case 53: goto L_0x001a;
                case 54: goto L_0x001a;
                case 55: goto L_0x001a;
                case 56: goto L_0x001a;
                case 57: goto L_0x001a;
                case 58: goto L_0x001a;
                case 59: goto L_0x001a;
                case 60: goto L_0x001a;
                case 61: goto L_0x001a;
                case 62: goto L_0x001a;
                case 63: goto L_0x001a;
                case 64: goto L_0x001a;
                case 65: goto L_0x001a;
                case 66: goto L_0x001a;
                case 67: goto L_0x001a;
                case 68: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x01b6
        L_0x001a:
            int r3 = r8.Y(r2)
            r3 = r3 & r4
            long r3 = (long) r3
            int r7 = c.d.a.b.e.e.kb.h(r9, r3)
            int r3 = c.d.a.b.e.e.kb.h(r10, r3)
            if (r7 != r3) goto L_0x01b5
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r9, r5)
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r10, r5)
            boolean r3 = c.d.a.b.e.e.ka.z(r3, r4)
            if (r3 != 0) goto L_0x01b6
            goto L_0x01b5
        L_0x003a:
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r9, r5)
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r10, r5)
            boolean r3 = c.d.a.b.e.e.ka.z(r3, r4)
            if (r3 != 0) goto L_0x01b6
            goto L_0x01b5
        L_0x004a:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r9, r5)
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r10, r5)
            boolean r3 = c.d.a.b.e.e.ka.z(r3, r4)
            if (r3 == 0) goto L_0x01b5
            goto L_0x01b6
        L_0x0060:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            long r3 = c.d.a.b.e.e.kb.i(r9, r5)
            long r5 = c.d.a.b.e.e.kb.i(r10, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x0074:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            int r3 = c.d.a.b.e.e.kb.h(r9, r5)
            int r4 = c.d.a.b.e.e.kb.h(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x0086:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            long r3 = c.d.a.b.e.e.kb.i(r9, r5)
            long r5 = c.d.a.b.e.e.kb.i(r10, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x009a:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            int r3 = c.d.a.b.e.e.kb.h(r9, r5)
            int r4 = c.d.a.b.e.e.kb.h(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x00ac:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            int r3 = c.d.a.b.e.e.kb.h(r9, r5)
            int r4 = c.d.a.b.e.e.kb.h(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x00be:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            int r3 = c.d.a.b.e.e.kb.h(r9, r5)
            int r4 = c.d.a.b.e.e.kb.h(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x00d0:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r9, r5)
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r10, r5)
            boolean r3 = c.d.a.b.e.e.ka.z(r3, r4)
            if (r3 == 0) goto L_0x01b5
            goto L_0x01b6
        L_0x00e6:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r9, r5)
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r10, r5)
            boolean r3 = c.d.a.b.e.e.ka.z(r3, r4)
            if (r3 == 0) goto L_0x01b5
            goto L_0x01b6
        L_0x00fc:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r9, r5)
            java.lang.Object r4 = c.d.a.b.e.e.kb.k(r10, r5)
            boolean r3 = c.d.a.b.e.e.ka.z(r3, r4)
            if (r3 == 0) goto L_0x01b5
            goto L_0x01b6
        L_0x0112:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            boolean r3 = c.d.a.b.e.e.kb.B(r9, r5)
            boolean r4 = c.d.a.b.e.e.kb.B(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x0124:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            int r3 = c.d.a.b.e.e.kb.h(r9, r5)
            int r4 = c.d.a.b.e.e.kb.h(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x0136:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            long r3 = c.d.a.b.e.e.kb.i(r9, r5)
            long r5 = c.d.a.b.e.e.kb.i(r10, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x014a:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            int r3 = c.d.a.b.e.e.kb.h(r9, r5)
            int r4 = c.d.a.b.e.e.kb.h(r10, r5)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x015b:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            long r3 = c.d.a.b.e.e.kb.i(r9, r5)
            long r5 = c.d.a.b.e.e.kb.i(r10, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x016e:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            long r3 = c.d.a.b.e.e.kb.i(r9, r5)
            long r5 = c.d.a.b.e.e.kb.i(r10, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x0181:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            float r3 = c.d.a.b.e.e.kb.g(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            float r4 = c.d.a.b.e.e.kb.g(r10, r5)
            int r4 = java.lang.Float.floatToIntBits(r4)
            if (r3 != r4) goto L_0x01b5
            goto L_0x01b6
        L_0x019a:
            boolean r3 = r8.B(r9, r10, r2)
            if (r3 == 0) goto L_0x01b5
            double r3 = c.d.a.b.e.e.kb.f(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            double r5 = c.d.a.b.e.e.kb.f(r10, r5)
            long r5 = java.lang.Double.doubleToLongBits(r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01b5
            goto L_0x01b6
        L_0x01b5:
            return r1
        L_0x01b6:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01ba:
            c.d.a.b.e.e.ab r0 = r8.l
            java.lang.Object r0 = r0.d(r9)
            c.d.a.b.e.e.ab r2 = r8.l
            java.lang.Object r2 = r2.d(r10)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01cd
            return r1
        L_0x01cd:
            boolean r0 = r8.f1575f
            if (r0 != 0) goto L_0x01d3
            r9 = 1
            return r9
        L_0x01d3:
            c.d.a.b.e.e.f8 r0 = r8.m
            r0.a(r9)
            c.d.a.b.e.e.f8 r9 = r8.m
            r9.a(r10)
            r9 = 0
            goto L_0x01e0
        L_0x01df:
            throw r9
        L_0x01e0:
            goto L_0x01df
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.aa.d(java.lang.Object, java.lang.Object):boolean");
    }

    public final Object e() {
        return ((s8) this.f1574e).m();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02ed, code lost:
        r11.E(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02fe, code lost:
        r11.c(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x030f, code lost:
        r11.o(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0320, code lost:
        r11.z(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0331, code lost:
        r11.g(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x033c, code lost:
        r11.s(r4, (c.d.a.b.e.e.r7) c.d.a.b.e.e.kb.k(r10, (long) (r3 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x034f, code lost:
        r11.x(r4, c.d.a.b.e.e.kb.k(r10, (long) (r3 & 1048575)), n(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0364, code lost:
        I(r4, c.d.a.b.e.e.kb.k(r10, (long) (r3 & 1048575)), r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x037b, code lost:
        r11.C(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x038c, code lost:
        r11.A(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x039c, code lost:
        r11.v(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x03ac, code lost:
        r11.J(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x03bc, code lost:
        r11.i(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x03cc, code lost:
        r11.I(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03dc, code lost:
        r11.r(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03ec, code lost:
        r11.f(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02c1, code lost:
        r11.l(r4, c.d.a.b.e.e.kb.k(r10, (long) (r3 & 1048575)), n(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02dc, code lost:
        r11.G(r4, r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(java.lang.Object r10, c.d.a.b.e.e.tb r11) {
        /*
            r9 = this;
            boolean r0 = r9.g
            if (r0 == 0) goto L_0x0404
            boolean r0 = r9.f1575f
            if (r0 != 0) goto L_0x03fd
            int[] r0 = r9.f1570a
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x000d:
            if (r2 >= r0) goto L_0x03f3
            int r3 = r9.k(r2)
            int[] r4 = r9.f1570a
            r4 = r4[r2]
            int r5 = j(r3)
            r6 = 1
            r7 = 1048575(0xfffff, float:1.469367E-39)
            switch(r5) {
                case 0: goto L_0x03e0;
                case 1: goto L_0x03d0;
                case 2: goto L_0x03c0;
                case 3: goto L_0x03b0;
                case 4: goto L_0x03a0;
                case 5: goto L_0x0390;
                case 6: goto L_0x0380;
                case 7: goto L_0x036f;
                case 8: goto L_0x035e;
                case 9: goto L_0x0349;
                case 10: goto L_0x0336;
                case 11: goto L_0x0325;
                case 12: goto L_0x0314;
                case 13: goto L_0x0303;
                case 14: goto L_0x02f2;
                case 15: goto L_0x02e1;
                case 16: goto L_0x02d0;
                case 17: goto L_0x02bb;
                case 18: goto L_0x02ae;
                case 19: goto L_0x02a1;
                case 20: goto L_0x0294;
                case 21: goto L_0x0287;
                case 22: goto L_0x027a;
                case 23: goto L_0x026d;
                case 24: goto L_0x0260;
                case 25: goto L_0x0253;
                case 26: goto L_0x0246;
                case 27: goto L_0x0235;
                case 28: goto L_0x0228;
                case 29: goto L_0x021b;
                case 30: goto L_0x020e;
                case 31: goto L_0x0201;
                case 32: goto L_0x01f4;
                case 33: goto L_0x01e7;
                case 34: goto L_0x01da;
                case 35: goto L_0x01cd;
                case 36: goto L_0x01c0;
                case 37: goto L_0x01b3;
                case 38: goto L_0x01a6;
                case 39: goto L_0x0199;
                case 40: goto L_0x018c;
                case 41: goto L_0x017f;
                case 42: goto L_0x0172;
                case 43: goto L_0x0165;
                case 44: goto L_0x0158;
                case 45: goto L_0x014b;
                case 46: goto L_0x013e;
                case 47: goto L_0x0131;
                case 48: goto L_0x0124;
                case 49: goto L_0x0113;
                case 50: goto L_0x0108;
                case 51: goto L_0x00fa;
                case 52: goto L_0x00ec;
                case 53: goto L_0x00de;
                case 54: goto L_0x00d0;
                case 55: goto L_0x00c2;
                case 56: goto L_0x00b4;
                case 57: goto L_0x00a6;
                case 58: goto L_0x0098;
                case 59: goto L_0x0090;
                case 60: goto L_0x0088;
                case 61: goto L_0x0080;
                case 62: goto L_0x0072;
                case 63: goto L_0x0064;
                case 64: goto L_0x0056;
                case 65: goto L_0x0048;
                case 66: goto L_0x003a;
                case 67: goto L_0x002c;
                case 68: goto L_0x0024;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x03ef
        L_0x0024:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            goto L_0x02c1
        L_0x002c:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            long r5 = l(r10, r5)
            goto L_0x02dc
        L_0x003a:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            int r3 = R(r10, r5)
            goto L_0x02ed
        L_0x0048:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            long r5 = l(r10, r5)
            goto L_0x02fe
        L_0x0056:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            int r3 = R(r10, r5)
            goto L_0x030f
        L_0x0064:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            int r3 = R(r10, r5)
            goto L_0x0320
        L_0x0072:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            int r3 = R(r10, r5)
            goto L_0x0331
        L_0x0080:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            goto L_0x033c
        L_0x0088:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            goto L_0x034f
        L_0x0090:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            goto L_0x0364
        L_0x0098:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            boolean r3 = H(r10, r5)
            goto L_0x037b
        L_0x00a6:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            int r3 = R(r10, r5)
            goto L_0x038c
        L_0x00b4:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            long r5 = l(r10, r5)
            goto L_0x039c
        L_0x00c2:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            int r3 = R(r10, r5)
            goto L_0x03ac
        L_0x00d0:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            long r5 = l(r10, r5)
            goto L_0x03bc
        L_0x00de:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            long r5 = l(r10, r5)
            goto L_0x03cc
        L_0x00ec:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            float r3 = O(r10, r5)
            goto L_0x03dc
        L_0x00fa:
            boolean r5 = r9.G(r10, r4, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            double r5 = N(r10, r5)
            goto L_0x03ec
        L_0x0108:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            r9.A(r11, r4, r3, r2)
            goto L_0x03ef
        L_0x0113:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ia r5 = r9.n(r2)
            c.d.a.b.e.e.ka.o(r4, r3, r11, r5)
            goto L_0x03ef
        L_0x0124:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.v(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x0131:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.u(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x013e:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.t(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x014b:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.s(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x0158:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.k(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x0165:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.x(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x0172:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.h(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x017f:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.l(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x018c:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.m(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x0199:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.p(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x01a6:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.y(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x01b3:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.q(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x01c0:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.n(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x01cd:
            r3 = r3 & r7
            long r7 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r7)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.j(r4, r3, r11, r6)
            goto L_0x03ef
        L_0x01da:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.v(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x01e7:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.u(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x01f4:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.t(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x0201:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.s(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x020e:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.k(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x021b:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.x(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x0228:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.i(r4, r3, r11)
            goto L_0x03ef
        L_0x0235:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ia r5 = r9.n(r2)
            c.d.a.b.e.e.ka.r(r4, r3, r11, r5)
            goto L_0x03ef
        L_0x0246:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.w(r4, r3, r11)
            goto L_0x03ef
        L_0x0253:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.h(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x0260:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.l(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x026d:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.m(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x027a:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.p(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x0287:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.y(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x0294:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.q(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x02a1:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.n(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x02ae:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            java.util.List r3 = (java.util.List) r3
            c.d.a.b.e.e.ka.j(r4, r3, r11, r1)
            goto L_0x03ef
        L_0x02bb:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
        L_0x02c1:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            c.d.a.b.e.e.ia r5 = r9.n(r2)
            r11.l(r4, r3, r5)
            goto L_0x03ef
        L_0x02d0:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            long r5 = c.d.a.b.e.e.kb.i(r10, r5)
        L_0x02dc:
            r11.G(r4, r5)
            goto L_0x03ef
        L_0x02e1:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            int r3 = c.d.a.b.e.e.kb.h(r10, r5)
        L_0x02ed:
            r11.E(r4, r3)
            goto L_0x03ef
        L_0x02f2:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            long r5 = c.d.a.b.e.e.kb.i(r10, r5)
        L_0x02fe:
            r11.c(r4, r5)
            goto L_0x03ef
        L_0x0303:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            int r3 = c.d.a.b.e.e.kb.h(r10, r5)
        L_0x030f:
            r11.o(r4, r3)
            goto L_0x03ef
        L_0x0314:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            int r3 = c.d.a.b.e.e.kb.h(r10, r5)
        L_0x0320:
            r11.z(r4, r3)
            goto L_0x03ef
        L_0x0325:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            int r3 = c.d.a.b.e.e.kb.h(r10, r5)
        L_0x0331:
            r11.g(r4, r3)
            goto L_0x03ef
        L_0x0336:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
        L_0x033c:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            c.d.a.b.e.e.r7 r3 = (c.d.a.b.e.e.r7) r3
            r11.s(r4, r3)
            goto L_0x03ef
        L_0x0349:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
        L_0x034f:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            c.d.a.b.e.e.ia r5 = r9.n(r2)
            r11.x(r4, r3, r5)
            goto L_0x03ef
        L_0x035e:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
        L_0x0364:
            r3 = r3 & r7
            long r5 = (long) r3
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r10, r5)
            I(r4, r3, r11)
            goto L_0x03ef
        L_0x036f:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            boolean r3 = c.d.a.b.e.e.kb.B(r10, r5)
        L_0x037b:
            r11.C(r4, r3)
            goto L_0x03ef
        L_0x0380:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            int r3 = c.d.a.b.e.e.kb.h(r10, r5)
        L_0x038c:
            r11.A(r4, r3)
            goto L_0x03ef
        L_0x0390:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            long r5 = c.d.a.b.e.e.kb.i(r10, r5)
        L_0x039c:
            r11.v(r4, r5)
            goto L_0x03ef
        L_0x03a0:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            int r3 = c.d.a.b.e.e.kb.h(r10, r5)
        L_0x03ac:
            r11.J(r4, r3)
            goto L_0x03ef
        L_0x03b0:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            long r5 = c.d.a.b.e.e.kb.i(r10, r5)
        L_0x03bc:
            r11.i(r4, r5)
            goto L_0x03ef
        L_0x03c0:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            long r5 = c.d.a.b.e.e.kb.i(r10, r5)
        L_0x03cc:
            r11.I(r4, r5)
            goto L_0x03ef
        L_0x03d0:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            float r3 = c.d.a.b.e.e.kb.g(r10, r5)
        L_0x03dc:
            r11.r(r4, r3)
            goto L_0x03ef
        L_0x03e0:
            boolean r5 = r9.C(r10, r2)
            if (r5 == 0) goto L_0x03ef
            r3 = r3 & r7
            long r5 = (long) r3
            double r5 = c.d.a.b.e.e.kb.f(r10, r5)
        L_0x03ec:
            r11.f(r4, r5)
        L_0x03ef:
            int r2 = r2 + 3
            goto L_0x000d
        L_0x03f3:
            c.d.a.b.e.e.ab r0 = r9.l
            java.lang.Object r10 = r0.d(r10)
            r0.i(r10, r11)
            return
        L_0x03fd:
            c.d.a.b.e.e.f8 r11 = r9.m
            r11.a(r10)
            r10 = 0
            throw r10
        L_0x0404:
            r9.z(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.aa.f(java.lang.Object, c.d.a.b.e.e.tb):void");
    }

    public final boolean g(Object obj) {
        int i2;
        int i3;
        Object obj2 = obj;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.i) {
            int i7 = this.h[i6];
            int i8 = this.f1570a[i7];
            int k2 = k(i7);
            int i9 = this.f1570a[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = p.getInt(obj2, (long) i10);
                }
                i2 = i5;
                i3 = i10;
            } else {
                i3 = i4;
                i2 = i5;
            }
            if ((268435456 & k2) != 0 && !D(obj, i7, i3, i2, i11)) {
                return false;
            }
            int j2 = j(k2);
            if (j2 != 9 && j2 != 17) {
                if (j2 != 27) {
                    if (j2 == 60 || j2 == 68) {
                        if (G(obj2, i8, i7) && !E(obj2, k2, n(i7))) {
                            return false;
                        }
                    } else if (j2 != 49) {
                        if (j2 == 50 && !((r9) kb.k(obj2, (long) (k2 & 1048575))).isEmpty()) {
                            q9 q9Var = (q9) o(i7);
                            throw null;
                        }
                    }
                }
                List list = (List) kb.k(obj2, (long) (k2 & 1048575));
                if (!list.isEmpty()) {
                    ia n2 = n(i7);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        if (!n2.g(list.get(i12))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (D(obj, i7, i3, i2, i11) && !E(obj2, k2, n(i7))) {
                return false;
            }
            i6++;
            i4 = i3;
            i5 = i2;
        }
        if (!this.f1575f) {
            return true;
        }
        this.m.a(obj2);
        throw null;
    }

    public final void h(Object obj, byte[] bArr, int i2, int i3, g7 g7Var) {
        if (this.g) {
            U(obj, bArr, i2, i3, g7Var);
        } else {
            J(obj, bArr, i2, i3, 0, g7Var);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008d, code lost:
        r2 = r2 * 53;
        r3 = R(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a2, code lost:
        r2 = r2 * 53;
        r3 = l(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
        if (r3 != null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cb, code lost:
        r2 = r2 * 53;
        r3 = c.d.a.b.e.e.kb.k(r9, r5).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00da, code lost:
        if (r3 != null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00dc, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e4, code lost:
        r2 = r2 * 53;
        r3 = ((java.lang.String) c.d.a.b.e.e.kb.k(r9, r5)).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f7, code lost:
        r3 = c.d.a.b.e.e.y8.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0110, code lost:
        r3 = java.lang.Float.floatToIntBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x011b, code lost:
        r3 = java.lang.Double.doubleToLongBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x011f, code lost:
        r3 = c.d.a.b.e.e.y8.c(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0123, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0124, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int i(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.f1570a
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x0128
            int r3 = r8.k(r1)
            int[] r4 = r8.f1570a
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = j(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0115;
                case 1: goto L_0x010a;
                case 2: goto L_0x0103;
                case 3: goto L_0x0103;
                case 4: goto L_0x00fc;
                case 5: goto L_0x0103;
                case 6: goto L_0x00fc;
                case 7: goto L_0x00f1;
                case 8: goto L_0x00e4;
                case 9: goto L_0x00d6;
                case 10: goto L_0x00cb;
                case 11: goto L_0x00fc;
                case 12: goto L_0x00fc;
                case 13: goto L_0x00fc;
                case 14: goto L_0x0103;
                case 15: goto L_0x00fc;
                case 16: goto L_0x0103;
                case 17: goto L_0x00c4;
                case 18: goto L_0x00cb;
                case 19: goto L_0x00cb;
                case 20: goto L_0x00cb;
                case 21: goto L_0x00cb;
                case 22: goto L_0x00cb;
                case 23: goto L_0x00cb;
                case 24: goto L_0x00cb;
                case 25: goto L_0x00cb;
                case 26: goto L_0x00cb;
                case 27: goto L_0x00cb;
                case 28: goto L_0x00cb;
                case 29: goto L_0x00cb;
                case 30: goto L_0x00cb;
                case 31: goto L_0x00cb;
                case 32: goto L_0x00cb;
                case 33: goto L_0x00cb;
                case 34: goto L_0x00cb;
                case 35: goto L_0x00cb;
                case 36: goto L_0x00cb;
                case 37: goto L_0x00cb;
                case 38: goto L_0x00cb;
                case 39: goto L_0x00cb;
                case 40: goto L_0x00cb;
                case 41: goto L_0x00cb;
                case 42: goto L_0x00cb;
                case 43: goto L_0x00cb;
                case 44: goto L_0x00cb;
                case 45: goto L_0x00cb;
                case 46: goto L_0x00cb;
                case 47: goto L_0x00cb;
                case 48: goto L_0x00cb;
                case 49: goto L_0x00cb;
                case 50: goto L_0x00cb;
                case 51: goto L_0x00b7;
                case 52: goto L_0x00aa;
                case 53: goto L_0x009c;
                case 54: goto L_0x0095;
                case 55: goto L_0x0087;
                case 56: goto L_0x0080;
                case 57: goto L_0x0079;
                case 58: goto L_0x006b;
                case 59: goto L_0x0063;
                case 60: goto L_0x005b;
                case 61: goto L_0x0053;
                case 62: goto L_0x004c;
                case 63: goto L_0x0045;
                case 64: goto L_0x003e;
                case 65: goto L_0x0036;
                case 66: goto L_0x002f;
                case 67: goto L_0x0027;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0124
        L_0x001f:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00cb
        L_0x0027:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00a2
        L_0x002f:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x004b
        L_0x0036:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00a2
        L_0x003e:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x004b
        L_0x0045:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
        L_0x004b:
            goto L_0x008d
        L_0x004c:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x008d
        L_0x0053:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00cb
        L_0x005b:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00cb
        L_0x0063:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00e4
        L_0x006b:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            int r2 = r2 * 53
            boolean r3 = H(r9, r5)
            goto L_0x00f7
        L_0x0079:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x008d
        L_0x0080:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00a2
        L_0x0087:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
        L_0x008d:
            int r2 = r2 * 53
            int r3 = R(r9, r5)
            goto L_0x0123
        L_0x0095:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            goto L_0x00a2
        L_0x009c:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
        L_0x00a2:
            int r2 = r2 * 53
            long r3 = l(r9, r5)
            goto L_0x011f
        L_0x00aa:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            int r2 = r2 * 53
            float r3 = O(r9, r5)
            goto L_0x0110
        L_0x00b7:
            boolean r3 = r8.G(r9, r4, r1)
            if (r3 == 0) goto L_0x0124
            int r2 = r2 * 53
            double r3 = N(r9, r5)
            goto L_0x011b
        L_0x00c4:
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r9, r5)
            if (r3 == 0) goto L_0x00e0
            goto L_0x00dc
        L_0x00cb:
            int r2 = r2 * 53
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0123
        L_0x00d6:
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r9, r5)
            if (r3 == 0) goto L_0x00e0
        L_0x00dc:
            int r7 = r3.hashCode()
        L_0x00e0:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0124
        L_0x00e4:
            int r2 = r2 * 53
            java.lang.Object r3 = c.d.a.b.e.e.kb.k(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0123
        L_0x00f1:
            int r2 = r2 * 53
            boolean r3 = c.d.a.b.e.e.kb.B(r9, r5)
        L_0x00f7:
            int r3 = c.d.a.b.e.e.y8.a(r3)
            goto L_0x0123
        L_0x00fc:
            int r2 = r2 * 53
            int r3 = c.d.a.b.e.e.kb.h(r9, r5)
            goto L_0x0123
        L_0x0103:
            int r2 = r2 * 53
            long r3 = c.d.a.b.e.e.kb.i(r9, r5)
            goto L_0x011f
        L_0x010a:
            int r2 = r2 * 53
            float r3 = c.d.a.b.e.e.kb.g(r9, r5)
        L_0x0110:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0123
        L_0x0115:
            int r2 = r2 * 53
            double r3 = c.d.a.b.e.e.kb.f(r9, r5)
        L_0x011b:
            long r3 = java.lang.Double.doubleToLongBits(r3)
        L_0x011f:
            int r3 = c.d.a.b.e.e.y8.c(r3)
        L_0x0123:
            int r2 = r2 + r3
        L_0x0124:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0128:
            int r2 = r2 * 53
            c.d.a.b.e.e.ab r0 = r8.l
            java.lang.Object r0 = r0.d(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f1575f
            if (r0 != 0) goto L_0x013a
            return r2
        L_0x013a:
            c.d.a.b.e.e.f8 r0 = r8.m
            r0.a(r9)
            r9 = 0
            goto L_0x0142
        L_0x0141:
            throw r9
        L_0x0142:
            goto L_0x0141
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.aa.i(java.lang.Object):int");
    }
}
