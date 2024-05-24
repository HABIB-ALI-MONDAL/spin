package c.d.a.a.i;

import c.d.a.a.i.j;
import java.util.Map;
import java.util.Objects;

final class c extends j {

    /* renamed from: a  reason: collision with root package name */
    private final String f1421a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f1422b;

    /* renamed from: c  reason: collision with root package name */
    private final i f1423c;

    /* renamed from: d  reason: collision with root package name */
    private final long f1424d;

    /* renamed from: e  reason: collision with root package name */
    private final long f1425e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f1426f;

    static final class b extends j.a {

        /* renamed from: a  reason: collision with root package name */
        private String f1427a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f1428b;

        /* renamed from: c  reason: collision with root package name */
        private i f1429c;

        /* renamed from: d  reason: collision with root package name */
        private Long f1430d;

        /* renamed from: e  reason: collision with root package name */
        private Long f1431e;

        /* renamed from: f  reason: collision with root package name */
        private Map<String, String> f1432f;

        b() {
        }

        public j d() {
            String str = "";
            if (this.f1427a == null) {
                str = str + " transportName";
            }
            if (this.f1429c == null) {
                str = str + " encodedPayload";
            }
            if (this.f1430d == null) {
                str = str + " eventMillis";
            }
            if (this.f1431e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f1432f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new c(this.f1427a, this.f1428b, this.f1429c, this.f1430d.longValue(), this.f1431e.longValue(), this.f1432f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: protected */
        public Map<String, String> e() {
            Map<String, String> map = this.f1432f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* access modifiers changed from: protected */
        public j.a f(Map<String, String> map) {
            Objects.requireNonNull(map, "Null autoMetadata");
            this.f1432f = map;
            return this;
        }

        public j.a g(Integer num) {
            this.f1428b = num;
            return this;
        }

        public j.a h(i iVar) {
            Objects.requireNonNull(iVar, "Null encodedPayload");
            this.f1429c = iVar;
            return this;
        }

        public j.a i(long j) {
            this.f1430d = Long.valueOf(j);
            return this;
        }

        public j.a j(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f1427a = str;
            return this;
        }

        public j.a k(long j) {
            this.f1431e = Long.valueOf(j);
            return this;
        }
    }

    private c(String str, Integer num, i iVar, long j, long j2, Map<String, String> map) {
        this.f1421a = str;
        this.f1422b = num;
        this.f1423c = iVar;
        this.f1424d = j;
        this.f1425e = j2;
        this.f1426f = map;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> c() {
        return this.f1426f;
    }

    public Integer d() {
        return this.f1422b;
    }

    public i e() {
        return this.f1423c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r7.f1422b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof c.d.a.a.i.j
            r2 = 0
            if (r1 == 0) goto L_0x005b
            c.d.a.a.i.j r8 = (c.d.a.a.i.j) r8
            java.lang.String r1 = r7.f1421a
            java.lang.String r3 = r8.j()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0059
            java.lang.Integer r1 = r7.f1422b
            if (r1 != 0) goto L_0x0022
            java.lang.Integer r1 = r8.d()
            if (r1 != 0) goto L_0x0059
            goto L_0x002c
        L_0x0022:
            java.lang.Integer r3 = r8.d()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0059
        L_0x002c:
            c.d.a.a.i.i r1 = r7.f1423c
            c.d.a.a.i.i r3 = r8.e()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0059
            long r3 = r7.f1424d
            long r5 = r8.f()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0059
            long r3 = r7.f1425e
            long r5 = r8.k()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0059
            java.util.Map<java.lang.String, java.lang.String> r1 = r7.f1426f
            java.util.Map r8 = r8.c()
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            return r0
        L_0x005b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.a.i.c.equals(java.lang.Object):boolean");
    }

    public long f() {
        return this.f1424d;
    }

    public int hashCode() {
        int hashCode = (this.f1421a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f1422b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j = this.f1424d;
        long j2 = this.f1425e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.f1423c.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f1426f.hashCode();
    }

    public String j() {
        return this.f1421a;
    }

    public long k() {
        return this.f1425e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f1421a + ", code=" + this.f1422b + ", encodedPayload=" + this.f1423c + ", eventMillis=" + this.f1424d + ", uptimeMillis=" + this.f1425e + ", autoMetadata=" + this.f1426f + "}";
    }
}
