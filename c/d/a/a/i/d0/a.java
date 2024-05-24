package c.d.a.a.i.d0;

import android.util.SparseArray;
import c.d.a.a.d;
import java.util.HashMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static SparseArray<d> f1445a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<d, Integer> f1446b;

    static {
        HashMap<d, Integer> hashMap = new HashMap<>();
        f1446b = hashMap;
        hashMap.put(d.DEFAULT, 0);
        f1446b.put(d.VERY_LOW, 1);
        f1446b.put(d.HIGHEST, 2);
        for (d next : f1446b.keySet()) {
            f1445a.append(f1446b.get(next).intValue(), next);
        }
    }

    public static int a(d dVar) {
        Integer num = f1446b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i) {
        d dVar = f1445a.get(i);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i);
    }
}
