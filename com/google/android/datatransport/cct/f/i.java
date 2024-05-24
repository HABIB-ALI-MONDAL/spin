package com.google.android.datatransport.cct.f;

import com.google.android.datatransport.cct.f.o;

final class i extends o {

    /* renamed from: a  reason: collision with root package name */
    private final o.c f1947a;

    /* renamed from: b  reason: collision with root package name */
    private final o.b f1948b;

    static final class b extends o.a {

        /* renamed from: a  reason: collision with root package name */
        private o.c f1949a;

        /* renamed from: b  reason: collision with root package name */
        private o.b f1950b;

        b() {
        }

        public o a() {
            return new i(this.f1949a, this.f1950b);
        }

        public o.a b(o.b bVar) {
            this.f1950b = bVar;
            return this;
        }

        public o.a c(o.c cVar) {
            this.f1949a = cVar;
            return this;
        }
    }

    private i(o.c cVar, o.b bVar) {
        this.f1947a = cVar;
        this.f1948b = bVar;
    }

    public o.b b() {
        return this.f1948b;
    }

    public o.c c() {
        return this.f1947a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        o.c cVar = this.f1947a;
        if (cVar != null ? cVar.equals(oVar.c()) : oVar.c() == null) {
            o.b bVar = this.f1948b;
            o.b b2 = oVar.b();
            if (bVar == null) {
                if (b2 == null) {
                    return true;
                }
            } else if (bVar.equals(b2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        o.c cVar = this.f1947a;
        int i = 0;
        int hashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        o.b bVar = this.f1948b;
        if (bVar != null) {
            i = bVar.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f1947a + ", mobileSubtype=" + this.f1948b + "}";
    }
}
