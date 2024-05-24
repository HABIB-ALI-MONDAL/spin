package com.google.firebase.installations.r;

import com.google.firebase.installations.r.c;
import com.google.firebase.installations.r.d;
import java.util.Objects;

final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f2784a;

    /* renamed from: b  reason: collision with root package name */
    private final c.a f2785b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2786c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2787d;

    /* renamed from: e  reason: collision with root package name */
    private final long f2788e;

    /* renamed from: f  reason: collision with root package name */
    private final long f2789f;
    private final String g;

    static final class b extends d.a {

        /* renamed from: a  reason: collision with root package name */
        private String f2790a;

        /* renamed from: b  reason: collision with root package name */
        private c.a f2791b;

        /* renamed from: c  reason: collision with root package name */
        private String f2792c;

        /* renamed from: d  reason: collision with root package name */
        private String f2793d;

        /* renamed from: e  reason: collision with root package name */
        private Long f2794e;

        /* renamed from: f  reason: collision with root package name */
        private Long f2795f;
        private String g;

        b() {
        }

        private b(d dVar) {
            this.f2790a = dVar.d();
            this.f2791b = dVar.g();
            this.f2792c = dVar.b();
            this.f2793d = dVar.f();
            this.f2794e = Long.valueOf(dVar.c());
            this.f2795f = Long.valueOf(dVar.h());
            this.g = dVar.e();
        }

        public d a() {
            String str = "";
            if (this.f2791b == null) {
                str = str + " registrationStatus";
            }
            if (this.f2794e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f2795f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f2790a, this.f2791b, this.f2792c, this.f2793d, this.f2794e.longValue(), this.f2795f.longValue(), this.g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public d.a b(String str) {
            this.f2792c = str;
            return this;
        }

        public d.a c(long j) {
            this.f2794e = Long.valueOf(j);
            return this;
        }

        public d.a d(String str) {
            this.f2790a = str;
            return this;
        }

        public d.a e(String str) {
            this.g = str;
            return this;
        }

        public d.a f(String str) {
            this.f2793d = str;
            return this;
        }

        public d.a g(c.a aVar) {
            Objects.requireNonNull(aVar, "Null registrationStatus");
            this.f2791b = aVar;
            return this;
        }

        public d.a h(long j) {
            this.f2795f = Long.valueOf(j);
            return this;
        }
    }

    private a(String str, c.a aVar, String str2, String str3, long j, long j2, String str4) {
        this.f2784a = str;
        this.f2785b = aVar;
        this.f2786c = str2;
        this.f2787d = str3;
        this.f2788e = j;
        this.f2789f = j2;
        this.g = str4;
    }

    public String b() {
        return this.f2786c;
    }

    public long c() {
        return this.f2788e;
    }

    public String d() {
        return this.f2784a;
    }

    public String e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str3 = this.f2784a;
        if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
            if (this.f2785b.equals(dVar.g()) && ((str = this.f2786c) != null ? str.equals(dVar.b()) : dVar.b() == null) && ((str2 = this.f2787d) != null ? str2.equals(dVar.f()) : dVar.f() == null) && this.f2788e == dVar.c() && this.f2789f == dVar.h()) {
                String str4 = this.g;
                String e2 = dVar.e();
                if (str4 == null) {
                    if (e2 == null) {
                        return true;
                    }
                } else if (str4.equals(e2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String f() {
        return this.f2787d;
    }

    public c.a g() {
        return this.f2785b;
    }

    public long h() {
        return this.f2789f;
    }

    public int hashCode() {
        String str = this.f2784a;
        int i = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f2785b.hashCode()) * 1000003;
        String str2 = this.f2786c;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2787d;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        long j = this.f2788e;
        long j2 = this.f2789f;
        int i2 = (((((hashCode2 ^ hashCode3) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.g;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i2 ^ i;
    }

    public d.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f2784a + ", registrationStatus=" + this.f2785b + ", authToken=" + this.f2786c + ", refreshToken=" + this.f2787d + ", expiresInSecs=" + this.f2788e + ", tokenCreationEpochInSecs=" + this.f2789f + ", fisError=" + this.g + "}";
    }
}
