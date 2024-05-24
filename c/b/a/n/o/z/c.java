package c.b.a.n.o.z;

import android.graphics.Bitmap;
import c.b.a.t.i;

class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final b f1012a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final h<a, Bitmap> f1013b = new h<>();

    static class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f1014a;

        /* renamed from: b  reason: collision with root package name */
        private int f1015b;

        /* renamed from: c  reason: collision with root package name */
        private int f1016c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.Config f1017d;

        public a(b bVar) {
            this.f1014a = bVar;
        }

        public void a() {
            this.f1014a.c(this);
        }

        public void b(int i, int i2, Bitmap.Config config) {
            this.f1015b = i;
            this.f1016c = i2;
            this.f1017d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1015b == aVar.f1015b && this.f1016c == aVar.f1016c && this.f1017d == aVar.f1017d;
        }

        public int hashCode() {
            int i = ((this.f1015b * 31) + this.f1016c) * 31;
            Bitmap.Config config = this.f1017d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.g(this.f1015b, this.f1016c, this.f1017d);
        }
    }

    static class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        /* access modifiers changed from: package-private */
        public a e(int i, int i2, Bitmap.Config config) {
            a aVar = (a) b();
            aVar.b(i, i2, config);
            return aVar;
        }
    }

    c() {
    }

    static String g(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    private static String h(Bitmap bitmap) {
        return g(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public int a(Bitmap bitmap) {
        return i.g(bitmap);
    }

    public Bitmap b() {
        return this.f1013b.f();
    }

    public Bitmap c(int i, int i2, Bitmap.Config config) {
        return this.f1013b.a(this.f1012a.e(i, i2, config));
    }

    public void d(Bitmap bitmap) {
        this.f1013b.d(this.f1012a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public String e(int i, int i2, Bitmap.Config config) {
        return g(i, i2, config);
    }

    public String f(Bitmap bitmap) {
        return h(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f1013b;
    }
}
