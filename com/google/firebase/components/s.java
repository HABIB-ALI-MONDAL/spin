package com.google.firebase.components;

import android.util.Log;
import com.google.firebase.m.c;
import com.google.firebase.m.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class s extends m implements com.google.firebase.k.a {
    private static final com.google.firebase.o.b<Set<Object>> h = i.f2697a;

    /* renamed from: a  reason: collision with root package name */
    private final Map<n<?>, com.google.firebase.o.b<?>> f2717a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, com.google.firebase.o.b<?>> f2718b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, a0<?>> f2719c;

    /* renamed from: d  reason: collision with root package name */
    private final List<com.google.firebase.o.b<ComponentRegistrar>> f2720d;

    /* renamed from: e  reason: collision with root package name */
    private final x f2721e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference<Boolean> f2722f;
    private final r g;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f2723a;

        /* renamed from: b  reason: collision with root package name */
        private final List<com.google.firebase.o.b<ComponentRegistrar>> f2724b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final List<n<?>> f2725c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private r f2726d = r.f2716a;

        b(Executor executor) {
            this.f2723a = executor;
        }

        static /* synthetic */ ComponentRegistrar e(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public b a(n<?> nVar) {
            this.f2725c.add(nVar);
            return this;
        }

        public b b(ComponentRegistrar componentRegistrar) {
            this.f2724b.add(new e(componentRegistrar));
            return this;
        }

        public b c(Collection<com.google.firebase.o.b<ComponentRegistrar>> collection) {
            this.f2724b.addAll(collection);
            return this;
        }

        public s d() {
            return new s(this.f2723a, this.f2724b, this.f2725c, this.f2726d);
        }

        public b f(r rVar) {
            this.f2726d = rVar;
            return this;
        }
    }

    private s(Executor executor, Iterable<com.google.firebase.o.b<ComponentRegistrar>> iterable, Collection<n<?>> collection, r rVar) {
        this.f2717a = new HashMap();
        this.f2718b = new HashMap();
        this.f2719c = new HashMap();
        this.f2722f = new AtomicReference<>();
        x xVar = new x(executor);
        this.f2721e = xVar;
        this.g = rVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(n.o(xVar, x.class, d.class, c.class));
        arrayList.add(n.o(this, com.google.firebase.k.a.class, new Class[0]));
        for (n next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        this.f2720d = i(iterable);
        f(arrayList);
    }

    public static b e(Executor executor) {
        return new b(executor);
    }

    private void f(List<n<?>> list) {
        ArrayList<Runnable> arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator<com.google.firebase.o.b<ComponentRegistrar>> it = this.f2720d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) it.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(this.g.a(componentRegistrar));
                        it.remove();
                    }
                } catch (y e2) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e2);
                }
            }
            if (this.f2717a.isEmpty()) {
                t.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f2717a.keySet());
                arrayList2.addAll(list);
                t.a(arrayList2);
            }
            for (n next : list) {
                this.f2717a.put(next, new z(new d(this, next)));
            }
            arrayList.addAll(p(list));
            arrayList.addAll(q());
            o();
        }
        for (Runnable run : arrayList) {
            run.run();
        }
        n();
    }

    private void g(Map<n<?>, com.google.firebase.o.b<?>> map, boolean z) {
        for (Map.Entry next : map.entrySet()) {
            n nVar = (n) next.getKey();
            com.google.firebase.o.b bVar = (com.google.firebase.o.b) next.getValue();
            if (nVar.j() || (nVar.k() && z)) {
                bVar.get();
            }
        }
        this.f2721e.c();
    }

    private static <T> List<T> i(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T add : iterable) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ Object k(n nVar) {
        return nVar.d().a(new e0(nVar, this));
    }

    private void n() {
        Boolean bool = this.f2722f.get();
        if (bool != null) {
            g(this.f2717a, bool.booleanValue());
        }
    }

    private void o() {
        Map map;
        Class<?> b2;
        Object a2;
        for (n next : this.f2717a.keySet()) {
            Iterator<u> it = next.c().iterator();
            while (true) {
                if (it.hasNext()) {
                    u next2 = it.next();
                    if (next2.f() && !this.f2719c.containsKey(next2.b())) {
                        map = this.f2719c;
                        b2 = next2.b();
                        a2 = a0.b(Collections.emptySet());
                    } else if (this.f2718b.containsKey(next2.b())) {
                        continue;
                    } else if (next2.e()) {
                        throw new b0(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next, next2.b()}));
                    } else if (!next2.f()) {
                        map = this.f2718b;
                        b2 = next2.b();
                        a2 = c0.a();
                    }
                    map.put(b2, a2);
                }
            }
        }
    }

    private List<Runnable> p(List<n<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (n next : list) {
            if (next.l()) {
                com.google.firebase.o.b bVar = this.f2717a.get(next);
                for (Class cls : next.f()) {
                    if (!this.f2718b.containsKey(cls)) {
                        this.f2718b.put(cls, bVar);
                    } else {
                        arrayList.add(new g((c0) this.f2718b.get(cls), bVar));
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> q() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f2717a.entrySet()) {
            n nVar = (n) next.getKey();
            if (!nVar.l()) {
                com.google.firebase.o.b bVar = (com.google.firebase.o.b) next.getValue();
                for (Class cls : nVar.f()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(bVar);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!this.f2719c.containsKey(entry.getKey())) {
                this.f2719c.put((Class) entry.getKey(), a0.b((Collection) entry.getValue()));
            } else {
                a0 a0Var = this.f2719c.get(entry.getKey());
                for (com.google.firebase.o.b fVar : (Set) entry.getValue()) {
                    arrayList.add(new f(a0Var, fVar));
                }
            }
        }
        return arrayList;
    }

    public synchronized <T> com.google.firebase.o.b<T> b(Class<T> cls) {
        d0.c(cls, "Null interface requested.");
        return this.f2718b.get(cls);
    }

    public synchronized <T> com.google.firebase.o.b<Set<T>> d(Class<T> cls) {
        a0 a0Var = this.f2719c.get(cls);
        if (a0Var != null) {
            return a0Var;
        }
        return h;
    }

    public void h(boolean z) {
        HashMap hashMap;
        if (this.f2722f.compareAndSet((Object) null, Boolean.valueOf(z))) {
            synchronized (this) {
                hashMap = new HashMap(this.f2717a);
            }
            g(hashMap, z);
        }
    }
}
