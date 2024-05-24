package com.google.android.datatransport.cct.f;

import com.google.android.datatransport.cct.f.k;

final class e extends k {

    /* renamed from: a  reason: collision with root package name */
    private final k.b f1918a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1919b;

    static final class b extends k.a {

        /* renamed from: a  reason: collision with root package name */
        private k.b f1920a;

        /* renamed from: b  reason: collision with root package name */
        private a f1921b;

        b() {
        }

        public k a() {
            return new e(this.f1920a, this.f1921b);
        }

        public k.a b(a aVar) {
            this.f1921b = aVar;
            return this;
        }

        public k.a c(k.b bVar) {
            this.f1920a = bVar;
            return this;
        }
    }

    private e(k.b bVar, a aVar) {
        this.f1918a = bVar;
        this.f1919b = aVar;
    }

    public a b() {
        return this.f1919b;
    }

    public k.b c() {
        return this.f1918a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        k.b bVar = this.f1918a;
        if (bVar != null ? bVar.equals(kVar.c()) : kVar.c() == null) {
            a aVar = this.f1919b;
            a b2 = kVar.b();
            if (aVar == null) {
                if (b2 == null) {
                    return true;
                }
            } else if (aVar.equals(b2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        k.b bVar = this.f1918a;
        int i = 0;
        int hashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        a aVar = this.f1919b;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f1918a + ", androidClientInfo=" + this.f1919b + "}";
    }
}
