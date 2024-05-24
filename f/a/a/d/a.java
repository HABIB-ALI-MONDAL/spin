package f.a.a.d;

import java.io.Serializable;

public class a implements Serializable {
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private a f3101a = new a();

        public a a() {
            return this.f3101a;
        }

        public b b(int i) {
            this.f3101a.f(i);
            return this;
        }

        public b c(int i) {
            this.f3101a.g(i);
            return this;
        }

        public b d(boolean z) {
            this.f3101a.h(z);
            return this;
        }
    }

    private a() {
    }

    public int a() {
        return this.k;
    }

    public int b() {
        return this.l;
    }

    public int c() {
        return this.m;
    }

    public int d() {
        return this.n;
    }

    public boolean e() {
        return this.j;
    }

    public void f(int i) {
        this.k = i;
    }

    public void g(int i) {
        this.l = i;
    }

    public void h(boolean z) {
        this.j = z;
    }
}
