package f.a.a.c;

import f.a.a.d.c;
import java.io.Serializable;

public class a implements Serializable {
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private c o;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private a f3087a = new a();

        public a a() {
            return this.f3087a;
        }

        public b b(boolean z) {
            this.f3087a.a(z);
            return this;
        }

        public b c(int i) {
            this.f3087a.i(i);
            return this;
        }

        public b d(int i) {
            this.f3087a.j(i);
            return this;
        }
    }

    private a() {
        this.j = 1200;
        this.k = 102400;
        this.l = true;
        this.m = true;
        this.n = true;
    }

    public static a h() {
        return new a();
    }

    public void a(boolean z) {
        this.n = z;
    }

    public c b() {
        return this.o;
    }

    public int c() {
        return this.j;
    }

    public int d() {
        return this.k;
    }

    public boolean e() {
        return this.l;
    }

    public boolean f() {
        return this.m;
    }

    public boolean g() {
        return this.n;
    }

    public a i(int i) {
        this.j = i;
        return this;
    }

    public void j(int i) {
        this.k = i;
    }
}
