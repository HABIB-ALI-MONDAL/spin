package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import c.d.a.a.d;
import c.d.a.a.i.c0.a;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import java.util.Map;
import java.util.Objects;

final class q extends t {

    /* renamed from: a  reason: collision with root package name */
    private final a f2001a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<d, t.b> f2002b;

    q(a aVar, Map<d, t.b> map) {
        Objects.requireNonNull(aVar, "Null clock");
        this.f2001a = aVar;
        Objects.requireNonNull(map, "Null values");
        this.f2002b = map;
    }

    /* access modifiers changed from: package-private */
    public a e() {
        return this.f2001a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f2001a.equals(tVar.e()) && this.f2002b.equals(tVar.h());
    }

    /* access modifiers changed from: package-private */
    public Map<d, t.b> h() {
        return this.f2002b;
    }

    public int hashCode() {
        return ((this.f2001a.hashCode() ^ 1000003) * 1000003) ^ this.f2002b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f2001a + ", values=" + this.f2002b + "}";
    }
}
