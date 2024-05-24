package com.google.firebase.components;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f2732a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2733b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2734c;

    private u(Class<?> cls, int i, int i2) {
        d0.c(cls, "Null dependency anInterface.");
        this.f2732a = cls;
        this.f2733b = i;
        this.f2734c = i2;
    }

    private static String a(int i) {
        if (i == 0) {
            return "direct";
        }
        if (i == 1) {
            return "provider";
        }
        if (i == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i);
    }

    @Deprecated
    public static u g(Class<?> cls) {
        return new u(cls, 0, 0);
    }

    public static u h(Class<?> cls) {
        return new u(cls, 0, 1);
    }

    public static u i(Class<?> cls) {
        return new u(cls, 1, 0);
    }

    public static u j(Class<?> cls) {
        return new u(cls, 1, 1);
    }

    public static u k(Class<?> cls) {
        return new u(cls, 2, 0);
    }

    public Class<?> b() {
        return this.f2732a;
    }

    public boolean c() {
        return this.f2734c == 2;
    }

    public boolean d() {
        return this.f2734c == 0;
    }

    public boolean e() {
        return this.f2733b == 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f2732a == uVar.f2732a && this.f2733b == uVar.f2733b && this.f2734c == uVar.f2734c;
    }

    public boolean f() {
        return this.f2733b == 2;
    }

    public int hashCode() {
        return ((((this.f2732a.hashCode() ^ 1000003) * 1000003) ^ this.f2733b) * 1000003) ^ this.f2734c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f2732a);
        sb.append(", type=");
        int i = this.f2733b;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", injection=");
        sb.append(a(this.f2734c));
        sb.append("}");
        return sb.toString();
    }
}
