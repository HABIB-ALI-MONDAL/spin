package c.b.a.n.o;

import c.b.a.n.h;
import c.b.a.n.j;
import c.b.a.n.m;
import c.b.a.n.o.z.b;
import c.b.a.t.e;
import c.b.a.t.i;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class w implements h {
    private static final e<Class<?>, byte[]> j = new e<>(50);

    /* renamed from: b  reason: collision with root package name */
    private final b f1005b;

    /* renamed from: c  reason: collision with root package name */
    private final h f1006c;

    /* renamed from: d  reason: collision with root package name */
    private final h f1007d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1008e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1009f;
    private final Class<?> g;
    private final j h;
    private final m<?> i;

    w(b bVar, h hVar, h hVar2, int i2, int i3, m<?> mVar, Class<?> cls, j jVar) {
        this.f1005b = bVar;
        this.f1006c = hVar;
        this.f1007d = hVar2;
        this.f1008e = i2;
        this.f1009f = i3;
        this.i = mVar;
        this.g = cls;
        this.h = jVar;
    }

    private byte[] c() {
        e<Class<?>, byte[]> eVar = j;
        byte[] g2 = eVar.g(this.g);
        if (g2 != null) {
            return g2;
        }
        byte[] bytes = this.g.getName().getBytes(h.f873a);
        eVar.k(this.g, bytes);
        return bytes;
    }

    public void a(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f1005b.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f1008e).putInt(this.f1009f).array();
        this.f1007d.a(messageDigest);
        this.f1006c.a(messageDigest);
        messageDigest.update(bArr);
        m<?> mVar = this.i;
        if (mVar != null) {
            mVar.a(messageDigest);
        }
        this.h.a(messageDigest);
        messageDigest.update(c());
        this.f1005b.d(bArr);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f1009f == wVar.f1009f && this.f1008e == wVar.f1008e && i.c(this.i, wVar.i) && this.g.equals(wVar.g) && this.f1006c.equals(wVar.f1006c) && this.f1007d.equals(wVar.f1007d) && this.h.equals(wVar.h);
    }

    public int hashCode() {
        int hashCode = (((((this.f1006c.hashCode() * 31) + this.f1007d.hashCode()) * 31) + this.f1008e) * 31) + this.f1009f;
        m<?> mVar = this.i;
        if (mVar != null) {
            hashCode = (hashCode * 31) + mVar.hashCode();
        }
        return (((hashCode * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f1006c + ", signature=" + this.f1007d + ", width=" + this.f1008e + ", height=" + this.f1009f + ", decodedResourceClass=" + this.g + ", transformation='" + this.i + '\'' + ", options=" + this.h + '}';
    }
}
