package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;
import java.util.List;

final class h6 {
    private long A;
    private String B;
    private boolean C;
    private long D;
    private long E;

    /* renamed from: a  reason: collision with root package name */
    private final x4 f2397a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2398b;

    /* renamed from: c  reason: collision with root package name */
    private String f2399c;

    /* renamed from: d  reason: collision with root package name */
    private String f2400d;

    /* renamed from: e  reason: collision with root package name */
    private String f2401e;

    /* renamed from: f  reason: collision with root package name */
    private String f2402f;
    private long g;
    private long h;
    private long i;
    private String j;
    private long k;
    private String l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;
    private String q;
    private Boolean r;
    private long s;
    private List t;
    private String u;
    private long v;
    private long w;
    private long x;
    private long y;
    private long z;

    h6(x4 x4Var, String str) {
        n.i(x4Var);
        n.e(str);
        this.f2397a = x4Var;
        this.f2398b = str;
        x4Var.c().h();
    }

    public final long A() {
        this.f2397a.c().h();
        return 0;
    }

    public final void B(long j2) {
        boolean z2 = true;
        n.a(j2 >= 0);
        this.f2397a.c().h();
        boolean z3 = this.C;
        if (this.g == j2) {
            z2 = false;
        }
        this.C = z2 | z3;
        this.g = j2;
    }

    public final void C(long j2) {
        this.f2397a.c().h();
        this.C |= this.h != j2;
        this.h = j2;
    }

    public final void D(boolean z2) {
        this.f2397a.c().h();
        this.C |= this.o != z2;
        this.o = z2;
    }

    public final void E(Boolean bool) {
        this.f2397a.c().h();
        this.C |= !g5.a(this.r, bool);
        this.r = bool;
    }

    public final void F(String str) {
        this.f2397a.c().h();
        this.C |= !g5.a(this.f2401e, str);
        this.f2401e = str;
    }

    public final void G(List list) {
        this.f2397a.c().h();
        if (!g5.a(this.t, list)) {
            this.C = true;
            this.t = list != null ? new ArrayList(list) : null;
        }
    }

    public final void H(String str) {
        this.f2397a.c().h();
        this.C |= !g5.a(this.u, str);
        this.u = str;
    }

    public final boolean I() {
        this.f2397a.c().h();
        return this.p;
    }

    public final boolean J() {
        this.f2397a.c().h();
        return this.o;
    }

    public final boolean K() {
        this.f2397a.c().h();
        return this.C;
    }

    public final long L() {
        this.f2397a.c().h();
        return this.k;
    }

    public final long M() {
        this.f2397a.c().h();
        return this.D;
    }

    public final long N() {
        this.f2397a.c().h();
        return this.y;
    }

    public final long O() {
        this.f2397a.c().h();
        return this.z;
    }

    public final long P() {
        this.f2397a.c().h();
        return this.x;
    }

    public final long Q() {
        this.f2397a.c().h();
        return this.w;
    }

    public final long R() {
        this.f2397a.c().h();
        return this.A;
    }

    public final long S() {
        this.f2397a.c().h();
        return this.v;
    }

    public final long T() {
        this.f2397a.c().h();
        return this.n;
    }

    public final long U() {
        this.f2397a.c().h();
        return this.s;
    }

    public final long V() {
        this.f2397a.c().h();
        return this.E;
    }

    public final long W() {
        this.f2397a.c().h();
        return this.m;
    }

    public final long X() {
        this.f2397a.c().h();
        return this.i;
    }

    public final long Y() {
        this.f2397a.c().h();
        return this.g;
    }

    public final long Z() {
        this.f2397a.c().h();
        return this.h;
    }

    public final String a() {
        this.f2397a.c().h();
        return this.f2401e;
    }

    public final Boolean a0() {
        this.f2397a.c().h();
        return this.r;
    }

    public final String b() {
        this.f2397a.c().h();
        return this.u;
    }

    public final String b0() {
        this.f2397a.c().h();
        return this.q;
    }

    public final List c() {
        this.f2397a.c().h();
        return this.t;
    }

    public final String c0() {
        this.f2397a.c().h();
        String str = this.B;
        y((String) null);
        return str;
    }

    public final void d() {
        this.f2397a.c().h();
        this.C = false;
    }

    public final String d0() {
        this.f2397a.c().h();
        return this.f2398b;
    }

    public final void e() {
        this.f2397a.c().h();
        long j2 = this.g + 1;
        if (j2 > 2147483647L) {
            this.f2397a.f().w().b("Bundle index overflow. appId", m3.z(this.f2398b));
            j2 = 0;
        }
        this.C = true;
        this.g = j2;
    }

    public final String e0() {
        this.f2397a.c().h();
        return this.f2399c;
    }

    public final void f(String str) {
        this.f2397a.c().h();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.C |= true ^ g5.a(this.q, str);
        this.q = str;
    }

    public final String f0() {
        this.f2397a.c().h();
        return this.l;
    }

    public final void g(boolean z2) {
        this.f2397a.c().h();
        this.C |= this.p != z2;
        this.p = z2;
    }

    public final String g0() {
        this.f2397a.c().h();
        return this.j;
    }

    public final void h(String str) {
        this.f2397a.c().h();
        this.C |= !g5.a(this.f2399c, str);
        this.f2399c = str;
    }

    public final String h0() {
        this.f2397a.c().h();
        return this.f2402f;
    }

    public final void i(String str) {
        this.f2397a.c().h();
        this.C |= !g5.a(this.l, str);
        this.l = str;
    }

    public final String i0() {
        this.f2397a.c().h();
        return this.f2400d;
    }

    public final void j(String str) {
        this.f2397a.c().h();
        this.C |= !g5.a(this.j, str);
        this.j = str;
    }

    public final String j0() {
        this.f2397a.c().h();
        return this.B;
    }

    public final void k(long j2) {
        this.f2397a.c().h();
        this.C |= this.k != j2;
        this.k = j2;
    }

    public final void l(long j2) {
        this.f2397a.c().h();
        this.C |= this.D != j2;
        this.D = j2;
    }

    public final void m(long j2) {
        this.f2397a.c().h();
        this.C |= this.y != j2;
        this.y = j2;
    }

    public final void n(long j2) {
        this.f2397a.c().h();
        this.C |= this.z != j2;
        this.z = j2;
    }

    public final void o(long j2) {
        this.f2397a.c().h();
        this.C |= this.x != j2;
        this.x = j2;
    }

    public final void p(long j2) {
        this.f2397a.c().h();
        this.C |= this.w != j2;
        this.w = j2;
    }

    public final void q(long j2) {
        this.f2397a.c().h();
        this.C |= this.A != j2;
        this.A = j2;
    }

    public final void r(long j2) {
        this.f2397a.c().h();
        this.C |= this.v != j2;
        this.v = j2;
    }

    public final void s(long j2) {
        this.f2397a.c().h();
        this.C |= this.n != j2;
        this.n = j2;
    }

    public final void t(long j2) {
        this.f2397a.c().h();
        this.C |= this.s != j2;
        this.s = j2;
    }

    public final void u(long j2) {
        this.f2397a.c().h();
        this.C |= this.E != j2;
        this.E = j2;
    }

    public final void v(String str) {
        this.f2397a.c().h();
        this.C |= !g5.a(this.f2402f, str);
        this.f2402f = str;
    }

    public final void w(String str) {
        this.f2397a.c().h();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.C |= true ^ g5.a(this.f2400d, str);
        this.f2400d = str;
    }

    public final void x(long j2) {
        this.f2397a.c().h();
        this.C |= this.m != j2;
        this.m = j2;
    }

    public final void y(String str) {
        this.f2397a.c().h();
        this.C |= !g5.a(this.B, str);
        this.B = str;
    }

    public final void z(long j2) {
        this.f2397a.c().h();
        this.C |= this.i != j2;
        this.i = j2;
    }
}
