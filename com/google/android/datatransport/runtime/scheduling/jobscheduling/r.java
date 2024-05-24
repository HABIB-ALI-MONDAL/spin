package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import java.util.Objects;
import java.util.Set;

final class r extends t.b {

    /* renamed from: a  reason: collision with root package name */
    private final long f2003a;

    /* renamed from: b  reason: collision with root package name */
    private final long f2004b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<t.c> f2005c;

    static final class b extends t.b.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f2006a;

        /* renamed from: b  reason: collision with root package name */
        private Long f2007b;

        /* renamed from: c  reason: collision with root package name */
        private Set<t.c> f2008c;

        b() {
        }

        public t.b a() {
            String str = "";
            if (this.f2006a == null) {
                str = str + " delta";
            }
            if (this.f2007b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f2008c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new r(this.f2006a.longValue(), this.f2007b.longValue(), this.f2008c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public t.b.a b(long j) {
            this.f2006a = Long.valueOf(j);
            return this;
        }

        public t.b.a c(Set<t.c> set) {
            Objects.requireNonNull(set, "Null flags");
            this.f2008c = set;
            return this;
        }

        public t.b.a d(long j) {
            this.f2007b = Long.valueOf(j);
            return this;
        }
    }

    private r(long j, long j2, Set<t.c> set) {
        this.f2003a = j;
        this.f2004b = j2;
        this.f2005c = set;
    }

    /* access modifiers changed from: package-private */
    public long b() {
        return this.f2003a;
    }

    /* access modifiers changed from: package-private */
    public Set<t.c> c() {
        return this.f2005c;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        return this.f2004b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t.b)) {
            return false;
        }
        t.b bVar = (t.b) obj;
        return this.f2003a == bVar.b() && this.f2004b == bVar.d() && this.f2005c.equals(bVar.c());
    }

    public int hashCode() {
        long j = this.f2003a;
        long j2 = this.f2004b;
        return this.f2005c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f2003a + ", maxAllowedDelay=" + this.f2004b + ", flags=" + this.f2005c + "}";
    }
}
