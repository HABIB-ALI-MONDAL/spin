package com.google.firebase.components;

import com.google.firebase.o.a;
import com.google.firebase.o.b;

class c0<T> implements b<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final a<Object> f2683c = k.f2699a;

    /* renamed from: d  reason: collision with root package name */
    private static final b<Object> f2684d = j.f2698a;

    /* renamed from: a  reason: collision with root package name */
    private a<T> f2685a;

    /* renamed from: b  reason: collision with root package name */
    private volatile b<T> f2686b;

    private c0(a<T> aVar, b<T> bVar) {
        this.f2685a = aVar;
        this.f2686b = bVar;
    }

    static <T> c0<T> a() {
        return new c0<>(f2683c, f2684d);
    }

    static /* synthetic */ void b(b bVar) {
    }

    static /* synthetic */ Object c() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public void d(b<T> bVar) {
        a<T> aVar;
        if (this.f2686b == f2684d) {
            synchronized (this) {
                aVar = this.f2685a;
                this.f2685a = null;
                this.f2686b = bVar;
            }
            aVar.a(bVar);
            return;
        }
        throw new IllegalStateException("provide() can be called only once.");
    }

    public T get() {
        return this.f2686b.get();
    }
}
