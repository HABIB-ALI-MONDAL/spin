package com.google.firebase.n;

import java.util.List;
import java.util.Objects;

final class f extends m {

    /* renamed from: a  reason: collision with root package name */
    private final String f3032a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f3033b;

    f(String str, List<String> list) {
        Objects.requireNonNull(str, "Null userAgent");
        this.f3032a = str;
        Objects.requireNonNull(list, "Null usedDates");
        this.f3033b = list;
    }

    public List<String> b() {
        return this.f3033b;
    }

    public String c() {
        return this.f3032a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f3032a.equals(mVar.c()) && this.f3033b.equals(mVar.b());
    }

    public int hashCode() {
        return ((this.f3032a.hashCode() ^ 1000003) * 1000003) ^ this.f3033b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f3032a + ", usedDates=" + this.f3033b + "}";
    }
}
