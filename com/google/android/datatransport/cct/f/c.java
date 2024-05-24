package com.google.android.datatransport.cct.f;

import com.google.android.datatransport.cct.f.a;

final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f1905a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1906b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1907c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1908d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1909e;

    /* renamed from: f  reason: collision with root package name */
    private final String f1910f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;

    static final class b extends a.C0065a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f1911a;

        /* renamed from: b  reason: collision with root package name */
        private String f1912b;

        /* renamed from: c  reason: collision with root package name */
        private String f1913c;

        /* renamed from: d  reason: collision with root package name */
        private String f1914d;

        /* renamed from: e  reason: collision with root package name */
        private String f1915e;

        /* renamed from: f  reason: collision with root package name */
        private String f1916f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;

        b() {
        }

        public a a() {
            return new c(this.f1911a, this.f1912b, this.f1913c, this.f1914d, this.f1915e, this.f1916f, this.g, this.h, this.i, this.j, this.k, this.l);
        }

        public a.C0065a b(String str) {
            this.l = str;
            return this;
        }

        public a.C0065a c(String str) {
            this.j = str;
            return this;
        }

        public a.C0065a d(String str) {
            this.f1914d = str;
            return this;
        }

        public a.C0065a e(String str) {
            this.h = str;
            return this;
        }

        public a.C0065a f(String str) {
            this.f1913c = str;
            return this;
        }

        public a.C0065a g(String str) {
            this.i = str;
            return this;
        }

        public a.C0065a h(String str) {
            this.g = str;
            return this;
        }

        public a.C0065a i(String str) {
            this.k = str;
            return this;
        }

        public a.C0065a j(String str) {
            this.f1912b = str;
            return this;
        }

        public a.C0065a k(String str) {
            this.f1916f = str;
            return this;
        }

        public a.C0065a l(String str) {
            this.f1915e = str;
            return this;
        }

        public a.C0065a m(Integer num) {
            this.f1911a = num;
            return this;
        }
    }

    private c(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f1905a = num;
        this.f1906b = str;
        this.f1907c = str2;
        this.f1908d = str3;
        this.f1909e = str4;
        this.f1910f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = str9;
        this.k = str10;
        this.l = str11;
    }

    public String b() {
        return this.l;
    }

    public String c() {
        return this.j;
    }

    public String d() {
        return this.f1908d;
    }

    public String e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        Integer num = this.f1905a;
        if (num != null ? num.equals(aVar.m()) : aVar.m() == null) {
            String str = this.f1906b;
            if (str != null ? str.equals(aVar.j()) : aVar.j() == null) {
                String str2 = this.f1907c;
                if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                    String str3 = this.f1908d;
                    if (str3 != null ? str3.equals(aVar.d()) : aVar.d() == null) {
                        String str4 = this.f1909e;
                        if (str4 != null ? str4.equals(aVar.l()) : aVar.l() == null) {
                            String str5 = this.f1910f;
                            if (str5 != null ? str5.equals(aVar.k()) : aVar.k() == null) {
                                String str6 = this.g;
                                if (str6 != null ? str6.equals(aVar.h()) : aVar.h() == null) {
                                    String str7 = this.h;
                                    if (str7 != null ? str7.equals(aVar.e()) : aVar.e() == null) {
                                        String str8 = this.i;
                                        if (str8 != null ? str8.equals(aVar.g()) : aVar.g() == null) {
                                            String str9 = this.j;
                                            if (str9 != null ? str9.equals(aVar.c()) : aVar.c() == null) {
                                                String str10 = this.k;
                                                if (str10 != null ? str10.equals(aVar.i()) : aVar.i() == null) {
                                                    String str11 = this.l;
                                                    String b2 = aVar.b();
                                                    if (str11 == null) {
                                                        if (b2 == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(b2)) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String f() {
        return this.f1907c;
    }

    public String g() {
        return this.i;
    }

    public String h() {
        return this.g;
    }

    public int hashCode() {
        Integer num = this.f1905a;
        int i2 = 0;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f1906b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f1907c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f1908d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f1909e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f1910f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.h;
        int hashCode8 = (hashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.i;
        int hashCode9 = (hashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.j;
        int hashCode10 = (hashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.k;
        int hashCode11 = (hashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.l;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return hashCode11 ^ i2;
    }

    public String i() {
        return this.k;
    }

    public String j() {
        return this.f1906b;
    }

    public String k() {
        return this.f1910f;
    }

    public String l() {
        return this.f1909e;
    }

    public Integer m() {
        return this.f1905a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f1905a + ", model=" + this.f1906b + ", hardware=" + this.f1907c + ", device=" + this.f1908d + ", product=" + this.f1909e + ", osBuild=" + this.f1910f + ", manufacturer=" + this.g + ", fingerprint=" + this.h + ", locale=" + this.i + ", country=" + this.j + ", mccMnc=" + this.k + ", applicationBuild=" + this.l + "}";
    }
}
