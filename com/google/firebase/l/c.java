package com.google.firebase.l;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f2834a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Object> f2835b;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f2836a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Class<?>, Object> f2837b = null;

        b(String str) {
            this.f2836a = str;
        }

        public c a() {
            return new c(this.f2836a, this.f2837b == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.f2837b)));
        }

        public <T extends Annotation> b b(T t) {
            if (this.f2837b == null) {
                this.f2837b = new HashMap();
            }
            this.f2837b.put(t.annotationType(), t);
            return this;
        }
    }

    private c(String str, Map<Class<?>, Object> map) {
        this.f2834a = str;
        this.f2835b = map;
    }

    public static b a(String str) {
        return new b(str);
    }

    public static c d(String str) {
        return new c(str, Collections.emptyMap());
    }

    public String b() {
        return this.f2834a;
    }

    public <T extends Annotation> T c(Class<T> cls) {
        return (Annotation) this.f2835b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f2834a.equals(cVar.f2834a) && this.f2835b.equals(cVar.f2835b);
    }

    public int hashCode() {
        return (this.f2834a.hashCode() * 31) + this.f2835b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f2834a + ", properties=" + this.f2835b.values() + "}";
    }
}
