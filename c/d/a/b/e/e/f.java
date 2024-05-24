package c.d.a.b.e.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class f implements Iterable, q, m {
    final SortedMap j;
    final Map k;

    public f() {
        this.j = new TreeMap();
        this.k = new TreeMap();
    }

    public f(List list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                B(i, (q) list.get(i));
            }
        }
    }

    public final void A(int i) {
        int intValue = ((Integer) this.j.lastKey()).intValue();
        if (i <= intValue && i >= 0) {
            this.j.remove(Integer.valueOf(i));
            if (i == intValue) {
                SortedMap sortedMap = this.j;
                int i2 = i - 1;
                Integer valueOf = Integer.valueOf(i2);
                if (!sortedMap.containsKey(valueOf) && i2 >= 0) {
                    this.j.put(valueOf, q.f1722b);
                    return;
                }
                return;
            }
            while (true) {
                i++;
                if (i <= ((Integer) this.j.lastKey()).intValue()) {
                    SortedMap sortedMap2 = this.j;
                    Integer valueOf2 = Integer.valueOf(i);
                    q qVar = (q) sortedMap2.get(valueOf2);
                    if (qVar != null) {
                        this.j.put(Integer.valueOf(i - 1), qVar);
                        this.j.remove(valueOf2);
                    }
                } else {
                    return;
                }
            }
        }
    }

    @RequiresNonNull({"elements"})
    public final void B(int i, q qVar) {
        if (i > 32468) {
            throw new IllegalStateException("Array too large");
        } else if (i < 0) {
            throw new IndexOutOfBoundsException("Out of bounds index: " + i);
        } else if (qVar == null) {
            this.j.remove(Integer.valueOf(i));
        } else {
            this.j.put(Integer.valueOf(i), qVar);
        }
    }

    public final boolean C(int i) {
        if (i >= 0 && i <= ((Integer) this.j.lastKey()).intValue()) {
            return this.j.containsKey(Integer.valueOf(i));
        }
        throw new IndexOutOfBoundsException("Out of bounds index: " + i);
    }

    public final q d() {
        Integer num;
        SortedMap sortedMap;
        q qVar;
        f fVar = new f();
        for (Map.Entry entry : this.j.entrySet()) {
            if (entry.getValue() instanceof m) {
                sortedMap = fVar.j;
                num = (Integer) entry.getKey();
                qVar = (q) entry.getValue();
            } else {
                sortedMap = fVar.j;
                num = (Integer) entry.getKey();
                qVar = ((q) entry.getValue()).d();
            }
            sortedMap.put(num, qVar);
        }
        return fVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (t() != fVar.t()) {
            return false;
        }
        if (this.j.isEmpty()) {
            return fVar.j.isEmpty();
        }
        for (int intValue = ((Integer) this.j.firstKey()).intValue(); intValue <= ((Integer) this.j.lastKey()).intValue(); intValue++) {
            if (!u(intValue).equals(fVar.u(intValue))) {
                return false;
            }
        }
        return true;
    }

    public final Double f() {
        return this.j.size() == 1 ? u(0).f() : this.j.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    public final String g() {
        return v(",");
    }

    public final int hashCode() {
        return this.j.hashCode() * 31;
    }

    public final Iterator i() {
        return new d(this, this.j.keySet().iterator(), this.k.keySet().iterator());
    }

    public final Iterator iterator() {
        return new e(this);
    }

    public final boolean j(String str) {
        return "length".equals(str) || this.k.containsKey(str);
    }

    public final Boolean k() {
        return Boolean.TRUE;
    }

    public final q l(String str, n4 n4Var, List list) {
        return ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) ? d0.a(str, this, n4Var, list) : k.a(this, new u(str), n4Var, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        r3 = (c.d.a.b.e.e.q) r2.k.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final c.d.a.b.e.e.q p(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "length"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0017
            c.d.a.b.e.e.i r3 = new c.d.a.b.e.e.i
            int r0 = r2.t()
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r3.<init>(r0)
            return r3
        L_0x0017:
            boolean r0 = r2.j(r3)
            if (r0 == 0) goto L_0x0028
            java.util.Map r0 = r2.k
            java.lang.Object r3 = r0.get(r3)
            c.d.a.b.e.e.q r3 = (c.d.a.b.e.e.q) r3
            if (r3 == 0) goto L_0x0028
            return r3
        L_0x0028:
            c.d.a.b.e.e.q r3 = c.d.a.b.e.e.q.f1722b
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.f.p(java.lang.String):c.d.a.b.e.e.q");
    }

    public final void r(String str, q qVar) {
        if (qVar == null) {
            this.k.remove(str);
        } else {
            this.k.put(str, qVar);
        }
    }

    public final int s() {
        return this.j.size();
    }

    public final int t() {
        if (this.j.isEmpty()) {
            return 0;
        }
        return ((Integer) this.j.lastKey()).intValue() + 1;
    }

    public final String toString() {
        return v(",");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r2 = (c.d.a.b.e.e.q) r1.j.get(java.lang.Integer.valueOf(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final c.d.a.b.e.e.q u(int r2) {
        /*
            r1 = this;
            int r0 = r1.t()
            if (r2 >= r0) goto L_0x001e
            boolean r0 = r1.C(r2)
            if (r0 == 0) goto L_0x001b
            java.util.SortedMap r0 = r1.j
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r2 = r0.get(r2)
            c.d.a.b.e.e.q r2 = (c.d.a.b.e.e.q) r2
            if (r2 == 0) goto L_0x001b
            return r2
        L_0x001b:
            c.d.a.b.e.e.q r2 = c.d.a.b.e.e.q.f1722b
            return r2
        L_0x001e:
            java.lang.IndexOutOfBoundsException r2 = new java.lang.IndexOutOfBoundsException
            java.lang.String r0 = "Attempting to get element outside of current array"
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.b.e.e.f.u(int):c.d.a.b.e.e.q");
    }

    public final String v(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        if (!this.j.isEmpty()) {
            for (int i = 0; i < t(); i++) {
                q u = u(i);
                sb.append(str);
                if (!(u instanceof v) && !(u instanceof o)) {
                    sb.append(u.g());
                }
            }
            sb.delete(0, str.length());
        }
        return sb.toString();
    }

    public final Iterator w() {
        return this.j.keySet().iterator();
    }

    public final List x() {
        ArrayList arrayList = new ArrayList(t());
        for (int i = 0; i < t(); i++) {
            arrayList.add(u(i));
        }
        return arrayList;
    }

    public final void y() {
        this.j.clear();
    }

    public final void z(int i, q qVar) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid value index: " + i);
        } else if (i >= t()) {
            B(i, qVar);
        } else {
            for (int intValue = ((Integer) this.j.lastKey()).intValue(); intValue >= i; intValue--) {
                SortedMap sortedMap = this.j;
                Integer valueOf = Integer.valueOf(intValue);
                q qVar2 = (q) sortedMap.get(valueOf);
                if (qVar2 != null) {
                    B(intValue + 1, qVar2);
                    this.j.remove(valueOf);
                }
            }
            B(i, qVar);
        }
    }
}
