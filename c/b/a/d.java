package c.b.a;

import android.content.Context;
import b.c.a;
import c.b.a.n.o.a0.a;
import c.b.a.n.o.a0.g;
import c.b.a.n.o.a0.h;
import c.b.a.n.o.a0.i;
import c.b.a.n.o.j;
import c.b.a.n.o.z.b;
import c.b.a.n.o.z.e;
import c.b.a.n.o.z.k;
import c.b.a.o.f;
import c.b.a.o.l;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f811a = new a();

    /* renamed from: b  reason: collision with root package name */
    private j f812b;

    /* renamed from: c  reason: collision with root package name */
    private e f813c;

    /* renamed from: d  reason: collision with root package name */
    private b f814d;

    /* renamed from: e  reason: collision with root package name */
    private h f815e;

    /* renamed from: f  reason: collision with root package name */
    private c.b.a.n.o.b0.a f816f;
    private c.b.a.n.o.b0.a g;
    private a.C0041a h;
    private i i;
    private c.b.a.o.d j;
    private int k = 4;
    private c.b.a.r.e l = new c.b.a.r.e();
    private l.b m;
    private c.b.a.n.o.b0.a n;
    private boolean o;

    public c a(Context context) {
        if (this.f816f == null) {
            this.f816f = c.b.a.n.o.b0.a.f();
        }
        if (this.g == null) {
            this.g = c.b.a.n.o.b0.a.d();
        }
        if (this.n == null) {
            this.n = c.b.a.n.o.b0.a.b();
        }
        if (this.i == null) {
            this.i = new i.a(context).a();
        }
        if (this.j == null) {
            this.j = new f();
        }
        if (this.f813c == null) {
            int b2 = this.i.b();
            if (b2 > 0) {
                this.f813c = new k((long) b2);
            } else {
                this.f813c = new c.b.a.n.o.z.f();
            }
        }
        if (this.f814d == null) {
            this.f814d = new c.b.a.n.o.z.j(this.i.a());
        }
        if (this.f815e == null) {
            this.f815e = new g((long) this.i.d());
        }
        if (this.h == null) {
            this.h = new c.b.a.n.o.a0.f(context);
        }
        if (this.f812b == null) {
            this.f812b = new j(this.f815e, this.h, this.g, this.f816f, c.b.a.n.o.b0.a.h(), c.b.a.n.o.b0.a.b(), this.o);
        }
        l lVar = new l(this.m);
        j jVar = this.f812b;
        h hVar = this.f815e;
        e eVar = this.f813c;
        b bVar = this.f814d;
        c.b.a.o.d dVar = this.j;
        int i2 = this.k;
        c.b.a.r.e eVar2 = this.l;
        eVar2.O();
        return new c(context, jVar, hVar, eVar, bVar, lVar, dVar, i2, eVar2, this.f811a);
    }

    /* access modifiers changed from: package-private */
    public void b(l.b bVar) {
        this.m = bVar;
    }
}
