package c.d.a.a.i;

import c.d.a.a.b;
import java.util.Arrays;
import java.util.Objects;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final b f1454a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f1455b;

    public i(b bVar, byte[] bArr) {
        Objects.requireNonNull(bVar, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.f1454a = bVar;
        this.f1455b = bArr;
    }

    public byte[] a() {
        return this.f1455b;
    }

    public b b() {
        return this.f1454a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (!this.f1454a.equals(iVar.f1454a)) {
            return false;
        }
        return Arrays.equals(this.f1455b, iVar.f1455b);
    }

    public int hashCode() {
        return ((this.f1454a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f1455b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f1454a + ", bytes=[...]}";
    }
}
