package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.g;
import java.util.Objects;

final class b extends g {

    /* renamed from: a  reason: collision with root package name */
    private final g.a f1955a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1956b;

    b(g.a aVar, long j) {
        Objects.requireNonNull(aVar, "Null status");
        this.f1955a = aVar;
        this.f1956b = j;
    }

    public long b() {
        return this.f1956b;
    }

    public g.a c() {
        return this.f1955a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f1955a.equals(gVar.c()) && this.f1956b == gVar.b();
    }

    public int hashCode() {
        long j = this.f1956b;
        return ((this.f1955a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f1955a + ", nextRequestWaitMillis=" + this.f1956b + "}";
    }
}
