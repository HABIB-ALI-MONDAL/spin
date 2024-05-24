package com.google.firebase.m;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f2879a;

    /* renamed from: b  reason: collision with root package name */
    private final T f2880b;

    public T a() {
        return this.f2880b;
    }

    public Class<T> b() {
        return this.f2879a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", new Object[]{this.f2879a, this.f2880b});
    }
}
