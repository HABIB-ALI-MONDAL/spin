package com.google.android.datatransport.cct.f;

import com.google.android.datatransport.cct.f.l;
import java.util.Arrays;

final class f extends l {

    /* renamed from: a  reason: collision with root package name */
    private final long f1922a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f1923b;

    /* renamed from: c  reason: collision with root package name */
    private final long f1924c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f1925d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1926e;

    /* renamed from: f  reason: collision with root package name */
    private final long f1927f;
    private final o g;

    static final class b extends l.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f1928a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f1929b;

        /* renamed from: c  reason: collision with root package name */
        private Long f1930c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f1931d;

        /* renamed from: e  reason: collision with root package name */
        private String f1932e;

        /* renamed from: f  reason: collision with root package name */
        private Long f1933f;
        private o g;

        b() {
        }

        public l a() {
            String str = "";
            if (this.f1928a == null) {
                str = str + " eventTimeMs";
            }
            if (this.f1930c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f1933f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new f(this.f1928a.longValue(), this.f1929b, this.f1930c.longValue(), this.f1931d, this.f1932e, this.f1933f.longValue(), this.g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public l.a b(Integer num) {
            this.f1929b = num;
            return this;
        }

        public l.a c(long j) {
            this.f1928a = Long.valueOf(j);
            return this;
        }

        public l.a d(long j) {
            this.f1930c = Long.valueOf(j);
            return this;
        }

        public l.a e(o oVar) {
            this.g = oVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public l.a f(byte[] bArr) {
            this.f1931d = bArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        public l.a g(String str) {
            this.f1932e = str;
            return this;
        }

        public l.a h(long j) {
            this.f1933f = Long.valueOf(j);
            return this;
        }
    }

    private f(long j, Integer num, long j2, byte[] bArr, String str, long j3, o oVar) {
        this.f1922a = j;
        this.f1923b = num;
        this.f1924c = j2;
        this.f1925d = bArr;
        this.f1926e = str;
        this.f1927f = j3;
        this.g = oVar;
    }

    public Integer b() {
        return this.f1923b;
    }

    public long c() {
        return this.f1922a;
    }

    public long d() {
        return this.f1924c;
    }

    public o e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f1922a == lVar.c() && ((num = this.f1923b) != null ? num.equals(lVar.b()) : lVar.b() == null) && this.f1924c == lVar.d()) {
            if (Arrays.equals(this.f1925d, lVar instanceof f ? ((f) lVar).f1925d : lVar.f()) && ((str = this.f1926e) != null ? str.equals(lVar.g()) : lVar.g() == null) && this.f1927f == lVar.h()) {
                o oVar = this.g;
                o e2 = lVar.e();
                if (oVar == null) {
                    if (e2 == null) {
                        return true;
                    }
                } else if (oVar.equals(e2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public byte[] f() {
        return this.f1925d;
    }

    public String g() {
        return this.f1926e;
    }

    public long h() {
        return this.f1927f;
    }

    public int hashCode() {
        long j = this.f1922a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f1923b;
        int i2 = 0;
        int hashCode = num == null ? 0 : num.hashCode();
        long j2 = this.f1924c;
        int hashCode2 = (((((i ^ hashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f1925d)) * 1000003;
        String str = this.f1926e;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.f1927f;
        int i3 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        o oVar = this.g;
        if (oVar != null) {
            i2 = oVar.hashCode();
        }
        return i3 ^ i2;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f1922a + ", eventCode=" + this.f1923b + ", eventUptimeMs=" + this.f1924c + ", sourceExtension=" + Arrays.toString(this.f1925d) + ", sourceExtensionJsonProto3=" + this.f1926e + ", timezoneOffsetSeconds=" + this.f1927f + ", networkConnectionInfo=" + this.g + "}";
    }
}
