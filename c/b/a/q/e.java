package c.b.a.q;

import c.b.a.n.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f1248a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f1249b = new HashMap();

    private static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f1250a;

        /* renamed from: b  reason: collision with root package name */
        final Class<R> f1251b;

        /* renamed from: c  reason: collision with root package name */
        final k<T, R> f1252c;

        public a(Class<T> cls, Class<R> cls2, k<T, R> kVar) {
            this.f1250a = cls;
            this.f1251b = cls2;
            this.f1252c = kVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f1250a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f1251b);
        }
    }

    private synchronized List<a<?, ?>> c(String str) {
        List<a<?, ?>> list;
        if (!this.f1248a.contains(str)) {
            this.f1248a.add(str);
        }
        list = this.f1249b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f1249b.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> void a(String str, k<T, R> kVar, Class<T> cls, Class<R> cls2) {
        c(str).add(new a(cls, cls2, kVar));
    }

    public synchronized <T, R> List<k<T, R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f1248a) {
            List<a> list = this.f1249b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f1252c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<Class<R>> d(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f1248a) {
            List<a> list = this.f1249b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f1251b)) {
                        arrayList.add(aVar.f1251b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.f1248a);
        this.f1248a.clear();
        this.f1248a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f1248a.add(str);
            }
        }
    }
}
