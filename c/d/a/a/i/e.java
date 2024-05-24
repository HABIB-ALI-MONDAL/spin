package c.d.a.a.i;

import c.d.a.a.d;
import c.d.a.a.i.p;
import java.util.Arrays;
import java.util.Objects;

final class e extends p {

    /* renamed from: a  reason: collision with root package name */
    private final String f1447a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f1448b;

    /* renamed from: c  reason: collision with root package name */
    private final d f1449c;

    static final class b extends p.a {

        /* renamed from: a  reason: collision with root package name */
        private String f1450a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f1451b;

        /* renamed from: c  reason: collision with root package name */
        private d f1452c;

        b() {
        }

        public p a() {
            String str = "";
            if (this.f1450a == null) {
                str = str + " backendName";
            }
            if (this.f1452c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new e(this.f1450a, this.f1451b, this.f1452c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public p.a b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.f1450a = str;
            return this;
        }

        public p.a c(byte[] bArr) {
            this.f1451b = bArr;
            return this;
        }

        public p.a d(d dVar) {
            Objects.requireNonNull(dVar, "Null priority");
            this.f1452c = dVar;
            return this;
        }
    }

    private e(String str, byte[] bArr, d dVar) {
        this.f1447a = str;
        this.f1448b = bArr;
        this.f1449c = dVar;
    }

    public String b() {
        return this.f1447a;
    }

    public byte[] c() {
        return this.f1448b;
    }

    public d d() {
        return this.f1449c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f1447a.equals(pVar.b())) {
            return Arrays.equals(this.f1448b, pVar instanceof e ? ((e) pVar).f1448b : pVar.c()) && this.f1449c.equals(pVar.d());
        }
    }

    public int hashCode() {
        return ((((this.f1447a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f1448b)) * 1000003) ^ this.f1449c.hashCode();
    }
}
