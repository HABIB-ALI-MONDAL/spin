package f.a.a.d;

import java.io.Serializable;

public class k implements Serializable {
    private boolean j;
    private boolean k;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private k f3115a = new k();

        public k a() {
            return this.f3115a;
        }

        public b b(boolean z) {
            this.f3115a.c(z);
            return this;
        }
    }

    private k() {
    }

    public boolean a() {
        return this.k;
    }

    public boolean b() {
        return this.j;
    }

    public void c(boolean z) {
        this.k = z;
    }
}
