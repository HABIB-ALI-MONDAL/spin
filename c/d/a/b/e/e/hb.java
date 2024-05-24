package c.d.a.b.e.e;

import sun.misc.Unsafe;

final class hb extends jb {
    hb(Unsafe unsafe) {
        super(unsafe);
    }

    public final double a(Object obj, long j) {
        return Double.longBitsToDouble(k(obj, j));
    }

    public final float b(Object obj, long j) {
        return Float.intBitsToFloat(j(obj, j));
    }

    public final void c(Object obj, long j, boolean z) {
        if (kb.h) {
            kb.d(obj, j, r3 ? (byte) 1 : 0);
        } else {
            kb.e(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final void d(Object obj, long j, byte b2) {
        if (kb.h) {
            kb.d(obj, j, b2);
        } else {
            kb.e(obj, j, b2);
        }
    }

    public final void e(Object obj, long j, double d2) {
        o(obj, j, Double.doubleToLongBits(d2));
    }

    public final void f(Object obj, long j, float f2) {
        n(obj, j, Float.floatToIntBits(f2));
    }

    public final boolean g(Object obj, long j) {
        return kb.h ? kb.y(obj, j) : kb.z(obj, j);
    }
}
