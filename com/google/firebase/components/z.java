package com.google.firebase.components;

import com.google.firebase.o.b;

public class z<T> implements b<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f2738c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f2739a = f2738c;

    /* renamed from: b  reason: collision with root package name */
    private volatile b<T> f2740b;

    public z(b<T> bVar) {
        this.f2740b = bVar;
    }

    public T get() {
        T t = this.f2739a;
        T t2 = f2738c;
        if (t == t2) {
            synchronized (this) {
                t = this.f2739a;
                if (t == t2) {
                    t = this.f2740b.get();
                    this.f2739a = t;
                    this.f2740b = null;
                }
            }
        }
        return t;
    }
}
