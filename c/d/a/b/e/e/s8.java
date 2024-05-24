package c.d.a.b.e.e;

import c.d.a.b.e.e.p8;
import c.d.a.b.e.e.s8;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class s8<MessageType extends s8<MessageType, BuilderType>, BuilderType extends p8<MessageType, BuilderType>> extends d7<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    protected bb zzc = bb.c();
    private int zzd = -1;

    static s8 C(Class cls) {
        Map map = zza;
        s8 s8Var = (s8) map.get(cls);
        if (s8Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                s8Var = (s8) map.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (s8Var == null) {
            s8Var = (s8) ((s8) kb.j(cls)).D(6, (Object) null, (Object) null);
            if (s8Var != null) {
                map.put(cls, s8Var);
            } else {
                throw new IllegalStateException();
            }
        }
        return s8Var;
    }

    private final int l(ia iaVar) {
        return iaVar == null ? fa.a().b(getClass()).b(this) : iaVar.b(this);
    }

    protected static v8 n() {
        return t8.i();
    }

    protected static w8 o() {
        return m9.g();
    }

    protected static w8 p(w8 w8Var) {
        int size = w8Var.size();
        return w8Var.m(size == 0 ? 10 : size + size);
    }

    protected static x8 q() {
        return ga.g();
    }

    protected static x8 r(x8 x8Var) {
        int size = x8Var.size();
        return x8Var.h(size == 0 ? 10 : size + size);
    }

    static Object s(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object t(x9 x9Var, String str, Object[] objArr) {
        return new ha(x9Var, str, objArr);
    }

    protected static void w(Class cls, s8 s8Var) {
        zza.put(cls, s8Var);
        s8Var.u();
    }

    /* access modifiers changed from: protected */
    public final p8 A() {
        return (p8) D(5, (Object) null, (Object) null);
    }

    public final p8 B() {
        p8 p8Var = (p8) D(5, (Object) null, (Object) null);
        p8Var.l(this);
        return p8Var;
    }

    /* access modifiers changed from: protected */
    public abstract Object D(int i, Object obj, Object obj2);

    public final void a(z7 z7Var) {
        fa.a().b(getClass()).f(this, a8.K(z7Var));
    }

    public final /* synthetic */ x9 d() {
        return (s8) D(6, (Object) null, (Object) null);
    }

    public final int e() {
        int i;
        if (y()) {
            i = l((ia) null);
            if (i < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i);
            }
        } else {
            i = this.zzd & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = l((ia) null);
                if (i >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i);
                }
            }
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return fa.a().b(getClass()).d(this, (s8) obj);
        }
        return false;
    }

    public final /* synthetic */ w9 g() {
        return (p8) D(5, (Object) null, (Object) null);
    }

    public final int hashCode() {
        if (y()) {
            return z();
        }
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int z = z();
        this.zzb = z;
        return z;
    }

    /* access modifiers changed from: package-private */
    public final int i(ia iaVar) {
        if (y()) {
            int l = l(iaVar);
            if (l >= 0) {
                return l;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + l);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int l2 = l(iaVar);
        if (l2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | l2;
            return l2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + l2);
    }

    /* access modifiers changed from: package-private */
    public final s8 m() {
        return (s8) D(4, (Object) null, (Object) null);
    }

    public final String toString() {
        return z9.a(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public final void u() {
        fa.a().b(getClass()).a(this);
        v();
    }

    /* access modifiers changed from: package-private */
    public final void v() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final void x(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public final boolean y() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* access modifiers changed from: package-private */
    public final int z() {
        return fa.a().b(getClass()).i(this);
    }
}
