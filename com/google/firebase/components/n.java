package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class n<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f2701a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Class<? super T>> f2702b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<u> f2703c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2704d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2705e;

    /* renamed from: f  reason: collision with root package name */
    private final q<T> f2706f;
    private final Set<Class<?>> g;

    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        private String f2707a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<Class<? super T>> f2708b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<u> f2709c;

        /* renamed from: d  reason: collision with root package name */
        private int f2710d;

        /* renamed from: e  reason: collision with root package name */
        private int f2711e;

        /* renamed from: f  reason: collision with root package name */
        private q<T> f2712f;
        private Set<Class<?>> g;

        @SafeVarargs
        private b(Class<T> cls, Class<? super T>... clsArr) {
            this.f2707a = null;
            HashSet hashSet = new HashSet();
            this.f2708b = hashSet;
            this.f2709c = new HashSet();
            this.f2710d = 0;
            this.f2711e = 0;
            this.g = new HashSet();
            d0.c(cls, "Null interface");
            hashSet.add(cls);
            for (Class<? super T> c2 : clsArr) {
                d0.c(c2, "Null interface");
            }
            Collections.addAll(this.f2708b, clsArr);
        }

        /* access modifiers changed from: private */
        public b<T> g() {
            this.f2711e = 1;
            return this;
        }

        private b<T> i(int i) {
            d0.d(this.f2710d == 0, "Instantiation type has already been set.");
            this.f2710d = i;
            return this;
        }

        private void j(Class<?> cls) {
            d0.a(!this.f2708b.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b<T> b(u uVar) {
            d0.c(uVar, "Null dependency");
            j(uVar.b());
            this.f2709c.add(uVar);
            return this;
        }

        public b<T> c() {
            i(1);
            return this;
        }

        public n<T> d() {
            d0.d(this.f2712f != null, "Missing required property: factory.");
            return new n(this.f2707a, new HashSet(this.f2708b), new HashSet(this.f2709c), this.f2710d, this.f2711e, this.f2712f, this.g);
        }

        public b<T> e() {
            i(2);
            return this;
        }

        public b<T> f(q<T> qVar) {
            d0.c(qVar, "Null factory");
            this.f2712f = qVar;
            return this;
        }

        public b<T> h(String str) {
            this.f2707a = str;
            return this;
        }
    }

    private n(String str, Set<Class<? super T>> set, Set<u> set2, int i, int i2, q<T> qVar, Set<Class<?>> set3) {
        this.f2701a = str;
        this.f2702b = Collections.unmodifiableSet(set);
        this.f2703c = Collections.unmodifiableSet(set2);
        this.f2704d = i;
        this.f2705e = i2;
        this.f2706f = qVar;
        this.g = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> b<T> b(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    public static <T> n<T> h(T t, Class<T> cls) {
        b<T> i = i(cls);
        i.f(new a(t));
        return i.d();
    }

    public static <T> b<T> i(Class<T> cls) {
        b<T> a2 = a(cls);
        b unused = a2.g();
        return a2;
    }

    static /* synthetic */ Object m(Object obj, o oVar) {
        return obj;
    }

    static /* synthetic */ Object n(Object obj, o oVar) {
        return obj;
    }

    @SafeVarargs
    public static <T> n<T> o(T t, Class<T> cls, Class<? super T>... clsArr) {
        b<T> b2 = b(cls, clsArr);
        b2.f(new b(t));
        return b2.d();
    }

    public Set<u> c() {
        return this.f2703c;
    }

    public q<T> d() {
        return this.f2706f;
    }

    public String e() {
        return this.f2701a;
    }

    public Set<Class<? super T>> f() {
        return this.f2702b;
    }

    public Set<Class<?>> g() {
        return this.g;
    }

    public boolean j() {
        return this.f2704d == 1;
    }

    public boolean k() {
        return this.f2704d == 2;
    }

    public boolean l() {
        return this.f2705e == 0;
    }

    public n<T> p(q<T> qVar) {
        return new n(this.f2701a, this.f2702b, this.f2703c, this.f2704d, this.f2705e, qVar, this.g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f2702b.toArray()) + ">{" + this.f2704d + ", type=" + this.f2705e + ", deps=" + Arrays.toString(this.f2703c.toArray()) + "}";
    }
}
