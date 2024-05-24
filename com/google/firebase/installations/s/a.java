package com.google.firebase.installations.s;

import com.google.firebase.installations.s.d;

final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f2801a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2802b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2803c;

    /* renamed from: d  reason: collision with root package name */
    private final f f2804d;

    /* renamed from: e  reason: collision with root package name */
    private final d.b f2805e;

    static final class b extends d.a {

        /* renamed from: a  reason: collision with root package name */
        private String f2806a;

        /* renamed from: b  reason: collision with root package name */
        private String f2807b;

        /* renamed from: c  reason: collision with root package name */
        private String f2808c;

        /* renamed from: d  reason: collision with root package name */
        private f f2809d;

        /* renamed from: e  reason: collision with root package name */
        private d.b f2810e;

        b() {
        }

        public d a() {
            return new a(this.f2806a, this.f2807b, this.f2808c, this.f2809d, this.f2810e);
        }

        public d.a b(f fVar) {
            this.f2809d = fVar;
            return this;
        }

        public d.a c(String str) {
            this.f2807b = str;
            return this;
        }

        public d.a d(String str) {
            this.f2808c = str;
            return this;
        }

        public d.a e(d.b bVar) {
            this.f2810e = bVar;
            return this;
        }

        public d.a f(String str) {
            this.f2806a = str;
            return this;
        }
    }

    private a(String str, String str2, String str3, f fVar, d.b bVar) {
        this.f2801a = str;
        this.f2802b = str2;
        this.f2803c = str3;
        this.f2804d = fVar;
        this.f2805e = bVar;
    }

    public f b() {
        return this.f2804d;
    }

    public String c() {
        return this.f2802b;
    }

    public String d() {
        return this.f2803c;
    }

    public d.b e() {
        return this.f2805e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f2801a;
        if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
            String str2 = this.f2802b;
            if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                String str3 = this.f2803c;
                if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                    f fVar = this.f2804d;
                    if (fVar != null ? fVar.equals(dVar.b()) : dVar.b() == null) {
                        d.b bVar = this.f2805e;
                        d.b e2 = dVar.e();
                        if (bVar == null) {
                            if (e2 == null) {
                                return true;
                            }
                        } else if (bVar.equals(e2)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String f() {
        return this.f2801a;
    }

    public int hashCode() {
        String str = this.f2801a;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f2802b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2803c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        f fVar = this.f2804d;
        int hashCode4 = (hashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        d.b bVar = this.f2805e;
        if (bVar != null) {
            i = bVar.hashCode();
        }
        return hashCode4 ^ i;
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f2801a + ", fid=" + this.f2802b + ", refreshToken=" + this.f2803c + ", authToken=" + this.f2804d + ", responseCode=" + this.f2805e + "}";
    }
}
