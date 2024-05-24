package c.d.a.a.i.x.a;

import com.google.firebase.l.j.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f1495a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f1496b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f1497a = "";

        /* renamed from: b  reason: collision with root package name */
        private List<c> f1498b = new ArrayList();

        a() {
        }

        public d a() {
            return new d(this.f1497a, Collections.unmodifiableList(this.f1498b));
        }

        public a b(List<c> list) {
            this.f1498b = list;
            return this;
        }

        public a c(String str) {
            this.f1497a = str;
            return this;
        }
    }

    static {
        new a().a();
    }

    d(String str, List<c> list) {
        this.f1495a = str;
        this.f1496b = list;
    }

    public static a c() {
        return new a();
    }

    @f(tag = 2)
    public List<c> a() {
        return this.f1496b;
    }

    @f(tag = 1)
    public String b() {
        return this.f1495a;
    }
}
