package c.b.a.t.j;

public abstract class b {

    /* renamed from: c.b.a.t.j.b$b  reason: collision with other inner class name */
    private static class C0059b extends b {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f1290a;

        C0059b() {
            super();
        }

        public void b(boolean z) {
            this.f1290a = z;
        }

        public void c() {
            if (this.f1290a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private b() {
    }

    public static b a() {
        return new C0059b();
    }

    /* access modifiers changed from: package-private */
    public abstract void b(boolean z);

    public abstract void c();
}
