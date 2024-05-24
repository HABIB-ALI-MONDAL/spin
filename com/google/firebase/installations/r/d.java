package com.google.firebase.installations.r;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.r.a;
import com.google.firebase.installations.r.c;

@AutoValue
public abstract class d {

    @AutoValue.Builder
    public static abstract class a {
        public abstract d a();

        public abstract a b(String str);

        public abstract a c(long j);

        public abstract a d(String str);

        public abstract a e(String str);

        public abstract a f(String str);

        public abstract a g(c.a aVar);

        public abstract a h(long j);
    }

    static {
        a().a();
    }

    public static a a() {
        a.b bVar = new a.b();
        bVar.h(0);
        bVar.g(c.a.ATTEMPT_MIGRATION);
        bVar.c(0);
        return bVar;
    }

    public abstract String b();

    public abstract long c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract c.a g();

    public abstract long h();

    public boolean i() {
        return g() == c.a.REGISTER_ERROR;
    }

    public boolean j() {
        return g() == c.a.NOT_GENERATED || g() == c.a.ATTEMPT_MIGRATION;
    }

    public boolean k() {
        return g() == c.a.REGISTERED;
    }

    public boolean l() {
        return g() == c.a.UNREGISTERED;
    }

    public boolean m() {
        return g() == c.a.ATTEMPT_MIGRATION;
    }

    public abstract a n();

    public d o(String str, long j, long j2) {
        a n = n();
        n.b(str);
        n.c(j);
        n.h(j2);
        return n.a();
    }

    public d p() {
        a n = n();
        n.b((String) null);
        return n.a();
    }

    public d q(String str) {
        a n = n();
        n.e(str);
        n.g(c.a.REGISTER_ERROR);
        return n.a();
    }

    public d r() {
        a n = n();
        n.g(c.a.NOT_GENERATED);
        return n.a();
    }

    public d s(String str, String str2, long j, String str3, long j2) {
        a n = n();
        n.d(str);
        n.g(c.a.REGISTERED);
        n.b(str3);
        n.f(str2);
        n.c(j2);
        n.h(j);
        return n.a();
    }

    public d t(String str) {
        a n = n();
        n.d(str);
        n.g(c.a.UNREGISTERED);
        return n.a();
    }
}
