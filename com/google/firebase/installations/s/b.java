package com.google.firebase.installations.s;

import com.google.firebase.installations.s.f;

final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private final String f2811a;

    /* renamed from: b  reason: collision with root package name */
    private final long f2812b;

    /* renamed from: c  reason: collision with root package name */
    private final f.b f2813c;

    /* renamed from: com.google.firebase.installations.s.b$b  reason: collision with other inner class name */
    static final class C0076b extends f.a {

        /* renamed from: a  reason: collision with root package name */
        private String f2814a;

        /* renamed from: b  reason: collision with root package name */
        private Long f2815b;

        /* renamed from: c  reason: collision with root package name */
        private f.b f2816c;

        C0076b() {
        }

        public f a() {
            String str = "";
            if (this.f2815b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f2814a, this.f2815b.longValue(), this.f2816c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public f.a b(f.b bVar) {
            this.f2816c = bVar;
            return this;
        }

        public f.a c(String str) {
            this.f2814a = str;
            return this;
        }

        public f.a d(long j) {
            this.f2815b = Long.valueOf(j);
            return this;
        }
    }

    private b(String str, long j, f.b bVar) {
        this.f2811a = str;
        this.f2812b = j;
        this.f2813c = bVar;
    }

    public f.b b() {
        return this.f2813c;
    }

    public String c() {
        return this.f2811a;
    }

    public long d() {
        return this.f2812b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f2811a;
        if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
            if (this.f2812b == fVar.d()) {
                f.b bVar = this.f2813c;
                f.b b2 = fVar.b();
                if (bVar == null) {
                    if (b2 == null) {
                        return true;
                    }
                } else if (bVar.equals(b2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f2811a;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f2812b;
        int i2 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        f.b bVar = this.f2813c;
        if (bVar != null) {
            i = bVar.hashCode();
        }
        return i2 ^ i;
    }

    public String toString() {
        return "TokenResult{token=" + this.f2811a + ", tokenExpirationTimestamp=" + this.f2812b + ", responseCode=" + this.f2813c + "}";
    }
}
