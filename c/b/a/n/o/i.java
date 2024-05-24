package c.b.a.n.o;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f971a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final i f972b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final i f973c = new c();

    class a extends i {
        a() {
        }

        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean c(c.b.a.n.a aVar) {
            return false;
        }

        public boolean d(boolean z, c.b.a.n.a aVar, c.b.a.n.c cVar) {
            return false;
        }
    }

    class b extends i {
        b() {
        }

        public boolean a() {
            return true;
        }

        public boolean b() {
            return false;
        }

        public boolean c(c.b.a.n.a aVar) {
            return (aVar == c.b.a.n.a.DATA_DISK_CACHE || aVar == c.b.a.n.a.MEMORY_CACHE) ? false : true;
        }

        public boolean d(boolean z, c.b.a.n.a aVar, c.b.a.n.c cVar) {
            return false;
        }
    }

    class c extends i {
        c() {
        }

        public boolean a() {
            return true;
        }

        public boolean b() {
            return true;
        }

        public boolean c(c.b.a.n.a aVar) {
            return aVar == c.b.a.n.a.REMOTE;
        }

        public boolean d(boolean z, c.b.a.n.a aVar, c.b.a.n.c cVar) {
            return ((z && aVar == c.b.a.n.a.DATA_DISK_CACHE) || aVar == c.b.a.n.a.LOCAL) && cVar == c.b.a.n.c.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(c.b.a.n.a aVar);

    public abstract boolean d(boolean z, c.b.a.n.a aVar, c.b.a.n.c cVar);
}
