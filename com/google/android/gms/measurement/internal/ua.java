package com.google.android.gms.measurement.internal;

import b.c.a;
import c.d.a.b.e.e.b4;
import c.d.a.b.e.e.c4;
import c.d.a.b.e.e.d4;
import c.d.a.b.e.e.e4;
import c.d.a.b.e.e.mc;
import c.d.a.b.e.e.v4;
import c.d.a.b.e.e.w4;
import c.d.a.b.e.e.x4;
import c.d.a.b.e.e.y4;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class ua {

    /* renamed from: a  reason: collision with root package name */
    private String f2572a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2573b;

    /* renamed from: c  reason: collision with root package name */
    private w4 f2574c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public BitSet f2575d;

    /* renamed from: e  reason: collision with root package name */
    private BitSet f2576e;

    /* renamed from: f  reason: collision with root package name */
    private Map f2577f;
    private Map g;
    final /* synthetic */ b h;

    /* synthetic */ ua(b bVar, String str, w4 w4Var, BitSet bitSet, BitSet bitSet2, Map map, Map map2, ta taVar) {
        this.h = bVar;
        this.f2572a = str;
        this.f2575d = bitSet;
        this.f2576e = bitSet2;
        this.f2577f = map;
        this.g = new a();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.g.put(num, arrayList);
        }
        this.f2573b = false;
        this.f2574c = w4Var;
    }

    /* synthetic */ ua(b bVar, String str, ta taVar) {
        this.h = bVar;
        this.f2572a = str;
        this.f2573b = true;
        this.f2575d = new BitSet();
        this.f2576e = new BitSet();
        this.f2577f = new a();
        this.g = new a();
    }

    /* access modifiers changed from: package-private */
    public final c4 a(int i) {
        ArrayList arrayList;
        List list;
        b4 F = c4.F();
        F.s(i);
        F.u(this.f2573b);
        w4 w4Var = this.f2574c;
        if (w4Var != null) {
            F.v(w4Var);
        }
        v4 J = w4.J();
        J.t(ea.H(this.f2575d));
        J.v(ea.H(this.f2576e));
        Map map = this.f2577f;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer intValue : this.f2577f.keySet()) {
                int intValue2 = intValue.intValue();
                Long l = (Long) this.f2577f.get(Integer.valueOf(intValue2));
                if (l != null) {
                    d4 G = e4.G();
                    G.t(intValue2);
                    G.s(l.longValue());
                    arrayList2.add((e4) G.n());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            J.s(arrayList);
        }
        Map map2 = this.g;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num : this.g.keySet()) {
                x4 H = y4.H();
                H.t(num.intValue());
                List list2 = (List) this.g.get(num);
                if (list2 != null) {
                    Collections.sort(list2);
                    H.s(list2);
                }
                arrayList3.add((y4) H.n());
            }
            list = arrayList3;
        }
        J.u(list);
        F.t(J);
        return (c4) F.n();
    }

    /* access modifiers changed from: package-private */
    public final void c(ya yaVar) {
        int a2 = yaVar.a();
        Boolean bool = yaVar.f2645c;
        if (bool != null) {
            this.f2576e.set(a2, bool.booleanValue());
        }
        Boolean bool2 = yaVar.f2646d;
        if (bool2 != null) {
            this.f2575d.set(a2, bool2.booleanValue());
        }
        if (yaVar.f2647e != null) {
            Map map = this.f2577f;
            Integer valueOf = Integer.valueOf(a2);
            Long l = (Long) map.get(valueOf);
            long longValue = yaVar.f2647e.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.f2577f.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (yaVar.f2648f != null) {
            Map map2 = this.g;
            Integer valueOf2 = Integer.valueOf(a2);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.g.put(valueOf2, list);
            }
            if (yaVar.c()) {
                list.clear();
            }
            mc.c();
            h z = this.h.f2527a.z();
            String str = this.f2572a;
            x2 x2Var = y2.X;
            if (z.B(str, x2Var) && yaVar.b()) {
                list.clear();
            }
            mc.c();
            boolean B = this.h.f2527a.z().B(this.f2572a, x2Var);
            Long valueOf3 = Long.valueOf(yaVar.f2648f.longValue() / 1000);
            if (!B) {
                list.add(valueOf3);
            } else if (!list.contains(valueOf3)) {
                list.add(valueOf3);
            }
        }
    }
}
