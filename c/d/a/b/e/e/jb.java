package c.d.a.b.e.e;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class jb {

    /* renamed from: a  reason: collision with root package name */
    final Unsafe f1666a;

    jb(Unsafe unsafe) {
        this.f1666a = unsafe;
    }

    public abstract double a(Object obj, long j);

    public abstract float b(Object obj, long j);

    public abstract void c(Object obj, long j, boolean z);

    public abstract void d(Object obj, long j, byte b2);

    public abstract void e(Object obj, long j, double d2);

    public abstract void f(Object obj, long j, float f2);

    public abstract boolean g(Object obj, long j);

    public final int h(Class cls) {
        return this.f1666a.arrayBaseOffset(cls);
    }

    public final int i(Class cls) {
        return this.f1666a.arrayIndexScale(cls);
    }

    public final int j(Object obj, long j) {
        return this.f1666a.getInt(obj, j);
    }

    public final long k(Object obj, long j) {
        return this.f1666a.getLong(obj, j);
    }

    public final long l(Field field) {
        return this.f1666a.objectFieldOffset(field);
    }

    public final Object m(Object obj, long j) {
        return this.f1666a.getObject(obj, j);
    }

    public final void n(Object obj, long j, int i) {
        this.f1666a.putInt(obj, j, i);
    }

    public final void o(Object obj, long j, long j2) {
        this.f1666a.putLong(obj, j, j2);
    }

    public final void p(Object obj, long j, Object obj2) {
        this.f1666a.putObject(obj, j, obj2);
    }
}
