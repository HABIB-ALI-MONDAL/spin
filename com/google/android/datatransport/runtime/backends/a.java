package com.google.android.datatransport.runtime.backends;

import c.d.a.a.i.j;
import com.google.android.datatransport.runtime.backends.f;
import java.util.Arrays;
import java.util.Objects;

final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Iterable<j> f1951a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f1952b;

    static final class b extends f.a {

        /* renamed from: a  reason: collision with root package name */
        private Iterable<j> f1953a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f1954b;

        b() {
        }

        public f a() {
            String str = "";
            if (this.f1953a == null) {
                str = str + " events";
            }
            if (str.isEmpty()) {
                return new a(this.f1953a, this.f1954b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public f.a b(Iterable<j> iterable) {
            Objects.requireNonNull(iterable, "Null events");
            this.f1953a = iterable;
            return this;
        }

        public f.a c(byte[] bArr) {
            this.f1954b = bArr;
            return this;
        }
    }

    private a(Iterable<j> iterable, byte[] bArr) {
        this.f1951a = iterable;
        this.f1952b = bArr;
    }

    public Iterable<j> b() {
        return this.f1951a;
    }

    public byte[] c() {
        return this.f1952b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f1951a.equals(fVar.b())) {
            if (Arrays.equals(this.f1952b, fVar instanceof a ? ((a) fVar).f1952b : fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f1951a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f1952b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f1951a + ", extras=" + Arrays.toString(this.f1952b) + "}";
    }
}
