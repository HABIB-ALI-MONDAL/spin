package com.google.android.datatransport.cct.f;

import java.util.List;
import java.util.Objects;

final class d extends j {

    /* renamed from: a  reason: collision with root package name */
    private final List<m> f1917a;

    d(List<m> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.f1917a = list;
    }

    public List<m> c() {
        return this.f1917a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return this.f1917a.equals(((j) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f1917a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f1917a + "}";
    }
}
