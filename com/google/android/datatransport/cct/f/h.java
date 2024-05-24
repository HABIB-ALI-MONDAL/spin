package com.google.android.datatransport.cct.f;

final class h extends n {

    /* renamed from: a  reason: collision with root package name */
    private final long f1946a;

    h(long j) {
        this.f1946a = j;
    }

    public long c() {
        return this.f1946a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof n) && this.f1946a == ((n) obj).c();
    }

    public int hashCode() {
        long j = this.f1946a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f1946a + "}";
    }
}
