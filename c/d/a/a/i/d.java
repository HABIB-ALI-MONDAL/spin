package c.d.a.a.i;

import c.d.a.a.c;
import c.d.a.a.e;
import c.d.a.a.i.o;
import java.util.Objects;

final class d extends o {

    /* renamed from: a  reason: collision with root package name */
    private final p f1435a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1436b;

    /* renamed from: c  reason: collision with root package name */
    private final c<?> f1437c;

    /* renamed from: d  reason: collision with root package name */
    private final e<?, byte[]> f1438d;

    /* renamed from: e  reason: collision with root package name */
    private final c.d.a.a.b f1439e;

    static final class b extends o.a {

        /* renamed from: a  reason: collision with root package name */
        private p f1440a;

        /* renamed from: b  reason: collision with root package name */
        private String f1441b;

        /* renamed from: c  reason: collision with root package name */
        private c<?> f1442c;

        /* renamed from: d  reason: collision with root package name */
        private e<?, byte[]> f1443d;

        /* renamed from: e  reason: collision with root package name */
        private c.d.a.a.b f1444e;

        b() {
        }

        public o a() {
            String str = "";
            if (this.f1440a == null) {
                str = str + " transportContext";
            }
            if (this.f1441b == null) {
                str = str + " transportName";
            }
            if (this.f1442c == null) {
                str = str + " event";
            }
            if (this.f1443d == null) {
                str = str + " transformer";
            }
            if (this.f1444e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new d(this.f1440a, this.f1441b, this.f1442c, this.f1443d, this.f1444e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public o.a b(c.d.a.a.b bVar) {
            Objects.requireNonNull(bVar, "Null encoding");
            this.f1444e = bVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public o.a c(c<?> cVar) {
            Objects.requireNonNull(cVar, "Null event");
            this.f1442c = cVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public o.a d(e<?, byte[]> eVar) {
            Objects.requireNonNull(eVar, "Null transformer");
            this.f1443d = eVar;
            return this;
        }

        public o.a e(p pVar) {
            Objects.requireNonNull(pVar, "Null transportContext");
            this.f1440a = pVar;
            return this;
        }

        public o.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f1441b = str;
            return this;
        }
    }

    private d(p pVar, String str, c<?> cVar, e<?, byte[]> eVar, c.d.a.a.b bVar) {
        this.f1435a = pVar;
        this.f1436b = str;
        this.f1437c = cVar;
        this.f1438d = eVar;
        this.f1439e = bVar;
    }

    public c.d.a.a.b b() {
        return this.f1439e;
    }

    /* access modifiers changed from: package-private */
    public c<?> c() {
        return this.f1437c;
    }

    /* access modifiers changed from: package-private */
    public e<?, byte[]> e() {
        return this.f1438d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f1435a.equals(oVar.f()) && this.f1436b.equals(oVar.g()) && this.f1437c.equals(oVar.c()) && this.f1438d.equals(oVar.e()) && this.f1439e.equals(oVar.b());
    }

    public p f() {
        return this.f1435a;
    }

    public String g() {
        return this.f1436b;
    }

    public int hashCode() {
        return ((((((((this.f1435a.hashCode() ^ 1000003) * 1000003) ^ this.f1436b.hashCode()) * 1000003) ^ this.f1437c.hashCode()) * 1000003) ^ this.f1438d.hashCode()) * 1000003) ^ this.f1439e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f1435a + ", transportName=" + this.f1436b + ", event=" + this.f1437c + ", transformer=" + this.f1438d + ", encoding=" + this.f1439e + "}";
    }
}
