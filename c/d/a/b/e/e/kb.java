package c.d.a.b.e.e;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

final class kb {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f1671a;

    /* renamed from: b  reason: collision with root package name */
    private static final Class f1672b = f7.a();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f1673c;

    /* renamed from: d  reason: collision with root package name */
    private static final jb f1674d;

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f1675e;

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f1676f;
    static final long g = ((long) E(byte[].class));
    static final boolean h;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0132  */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            java.lang.Class<double[]> r1 = double[].class
            java.lang.Class<float[]> r2 = float[].class
            java.lang.Class<long[]> r3 = long[].class
            java.lang.Class<int[]> r4 = int[].class
            java.lang.Class<boolean[]> r5 = boolean[].class
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            sun.misc.Unsafe r7 = l()
            f1671a = r7
            java.lang.Class r8 = c.d.a.b.e.e.f7.a()
            f1672b = r8
            java.lang.Class r8 = java.lang.Long.TYPE
            boolean r9 = A(r8)
            f1673c = r9
            java.lang.Class r10 = java.lang.Integer.TYPE
            boolean r10 = A(r10)
            r11 = 0
            if (r7 != 0) goto L_0x002c
            goto L_0x003b
        L_0x002c:
            if (r9 == 0) goto L_0x0034
            c.d.a.b.e.e.ib r11 = new c.d.a.b.e.e.ib
            r11.<init>(r7)
            goto L_0x003b
        L_0x0034:
            if (r10 == 0) goto L_0x003b
            c.d.a.b.e.e.hb r11 = new c.d.a.b.e.e.hb
            r11.<init>(r7)
        L_0x003b:
            f1674d = r11
            java.lang.String r7 = "getLong"
            java.lang.String r9 = "objectFieldOffset"
            r10 = 2
            r12 = 1
            r13 = 0
            if (r11 != 0) goto L_0x0048
        L_0x0046:
            r8 = 0
            goto L_0x006e
        L_0x0048:
            sun.misc.Unsafe r11 = r11.f1666a
            java.lang.Class r11 = r11.getClass()     // Catch:{ all -> 0x0069 }
            java.lang.Class[] r14 = new java.lang.Class[r12]     // Catch:{ all -> 0x0069 }
            java.lang.Class<java.lang.reflect.Field> r15 = java.lang.reflect.Field.class
            r14[r13] = r15     // Catch:{ all -> 0x0069 }
            r11.getMethod(r9, r14)     // Catch:{ all -> 0x0069 }
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x0069 }
            r14[r13] = r6     // Catch:{ all -> 0x0069 }
            r14[r12] = r8     // Catch:{ all -> 0x0069 }
            r11.getMethod(r7, r14)     // Catch:{ all -> 0x0069 }
            java.lang.reflect.Field r8 = b()     // Catch:{ all -> 0x0069 }
            if (r8 != 0) goto L_0x0067
            goto L_0x0046
        L_0x0067:
            r8 = 1
            goto L_0x006e
        L_0x0069:
            r8 = move-exception
            java.util.logging.Logger.getLogger(c.d.a.b.e.e.kb.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r8.toString()))
            goto L_0x0046
        L_0x006e:
            f1675e = r8
            c.d.a.b.e.e.jb r8 = f1674d
            if (r8 != 0) goto L_0x0076
        L_0x0074:
            r6 = 0
            goto L_0x00ed
        L_0x0076:
            sun.misc.Unsafe r8 = r8.f1666a
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x00e8 }
            java.lang.Class[] r11 = new java.lang.Class[r12]     // Catch:{ all -> 0x00e8 }
            java.lang.Class<java.lang.reflect.Field> r14 = java.lang.reflect.Field.class
            r11[r13] = r14     // Catch:{ all -> 0x00e8 }
            r8.getMethod(r9, r11)     // Catch:{ all -> 0x00e8 }
            java.lang.Class[] r9 = new java.lang.Class[r12]     // Catch:{ all -> 0x00e8 }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r9[r13] = r11     // Catch:{ all -> 0x00e8 }
            java.lang.String r11 = "arrayBaseOffset"
            r8.getMethod(r11, r9)     // Catch:{ all -> 0x00e8 }
            java.lang.Class[] r9 = new java.lang.Class[r12]     // Catch:{ all -> 0x00e8 }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r9[r13] = r11     // Catch:{ all -> 0x00e8 }
            java.lang.String r11 = "arrayIndexScale"
            r8.getMethod(r11, r9)     // Catch:{ all -> 0x00e8 }
            java.lang.Class[] r9 = new java.lang.Class[r10]     // Catch:{ all -> 0x00e8 }
            r9[r13] = r6     // Catch:{ all -> 0x00e8 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x00e8 }
            r9[r12] = r11     // Catch:{ all -> 0x00e8 }
            java.lang.String r14 = "getInt"
            r8.getMethod(r14, r9)     // Catch:{ all -> 0x00e8 }
            r9 = 3
            java.lang.Class[] r14 = new java.lang.Class[r9]     // Catch:{ all -> 0x00e8 }
            r14[r13] = r6     // Catch:{ all -> 0x00e8 }
            r14[r12] = r11     // Catch:{ all -> 0x00e8 }
            java.lang.Class r15 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00e8 }
            r14[r10] = r15     // Catch:{ all -> 0x00e8 }
            java.lang.String r15 = "putInt"
            r8.getMethod(r15, r14)     // Catch:{ all -> 0x00e8 }
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x00e8 }
            r14[r13] = r6     // Catch:{ all -> 0x00e8 }
            r14[r12] = r11     // Catch:{ all -> 0x00e8 }
            r8.getMethod(r7, r14)     // Catch:{ all -> 0x00e8 }
            java.lang.Class[] r7 = new java.lang.Class[r9]     // Catch:{ all -> 0x00e8 }
            r7[r13] = r6     // Catch:{ all -> 0x00e8 }
            r7[r12] = r11     // Catch:{ all -> 0x00e8 }
            r7[r10] = r11     // Catch:{ all -> 0x00e8 }
            java.lang.String r14 = "putLong"
            r8.getMethod(r14, r7)     // Catch:{ all -> 0x00e8 }
            java.lang.Class[] r7 = new java.lang.Class[r10]     // Catch:{ all -> 0x00e8 }
            r7[r13] = r6     // Catch:{ all -> 0x00e8 }
            r7[r12] = r11     // Catch:{ all -> 0x00e8 }
            java.lang.String r14 = "getObject"
            r8.getMethod(r14, r7)     // Catch:{ all -> 0x00e8 }
            java.lang.Class[] r7 = new java.lang.Class[r9]     // Catch:{ all -> 0x00e8 }
            r7[r13] = r6     // Catch:{ all -> 0x00e8 }
            r7[r12] = r11     // Catch:{ all -> 0x00e8 }
            r7[r10] = r6     // Catch:{ all -> 0x00e8 }
            java.lang.String r6 = "putObject"
            r8.getMethod(r6, r7)     // Catch:{ all -> 0x00e8 }
            r6 = 1
            goto L_0x00ed
        L_0x00e8:
            r6 = move-exception
            java.util.logging.Logger.getLogger(c.d.a.b.e.e.kb.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r6.toString()))
            goto L_0x0074
        L_0x00ed:
            f1676f = r6
            java.lang.Class<byte[]> r6 = byte[].class
            int r6 = E(r6)
            long r6 = (long) r6
            g = r6
            E(r5)
            a(r5)
            E(r4)
            a(r4)
            E(r3)
            a(r3)
            E(r2)
            a(r2)
            E(r1)
            a(r1)
            E(r0)
            a(r0)
            java.lang.reflect.Field r0 = b()
            if (r0 == 0) goto L_0x0129
            c.d.a.b.e.e.jb r1 = f1674d
            if (r1 == 0) goto L_0x0129
            r1.l(r0)
        L_0x0129:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0132
            goto L_0x0133
        L_0x0132:
            r12 = 0
        L_0x0133:
            h = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.kb.<clinit>():void");
    }

    private kb() {
    }

    static boolean A(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i = f7.f1631a;
        try {
            Class cls3 = f1672b;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean B(Object obj, long j) {
        return f1674d.g(obj, j);
    }

    static boolean C() {
        return f1676f;
    }

    static boolean D() {
        return f1675e;
    }

    private static int E(Class cls) {
        if (f1676f) {
            return f1674d.h(cls);
        }
        return -1;
    }

    private static int a(Class cls) {
        if (f1676f) {
            return f1674d.i(cls);
        }
        return -1;
    }

    private static Field b() {
        int i = f7.f1631a;
        Field c2 = c(Buffer.class, "effectiveDirectAddress");
        if (c2 != null) {
            return c2;
        }
        Field c3 = c(Buffer.class, "address");
        if (c3 == null || c3.getType() != Long.TYPE) {
            return null;
        }
        return c3;
    }

    private static Field c(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void d(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        jb jbVar = f1674d;
        int i = ((((int) j) ^ -1) & 3) << 3;
        jbVar.n(obj, j2, ((255 & b2) << i) | (jbVar.j(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void e(Object obj, long j, byte b2) {
        long j2 = -4 & j;
        jb jbVar = f1674d;
        int i = (((int) j) & 3) << 3;
        jbVar.n(obj, j2, ((255 & b2) << i) | (jbVar.j(obj, j2) & ((255 << i) ^ -1)));
    }

    static double f(Object obj, long j) {
        return f1674d.a(obj, j);
    }

    static float g(Object obj, long j) {
        return f1674d.b(obj, j);
    }

    static int h(Object obj, long j) {
        return f1674d.j(obj, j);
    }

    static long i(Object obj, long j) {
        return f1674d.k(obj, j);
    }

    static Object j(Class cls) {
        try {
            return f1671a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    static Object k(Object obj, long j) {
        return f1674d.m(obj, j);
    }

    static Unsafe l() {
        try {
            return (Unsafe) AccessController.doPrivileged(new gb());
        } catch (Throwable unused) {
            return null;
        }
    }

    static void r(Object obj, long j, boolean z) {
        f1674d.c(obj, j, z);
    }

    static void s(byte[] bArr, long j, byte b2) {
        f1674d.d(bArr, g + j, b2);
    }

    static void t(Object obj, long j, double d2) {
        f1674d.e(obj, j, d2);
    }

    static void u(Object obj, long j, float f2) {
        f1674d.f(obj, j, f2);
    }

    static void v(Object obj, long j, int i) {
        f1674d.n(obj, j, i);
    }

    static void w(Object obj, long j, long j2) {
        f1674d.o(obj, j, j2);
    }

    static void x(Object obj, long j, Object obj2) {
        f1674d.p(obj, j, obj2);
    }

    static /* bridge */ /* synthetic */ boolean y(Object obj, long j) {
        return ((byte) ((f1674d.j(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3))) & 255)) != 0;
    }

    static /* bridge */ /* synthetic */ boolean z(Object obj, long j) {
        return ((byte) ((f1674d.j(obj, -4 & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }
}
