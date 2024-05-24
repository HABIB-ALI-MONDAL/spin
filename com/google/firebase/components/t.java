package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class t {

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final n<?> f2727a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<b> f2728b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<b> f2729c = new HashSet();

        b(n<?> nVar) {
            this.f2727a = nVar;
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f2728b.add(bVar);
        }

        /* access modifiers changed from: package-private */
        public void b(b bVar) {
            this.f2729c.add(bVar);
        }

        /* access modifiers changed from: package-private */
        public n<?> c() {
            return this.f2727a;
        }

        /* access modifiers changed from: package-private */
        public Set<b> d() {
            return this.f2728b;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            return this.f2728b.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public boolean f() {
            return this.f2729c.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public void g(b bVar) {
            this.f2729c.remove(bVar);
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private final Class<?> f2730a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f2731b;

        private c(Class<?> cls, boolean z) {
            this.f2730a = cls;
            this.f2731b = z;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f2730a.equals(this.f2730a) && cVar.f2731b == this.f2731b;
        }

        public int hashCode() {
            return ((this.f2730a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f2731b).hashCode();
        }
    }

    static void a(List<n<?>> list) {
        Set<b> c2 = c(list);
        Set<b> b2 = b(c2);
        int i = 0;
        while (!b2.isEmpty()) {
            b next = b2.iterator().next();
            b2.remove(next);
            i++;
            for (b next2 : next.d()) {
                next2.g(next);
                if (next2.f()) {
                    b2.add(next2);
                }
            }
        }
        if (i != list.size()) {
            ArrayList arrayList = new ArrayList();
            for (b next3 : c2) {
                if (!next3.f() && !next3.e()) {
                    arrayList.add(next3.c());
                }
            }
            throw new v(arrayList);
        }
    }

    private static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b next : set) {
            if (next.f()) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    private static Set<b> c(List<n<?>> list) {
        Set<b> set;
        HashMap hashMap = new HashMap(list.size());
        for (n next : list) {
            b bVar = new b(next);
            Iterator it = next.f().iterator();
            while (true) {
                if (it.hasNext()) {
                    Class cls = (Class) it.next();
                    c cVar = new c(cls, !next.l());
                    if (!hashMap.containsKey(cVar)) {
                        hashMap.put(cVar, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(cVar);
                    if (set2.isEmpty() || cVar.f2731b) {
                        set2.add(bVar);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{cls}));
                    }
                }
            }
        }
        for (Set<b> it2 : hashMap.values()) {
            for (b bVar2 : it2) {
                for (u next2 : bVar2.c().c()) {
                    if (next2.d() && (set = (Set) hashMap.get(new c(next2.b(), next2.f()))) != null) {
                        for (b bVar3 : set) {
                            bVar2.a(bVar3);
                            bVar3.b(bVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set addAll : hashMap.values()) {
            hashSet.addAll(addAll);
        }
        return hashSet;
    }
}
