package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class n5 {
    public static double a(double d2) {
        if (Double.isNaN(d2)) {
            return 0.0d;
        }
        if (Double.isInfinite(d2) || d2 == 0.0d || d2 == 0.0d) {
            return d2;
        }
        double d3 = (double) (d2 > 0.0d ? 1 : -1);
        double floor = Math.floor(Math.abs(d2));
        Double.isNaN(d3);
        return d3 * floor;
    }

    public static int b(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2) || d2 == 0.0d) {
            return 0;
        }
        double d3 = (double) (d2 > 0.0d ? 1 : -1);
        double floor = Math.floor(Math.abs(d2));
        Double.isNaN(d3);
        return (int) ((long) ((d3 * floor) % 4.294967296E9d));
    }

    public static int c(n4 n4Var) {
        int b2 = b(n4Var.d("runtime.counter").f().doubleValue() + 1.0d);
        if (b2 <= 1000000) {
            n4Var.g("runtime.counter", new i(Double.valueOf((double) b2)));
            return b2;
        }
        throw new IllegalStateException("Instructions allowed exceeded");
    }

    public static long d(double d2) {
        return ((long) b(d2)) & 4294967295L;
    }

    public static n0 e(String str) {
        n0 n0Var = null;
        if (str != null && !str.isEmpty()) {
            n0Var = n0.d(Integer.parseInt(str));
        }
        if (n0Var != null) {
            return n0Var;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", new Object[]{str}));
    }

    public static Object f(q qVar) {
        if (q.f1723c.equals(qVar)) {
            return null;
        }
        if (q.f1722b.equals(qVar)) {
            return "";
        }
        if (qVar instanceof n) {
            return g((n) qVar);
        }
        if (!(qVar instanceof f)) {
            return !qVar.f().isNaN() ? qVar.f() : qVar.g();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((f) qVar).iterator();
        while (it.hasNext()) {
            Object f2 = f((q) it.next());
            if (f2 != null) {
                arrayList.add(f2);
            }
        }
        return arrayList;
    }

    public static Map g(n nVar) {
        HashMap hashMap = new HashMap();
        for (String str : nVar.a()) {
            Object f2 = f(nVar.p(str));
            if (f2 != null) {
                hashMap.put(str, f2);
            }
        }
        return hashMap;
    }

    public static void h(String str, int i, List list) {
        if (list.size() != i) {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(list.size())}));
        }
    }

    public static void i(String str, int i, List list) {
        if (list.size() < i) {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(list.size())}));
        }
    }

    public static void j(String str, int i, List list) {
        if (list.size() > i) {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(list.size())}));
        }
    }

    public static boolean k(q qVar) {
        if (qVar == null) {
            return false;
        }
        Double f2 = qVar.f();
        return !f2.isNaN() && f2.doubleValue() >= 0.0d && f2.equals(Double.valueOf(Math.floor(f2.doubleValue())));
    }

    public static boolean l(q qVar, q qVar2) {
        if (!qVar.getClass().equals(qVar2.getClass())) {
            return false;
        }
        if ((qVar instanceof v) || (qVar instanceof o)) {
            return true;
        }
        if (!(qVar instanceof i)) {
            return qVar instanceof u ? qVar.g().equals(qVar2.g()) : qVar instanceof g ? qVar.k().equals(qVar2.k()) : qVar == qVar2;
        }
        if (Double.isNaN(qVar.f().doubleValue()) || Double.isNaN(qVar2.f().doubleValue())) {
            return false;
        }
        return qVar.f().equals(qVar2.f());
    }
}
