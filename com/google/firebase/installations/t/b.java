package com.google.firebase.installations.t;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static b f2827a;

    private b() {
    }

    public static b b() {
        if (f2827a == null) {
            f2827a = new b();
        }
        return f2827a;
    }

    public long a() {
        return System.currentTimeMillis();
    }
}
