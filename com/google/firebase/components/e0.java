package com.google.firebase.components;

import com.google.firebase.m.c;
import com.google.firebase.o.b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class e0 extends m {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<?>> f2690a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Class<?>> f2691b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Class<?>> f2692c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<Class<?>> f2693d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<Class<?>> f2694e;

    /* renamed from: f  reason: collision with root package name */
    private final o f2695f;

    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final c f2696a;

        public a(Set<Class<?>> set, c cVar) {
            this.f2696a = cVar;
        }
    }

    e0(n<?> nVar, o oVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (u next : nVar.c()) {
            if (next.d()) {
                boolean f2 = next.f();
                Class<?> b2 = next.b();
                if (f2) {
                    hashSet4.add(b2);
                } else {
                    hashSet.add(b2);
                }
            } else if (next.c()) {
                hashSet3.add(next.b());
            } else {
                boolean f3 = next.f();
                Class<?> b3 = next.b();
                if (f3) {
                    hashSet5.add(b3);
                } else {
                    hashSet2.add(b3);
                }
            }
        }
        if (!nVar.g().isEmpty()) {
            hashSet.add(c.class);
        }
        this.f2690a = Collections.unmodifiableSet(hashSet);
        this.f2691b = Collections.unmodifiableSet(hashSet2);
        Collections.unmodifiableSet(hashSet3);
        this.f2692c = Collections.unmodifiableSet(hashSet4);
        this.f2693d = Collections.unmodifiableSet(hashSet5);
        this.f2694e = nVar.g();
        this.f2695f = oVar;
    }

    public <T> T a(Class<T> cls) {
        if (this.f2690a.contains(cls)) {
            T a2 = this.f2695f.a(cls);
            return !cls.equals(c.class) ? a2 : new a(this.f2694e, (c) a2);
        }
        throw new w(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public <T> b<T> b(Class<T> cls) {
        if (this.f2691b.contains(cls)) {
            return this.f2695f.b(cls);
        }
        throw new w(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{cls}));
    }

    public <T> Set<T> c(Class<T> cls) {
        if (this.f2692c.contains(cls)) {
            return this.f2695f.c(cls);
        }
        throw new w(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{cls}));
    }

    public <T> b<Set<T>> d(Class<T> cls) {
        if (this.f2693d.contains(cls)) {
            return this.f2695f.d(cls);
        }
        throw new w(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{cls}));
    }
}
