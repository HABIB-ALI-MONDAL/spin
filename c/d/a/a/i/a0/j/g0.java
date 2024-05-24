package c.d.a.a.i.a0.j;

import c.d.a.a.i.a0.j.k0;

final class g0 extends k0 {

    /* renamed from: b  reason: collision with root package name */
    private final long f1337b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1338c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1339d;

    /* renamed from: e  reason: collision with root package name */
    private final long f1340e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1341f;

    static final class b extends k0.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f1342a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f1343b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f1344c;

        /* renamed from: d  reason: collision with root package name */
        private Long f1345d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f1346e;

        b() {
        }

        /* access modifiers changed from: package-private */
        public k0 a() {
            String str = "";
            if (this.f1342a == null) {
                str = str + " maxStorageSizeInBytes";
            }
            if (this.f1343b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f1344c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f1345d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f1346e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new g0(this.f1342a.longValue(), this.f1343b.intValue(), this.f1344c.intValue(), this.f1345d.longValue(), this.f1346e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public k0.a b(int i) {
            this.f1344c = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        public k0.a c(long j) {
            this.f1345d = Long.valueOf(j);
            return this;
        }

        /* access modifiers changed from: package-private */
        public k0.a d(int i) {
            this.f1343b = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        public k0.a e(int i) {
            this.f1346e = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        public k0.a f(long j) {
            this.f1342a = Long.valueOf(j);
            return this;
        }
    }

    private g0(long j, int i, int i2, long j2, int i3) {
        this.f1337b = j;
        this.f1338c = i;
        this.f1339d = i2;
        this.f1340e = j2;
        this.f1341f = i3;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f1339d;
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.f1340e;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f1338c;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f1341f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return this.f1337b == k0Var.f() && this.f1338c == k0Var.d() && this.f1339d == k0Var.b() && this.f1340e == k0Var.c() && this.f1341f == k0Var.e();
    }

    /* access modifiers changed from: package-private */
    public long f() {
        return this.f1337b;
    }

    public int hashCode() {
        long j = this.f1337b;
        long j2 = this.f1340e;
        return this.f1341f ^ ((((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f1338c) * 1000003) ^ this.f1339d) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f1337b + ", loadBatchSize=" + this.f1338c + ", criticalSectionEnterTimeoutMs=" + this.f1339d + ", eventCleanUpAge=" + this.f1340e + ", maxBlobByteSizePerRow=" + this.f1341f + "}";
    }
}
