package com.google.firebase.components;

import com.google.firebase.m.a;
import com.google.firebase.m.b;
import com.google.firebase.m.c;
import com.google.firebase.m.d;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

class x implements d, c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ConcurrentHashMap<b<Object>, Executor>> f2735a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Queue<a<?>> f2736b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f2737c;

    x(Executor executor) {
        this.f2737c = executor;
    }

    private synchronized Set<Map.Entry<b<Object>, Executor>> d(a<?> aVar) {
        Map map;
        map = this.f2735a.get(aVar.b());
        return map == null ? Collections.emptySet() : map.entrySet();
    }

    public <T> void a(Class<T> cls, b<? super T> bVar) {
        b(cls, this.f2737c, bVar);
    }

    public synchronized <T> void b(Class<T> cls, Executor executor, b<? super T> bVar) {
        d0.b(cls);
        d0.b(bVar);
        d0.b(executor);
        if (!this.f2735a.containsKey(cls)) {
            this.f2735a.put(cls, new ConcurrentHashMap());
        }
        this.f2735a.get(cls).put(bVar, executor);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Queue<a<?>> queue;
        synchronized (this) {
            queue = this.f2736b;
            if (queue != null) {
                this.f2736b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (a f2 : queue) {
                f(f2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r0.hasNext() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r1 = r0.next();
        ((java.util.concurrent.Executor) r1.getValue()).execute(new com.google.firebase.components.h(r1, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000e, code lost:
        r0 = d(r5).iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(com.google.firebase.m.a<?> r5) {
        /*
            r4 = this;
            com.google.firebase.components.d0.b(r5)
            monitor-enter(r4)
            java.util.Queue<com.google.firebase.m.a<?>> r0 = r4.f2736b     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x000d
            r0.add(r5)     // Catch:{ all -> 0x0032 }
            monitor-exit(r4)     // Catch:{ all -> 0x0032 }
            return
        L_0x000d:
            monitor-exit(r4)     // Catch:{ all -> 0x0032 }
            java.util.Set r0 = r4.d(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0031
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            com.google.firebase.components.h r3 = new com.google.firebase.components.h
            r3.<init>(r1, r5)
            r2.execute(r3)
            goto L_0x0016
        L_0x0031:
            return
        L_0x0032:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0032 }
            goto L_0x0036
        L_0x0035:
            throw r5
        L_0x0036:
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.x.f(com.google.firebase.m.a):void");
    }
}
