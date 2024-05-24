package b.g.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import b.d.k.p;
import b.d.k.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class q {

    class a implements Runnable {
        final /* synthetic */ int j;
        final /* synthetic */ ArrayList k;
        final /* synthetic */ ArrayList l;
        final /* synthetic */ ArrayList m;
        final /* synthetic */ ArrayList n;

        a(q qVar, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.j = i;
            this.k = arrayList;
            this.l = arrayList2;
            this.m = arrayList3;
            this.n = arrayList4;
        }

        public void run() {
            for (int i = 0; i < this.j; i++) {
                p.J((View) this.k.get(i), (String) this.l.get(i));
                p.J((View) this.m.get(i), (String) this.n.get(i));
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ ArrayList j;
        final /* synthetic */ Map k;

        b(q qVar, ArrayList arrayList, Map map) {
            this.j = arrayList;
            this.k = map;
        }

        public void run() {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.j.get(i);
                String m = p.m(view);
                if (m != null) {
                    p.J(view, q.i(this.k, m));
                }
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ ArrayList j;
        final /* synthetic */ Map k;

        c(q qVar, ArrayList arrayList, Map map) {
            this.j = arrayList;
            this.k = map;
        }

        public void run() {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.j.get(i);
                p.J(view, (String) this.k.get(p.m(view)));
            }
        }
    }

    protected static void d(List<View> list, View view) {
        int size = list.size();
        if (!h(list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!h(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean h(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    static String i(Map<String, String> map, String str) {
        for (Map.Entry next : map.entrySet()) {
            if (str.equals(next.getValue())) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    protected static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract Object A(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    /* access modifiers changed from: package-private */
    public void f(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            boolean z = view instanceof ViewGroup;
            ViewGroup viewGroup = view;
            if (z) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                boolean a2 = r.a(viewGroup2);
                viewGroup = viewGroup2;
                if (!a2) {
                    int childCount = viewGroup2.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        f(arrayList, viewGroup2.getChildAt(i));
                    }
                    return;
                }
            }
            arrayList.add(viewGroup);
        }
    }

    public abstract Object g(Object obj);

    /* access modifiers changed from: package-private */
    public void j(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String m = p.m(view);
            if (m != null) {
                map.put(m, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    j(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    /* access modifiers changed from: package-private */
    public ArrayList<String> o(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(p.m(view));
            p.J(view, (String) null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void r(Object obj, View view, ArrayList<View> arrayList);

    /* access modifiers changed from: package-private */
    public void s(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        r.a(viewGroup, new c(this, arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    /* access modifiers changed from: package-private */
    public void w(View view, ArrayList<View> arrayList, Map<String, String> map) {
        r.a(view, new b(this, arrayList, map));
    }

    /* access modifiers changed from: package-private */
    public void x(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String m = p.m(view2);
            arrayList4.add(m);
            if (m != null) {
                p.J(view2, (String) null);
                String str = map.get(m);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i2))) {
                        p.J(arrayList2.get(i2), m);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        r.a(view, new a(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void y(Object obj, View view, ArrayList<View> arrayList);

    public abstract void z(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);
}
