package com.google.firebase.installations;

import com.google.firebase.installations.m;
import java.util.Objects;

final class f extends m {

    /* renamed from: a  reason: collision with root package name */
    private final String f2758a;

    /* renamed from: b  reason: collision with root package name */
    private final long f2759b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2760c;

    static final class b extends m.a {

        /* renamed from: a  reason: collision with root package name */
        private String f2761a;

        /* renamed from: b  reason: collision with root package name */
        private Long f2762b;

        /* renamed from: c  reason: collision with root package name */
        private Long f2763c;

        b() {
        }

        public m a() {
            String str = "";
            if (this.f2761a == null) {
                str = str + " token";
            }
            if (this.f2762b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f2763c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new f(this.f2761a, this.f2762b.longValue(), this.f2763c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public m.a b(String str) {
            Objects.requireNonNull(str, "Null token");
            this.f2761a = str;
            return this;
        }

        public m.a c(long j) {
            this.f2763c = Long.valueOf(j);
            return this;
        }

        public m.a d(long j) {
            this.f2762b = Long.valueOf(j);
            return this;
        }
    }

    private f(String str, long j, long j2) {
        this.f2758a = str;
        this.f2759b = j;
        this.f2760c = j2;
    }

    public String b() {
        return this.f2758a;
    }

    public long c() {
        return this.f2760c;
    }

    public long d() {
        return this.f2759b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f2758a.equals(mVar.b()) && this.f2759b == mVar.d() && this.f2760c == mVar.c();
    }

    public int hashCode() {
        long j = this.f2759b;
        long j2 = this.f2760c;
        return ((((this.f2758a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f2758a + ", tokenExpirationTimestamp=" + this.f2759b + ", tokenCreationTimestamp=" + this.f2760c + "}";
    }
}
