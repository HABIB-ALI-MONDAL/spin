package c.b.a.r;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c.b.a.g;
import c.b.a.n.h;
import c.b.a.n.j;
import c.b.a.n.m;
import c.b.a.n.o.i;
import c.b.a.n.q.c.k;
import c.b.a.n.q.c.n;
import c.b.a.n.q.g.c;
import c.b.a.n.q.g.f;
import c.b.a.s.a;
import java.util.HashMap;
import java.util.Map;

public class e implements Cloneable {
    private Map<Class<?>, m<?>> A = new HashMap();
    private Class<?> B = Object.class;
    private boolean C;
    private Resources.Theme D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H = true;
    private boolean I;
    private int j;
    private float k = 1.0f;
    private i l = i.f973c;
    private g m = g.NORMAL;
    private Drawable n;
    private int o;
    private Drawable p;
    private int q;
    private boolean r = true;
    private int s = -1;
    private int t = -1;
    private h u = a.c();
    private boolean v;
    private boolean w = true;
    private Drawable x;
    private int y;
    private j z = new j();

    private boolean I(int i) {
        return J(this.j, i);
    }

    private static boolean J(int i, int i2) {
        return (i & i2) != 0;
    }

    private e S(c.b.a.n.q.c.j jVar, m<Bitmap> mVar) {
        return X(jVar, mVar, false);
    }

    private e X(c.b.a.n.q.c.j jVar, m<Bitmap> mVar, boolean z2) {
        e g0 = z2 ? g0(jVar, mVar) : T(jVar, mVar);
        g0.H = true;
        return g0;
    }

    private e Y() {
        if (!this.C) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
    }

    public static e b0(h hVar) {
        return new e().a0(hVar);
    }

    private e f0(m<Bitmap> mVar, boolean z2) {
        if (this.E) {
            return clone().f0(mVar, z2);
        }
        c.b.a.n.q.c.m mVar2 = new c.b.a.n.q.c.m(mVar, z2);
        h0(Bitmap.class, mVar, z2);
        h0(Drawable.class, mVar2, z2);
        mVar2.c();
        h0(BitmapDrawable.class, mVar2, z2);
        h0(c.class, new f(mVar), z2);
        Y();
        return this;
    }

    private <T> e h0(Class<T> cls, m<T> mVar, boolean z2) {
        if (this.E) {
            return clone().h0(cls, mVar, z2);
        }
        c.b.a.t.h.d(cls);
        c.b.a.t.h.d(mVar);
        this.A.put(cls, mVar);
        int i = this.j | 2048;
        this.j = i;
        this.w = true;
        int i2 = i | 65536;
        this.j = i2;
        this.H = false;
        if (z2) {
            this.j = i2 | 131072;
            this.v = true;
        }
        Y();
        return this;
    }

    public static e i(Class<?> cls) {
        return new e().g(cls);
    }

    public static e k(i iVar) {
        return new e().j(iVar);
    }

    public final float A() {
        return this.k;
    }

    public final Resources.Theme B() {
        return this.D;
    }

    public final Map<Class<?>, m<?>> C() {
        return this.A;
    }

    public final boolean D() {
        return this.I;
    }

    public final boolean E() {
        return this.F;
    }

    public final boolean F() {
        return this.r;
    }

    public final boolean G() {
        return I(8);
    }

    /* access modifiers changed from: package-private */
    public boolean H() {
        return this.H;
    }

    public final boolean K() {
        return this.w;
    }

    public final boolean L() {
        return this.v;
    }

    public final boolean M() {
        return I(2048);
    }

    public final boolean N() {
        return c.b.a.t.i.r(this.t, this.s);
    }

    public e O() {
        this.C = true;
        return this;
    }

    public e P() {
        return T(c.b.a.n.q.c.j.f1141b, new c.b.a.n.q.c.g());
    }

    public e Q() {
        return S(c.b.a.n.q.c.j.f1142c, new c.b.a.n.q.c.h());
    }

    public e R() {
        return S(c.b.a.n.q.c.j.f1140a, new n());
    }

    /* access modifiers changed from: package-private */
    public final e T(c.b.a.n.q.c.j jVar, m<Bitmap> mVar) {
        if (this.E) {
            return clone().T(jVar, mVar);
        }
        l(jVar);
        return f0(mVar, false);
    }

    public e U(int i, int i2) {
        if (this.E) {
            return clone().U(i, i2);
        }
        this.t = i;
        this.s = i2;
        this.j |= 512;
        Y();
        return this;
    }

    public e V(int i) {
        if (this.E) {
            return clone().V(i);
        }
        this.q = i;
        this.j |= 128;
        Y();
        return this;
    }

    public e W(g gVar) {
        if (this.E) {
            return clone().W(gVar);
        }
        c.b.a.t.h.d(gVar);
        this.m = gVar;
        this.j |= 8;
        Y();
        return this;
    }

    public <T> e Z(c.b.a.n.i<T> iVar, T t2) {
        if (this.E) {
            return clone().Z(iVar, t2);
        }
        c.b.a.t.h.d(iVar);
        c.b.a.t.h.d(t2);
        this.z.e(iVar, t2);
        Y();
        return this;
    }

    public e a(e eVar) {
        if (this.E) {
            return clone().a(eVar);
        }
        if (J(eVar.j, 2)) {
            this.k = eVar.k;
        }
        if (J(eVar.j, 262144)) {
            this.F = eVar.F;
        }
        if (J(eVar.j, 1048576)) {
            this.I = eVar.I;
        }
        if (J(eVar.j, 4)) {
            this.l = eVar.l;
        }
        if (J(eVar.j, 8)) {
            this.m = eVar.m;
        }
        if (J(eVar.j, 16)) {
            this.n = eVar.n;
        }
        if (J(eVar.j, 32)) {
            this.o = eVar.o;
        }
        if (J(eVar.j, 64)) {
            this.p = eVar.p;
        }
        if (J(eVar.j, 128)) {
            this.q = eVar.q;
        }
        if (J(eVar.j, 256)) {
            this.r = eVar.r;
        }
        if (J(eVar.j, 512)) {
            this.t = eVar.t;
            this.s = eVar.s;
        }
        if (J(eVar.j, 1024)) {
            this.u = eVar.u;
        }
        if (J(eVar.j, 4096)) {
            this.B = eVar.B;
        }
        if (J(eVar.j, 8192)) {
            this.x = eVar.x;
        }
        if (J(eVar.j, 16384)) {
            this.y = eVar.y;
        }
        if (J(eVar.j, 32768)) {
            this.D = eVar.D;
        }
        if (J(eVar.j, 65536)) {
            this.w = eVar.w;
        }
        if (J(eVar.j, 131072)) {
            this.v = eVar.v;
        }
        if (J(eVar.j, 2048)) {
            this.A.putAll(eVar.A);
            this.H = eVar.H;
        }
        if (J(eVar.j, 524288)) {
            this.G = eVar.G;
        }
        if (!this.w) {
            this.A.clear();
            int i = this.j & -2049;
            this.j = i;
            this.v = false;
            this.j = i & -131073;
            this.H = true;
        }
        this.j |= eVar.j;
        this.z.d(eVar.z);
        Y();
        return this;
    }

    public e a0(h hVar) {
        if (this.E) {
            return clone().a0(hVar);
        }
        c.b.a.t.h.d(hVar);
        this.u = hVar;
        this.j |= 1024;
        Y();
        return this;
    }

    public e b() {
        if (!this.C || this.E) {
            this.E = true;
            O();
            return this;
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public e c0(float f2) {
        if (this.E) {
            return clone().c0(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.k = f2;
        this.j |= 2;
        Y();
        return this;
    }

    public e d() {
        return g0(c.b.a.n.q.c.j.f1141b, new c.b.a.n.q.c.g());
    }

    public e d0(boolean z2) {
        if (this.E) {
            return clone().d0(true);
        }
        this.r = !z2;
        this.j |= 256;
        Y();
        return this;
    }

    /* renamed from: e */
    public e clone() {
        try {
            e eVar = (e) super.clone();
            j jVar = new j();
            eVar.z = jVar;
            jVar.d(this.z);
            HashMap hashMap = new HashMap();
            eVar.A = hashMap;
            hashMap.putAll(this.A);
            eVar.C = false;
            eVar.E = false;
            return eVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public e e0(m<Bitmap> mVar) {
        return f0(mVar, true);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Float.compare(eVar.k, this.k) == 0 && this.o == eVar.o && c.b.a.t.i.c(this.n, eVar.n) && this.q == eVar.q && c.b.a.t.i.c(this.p, eVar.p) && this.y == eVar.y && c.b.a.t.i.c(this.x, eVar.x) && this.r == eVar.r && this.s == eVar.s && this.t == eVar.t && this.v == eVar.v && this.w == eVar.w && this.F == eVar.F && this.G == eVar.G && this.l.equals(eVar.l) && this.m == eVar.m && this.z.equals(eVar.z) && this.A.equals(eVar.A) && this.B.equals(eVar.B) && c.b.a.t.i.c(this.u, eVar.u) && c.b.a.t.i.c(this.D, eVar.D);
    }

    public e g(Class<?> cls) {
        if (this.E) {
            return clone().g(cls);
        }
        c.b.a.t.h.d(cls);
        this.B = cls;
        this.j |= 4096;
        Y();
        return this;
    }

    /* access modifiers changed from: package-private */
    public final e g0(c.b.a.n.q.c.j jVar, m<Bitmap> mVar) {
        if (this.E) {
            return clone().g0(jVar, mVar);
        }
        l(jVar);
        return e0(mVar);
    }

    public int hashCode() {
        return c.b.a.t.i.m(this.D, c.b.a.t.i.m(this.u, c.b.a.t.i.m(this.B, c.b.a.t.i.m(this.A, c.b.a.t.i.m(this.z, c.b.a.t.i.m(this.m, c.b.a.t.i.m(this.l, c.b.a.t.i.n(this.G, c.b.a.t.i.n(this.F, c.b.a.t.i.n(this.w, c.b.a.t.i.n(this.v, c.b.a.t.i.l(this.t, c.b.a.t.i.l(this.s, c.b.a.t.i.n(this.r, c.b.a.t.i.m(this.x, c.b.a.t.i.l(this.y, c.b.a.t.i.m(this.p, c.b.a.t.i.l(this.q, c.b.a.t.i.m(this.n, c.b.a.t.i.l(this.o, c.b.a.t.i.j(this.k)))))))))))))))))))));
    }

    public e i0(boolean z2) {
        if (this.E) {
            return clone().i0(z2);
        }
        this.I = z2;
        this.j |= 1048576;
        Y();
        return this;
    }

    public e j(i iVar) {
        if (this.E) {
            return clone().j(iVar);
        }
        c.b.a.t.h.d(iVar);
        this.l = iVar;
        this.j |= 4;
        Y();
        return this;
    }

    public e l(c.b.a.n.q.c.j jVar) {
        c.b.a.n.i<c.b.a.n.q.c.j> iVar = k.g;
        c.b.a.t.h.d(jVar);
        return Z(iVar, jVar);
    }

    public final i m() {
        return this.l;
    }

    public final int n() {
        return this.o;
    }

    public final Drawable o() {
        return this.n;
    }

    public final Drawable p() {
        return this.x;
    }

    public final int q() {
        return this.y;
    }

    public final boolean r() {
        return this.G;
    }

    public final j s() {
        return this.z;
    }

    public final int t() {
        return this.s;
    }

    public final int u() {
        return this.t;
    }

    public final Drawable v() {
        return this.p;
    }

    public final int w() {
        return this.q;
    }

    public final g x() {
        return this.m;
    }

    public final Class<?> y() {
        return this.B;
    }

    public final h z() {
        return this.u;
    }
}
