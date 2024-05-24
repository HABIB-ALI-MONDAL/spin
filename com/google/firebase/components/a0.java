package com.google.firebase.components;

import com.google.firebase.o.b;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class a0<T> implements b<Set<T>> {

    /* renamed from: a  reason: collision with root package name */
    private volatile Set<b<T>> f2679a = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: b  reason: collision with root package name */
    private volatile Set<T> f2680b = null;

    a0(Collection<b<T>> collection) {
        this.f2679a.addAll(collection);
    }

    static a0<?> b(Collection<b<?>> collection) {
        return new a0<>((Set) collection);
    }

    private synchronized void d() {
        for (b<T> bVar : this.f2679a) {
            this.f2680b.add(bVar.get());
        }
        this.f2679a = null;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(b<T> bVar) {
        Set set;
        T t;
        if (this.f2680b == null) {
            set = this.f2679a;
            t = bVar;
        } else {
            set = this.f2680b;
            t = bVar.get();
        }
        set.add(t);
    }

    /* renamed from: c */
    public Set<T> get() {
        if (this.f2680b == null) {
            synchronized (this) {
                if (this.f2680b == null) {
                    this.f2680b = Collections.newSetFromMap(new ConcurrentHashMap());
                    d();
                }
            }
        }
        return Collections.unmodifiableSet(this.f2680b);
    }
}
