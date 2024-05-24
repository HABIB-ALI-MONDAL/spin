package c.b.a.t;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f1280a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f1281b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f1282c;

    public g() {
    }

    public g(Class<?> cls, Class<?> cls2) {
        a(cls, cls2);
    }

    public g(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        b(cls, cls2, cls3);
    }

    public void a(Class<?> cls, Class<?> cls2) {
        b(cls, cls2, (Class<?>) null);
    }

    public void b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f1280a = cls;
        this.f1281b = cls2;
        this.f1282c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f1280a.equals(gVar.f1280a) && this.f1281b.equals(gVar.f1281b) && i.c(this.f1282c, gVar.f1282c);
    }

    public int hashCode() {
        int hashCode = ((this.f1280a.hashCode() * 31) + this.f1281b.hashCode()) * 31;
        Class<?> cls = this.f1282c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f1280a + ", second=" + this.f1281b + '}';
    }
}
