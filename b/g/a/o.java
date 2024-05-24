package b.g.a;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.k;
import b.d.k.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class o {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f731a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* renamed from: b  reason: collision with root package name */
    private static final q f732b = (Build.VERSION.SDK_INT >= 21 ? new p() : null);

    /* renamed from: c  reason: collision with root package name */
    private static final q f733c = x();

    static class a implements Runnable {
        final /* synthetic */ ArrayList j;

        a(ArrayList arrayList) {
            this.j = arrayList;
        }

        public void run() {
            o.B(this.j, 4);
        }
    }

    static class b implements Runnable {
        final /* synthetic */ Object j;
        final /* synthetic */ q k;
        final /* synthetic */ View l;
        final /* synthetic */ d m;
        final /* synthetic */ ArrayList n;
        final /* synthetic */ ArrayList o;
        final /* synthetic */ ArrayList p;
        final /* synthetic */ Object q;

        b(Object obj, q qVar, View view, d dVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.j = obj;
            this.k = qVar;
            this.l = view;
            this.m = dVar;
            this.n = arrayList;
            this.o = arrayList2;
            this.p = arrayList3;
            this.q = obj2;
        }

        public void run() {
            Object obj = this.j;
            if (obj != null) {
                this.k.p(obj, this.l);
                this.o.addAll(o.k(this.k, this.j, this.m, this.n, this.l));
            }
            if (this.p != null) {
                if (this.q != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.l);
                    this.k.q(this.q, this.p, arrayList);
                }
                this.p.clear();
                this.p.add(this.l);
            }
        }
    }

    static class c implements Runnable {
        final /* synthetic */ d j;
        final /* synthetic */ d k;
        final /* synthetic */ boolean l;
        final /* synthetic */ b.c.a m;
        final /* synthetic */ View n;
        final /* synthetic */ q o;
        final /* synthetic */ Rect p;

        c(d dVar, d dVar2, boolean z, b.c.a aVar, View view, q qVar, Rect rect) {
            this.j = dVar;
            this.k = dVar2;
            this.l = z;
            this.m = aVar;
            this.n = view;
            this.o = qVar;
            this.p = rect;
        }

        public void run() {
            o.f(this.j, this.k, this.l, this.m, false);
            View view = this.n;
            if (view != null) {
                this.o.k(view, this.p);
            }
        }
    }

    static class d implements Runnable {
        final /* synthetic */ q j;
        final /* synthetic */ b.c.a k;
        final /* synthetic */ Object l;
        final /* synthetic */ e m;
        final /* synthetic */ ArrayList n;
        final /* synthetic */ View o;
        final /* synthetic */ d p;
        final /* synthetic */ d q;
        final /* synthetic */ boolean r;
        final /* synthetic */ ArrayList s;
        final /* synthetic */ Object t;
        final /* synthetic */ Rect u;

        d(q qVar, b.c.a aVar, Object obj, e eVar, ArrayList arrayList, View view, d dVar, d dVar2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.j = qVar;
            this.k = aVar;
            this.l = obj;
            this.m = eVar;
            this.n = arrayList;
            this.o = view;
            this.p = dVar;
            this.q = dVar2;
            this.r = z;
            this.s = arrayList2;
            this.t = obj2;
            this.u = rect;
        }

        public void run() {
            b.c.a<String, View> h = o.h(this.j, this.k, this.l, this.m);
            if (h != null) {
                this.n.addAll(h.values());
                this.n.add(this.o);
            }
            o.f(this.p, this.q, this.r, h, false);
            Object obj = this.l;
            if (obj != null) {
                this.j.z(obj, this.s, this.n);
                View t2 = o.t(h, this.m, this.t, this.r);
                if (t2 != null) {
                    this.j.k(t2, this.u);
                }
            }
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        public d f734a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f735b;

        /* renamed from: c  reason: collision with root package name */
        public a f736c;

        /* renamed from: d  reason: collision with root package name */
        public d f737d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f738e;

        /* renamed from: f  reason: collision with root package name */
        public a f739f;

        e() {
        }
    }

    private static void A(q qVar, Object obj, Object obj2, b.c.a<String, View> aVar, boolean z, a aVar2) {
        ArrayList<String> arrayList = aVar2.q;
        if (arrayList != null && !arrayList.isEmpty()) {
            View view = aVar.get((z ? aVar2.r : aVar2.q).get(0));
            qVar.v(obj, view);
            if (obj2 != null) {
                qVar.v(obj2, view);
            }
        }
    }

    static void B(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    static void C(j jVar, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (jVar.u >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                a aVar = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    e(aVar, sparseArray, z);
                } else {
                    c(aVar, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(jVar.v.e());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    b.c.a<String, String> d2 = d(keyAt, arrayList, arrayList2, i, i2);
                    e eVar = (e) sparseArray.valueAt(i4);
                    if (z) {
                        o(jVar, keyAt, eVar, view, d2);
                    } else {
                        n(jVar, keyAt, eVar, view, d2);
                    }
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, b.c.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View m = aVar.m(size);
            if (collection.contains(p.m(m))) {
                arrayList.add(m);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0041, code lost:
        if (r10.t != false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0076, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0090, code lost:
        if (r10.J == false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0092, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(b.g.a.a r16, b.g.a.a.C0032a r17, android.util.SparseArray<b.g.a.o.e> r18, boolean r19, boolean r20) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            b.g.a.d r10 = r1.f681b
            if (r10 != 0) goto L_0x000d
            return
        L_0x000d:
            int r11 = r10.H
            if (r11 != 0) goto L_0x0012
            return
        L_0x0012:
            if (r3 == 0) goto L_0x001b
            int[] r4 = f731a
            int r1 = r1.f680a
            r1 = r4[r1]
            goto L_0x001d
        L_0x001b:
            int r1 = r1.f680a
        L_0x001d:
            r4 = 0
            r5 = 1
            if (r1 == r5) goto L_0x0085
            r6 = 3
            if (r1 == r6) goto L_0x005f
            r6 = 4
            if (r1 == r6) goto L_0x0047
            r6 = 5
            if (r1 == r6) goto L_0x0035
            r6 = 6
            if (r1 == r6) goto L_0x005f
            r6 = 7
            if (r1 == r6) goto L_0x0085
            r1 = 0
        L_0x0031:
            r12 = 0
            r13 = 0
            goto L_0x0098
        L_0x0035:
            if (r20 == 0) goto L_0x0044
            boolean r1 = r10.X
            if (r1 == 0) goto L_0x0094
            boolean r1 = r10.J
            if (r1 != 0) goto L_0x0094
            boolean r1 = r10.t
            if (r1 == 0) goto L_0x0094
            goto L_0x0092
        L_0x0044:
            boolean r1 = r10.J
            goto L_0x0095
        L_0x0047:
            if (r20 == 0) goto L_0x0056
            boolean r1 = r10.X
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.t
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.J
            if (r1 == 0) goto L_0x0078
        L_0x0055:
            goto L_0x0076
        L_0x0056:
            boolean r1 = r10.t
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.J
            if (r1 != 0) goto L_0x0078
            goto L_0x0055
        L_0x005f:
            boolean r1 = r10.t
            if (r20 == 0) goto L_0x007a
            if (r1 != 0) goto L_0x0078
            android.view.View r1 = r10.R
            if (r1 == 0) goto L_0x0078
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x0078
            float r1 = r10.Y
            r6 = 0
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x0078
        L_0x0076:
            r1 = 1
            goto L_0x0081
        L_0x0078:
            r1 = 0
            goto L_0x0081
        L_0x007a:
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.J
            if (r1 != 0) goto L_0x0078
            goto L_0x0076
        L_0x0081:
            r13 = r1
            r1 = 0
            r12 = 1
            goto L_0x0098
        L_0x0085:
            if (r20 == 0) goto L_0x008a
            boolean r1 = r10.W
            goto L_0x0095
        L_0x008a:
            boolean r1 = r10.t
            if (r1 != 0) goto L_0x0094
            boolean r1 = r10.J
            if (r1 != 0) goto L_0x0094
        L_0x0092:
            r1 = 1
            goto L_0x0095
        L_0x0094:
            r1 = 0
        L_0x0095:
            r4 = r1
            r1 = 1
            goto L_0x0031
        L_0x0098:
            java.lang.Object r6 = r2.get(r11)
            b.g.a.o$e r6 = (b.g.a.o.e) r6
            if (r4 == 0) goto L_0x00aa
            b.g.a.o$e r6 = p(r6, r2, r11)
            r6.f734a = r10
            r6.f735b = r3
            r6.f736c = r0
        L_0x00aa:
            r14 = r6
            r15 = 0
            if (r20 != 0) goto L_0x00d1
            if (r1 == 0) goto L_0x00d1
            if (r14 == 0) goto L_0x00b8
            b.g.a.d r1 = r14.f737d
            if (r1 != r10) goto L_0x00b8
            r14.f737d = r15
        L_0x00b8:
            b.g.a.j r4 = r0.f674a
            int r1 = r10.j
            if (r1 >= r5) goto L_0x00d1
            int r1 = r4.u
            if (r1 < r5) goto L_0x00d1
            boolean r1 = r0.s
            if (r1 != 0) goto L_0x00d1
            r4.w0(r10)
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r10
            r4.G0(r5, r6, r7, r8, r9)
        L_0x00d1:
            if (r13 == 0) goto L_0x00e3
            if (r14 == 0) goto L_0x00d9
            b.g.a.d r1 = r14.f737d
            if (r1 != 0) goto L_0x00e3
        L_0x00d9:
            b.g.a.o$e r14 = p(r14, r2, r11)
            r14.f737d = r10
            r14.f738e = r3
            r14.f739f = r0
        L_0x00e3:
            if (r20 != 0) goto L_0x00ef
            if (r12 == 0) goto L_0x00ef
            if (r14 == 0) goto L_0x00ef
            b.g.a.d r0 = r14.f734a
            if (r0 != r10) goto L_0x00ef
            r14.f734a = r15
        L_0x00ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.a.o.b(b.g.a.a, b.g.a.a$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(a aVar, SparseArray<e> sparseArray, boolean z) {
        int size = aVar.f675b.size();
        for (int i = 0; i < size; i++) {
            b(aVar, aVar.f675b.get(i), sparseArray, false, z);
        }
    }

    private static b.c.a<String, String> d(int i, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        b.c.a<String, String> aVar = new b.c.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            a aVar2 = arrayList.get(i4);
            if (aVar2.p(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = aVar2.q;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.q;
                        arrayList4 = aVar2.r;
                    } else {
                        ArrayList<String> arrayList6 = aVar2.q;
                        arrayList3 = aVar2.r;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(a aVar, SparseArray<e> sparseArray, boolean z) {
        if (aVar.f674a.w.c()) {
            for (int size = aVar.f675b.size() - 1; size >= 0; size--) {
                b(aVar, aVar.f675b.get(size), sparseArray, true, z);
            }
        }
    }

    static void f(d dVar, d dVar2, boolean z, b.c.a<String, View> aVar, boolean z2) {
        k s = z ? dVar2.s() : dVar.s();
        if (s != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.i(i));
                arrayList.add(aVar.m(i));
            }
            if (z2) {
                s.c(arrayList2, arrayList, (List<View>) null);
            } else {
                s.b(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    private static boolean g(q qVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!qVar.e(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    static b.c.a<String, View> h(q qVar, b.c.a<String, String> aVar, Object obj, e eVar) {
        k kVar;
        ArrayList<String> arrayList;
        String q;
        d dVar = eVar.f734a;
        View H = dVar.H();
        if (aVar.isEmpty() || obj == null || H == null) {
            aVar.clear();
            return null;
        }
        b.c.a<String, View> aVar2 = new b.c.a<>();
        qVar.j(aVar2, H);
        a aVar3 = eVar.f736c;
        if (eVar.f735b) {
            kVar = dVar.u();
            arrayList = aVar3.q;
        } else {
            kVar = dVar.s();
            arrayList = aVar3.r;
        }
        if (arrayList != null) {
            aVar2.o(arrayList);
            aVar2.o(aVar.values());
        }
        if (kVar != null) {
            kVar.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    String q2 = q(aVar, str);
                    if (q2 != null) {
                        aVar.remove(q2);
                    }
                } else if (!str.equals(p.m(view)) && (q = q(aVar, str)) != null) {
                    aVar.put(q, p.m(view));
                }
            }
        } else {
            y(aVar, aVar2);
        }
        return aVar2;
    }

    private static b.c.a<String, View> i(q qVar, b.c.a<String, String> aVar, Object obj, e eVar) {
        k kVar;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        d dVar = eVar.f737d;
        b.c.a<String, View> aVar2 = new b.c.a<>();
        qVar.j(aVar2, dVar.H());
        a aVar3 = eVar.f739f;
        if (eVar.f738e) {
            kVar = dVar.s();
            arrayList = aVar3.r;
        } else {
            kVar = dVar.u();
            arrayList = aVar3.q;
        }
        aVar2.o(arrayList);
        if (kVar != null) {
            kVar.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(p.m(view))) {
                    aVar.put(p.m(view), aVar.remove(str));
                }
            }
        } else {
            aVar.o(aVar2.keySet());
        }
        return aVar2;
    }

    private static q j(d dVar, d dVar2) {
        ArrayList arrayList = new ArrayList();
        if (dVar != null) {
            Object t = dVar.t();
            if (t != null) {
                arrayList.add(t);
            }
            Object D = dVar.D();
            if (D != null) {
                arrayList.add(D);
            }
            Object F = dVar.F();
            if (F != null) {
                arrayList.add(F);
            }
        }
        if (dVar2 != null) {
            Object r = dVar2.r();
            if (r != null) {
                arrayList.add(r);
            }
            Object B = dVar2.B();
            if (B != null) {
                arrayList.add(B);
            }
            Object E = dVar2.E();
            if (E != null) {
                arrayList.add(E);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        q qVar = f732b;
        if (qVar != null && g(qVar, arrayList)) {
            return qVar;
        }
        q qVar2 = f733c;
        if (qVar2 != null && g(qVar2, arrayList)) {
            return qVar2;
        }
        if (qVar == null && qVar2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(q qVar, Object obj, d dVar, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View H = dVar.H();
        if (H != null) {
            qVar.f(arrayList2, H);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        qVar.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(q qVar, ViewGroup viewGroup, View view, b.c.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        b.c.a<String, String> aVar2;
        Object obj3;
        Object obj4;
        Rect rect;
        q qVar2 = qVar;
        e eVar2 = eVar;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        d dVar = eVar2.f734a;
        d dVar2 = eVar2.f737d;
        if (dVar == null || dVar2 == null) {
            return null;
        }
        boolean z = eVar2.f735b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            obj3 = null;
        } else {
            obj3 = u(qVar2, dVar, dVar2, z);
            aVar2 = aVar;
        }
        b.c.a<String, View> i = i(qVar2, aVar2, obj3, eVar2);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(i.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        f(dVar, dVar2, z, i, true);
        if (obj4 != null) {
            rect = new Rect();
            qVar2.y(obj4, view, arrayList3);
            A(qVar, obj4, obj2, i, eVar2.f738e, eVar2.f739f);
            if (obj5 != null) {
                qVar2.u(obj5, rect);
            }
        } else {
            rect = null;
        }
        d dVar3 = r0;
        d dVar4 = new d(qVar, aVar, obj4, eVar, arrayList2, view, dVar, dVar2, z, arrayList, obj, rect);
        r.a(viewGroup, dVar3);
        return obj4;
    }

    private static Object m(q qVar, ViewGroup viewGroup, View view, b.c.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        View view2;
        q qVar2 = qVar;
        View view3 = view;
        b.c.a<String, String> aVar2 = aVar;
        e eVar2 = eVar;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj4 = obj;
        d dVar = eVar2.f734a;
        d dVar2 = eVar2.f737d;
        if (dVar != null) {
            dVar.H().setVisibility(0);
        }
        if (dVar == null || dVar2 == null) {
            return null;
        }
        boolean z = eVar2.f735b;
        Object u = aVar.isEmpty() ? null : u(qVar, dVar, dVar2, z);
        b.c.a<String, View> i = i(qVar, aVar2, u, eVar2);
        b.c.a<String, View> h = h(qVar, aVar2, u, eVar2);
        if (aVar.isEmpty()) {
            if (i != null) {
                i.clear();
            }
            if (h != null) {
                h.clear();
            }
            obj3 = null;
        } else {
            a(arrayList3, i, aVar.keySet());
            a(arrayList4, h, aVar.values());
            obj3 = u;
        }
        if (obj4 == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(dVar, dVar2, z, i, true);
        if (obj3 != null) {
            arrayList4.add(view3);
            qVar.y(obj3, view3, arrayList3);
            A(qVar, obj3, obj2, i, eVar2.f738e, eVar2.f739f);
            Rect rect2 = new Rect();
            View t = t(h, eVar2, obj4, z);
            if (t != null) {
                qVar.u(obj4, rect2);
            }
            rect = rect2;
            view2 = t;
        } else {
            view2 = null;
            rect = null;
        }
        r.a(viewGroup, new c(dVar, dVar2, z, h, view2, qVar, rect));
        return obj3;
    }

    private static void n(j jVar, int i, e eVar, View view, b.c.a<String, String> aVar) {
        d dVar;
        d dVar2;
        q j;
        Object obj;
        j jVar2 = jVar;
        e eVar2 = eVar;
        View view2 = view;
        b.c.a<String, String> aVar2 = aVar;
        ViewGroup viewGroup = jVar2.w.c() ? (ViewGroup) jVar2.w.b(i) : null;
        if (viewGroup != null && (j = j(dVar2, dVar)) != null) {
            boolean z = eVar2.f735b;
            boolean z2 = eVar2.f738e;
            Object r = r(j, (dVar = eVar2.f734a), z);
            Object s = s(j, (dVar2 = eVar2.f737d), z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = s;
            q qVar = j;
            Object l = l(j, viewGroup, view, aVar, eVar, arrayList, arrayList2, r, obj2);
            Object obj3 = r;
            if (obj3 == null && l == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList<View> k = k(qVar, obj, dVar2, arrayList3, view2);
            Object obj4 = (k == null || k.isEmpty()) ? null : obj;
            qVar.a(obj3, view2);
            Object v = v(qVar, obj3, obj4, l, dVar, eVar2.f735b);
            if (v != null) {
                ArrayList arrayList4 = new ArrayList();
                q qVar2 = qVar;
                qVar2.t(v, obj3, arrayList4, obj4, k, l, arrayList2);
                z(qVar2, viewGroup, dVar, view, arrayList2, obj3, arrayList4, obj4, k);
                ArrayList arrayList5 = arrayList2;
                qVar.w(viewGroup, arrayList5, aVar2);
                qVar.c(viewGroup, v);
                qVar.s(viewGroup, arrayList5, aVar2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r11 = r4.f734a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void o(b.g.a.j r17, int r18, b.g.a.o.e r19, android.view.View r20, b.c.a<java.lang.String, java.lang.String> r21) {
        /*
            r0 = r17
            r4 = r19
            r9 = r20
            b.g.a.f r1 = r0.w
            boolean r1 = r1.c()
            if (r1 == 0) goto L_0x0019
            b.g.a.f r0 = r0.w
            r1 = r18
            android.view.View r0 = r0.b(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            r10 = r0
            if (r10 != 0) goto L_0x001e
            return
        L_0x001e:
            b.g.a.d r11 = r4.f734a
            b.g.a.d r12 = r4.f737d
            b.g.a.q r13 = j(r12, r11)
            if (r13 != 0) goto L_0x0029
            return
        L_0x0029:
            boolean r14 = r4.f735b
            boolean r0 = r4.f738e
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.Object r7 = r(r13, r11, r14)
            java.lang.Object r6 = s(r13, r12, r0)
            r0 = r13
            r1 = r10
            r2 = r20
            r3 = r21
            r4 = r19
            r5 = r8
            r17 = r6
            r6 = r15
            r18 = r7
            r16 = r10
            r10 = r8
            r8 = r17
            java.lang.Object r8 = m(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r6 = r18
            if (r6 != 0) goto L_0x0061
            if (r8 != 0) goto L_0x0061
            r7 = r17
            if (r7 != 0) goto L_0x0063
            return
        L_0x0061:
            r7 = r17
        L_0x0063:
            java.util.ArrayList r5 = k(r13, r7, r12, r10, r9)
            java.util.ArrayList r9 = k(r13, r6, r11, r15, r9)
            r0 = 4
            B(r9, r0)
            r0 = r13
            r1 = r6
            r2 = r7
            r3 = r8
            r4 = r11
            r11 = r5
            r5 = r14
            java.lang.Object r14 = v(r0, r1, r2, r3, r4, r5)
            if (r14 == 0) goto L_0x00a4
            w(r13, r7, r12, r11)
            java.util.ArrayList r12 = r13.o(r15)
            r0 = r13
            r1 = r14
            r2 = r6
            r3 = r9
            r4 = r7
            r5 = r11
            r6 = r8
            r7 = r15
            r0.t(r1, r2, r3, r4, r5, r6, r7)
            r0 = r16
            r13.c(r0, r14)
            r1 = r13
            r2 = r0
            r3 = r10
            r4 = r15
            r5 = r12
            r6 = r21
            r1.x(r2, r3, r4, r5, r6)
            r0 = 0
            B(r9, r0)
            r13.z(r8, r10, r15)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.a.o.o(b.g.a.j, int, b.g.a.o$e, android.view.View, b.c.a):void");
    }

    private static e p(e eVar, SparseArray<e> sparseArray, int i) {
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        sparseArray.put(i, eVar2);
        return eVar2;
    }

    private static String q(b.c.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.m(i))) {
                return aVar.i(i);
            }
        }
        return null;
    }

    private static Object r(q qVar, d dVar, boolean z) {
        if (dVar == null) {
            return null;
        }
        return qVar.g(z ? dVar.B() : dVar.r());
    }

    private static Object s(q qVar, d dVar, boolean z) {
        if (dVar == null) {
            return null;
        }
        return qVar.g(z ? dVar.D() : dVar.t());
    }

    static View t(b.c.a<String, View> aVar, e eVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        a aVar2 = eVar.f736c;
        if (obj == null || aVar == null || (arrayList = aVar2.q) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z ? aVar2.q : aVar2.r).get(0));
    }

    private static Object u(q qVar, d dVar, d dVar2, boolean z) {
        if (dVar == null || dVar2 == null) {
            return null;
        }
        return qVar.A(qVar.g(z ? dVar2.F() : dVar.E()));
    }

    private static Object v(q qVar, Object obj, Object obj2, Object obj3, d dVar, boolean z) {
        return (obj == null || obj2 == null || dVar == null) ? true : z ? dVar.m() : dVar.l() ? qVar.n(obj2, obj, obj3) : qVar.m(obj2, obj, obj3);
    }

    private static void w(q qVar, Object obj, d dVar, ArrayList<View> arrayList) {
        if (dVar != null && obj != null && dVar.t && dVar.J && dVar.X) {
            dVar.b1(true);
            qVar.r(obj, dVar.H(), arrayList);
            r.a(dVar.Q, new a(arrayList));
        }
    }

    private static q x() {
        try {
            return (q) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void y(b.c.a<String, String> aVar, b.c.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.m(size))) {
                aVar.k(size);
            }
        }
    }

    private static void z(q qVar, ViewGroup viewGroup, d dVar, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        ViewGroup viewGroup2 = viewGroup;
        r.a(viewGroup, new b(obj, qVar, view, dVar, arrayList, arrayList2, arrayList3, obj2));
    }
}
