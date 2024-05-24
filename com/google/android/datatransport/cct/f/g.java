package com.google.android.datatransport.cct.f;

import com.google.android.datatransport.cct.f.m;
import java.util.List;

final class g extends m {

    /* renamed from: a  reason: collision with root package name */
    private final long f1934a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1935b;

    /* renamed from: c  reason: collision with root package name */
    private final k f1936c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f1937d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1938e;

    /* renamed from: f  reason: collision with root package name */
    private final List<l> f1939f;
    private final p g;

    static final class b extends m.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f1940a;

        /* renamed from: b  reason: collision with root package name */
        private Long f1941b;

        /* renamed from: c  reason: collision with root package name */
        private k f1942c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f1943d;

        /* renamed from: e  reason: collision with root package name */
        private String f1944e;

        /* renamed from: f  reason: collision with root package name */
        private List<l> f1945f;
        private p g;

        b() {
        }

        public m a() {
            String str = "";
            if (this.f1940a == null) {
                str = str + " requestTimeMs";
            }
            if (this.f1941b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new g(this.f1940a.longValue(), this.f1941b.longValue(), this.f1942c, this.f1943d, this.f1944e, this.f1945f, this.g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public m.a b(k kVar) {
            this.f1942c = kVar;
            return this;
        }

        public m.a c(List<l> list) {
            this.f1945f = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public m.a d(Integer num) {
            this.f1943d = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        public m.a e(String str) {
            this.f1944e = str;
            return this;
        }

        public m.a f(p pVar) {
            this.g = pVar;
            return this;
        }

        public m.a g(long j) {
            this.f1940a = Long.valueOf(j);
            return this;
        }

        public m.a h(long j) {
            this.f1941b = Long.valueOf(j);
            return this;
        }
    }

    private g(long j, long j2, k kVar, Integer num, String str, List<l> list, p pVar) {
        this.f1934a = j;
        this.f1935b = j2;
        this.f1936c = kVar;
        this.f1937d = num;
        this.f1938e = str;
        this.f1939f = list;
        this.g = pVar;
    }

    public k b() {
        return this.f1936c;
    }

    public List<l> c() {
        return this.f1939f;
    }

    public Integer d() {
        return this.f1937d;
    }

    public String e() {
        return this.f1938e;
    }

    public boolean equals(Object obj) {
        k kVar;
        Integer num;
        String str;
        List<l> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f1934a == mVar.g() && this.f1935b == mVar.h() && ((kVar = this.f1936c) != null ? kVar.equals(mVar.b()) : mVar.b() == null) && ((num = this.f1937d) != null ? num.equals(mVar.d()) : mVar.d() == null) && ((str = this.f1938e) != null ? str.equals(mVar.e()) : mVar.e() == null) && ((list = this.f1939f) != null ? list.equals(mVar.c()) : mVar.c() == null)) {
            p pVar = this.g;
            p f2 = mVar.f();
            if (pVar == null) {
                if (f2 == null) {
                    return true;
                }
            } else if (pVar.equals(f2)) {
                return true;
            }
        }
        return false;
    }

    public p f() {
        return this.g;
    }

    public long g() {
        return this.f1934a;
    }

    public long h() {
        return this.f1935b;
    }

    public int hashCode() {
        long j = this.f1934a;
        long j2 = this.f1935b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        k kVar = this.f1936c;
        int i2 = 0;
        int hashCode = (i ^ (kVar == null ? 0 : kVar.hashCode())) * 1000003;
        Integer num = this.f1937d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f1938e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<l> list = this.f1939f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        p pVar = this.g;
        if (pVar != null) {
            i2 = pVar.hashCode();
        }
        return hashCode4 ^ i2;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f1934a + ", requestUptimeMs=" + this.f1935b + ", clientInfo=" + this.f1936c + ", logSource=" + this.f1937d + ", logSourceName=" + this.f1938e + ", logEvents=" + this.f1939f + ", qosTier=" + this.g + "}";
    }
}
