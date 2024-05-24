package c.d.a.b.e.e;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class ka {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f1667a;

    /* renamed from: b  reason: collision with root package name */
    private static final ab f1668b = C(false);

    /* renamed from: c  reason: collision with root package name */
    private static final ab f1669c = C(true);

    /* renamed from: d  reason: collision with root package name */
    private static final ab f1670d = new cb();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f1667a = cls;
    }

    static int A(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (z7.a(i << 3) + 1);
    }

    static void B(s9 s9Var, Object obj, Object obj2, long j) {
        kb.x(obj, j, s9.b(kb.k(obj, j), kb.k(obj2, j)));
    }

    private static ab C(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (ab) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int D(List list) {
        return list.size();
    }

    static int E(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int D = size * z7.D(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            D += z7.x((r7) list.get(i2));
        }
        return D;
    }

    static int F(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return G(list) + (size * z7.D(i));
    }

    static int G(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t8) {
            t8 t8Var = (t8) list;
            i = 0;
            while (i2 < size) {
                i += z7.z(t8Var.g(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + z7.z(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int H(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (z7.a(i << 3) + 4);
    }

    static int I(List list) {
        return list.size() * 4;
    }

    static int J(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (z7.a(i << 3) + 8);
    }

    static int K(List list) {
        return list.size() * 8;
    }

    static int L(int i, List list, ia iaVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += z7.y(i, (x9) list.get(i3), iaVar);
        }
        return i2;
    }

    static int M(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return N(list) + (size * z7.D(i));
    }

    static int N(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t8) {
            t8 t8Var = (t8) list;
            i = 0;
            while (i2 < size) {
                i += z7.z(t8Var.g(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + z7.z(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int O(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return P(list) + (list.size() * z7.D(i));
    }

    static int P(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof m9) {
            m9 m9Var = (m9) list;
            i = 0;
            while (i2 < size) {
                i += z7.b(m9Var.a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + z7.b(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int Q(int i, Object obj, ia iaVar) {
        if (!(obj instanceof c9)) {
            return z7.a(i << 3) + z7.B((x9) obj, iaVar);
        }
        int a2 = z7.a(i << 3);
        int a3 = ((c9) obj).a();
        return a2 + z7.a(a3) + a3;
    }

    static int R(int i, List list, ia iaVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int D = z7.D(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            D += obj instanceof c9 ? z7.A((c9) obj) : z7.B((x9) obj, iaVar);
        }
        return D;
    }

    static int S(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return T(list) + (size * z7.D(i));
    }

    static int T(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t8) {
            t8 t8Var = (t8) list;
            i = 0;
            while (i2 < size) {
                int g = t8Var.g(i2);
                i += z7.a((g >> 31) ^ (g + g));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + z7.a((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    static int U(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return V(list) + (size * z7.D(i));
    }

    static int V(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof m9) {
            m9 m9Var = (m9) list;
            i = 0;
            while (i2 < size) {
                long a2 = m9Var.a(i2);
                i += z7.b((a2 >> 63) ^ (a2 + a2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + z7.b((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int W(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int D = z7.D(i) * size;
        if (list instanceof e9) {
            e9 e9Var = (e9) list;
            while (i2 < size) {
                Object q = e9Var.q(i2);
                D += q instanceof r7 ? z7.x((r7) q) : z7.C((String) q);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                D += obj instanceof r7 ? z7.x((r7) obj) : z7.C((String) obj);
                i2++;
            }
        }
        return D;
    }

    static int X(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return Y(list) + (size * z7.D(i));
    }

    static int Y(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t8) {
            t8 t8Var = (t8) list;
            i = 0;
            while (i2 < size) {
                i += z7.a(t8Var.g(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + z7.a(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int Z(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return a0(list) + (size * z7.D(i));
    }

    public static ab a() {
        return f1669c;
    }

    static int a0(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof m9) {
            m9 m9Var = (m9) list;
            i = 0;
            while (i2 < size) {
                i += z7.b(m9Var.a(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + z7.b(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static ab b() {
        return f1670d;
    }

    public static ab b0() {
        return f1668b;
    }

    static Object c(Object obj, int i, List list, u8 u8Var, Object obj2, ab abVar) {
        Object obj3 = null;
        if (u8Var == null) {
            return null;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (u8Var.a(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj3 = d(obj, i, intValue, obj3, abVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj3;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!u8Var.a(intValue2)) {
                    obj3 = d(obj, i, intValue2, obj3, abVar);
                    it.remove();
                }
            }
        }
        return obj3;
    }

    static Object d(Object obj, int i, int i2, Object obj2, ab abVar) {
        if (obj2 == null) {
            obj2 = abVar.c(obj);
        }
        abVar.f(obj2, i, (long) i2);
        return obj2;
    }

    static void e(f8 f8Var, Object obj, Object obj2) {
        f8Var.a(obj2);
        throw null;
    }

    static void f(ab abVar, Object obj, Object obj2) {
        abVar.h(obj, abVar.e(abVar.d(obj), abVar.d(obj2)));
    }

    public static void g(Class cls) {
        Class cls2;
        if (!s8.class.isAssignableFrom(cls) && (cls2 = f1667a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void h(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.a(i, list, z);
        }
    }

    public static void i(int i, List list, tb tbVar) {
        if (list != null && !list.isEmpty()) {
            tbVar.j(i, list);
        }
    }

    public static void j(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.e(i, list, z);
        }
    }

    public static void k(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.B(i, list, z);
        }
    }

    public static void l(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.m(i, list, z);
        }
    }

    public static void m(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.n(i, list, z);
        }
    }

    public static void n(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.q(i, list, z);
        }
    }

    public static void o(int i, List list, tb tbVar, ia iaVar) {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((a8) tbVar).l(i, list.get(i2), iaVar);
            }
        }
    }

    public static void p(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.u(i, list, z);
        }
    }

    public static void q(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.y(i, list, z);
        }
    }

    public static void r(int i, List list, tb tbVar, ia iaVar) {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((a8) tbVar).x(i, list.get(i2), iaVar);
            }
        }
    }

    public static void s(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.d(i, list, z);
        }
    }

    public static void t(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.h(i, list, z);
        }
    }

    public static void u(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.t(i, list, z);
        }
    }

    public static void v(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.w(i, list, z);
        }
    }

    public static void w(int i, List list, tb tbVar) {
        if (list != null && !list.isEmpty()) {
            tbVar.b(i, list);
        }
    }

    public static void x(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.k(i, list, z);
        }
    }

    public static void y(int i, List list, tb tbVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            tbVar.D(i, list, z);
        }
    }

    static boolean z(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
