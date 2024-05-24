package com.google.android.gms.common.api.internal;

public final class h<L> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2090a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2091b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f2090a == hVar.f2090a && this.f2091b.equals(hVar.f2091b);
    }

    public int hashCode() {
        return (System.identityHashCode(this.f2090a) * 31) + this.f2091b.hashCode();
    }
}
