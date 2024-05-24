package c.d.a.a.i.x.a;

import c.d.a.a.i.m;
import com.google.firebase.l.j.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final f f1481a;

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f1482b;

    /* renamed from: c  reason: collision with root package name */
    private final b f1483c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1484d;

    /* renamed from: c.d.a.a.i.x.a.a$a  reason: collision with other inner class name */
    public static final class C0062a {

        /* renamed from: a  reason: collision with root package name */
        private f f1485a = null;

        /* renamed from: b  reason: collision with root package name */
        private List<d> f1486b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private b f1487c = null;

        /* renamed from: d  reason: collision with root package name */
        private String f1488d = "";

        C0062a() {
        }

        public C0062a a(d dVar) {
            this.f1486b.add(dVar);
            return this;
        }

        public a b() {
            return new a(this.f1485a, Collections.unmodifiableList(this.f1486b), this.f1487c, this.f1488d);
        }

        public C0062a c(String str) {
            this.f1488d = str;
            return this;
        }

        public C0062a d(b bVar) {
            this.f1487c = bVar;
            return this;
        }

        public C0062a e(f fVar) {
            this.f1485a = fVar;
            return this;
        }
    }

    static {
        new C0062a().b();
    }

    a(f fVar, List<d> list, b bVar, String str) {
        this.f1481a = fVar;
        this.f1482b = list;
        this.f1483c = bVar;
        this.f1484d = str;
    }

    public static C0062a e() {
        return new C0062a();
    }

    @f(tag = 4)
    public String a() {
        return this.f1484d;
    }

    @f(tag = 3)
    public b b() {
        return this.f1483c;
    }

    @f(tag = 2)
    public List<d> c() {
        return this.f1482b;
    }

    @f(tag = 1)
    public f d() {
        return this.f1481a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
