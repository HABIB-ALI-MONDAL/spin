package c.b.a.n.o;

import c.b.a.n.h;
import c.b.a.n.j;
import java.security.MessageDigest;
import java.util.Map;

class m implements h {

    /* renamed from: b  reason: collision with root package name */
    private final Object f995b;

    /* renamed from: c  reason: collision with root package name */
    private final int f996c;

    /* renamed from: d  reason: collision with root package name */
    private final int f997d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f998e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f999f;
    private final h g;
    private final Map<Class<?>, c.b.a.n.m<?>> h;
    private final j i;
    private int j;

    m(Object obj, h hVar, int i2, int i3, Map<Class<?>, c.b.a.n.m<?>> map, Class<?> cls, Class<?> cls2, j jVar) {
        c.b.a.t.h.d(obj);
        this.f995b = obj;
        c.b.a.t.h.e(hVar, "Signature must not be null");
        this.g = hVar;
        this.f996c = i2;
        this.f997d = i3;
        c.b.a.t.h.d(map);
        this.h = map;
        c.b.a.t.h.e(cls, "Resource class must not be null");
        this.f998e = cls;
        c.b.a.t.h.e(cls2, "Transcode class must not be null");
        this.f999f = cls2;
        c.b.a.t.h.d(jVar);
        this.i = jVar;
    }

    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f995b.equals(mVar.f995b) && this.g.equals(mVar.g) && this.f997d == mVar.f997d && this.f996c == mVar.f996c && this.h.equals(mVar.h) && this.f998e.equals(mVar.f998e) && this.f999f.equals(mVar.f999f) && this.i.equals(mVar.i);
    }

    public int hashCode() {
        if (this.j == 0) {
            int hashCode = this.f995b.hashCode();
            this.j = hashCode;
            int hashCode2 = (hashCode * 31) + this.g.hashCode();
            this.j = hashCode2;
            int i2 = (hashCode2 * 31) + this.f996c;
            this.j = i2;
            int i3 = (i2 * 31) + this.f997d;
            this.j = i3;
            int hashCode3 = (i3 * 31) + this.h.hashCode();
            this.j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f998e.hashCode();
            this.j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f999f.hashCode();
            this.j = hashCode5;
            this.j = (hashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f995b + ", width=" + this.f996c + ", height=" + this.f997d + ", resourceClass=" + this.f998e + ", transcodeClass=" + this.f999f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }
}
